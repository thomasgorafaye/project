/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author thomas
 */
public class Backup {
    
    private long timestamp;
    private Date date;
    private String time;
    private String type;
    private String method;
    private String objet;
    private String name;
    private String strategy;
    private String s_repertory;
    private String d_repertory;
    private String log;
    private boolean success;
    private boolean planned;

    public Backup() {
    }

    public Backup(long timestamp, Date date, String time, String type, String method, String objet, String name, String strategy, String s_repertory, String d_repertory, String log, boolean success, boolean planned) {
        this.timestamp = timestamp;
        this.date = date;
        this.time = time;
        this.type = type;
        this.method = method;
        this.objet = objet;
        this.name = name;
        this.strategy = strategy;
        this.s_repertory = s_repertory;
        this.d_repertory = d_repertory;
        this.log = log;
        this.success = success;
        this.planned = planned;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isPlanned() {
        return planned;
    }

    public void setPlanned(boolean planned) {
        this.planned = planned;
    }

    @Override
    public String toString() {
        return "Backup{" + "timestamp=" + timestamp + ", date=" + date + ", time=" + time + ", type=" + type + ", method=" + method + ", objet=" + objet + ", name=" + name + ", strategy=" + strategy + ", s_repertory=" + s_repertory + ", d_repertory=" + d_repertory + ", log=" + log + ", success=" + success + ", planned=" + planned + '}';
    }
    
    
}
