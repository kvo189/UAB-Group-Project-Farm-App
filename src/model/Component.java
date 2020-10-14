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


}
