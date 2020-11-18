package controllers;

import model.Drone;

import java.awt.*;
import java.io.IOException;

public class DroneAdapter extends MultiRotorDrone {
    private final SimulateDrone simulateDrone;

    public DroneAdapter(SimulateDrone drone){
        this.simulateDrone = drone;
    }

    @Override
    public void flyBackward(int back) throws IOException {
        
    }

    @Override
    public void flip(String direction) throws IOException {

    }

    @Override
    public void hoverInPlace(int seconds){
        simulateDrone.setHoverDuration(seconds);
    }

    @Override
    public void takeoff() throws IOException {

    }

    @Override
    public void land() throws IOException {

    }

    @Override
    public void increaseAltitude(int up) throws IOException {

    }

    @Override
    public void decreaseAltitude(int down) throws IOException {

    }

    @Override
    public void flyForward(int front) throws IOException {
        //needs implementation
    }

    @Override
    public void flyLeft(int left) throws IOException {
        //needs implementation
    }

    @Override
    public void flyRight(int right) throws IOException {
        //needs implementation
    }

    @Override
    public void turnCW(int degrees) throws IOException {
        //needs implementation
    }

    @Override
    public void turnCCW(int degrees) throws IOException {
        //needs implementation
    }

    @Override
    public int getFlightTime() throws IOException {
        return 0;
    }

    @Override
    public int getHeight() throws IOException {
        return 0;
    }

    @Override
    public int getAttitudePitch() throws IOException {
        return 0;
    }

    @Override
    public int getAttitudeRoll() throws IOException {
        return 0;
    }

    @Override
    public int getAttitudeYaw() throws IOException {
        return 0;
    }

    @Override
    public double getAccelerationX() throws IOException {
        return 0;
    }

    @Override
    public double getAccelerationY() throws IOException {
        return 0;
    }

    @Override
    public double getAccelerationZ() throws IOException {
        return 0;
    }

    @Override
    public int getTOF() throws IOException {
        return 0;
    }

    @Override
    public void setSpeed(int speed) throws IOException {

    }

    @Override
    public double getSpeed() throws NumberFormatException, IOException {
        return 0;
    }

    @Override
    public int getBattery() throws NumberFormatException, IOException {
        return 0;
    }
}
