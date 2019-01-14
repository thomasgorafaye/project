/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import model.Backup;
import model.Host;

/**
 *
 * @author thomas
 */
public class Script {
    
    final String CHEMIN = "C:\\workspace\\";
    
    public void run(Host h, Backup b){
        
        String script;
        switch (b.getMethod()){
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
    }
        
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
                env.put("s_repertory", b.getS_repertory());
                env.put("d_repertoty", b.getD_repertory());
                env.put("log", b.getLog());

                Process p = pb.start();
                AfficheurFlux fluxSortie = new AfficheurFlux(p.getInputStream());
                AfficheurFlux fluxErreur = new AfficheurFlux(p.getErrorStream());
                new Thread(fluxSortie).start();
                new Thread(fluxErreur).start();
                p.waitFor();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
