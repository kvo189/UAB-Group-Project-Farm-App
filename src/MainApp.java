import controllers.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Drone;
import model.DroneTarget;

import java.io.IOException;




public class MainApp extends Application {

    private ObservableList<DroneTarget> droneTargetList = FXCollections.observableArrayList();

    private Stage primaryStage;



    droneTargetList.add(new DroneTarget());




    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        initRootLayout();
    }



    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            RootLayoutController rootLayoutController = RootLayoutController.getInstance();
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setController(rootLayoutController);
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            BorderPane rootLayout = loader.<BorderPane>load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Farm App");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        launch(args);



    }
}