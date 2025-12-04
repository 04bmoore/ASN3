package edu.loyola.cs485.controller;

import edu.loyola.cs485.model.dao.LeagueDAO;
import edu.loyola.cs485.model.entity.League;
import java.util.List;

public class LeagueService {

    public League createLeague(String name, String country) throws Exception {
        League league = new League();
        league.setName_league(name);
        league.setCountry(country);

        LeagueDAO dao = new LeagueDAO();
        dao.create(league);

        return league;
    }

    public List<League> getALLLeagues() throws Exception {
        LeagueDAO dao = new LeagueDAO();
        return dao.list();
    }

    public void deleteLeague(int id) throws Exception {
        LeagueDAO dao = new LeagueDAO();
        dao.delete(id);
    }
}
