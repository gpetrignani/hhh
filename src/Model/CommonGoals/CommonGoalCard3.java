package Model.CommonGoals;

import Model.Player.Bookshelf;
import Model.Shared.Tile;
import Model.Shared.TileType;

public class CommonGoalCard3 extends CommonGoalCard{

    private String description = "Four tiles of the same type in the four corners of the bookshelf.";

    /**
     * Constructor of CommonGoalCard2
     * @param cardID specifies the ID of the card that is being constructed
     */
    public CommonGoalCard3(int cardID) {
        this.cardID = cardID;
    }

    /**
     * @return the description of the CommonGoalCard3
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

        if(shelf[0][0] != null && shelf[0][4] != null && shelf[5][0] != null && shelf[5][4] != null)
        {
            TileType left_up = shelf[0][0].getTileType();
            TileType right_up = shelf[0][4].getTileType();
            TileType left_down = shelf[5][0].getTileType();
            TileType right_down = shelf[5][4].getTileType();

            if(left_up == right_up && left_up == left_down && left_up == right_down)
            {
                return true;
            }
        }
        return false;
    }
}
