package Model.Player;

public class Player {

    private final String username;
    private int score = 0;
    private boolean playing = false;
    private final Bookshelf bookshelf;



    public Player(String username) {
        this.username = username;
        bookshelf = new Bookshelf();
    }


    public String getUsername() {
        return username;
    }

    public boolean isPlaying() {
        return playing;
    }

    public Bookshelf getBookshelf() { return bookshelf;}








}
