package Model;

public class LivingRoomSlot {

    private final TileSpecification tileSpecification;
    private TileType item;
    private boolean tilePresent;
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


    public void setTilePresent() {
        this.tilePresent = true;
    }


    public boolean isTilePresent() {
       if(tilePresent){
           return true;
       }
       else
           return false;
    }


    public void setExtractable() {
        this.extractable = true;
    }



}

