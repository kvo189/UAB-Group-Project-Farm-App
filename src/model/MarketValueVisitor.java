package model;

import java.util.Iterator;

public class MarketValueVisitor implements Visitor{
    private int marketValue;
    private int totalMarketValue;
    public MarketValueVisitor(){
        totalMarketValue = 0;
    }

    @Override
    public int visit(Item item){
        marketValue = item.getMarketValue();
        return marketValue;
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
}
