/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author thomas
 */
public class Host {
    
    private String sid;
    private String hostname;
    private String ownername;
    private String osuser;
    private String ospassword;
    private String version;
    private String dbuser;
    private String dbpassword;
    
    private List<Plan> plans;
    private List<Backup> backups;
}
