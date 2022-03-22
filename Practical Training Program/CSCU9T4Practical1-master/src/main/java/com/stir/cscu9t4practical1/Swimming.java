package com.stir.cscu9t4practical1;

public class Swimming {
    private int swimmingDistance;
    private int swimmingTime;
    private boolean swimPlace;

    public Swimming(int swimmingDistance, int swimmingTime, boolean swimPlace) {
        this.swimmingDistance = swimmingDistance;
        this.swimmingTime = swimmingTime;
        this.swimPlace = swimPlace;
    }

    public int getSwimmingDistance() {
        return swimmingDistance;
    }

    public int getSwimmingTime() {
        return swimmingTime;
    }

    public boolean isSwimPlace() {
        return swimPlace;
    }

    public String getSwimming(){
        String place;

        if(swimPlace){
            place = "Pool";
        } else {
            place = "Outdoor";
        }

        return "- Swimming Record - Distance: " + swimmingDistance + "- Time: " + swimmingTime + "- Place: " + place;
    }
}
