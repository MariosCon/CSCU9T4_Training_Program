// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;

public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass

    //Method to remove an entry from the list
    public void removeEntry(String name, int day, int month, int year){
        for (int i=0;i<getNumberOfEntries();i++){
            //check if the current entry is the same
            if(tr.get(i).getName().equals(name) && tr.get(i).getDay() == day && tr.get(i).getMonth() == month && tr.get(i).getYear() == year){
                tr.remove(i);
                return;
            }
        }
    }
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
        return lookUpEntry(d,m,y,false);
   } // lookupEntry

    //look up all the entries of a given day and month
    public String lookUpEntry(int d, int m, int y, boolean allEntries){
        ListIterator<Entry> iter = tr.listIterator();
        String result = "";

        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
                //Check if must find all entries
                if(allEntries){
                    result += current.getEntry() + "\n";
                } else {    //Single entry
                    result = current.getEntry();
                }
        }

        //Check if there are no results
        if(result.equals("")){
            result = "No entries found";
        }

        return result;
    }

    //Check if an entry already exists and return a boolean
    public boolean CheckIfRecordExists(String n, int m,int d, int y){

        //Loop through all the entries to check if already exist
        for(int i=0;i<getNumberOfEntries();i++){
            //Get the selected entry values
            String entryName = tr.get(i).getName();
            int entryDay = tr.get(i).getDay();
            int entryMonth = tr.get(i).getMonth();
            int entryYear = tr.get(i).getYear();

            //Check if the values are the same
            if(entryName.equals(n) && entryDay == d && entryMonth == m && entryYear == y){
                return true;    //entry is the same
            }
        }

        return false;
    }

   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord