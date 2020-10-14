package model;

abstract class Component {
    private String name;

    Component(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



//    Delete item
//    Change name
//    Change price
//    Change location-x
//    Change location-y
//    Change length
//    Change width
//    Change height
}
