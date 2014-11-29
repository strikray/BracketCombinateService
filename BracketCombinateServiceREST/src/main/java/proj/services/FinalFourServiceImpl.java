package proj.services;

import proj.model.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Ryan on 11/29/2014.
 */
@Service
public class FinalFourServiceImpl implements FinalFourService {

    @Autowired
    ServletContext servletContext;

    @Autowired
    DbMock dbService;

    static HashMap<Integer, Team> teamDB = null;

    @Override
    public Team getRandomSouthTeam() {
        Random random = new Random();
        Integer low = 1;
        Integer high = 17;
        Integer id = random.nextInt(high - low) + low;

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
    public Team getRandomEastTeam() {
        Random random = new Random();
        Integer low = 17;
        Integer high = 33;
        Integer id = random.nextInt(high - low) + low;

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
    public Team getRandomWestTeam() {
        Random random = new Random();
        Integer low = 33;
        Integer high = 49;
        Integer id = random.nextInt(high - low) + low;

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
    public Team getRandomMidWestTeam() {
        Random random = new Random();
        Integer low = 49;
        Integer high = 65;
        Integer id = random.nextInt(high - low) + low;

        Team theTeam = dbService.getTeamById(id);
        if (theTeam == null){
            RequestError requestError = new RequestError(400,
                    "The requested id "+id+" is invalid or not in range");
            theTeam = new Team();
            theTeam.setError(requestError);
        }

        return theTeam;
    }

    @Override
    public FinalFour getRandomFinalFour() {
        FinalFour finalFour = new FinalFour();

        Team southTeam = getRandomSouthTeam();
        Team eastTeam = getRandomEastTeam();
        Team westTeam = getRandomWestTeam();
        Team midwestTeam = getRandomMidWestTeam();

        finalFour.setSouthChampion(southTeam);
        finalFour.setEastChampion(eastTeam);
        finalFour.setWestChampion(westTeam);
        finalFour.setMidwestChampion(midwestTeam);

        return finalFour;
    }

    @Override
    public FinalFour getSelectedFinalFour(int[] teamList) {
        FinalFour finalFour = new FinalFour();

        Team southTeam = null;
        Team eastTeam = null;
        Team westTeam = null;
        Team midwestTeam = null;
        int size = 0;

        if( teamList.length > 4 )
        {
            size = 4;
        }
        else
        {
            size = teamList.length;
        }

        for (int i=0; i<size; i++)
        {
            if ( (teamList[i] <= 16) && (teamList[i] >=1) && (southTeam == null) )
            {
                southTeam = dbService.getTeamById(teamList[i]);
            }
            else if ((teamList[i] <= 32) && (teamList[i] >=17) && (eastTeam == null) )
            {
                eastTeam = dbService.getTeamById(teamList[i]);
            }
            else if ((teamList[i] <= 48) && (teamList[i] >=33) && (westTeam == null) )
            {
                westTeam = dbService.getTeamById(teamList[i]);
            }
            else if ((teamList[i] <= 64) && (teamList[i] >=49) && (midwestTeam == null) )
            {
                midwestTeam = dbService.getTeamById(teamList[i]);
            }
        }

        if (southTeam == null)
            southTeam = getRandomSouthTeam();

        if (eastTeam == null)
            eastTeam = getRandomEastTeam();

        if (westTeam == null)
            westTeam = getRandomWestTeam();

        if (midwestTeam == null)
            midwestTeam = getRandomMidWestTeam();

        finalFour.setSouthChampion(southTeam);
        finalFour.setEastChampion(eastTeam);
        finalFour.setWestChampion(westTeam);
        finalFour.setMidwestChampion(midwestTeam);

        return finalFour;
    }

    @Override
    public FinalFour getRandomFinalFourChampions() {
        Random random = new Random();

        FinalFour finalFour = getRandomFinalFour();

        if (random.nextBoolean())
        {
            finalFour.setSouthEastChampion(finalFour.getSouthChampion());
        }
        else
        {
            finalFour.setSouthEastChampion(finalFour.getEastChampion());
        }

        if (random.nextBoolean())
        {
            finalFour.setWestMidwestChampion(finalFour.getWestChampion());
        }
        else
        {
            finalFour.setWestMidwestChampion(finalFour.getMidwestChampion());
        }

        if (random.nextBoolean())
        {
            finalFour.setNationalChampion(finalFour.getSouthEastChampion());
        }
        else
        {
            finalFour.setNationalChampion(finalFour.getWestMidwestChampion());
        }

        return finalFour;
    }

    @Override
    public FinalFour getSelectedFinalFourChampions(int[] teamList, String southEastChampion, String westMidwestChampion, String nationalChampion) {
        Random random = new Random();

        FinalFour finalFour = getSelectedFinalFour(teamList);

        if (finalFour.getSouthChampion().getName().equals(southEastChampion)) {
            finalFour.setSouthEastChampion(finalFour.getSouthChampion());
        }
        else if (finalFour.getEastChampion().getName().equals(southEastChampion)) {
            finalFour.setSouthEastChampion(finalFour.getEastChampion());
        }
        else {
            if (random.nextBoolean())
            {
                finalFour.setSouthEastChampion(finalFour.getSouthChampion());
            }
            else
            {
                finalFour.setSouthEastChampion(finalFour.getEastChampion());
            }
        }

        if (finalFour.getWestChampion().getName().equals(westMidwestChampion)) {
            finalFour.setWestMidwestChampion(finalFour.getWestChampion());
        }
        else if (finalFour.getMidwestChampion().getName().equals(westMidwestChampion)) {
            finalFour.setWestMidwestChampion(finalFour.getMidwestChampion());
        }
        else {
            if (random.nextBoolean())
            {
                finalFour.setWestMidwestChampion(finalFour.getWestChampion());
            }
            else
            {
                finalFour.setWestMidwestChampion(finalFour.getMidwestChampion());
            }
        }

        if (finalFour.getSouthEastChampion().getName().equals(nationalChampion)) {
            finalFour.setNationalChampion(finalFour.getSouthEastChampion());
        }
        else if (finalFour.getWestMidwestChampion().getName().equals(nationalChampion)) {
            finalFour.setNationalChampion(finalFour.getWestMidwestChampion());
        }
        else {
            if (random.nextBoolean())
            {
                finalFour.setNationalChampion(finalFour.getSouthEastChampion());
            }
            else
            {
                finalFour.setNationalChampion(finalFour.getWestMidwestChampion());
            }
        }

        return finalFour;
    }
}
