package Model.LivingRoomClasses;


import Model.Shared.Tile;
import Model.Shared.TileType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {

    private List<Tile> itemTiles;


    public Bag() {
        itemTiles = new ArrayList<>();
        for(int i = 0; i < 22; i++) {
            for(TileType type : TileType.values()) {
                itemTiles.add(new Tile(type, i%3 + 1));
            }
        }
    }


    public Tile drawItemTile() throws IllegalArgumentException {
        try {
            Random random = new Random();
            int index = random.nextInt(itemTiles.size());
            Tile drawn = itemTiles.get(index);
            itemTiles.remove(index);
            return drawn;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The bag is empty");
        }
    }

    public void addItemTile(Tile tile) {
        itemTiles.add(tile);
    }


    public boolean isEmpty() {
        if(itemTiles.size() == 0) return true;
        return false;
    }

    public List<Tile> getItemTiles() {
        return itemTiles;
    }
}
