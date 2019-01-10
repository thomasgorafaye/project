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
    private String email;
    private String osuser;
    private String ospassword;
    private String version;
    private String dbuser;
    private String dbpassword;
    
    private List<Plan> plans;
    private List<Backup> backups;

    public Host() {
    }

    public Host(String sid, String hostname, String ownername, String email, String osuser, String ospassword, String version, String dbuser, String dbpassword) {
        this.sid = sid;
        this.hostname = hostname;
        this.ownername = ownername;
        this.email = email;
        this.osuser = osuser;
        this.ospassword = ospassword;
        this.version = version;
        this.dbuser = dbuser;
        this.dbpassword = dbpassword;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOsuser() {
        return osuser;
    }

    public void setOsuser(String osuser) {
        this.osuser = osuser;
    }

    public String getOspassword() {
        return ospassword;
    }

    public void setOspassword(String ospassword) {
        this.ospassword = ospassword;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDbuser() {
        return dbuser;
    }

    public void setDbuser(String dbuser) {
        this.dbuser = dbuser;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public List<Backup> getBackups() {
        return backups;
    }

    public void setBackups(List<Backup> backups) {
        this.backups = backups;
    }

    @Override
    public String toString() {
        return "Host{" + "sid=" + sid + ", hostname=" + hostname + ", ownername=" + ownername + ", email=" + email + ", osuser=" + osuser + ", ospassword=" + ospassword + ", version=" + version + ", dbuser=" + dbuser + ", dbpassword=" + dbpassword + '}';
    }
    
    
}
