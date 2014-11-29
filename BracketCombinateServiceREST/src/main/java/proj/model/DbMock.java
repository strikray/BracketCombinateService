package proj.model;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ryan on 11/28/2014.
 */
@Service
public class DbMock {

    @Autowired
    ServletContext servletContext;

    private HashMap<Integer,Team> teamCache = null;

    public HashMap<Integer,Team> getFullTeamList()
    {
        return queryTeams();
    }

    public Team getTeamById(int id)
    {
        HashMap<Integer,Team> teamDB = queryTeams();
        Integer index = new Integer(id);
        return teamDB.get(index);
    }

    public Collection<Team> getAllTeams()
    {
        HashMap<Integer,Team> teamDB = queryTeams();
        return teamDB.values();
    }

    private HashMap<Integer,Team> queryTeams()
    {
        if(teamCache != null) return teamCache;

        ObjectMapper mapper = new ObjectMapper();
        HashMap<Integer,Team> teamDB = new HashMap<Integer,Team>();

        try{
            File jsonDB = new File(servletContext.getRealPath("/WEB-INF/content/Teams.json"));
            List<Team> teamList = mapper.readValue(jsonDB, new TypeReference<List<Team>>(){});

            for( Team t : teamList)
            {
                Integer idx = new Integer(t.getId());
                teamDB.put(idx,t);
            }
            teamCache = teamDB;
            return teamDB;
        }catch(Exception e)
        {
            e.printStackTrace();
            teamCache = null;
            return null;
        }
    }
}
