package model;

//Item class......it extends the Component class (following composite design pattern)
public class Item extends Component{
    //item attributes
    private int price;
    private int locationX;
    private int locationY;
    private int length;
    private int width;
    private int height;

    //Item constructor
    public Item(String name, int price, int locationX, int locationY, int length, int width, int height){
        //item params
        super(name);
        this.price = price;
        this.locationX = locationX;
        this.locationY = locationY;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    //overrides for the class we are inheriting from
    //add item
    @Override
    public void addComp(Component component) {
        throw new ClassCastException();
    }
    //remove/delete item
    @Override
    public void removeComp(Component component) {
        throw new ClassCastException();
    }
    //set value of price (in dollars) of item
    @Override
    public void setPrice(int price){
        this.price = price;
    }
    // return the price (in dollars) of item
    @Override
    public int getPrice(){
        return price;
    }
    //set the value for the item's X position
    @Override
    public void setLocationX(int locationX){
        this.locationX = locationX;
    }
    //set the value of the item's y position'
    @Override
    public void setLocationY(int locationY){
        this.locationY = locationY;
    }
    //return the value of the item's X position
    @Override
    public int getLocationX(){
        return locationX;
    }
    // return the value of the item's y position
    @Override
    public int getLocationY(){
        return locationY;
    }
    // set the item's length property
    @Override
    public void setLength(int length){
        this.length = length;
    }
    // return the value of the item's length
    @Override
    public int getLength(){
        return length;
    }
    //set the value of the item's width property
    @Override
    public void setWidth(int width){
        this.width = width;
    }
    //return the value of the width property for the item
    @Override
    public int getWidth(){
        return width;
    }
    //give the item a new height value
    @Override
    public void setHeight(int height){
        this.height = height;
    }
    //return the value of this item's height property.
    @Override
    public int getHeight(){
        return height;
    }


}
