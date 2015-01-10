package air.balloon.tennis.model;

import java.util.List;

/**
 * Created by oliver on 5/13/14.
 */
public class TennisUserDTO {

    List<TennisUser> results;

    public List<TennisUser> getUser_TennisUser_List() {
        return results;
    }

    public void setUser_TennisUser_List(List<TennisUser> results) {
        this.results = results;
    }
}
