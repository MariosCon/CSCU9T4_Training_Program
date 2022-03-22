// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class Entry {
  private String name;
  private Calendar dateAndTime;
  private float distance;

  private Running runningRecord;
  private Cycling cyclingRecord;
  private Swimming swimmingRecord;
  
  public Entry (String n, int d, int m, int y, int h, int min, int s, float dist,
                int runDistance,int runRecover,int cyclingDistance,String cyclingTerrain,int cyclingTime,int swimmingDistance,int swimmingTime,boolean swimPlace) {

    //Create Athlete Record
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;

    //Create Triathlete Record

    //Running record
    runningRecord = new Running(runDistance,runRecover);
    //Cycling Record
    cyclingRecord = new Cycling(cyclingDistance,cyclingTerrain,cyclingTime);
    //Swimming Record
    swimmingRecord = new Swimming(swimmingDistance,swimmingTime,swimPlace);
  } //constructor
  
  public String getName () {
    return name;
  } //getName
  
  public int getDay () {
    return dateAndTime.get(Calendar.DATE);
  } //getDay
  
  public int getMonth () {
    int month =  dateAndTime.get(Calendar.MONTH) + 1;
    return month;
  } //getMonth
  
  public int getYear () {
    return dateAndTime.get(Calendar.YEAR);
  } //getYear

  public int getHour () {
    return dateAndTime.get(Calendar.HOUR);
  } //getHour

  public int getMin () {
    return dateAndTime.get(Calendar.MINUTE);
  } //getMin

  public int getSec () {
    return dateAndTime.get(Calendar.SECOND);
  } //getSec

  public float getDistance () {
    return distance;
  } //getYear

  public String getEntry () {
   String result = "Athlete: " + getName()+"- Distance: " + getDistance() + " km- Time: "
             +getHour()+":"+getMin()+":"+ getSec() + "- Date: "
             +getDay()+"/"+getMonth()+"/"+getYear() + getTriathleteRecords();
   return result;
  } //getEntry

  public String getTriathleteRecords(){
    String record = runningRecord.getRunning() + cyclingRecord.getCycling() + swimmingRecord.getSwimming();
    return record;
  }
   
} // Entry