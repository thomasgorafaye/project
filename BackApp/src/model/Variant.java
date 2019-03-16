/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author thomas
 */
public class Variant {
    
    private IntegerProperty id;
    private SimpleStringProperty type;
    private SimpleStringProperty method;
    private SimpleStringProperty object;
    private SimpleStringProperty name;
    private SimpleStringProperty strategy;
    private SimpleStringProperty s_repertory;
    private SimpleStringProperty d_repertory;
    private SimpleStringProperty log;
    private SimpleStringProperty description;
    
    
    public Variant() {
        this.id = new SimpleIntegerProperty();
        this.type = new SimpleStringProperty();
        this.method = new SimpleStringProperty();
        this.object = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.strategy = new SimpleStringProperty();
        this.s_repertory = new SimpleStringProperty();
        this.d_repertory = new SimpleStringProperty();
        this.log = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
    }
    
    public Variant(int id, String type, String method, String object, String name, String strategy, String s_repertory, String d_repertory, String log, String description) {
        this.id = new SimpleIntegerProperty(id);
        this.type = new SimpleStringProperty(type);
        this.method = new SimpleStringProperty(method);
        this.object = new SimpleStringProperty(object);
        this.name = new SimpleStringProperty(name);
        this.strategy = new SimpleStringProperty(strategy);
        this.s_repertory = new SimpleStringProperty(s_repertory);
        this.d_repertory = new SimpleStringProperty(d_repertory);
        this.log = new SimpleStringProperty(log);
        this.description = new SimpleStringProperty(description);
    }

    public long getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
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

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    @Override
    public String toString() {
        return id.get() + " " + description.get() ;
    }
    
    
}
