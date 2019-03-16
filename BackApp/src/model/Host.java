/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author thomas
 */
public class Host {
    
    private final StringProperty sid;
    private final StringProperty hostname;
    private final StringProperty ownername;
    private final StringProperty email;
    private final StringProperty osname;
    private final StringProperty osuser;
    private final StringProperty ospassword;
    private final StringProperty version;
    private final StringProperty dbuser;
    private final StringProperty dbpassword;
    
    private List<Plan> plans;
    private List<Backup> backups;

    public Host() {
        this("", "", "","", "", "","", "", "","");
    }

    public Host(String sid, String hostname, String ownername, String email, String osname, String osuser, String ospassword,String dbuser, String dbpassword, String version) {
        this.sid = new SimpleStringProperty(sid);
        this.hostname = new SimpleStringProperty(hostname);
        this.ownername = new SimpleStringProperty(ownername);
        this.email = new SimpleStringProperty(email);
        this.osname = new SimpleStringProperty(osname);
        this.osuser = new SimpleStringProperty(osuser);
        this.ospassword = new SimpleStringProperty(ospassword);
        this.version = new SimpleStringProperty(version);
        this.dbuser = new SimpleStringProperty(dbuser);
        this.dbpassword = new SimpleStringProperty(dbpassword);
    }
    
    /**
    * @return 
    */
    public String getSid() {
        return sid.get();
    }
    
    /**
    * @param sid
    */
    public void setSid(String sid) {
        this.sid.set(sid);
    }

    public String getHostname() {
        return hostname.get();
    }

    public void setHostname(String hostname) {
        this.hostname.set(hostname);
    }

    public String getOwnername() {
        return ownername.get();
    }

    public void setOwnername(String ownername) {
        this.ownername.set(ownername);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getOsname() {
        return osname.get();
    }

    public void setOsname(String osname) {
        this.osname.set(osname);
    }

    public String getOsuser() {
        return osuser.get();
    }

    public void setOsuser(String osuser) {
        this.osuser.set(osuser);
    }

    public String getOspassword() {
        return ospassword.get();
    }

    public void setOspassword(String ospassword) {
        this.ospassword.set(ospassword);
    }

    public String getVersion() {
        return version.get();
    }

    public void setVersion(String version) {
        this.version.set(version);
    }

    public String getDbuser() {
        return dbuser.get();
    }

    public void setDbuser(String dbuser) {
        this.dbuser.set(dbuser);
    }

    public String getDbpassword() {
        return dbpassword.get();
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword.set(dbpassword);
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
    
    public String toSearch() {
        return "Host{" + "sid=" + sid + ", hostname=" + hostname + ", ownername=" + ownername + ", email=" + email + ", osname=" + osname + ", osuser=" + osuser + ", ospassword=" + ospassword + ", version=" + version + ", dbuser=" + dbuser + ", dbpassword=" + dbpassword + '}';
    }

    @Override
    public String toString() {
        return "Database : " + sid.get().toUpperCase() + " (" + hostname.get() + ")";
    }
    
    
}
