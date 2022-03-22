// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    //Athlete Text Fields
    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    //Athlete Labels
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");

    //Running labels
    private JLabel runDistanceLabel = new JLabel("Distance (m):");
    private JLabel runRecoverLabel = new JLabel("Recover minutes:");

    //Running Text Fields
    private JTextField runDist = new JTextField(4);
    private JTextField runRecover = new JTextField(2);

    //Cycle labels
    private JLabel cycleDistanceLabel = new JLabel("Distance (m):");
    private JLabel cycleTerrainLabel = new JLabel("Terrain:");
    private JLabel cycleTimeLabel = new JLabel("Time (sec):");

    //Cycle Text Fields
    private JTextField cycleDist = new JTextField(4);
    private JTextField cycleTerrain = new JTextField(4);
    private JTextField cycleTime = new JTextField(2);

    //Swim labels
    private JLabel swimDistanceLabel = new JLabel("Distance (m):");
    private JLabel swimTimeLabel = new JLabel("Time (sec):");
    private JLabel swimPlaceLabel = new JLabel("Pool?");

    //Swim Text Fields
    private JTextField swimDist = new JTextField(4);
    private JTextField swimTime = new JTextField(2);
    private JCheckBox swimPlace = new JCheckBox();

    //Title labels
    private JLabel athleteTitleLabel = new JLabel("Athlete Details:");
    private JLabel runTitleLabel = new JLabel("Running/Sprint Record:");
    private JLabel cycleTitleLabel = new JLabel("Cycle Record:");
    private JLabel swimTitleLabel = new JLabel("Swim Record:");

    //Buttons
    private JButton addR = new JButton("Add");
    private JButton removeButton = new JButton("Remove Entry");
    private JButton lookUpByDate = new JButton("Look Up Single Entry");
    private JButton FindAllByDate = new JButton("Look Up All Entries");

    //Training Record
    private TrainingRecord myAthletes = new TrainingRecord();

    //Text Area
    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());

        //Athlete title
        add(athleteTitleLabel);
        athleteTitleLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        athleteTitleLabel.setForeground(Color.BLACK);

        //Athlete Text Labels
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);

        //Running Title
        add(runTitleLabel);
        runTitleLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        runTitleLabel.setForeground(Color.BLACK);

        //Running Text Labels
        add(runDistanceLabel);
        add(runDist);
        runDist.setEditable(true);
        add(runRecoverLabel);
        add(runRecover);
        runDist.setEditable(true);

        //Cycle Title
        add(cycleTitleLabel);
        cycleTitleLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        cycleTitleLabel.setForeground(Color.BLACK);

        //Cycle Text Labels
        add(cycleDistanceLabel);
        add(cycleDist);
        cycleDist.setEditable(true);
        add(cycleTerrainLabel);
        add(cycleTerrain);
        cycleTerrain.setEditable(true);
        add(cycleTimeLabel);
        add(cycleTime);
        cycleTime.setEditable(true);

        //Swimming Title Labels
        add(swimTitleLabel);
        swimTitleLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        swimTitleLabel.setForeground(Color.BLACK);

        //Swimming Text Labels
        add(swimDistanceLabel);
        add(swimDist);
        swimDist.setEditable(true);
        add(swimTimeLabel);
        add(swimTime);
        swimTime.setEditable(true);
        add(swimPlaceLabel);
        add(swimPlace);

        //Output Area
        add(outputArea);
        outputArea.setEditable(false);

        //Buttons
        add(addR);
        addR.addActionListener(this);
        add(removeButton);
        removeButton.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);

        enableButtons(false);

        //Frame options
        setSize(1500, 300); //Frame size
        setLocationRelativeTo(null);    //Center the GUI window
        setVisible(true);
        blankDisplay();

        //Close the program if the x is pressed. If this is not implemented the code will still run
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if(event.getSource() == removeButton){
            message = RemoveEntry();
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == FindAllByDate) {
            message = LookAllEntries();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    //Method to check if there are any entries and disable or enable the buttons
    public void CheckEntryNumber(){
        //If the list is empty
        if(myAthletes.getNumberOfEntries() < 1){
            enableButtons(false);
        } else {
            enableButtons(true);
        }
    }

    //Method to enable or disable the buttons
    public void enableButtons(boolean enable){
        removeButton.setEnabled(enable);
        lookUpByDate.setEnabled(enable);
        FindAllByDate.setEnabled(enable);
    }

    public String addEntry(String what) {
        String message = "";

        //Check if the athlete name is valid or return an error message
        if(!CheckNameValid(name.getText())){
            return message = "Name cannot be empty. Try again.";
        }

        //Check if the athlete's numeric inputs are valid and not contain string or return an error message
        if(!CheckAthleteValues()){
            return message = "Athlete input contains string or its empty. Try again.";
        }

        //Check if the
        if(!CheckTerrainValid(cycleTerrain.getText())){
            return message = "Terrain cannot be empty. Try again.";
        }

        //Check if the triathlete numeric inputs are valid and not contain string or return an error message
        if(!CheckAllSportValues()){
            return message = "Sport input contains string or its empty. Try again.";
        }

        //Parse the Athlete values
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());

        //Parse the Sports values
        int runDistance = Integer.parseInt(runDist.getText());
        int runRec = Integer.parseInt(runRecover.getText());
        int cycleDistance = Integer.parseInt(cycleDist.getText());
        String cycleTerr = cycleTerrain.getText();
        int cycleT = Integer.parseInt(cycleTime.getText());
        int swimDistance = Integer.parseInt(swimDist.getText());
        int swimT= Integer.parseInt(swimTime.getText());
        boolean swimPlc = swimPlace.isSelected();

        //Check if the entry already exists and return error if exists
        if(myAthletes.CheckIfRecordExists(n,m,d,y)){
            return "This record already exists. Try to add a different one";
        }

        message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");

        Entry e = new Entry(n, d, m, y, h, mm, s, km,runDistance,runRec,cycleDistance,cycleTerr,cycleT,swimDistance,swimT,swimPlc);
        myAthletes.addEntry(e);

        //Check the entry number and enable the buttons
        CheckEntryNumber();

        return message;
    }

    //Method to remove an athlete entry using the name day month and year
    public String RemoveEntry(){
        String message = "";
        //Parse the name
        String n = name.getText();

        //Check if the name is valid or return an error message
        if(!CheckNameValid(n)){
            return message = "Name cannot be empty. Try again.";
        }

        //Check if the input is correct and return error if are not
        if(!CheckInputValues()){
            return "Numeric inputs contains string or are empty. Try again.";
        }

        //Parse the values
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());

        //Check if the entry record does not exist
        if(!myAthletes.CheckIfRecordExists(n,m,d,y)){
            return "This entry does not exist. Try to remove a different one";
        }

        myAthletes.removeEntry(n,d,m,y);

        //Check if there are any entries available or disable the buttons
        CheckEntryNumber();

        return message = "Entry successfully removed";
    }

    //Method to get the last athlete entry using the month day and year
    public String lookupEntry() {
        //Check if the input is correct and return error if are not
        if(!CheckInputValues()){
            return "Input contains string or is empty. Try again.";
        }

        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    //Method to get all athlete entry using the month day and year
    public String LookAllEntries(){
        //Check if the input is correct and return error if are not
        if(!CheckInputValues()){
            return "Input contains string or is empty. Try again.";
        }

        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookUpEntry(d,m,y,true);
        return message;
    }

    //Method to check if the name input is not null or empty and return bool
    public boolean CheckNameValid(String name){
        if(name == null || name.equals("")){
            return false;
        }
        return true;
    }

    //Method to check the month day and year values are correct and not contain any string and return true if are correct
    public boolean CheckInputValues(){
        int intValue;

        try {
            intValue = Integer.parseInt(month.getText());
            intValue = Integer.parseInt(day.getText());
            intValue = Integer.parseInt(year.getText());
            return true;    //correct values
        } catch (NumberFormatException e){
        }

        return false;   //not correct
    }

    //Method to check the athlete input values are correct and not contain any string and return true if they are correct
    public boolean CheckAthleteValues(){
        int intValue;
        float floatValue;

        try {
            intValue = Integer.parseInt(month.getText());
            intValue = Integer.parseInt(day.getText());
            intValue = Integer.parseInt(year.getText());
            floatValue = java.lang.Float.parseFloat(dist.getText());
            intValue = Integer.parseInt(hours.getText());
            intValue = Integer.parseInt(mins.getText());
            intValue = Integer.parseInt(secs.getText());

            return true;    //correct values
        } catch (NumberFormatException e){
        }

        return false;   //not correct
    }

    //Method to check if the terrain input is not null or empty and return bool
    public boolean CheckTerrainValid(String terrain){
        if(terrain == null || terrain.equals("")){
            return false;
        }
        return true;
    }

    //Method to check the triathlete sport input values are correct and not contain any string and return true if they are correct
    public boolean CheckAllSportValues(){
        int intValue;

        try{
            intValue = Integer.parseInt(runDist.getText());
            intValue = Integer.parseInt(runRecover.getText());
            intValue = Integer.parseInt(cycleDist.getText());
            intValue = Integer.parseInt(cycleTime.getText());
            intValue = Integer.parseInt(swimDist.getText());
            intValue= Integer.parseInt(swimTime.getText());
            return true;    //correct values
        } catch (NumberFormatException e){
        }

        return false;   //not correct
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        runDist.setText("");
        runRecover.setText("");
        cycleDist.setText("");
        cycleTerrain.setText("");
        cycleTime.setText("");
        swimDist.setText("");
        swimTime.setText("");
        swimPlace.setSelected(false);
    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

