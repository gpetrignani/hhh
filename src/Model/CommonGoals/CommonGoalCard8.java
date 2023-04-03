package Model.CommonGoals;

import Model.Player.Bookshelf;
import Model.Shared.Tile;
import Model.Shared.TileType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonGoalCard8 extends CommonGoalCard{

    private final String description = "Four lines each formed by 5 tiles of maximum three different types. " +
            "One line can show the same or a different combination of another line.";

    /**
     * Constructor of CommonGoalCard8
     * @param cardID specifies the ID of the card that is being constructed
     */
    public CommonGoalCard8(int cardID) {
        this.cardID = cardID;

    }

    /**
     * @return the description of the CommonGoalCard8
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

        int numbrow = 0;
        for(int i = 0; i < 6; i++)
        {
            int[] count = {0, 0, 0, 0, 0, 0};
            int numbtype = 0;


            if(bookshelf.isRowFull(i))
            {
                for (int j = 0; j < 5; j++)
                {
                    int index = type.indexOf(shelf[i][j].getTileType());
                    count[index]++;
                }

                for (int k = 0; k < 6; k++)
                {
                    if (count[k] > 0)
                    {
                        numbtype++;
                    }
                }
                if (numbtype <= 3)
                {
                    numbrow++;
                }
            }


        }
        return numbrow >= 4;

    }

}

