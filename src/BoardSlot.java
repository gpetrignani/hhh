public class BoardSlot {
    private final TileType type;
    private ItemTile Item;

    public BoardSlot (TileType Type){
        this.type = Type;
    }

    public TileType getType() {
        return type;
    }
}


