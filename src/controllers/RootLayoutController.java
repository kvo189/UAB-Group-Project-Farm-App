package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

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
        treeView.setRoot(root);

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
