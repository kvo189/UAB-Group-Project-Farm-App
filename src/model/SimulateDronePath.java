package model;


import controllers.SimulateDrone;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;

public abstract class SimulateDronePath implements SimulateDrone {
    private double XDestination;
    private double YDestination;

    public SimulateDronePath(){

    }

    public void SimulateDrone(double XDestination, double YDestination){
        this.XDestination = XDestination;
        this.YDestination = YDestination;
    }


    public void ScanFarm(int speed){

    }
    public void FlyLocation(int speed) {
        PathElement[] Path = {
                new MoveTo(-300, 300),
                new LineTo(XDestination, YDestination),
                new ClosePath()
        };
        setup(Path, speed, false);
    }
}
