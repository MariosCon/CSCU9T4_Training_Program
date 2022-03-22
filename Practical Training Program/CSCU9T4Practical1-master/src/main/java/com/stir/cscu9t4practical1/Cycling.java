package com.stir.cscu9t4practical1;

public class Cycling {
    private int cyclingDistance;
    private String cyclingTerrain;
    private int cyclingTime;

    public Cycling(int cyclingDistance, String cyclingTerritory, int cyclingTime) {
        this.cyclingDistance = cyclingDistance;
        this.cyclingTerrain = cyclingTerritory;
        this.cyclingTime = cyclingTime;
    }

    public int getCyclingDistance() {
        return cyclingDistance;
    }

    public String getCyclingTerritory() {
        return cyclingTerrain;
    }

    public int getCyclingTime() {
        return cyclingTime;
    }

    public String getCycling(){
        return "- Cycling Record - Distance: " + cyclingDistance + "- Territory: " + cyclingTerrain + "- Time: " + cyclingTime;
    }
}
