package proj.model;

import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by Ryan on 11/28/2014.
 */

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Team {
    private Integer id;
    private String bracket;
    private String name;
    private Integer rank;
    private RequestError error;

    public Team() {};

    public String getBracket() {
        return bracket;
    }

    public void setBracket(String bracket) {
        this.bracket = bracket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RequestError getError() {
        return error;
    }

    public void setError(RequestError error) {
        this.error = error;
    }
}
