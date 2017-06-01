package ch.hesge.steeve.domaine;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Author : Steeve Gerson
 */

public class DiceTest {
    private ArrayList<Dice> mockedList = mock(ArrayList.class);
    private int[] initialValues = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};

    @BeforeTest
    public void setUp() {
        for (int i = 0; i < 10; i++) {
            verify(mockedList).add(new Dice(initialValues[i]));
        }
    }

    @Test
    public void testGetValeur() throws Exception {
        when(mockedList.get(0).getValeur()).thenReturn(-1);
    }

    @Test
    public void testSetValeur() throws Exception {
        for (int i = 0; i < mockedList.size(); i++) {
            mockedList.get(i).setValeur();
            int diceValue = mockedList.get(i).getValeur();
            assertEquals(diceValue > 0 && (diceValue <= 6 && diceValue >= 1), true);
        }
    }

    @Test
    public void testCompareTo() throws Exception {
        for (int i = 0; i < mockedList.size() - 1; i++) {
            assertEquals(mockedList.get(i).compareTo(mockedList.get(i + 1)) < 0, true);
        }
    }

}