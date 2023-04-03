package Model.CommonGoals;

public class ScoringToken {
    private int value;

    /**
     * Constructor of class ScoringToken
     * @param value how many points the scoring token is worth
     */
    public ScoringToken(int value)
    {
        this.value = value;
    }

    /**
     * Getter method of value
     * @return how many points the scoring token is worth
     */
    public int getValue()
    {
        return value;
    }
}
