package model;
//import JavaFX modules
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//Abstract class for component. This is the abstract class for our Composite implementation.
public abstract class Component {
    private final StringProperty name = new SimpleStringProperty();

    // this is a component class
    public Component(String name){
        setName(name);
    }

    //return the property
    public final StringProperty nameProperty() {
        return this.name;
    }

    //return the name
    public final String getName() {
        return this.nameProperty().get();
    }
    //Set the value of the ItemContainer's name
    public final void setName(final String name) {
        this.nameProperty().set(name);
    }
    //abstract methods
    public abstract void addComp(Component component);
    //Remove/delete a component from ItemContainer
    public abstract void removeComp(Component component);
    //Return the price of the ItemContainer
    public abstract int getPrice();
    //Set the value in dollars...set the price of the ItemContainer
    public abstract void setPrice(int price);
    //Return X Position
    public abstract int getLocationX();
    //Return Y Position
    public abstract int getLocationY();
    //Set X Position
    public abstract void setLocationX(int locationX);
    //Set Y Position
    public abstract void setLocationY(int locationY);
    //Return Length of ItemContainer
    public abstract int getLength();
    //Set Length of ItemContainer
    public abstract void setLength(int length);
    //Return Width of ItemContainer
    public abstract int getWidth();
    //Set Width of ItemContainer
    public abstract void setWidth(int width);
    //Return Height of ItemContainer
    public abstract int getHeight();
    //Set height of ItemContainer
    public abstract void setHeight(int height);
}
