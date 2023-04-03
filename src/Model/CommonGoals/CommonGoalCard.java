package Model.CommonGoals;

import Model.Player.Bookshelf;
import Model.Player.Player;
import Model.Shared.Tile;
import Model.Shared.TileType;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonGoalCard {

    private final int numeroRighe = 6;
    private final int numeroColonne = 5;


    protected List<ScoringToken> tokenList;
    protected int cardID;


    public abstract boolean checkGoal(Bookshelf b);


    public void initializeTokenList(int numberOfPlayers) {
        tokenList = new ArrayList<>();
        switch (numberOfPlayers) {
            case 2:
                tokenList.add(new ScoringToken(8));
                tokenList.add(new ScoringToken(4));
            case 3:
                tokenList.add(new ScoringToken(8));
                tokenList.add(new ScoringToken(6));
                tokenList.add(new ScoringToken(4));
            case 4:
                tokenList.add(new ScoringToken(8));
                tokenList.add(new ScoringToken(6));
                tokenList.add(new ScoringToken(4));
                tokenList.add(new ScoringToken(2));
        }
    }

    public void giveToken(Player player) {
        ScoringToken t = tokenList.get(0);
        player.receiveToken(t);
        tokenList.remove(0);
    }



    public static int dfs( Tile[][] shelf, TileType t, int row, int col)
    {
        int m = shelf.length;
        int n = shelf[0].length;

        int area = 1;

        shelf[row][col] = null;

        int [] dir = {-1,0,1,0,-1};

        for (int i = 0; i < 4; i++)
        {
            int r = row+dir[i];
            int c = col+dir[i+1];

            if (r >= 0 && r < m && c >= 0 && c < n && shelf[r][c]!=null && shelf[r][c].getTileType().equals(t))
            {
                area += dfs(shelf, t, r, c);
            }
        }
        return area;
    }



}