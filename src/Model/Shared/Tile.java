package Model.Shared;

import java.util.Objects;

public class Tile {
    private TileType type;
    private int TileId;



    public Tile (TileType type, int tileId){
        this.type = type;
        this.TileId = tileId;
    }


    /**
     * Getter method
     * @return type of the ItemTile
     */

    public TileType getTileType () {

        return this.type;
    }

    public int getTileId () {

        return this.TileId;
    }


    public void setTile (TileType type, int TileId){
        this.type = type;
        this.TileId = TileId;
    }


    public void resetTile () {
        this.type = null;
        this.TileId = 0;
    }







}

