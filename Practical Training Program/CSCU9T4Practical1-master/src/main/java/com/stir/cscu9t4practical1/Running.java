package com.stir.cscu9t4practical1;

public class Running {
    private int runDistance;
    private int runRecover;

    public Running(int runDistance, int runRecover) {
        this.runDistance = runDistance;
        this.runRecover = runRecover;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public int getRunRecover() {
        return runRecover;
    }

    public String getRunning(){
        return "- Running Record - Distance: " + runDistance + "- Recover: " + runRecover;
    }
}
