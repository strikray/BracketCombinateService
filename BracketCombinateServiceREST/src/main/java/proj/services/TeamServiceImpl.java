package proj.services;

import proj.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.ServletContext;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Ryan on 11/28/2014.
 */

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    ServletContext servletContext;

    @Autowired
    DbMock dbService;

    static HashMap<Integer, Team> teamDB = null;

    @Override
    public Teams getAllTeams(){

        Teams tList = new Teams();
        Collection<Team> teamList = dbService.getAllTeams();
        if (teamList != null) {
            tList.setTeams(teamList);
        }
        else {
            RequestError requestError = new RequestError(400,
                    "Please check server logs, an unexpected error has happened");
            tList.setError(requestError);
        }

        return tList;
    }

    @Override
    public Team getTeamById(int id){

        Team theTeam = dbService.getTeamById(id);
        if (theTeam == null){
            RequestError requestError = new RequestError(400,
                    "The requested inced "+id+" is invalid or not in range");
            theTeam = new Team();
            theTeam.setError(requestError);
        }

        return theTeam;
    }

    @Override
    public Teams getSelectedTeams(int[] teamList){
        Teams tList = new Teams();

        Collection<Team> selectedTeamList = null;
        for (int i=0; i<teamList.length; i++)
        {
            selectedTeamList.add(dbService.getTeamById(teamList[i]));
        }
        if (selectedTeamList != null) {
            tList.setTeams(selectedTeamList);
        }
        else {
            RequestError requestError = new RequestError(400,
                    "Please check server logs, an unexpected error has happened");
            tList.setError(requestError);
        }

        return tList;
    }
}
