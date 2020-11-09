package model;

import java.util.Iterator;

public class MarketValueVisitor implements Visitor{
    private int totalPrice;
    public MarketValueVisitor(){
        totalPrice = 0;
    }
    @Override
    public int visit(ItemContainer itemContainer){
        Iterator<Component> iterator = itemContainer.getItemComponents().iterator();
        while(iterator.hasNext()){
            Component currentComponent = (Component)iterator.next();
            if(currentComponent instanceof Item){
                totalPrice += currentComponent.getMarketValue();
            }
        }
        return totalPrice;
    }
    @Override
    public int visit(Item item){
        totalPrice = item.getMarketValue();
        return totalPrice;
    }
}
