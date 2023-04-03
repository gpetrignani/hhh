package Model.CommonGoals;

import Model.Player.Bookshelf;
import Model.Shared.Tile;
import Model.Shared.TileType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonGoalCard6 extends CommonGoalCard{

    private String description = "Eight tiles of the same type. There’s no" +
            "restriction about the position of these" +
            "tiles.";

    /**
     * Constructor of CommonGoalCard6
     * @param cardID specifies the ID of the card that is being constructed
     */

    public CommonGoalCard6(int cardID) {
        this.cardID = cardID;

    }

    /**
     * @return the description of the CommonGoalCard6
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
        //CAT, BOOK, GAME, FRAME, TROPHY, PLANT;
        List<TileType> type = new ArrayList<TileType>(Arrays.asList(TileType.values()));
        int[] count = {0, 0, 0, 0, 0, 0};

        for(int i = 0; i<6; i++)
        {
            for(int j = 0; j<5; j++)
            {
                if(shelf[i][j] != null && type.contains(shelf[i][j].getTileType()))
                {
                    int index = type.indexOf(shelf[i][j].getTileType());
                    count[index]++;
                }
            }
        }
        for(int k = 0; k<6; k++)
        {
            if (count[k] >= 8)
            {
                return true;
            }
        }
        return false;

    }
}
