import controllers.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<String> droneObjectiveList = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        initRootLayout();
    }

    public ObservableList<String> getDroneObjective() {
        return droneObjectiveList;
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
            rootLayout = loader.load();

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