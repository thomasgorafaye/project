/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author thomas
 */
public class Cron {
    private IntegerProperty id;
    private SimpleStringProperty expression;
    private BooleanProperty active;
    
    private int plan;
    
    private Elements elements;

    public Cron() {
        
    }

    public Cron(int id, String expression, boolean active, int plan) {
        this.id = new SimpleIntegerProperty(id);
        this.expression = new SimpleStringProperty(expression);
        this.active = new SimpleBooleanProperty(active);
        this.plan = plan;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getExpression() {
        return expression.get();
    }

    public void setExpression(String expression) {
        this.expression.set(expression);
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

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public Elements getElements() {
        return elements;
    }

    public void setElements(Elements elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Cron{" + "id=" + id + ", expression=" + expression + ", active=" + active + ", plan=" + plan +'}';
    }
    
}
