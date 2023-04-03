package Model.CommonGoals;

import Model.Player.Bookshelf;
import Model.Shared.Tile;
import Model.Shared.TileType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonGoalCard11 extends CommonGoalCard{

    private String description = "Five tiles of the same type forming an X.";

    /**
     * Constructor of CommonGoalCard11
     * @param cardID specifies the ID of the card that is being constructed
     */
    public CommonGoalCard11(int cardID) {
        this.cardID = cardID;

    }

    /**
     * @return the description of the CommonGoalCard11
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method used during the game to check if a player reached the objective of the CommonGoalCard
     * @param bookshelf Bookshelf that has to be checked
     * @return true if the objective is reached, false if is not reached
     */
    public boolean checkGoal(Bookshelf bookshelf)
    {
        Tile[][] shelf = bookshelf.getBookShelfLayer();
        List<TileType> type = new ArrayList<TileType>(Arrays.asList(TileType.values()));

        for(int i = 1; i<5; i++)
        {
            for(int j = 1; j<4; j++)
            {
                if(shelf[i][j] != null && shelf[i-1][j-1] != null && shelf[i-1][j+1]!=null && shelf[i+1][j+1]!=null && shelf[i+1][j-1]!=null)
                {
                    if(shelf[i][j].getTileType() == shelf[i-1][j-1].getTileType() &&
                    shelf[i][j].getTileType() == shelf[i-1][j+1].getTileType() &&
                    shelf[i][j].getTileType() == shelf[i+1][j-1].getTileType() &&
                    shelf[i][j].getTileType() == shelf[i+1][j+1].getTileType())
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
