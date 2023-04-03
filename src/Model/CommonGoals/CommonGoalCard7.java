package Model.CommonGoals;

import Model.Player.Bookshelf;
import Model.Shared.Tile;
import Model.Shared.TileType;

import java.util.List;

public class CommonGoalCard7 extends CommonGoalCard{

    private String description = "Five tiles of the same type forming a diagonal.";

    /**
     * Constructor of CommonGoalCard7
     * @param cardID specifies the ID of the card that is being constructed
     */
    public CommonGoalCard7(int cardID) {
        this.cardID = cardID;

    }
    /**
     * @return the description of the CommonGoalCard7
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
        List<Boolean> checkFull = bookshelf.isDiagonalFull();

        if(checkFull.get(0) && shelf[0][0].getTileType() == shelf[1][1].getTileType() &&
        shelf[0][0].getTileType() == shelf[2][2].getTileType() &&
        shelf[0][0].getTileType() == shelf[3][3].getTileType() &&
        shelf[0][0].getTileType() == shelf[4][4].getTileType())
        {
            return true;

        } else if (checkFull.get(1) && shelf[1][0].getTileType() == shelf[2][1].getTileType() &&
                shelf[1][0].getTileType() == shelf[3][2].getTileType() &&
                shelf[1][0].getTileType() == shelf[4][3].getTileType() &&
                shelf[1][0].getTileType() == shelf[5][4].getTileType()) {
            
            return true;

        } else if (checkFull.get(2) && shelf[0][4].getTileType() == shelf[1][3].getTileType() &&
                shelf[0][4].getTileType() == shelf[2][2].getTileType() &&
                shelf[0][4].getTileType() == shelf[3][1].getTileType() &&
                shelf[0][4].getTileType() == shelf[4][0].getTileType()) {
            return true;

        } else if (checkFull.get(3) && shelf[1][4].getTileType() == shelf[2][3].getTileType() &&
                shelf[1][4].getTileType() == shelf[3][2].getTileType() &&
                shelf[1][4].getTileType() == shelf[4][1].getTileType() &&
                shelf[1][4].getTileType() == shelf[5][0].getTileType()) {
            return true;
        }
        else
        {
            return false;
        }

    }
}
