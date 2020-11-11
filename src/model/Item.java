package model;

//Item class......it extends the Component class (following composite design pattern)
public class Item extends Component{
    //item attributes
    private int price;
    private int locationX;
    private int locationY;
    private int length;
    private int width;
    private int height;
    private int marketValue;

    //Item constructor
    public Item(String name, int price, int locationX, int locationY, int length, int width, int height, int marketValue){
        //item params
        super(name);
        this.price = price;
        this.locationX = locationX;
        this.locationY = locationY;
        this.length = length;
        this.width = width;
        this.height = height;
        this.marketValue = marketValue;
    }

    //overrides for the class we are inheriting from
    //add item
    @Override
    public void addComp(Component component) {
        throw new ClassCastException();
    }
    //remove/delete item
    @Override
    public void removeComp(Component component) {
        throw new ClassCastException();
    }
    //set value of price (in dollars) of item
    @Override
    public void setPrice(int price){
        this.price = price;
    }
    // return the price (in dollars) of item
    @Override
    public int getPrice(){
        return price;
    }
    //set the value for the item's X position
    @Override
    public void setLocationX(int locationX){
        this.locationX = locationX;
    }
    //set the value of the item's y position'
    @Override
    public void setLocationY(int locationY){
        this.locationY = locationY;
    }
    //return the value of the item's X position
    @Override
    public int getLocationX(){
        return locationX;
    }
    // return the value of the item's y position
    @Override
    public int getLocationY(){
        return locationY;
    }
    // set the item's length property
    @Override
    public void setLength(int length){
        this.length = length;
    }
    // return the value of the item's length
    @Override
    public int getLength(){
        return length;
    }
    //set the value of the item's width property
    @Override
    public void setWidth(int width){
        this.width = width;
    }
    //return the value of the width property for the item
    @Override
    public int getWidth(){
        return width;
    }
    //give the item a new height value
    @Override
    public void setHeight(int height){
        this.height = height;
    }
    //return the value of this item's height property.
    @Override
    public int getHeight(){
        return height;
    }
    //accept hook
    @Override
    public int accept(Visitor vis){ return vis.visit(this);}

    /*
    New as of November 10th, 7 :45 PM -- please make sure this is what instructions meant ... - Will
     */

    //Set Market Value
    public void setMarketValue(int marketValue){
        this.marketValue = marketValue;
    }
    //Get Market Value
    public int getMarketValue() {
        return marketValue;
    }

}


    /*
    .........................Market Value........................................
    Market value instructions from assignment (Design and implemmentation Part 2):
   ```````````````````````````````````````````````````````````````````````````````````

        Add a new variable: market-value only for items (not to item-containers)
        to track their selling price in the market.
        Provide a way to change the value for market-value for items.



-----------------------------------------------------------------------------------------------------------------------

                                            [√] Checklist [√]:

-----------------------------------------------------------------------------------------------------------------------

      [  ]  Add two labels (See #1 Visitor Pattern in Figure-1):
      ``````````````````````````````````````````````````````````````````````````````````````````````````````````
                [   ]Purchase price.........<-----to display price of selected item or item-container
                [   ]Current Market Value...<----to display market-value of selected item or item-container
                ````````````````````````````````````````````````````````````````````````````````````````````
      [  ]  Dashboard should include a label “Current Market Value”
            to display market-value of selected item or item container

      ```````````````````````````````````````````````````````````````````````````````````````````````````````````
      [  ]MARKET VALUE SHOULD BE CALCULATED WHEN:
      ```````````````````````````````````````````````````````````````````````````````````````````````````````````
        [   ]When user selects an item display market-value of that item
        [   ]When user selects item-container calculate the market-value as: total market-value of all children.
        [   ]Implement visitor pattern to calculate price and marketValue on the composite structure.


          ...........................................................................
          .                      Market-value calculation example:                  .
          .     ...............................................................     .
          .     1.Add building-1 (item-containers do not have market-value)         .
          .     ...............................................................     .
          .     2.Add room-1 to building-1                                          .
          .     ...............................................................     .
          .     3.Add cattle-1 (item: market-value = 500) to room                   .
          .     ...............................................................     .
          .     4.Add equipment-1 (item: market-value = 400) to building            .
          .     ...............................................................     .
          .     5.When cattle-1 is selected, the label should display               .
          .              “Current Market Value: 500”                                .
          .     ...............................................................     .
          .     6.When room-1 is selected, the label should display:                .
          .              “Current Market Value: 500” (cattle-1 market-value)        .
          .     ...............................................................     .
          .     7.When building-1 selected the label displays:                      .
          .       “Current Market Value: 900“ [500 (cost of cattle-1)               .
          .       + 400 (cost of equipment-1)"                                      .
          ...........................................................................

     */


