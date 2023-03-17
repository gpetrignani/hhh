public class LivingRoomBoard {

    BoardSlot[][] livingRoomBoard = new BoardSlot[9][9];


    /*public int getLivingRoomBoardSize (){
        int LivRomBoaSiz = livingRoomBoard.length;
        return LivRomBoaSiz;
    }*/


    public void initializeBoard() {


//        for(int i = 0; i < livingRoomBoard.length; i++){
//            for( int j= 0; j < livingRoomBoard[i].length; j++) {
//                livingRoomBoard[i][j] = new BoardSlot();
//            }
//        }

        //livingRoomBoard[0][0] = new BoardSlot();



        livingRoomBoard[0][0] = new BoardSlot(TileType.OUT);

        livingRoomBoard[0][1].BoardSlotInOut(false);
        livingRoomBoard[0][2].BoardSlotInOut(false);

        livingRoomBoard[0][3].BoardSlotInOut(true);
        livingRoomBoard[0][3].threePlayerSlotGame(true);
        livingRoomBoard[0][4].BoardSlotInOut(true);
        livingRoomBoard[0][4].fourPlayerSlotGame(true);

        livingRoomBoard[0][5].BoardSlotInOut(false);
        livingRoomBoard[0][6].BoardSlotInOut(false);
        livingRoomBoard[0][7].BoardSlotInOut(false);
        livingRoomBoard[0][8].BoardSlotInOut(false);

        livingRoomBoard[1][0].BoardSlotInOut(false);
        livingRoomBoard[1][1].BoardSlotInOut(false);
        livingRoomBoard[1][2].BoardSlotInOut(false);

        livingRoomBoard[1][3].BoardSlotInOut(true);
        livingRoomBoard[1][4].BoardSlotInOut(true);
        livingRoomBoard[1][5].BoardSlotInOut(true);
        livingRoomBoard[1][5].fourPlayerSlotGame(true);


        livingRoomBoard[1][6].BoardSlotInOut(false);
        livingRoomBoard[1][7].BoardSlotInOut(false);
        livingRoomBoard[1][8].BoardSlotInOut(false);

        livingRoomBoard[2][0].BoardSlotInOut(false);
        livingRoomBoard[2][1].BoardSlotInOut(false);

        livingRoomBoard[2][2].BoardSlotInOut(true);
        livingRoomBoard[2][2].threePlayerSlotGame(true);

        livingRoomBoard[2][3].BoardSlotInOut(true);
        livingRoomBoard[2][4].BoardSlotInOut(true);
        livingRoomBoard[2][5].BoardSlotInOut(true);
        livingRoomBoard[2][6].BoardSlotInOut(true);
        livingRoomBoard[2][6].threePlayerSlotGame(true);

        livingRoomBoard[2][7].BoardSlotInOut(false);
        livingRoomBoard[2][8].BoardSlotInOut(false);

        livingRoomBoard[3][0].BoardSlotInOut(false);

        livingRoomBoard[3][1].BoardSlotInOut(true);
        livingRoomBoard[3][1].fourPlayerSlotGame(true);

        livingRoomBoard[3][2].BoardSlotInOut(true);
        livingRoomBoard[3][3].BoardSlotInOut(true);
        livingRoomBoard[3][4].BoardSlotInOut(true);
        livingRoomBoard[3][5].BoardSlotInOut(true);
        livingRoomBoard[3][6].BoardSlotInOut(true);
        livingRoomBoard[3][7].BoardSlotInOut(true);
        livingRoomBoard[3][8].BoardSlotInOut(true);
        livingRoomBoard[3][8].threePlayerSlotGame(true);

        livingRoomBoard[4][0].BoardSlotInOut(true);
        livingRoomBoard[4][0].fourPlayerSlotGame(true);

        livingRoomBoard[4][1].BoardSlotInOut(true);
        livingRoomBoard[4][2].BoardSlotInOut(true);
        livingRoomBoard[4][3].BoardSlotInOut(true);
        livingRoomBoard[4][4].BoardSlotInOut(true);
        livingRoomBoard[4][5].BoardSlotInOut(true);
        livingRoomBoard[4][6].BoardSlotInOut(true);
        livingRoomBoard[4][7].BoardSlotInOut(true);
        livingRoomBoard[4][8].BoardSlotInOut(true);
        livingRoomBoard[4][8].fourPlayerSlotGame(true);

        livingRoomBoard[5][0].BoardSlotInOut(true);
        livingRoomBoard[5][0].threePlayerSlotGame(true);


        livingRoomBoard[5][1].BoardSlotInOut(true);
        livingRoomBoard[5][2].BoardSlotInOut(true);
        livingRoomBoard[5][3].BoardSlotInOut(true);
        livingRoomBoard[5][4].BoardSlotInOut(true);
        livingRoomBoard[5][5].BoardSlotInOut(true);
        livingRoomBoard[5][6].BoardSlotInOut(true);
        livingRoomBoard[5][7].BoardSlotInOut(true);
        livingRoomBoard[5][7].fourPlayerSlotGame(true);

        livingRoomBoard[5][8].BoardSlotInOut(false);

        livingRoomBoard[6][0].BoardSlotInOut(false);
        livingRoomBoard[6][1].BoardSlotInOut(false);

        livingRoomBoard[6][2].BoardSlotInOut(true);
        livingRoomBoard[6][2].threePlayerSlotGame(true);

        livingRoomBoard[6][3].BoardSlotInOut(true);
        livingRoomBoard[6][4].BoardSlotInOut(true);
        livingRoomBoard[6][5].BoardSlotInOut(true);
        livingRoomBoard[6][6].BoardSlotInOut(true);
        livingRoomBoard[6][6].threePlayerSlotGame(true);

        livingRoomBoard[6][7].BoardSlotInOut(false);
        livingRoomBoard[6][8].BoardSlotInOut(false);

        livingRoomBoard[7][0].BoardSlotInOut(false);
        livingRoomBoard[7][1].BoardSlotInOut(false);
        livingRoomBoard[7][2].BoardSlotInOut(false);

        livingRoomBoard[7][3].BoardSlotInOut(true);
        livingRoomBoard[7][3].fourPlayerSlotGame(true);
        livingRoomBoard[7][4].BoardSlotInOut(true);
        livingRoomBoard[7][5].BoardSlotInOut(true);

        livingRoomBoard[7][6].BoardSlotInOut(false);
        livingRoomBoard[7][7].BoardSlotInOut(false);
        livingRoomBoard[7][8].BoardSlotInOut(false);

        livingRoomBoard[8][0].BoardSlotInOut(false);
        livingRoomBoard[8][1].BoardSlotInOut(false);
        livingRoomBoard[8][2].BoardSlotInOut(false);
        livingRoomBoard[8][3].BoardSlotInOut(false);

        livingRoomBoard[8][4].BoardSlotInOut(true);
        livingRoomBoard[8][4].fourPlayerSlotGame(true);
        livingRoomBoard[8][5].BoardSlotInOut(true);
        livingRoomBoard[8][5].threePlayerSlotGame(true);

        livingRoomBoard[8][6].BoardSlotInOut(false);
        livingRoomBoard[8][7].BoardSlotInOut(false);
        livingRoomBoard[8][8].BoardSlotInOut(false);
    }

    public void getStatus(){

        for(int i = 0; i < livingRoomBoard.length; i++){
            for( int j= 0; j < livingRoomBoard[i].length; j++) {

                if (livingRoomBoard[i][j].isInOut()) {
                    System.out.print("-");

                    if (livingRoomBoard[i][j].isFourPlayerSlot())
                        System.out.print("4 ");
                    else if (livingRoomBoard[i][j].isThreePlayerSlot())
                        System.out.print("3 ");
                    else
                        System.out.print("2 ");
                }
                else
                    System.out.print("OUT ");

                if (j == 8)
                    System.out.println("");

            }
        }

    }



}
