package ch.hesge.steeve.metier;

/**
 * Author : John Cheng
 * Created on 16.05.17
 */

public class Action {

    public static final int DICES_THROWN = 1;

    private int action;

    public Action(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }
}
