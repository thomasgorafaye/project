/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import model.Backup;
import model.Host;
import model.Plan;

/**
 *
 * @author thomas
 */
public class Mail {
    private final static String MAILER_VERSION = "Java";
    
    private Host host;
    private Plan plan;
    private Backup backup;
    
    public Mail(Host host, Backup backup, Plan plan){
        this.backup = backup;
        this.host = host;
        this.plan = plan;
    }
    
    public boolean envoyerMailSMTP(String email){
        boolean result = false;
        final String username = "fayethomasgora@gmail.com";
		final String password = "thomas1994lion";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("thomasgorafaye@hotmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject(formHeader());
			message.setText(formBody());
                        
                        BodyPart messageBodyPart = new MimeBodyPart();
                        messageBodyPart.setText(formBody());
                        Multipart multipart = new MimeMultipart();
                        multipart.addBodyPart(messageBodyPart);
                        messageBodyPart =  new MimeBodyPart();
                        DataSource source = new FileDataSource(backup.getLog());
                        messageBodyPart.setDataHandler(new DataHandler(source));
                        messageBodyPart.setFileName(backup.getLog());
                        multipart.addBodyPart(messageBodyPart);
                        
                        message.setContent(multipart);

			Transport.send(message);

			System.out.println("Email sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
            return result;
    }  
    
    private String formBody(){
        String text = "Bonjour "+host.getOwnername()+",\n\n"+
                      "Une sauvegarde automatisée a été effectuée sur la base de données "+host.getSid()+" par votre appliclication BackApp suite au déclenchement de la planificifation "+plan.getId()+".\n"+
                      "Les détails de la sauvegarde:\n"+
                        "Date : "+backup.getDate()+"\n"+
                        "Heure : "+backup.getTime()+"\n"+
                        "Identifiant : "+backup.getTimestamp()+"\n"+
                        "Type : "+backup.getType()+"\n"+
                        "Méthode : "+backup.getMethod()+"\n"+
                        "Object : "+backup.getObject()+"\n"+
                        "Nom : "+backup.getName()+"\n"+
                        "Répertoire destination : "+backup.getD_repertory()+"\n"+
                        "Log : "+backup.getLog()+"\n\n"+
                        "Vous trouverez en joint le fichier log de la sauvegarde.\n\n"+
                        "Bien cordialement.";
        return text;
                
    }
    
    private String formHeader(){
        String text = "Sauvegarde "+backup.getTimestamp()+" sur la base de données "+host.getSid();
        return text;
    }
    
} 
