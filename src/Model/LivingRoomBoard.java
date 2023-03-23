package Model;


import java.util.ArrayList;

public class LivingRoomBoard {


    private boolean refillToDo;
    private boolean youCanExtract;


    private final TileSpecification[][] initial_config = {
            {TileSpecification.OUT, TileSpecification.OUT, TileSpecification.OUT, TileSpecification.THREE, TileSpecification.FOUR, TileSpecification.OUT, TileSpecification.OUT, TileSpecification.OUT, TileSpecification.OUT},
            {TileSpecification.OUT, TileSpecification.OUT, TileSpecification.OUT, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.FOUR, TileSpecification.OUT, TileSpecification.OUT, TileSpecification.OUT},
            {TileSpecification.OUT, TileSpecification.OUT, TileSpecification.THREE, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.THREE, TileSpecification.OUT, TileSpecification.OUT},
            {TileSpecification.OUT, TileSpecification.FOUR, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.THREE},
            {TileSpecification.FOUR, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.FOUR},
            {TileSpecification.THREE, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.FOUR, TileSpecification.OUT},
            {TileSpecification.OUT, TileSpecification.OUT, TileSpecification.THREE, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.THREE, TileSpecification.OUT, TileSpecification.OUT},
            {TileSpecification.OUT, TileSpecification.OUT, TileSpecification.OUT, TileSpecification.FOUR, TileSpecification.TWO, TileSpecification.TWO, TileSpecification.OUT, TileSpecification.OUT, TileSpecification.OUT},
            {TileSpecification.OUT, TileSpecification.OUT, TileSpecification.OUT, TileSpecification.OUT, TileSpecification.FOUR, TileSpecification.THREE, TileSpecification.OUT, TileSpecification.OUT, TileSpecification.OUT},
    };
    /**
     * initial_config once it's set, you don't need to modify it
     */

    private final LivingRoomSlot[][] livingRoomBoard = new LivingRoomSlot[9][9];

    /**
     * Initializing objects of Matrix initial_config
     */
    private void initializeBoard() {
        for (int r = 0; r < this.initial_config.length; r++) {
            for (int c = 0; c < this.initial_config[0].length; c++) {
                this.livingRoomBoard[r][c] = new LivingRoomSlot(this.initial_config[r][c]);
            }
        }
    }

    public LivingRoomBoard() {
        this.initializeBoard();
    }


    public void setItemOnBoard(TileType item, int i, int j) {

        this.livingRoomBoard[i][j].setItem(item);
        this.livingRoomBoard[i][j].setTilePresent();

    }

    public boolean getItemStatus(int x, int y) {
        return this.livingRoomBoard[x][y].isTilePresent();
    }


    public void getStatus() {
        for (LivingRoomSlot[] boardSlots : this.livingRoomBoard) {
            for (LivingRoomSlot boardSlot : boardSlots) {


                switch (boardSlot.getTileSpecification()) {
                    case TWO -> System.out.print("_2_ ");
                    case THREE -> System.out.print("_3_ ");
                    case FOUR -> System.out.print("_4_ ");
                    default -> System.out.print("OUT ");
                }

            }
            System.out.println();
        }
    }

    public boolean doINeedRefill() {


        this.refillToDo = true;

        for (int i = 0; i < this.livingRoomBoard.length; i++) {

            for (int j = 0; j < this.livingRoomBoard[i].length; j++) {


                switch (this.livingRoomBoard[i][j].getTileSpecification()) {

                    case TWO: {
                        if (this.livingRoomBoard[i - 1][j].isTilePresent()) {
                            this.refillToDo = false;
                            break;

                            // potrei anche scrivere direttamente return false
                            // ed evitare di tenere refillToDo Come una variabile booleana
                        }
                        if (this.livingRoomBoard[i][j + 1].isTilePresent()) {
                            this.refillToDo = false;
                            break;
                        }
                        if (this.livingRoomBoard[i + 1][j].isTilePresent()) {
                            this.refillToDo = false;
                            break;
                        }
                        if (this.livingRoomBoard[i][j - 1].isTilePresent()) {
                            this.refillToDo = false;
                            break;
                        }

                    }
                    case THREE: {
                        if ((i - 1) > 0 && (this.livingRoomBoard[i - 1][j].isTilePresent())) {
                            this.refillToDo = false;
                            break;
                        }
                        if ((j + 1) < 8 && (this.livingRoomBoard[i][j + 1].isTilePresent())) {
                            this.refillToDo = false;
                            break;
                        }
                        if ((i + 1) < 8 && (this.livingRoomBoard[i + 1][j].isTilePresent())) {
                            this.refillToDo = false;
                            break;
                        }
                        if ((j - 1) > 0 && (this.livingRoomBoard[i][j - 1].isTilePresent())) {
                            this.refillToDo = false;
                            break;
                        }

                    }
                    case FOUR: {
                        if ((i - 1) > 0 && (this.livingRoomBoard[i - 1][j].isTilePresent())) {
                            this.refillToDo = false;
                            break;
                        }
                        if ((j + 1) < 8 && (this.livingRoomBoard[i][j + 1].isTilePresent())) {
                            this.refillToDo = false;
                            break;
                        }
                        if ((i + 1) < 8 && (this.livingRoomBoard[i + 1][j].isTilePresent())) {
                            this.refillToDo = false;
                            break;
                        }
                        if ((j - 1) > 0 && (this.livingRoomBoard[i][j - 1].isTilePresent())) {
                            this.refillToDo = false;
                            break;
                        }

                    }
                    case OUT: {
                        break;
                    }
                }
            }
        }

        return this.refillToDo;

    }

    public boolean canIExtractTiles (ArrayList<TileToExtract> listaTessere){

        this.youCanExtract= true;

        int Column1 = listaTessere.get(0).getColumn();
        int Row1 = listaTessere.get(0).getRow();

        int Column2 = listaTessere.get(1).getColumn();
        int Row2 = listaTessere.get(1).getRow();

        int Column3 = listaTessere.get(3).getColumn();
        int Row3 = listaTessere.get(3).getRow();



        int dimensioneArrayList = listaTessere.size();

        switch (dimensioneArrayList) {

            // in questo caso controllo solo se ha almeno un lato libero
            case 1: {

                if ((Row1 - 1) < 0) {
                    break;
                } else {

                    if (!(this.livingRoomBoard[Row1 - 1][Column1].isTilePresent()))
                        youCanExtract = true;
                }

                if (Column1 + 1 > 8) {
                    break;
                } else {

                    if (!(this.livingRoomBoard[Row1][Column1 + 1].isTilePresent()))
                        youCanExtract = true;
                }

                if (Row1 + 1 > 8) {
                    break;
                } else {

                    if (!(this.livingRoomBoard[Row1 + 1][Column1].isTilePresent()))
                        youCanExtract = true;
                }

                if (Column1 - 1 < 0) {
                    break;
                } else {

                    if (!(this.livingRoomBoard[Row1][Column1 - 1].isTilePresent()))
                        youCanExtract = true;
                }
            }

            case 2: {

                if (Row1 == Row2) {

                    if ((Column1 == Column2 + 1) || (Column1 == Column2 - 1)) {

                        //analisi tessere libere
                    }
                }

                if (Column1 == Column2) {

                    if ((Row1 == Row2 + 1) || (Row1 == Row2 - 1)) {

                        //analisi tessere libere
                    }
                }

            }










            }



            case 3:

            default:
                break;

            }

        }
    }
}

















