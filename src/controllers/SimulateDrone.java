package controllers;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.PathElement;

import java.awt.*;

public interface SimulateDrone {
    public void scanFarm(Node droneGraphic,double droneX, double droneY, double droneW, double droneL);

    public void flytoLocation(Node node, Point dronePos, Point targetPos);
}
