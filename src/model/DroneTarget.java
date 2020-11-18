package model;

import java.util.ArrayList;

public class DroneTarget {

    private String targetObjective;
    private String targetName;
    private int targetX;
    private int targetY;
    private int targetZ;
    private String targetInfo;


    public DroneTarget (String targetObjective, String targetName, int targetX,
                        int targetY, int targetZ, String targetInfo)
    {
        this.targetName = targetName;
        this.targetX = targetX;
        this.targetY = targetY;
        this.targetZ = targetZ;
        this.targetInfo = targetInfo;
    }

    public String getTargetObjective() {return targetName;}
    public String getTargetName() {
        return targetName;
    }

    public int getTargetX(){
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public int getTargetZ() {
        return targetZ;
    }
    public String getInfoString(){ return targetInfo; };


    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public void setTargetX(int targetX){
        this.targetX = targetX;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }

    public void setTargetZ(int targetZ) {
        this.targetZ = targetZ;
    }

    public void setTargetInfo(String targetInfo){ this.targetInfo = targetInfo; }



}
