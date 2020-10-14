import controllers.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private static MainApp mainInstance;
    private Stage primaryStage;
    private BorderPane rootLayout;

    public MainApp () {
        super();
    };

    public static MainApp getInstance() {
        if (mainInstance == null) {
            mainInstance = new MainApp();
        }
        return mainInstance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainInstance = this;
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Farm App");
        initRootLayout();
    }
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
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