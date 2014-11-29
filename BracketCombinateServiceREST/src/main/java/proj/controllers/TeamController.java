package proj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ryan on 11/28/2014.
 */

import proj.model.*;
import proj.services.TeamService;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController (TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Teams getAllTeams() {
        //model.addAttribute("message", "Hello world!");
        return teamService.getAllTeams();
    }

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public @ResponseBody Team
    getDataInJSON(@PathVariable int id)
    {
        return teamService.getTeamById(id);
    }
}
