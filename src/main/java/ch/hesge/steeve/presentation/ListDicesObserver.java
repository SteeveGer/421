package ch.hesge.steeve.presentation;

import ch.hesge.steeve.domaine.Dice;
import ch.hesge.steeve.metier.Action;
import ch.hesge.steeve.metier.ListDices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

/**
 * Author : Steeve Gerson
 */

public class ListDicesObserver implements Observer {
    private final int[] winningValues = {4, 2, 1};
    private Game game;

    public ListDicesObserver(Game game) {
        this.game = game;
    }

    public void update(Observable o, Object arg) {
        ListDices lstDes = (ListDices) o;
        Action action = (Action) arg;
        switch (action.getAction()) {
            case Action.DICES_THROWN:
                game.setResult(checkListeDes(lstDes.getLstDes()));
                break;
        }
    }

    private boolean checkListeDes(ArrayList<Dice> lstDes) {
        Collections.sort(lstDes);
        int nbWinningValues = getWinningValues(lstDes);
        return nbWinningValues == winningValues.length;
    }

    private int getWinningValues(ArrayList<Dice> lstDes) {
        int nbWinningValues = 0;
        for (int i = 0; i < lstDes.size(); i++) {
            if (lstDes.get(i).getValeur() == winningValues[i]) {
                nbWinningValues++;
            }
        }
        return nbWinningValues;
    }
}
