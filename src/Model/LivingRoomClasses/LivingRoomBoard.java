package Model.LivingRoomClasses;


import java.util.ArrayList;


public class LivingRoomBoard {


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




        for (int i = 0; i < this.livingRoomBoard.length; i++) {

            for (int j = 0; j < this.livingRoomBoard[i].length; j++) {


                switch (this.livingRoomBoard[i][j].getTileSpecification()) {

                    case TWO: {

                        if (this.livingRoomBoard[i - 1][j].isTilePresent())
                            return false;


                        if (this.livingRoomBoard[i][j + 1].isTilePresent())
                            return false;


                        if (this.livingRoomBoard[i + 1][j].isTilePresent())
                            return false;


                        if (this.livingRoomBoard[i][j - 1].isTilePresent())
                            return false;



                    }

                    case THREE: {

                        if ((i - 1) > 0 && (this.livingRoomBoard[i - 1][j].isTilePresent()))
                            return false;

                        if ((j + 1) < 8 && (this.livingRoomBoard[i][j + 1].isTilePresent()))
                            return false;

                        if ((i + 1) < 8 && (this.livingRoomBoard[i + 1][j].isTilePresent()))
                            return false;

                        if ((j - 1) > 0 && (this.livingRoomBoard[i][j - 1].isTilePresent()))
                            return false;

                    }

                    case FOUR: {
                        if ((i - 1) > 0 && (this.livingRoomBoard[i - 1][j].isTilePresent()))
                            return false;

                        if ((j + 1) < 8 && (this.livingRoomBoard[i][j + 1].isTilePresent()))
                            return false;

                        if ((i + 1) < 8 && (this.livingRoomBoard[i + 1][j].isTilePresent()))
                            return false;

                        if ((j - 1) > 0 && (this.livingRoomBoard[i][j - 1].isTilePresent()))
                            return false;


                    }
                    case OUT: {
                        break;
                    }
                }
            }
        }

        return true;

    }

    public boolean canIExtractTiles (ArrayList<TileToExtract> listaTessere) {


        int Column1 = listaTessere.get(0).getColumn();
        int Row1 = listaTessere.get(0).getRow();

        int Column2 = listaTessere.get(1).getColumn();
        int Row2 = listaTessere.get(1).getRow();

        int Column3 = listaTessere.get(3).getColumn();
        int Row3 = listaTessere.get(3).getRow();


        boolean youCanExtract = false;

        int dimensioneArrayList = listaTessere.size();

        switch (dimensioneArrayList) {

            // in questo caso controllo solo se ha almeno un lato libero
            case 1: {

                if (doesTileHaveFreeEdge(Column1, Row1))
                    return true;
                break;
            }

            case 2: {

                if (Row1 == Row2) {

                    if ((Column1 == Column2 + 1) || (Column1 == Column2 - 1)) {

                        if (doesTileHaveFreeEdge(Column1, Row1) && doesTileHaveFreeEdge(Column2, Row2))
                            return true;


                    }
                }

                if (Column1 == Column2) {

                    if ((Row1 == Row2 + 1) || (Row1 == Row2 - 1)) {

                        if (doesTileHaveFreeEdge(Column1, Row1) && doesTileHaveFreeEdge(Column2, Row2))
                            return true;
                    }
                }
            }

            case 3: {

                if ((Row1 == Row2) && (Row2 == Row3)) {

                    if (((Column3 == Column1 + 2) && (Column2 == Column1 + 1)) || ((Column3 == Column1 + 1) && (Column2 == Column1 + 2)) || ((Column3 == Column1 + 1) && (Column2 == Column1 - 1)) ||
                            ((Column3 == Column1 - 1) && (Column2 == Column1 + 1)) || ((Column3 == Column1 - 1) && (Column2 == Column1 - 2)) || ((Column3 == Column1 - 2) && (Column2 == Column1 - 1))) {

                        if (doesTileHaveFreeEdge(Column1, Row1) && doesTileHaveFreeEdge(Column2, Row2) && doesTileHaveFreeEdge(Column3, Row3))
                            return true;
                    }
                }

                if  ((Column1 == Column2) && (Column2 == Column3)) {

                    if (((Row3 == Row1 + 2) && (Row2 == Row1 + 1)) || ((Row3 == Row1 + 1) && (Row2 == Row1 + 2)) || ((Row3 == Row1 + 1) && (Row2 == Row1 - 1)) ||
                            ((Row3 == Row1 - 1) && (Row2 == Row1 + 1)) || ((Row3 == Row1 - 1) && (Row2 == Row1 - 2)) || ((Row3 == Row1 - 2) && (Row2 == Row1 - 1))) {

                        if (doesTileHaveFreeEdge(Column1, Row1) && doesTileHaveFreeEdge(Column2, Row2) && doesTileHaveFreeEdge(Column3, Row3))
                            return true;
                    }
                }
            }
        }

        return false;

    }


    private boolean doesTileHaveFreeEdge(int Column , int Row ){

        if (( Row - 1 ) < 0 )
            return true;

        if (!(this.livingRoomBoard[Row - 1][Column].isTilePresent()))
            return true;

        if (( Column + 1 ) > 8 )
            return true;

        if (!(this.livingRoomBoard[Row][Column + 1].isTilePresent()))
            return true;

        if (( Column - 1 ) < 0 )
            return true;

        if (!(this.livingRoomBoard[Row][Column - 1].isTilePresent()))
            return true;

        return false;

    }









}


















