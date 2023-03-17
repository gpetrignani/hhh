public class BoardSlot {

    /*private boolean inOut;
    private boolean itemTile;
    private boolean threePlayerSlot;
    private boolean fourPlayerSlot;
     */



    private TileType type;
    private ItemTile Item;

    public BoardSlot (TileType Type){
        this.type = Type;
    }

    public TileType getType() {
        return type;
    }









    public void BoardSlotInOut (boolean inOut){

        this.inOut = inOut;
    }

    public void itemTilePresent (boolean itemTile){

        this.itemTile = itemTile;
    }

    public void threePlayerSlotGame (boolean threePlayerSlot){

        this.threePlayerSlot = threePlayerSlot;
    }

    public void fourPlayerSlotGame (boolean fourPlayerSlot){

        this.fourPlayerSlot = fourPlayerSlot;
    }


    public boolean isInOut() {
        return inOut;
    }

    public boolean isItemTile() {
        return itemTile;
    }

    public boolean isThreePlayerSlot() {
        return threePlayerSlot;
    }

    public boolean isFourPlayerSlot() {
        return fourPlayerSlot;
    }
}


