package proj.services;

import proj.model.FinalFour;
import proj.model.Team;
import proj.model.Teams;

/**
 * Created by Ryan on 11/29/2014.
 */
public interface FinalFourService {
    Team getRandomSouthTeam();
    Team getRandomEastTeam();
    Team getRandomWestTeam();
    Team getRandomMidWestTeam();
    FinalFour getRandomFinalFour();
    FinalFour getSelectedFinalFour(int[] teamList);
    FinalFour getRandomFinalFourChampions();
    FinalFour getSelectedFinalFourChampions(int[] teamList, String southEastChampion, String westMidwestChampion, String nationalChampion);
}
