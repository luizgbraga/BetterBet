package com.project.model;

/**
 * Classe que identifica os clubes
 * @author Diogo Laurindo
 */
public class Club {
    String clubName, clubState;
    int victories;
    int losses;

    /**
     * Construtor que recebe o nome do clube e o estado ao qual pertence
     * @param name
     * @param state
     */
    public Club(String name, String state) {
        clubName = name;
        clubState = state;
    }
}
