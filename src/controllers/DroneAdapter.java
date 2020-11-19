package controllers;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.util.Duration;
import model.Drone;

import java.awt.*;
import java.io.IOException;

public class DroneAdapter implements SimulateDrone {
    private final TelloDrone telloDrone;
    private final int defaultDroneSpeed;
    private final int convertPxToCm;

    public DroneAdapter(TelloDrone telloDrone) {
        this.telloDrone = telloDrone;
        this.defaultDroneSpeed = 150;
        this.convertPxToCm = Constants.CENTIMETERS_PER_MODEL_FOOT/Constants.PIXELS_TO_ONE_MODEL_FOOT;
    }

    public void scanFarm(Node droneGraphic,double droneX, double droneY, double droneW, double droneL) {
        int farmHeight = Constants.MODELHEIGHT * 30;
        int farmWidth = Constants.MODELWIDTH * 30;
        try{
            //send drone to farm corner
            telloDrone.takeoff();
            telloDrone.increaseAltitude(1500);
            telloDrone.gotoXY(0, farmHeight,defaultDroneSpeed);

            //begin longitudinal farm scan
            int widthTravelCm = 120;
            int totalWidthTravelledCm = 120;
            while(totalWidthTravelledCm < farmWidth){
                telloDrone.flyForward(farmHeight);
                telloDrone.turnCCW(90);
                telloDrone.flyForward(widthTravelCm);

                totalWidthTravelledCm += widthTravelCm; //add

                telloDrone.turnCCW(90);
                telloDrone.flyForward(farmHeight);

                if(totalWidthTravelledCm > farmWidth){ //check if drone has gone past farm limits
                    break;
                }

                telloDrone.turnCW(90);
                telloDrone.flyForward(widthTravelCm);

                totalWidthTravelledCm += widthTravelCm; //add

                telloDrone.turnCW(90);
            }
            //return drone to original spot
            telloDrone.gotoXY((int)droneX * convertPxToCm, (int)droneY * convertPxToCm, defaultDroneSpeed);
            telloDrone.decreaseAltitude(1500);
            telloDrone.land();
        } catch(IOException ex){
            System.out.println (ex.toString());
        }
    }

    public void flytoLocation(Node node, Point dronePos, Point targetPos){
        try{
            telloDrone.takeoff();
            telloDrone.increaseAltitude(1500);
            telloDrone.gotoXY(targetPos.x * convertPxToCm,targetPos.y * convertPxToCm, defaultDroneSpeed);
            telloDrone.turnCW(360);
            telloDrone.hoverInPlace(10);

            telloDrone.gotoXY(dronePos.x * convertPxToCm,dronePos.y * convertPxToCm, defaultDroneSpeed);
            telloDrone.decreaseAltitude(1500);
            telloDrone.land();
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}