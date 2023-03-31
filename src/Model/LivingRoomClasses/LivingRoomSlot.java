package Model.LivingRoomClasses;

public class LivingRoomSlot {

    private final TileSpecification tileSpecification;
    private TileType item;
    private boolean extractable;

    /**
     * type represents what kind of LivingRoomSlot I'm placing my item on
     * @param Type
     */


    public LivingRoomSlot(TileSpecification Type){
        this.tileSpecification = Type;
    }


    public TileSpecification getTileSpecification() {
        return tileSpecification;
    }

    /**
     * item represents what kind of TileType I'm placing on a LivingRoomSlot
     * @param item
     */

    public void setItem(TileType item) {
        this.item = item;
    }

    public TileType getItem() {
        return this.item;
    }





    public boolean isTilePresent() {

        if(this.tileSpecification == TileSpecification.OUT){
           return false;
        }
        if(this.item == null){
            return false;
        }
        return true;
    }


    public void setExtractable() {
        this.extractable = true;
    }



}

