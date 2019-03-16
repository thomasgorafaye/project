/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import model.Host;

/**
 *
 * @author thomas
 */
public class CheckArchiveLog implements Runnable{
    
    final String CHEMIN = "C:\\Users\\thomas\\Documents\\NetBeansProjects\\project\\BackApp\\src\\file";
    
    private InputStream inputStream;
    
    private int result = 1;

    private BufferedReader getBufferedReader(InputStream is) {
        return new BufferedReader(new InputStreamReader(is));
    }

    @Override
    public void run() {
        BufferedReader br = getBufferedReader(inputStream);
        String ligne = "";
        try {
            while ((ligne = br.readLine()) != null) {
                if(ligne.equalsIgnoreCase("archivelog"))
                    result = 0;
                if(ligne.equalsIgnoreCase("noarchivelog"))
                    result = 2;
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int check(Host h){
        try {
                ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C",
                        "check_archivelog_mode.bat");
                pb.directory(new File(CHEMIN));

                Map env = pb.environment();
                /*Iterator<Map.Entry> it = env.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = it.next();
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }*/

                env.put("MonArg", "Valeur");
                env.put("sid", h.getSid());
                env.put("osname", h.getOsname());
                env.put("dbuser", h.getDbuser());
                env.put("dbpassword", h.getDbpassword());

                Process p = pb.start();
                inputStream = p.getInputStream();
                new Thread(this).start();
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
        return result;
    }
}