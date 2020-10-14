package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import model.Component;
import model.ItemContainer;

public class RootLayoutController {
    @FXML
    private TreeView<String> treeView;
    private static RootLayoutController rootLayout;
    private RootLayoutController() {}

    public static RootLayoutController getInstance() {
        if (rootLayout == null) {
            rootLayout = new RootLayoutController();
        }
        return rootLayout;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        TreeItem<String> root = new TreeItem<>("Farm");
        Component barn = new ItemContainer("Barn", 1000, 10, 15, 200, 100, 50);

        treeView.setRoot(root);
        root.setExpanded(true);
        TreeItem<String> barnNode = new TreeItem<>(barn.getName());
        root.getChildren().add(barnNode);

        treeView.getSelectionModel().selectedItemProperty().addListener( new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue,
                                Object newValue) {

                TreeItem<String> selectedItem = (TreeItem<String>) newValue;
                System.out.println("Selected Text : " + selectedItem.getValue());
                // do what ever you want
            }

        });
    }
}
