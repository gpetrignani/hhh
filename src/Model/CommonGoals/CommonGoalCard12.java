package Model.CommonGoals;

import Model.Player.Bookshelf;
import Model.Shared.Tile;
import Model.Shared.TileType;

public class CommonGoalCard12 extends CommonGoalCard{

    private String description = "Five columns of increasing or decreasing height. " +
            "Starting from the first column on the left or on the right, each next column must be made " +
            "of exactly one more tile. Tiles can be of any type. ";


    /**
     * Constructor of CommonGoalCard12
     * @param cardID specifies the ID of the card that is being constructed
     */
    public CommonGoalCard12(int cardID) {
        this.cardID = cardID;
    }

    /**
     * @return the description of the CommonGoalCard12
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
        int count = 0;
        
        if(bookshelf.columnHasRightNumberSpaces(0, 1) &&
        bookshelf.columnHasRightNumberSpaces(1, 2) &&
        bookshelf.columnHasRightNumberSpaces(2, 3) &&
        bookshelf.columnHasRightNumberSpaces(3, 4) &&
        bookshelf.columnHasRightNumberSpaces(4, 5))
        {
            return true;
        }
        else if (bookshelf.columnHasRightNumberSpaces(0, 5) &&
                bookshelf.columnHasRightNumberSpaces(1, 4) &&
                bookshelf.columnHasRightNumberSpaces(2, 3) &&
                bookshelf.columnHasRightNumberSpaces(3, 2) &&
                bookshelf.columnHasRightNumberSpaces(4, 1))
        {
            return true;
            
        }
        else if (bookshelf.columnHasRightNumberSpaces(0, 4) &&
                bookshelf.columnHasRightNumberSpaces(1, 3) &&
                bookshelf.columnHasRightNumberSpaces(2, 2) &&
                bookshelf.columnHasRightNumberSpaces(3, 1) &&
                bookshelf.columnHasRightNumberSpaces(4, 0))
        {
            return true;

        }
        else return bookshelf.columnHasRightNumberSpaces(0, 0) &&
                    bookshelf.columnHasRightNumberSpaces(1, 1) &&
                    bookshelf.columnHasRightNumberSpaces(2, 2) &&
                    bookshelf.columnHasRightNumberSpaces(3, 3) &&
                    bookshelf.columnHasRightNumberSpaces(4, 4);

    }
}
