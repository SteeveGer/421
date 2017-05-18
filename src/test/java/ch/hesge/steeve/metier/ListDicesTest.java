package ch.hesge.steeve.metier;

import ch.hesge.steeve.domaine.Dice;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Author : Steeve Gerson
 */

public class ListDicesTest {
    private ArrayList<Dice> dices = new ArrayList<Dice>();
    private int[] initialValues = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};

    @BeforeTest
    public void setUp() {
        for (int i = 0; i < 10; i++) {
            dices.add(new Dice(initialValues[i]));
        }
    }

    @Test
    public void testThrowDices() throws Exception {
        for (int i = 0; i < dices.size(); i++) {
            dices.get(i).setValeur();
            int diceValue = dices.get(i).getValeur();
            assertEquals(diceValue > 0 && (diceValue <= 6 && diceValue >= 1), true);
        }
    }
}