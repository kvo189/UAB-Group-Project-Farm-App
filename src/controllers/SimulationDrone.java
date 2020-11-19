package controllers;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.awt.*;

public class SimulationDrone implements SimulateDrone {
    private int hoverDuration;


    SimulationDrone(){

    }

    @Override
    public void scanFarm(Node droneGraphic,double droneX, double droneY, double droneW, double droneL) {
        int rootLength = Constants.FARMWIDTH;
        int rootWidth = Constants.FARMHEIGHT;

        Path path = new Path();

        double droneSpeed = 30;


        path.getElements().add(new MoveTo(droneW,droneL));
        path.getElements().add(new LineTo(-droneX + droneW, -droneY ));
        path.getElements().add(new VLineTo(rootLength - droneL - droneY));
        path.getElements().add(new HLineTo(droneW - droneX + droneW));
        path.getElements().add(new VLineTo(- droneY + droneL));

        for (int i = 100; i < rootWidth; i+=100) {
            path.getElements().add(new HLineTo(i - droneX + droneW));
            path.getElements().add(new VLineTo(rootLength -droneL - droneY));
            path.getElements().add(new HLineTo(i+droneW - droneX + droneW));
            path.getElements().add(new VLineTo(- droneY + droneL));
        }



        path.getElements().add(new LineTo(droneW, droneL));

        PathTransition pathTransition = new PathTransition();


        pathTransition.setDuration(Duration.millis(rootLength*(rootWidth/droneW)/(droneSpeed/droneL)));
        pathTransition.setPath(path);
        pathTransition.setNode(droneGraphic);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
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
        seq.getChildren().add(new PauseTransition(Duration.seconds(hoverDuration)));
        seq.getChildren().add(rt1);
        seq.getChildren().add(translate1);
        seq.getChildren().add(rt2);
        seq.play();
    }
/*
    @Override
    public void deleteDrone(ImageView drone) {

    }
*/
    public float getAngle(Point target, float x, float y) {
        float angle = (float) Math.toDegrees(Math.atan2(-(target.y - y),(target.x - x)));

        return angle;
    }
}
