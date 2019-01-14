/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author thomas
 */
public class Cron {
    private int id;
    private String expression;
    private boolean active;
    
    private int plan;
    
    private Elements elements;

    public Cron() {
    }

    public Cron(int id, String expression, boolean active) {
        this.id = id;
        this.expression = expression;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
        return "Cron{" + "id=" + id + ", expression=" + expression + ", active=" + active + '}';
    }
    
}
