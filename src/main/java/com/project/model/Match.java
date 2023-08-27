package com.project.model;

import java.time.LocalTime;
import com.project.data.*;

public class Match {
    String homeClubName, visitorClubName;
    String homeClubState, visitorClubState;
    int homeScore, visitorScore;
    LocalTime matchTime;

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
