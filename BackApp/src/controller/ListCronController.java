/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Cron;

/**
 *
 * @author thomas
 */
public class ListCronController implements Initializable {
    
        @FXML
        private VBox root;
        
        @FXML
        private TableView<Cron> tableView;
    
        @FXML
        private AnchorPane p_seconds,p_minutes,p_hours,p_day,p_month,p_year;
        
	@FXML
	private CheckBox s_00,s_01,s_02,s_03,s_04,s_05,s_06,s_07,s_08,s_09,
					s_10,s_11,s_12,s_13,s_14,s_15,s_16,s_17,s_18,s_19,
					s_20,s_21,s_22,s_23,s_24,s_25,s_26,s_27,s_28,s_29,
					s_30,s_31,s_32,s_33,s_34,s_35,s_36,s_37,s_38,s_39,
					s_40,s_41,s_42,s_43,s_44,s_45,s_46,s_47,s_48,s_49,
					s_50,s_51,s_52,s_53,s_54,s_55,s_56,s_57,s_58,s_59,
					
					m_00,m_01,m_02,m_03,m_04,m_05,m_06,m_07,m_08,m_09,
					m_10,m_11,m_12,m_13,m_14,m_15,m_16,m_17,m_18,m_19,
					m_20,m_21,m_22,m_23,m_24,m_25,m_26,m_27,m_28,m_29,
					m_30,m_31,m_32,m_33,m_34,m_35,m_36,m_37,m_38,m_39,
					m_40,m_41,m_42,m_43,m_44,m_45,m_46,m_47,m_48,m_49,
					m_50,m_51,m_52,m_53,m_54,m_55,m_56,m_57,m_58,_59,
					
					h_00,h_01,h_02,h_03,h_04,h_05,h_06,h_07,h_08,h_09,
					h_10,h_11,h_12,h_13,h_14,h_15,h_16,h_17,h_18,h_19,
					h_20,h_21,h_22,h_23,
					
					d_01,d_02,d_03,d_04,d_05,d_06,d_07,d_08,d_09,
					d_10,d_11,d_12,d_13,d_14,d_15,d_16,d_17,d_18,d_19,
					d_20,d_21,d_22,d_23,d_24,d_25,d_26,d_27,d_28,d_29,
					d_30,d_31,
					
					d_lundi,d_mardi,d_mercredi,d_jeudi,d_vendredi,d_samedi,d_dimanche,
					
					m_janvier,m_fevrier,m_mars,m_avril,m_mai,m_juin,m_juillet,m_aout,m_septembre,m_octobre,m_novembre,m_decembre,
					
					year_2019,
					year_2020,year_2021,year_2022,year_2023,year_2024,year_2025,year_2026,year_2027,year_2028,year_2029,
					year_2030,year_2031,year_2032,year_2033,year_2034,year_2035,year_2036,year_2037,year_2038,year_2039,
					year_2040,year_2041,year_2042,year_2043,year_2044,year_2045,year_2046,year_2047,year_2048,year_2049,
					year_2050,year_2051,year_2052,year_2053,year_2054,year_2055,year_2056,year_2057,year_2058,year_2059,
					year_2060,year_2061,year_2062,year_2063,year_2064,year_2065,year_2066,year_2067,year_2068,year_2069,
					year_2070,year_2071,year_2072,year_2073,year_2074,year_2075,year_2076,year_2077,year_2078,year_2079,
					year_2080,year_2081,year_2082,year_2083,year_2084,year_2085,year_2086,year_2087,year_2088,year_2089,
					year_2090,year_2091,year_2092,year_2093,year_2094,year_2095,year_2096,year_2097,year_2098,year_2099;
					
    @FXML
    private Label expression;
        
    @FXML
    private RadioButton g_seconds_1,g_seconds_2,g_seconds_3,g_seconds_4,
                        g_minutes_1,g_minutes_2,g_minutes_3,g_minutes_4,
                        g_hours_1,g_hours_2,g_hours_3,g_hours_4,
                        g_day_1,g_day_2,g_day_3,g_day_4,g_day_5,g_day_6,g_day_7,g_day_8,g_day_9,g_day_10,g_day_11,
                        g_month_1,g_month_2,g_month_3,g_month_4,
                        g_year_1,g_year_2,g_year_3,g_year_4;
    @FXML
    private ComboBox seconds_combo_1,seconds_combo_2,seconds_combo_3,seconds_combo_4,
            minutes_combo_1,minutes_combo_2,minutes_combo_3,minutes_combo_4,
            hours_combo_1,hours_combo_2,hours_combo_3,hours_combo_4,
            day_combo_1,day_combo_2,day_combo_3,day_combo_4,day_combo_5,day_combo_6,day_combo_7,day_combo_8,day_combo_9,
            month_combo_1,month_combo_2,month_combo_3,month_combo_4,
            year_combo_1,year_combo_2,year_combo_3,year_combo_4;
    private final String list60[] = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
    private final String list24[] = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
    private final String list31[] = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private final String listWD[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
    private final String listOrdre[] = {"1er","2e","3e","4e","5e"};
    private final String list12[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
    private final String listMois[] = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
    private final String list100[] = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100"};
    private final ArrayList<Integer> listAnnee;
    
    private final HashMap<String,String> monthMap;
    private final HashMap<String,String> dayMap;
    private final HashMap<String,String> dayMapInt;
    
    @FXML 
    private Label entete;
    
    private ObservableList<Cron> CronList = FXCollections.observableArrayList();
    
    //private CronService cronService;
    
    private Cron selected;

    public ListCronController() {
        this.listAnnee = new ArrayList();
        for(int i=2019;i<2100;i++){
            listAnnee.add(i);
        }
        monthMap = new HashMap();
        monthMap.put("Janvier", "JAN");
        monthMap.put("Février", "FEB");
        monthMap.put("Mars", "MAR");
        monthMap.put("Avril", "APR");
        monthMap.put("Mai", "MAY");
        monthMap.put("Juin", "JUN");
        monthMap.put("Juillet", "JUL");
        monthMap.put("Août", "AUG");
        monthMap.put("Septembre", "SEP");
        monthMap.put("Octobre", "OCT");
        monthMap.put("Novembre", "NOV");
        monthMap.put("Décembre", "DEC");
        
        dayMap = new HashMap();
        dayMap.put("Lundi", "MON");
        dayMap.put("Mardi", "TUE");
        dayMap.put("Mercredi", "WED");
        dayMap.put("Jeudi", "THU");
        dayMap.put("Vendredi", "FRI");
        dayMap.put("Samedi", "SAT");
        dayMap.put("Dimanche", "SUN");
        
        dayMapInt = new HashMap();
        dayMapInt.put("Lundi", "2");
        dayMapInt.put("Mardi", "3");
        dayMapInt.put("Mercredi", "4");
        dayMapInt.put("Jeudi", "5");
        dayMapInt.put("Vendredi", "6");
        dayMapInt.put("Samedi", "7");
        dayMapInt.put("Dimanche", "1");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Remplissage combo box
        seconds_combo_1.getItems().addAll((Object[]) list60);
        seconds_combo_2.getItems().addAll((Object[]) list60);
        seconds_combo_3.getItems().addAll((Object[]) list60);
        seconds_combo_4.getItems().addAll((Object[]) list60);
        minutes_combo_1.getItems().addAll((Object[]) list60);
        minutes_combo_2.getItems().addAll((Object[]) list60);
        minutes_combo_3.getItems().addAll((Object[]) list60);
        minutes_combo_4.getItems().addAll((Object[]) list60);
        hours_combo_1.getItems().addAll((Object[]) list24);
        hours_combo_2.getItems().addAll((Object[]) list24);
        hours_combo_3.getItems().addAll((Object[]) list24);
        hours_combo_4.getItems().addAll((Object[]) list24);
        day_combo_1.getItems().addAll((Object[]) list31);
        day_combo_3.getItems().addAll((Object[]) list31);
        day_combo_4.getItems().addAll((Object[]) list31);
        day_combo_6.getItems().addAll((Object[]) list31);
        day_combo_7.getItems().addAll((Object[]) list31);
        day_combo_2.getItems().addAll((Object[]) listWD);
        day_combo_5.getItems().addAll((Object[]) listWD);
        day_combo_9.getItems().addAll((Object[]) listWD);
        day_combo_8.getItems().addAll((Object[]) listOrdre);
        month_combo_1.getItems().addAll((Object[]) list12);
        month_combo_2.getItems().addAll((Object[]) listMois);
        month_combo_3.getItems().addAll((Object[]) listMois);
        month_combo_4.getItems().addAll((Object[]) listMois);
        year_combo_1.getItems().addAll((Object[]) list100);
        year_combo_2.getItems().addAll(listAnnee);
        year_combo_3.getItems().addAll(listAnnee);
        year_combo_4.getItems().addAll(listAnnee);
        
        //cronService = new CronService();
        //CronList.addAll(cronService.findAll());
        tableView.getItems().addAll(CronList);
        tableView.getItems().add(new Cron(1,"Rose",true));
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cron>() {
            @Override
            public void changed(ObservableValue<? extends Cron> observable, Cron oldValue, Cron newValue) {
                selected=newValue;
                System.out.println("Selected item: " + newValue);
            }
        });
    }    
    
    @FXML
    private void enregistrer(ActionEvent event) {
        System.out.println("You clicked me!");
        String l_seconds = null,l_minutes = null,l_hours = null,l_day = null,l_month = null,l_year = null,l_wd = null;
        if(g_seconds_1.isSelected()){
            l_seconds = "* ";
        }
        else if(g_seconds_2.isSelected()){
            l_seconds = ((String)seconds_combo_2.getValue())+"/"+((String)seconds_combo_1.getValue())+" ";
        }
        else if(g_seconds_3.isSelected()){
            String tmp="";
            for(Node node : p_seconds.getChildren()){             
                if(node instanceof CheckBox){
                    CheckBox box = (CheckBox) node;
                    if(box.isSelected())
                        tmp += Integer.parseUnsignedInt(box.getText())+",";
                }
            }
            if(tmp.length()>0)
                l_seconds = tmp.substring(0, tmp.length()-1)+" ";
        }
        else if(g_seconds_4.isSelected()){
            l_seconds = ((String)seconds_combo_3.getValue())+"-"+((String)seconds_combo_4.getValue())+" ";
        }
        else {
            l_seconds = "0 ";
        }
        if(g_minutes_1.isSelected()){
           l_minutes = "* "; 
        }
        else if(g_minutes_2.isSelected()){
            l_minutes = ((String)minutes_combo_2.getValue())+"/"+((String)minutes_combo_1.getValue())+" ";
        }
        else if(g_minutes_3.isSelected()){
            String tmp="";
            for(Node node : p_minutes.getChildren()){             
                if(node instanceof CheckBox){
                    CheckBox box = (CheckBox) node;
                    if(box.isSelected())
                        tmp += Integer.parseUnsignedInt(box.getText())+",";
                }
            }
            if(tmp.length()>0)
                l_minutes = tmp.substring(0, tmp.length()-1)+" ";
        }
        else if(g_minutes_4.isSelected()){
            l_minutes = ((String)minutes_combo_3.getValue())+"-"+((String)minutes_combo_4.getValue())+" ";
        }
        else {
            l_minutes = "0 ";
        }
        if(g_hours_1.isSelected()){
            l_hours = "* ";
        }
        else if(g_hours_2.isSelected()){
            l_hours = ((String)hours_combo_2.getValue())+"/"+((String)hours_combo_1.getValue())+" ";
        }
        else if(g_hours_3.isSelected()){
            String tmp="";
            for(Node node : p_hours.getChildren()){             
                if(node instanceof CheckBox){
                    CheckBox box = (CheckBox) node;
                    if(box.isSelected())
                        tmp += Integer.parseUnsignedInt(box.getText())+",";
                }
            }
            if(tmp.length()>0)
                l_hours = tmp.substring(0, tmp.length()-1)+" ";
        }
        else if(g_hours_4.isSelected()){
            l_hours = ((String)hours_combo_3.getValue())+"/"+((String)hours_combo_4.getValue())+" ";
        }
        else {
            l_hours = "0 ";
        }
        if(g_day_1.isSelected()){
            l_day = "* ";
            l_wd = "? ";
        }
        else if(g_day_2.isSelected()){
            l_day = dayMap.get((String)day_combo_2.getValue())+"/"+((String)day_combo_1.getValue())+" ";
        }
        else if(g_day_3.isSelected()){
            l_day = ((String)day_combo_4.getValue())+"/"+((String)day_combo_3.getValue())+" ";
        }
        else if(g_day_4.isSelected()){
            String tmp="";
            for(Node node : p_day.getChildren()){            
                if(node instanceof CheckBox){
                    CheckBox box = (CheckBox) node;
                    if((box.isSelected())&&(box.getText().length()>3))
                        tmp += dayMap.get(box.getText())+",";
                }
            }
            if(tmp.length()>0)
                l_wd = tmp.substring(0, tmp.length()-1)+" ";
            l_day = "? ";
        }
        else if(g_day_5.isSelected()){
            String tmp="";
            for(Node node : p_day.getChildren()){ 
                if(node instanceof CheckBox){
                    CheckBox box = (CheckBox) node;
                    if((box.isSelected())&&(box.getText().length()<3))
                        tmp += Integer.parseUnsignedInt(box.getText())+",";
                }
            }
            if(tmp.length()>0)
                l_day = tmp.substring(0, tmp.length()-1)+" ";
            l_wd = "? ";
        }
        else if(g_day_6.isSelected()){
            l_day = "L ";
            l_wd = "? ";
        }
        else if(g_day_7.isSelected()){
            l_day = "LW";
            l_wd = "? ";
        }
        else if(g_day_8.isSelected()){
            l_day = dayMapInt.get((String)day_combo_5.getValue())+"L ";
            l_wd = "? ";
        }
        else if(g_day_9.isSelected()){
            l_day = "L-"+Integer.parseInt((String)day_combo_6.getValue())+" ";
            l_wd = "? ";
        }
        else if(g_day_10.isSelected()){
            l_day = Integer.parseInt((String)day_combo_7.getValue())+"W ";
            l_wd = "? ";
        }
        else if(g_day_11.isSelected()){
            l_wd = dayMapInt.get((String)day_combo_9.getValue())+"#"+((String)day_combo_8.getValue()).charAt(0)+" ";
            l_day = "? ";
        }
        else {
            l_day = "? ";
            l_wd = "? ";
        }
        if(g_month_1.isSelected()){
            l_month = "* ";
        }
        else if(g_month_2.isSelected()){
            l_month = monthMap.get((String)month_combo_2.getValue())+"/"+((String)month_combo_1.getValue())+" ";
        }
        else if(g_month_3.isSelected()){
            String tmp="";
            for(Node node : p_month.getChildren()){      
                if(node instanceof CheckBox){
                    CheckBox box = (CheckBox) node;
                    if(box.isSelected())
                        tmp += monthMap.get(box.getText())+",";
                }
            }
            if(tmp.length()>0)
                l_month = tmp.substring(0, tmp.length()-1)+" ";
        }
        else if(g_month_4.isSelected()){
            l_month = monthMap.get((String)month_combo_3.getValue())+"/"+monthMap.get((String)month_combo_4.getValue())+" ";
        }
        else {
            l_month = "* ";
        }
        if(g_year_1.isSelected()){
            l_year = "* ";
        }
        else if(g_year_2.isSelected()){
            l_year = ((String)year_combo_2.getValue())+"/"+((String)year_combo_1.getValue())+" ";
        }
        else if(g_year_3.isSelected()){
            String tmp="";
            for(Node node : p_year.getChildren()){     
                if(node instanceof CheckBox){
                    CheckBox box = (CheckBox) node;
                    if(box.isSelected())
                        tmp += Integer.parseUnsignedInt(box.getText())+",";
                }
            }
            if(tmp.length()>0)
                l_year = tmp.substring(0, tmp.length()-1)+" ";
        }
        else if(g_year_4.isSelected()){
            l_year = ((String)year_combo_3.getValue())+"/"+((String)year_combo_4.getValue())+" ";
        }
        else {
            l_year = "";
        }
        expression.setText(l_seconds+l_minutes+l_hours+l_day+l_month+l_wd+l_year);
    }
	
    @FXML
    private void createHost(ActionEvent event) {
            try {
                root = (VBox) FXMLLoader.load(getClass().getResource("/view/Createbackup.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(ListCronController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        System.out.println("You clicked me!");
        if(selected != null){
            //hostService.delete(selected);
            tableView.getItems().remove(selected);
        }  
    }
    
    @FXML
    private void modifier(ActionEvent event) {
        System.out.println("You clicked me!");
        if(selected != null){
            //hostService.delete(selected);
            entete.setText("Modification SID:"+selected.getId());
        }  
    }
    
    @FXML
    private void ajouter(ActionEvent event) {
        System.out.println("You clicked me!");
        entete.setText("Enregistrement");
    }
}
