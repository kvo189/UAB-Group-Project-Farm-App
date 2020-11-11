package model;

import java.util.ArrayList;


//ItemContainer extends component. ItemContainer holds items.
public class ItemContainer extends Component{
    //ItemContainer parameters declared here.
    private int price;
    private int locationX;
    private int locationY;
    private int length;
    private int width;
    private int height;
    private int marketValue;
    private int purchasePrice;
    //ItemContainer has an ArrayList, itemComponents, which contains a collection of items.
    // This is basically ItemContainer's....item container. It's an ArrayList.
    private final ArrayList<Component> itemComponents = new ArrayList<>();

    //ItemContainer's constructor.
    public ItemContainer (String name,
                          int price,
                          int locationX,
                          int locationY,
                          int length,
                          int width,
                          int height
    ) {
        super(name);
        this.price = price;
        this.locationX = locationX;
        this.locationY = locationY;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    //@Override stuff

    // return the contents in itemComponents ArrayList (itemComponents is an ArrayList<Component> & Item--> Component)
    public ArrayList<Component> getItemComponents() {
        return itemComponents;
    }
    //add a component to the ArrayList
    @Override
    public void addComp(Component component) {
        itemComponents.add(component);
    }
    //Remove a component from the ArrayList
    @Override
    public void removeComp(Component component) {
        itemComponents.remove(component);
    }
    // Set the price of the Item Container
    @Override
    public void setPrice(int price) {
        this.price = price;
    }
    //Return the price of the item container (ex: price of barn, etc.)
    @Override
    public int getPrice() {
        return price;
    }
    //X position of item container (ex: barn x position)
    @Override
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }
    //Y Position of ItemContainer
    @Override
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
    //Return X position of ItemContainer
    @Override
    public int getLocationX() {
        return locationX;
    }
    // Return Y Position of ItemContainer
    @Override
    public int getLocationY() {
        return locationY;
    }
    //Set the value of the ItemContainer's Length
    @Override
    public void setLength(int length) {
        this.length = length;
    }
    @Override
    public int getLength() {
        return length;
    }
    @Override
    public void setWidth(int width) {
        this.width = width;
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public int getHeight() {
        return height;
    }
    //accept hook
    @Override
    public int accept(Visitor vis){ return vis.visit(this);}
}
