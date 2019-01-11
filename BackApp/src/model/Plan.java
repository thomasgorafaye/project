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
public class Plan {
    
    private int id;
    private boolean active;
    private String script;
    private String object;
    private String name;
    private String type;
    private String method;
    private String strategy;
    private String s_repertory;
    private String d_repertory;
    private String log;
    
    private String host;
    
    private List<Cron> crons;
    private List<Backup> backups;

    public Plan() {
    }

    public Plan(int id, boolean active, String script, String object, String name, String type, String method, String strategy, String s_repertory, String d_repertory, String log) {
        this.id = id;
        this.active = active;
        this.script = script;
        this.object = object;
        this.name = name;
        this.type = type;
        this.method = method;
        this.strategy = strategy;
        this.s_repertory = s_repertory;
        this.d_repertory = d_repertory;
        this.log = log;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
    

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getS_repertory() {
        return s_repertory;
    }

    public void setS_repertory(String s_repertory) {
        this.s_repertory = s_repertory;
    }

    public String getD_repertory() {
        return d_repertory;
    }

    public void setD_repertory(String d_repertory) {
        this.d_repertory = d_repertory;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
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
        return "Plan{" + "id=" + id + ", active=" + active + ", script=" + script + ", object=" + object + ", name=" + name + ", type=" + type + ", method=" + method + ", strategy=" + strategy + ", s_repertory=" + s_repertory + ", d_repertory=" + d_repertory + ", log=" + log + '}';
    }
    
}
