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
public class Elements {
    
    private String year_start;
    private String year_end;
    private String year_every;
    private String weekday_start;
    private String weekday_end;
    private String weekday_every;
    private String month_start;
    private String month_end;
    private String month_every;
    private String day_start;
    private String day_end;
    private String day_every; 
    private String hour_start;
    private String hour_end;
    private String hour_every;
    private String minute_start;
    private String minute_end;
    private String minute_every;
    private String second_start;
    private String second_end;
    private String second_every;

    public Elements() {
    }

    public Elements(String year_start, String year_end, String year_every, String weekday_start, String weekday_end, String weekday_every, String month_start, String month_end, String month_every, String day_start, String day_end, String day_every, String hour_start, String hour_end, String hour_every, String minute_start, String minute_end, String minute_every, String second_start, String second_end, String second_every) {
        this.year_start = year_start;
        this.year_end = year_end;
        this.year_every = year_every;
        this.weekday_start = weekday_start;
        this.weekday_end = weekday_end;
        this.weekday_every = weekday_every;
        this.month_start = month_start;
        this.month_end = month_end;
        this.month_every = month_every;
        this.day_start = day_start;
        this.day_end = day_end;
        this.day_every = day_every;
        this.hour_start = hour_start;
        this.hour_end = hour_end;
        this.hour_every = hour_every;
        this.minute_start = minute_start;
        this.minute_end = minute_end;
        this.minute_every = minute_every;
        this.second_start = second_start;
        this.second_end = second_end;
        this.second_every = second_every;
    }

    public String getYear_start() {
        return year_start;
    }

    public void setYear_start(String year_start) {
        this.year_start = year_start;
    }

    public String getYear_end() {
        return year_end;
    }

    public void setYear_end(String year_end) {
        this.year_end = year_end;
    }

    public String getYear_every() {
        return year_every;
    }

    public void setYear_every(String year_every) {
        this.year_every = year_every;
    }

    public String getWeekday_start() {
        return weekday_start;
    }

    public void setWeekday_start(String weekday_start) {
        this.weekday_start = weekday_start;
    }

    public String getWeekday_end() {
        return weekday_end;
    }

    public void setWeekday_end(String weekday_end) {
        this.weekday_end = weekday_end;
    }

    public String getWeekday_every() {
        return weekday_every;
    }

    public void setWeekday_every(String weekday_every) {
        this.weekday_every = weekday_every;
    }

    public String getMonth_start() {
        return month_start;
    }

    public void setMonth_start(String month_start) {
        this.month_start = month_start;
    }

    public String getMonth_end() {
        return month_end;
    }

    public void setMonth_end(String month_end) {
        this.month_end = month_end;
    }

    public String getMonth_every() {
        return month_every;
    }

    public void setMonth_every(String month_every) {
        this.month_every = month_every;
    }

    public String getDay_start() {
        return day_start;
    }

    public void setDay_start(String day_start) {
        this.day_start = day_start;
    }

    public String getDay_end() {
        return day_end;
    }

    public void setDay_end(String day_end) {
        this.day_end = day_end;
    }

    public String getDay_every() {
        return day_every;
    }

    public void setDay_every(String day_every) {
        this.day_every = day_every;
    }

    public String getHour_start() {
        return hour_start;
    }

    public void setHour_start(String hour_start) {
        this.hour_start = hour_start;
    }

    public String getHour_end() {
        return hour_end;
    }

    public void setHour_end(String hour_end) {
        this.hour_end = hour_end;
    }

    public String getHour_every() {
        return hour_every;
    }

    public void setHour_every(String hour_every) {
        this.hour_every = hour_every;
    }

    public String getMinute_start() {
        return minute_start;
    }

    public void setMinute_start(String minute_start) {
        this.minute_start = minute_start;
    }

    public String getMinute_end() {
        return minute_end;
    }

    public void setMinute_end(String minute_end) {
        this.minute_end = minute_end;
    }

    public String getMinute_every() {
        return minute_every;
    }

    public void setMinute_every(String minute_every) {
        this.minute_every = minute_every;
    }

    public String getSecond_start() {
        return second_start;
    }

    public void setSecond_start(String second_start) {
        this.second_start = second_start;
    }

    public String getSecond_end() {
        return second_end;
    }

    public void setSecond_end(String second_end) {
        this.second_end = second_end;
    }

    public String getSecond_every() {
        return second_every;
    }

    public void setSecond_every(String second_every) {
        this.second_every = second_every;
    }

    @Override
    public String toString() {
        return "Elements{" + "year_start=" + year_start + ", year_end=" + year_end + ", year_every=" + year_every + ", weekday_start=" + weekday_start + ", weekday_end=" + weekday_end + ", weekday_every=" + weekday_every + ", month_start=" + month_start + ", month_end=" + month_end + ", month_every=" + month_every + ", day_start=" + day_start + ", day_end=" + day_end + ", day_every=" + day_every + ", hour_start=" + hour_start + ", hour_end=" + hour_end + ", hour_every=" + hour_every + ", minute_start=" + minute_start + ", minute_end=" + minute_end + ", minute_every=" + minute_every + ", second_start=" + second_start + ", second_end=" + second_end + ", second_every=" + second_every + '}';
    }
    
}
