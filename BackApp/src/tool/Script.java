/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import static com.sun.deploy.cache.Cache.copyStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.Map;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Backup;
import model.Host;


/**
 *
 * @author thomas
 */
public class Script {
    
    final String CHEMIN = "C:\\Users\\thomas\\Documents\\NetBeansProjects\\project\\BackApp\\src\\file";
    private final ArrayList<String> rmanParam;

    public Script() {
        this.rmanParam = new ArrayList();
    }
    
    public void run(Host h, Backup b){
        
        String script;
        String method = b.getMethod().toLowerCase();
        String type = b.getType().toLowerCase();
        String strategy = b.getStrategy().toLowerCase();
        if(type.contains("froid"))
            type = "froid";
        else
            type = "chaud";
        
        if(strategy.contains("ve niveau 0"))
            strategy = "incremental level 0 cumulative";
        else if(strategy.contains("ve niveau 1"))
            strategy = "incremental level 1 cumulative";
        else if(strategy.contains("ve niveau 2"))
            strategy = "incremental level 2 cumulative";
        else if(strategy.contains("le niveau 0"))
            strategy = "incremental level 0";
        else if(strategy.contains("le niveau 1"))
            strategy = "incremental level 1";
        else if(strategy.contains("le niveau 2"))
            strategy = "incremental level 2";
        else
            strategy = "";
        
        if(method.contains("xcopy")){
            script = "connect.bat";
        }     
        else if(method.contains("rman")){
            String d_repertory = b.getD_repertory().replace("\\","\\\\");
            rmanParam.add("%d_repertory%");
            rmanParam.add(d_repertory);
            rmanParam.add("%strategy%");
            rmanParam.add(strategy);
            rmanParam.add("%object%");
            rmanParam.add(b.getObject());
            rmanParam.add("%name%");
            rmanParam.add(b.getName());
            try {
                createRmanScript("\\database.bat","\\temp.bat");
            } catch (IOException ex) {
                Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
            }
                script = "rman_backup.bat";       
        }else if(method.contains("export"))
            script = "export.bat";
        else
            script = "nothing";
        
        /*switch (b.getMethod()){
            case "xcopy" :
                    script = "xcopy.bat"; 
            case "export" :
                    script = "export.bat";
            case "rman" :
                    script = "rman.bat";
            case "coldBackup" :
                    script = "cold.bat";
            case "hotBackup" :
                    script = "hot.bat";
            default :
                    script = "nothing";
    }*/
        
        try {
                ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C",
                        script);
                pb.directory(new File(CHEMIN));

                Map env = pb.environment();
                Iterator<Map.Entry> it = env.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = it.next();
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }

                env.put("MonArg", "Valeur");
                env.put("sid", h.getSid());
                env.put("osname", h.getOsname());
                env.put("dbuser", h.getDbuser());
                env.put("dbpassword", h.getDbpassword());
                env.put("timestamp",""+b.getTimestamp());
                env.put("type",type);
                env.put("strategy",strategy);
                env.put("object",b.getObject());
                env.put("name",b.getName());
                env.put("s_repertory", b.getS_repertory());
                env.put("d_repertory", b.getD_repertory());
                env.put("log", b.getLog());

                Process p = pb.start();
                AfficheurFlux fluxSortie = new AfficheurFlux(p.getInputStream());
                AfficheurFlux fluxErreur = new AfficheurFlux(p.getErrorStream());
                new Thread(fluxSortie).start();
                new Thread(fluxErreur).start();
                p.waitFor();
                /*String file = "C:\\Users\\thomas\\Documents\\NetBeansProjects\\project\\BackApp\\src\\file\\log.txt";
                FileOutputStream out = new FileOutputStream(file);
                copyStream (p.getInputStream(), out);
                out.close();*/
                
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    
    public void createRmanScript(String oldfile,String newfile) throws IOException{
        File fileToBeModified = new File(CHEMIN+oldfile);
        File fileNew = new File(CHEMIN+newfile);
        String oldContent = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while(line!=null){
                oldContent = oldContent + line +System.lineSeparator();
                line = reader.readLine();
            }
            for(int i=0;i<rmanParam.size();i=i+2){
                oldContent = oldContent.replaceAll(rmanParam.get(i), rmanParam.get(i+1));
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileNew));
            writer.write(oldContent);
            reader.close();
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
