package Controller;


import Model.Player.Player;
import Model.Player.Bookshelf;
import Model.Game;

import java.util.Random;

public class GameController {

    private final Game game;

    public GameController(){

    }

    public void startGame() { selectStartingPlayer(); }


    private void selectStartingPlayer() {
        Random r = new Random();
        int firstPlayerIndex = r.nextInt(game.getPlayers().size());
        game.setCurrentPlayer(firstPlayerIndex);

    }

    public Game getGame() {
        return game;
    }



    public void computeNextPlayer(){


        int nextPlayer = (game.getPlayers().indexOf(game.getCurrentPlayer()) + 1) % game.getPlayers().size();
        game.setCurrentPlayer(nextPlayer);
        System.out.println("next player" + nextPlayer + game.getCurrentPlayer());

    }


}
