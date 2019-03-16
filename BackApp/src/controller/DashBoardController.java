/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import model.Backup;
import model.Host;
import model.Plan;
import service.BackupService;
import service.CronService;
import service.HostService;
import service.PlanService;

/**
 *
 * @author thomas
 */
public class DashBoardController implements Initializable {
    
    @FXML
    private PieChart chart1,chart2;
    
    @FXML
    private BarChart chart3;
    
    @FXML
    private LineChart chart4;
    
    @FXML
    private Label host,plan,cron,backup;
    
    private HostService hostService;
    private PlanService planService;
    private BackupService backupService;
    private CronService cronService;
    
    private ObservableList<Data> list = FXCollections.observableArrayList();
    private ObservableList<Data> list2 = FXCollections.observableArrayList();
    private ObservableList<BarChart.Series> list4 = FXCollections.observableArrayList();
    
    public DashBoardController(){
        hostService = new HostService();
        planService = new PlanService();
        backupService = new BackupService();
        cronService = new CronService();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int total = backupService.getTotal();
        host.setText(""+hostService.getTotal());
        backup.setText(""+total);
        plan.setText(""+planService.getTotal());
        cron.setText(""+cronService.getTotal());
        
        int success = backupService.getTotalSuccess();
        int planned = backupService.getTotalPlanned();
        
        Data data1 = new Data("Succès",success);
        Data data2 = new Data("Echec",total-success);
        Data data3 = new Data("Planfiniée",planned);
        Data data4 = new Data("Manuelle",total-planned);
        list.add(data1);
        list.add(data2);
        list2.add(data3);
        list2.add(data4);
        chart2.setData(list2);
        chart1.setData(list);
        chart1.setClockwise(true);
        chart2.setClockwise(true);
        chart1.setLabelsVisible(false);
        chart2.setLabelsVisible(true);
        chart1.setTitle("Succès/Echec");
        chart2.setTitle("Exécution");
        
        List<Backup> listBackup = backupService.getTotalGroupBy();
        
        Iterator<Backup> it = listBackup.iterator();
        String rman = "Rman";
        String export = "Import/Export";
        String xcopy = "Xcopy";
        String hot = "Sauvegarde à chaud";
        int rman_success = 0;
        int rman_planned = 0;
        int rman_hot = 0;
        int export_success = 0;
        int export_planned = 0;
        int export_hot = 0;
        int xcopy_success = 0;
        int xcopy_planned = 0;
        int xcopy_hot = 0;
        
        while(it.hasNext()){
            Backup b = it.next(); 
            if(b.getMethod().equals(rman)){
                if(b.isSuccess()==true)
                    rman_success+=b.getTimestamp();
                if(b.isPlanned()==true)
                    rman_planned+=b.getTimestamp();
                if(b.getType().equals(hot))
                    rman_hot+=b.getTimestamp();       
            }else if(b.getMethod().equals(export)){
                if(b.isSuccess()==true)
                    export_success+=b.getTimestamp();
                if(b.isPlanned()==true)
                    export_planned+=b.getTimestamp();
                if(b.getType().equals(hot))
                    export_hot+=b.getTimestamp();    
            }else{
                if(b.isSuccess()==true)
                    xcopy_success+=b.getTimestamp();
                if(b.isPlanned()==true)
                    xcopy_planned+=b.getTimestamp();
                if(b.getType().equals(hot))
                    xcopy_hot+=b.getTimestamp();    
            }
        }
        
        XYChart.Series serie1 = new XYChart.Series();
        serie1.setName("Succès");
        serie1.getData().add(new XYChart.Data(rman,rman_success));
        serie1.getData().add(new XYChart.Data(export,export_success));
        serie1.getData().add(new XYChart.Data(xcopy,xcopy_success));
        XYChart.Series serie2 = new XYChart.Series();
        serie2.setName("Planifiée");
        serie2.getData().add(new XYChart.Data(rman,rman_planned));
        serie2.getData().add(new XYChart.Data(export,export_planned));
        serie2.getData().add(new XYChart.Data(xcopy,xcopy_planned));
        XYChart.Series serie3 = new XYChart.Series();
        serie3.setName("Chaud");
        serie3.getData().add(new XYChart.Data(rman,rman_hot));
        serie3.getData().add(new XYChart.Data(export,export_hot));
        serie3.getData().add(new XYChart.Data(xcopy,xcopy_hot));
        
        list4.add(serie1);
        list4.add(serie2);
        list4.add(serie3);
        //chart3.setBarGap(100);
        //chart3.setCategoryGap(10);
        chart3.setData(list4);
        
        int rman_jan = 0;
        int rman_feb = 0;
        int rman_mar = 0;
        int rman_apr = 0;
        int rman_may = 0;
        int rman_jun = 0;
        int rman_jul = 0;
        int rman_aug = 0;
        int rman_sep = 0;
        int rman_oct = 0;
        int rman_nov = 0;
        int rman_dec = 0;
        int export_jan = 0;
        int export_feb = 0;
        int export_mar = 0;
        int export_apr = 0;
        int export_may = 0;
        int export_jun = 0;
        int export_jul = 0;
        int export_aug = 0;
        int export_sep = 0;
        int export_oct = 0;
        int export_nov = 0;
        int export_dec = 0;
        int xcopy_jan = 0;
        int xcopy_feb = 0;
        int xcopy_mar = 0;
        int xcopy_apr = 0;
        int xcopy_may = 0;
        int xcopy_jun = 0;
        int xcopy_jul = 0;
        int xcopy_aug = 0;
        int xcopy_sep = 0;
        int xcopy_oct = 0;
        int xcopy_nov = 0;
        int xcopy_dec = 0;
        
        chart4.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName(rman);
        //populating the series with data
        series.getData().add(new XYChart.Data("JAN", 33));
        series.getData().add(new XYChart.Data("FEB", 34));
        series.getData().add(new XYChart.Data("MAR", 35));
        series.getData().add(new XYChart.Data("APR", 34));
        series.getData().add(new XYChart.Data("MAY", 34));
        series.getData().add(new XYChart.Data("JUN", 36));
        series.getData().add(new XYChart.Data("JUL", 23));
        series.getData().add(new XYChart.Data("AUG", 53));
        series.getData().add(new XYChart.Data("SEP", 33));
        series.getData().add(new XYChart.Data("OCT", 73));
        series.getData().add(new XYChart.Data("NOV", 93));
        series.getData().add(new XYChart.Data("DEC", 53));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(export);
        //populating the series with data
        series2.getData().add(new XYChart.Data("JAN", 38));
        series2.getData().add(new XYChart.Data("FEB", 35));
        series2.getData().add(new XYChart.Data("MAR", 25));
        series2.getData().add(new XYChart.Data("APR", 44));
        series2.getData().add(new XYChart.Data("MAY", 44));
        series2.getData().add(new XYChart.Data("JUN", 16));
        series2.getData().add(new XYChart.Data("JUL", 13));
        series2.getData().add(new XYChart.Data("AUG", 63));
        series2.getData().add(new XYChart.Data("SEP", 23));
        series2.getData().add(new XYChart.Data("OCT", 63));
        series2.getData().add(new XYChart.Data("NOV", 73));
        series2.getData().add(new XYChart.Data("DEC", 63));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(xcopy);
        //populating the series with data
        series3.getData().add(new XYChart.Data("JAN", 13));
        series3.getData().add(new XYChart.Data("FEB", 84));
        series3.getData().add(new XYChart.Data("MAR", 25));
        series3.getData().add(new XYChart.Data("APR", 74));
        series3.getData().add(new XYChart.Data("MAY", 64));
        series3.getData().add(new XYChart.Data("JUN", 56));
        series3.getData().add(new XYChart.Data("JUL", 33));
        series3.getData().add(new XYChart.Data("AUG", 63));
        series3.getData().add(new XYChart.Data("SEP", 33));
        series3.getData().add(new XYChart.Data("OCT", 63));
        series3.getData().add(new XYChart.Data("NOV", 73));
        series3.getData().add(new XYChart.Data("DEC", 23));
        
        chart4.getData().add(series);
        chart4.getData().add(series2);
        chart4.getData().add(series3);
    }
    
    
    
}
