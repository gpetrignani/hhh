public class LivingRoomBoard {

    private final BoardSlot[][] livingRoomBoard = new BoardSlot[9][9];
    private final TileType[][] initial_config = {
{TileType.OUT, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.FOUR},
{TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.FOUR},
{TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.FOUR},
{TileType.TWO, TileType.OUT, TileType.THREE, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.FOUR},
{TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.FOUR},
{TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.FOUR},
{TileType.TWO, TileType.OUT, TileType.TWO, TileType.TWO, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.FOUR},
{TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.FOUR},
{TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.TWO, TileType.OUT, TileType.FOUR},
    };

    public LivingRoomBoard() {
        this.initializeBoard();
    }

    private void initializeBoard() {
        for (int r = 0; r < this.initial_config.length; r++) {
            for (int c = 0; c < this.initial_config[0].length; c++) {
                this.livingRoomBoard[r][c] = new BoardSlot(this.initial_config[r][c]);
            }
        }
    }

    public void getStatus() {
        for (BoardSlot[] boardSlots : this.livingRoomBoard) {
            for (BoardSlot boardSlot : boardSlots) {
                switch (boardSlot.getType()) {
                    case TWO -> System.out.print("_2_ ");
                    case THREE -> System.out.print("_3_ ");
                    case FOUR -> System.out.print("_4_ ");
                    default -> System.out.print("OUT ");
                }
            }
            System.out.println();
        }
    }
}
