package model;

public class DroneAnimation {
    Drone drone;

    public DroneAnimation(Drone Drone){
        this.drone = drone;
    }

    public void droneMoveTo(){
        if(facing up){

        } else if(facing right){

        } else if(facing down){

        } else if(facing left){

        }
    }

    public void droneTurn(){
        RotateTransition rotateTransition = new RotationTransition(Duration.seconds(3), drone)
    }

}
