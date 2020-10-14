package model;

public class Item extends Component{

    private String name;
    private int price;
    private int locationX;
    private int locationY;
    private int length;
    private int width;
    private int height;

    public Item(String name, int price, int locationX, int locationY, int length, int width, int height){
        this.name = name;
        this.price = price;
        this.locationX = locationX;
        this.locationY = locationY;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void addItemContainer() {
        throw new ClassCastException();
    }

    @Override
    public void deleteItemContainer() {
        throw new ClassCastException();
    }

    @Override
    public void addItem(){
        throw new ClassCastException();
    }

    @Override
    public void deleteItem() {
        
    }

    @Override
    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public int getPrice(){
        return price;
    }

    public void setLocationX(int locationX){
        this.locationX = locationX;
    }


    public void setLocationY(int locationY){
        this.locationY = locationY;
    }

    public int getLocationX(){
        return locationX;
    }

    public int getLocationY(){
        return locationY;
    }

    public void setLength(int length){
        this.length = length;
    }

    public int getLength(){
        return length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getWidth(){
        return width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }


}
