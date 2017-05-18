package ch.hesge.steeve.presentation;

import ch.hesge.steeve.metier.ListDices;
/**
 * Author : Steeve Gerson
 */
public class Game {
    private static final String VICTORY = "Gagné!", DEFEAT = "Perdu";
    private static final int MAX_TRIES = 3;
    private static int cptLancer;
    private static boolean isWinningResult;

    public Game() {
        cptLancer = 0;
        isWinningResult = false;
    }

    public void startGame() {
        ListDices des = initGame();
        play(des);
        checkGameResult();
    }

    private void checkGameResult() {
        System.out.println(isWinningResult ? VICTORY : DEFEAT);
    }

    private ListDices initGame() {
        return new ListDices(new ListDicesObserver(this));
    }

    private void play(ListDices des) {
        while (nextThrow()) {
            throwDices(des);
        }
    }
    
    private void throwDices(ListDices des) {
        des.throwDices();
        cptLancer++;
        System.out.println(des);
    }

    private boolean nextThrow() {
        return cptLancer < MAX_TRIES && !isWinningResult;
    }

    public void setResult(boolean result) {
        isWinningResult = result;
    }
}
