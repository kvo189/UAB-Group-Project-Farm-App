package model;

import controllers.DroneCommands;

public class Drones implements DroneCommands {
    
    public Drones() {
        
    }
    public void BeginProgram() {
        Drones.launchInitialization();
    }
    public void EndProgram() {
        Drones.launchInitialization();
    }
    public void FlyUp(int up){
        if (up < 0 || up > 600)
            return;
        Drones.commandDrone("up"+up);
    }

    private static void commandDrone(String s) {
    }

    public void FlyDown(int down){
        if (down < 0 || down > 600)
            return;
        Drones.commandDrone("down"+down);
    }
    public void FlyForward(int forward){
        if (forward < 0 || forward > 600)
            return;
        Drones.commandDrone("forward"+forward);
    }
    public void FlyBackward(int backward){
        if (backward < 0 || backward > 600)
            return;
        Drones.commandDrone("backward"+backward);
    }
    public void FlyLeft(int left){
        if (left < 0 || left > 600)
            return;
        Drones.commandDrone("left"+left);
    }
    public void FlyRight(int right){
        if (right < 0 || right > 600)
            return;
        Drones.commandDrone("right"+right);
    }
    public void XYZ(int x, int y, int z, int speed){

    }
    public void SetSpeed(int speed){

    }
    public void GetSpeed(int speed){

    }
    public void Stop(){

    }

    private static void launchInitialization() {
    }
}
