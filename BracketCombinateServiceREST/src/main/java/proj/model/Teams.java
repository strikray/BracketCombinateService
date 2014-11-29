package proj.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Ryan on 11/28/2014.
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Teams {

    private Collection<Team> teams = null;
    private RequestError error;

    public RequestError getError() {
        return error;
    }

    public void setError(RequestError error) {
        this.error = error;
    }

    public Collection<Team> getTeams() {
        return teams;
    }

    public void setTeams(Collection<Team> teams) {
        this.teams = teams;
    }
}
