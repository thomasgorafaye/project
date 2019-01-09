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
    private String objet;
    private String name;
    private String type;
    private String strategy;
    private String s_repertory;
    private String d_repertory;
    private String log;
    
    private List<Cron> crons;
    private List<Backup> backups;
}
