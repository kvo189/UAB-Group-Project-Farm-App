package model;

public abstract class Component {
    public abstract String getName();
    public abstract void setName(String name);

    public abstract void addItemContainer();
    public abstract void deleteItemContainer();

    public abstract void addItem();
    public abstract void deleteItem();

    public abstract void setPrice(int price);
    public abstract int getPrice();

    public abstract void setLocationX(int locationX);
    public abstract void setLocationY(int locationY);
    public abstract int getLocationX();
    public abstract int getLocationY();

    public abstract void setLength(int length);
    public abstract int getLength();

    public abstract void setWidth(int width);
    public abstract int getWidth();

    public abstract void setHeight(int height);
    public abstract int getHeight();
}
