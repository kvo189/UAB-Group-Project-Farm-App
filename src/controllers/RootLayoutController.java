package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Component;
import model.Item;
import model.ItemContainer;

import java.util.Iterator;
import java.util.function.UnaryOperator;

public class RootLayoutController {
    @FXML
    private TreeView<Component> treeView;
    @FXML
    private TextField nameTextField, xTextField, yTextField, lTextField, wTextField, hTextField, priceTextField;
    @FXML
    private Button saveBtn;
    @FXML
    private AnchorPane visualPane;

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
        ItemContainer farm = new ItemContainer("Farm", 0, 0, 0, 800, 600, 0);
        ItemContainer barn = new ItemContainer("Barn", 1000, 10, 15, 200, 100, 50);
        Item cow = new Item("Cow", 1000, 30, 35, 20, 20, 50);

        barn.addComp(cow);
        farm.addComp(barn);

//        drawComponent(barn.getLocationX(), barn.getLocationY(), barn.getLength(), barn.getWidth());
//        drawComponent(cow.getLocationX(), cow.getLocationY(), cow.getLength(), cow.getWidth());

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

            cell.selectedProperty().addListener((observable, prevSelected, newSelected) -> {
                Component cellItem = cell.getItem();
                if (newSelected && (!cell.isEmpty())){
                    nameTextField.setText(cellItem.getName());
                    xTextField.setText(String.valueOf(cellItem.getLocationX()));
                    yTextField.setText(String.valueOf(cellItem.getLocationY()));
                    lTextField.setText(String.valueOf(cellItem.getLength()));
                    wTextField.setText(String.valueOf(cellItem.getWidth()));
                    hTextField.setText(String.valueOf(cellItem.getHeight()));
                    priceTextField.setText(String.valueOf(cellItem.getPrice()));
                }
            });

            return cell;
        });

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

    @FXML
    private void handleSave() {
        int xVal = Integer.parseInt(xTextField.getText()),
                yVal = Integer.parseInt(yTextField.getText()),
                lengthVal = Integer.parseInt(lTextField.getText()),
                widthVal = Integer.parseInt(wTextField.getText()),
                heightVal = Integer.parseInt(hTextField.getText()),
                priceVal = Integer.parseInt(priceTextField.getText());
        if (xVal > 600 || yVal > 800) {
            showErrorDialog("Invalid Input", "Invalid position value(s)", "X cannot be larger than 600 and Y cannot be larger than 800!");
            return;
        }
        if (xVal+widthVal > 600 || yVal+lengthVal > 800) {
            showErrorDialog("Invalid Input", "Invalid size value(s)", "X + Width cannot be larger than 600 and Y + Length cannot be larger than 800!");
            return;
        }
        if(treeView.getSelectionModel().getSelectedItem().getParent() == null) {
            showErrorDialog("Invalid Operation", null, "Root item cannot be modified!");
            return;
        }

        Component item = treeView.getSelectionModel().getSelectedItem().getValue();
        item.setName(nameTextField.getText());
        item.setLocationX(xVal);
        item.setLocationY(yVal);
        item.setLength(lengthVal);
        item.setWidth(widthVal);
        item.setHeight(heightVal);
        item.setPrice(priceVal);
        visualPane.getChildren().clear();
        drawComponents(treeView.getRoot());
    }

    @FXML
    private void handleAddItem() {
        TreeItem<Component> selectedTreeItem = treeView.getSelectionModel().getSelectedItem();
        if (selectedTreeItem.getValue() instanceof ItemContainer){
            Item newItem = new Item("ITEM", 0, selectedTreeItem.getValue().getLocationX(), selectedTreeItem.getValue().getLocationY(), 0, 0, 0);
            TreeItem<Component> newItemNode = new TreeItem<>(newItem);
            selectedTreeItem.getValue().addComp(newItem);
            selectedTreeItem.getChildren().add(newItemNode);
            visualPane.getChildren().clear();
            drawComponents(treeView.getRoot());
        }else{
            showErrorDialog("Invalid Operation", null, "\"Add Item\" can only be performed on Item Containers!");
        }
    }

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

    @FXML
    private void handleDelete() {
        TreeItem<Component> selectedTreeItem = treeView.getSelectionModel().getSelectedItem();
        if (!(selectedTreeItem.getParent() == null)) {
            selectedTreeItem.getParent().getValue().removeComp(selectedTreeItem.getValue());
            selectedTreeItem.getParent().getChildren().remove(selectedTreeItem);
            visualPane.getChildren().clear();
            drawComponents(treeView.getRoot());
        }else{
            showErrorDialog("Invalid Operation", null, "Root item cannot be modified!");
        }
    }

    private void drawComponent (String name, int x, int y, int length, int width, Color color) {
        Rectangle rectangle = new Rectangle(width,length, Color.TRANSPARENT);
        rectangle.setStroke(color);
        rectangle.setStrokeWidth(2);
        rectangle.relocate(x,y);

        Text text = new Text();
        text.setText(name);
        text.setX((x+width/2) - text.getLayoutBounds().getWidth()/2);
        text.setY((y+length/2) + text.getLayoutBounds().getHeight()/2);

        visualPane.getChildren().addAll(rectangle,text);
    }

    private void drawComponents(TreeItem<Component> root){
        drawComponent(root.getValue().getName(),
                root.getValue().getLocationX(),
                root.getValue().getLocationY(),
                root.getValue().getLength(),
                root.getValue().getWidth(),
                Color.GREEN);
        for(TreeItem<Component> child: root.getChildren()){
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

    private void showErrorDialog (String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
