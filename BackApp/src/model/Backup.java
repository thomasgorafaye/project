/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.Date;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author thomas
 */
public class Backup {
    
    private LongProperty timestamp;
    private ObjectProperty<Date> date;
    private SimpleStringProperty time;
    private SimpleStringProperty type;
    private SimpleStringProperty method;
    private SimpleStringProperty object;
    private SimpleStringProperty name;
    private SimpleStringProperty strategy;
    private SimpleStringProperty s_repertory;
    private SimpleStringProperty d_repertory;
    private SimpleStringProperty log;
    private BooleanProperty success;
    private BooleanProperty planned;
    
    private String host;
    private int plan;

    public Backup() {
        this.timestamp = new SimpleLongProperty();
        this.date = new SimpleObjectProperty();
        this.time = new SimpleStringProperty();
        this.type = new SimpleStringProperty();
        this.method = new SimpleStringProperty();
        this.object = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.strategy = new SimpleStringProperty();
        this.s_repertory = new SimpleStringProperty();
        this.d_repertory = new SimpleStringProperty();
        this.log = new SimpleStringProperty();
        this.success = new SimpleBooleanProperty();
        this.planned = new SimpleBooleanProperty();
    }

    public Backup(long timestamp, Date date, String time, String type, String method, String object, String name, String strategy, String s_repertory, String d_repertory, String log, boolean success, boolean planned, String host, int plan) {
        this.timestamp = new SimpleLongProperty(timestamp);
        this.date = new SimpleObjectProperty(date);
        this.time = new SimpleStringProperty(time);
        this.type = new SimpleStringProperty(type);
        this.method = new SimpleStringProperty(method);
        this.object = new SimpleStringProperty(object);
        this.name = new SimpleStringProperty(name);
        this.strategy = new SimpleStringProperty(strategy);
        this.s_repertory = new SimpleStringProperty(s_repertory);
        this.d_repertory = new SimpleStringProperty(d_repertory);
        this.log = new SimpleStringProperty(log);
        this.success = new SimpleBooleanProperty(success);
        this.planned = new SimpleBooleanProperty(planned);
        this.host = host;
        this.plan = plan;
    }

    public long getTimestamp() {
        return timestamp.get();
    }

    public void setTimestamp(long timestamp) {
        this.timestamp.set(timestamp);
    }

    public Date getDate() {
        return date.get();
    }

    public void setDate(Date date) {
        this.date.set(date);
    }

    public String getTime() {
        return time.get();
    }

    public void setTime(String time) {
        this.time.set(time);
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
    
    public BooleanProperty successProperty() {
        return success;
    }

    public boolean isSuccess() {
        return success.get();
    }

    public void setSuccess(boolean success) {
        this.success.set(success);
    }
    
    public BooleanProperty plannedProperty() {
        return planned;
    }

    public boolean isPlanned() {
        return planned.get();
    }

    public void setPlanned(boolean planned) {
        this.planned.set(planned);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "Backup{" + "timestamp=" + timestamp + ", date=" + date + ", time=" + time + ", type=" + type + ", method=" + method + ", object=" + object + ", name=" + name + ", strategy=" + strategy + ", s_repertory=" + s_repertory + ", d_repertory=" + d_repertory + ", log=" + log + ", success=" + success + ", planned=" + planned + ", host=" + host + ", plan=" + plan + '}';
    }
    
    
}
