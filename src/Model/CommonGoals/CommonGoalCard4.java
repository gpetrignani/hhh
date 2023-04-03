package Model.CommonGoals;


import Model.Player.Bookshelf;
import Model.Shared.Tile;
import Model.Shared.TileType;

import java.awt.*;
import java.util.List;
import java.util.*;

public class CommonGoalCard4 extends CommonGoalCard{

    private final String description = "Two groups each containing 4 tiles of the same type in a 2x2 square." +
            "The tiles of one square can be different from those of the other square.";

    /**
     * Constructor of CommonGoalCard4
     * @param cardID specifies the ID of the card that is being constructed
     */
    public CommonGoalCard4(int cardID) {
        this.cardID = cardID;

    }

    /**
     * @return the description of the CommonGoalCard4
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
                        Set<Point> points = new HashSet<>();
                        area = dfs(shelf, t, i, j , points);

                        if(area == -1)
                        {
                            count++;
                        }
                        if(count>1)
                        {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }
    /**
     * Recursive method that implements the Depth First Search Algorithm.
     * It is useful to find the groups of tiles of the same type in Bookshelf
     * @param shelf of Bookshelf in which we are applying the algorithm
     * @param t TileType of the groups we are looking for
     * @param row coordinates of the first slot from where we are starting with the algorithm
     * @param col coordinates of the first slot from where we are starting with the algorithm
     * @param points list of the coordinates of the ItemTile of type t that the algorithm
     *               found near the first slot
     * @return the number of tiles of type t that the algorithm found near the shelf[row][col]
     */
    public static int dfs(Tile[][] shelf, TileType t, int row, int col, Set<Point> points)
    {
        int m = shelf.length;
        int n = shelf[0].length;

        int area = 1;

        shelf[row][col] = null;

        int [] dir = {-1,0,1,0,-1};
        points.add(new Point(row, col));
        for (int i = 0; i < 4; i++)
        {
            int r = row+dir[i];
            int c = col+dir[i+1];

            if (r >= 0 && r < m && c >= 0 && c < n && shelf[r][c]!=null && shelf[r][c].getTileType().equals(t))
            {
                points.add(new Point(r, c));
                area += dfs(shelf, t, r, c, points);
            }
        }
        ArrayList<Point> p = new ArrayList<>(points);

        if(area == 4)
        {
            if(twoXtwo(p))
            {
                return -1;
            }
        }
        return area;
    }

    /**
     * Method to check if 4 points form a 2x2 square
     * @param points list of 4 points that needs to be checked
     * @return true if the 4 points form a square, false if they don't
     */
    public static boolean twoXtwo(ArrayList<Point> points)
    {

        for(Point p: points)
        {
            Point p1 = new Point(p.x+0, p.y+1);
            Point p2 = new Point(p.x + 1, p.y+0);
            Point p3 = new Point(p.x + 1, p.y + 1);

            if (points.contains(p1) && points.contains(p2) && points.contains(p3))
            {
                return true;
            }

        }
        return false;
    }
}
