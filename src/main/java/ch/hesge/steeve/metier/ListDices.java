package ch.hesge.steeve.metier;

import ch.hesge.steeve.domaine.Dice;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
/**
 * Author : Steeve Gerson
 */
public class ListDices extends Observable {

    private final ArrayList<Dice> lstDes = new ArrayList();
    private final int MAX_DES = 3;


    public ListDices(Observer observer) {
        if (observer != null) {
            addObserver(observer);
        }
        for (int i = 0; i < MAX_DES; i++) {
            lstDes.add(new Dice());
        }
    }

    public ArrayList<Dice> getLstDes() {
        return (ArrayList<Dice>) lstDes.clone();
    }

    public void throwDices() {
        for (int i = 0; i < lstDes.size(); i++) {
            lstDes.get(i).setValeur();
        }
        setChanged();
        notifyObservers(new Action(Action.DICES_THROWN));
    }

    @Override
    public String toString() {
        return getAffichage();
    }

    private String getAffichage() {
        StringBuilder strB = new StringBuilder("");
        for (Dice lstDe : lstDes) {
            strB.append(lstDe);
        }
        return strB.toString();
    }

}
