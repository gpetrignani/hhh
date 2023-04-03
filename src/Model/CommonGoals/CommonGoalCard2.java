package Model.CommonGoals;


import Model.Player.Bookshelf;
import Model.Shared.Tile;
import Model.Shared.TileType;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonGoalCard2 extends CommonGoalCard{

    private final String description = "Four groups each containing at least 4 tiles of the same type." +
            "The tiles of one group can be different from those of another group.";


    /**
     * constructor of CommonGoalCard2
     * @param cardID specifies the ID of the card that is being created
     */
    public CommonGoalCard2(int cardID) {
        this.cardID = cardID;
    }

    /**
     * @return the description of the CommonGoalCard2
     */
    public String getDescription() {
        return description;
    }


    /**
     * Method used during the game to check if a player reached the objective of the CommonGoalCard
     * @param bookshelf Bookshelf that has to be checked
     * @return true if the objective is reached, false if is not reached
     */
    public boolean checkGoal(Bookshelf bookshelf) {
        List<TileType> type = new ArrayList<TileType>(Arrays.asList(TileType.values()));
        Tile[][] shelf = bookshelf.getBookShelfLayer();
        int count = 0;

        for(TileType t: type)
        {
            int m = shelf.length;
            int n = shelf[0].length;

            int area = 0;

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (shelf[i][j]!=null && shelf[i][j].getTileType().equals(t))
                    {
                        area = CommonGoalCard.dfs(shelf, t, i, j);
                        if(area >= 4)
                            count++;
                    }
                }
            }

        }

        if(count>=4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }




}
