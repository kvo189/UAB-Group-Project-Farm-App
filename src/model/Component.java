package model;

public abstract class Component {
    public abstract void getName();
    public abstract void setName();
    public abstract void changeName();

    public abstract void addItemContainer();
    public abstract void deleteItemContainer();

    public abstract void addItem();
    public abstract void deleteItem();

    public abstract void setPrice();
    public abstract void changePrice();

    public abstract void setLocationX();
    public abstract void setLocationY();

    public abstract void setLength();
    public abstract void changeLength();


    public abstract void setWidth();
    public abstract void changeWidth();

    public abstract void setHeight();
    public abstract void changeHeight();
}
