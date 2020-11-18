package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class DroneTarget {

    private final StringProperty targetObjective;
    private final StringProperty targetName;
    private final IntegerProperty targetX;
    private final IntegerProperty targetY;
    private final IntegerProperty targetZ;
    private final StringProperty targetInfo;

    //this goes here
    public DroneTarget() {
        this(null, null, 0, 0, 0, null);
    }



    public DroneTarget (String targetObjective, String targetName, int targetX,
                        int targetY, int targetZ, String targetInfo)
    {
        this.targetObjective = new SimpleStringProperty(targetObjective);
        this.targetName = new SimpleStringProperty(targetName);
        this.targetX = new SimpleIntegerProperty(targetX);
        this.targetY = new SimpleIntegerProperty(targetY);
        this.targetZ = new SimpleIntegerProperty(targetZ);
        this.targetInfo = new SimpleStringProperty(targetInfo);
    }


    public String getTargetObjective(){ return targetObjective.get(); }
    public String getTargetName(){ return targetName.get(); }
    public int getTargetX(){ return targetX.get(); }
    public int getTargetY(){ return targetY.get(); }
    public int getTargetZ(){ return targetZ.get(); }
    public String getTargetInfo(){ return targetInfo.get(); }

    public void setTargetObjective(String targetObjective) { this.targetObjective.set(targetObjective); }
    public void setTargetName(String targetName) { this.targetName.set(targetName); }
    public void setTargetX(int targetX) { this.targetX.set(targetX); }
    public void setTargetY(int targetY) { this.targetY.set(targetY); }
    public void setTargetZ(int targetZ) { this.targetZ.set(targetZ); }
    public void setTargetInfo(String targetInfo) { this.targetInfo.set(targetInfo); }


    public StringProperty targetNameProperty() { return targetName; }
    public StringProperty targetInfoProperty(){ return targetInfo; };
    public StringProperty getTargetObjectiveProperty() {return targetObjective;}
    public IntegerProperty targetXProperty() { return targetX; }
    public IntegerProperty targetYProperty(){ return targetY; };
    public IntegerProperty targetZProperty() {return targetZ;}



}
