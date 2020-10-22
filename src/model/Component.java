package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Component {
    private final StringProperty name = new SimpleStringProperty();

    public Component(String name){
        setName(name);
    }

    public final StringProperty nameProperty() {
        return this.name;
    }

    public final String getName() {
        return this.nameProperty().get();
    }

    public final void setName(final String name) {
        this.nameProperty().set(name);
    }

    public abstract void addComp(Component component);
    public abstract void removeComp(Component component);
    public abstract int getPrice();
    public abstract void setPrice(int price);
    public abstract int getLocationX();
    public abstract int getLocationY();
    public abstract void setLocationX(int locationX);
    public abstract void setLocationY(int locationY);
    public abstract int getLength();
    public abstract void setLength(int length);
    public abstract int getWidth();
    public abstract void setWidth(int width);
    public abstract int getHeight();
    public abstract void setHeight(int height);
}
