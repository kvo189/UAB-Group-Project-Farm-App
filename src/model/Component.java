package model;

import java.util.ArrayList;

public abstract class Component {
    public abstract String getName();
    public abstract void setName(String name);

    public abstract void addItemContainer();
    public abstract void deleteItemContainer();

    public abstract void addItem();
    public abstract void deleteItem();

    public abstract void setPrice(int price);
    public abstract int getPrice();
<<<<<<< HEAD

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

    public abstract void addItemContainer(ArrayList<ItemContainer> insertedItem);
=======

    public abstract void setLocationX(int locationX);
    public abstract void setLocationY(int locationY);
    public abstract int getLocationX();
    public abstract int getLocationY();

    public abstract void setLength(int length);
    public abstract int getLength();

<<<<<<< HEAD
    public abstract void setWidth();
    public abstract void changeWidth();

    public abstract void setHeight();
    public abstract void changeHeight();
=======
    public abstract void setWidth(int width);
    public abstract int getWidth();

    public abstract void setHeight(int height);
    public abstract int getHeight();
>>>>>>> dannyDev
>>>>>>> 66936b84c4a681f3dd9ea888d8ed577eaaf283c9
}
