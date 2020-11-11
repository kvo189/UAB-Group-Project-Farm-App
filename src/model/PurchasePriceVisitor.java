package model;
import java.util.Iterator;

public class PurchasePriceVisitor implements Visitor{
    private int totalPrice;
    public PurchasePriceVisitor(){
        totalPrice = 0;
    }
    @Override
    public int visit(ItemContainer itemContainer){
        Iterator<Component> iterator = itemContainer.getItemComponents().iterator();
        while(iterator.hasNext()){
            Component currentComponent = iterator.next();
            totalPrice += currentComponent.getPrice();
        }
        return totalPrice;
    }
    @Override
    public int visit(Item item){
        totalPrice = item.getPrice();
        return totalPrice;
    }
}
