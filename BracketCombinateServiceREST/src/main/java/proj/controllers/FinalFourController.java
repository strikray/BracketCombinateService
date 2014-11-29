package proj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proj.model.*;
import proj.services.FinalFourService;

/**
 * Created by Ryan on 11/29/2014.
 */
@Controller
@RequestMapping("/FinalFour")
public class FinalFourController {
    private final FinalFourService finalFourService;

    @Autowired
    public FinalFourController (FinalFourService finalFourService) {
        this.finalFourService = finalFourService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    FinalFour getRandomFinalFour() {

        return finalFourService.getRandomFinalFour();
    }

    @RequestMapping(value="/pick", method = RequestMethod.GET)
    public @ResponseBody
    FinalFour paramsPickFinalFour(@RequestParam("teamIDs") String teamIDs) {

        String[] ids = teamIDs.split(",");
        int[] teamList = new int[ids.length];
        for (int i=0; i<ids.length; i++)
        {
            try {
                teamList[i] = Integer.parseInt(ids[i]);
            } catch (NumberFormatException nfe) {};
        }

        return finalFourService.getSelectedFinalFour(teamList);
    }

    @RequestMapping(value="/teamIDs/{teamIDs}", method = RequestMethod.GET)
    public @ResponseBody
    FinalFour pathPickFinalFour(@PathVariable("teamIDs") String teamIDs) {

        String[] ids = teamIDs.split(",");
        int[] teamList = new int[ids.length];
        for (int i=0; i<ids.length; i++)
        {
            try {
                teamList[i] = Integer.parseInt(ids[i]);
            } catch (NumberFormatException nfe) {};
        }

        return finalFourService.getSelectedFinalFour(teamList);
    }

    @RequestMapping(value="/champions", method = RequestMethod.GET)
         public @ResponseBody
         FinalFour getRandomFinalFourChampions() {

         return finalFourService.getRandomFinalFourChampions();
    }

    // This is handling param arguments
    @RequestMapping(value="/champions/pick", method = RequestMethod.GET)
    public @ResponseBody
    FinalFour paramsPickFinalFourChampions(@RequestParam("teamIDs") String teamIDs, @RequestParam("southEastChampion") String southEastChampion, @RequestParam("westMidwestChampion") String westMidwestChampion, @RequestParam("nationalChampion") String nationalChampion) {

        String[] ids = teamIDs.split(",");
        int[] teamList = new int[ids.length];
        for (int i=0; i<ids.length; i++)
        {
            try {
                teamList[i] = Integer.parseInt(ids[i]);
            } catch (NumberFormatException nfe) {};
        }

        return finalFourService.getSelectedFinalFourChampions(teamList, southEastChampion, westMidwestChampion, nationalChampion);
    }

    // This is handling path arguments
    @RequestMapping(value="/champions/teamIDs/{teamIDs}/southEastChampion/{southEastChampion}/westMidwestChampion/{westMidwestChampion}/nationalChampion/{nationalChampion}", method = RequestMethod.GET)
    public @ResponseBody
    FinalFour pathPickFinalFourChampions(@PathVariable("teamIDs") String teamIDs, @PathVariable("southEastChampion") String southEastChampion, @PathVariable("westMidwestChampion") String westMidwestChampion, @PathVariable("nationalChampion") String nationalChampion) {

        String[] ids = teamIDs.split(",");
        int[] teamList = new int[ids.length];
        for (int i=0; i<ids.length; i++)
        {
            try {
                teamList[i] = Integer.parseInt(ids[i]);
            } catch (NumberFormatException nfe) {};
        }

        return finalFourService.getSelectedFinalFourChampions(teamList, southEastChampion, westMidwestChampion, nationalChampion);
    }
}
