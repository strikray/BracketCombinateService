package proj.services;

import proj.model.Team;
import proj.model.Teams;

import java.util.Collection;

/**
 * Created by Ryan on 11/28/2014.
 */
public interface TeamService {
    Teams getAllTeams();
    Team getTeamById(int id);
    Teams getSelectedTeams(int[] teamList);
}
