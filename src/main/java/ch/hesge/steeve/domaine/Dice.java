package ch.hesge.steeve.domaine;
/**
 * Author : Steeve Gerson
 */
public class Dice implements Comparable {
    private int valeur;
    private final int BASE_DES = 6;

    public Dice() {
    }

    public Dice(int valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur() {
        valeur = calculerValeurDes();
    }

    private int calculerValeurDes() {
        Double tmp = Math.random() * BASE_DES + 1;
        return tmp.intValue();
    }

    @Override
    public String toString() {
        return Integer.toString(valeur);
    }

    public int compareTo(Object o) {
        return ((Dice) o).valeur - valeur;
    }

}
