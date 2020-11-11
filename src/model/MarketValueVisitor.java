package model;

import java.util.Iterator;

public class MarketValueVisitor implements Visitor{
    private int totalMarketValue;
    public MarketValueVisitor(){
        totalMarketValue = 0;
    }
    @Override
    public int visit(ItemContainer itemContainer){
        Iterator<Component> iterator = itemContainer.getItemComponents().iterator();
        while(iterator.hasNext()){
            Component currentComponent = iterator.next();
            if(currentComponent instanceof Item){
                totalMarketValue += ((Item) currentComponent).getMarketValue();
            }
        }
        return totalMarketValue;
    }
    @Override
    public int visit(Item item){
        totalMarketValue = item.getMarketValue();
        return totalMarketValue;
    }
}
