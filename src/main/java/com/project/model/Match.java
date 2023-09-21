package com.project.model;

import java.time.LocalTime;

/**
 * Classe que representa a partida
 * @author Diogo Laurindo
 */
public class Match {
    String homeClubName, visitorClubName;
    String homeClubState, visitorClubState;
    int homeScore, visitorScore;
    LocalTime matchTime;

    /**
     * Construtor que recebe dados da partida e cria a mesma
     * @param homeClubName
     * @param visitorClubName
     * @param homeClubState
     * @param visitorClubState
     * @param homeScore
     * @param visitorScore
     * @param matchTime
     */
    public Match (String homeClubName, String visitorClubName, String homeClubState,
                String visitorClubState, int homeScore, int visitorScore, String matchTime) {
        this.homeClubName = homeClubName;
        this.visitorClubName = visitorClubName;
        this.homeClubState = homeClubState;
        this.visitorClubState = visitorClubState;
        this.homeScore = homeScore;
        this.visitorScore = visitorScore;
        this.matchTime = LocalTime.parse(matchTime);
    }
}
