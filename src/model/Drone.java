package model;

public class Drone extends Component{
    private int price;
    private int locationX;
    private int locationY;
    private int length;
    private int width;
    private int height;

    public Drone(String name, int price, int locationX, int locationY, int length, int width, int height){
        super(name);
        this.price = price;
        this.locationX = locationX;
        this.locationY = locationY;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public void addComp(Component component) {
        throw new ClassCastException();
    }

    @Override
    public void removeComp(Component component) {
        throw new ClassCastException();
    }

    @Override
    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public int getPrice(){
        return price;
    }

    @Override
    public void setLocationX(int locationX){
        this.locationX = locationX;
    }

    @Override
    public void setLocationY(int locationY){
        this.locationY = locationY;
    }

    @Override
    public int getLocationX(){
        return locationX;
    }

    @Override
    public int getLocationY(){
        return locationY;
    }

    @Override
    public void setLength(int length){
        this.length = length;
    }

    @Override
    public int getLength(){
        return length;
    }

    @Override
    public void setWidth(int width){
        this.width = width;
    }

    @Override
    public int getWidth(){
        return width;
    }

    @Override
    public void setHeight(int height){
        this.height = height;
    }

    @Override
    public int getHeight(){
        return height;
    }


}
