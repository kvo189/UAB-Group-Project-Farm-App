package controllers;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.awt.*;

public class SimulationDrone implements SimulateDrone {
    SimulationDrone(){

    }

    @Override
    public void scanFarm(int speed) {

    }

    @Override
    public void flytoLocation(Node node, Point dronePos, Point targetPos) {
        float droneX = (float) dronePos.x, droneY = (float) dronePos.y, targetX = (float) targetPos.x, targetY = (float) targetPos.y;
        double toX = -(droneX - targetX);
        double toY = -(droneY - targetY);

        SequentialTransition seq = new SequentialTransition();
        TranslateTransition translate = new TranslateTransition();
        TranslateTransition translate1 = new TranslateTransition();

        RotateTransition rt = new RotateTransition(Duration.millis(2000), node);
        rt.setToAngle(-getAngle(new Point((int)targetX,(int)targetY), droneX, droneY));
        rt.setCycleCount(1);
        rt.setAutoReverse(true);

        translate.setFromX(0);
        translate.setFromY(0);
        translate.setToX(toX);
        translate.setToY(toY);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(1);
        translate.setAutoReverse(true);
        translate.setNode(node);

        RotateTransition rt1 = new RotateTransition(Duration.millis(1000), node);
        rt1.setByAngle(180);
        rt1.setCycleCount(1);
        rt1.setAutoReverse(true);

        translate1.setFromX(toX);
        translate1.setFromY(toY);
        translate1.setToX(0);
        translate1.setToY(0);
        translate1.setDuration(Duration.millis(1000));
        translate1.setCycleCount(1);
        translate1.setAutoReverse(true);
        translate1.setNode(node);

        RotateTransition rt2 = new RotateTransition(Duration.millis(1000), node);
        rt2.setToAngle(0);
        rt2.setCycleCount(1);
        rt2.setAutoReverse(true);

        seq.getChildren().add(rt);
        seq.getChildren().add(translate);
        seq.getChildren().add(new PauseTransition(Duration.seconds(0.0)));
        seq.getChildren().add(rt1);
        seq.getChildren().add(translate1);
        seq.getChildren().add(rt2);
        seq.play();
    }

    @Override
    public void deleteDrone(ImageView drone) {

    }

    public void hover(int seconds){

    }

    public float getAngle(Point target, float x, float y) {
        float angle = (float) Math.toDegrees(Math.atan2(-(target.y - y),(target.x - x)));

        return angle;
    }
}
