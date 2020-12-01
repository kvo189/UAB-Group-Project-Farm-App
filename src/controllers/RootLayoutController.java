package controllers;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.*;
import model.Component;

import java.awt.*;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.function.UnaryOperator;

public class RootLayoutController<group> {
    //declare our variables

    //tree view to show the composite design pattern implementation....
    @FXML
    private TreeView<Component> treeView;
    //declare our text fields
    @FXML
    private TextField nameTextField, xTextField, yTextField, lTextField, wTextField, hTextField, priceTextField,
            marketValueTextField, purchasePriceTextField;

    //Save

    @FXML
    private Button saveBtn;

    @FXML
    private AnchorPane visualPane;
    private Drone drone = null;

    @FXML
    private ToggleGroup toggleButtonGroup1;
    @FXML
    private ToggleButton selectScanFarmToggleBtn;
    @FXML
    private ToggleButton selectVisitItemToggleBtn;

    //Danny
    private TelloDrone telloDrone;



    //This rectangle is blue and forms a box around the drone image. Drone image lives in this box. Together they are easy to see in clutter.
    private Rectangle droneGraphic;
    // Root Layout
    private static RootLayoutController rootLayout;
    //parameterless constructor for RootLayoutController
    private RootLayoutController() {}
    //This is drone.png, which is our depiction of our drone flying around.
    private final Image dronePng = new Image("drone.png");


    //toggle buttons glow when selected
    public Glow glowEffectScanFarmToggle = new Glow();
    public Glow glowEffectVisitItemToggle = new Glow();
    //Singleton pattern setup for RootLayoutController
    /**
     * Initializes an instance of the controller if one has not been created.
     * @return type object of this singleton class.
     */
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
        ItemContainer farm = new ItemContainer("Farm", 0, 0, 0, 800, 600, 0);
        ItemContainer barn = new ItemContainer("Barn", 1000, 10, 15, 200, 100, 50);
        Item cow = new Item("Cow", 1000, 30, 30, 35, 20, 20, 1000, 1000);
        barn.addComp(cow);
        farm.addComp(barn);

        TreeItem<Component> rootNode = new TreeItem<>(farm);
        TreeItem<Component> barnNode = new TreeItem<>(barn);
        TreeItem<Component> cowNode = new TreeItem<>(cow);

        treeView.setRoot(rootNode);
        treeView.getSelectionModel().selectFirst();
        rootNode.setExpanded(true);
        barnNode.setExpanded(true);

        barnNode.getChildren().add(cowNode);
        rootNode.getChildren().add(barnNode);

        drawComponents(rootNode);

        //Calibrating visual indication (Glow effect) for selected toggle buttons...glow = on, not glowing = off.
        selectVisitItemToggleBtn.setEffect(glowEffectVisitItemToggle);
        selectScanFarmToggleBtn.setEffect(glowEffectScanFarmToggle);
        glowEffectVisitItemToggle.setLevel(0.00);
        glowEffectScanFarmToggle.setLevel(0.65);

        //This is used to create the cells in our tree.
        treeView.setCellFactory(tv ->{
            TreeCell<Component> cell = new TreeCell<Component>() {
                @Override
                protected void updateItem(Component item, boolean empty) {
                    super.updateItem(item, empty);
                    textProperty().unbind();

                    if(empty){
                        setText(null);
                    }else{
                        textProperty().bind(item.nameProperty());

                    }
                }
            };

            // cell selected? If so...
            cell.selectedProperty().addListener((observable, prevSelected, newSelected) -> {
                Component cellItem = cell.getItem();
                //and if the selected cell is empty
                if (newSelected && (!cell.isEmpty())){
                    nameTextField.setText(cellItem.getName());
                    xTextField.setText(String.valueOf(cellItem.getLocationX()));
                    yTextField.setText(String.valueOf(cellItem.getLocationY()));
                    lTextField.setText(String.valueOf(cellItem.getLength()));
                    wTextField.setText(String.valueOf(cellItem.getWidth()));
                    hTextField.setText(String.valueOf(cellItem.getHeight()));
                    priceTextField.setText(String.valueOf(cellItem.getPrice()));
                    marketValueTextField.setText(String.valueOf(cellItem.accept(new MarketValueVisitor())));
                    purchasePriceTextField.setText(String.valueOf(cellItem.accept(new PurchasePriceVisitor())));

                    if (cellItem instanceof ItemContainer){
                        marketValueTextField.setDisable(true);
                    }else{
                        marketValueTextField.setDisable(false);
                    }
                }
            });

            return cell;
        });

        //Change values from text input
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();

            if (text.matches("[0-9]*")) {
                return change;
            }

            return null;
        };

        xTextField.setTextFormatter(new TextFormatter<>(filter));
        yTextField.setTextFormatter(new TextFormatter<>(filter));
        lTextField.setTextFormatter(new TextFormatter<>(filter));
        wTextField.setTextFormatter(new TextFormatter<>(filter));
        hTextField.setTextFormatter(new TextFormatter<>(filter));
        priceTextField.setTextFormatter(new TextFormatter<>(filter));
    }

    //Save objects after setting their values.
    @FXML
    private void handleSave() {
        int xVal = Integer.parseInt(xTextField.getText()),
                yVal = Integer.parseInt(yTextField.getText()),
                lengthVal = Integer.parseInt(lTextField.getText()),
                widthVal = Integer.parseInt(wTextField.getText()),
                heightVal = Integer.parseInt(hTextField.getText()),
                priceVal = Integer.parseInt(priceTextField.getText()),
                marketVal = Integer.parseInt(marketValueTextField.getText());


        //if the x or y coordinates are outside the bounds of the root (farm)
        int rootLength = treeView.getRoot().getValue().getLength();
        int rootWidth = treeView.getRoot().getValue().getWidth();

        if (xVal > rootWidth || yVal > rootLength) {
            showErrorDialog("Invalid Input", "Invalid position value(s)", "X cannot be larger than 600 and Y cannot be larger than 800!");
            return;
        }

        // make sure that the item's width doesn't make its edge(s) go out of bounds of the farm
        if (xVal+widthVal > rootWidth || yVal+lengthVal > rootLength) {
            showErrorDialog("Invalid Input", "Invalid size value(s)", "X + Width cannot be larger than 600 and Y + Length cannot be larger than 800!");
            return;
        }

        //if the item is the root item (the farm), prevent it from being modified and throw an error.
        if(treeView.getSelectionModel().getSelectedItem().getParent() == null) {
            showErrorDialog("Invalid Operation", null, "Root item cannot be modified!");
            return;
        }

        //set values of tree root and draw
        Component item = treeView.getSelectionModel().getSelectedItem().getValue();
        item.setName(nameTextField.getText());
        item.setLocationX(xVal);
        item.setLocationY(yVal);
        item.setLength(lengthVal);
        item.setWidth(widthVal);
        item.setHeight(heightVal);
        item.setPrice(priceVal);
        item.setMarketValue(marketVal);
        visualPane.getChildren().clear();
        drawComponents(treeView.getRoot());
    }

    //Add new items to item containers
    @FXML
    private void handleAddItem() {
        TreeItem<Component> selectedTreeItem = treeView.getSelectionModel().getSelectedItem();
        if (selectedTreeItem.getValue() instanceof ItemContainer){
            Item newItem = new Item("ITEM", 0, selectedTreeItem.getValue().getLocationX(), selectedTreeItem.getValue().getLocationY(), ((ItemContainer) selectedTreeItem.getValue()).getHeight(), 20, 20, 1000, 1000);
            TreeItem<Component> newItemNode = new TreeItem<>(newItem);
            selectedTreeItem.getValue().addComp(newItem);
            selectedTreeItem.getChildren().add(newItemNode);
            visualPane.getChildren().clear();
            drawComponents(treeView.getRoot());
        }else{
            showErrorDialog("Invalid Operation", null, "\"Add Item\" can only be performed on Item Containers!");
        }
    }

    // Add a new item container
    @FXML
    private void handleAddItemContainer() {
        TreeItem<Component> selectedTreeItem = treeView.getSelectionModel().getSelectedItem();
        if (selectedTreeItem.getValue() instanceof ItemContainer){
            ItemContainer newItemContainer = new ItemContainer("ITEM CONTAINER", 0, selectedTreeItem.getValue().getLocationX(), selectedTreeItem.getValue().getLocationY(), 0, 0, 0);
            TreeItem<Component> newItemContainerNode = new TreeItem<>(newItemContainer);
            newItemContainerNode.setExpanded(true);
            selectedTreeItem.getValue().addComp(newItemContainer);
            selectedTreeItem.getChildren().add(newItemContainerNode);
            visualPane.getChildren().clear();
            drawComponents(treeView.getRoot());
        }else{
            showErrorDialog("Invalid Operation", null, "\"Add Item\" can only be performed on Item Containers!");
        }
    }

    // Delete a Component
    @FXML
    private void handleDelete() {
        TreeItem<Component> selectedTreeItem = treeView.getSelectionModel().getSelectedItem();
        if (!(selectedTreeItem.getParent() == null)) {
            //if delete is performed on drone, then set the instance variables to null
            if (selectedTreeItem.getValue() instanceof Drone){
                drone = null;
                droneGraphic = null;
            }
            selectedTreeItem.getParent().getValue().removeComp(selectedTreeItem.getValue());
            selectedTreeItem.getParent().getChildren().remove(selectedTreeItem);
            visualPane.getChildren().clear();
            drawComponents(treeView.getRoot());
        }else{
            showErrorDialog("Invalid Operation", null, "Root item cannot be modified!");
        }
    }

    //Have the drone scan the farm, row by row.
    @FXML
    private void handleScanFarm () {

        //track the dimensions of root container to use for calculating time of drone flight
        //int rootLength and rootWidth are the length and width of farm
        if (drone == null || droneGraphic == null) {
            showErrorDialog("Invalid Operation", null, "\"Scan farm\" can only be performed when a drone component exists!");
            return;
        }

        int droneX = drone.getLocationX();
        int droneY = drone.getLocationY();
        double droneW = (double)drone.getWidth()/2;
        double droneL = (double)drone.getLength()/2;

        SimulationDrone drone = new SimulationDrone();
        drone.scanFarm(droneGraphic, droneX, droneY, droneW, droneL);
    }

    //TODO COMPLETE THIS
    @FXML
    public void handleSelectScanFarm(){
        selectScanFarmToggleBtn.setStyle("-fx-background-color : GREEN");
        selectVisitItemToggleBtn.setStyle("-fx-background-color: darkslategray");
        glowEffectVisitItemToggle.setLevel(0.00);
        glowEffectScanFarmToggle.setLevel(0.65);
    }

    //TODO COMPLETE THIS
    @FXML
    public void handleSelectVisitItem(){
        selectVisitItemToggleBtn.setStyle("-fx-background-color : GREEN");
        selectScanFarmToggleBtn.setStyle("-fx-background-color: darkslategray");
        glowEffectVisitItemToggle.setLevel(0.65);
        glowEffectScanFarmToggle.setLevel(0.00);
    }
    //Danny
    // Add a new drone to the farm.
    //TODO COMPLETE THIS
    @FXML
    public void handleLaunchSimulation(){
        if (selectScanFarmToggleBtn.isSelected()){
            handleScanFarm();
        } else {
            handleVisitItem();
        };
    }
    //Danny
    //TODO COMPLETE THIS
    @FXML
    private void handleLaunchDrone(){
        System.out.println("Physical drone launch selected, but this is commented out due to lack of access to physical drone.");
        /*

        DroneAdapter adaptedDrone = new DroneAdapter(telloDrone);
        if (drone == null || telloDrone == null) {
            showErrorDialog("Invalid Operation", null, "\"Visit Item/Item Containers\" can only be performed when a drone component exists!");
            return;
        }

        if (selectScanFarmToggleBtn.isSelected()){
            int droneX = drone.getLocationX();
            int droneY = drone.getLocationY();
            double droneW = (double)drone.getWidth()/2;
            double droneL = (double)drone.getLength()/2;

            adaptedDrone.scanFarm(droneGraphic, droneX, droneY, droneW, droneL);
        } else {
            TreeItem<Component> selectedTreeItem = treeView.getSelectionModel().getSelectedItem();
            int droneX = drone.getLocationX() + drone.getWidth()/2;
            int droneY = drone.getLocationY() + drone.getLength()/2;
            int targetX = selectedTreeItem.getValue().getLocationX() + selectedTreeItem.getValue().getWidth()/2;
            int targetY = selectedTreeItem.getValue().getLocationY() + selectedTreeItem.getValue().getLength()/2;

            adaptedDrone.flytoLocation(droneGraphic, new Point(droneX, droneY), new Point(targetX, targetY));
        };

        */

    }
    //add a new drone to the farm
    @FXML
    private void handleAddDrone () {
        if (drone != null){
            showErrorDialog("Invalid Operation", null, "\"Add Drone\" can only be performed if no drone exists!");
            return;
        }
        TreeItem<Component> selectedTreeItem = treeView.getSelectionModel().getSelectedItem();
        if (selectedTreeItem.getValue() instanceof ItemContainer){
            drone = new Drone("Drone", 0, selectedTreeItem.getValue().getLocationX(), selectedTreeItem.getValue().getLocationY(), 50, 50, 5, 5);
            TreeItem<Component> droneNode = new TreeItem<>(drone);
            selectedTreeItem.getValue().addComp(drone);
            selectedTreeItem.getChildren().add(droneNode);
            visualPane.getChildren().clear();
            drawComponents(treeView.getRoot());

            //Danny
            try{
                telloDrone = new TelloDrone();
            } catch (Exception e){
                System.out.println(e.toString());
            }

        }else{
            showErrorDialog("Invalid Operation", null, "\"Add Item\" can only be performed on Item Containers!");
        }
    }

    // Have the drone fly to an item and back.
    @FXML
    private void handleVisitItem () {
        if (drone == null) {
            showErrorDialog("Invalid Operation", null, "\"Visit Item/Item Containers\" can only be performed when a drone component exists!");
            return;
        }
//        MultiRotorDrone droneAdapter = new DroneAdapter(droneGraphic);
        TreeItem<Component> selectedTreeItem = treeView.getSelectionModel().getSelectedItem();
        int droneX = drone.getLocationX() + drone.getWidth()/2;
        int droneY = drone.getLocationY() + drone.getLength()/2;
        int targetX = selectedTreeItem.getValue().getLocationX() + selectedTreeItem.getValue().getWidth()/2;
        int targetY = selectedTreeItem.getValue().getLocationY() + selectedTreeItem.getValue().getLength()/2;

        SimulationDrone drone = new SimulationDrone();

        drone.flytoLocation(droneGraphic,new Point(droneX,droneY), new Point(targetX,targetY));
    }

    public float getAngle(Point target, float x, float y) {
        float angle = (float) Math.toDegrees(Math.atan2(-(target.y - y),(target.x - x)));

        return angle;
    }

    //draw a new component's rectangular outline for display on the dashboard overview.
    private void drawComponent (String name, int x, int y, int length, int width, Color color) {
        Rectangle rectangle = new Rectangle(width,length, Color.TRANSPARENT);
        rectangle.setStroke(color);
        rectangle.setStrokeWidth(2);
        rectangle.relocate(x,y);

        Text text = new Text();
        text.setText(name);
        text.setX((double)(x+width/2) - text.getLayoutBounds().getWidth()/2);
        text.setY((double)(y+length/2) + text.getLayoutBounds().getHeight()/2);

        visualPane.getChildren().addAll(rectangle,text);
    }

    //draw the drone's outline rectangle and also show its icon within the rectangle.
    private void drawDrone (int x, int y, int length, int width) {
        Rectangle rectangle = new Rectangle(width,length, Color.TRANSPARENT);
        droneGraphic = rectangle;
        //ImageView droneImageView = new ImageView(new Image("drone.png");
        rectangle.setStroke(Color.BLUE);
        rectangle.setStrokeWidth(2);
        rectangle.relocate(x,y);
        rectangle.setFill(new ImagePattern(dronePng));
        visualPane.getChildren().add(rectangle);
    }

    private void drawComponents(TreeItem<Component> root){
        drawComponent(root.getValue().getName(),
                root.getValue().getLocationX(),
                root.getValue().getLocationY(),
                root.getValue().getLength(),
                root.getValue().getWidth(),
                Color.GREEN);
        for(TreeItem<Component> child: root.getChildren()){
            if (child.getValue() instanceof Drone){
                drawDrone(child.getValue().getLocationX(),
                        child.getValue().getLocationY(),
                        child.getValue().getLength(),
                        child.getValue().getWidth());
                continue;
            }
            if(child.getChildren().isEmpty()){
                drawComponent(child.getValue().getName(),
                        child.getValue().getLocationX(),
                        child.getValue().getLocationY(),
                        child.getValue().getLength(),
                        child.getValue().getWidth(),
                        Color.RED);
            } else {
                drawComponents(child);
            }
        }
    }

    //Throw an error.
    private void showErrorDialog (String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
