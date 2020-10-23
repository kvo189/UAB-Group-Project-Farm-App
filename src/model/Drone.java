package model;

//drone class
public class Drone extends Component{
    private int price;
    private int locationX;
    private int locationY;
    private int length;
    private int width;
    private int height;

    //drone constructor
    public Drone(String name, int price, int locationX, int locationY, int length, int width, int height){
        super(name);
        this.price = price;
        this.locationX = locationX;
        this.locationY = locationY;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Add/Create a new component
    @Override
    public void addComp(Component component) {
        throw new ClassCastException();
    }

    // Delete/remove an existing component
    @Override
    public void removeComp(Component component) {
        throw new ClassCastException();
    }

    //Set a value for the item in dollars
    @Override
    public void setPrice(int price){
        this.price = price;
    }

    //return the value of the drone's price in dollars
    @Override
    public int getPrice(){
        return price;
    }

    // set the value of the drone's X position
    @Override
    public void setLocationX(int locationX){
        this.locationX = locationX;
    }

    //set the value of the drone's y position
    @Override
    public void setLocationY(int locationY){
        this.locationY = locationY;
    }

    //return the drone's X-position.
    @Override
    public int getLocationX(){
        return locationX;
    }

    //return the value for the drone's y-position.
    @Override
    public int getLocationY(){
        return locationY;
    }
    //set a new value for drone length.
    @Override
    public void setLength(int length){
        this.length = length;
    }

    //drone length?
    @Override
    public int getLength(){
        return length;
    }

    //drone width?
    @Override
    public void setWidth(int width){
        this.width = width;
    }

    //drone width?
    @Override
    public int getWidth(){
        return width;
    }

    //drone height/altitude?
    @Override
    public void setHeight(int height){
        this.height = height;
    }

    //how tall is the drone?
    @Override
    public int getHeight(){
        return height;
    }


}
