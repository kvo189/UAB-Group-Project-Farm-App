package model;

//interface class for visitor pattern implementation
interface Visitor {
    int visit(ItemContainer itemContainer);
    int visit(Item item);
}
