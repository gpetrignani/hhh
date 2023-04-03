package Model.CommonGoals;

//import it.polimi.ingsw.Model.PersonalGoalCards.*;

public class CommonGoalCardFactory {

    /**
     * Factory method
     * @param cardId is the Id of the card that will be created
     * @return a CommonGoalCard depending on the cardId given
     */
    public CommonGoalCard createCommonGoalCard(int cardId) throws IndexOutOfBoundsException {

        return switch (cardId)
                {
                    case 1 -> new CommonGoalCard1(cardId);
                    case 2 -> new CommonGoalCard2(cardId);
                    case 3 -> new CommonGoalCard3(cardId);
                    case 4 -> new CommonGoalCard4(cardId);
                    case 5 -> new CommonGoalCard5(cardId);
                    case 6 -> new CommonGoalCard6(cardId);
                    case 7 -> new CommonGoalCard7(cardId);
                    case 8 -> new CommonGoalCard8(cardId);
                    case 9 -> new CommonGoalCard9(cardId);
                    case 10 -> new CommonGoalCard10(cardId);
                    case 11 -> new CommonGoalCard11(cardId);
                    case 12 -> new CommonGoalCard12(cardId);
                    default -> throw new IndexOutOfBoundsException("Invalid cardId");
                };
    }
}
