package model;

import controllers.MultiRotorDrone;
import controllers.RootLayoutController;
import controllers.TelloDrone;

import java.io.IOException;

public class DroneAdapterClass extends MultiRotorDrone {
    Drone drone;

    public DroneAdapterClass(Drone Drone){
        this.drone = drone;
    }

    public void flyBackward(int back) throws IOException {

    }

    /***
     *
     * @param direction
     * @throws IOException
     */
    /*
    public void flip(String direction) throws IOException {

    }
    */
    /***
     *
     * @param seconds
     * @throws InterruptedException
     * @throws IOException
     */
    public void hoverInPlace(int seconds) throws InterruptedException, IOException {

    }

    public void setSpeed(int speed) throws IOException {

    }

    /***
     *
     * @return
     * @throws IOException
     * @throws NumberFormatException
     */
    public double getSpeed() throws NumberFormatException, IOException {
        return 0;
    }

    /***
     *
     * @return
     * @throws IOException
     * @throws NumberFormatException
     */
    public int getBattery() throws NumberFormatException, IOException {
        return 0;
    }

    public void takeoff() throws IOException {

    }

    /***
     * Sends the "land" signal to an active aircraft
     * Aircraft may land despite any obstacles below it or ahead
     * Make sure your landing area is clear
     * @throws IOException
     */
    public void land() throws IOException {

    }

    /***
     *
     * @param up
     * @throws IOException
     */
    public void increaseAltitude(int up) throws IOException {

    }

    /***
     *
     * @param down
     * @throws IOException
     */
    public void decreaseAltitude(int down) throws IOException {

    }

    /***
     *
     * @param front
     * @throws IOException
     */
    public void flyForward(int front) throws IOException {

    }

    /***
     *
     * @param left
     * @throws IOException
     */
    public void flyLeft(int left) throws IOException {

    }

    /***
     *
     * @param right
     * @throws IOException
     */
    public void flyRight(int right) throws IOException{

    }

    /***
     *
     * @param degrees
     * @throws IOException
     */
    public void turnCW(int degrees) throws IOException{

    }

    /***
     *
     * @param degrees
     * @throws IOException
     */
    public void turnCCW(int degrees) throws IOException{

    }

    /***
     *
     * @return
     * @throws IOException
     */
    public int getFlightTime() throws IOException{

    }

    /***
     *
     * @return
     * @throws IOException
     */
    public int getHeight() throws IOException{

    }

    /***
     *
     * @return
     * @throws IOException
     */
    public int getAttitudePitch() throws IOException{

    }

    /***
     *
     * @return
     * @throws IOException
     */
    public int getAttitudeRoll() throws IOException{

    }

    /***
     *
     * @return
     * @throws IOException
     */
    public int getAttitudeYaw() throws IOException{

    }

    /***
     * Gets aircraft's IMU angular acceleration data and returns the X component
     * @return double precision acceleration value based on SDK units
     * @throws IOException
     */
    public double getAccelerationX() throws IOException{

    }

    /***
     * Gets aircraft's IMU angular acceleration data and returns the Y component
     * @return double precision acceleration value based on SDK units
     * @throws IOException
     */
    public double getAccelerationY() throws IOException{

    }

    /***
     * Gets aircraft's IMU angular acceleration data and returns the Z component
     * @return double precision acceleration value based on SDK units
     * @throws IOException
     */
    public double getAccelerationZ() throws IOException{

    }

    /***
     *
     * @return
     * @throws IOException
     */
    public int getTOF() throws IOException{

    }

}
