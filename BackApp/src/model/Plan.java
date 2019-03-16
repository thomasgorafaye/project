/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author thomas
 */
public class Plan {
    
    private IntegerProperty id;
    private BooleanProperty active;
    private SimpleStringProperty script;
    private SimpleStringProperty object;
    private SimpleStringProperty name;
    private SimpleStringProperty type;
    private SimpleStringProperty method;
    private SimpleStringProperty strategy;
    private SimpleStringProperty s_repertory;
    private SimpleStringProperty d_repertory;
    private SimpleStringProperty log;
    
    private String host;
    
    private List<Cron> crons;
    private List<Backup> backups;

    public Plan() {
    }

    public Plan(int id, boolean active, String script,String object, String name, String type, String method, String strategy, String s_repertory, String d_repertory, String log, String host) {
        this.id = new SimpleIntegerProperty(id);
        this.active = new SimpleBooleanProperty(active);
        this.script = new SimpleStringProperty(script);
        this.object = new SimpleStringProperty(object);
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.method = new SimpleStringProperty(method);
        this.strategy = new SimpleStringProperty(strategy);
        this.s_repertory = new SimpleStringProperty(s_repertory);
        this.d_repertory = new SimpleStringProperty(d_repertory);
        this.log = new SimpleStringProperty(log);
        this.host = host;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }
    
    public BooleanProperty activeProperty(){
        return active;
    }

    public boolean isActive() {
        return active.get();
    }

    public void setActive(boolean active) {
        this.active.set(active);
    }

    public String getScript() {
        return script.get();
    }

    public void setScript(String script) {
        this.script.set(script);
    }

    public String getObject() {
        return object.get();
    }

    public void setObject(String object) {
        this.object.set(object);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getMethod() {
        return method.get();
    }

    public void setMethod(String method) {
        this.method.set(method);
    }
    
    

    public String getStrategy() {
        return strategy.get();
    }

    public void setStrategy(String strategy) {
        this.strategy.set(strategy);
    }

    public String getS_repertory() {
        return s_repertory.get();
    }

    public void setS_repertory(String s_repertory) {
        this.s_repertory.set(s_repertory);
    }

    public String getD_repertory() {
        return d_repertory.get();
    }

    public void setD_repertory(String d_repertory) {
        this.d_repertory.set(d_repertory);
    }

    public String getLog() {
        return log.get();
    }

    public void setLog(String log) {
        this.log.set(log);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<Cron> getCrons() {
        return crons;
    }

    public void setCrons(List<Cron> crons) {
        this.crons = crons;
    }

    public List<Backup> getBackups() {
        return backups;
    }

    public void setBackups(List<Backup> backups) {
        this.backups = backups;
    }

    @Override
    public String toString() {
        return "Plan{" + "id=" + id + ", active=" + active + ", script=" + script + ", object=" + object + ", name=" + name + ", type=" + type + ", method=" + method + ", strategy=" + strategy + ", s_repertory=" + s_repertory + ", d_repertory=" + d_repertory + ", log=" + log + ", host=" + host +'}';
    }
    
}
