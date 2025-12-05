package edu.loyola.cs485.model.dao;

import edu.loyola.cs485.model.entity.League;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class LeagueDAOTest {

    @Test
    public void testFake(){
        assertAll(
                () -> assertEquals(1,1)
        );
    }

    @Test
    public void testCreateLeague() throws Exception{
        LeagueDAO dao = new LeagueDAO();


        League League = new League();
        League.setName_league("Test League");
        League.setCountry("Test Country");

        dao.create(League); // Method Under Test

        //clean up
        dao.delete( League.getID() );

        assertAll(
                () -> assertNotNull( League.getID() )
        );
    }

    @Test
    public void testReadLeague() throws Exception{
        LeagueDAO dao = new LeagueDAO();

        League League = new League();
        League.setName_league("Test League");
        League.setCountry("Test Country");

        dao.create(League);
        League found = dao.read(League.getID()); //Function under test

        //clean up
        dao.delete( League.getID() );

        assertAll(
                () -> assertEquals(found.getID(), League.getID()),
                () -> assertEquals(found.getName_league(), League.getName_league()),
                () -> assertEquals(found.getCountry(), League.getCountry())
        );

    }

    @Test
    public void testReadLeagueDoesNotExist() throws Exception{
        LeagueDAO dao = new LeagueDAO();

        League found = dao.read(10);
        assertAll(
                () -> assertNull( found.getID() ),
                () -> assertNull( found.getName_league() )
        );
    }

    @Test
    public void testListLeague() throws Exception{
        LeagueDAO dao = new LeagueDAO();

        List<League> lst = dao.list();
        assertAll(
                () -> assertEquals(0, lst.size())
        );

    }
}