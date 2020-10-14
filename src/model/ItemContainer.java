package model;

import java.util.ArrayList;
import java.util.List;

public class ItemContainer extends Component{

    private int price;
    private int locationX;
    private int locationY;
    private int length;
    private int width;
    private int height;

    private String name;
    private ArrayList<ItemContainer> itemContainer;

    public ItemContainer (String name,
                          int price,
                          int locationX,
                          int locationY,
                          int length,
                          int width,
                          int height) {

        this.price = price;
        this.locationX = locationX;
        this.locationY = locationY;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addItemContainer() {

    }

    @Override
    public void deleteItemContainer() {

    }

    public void addItemContainer(ItemContainer item) {
        itemContainer.add(item);
    }

    public void deleteItemContainer(ItemContainer item) {
        itemContainer.remove(item);
    }

    public List<ItemContainer> getContainerList() {
        return itemContainer;
    }

    public void addItem() {
        throw new ClassCastException();
    }

    public void deleteItem() {
        throw new ClassCastException();
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setWidth() {

    }


    public void changeWidth() {

    }

    public void setHeight() {

    }

    public void changeHeight() {

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }


    public void addItemContainer(ArrayList<ItemContainer> insertedItem) {

        ItemContainer.add(insertedItem);



    }

    private static void add(ArrayList<ItemContainer> insertedItem) {
    }


}
