package Model;

import Model.LivingRoomClasses.LivingRoomBoard;
import Model.Player.Player;

import java.util.ArrayList;

public class Game {


    private ArrayList<Player> players;
    private int currentPlayer;
    private LivingRoomBoard livingRoomBoard;





    public Game () {

        this.players = new ArrayList<Player>();
        this.livingRoomBoard = new LivingRoomBoard();

    }

    public ArrayList<Player> getPlayers() { return players; }

    public void setCurrentPlayer(int playerIndex) {
        currentPlayer = playerIndex;
    }

    public Player getCurrentPlayer() { return players.get(currentPlayer); }


}
