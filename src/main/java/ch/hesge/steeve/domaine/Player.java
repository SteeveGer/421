/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.steeve.domaine;

import ch.hesge.steeve.metier.ListDices;

/**
 *
 * @author Steeve
 */
public class Player {
    
    private static int cptLancer;
       private static final int MAX_TRIES = 3;
    
    public Player(int cptLancer){this.cptLancer = cptLancer;}
    
    private void throwDices(ListDices des) {
        des.throwDices();
        cptLancer++;
        System.out.println(des);
    }
    
    public void play(ListDices des) {
        while (nextThrow()) {
            throwDices(des);
        }
    }

    private boolean nextThrow() {
        return cptLancer < MAX_TRIES;
    }
}
