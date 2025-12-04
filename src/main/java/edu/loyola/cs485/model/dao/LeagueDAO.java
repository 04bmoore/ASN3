package edu.loyola.cs485.model.dao;

import edu.loyola.cs485.model.entity.League;
import edu.loyola.cs485.model.dao.AbstractDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeagueDAO extends AbstractDAO<League> {
    @Override
    public void create(League entity) throws SQLException {
        Connection con = getConnection(); // Always open a connection

        String sql = "INSERT INTO League (name_league, country) VALUES (?, ?)";
        PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, entity.getName_league());
        pst.setString(2, entity.getCountry());
        pst.executeUpdate();

        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            entity.setID(rs.getInt(1));
        }

        con.close(); // Dont forget to close it
    }

    @Override
    public League read(int ID) throws SQLException {
        League readLeague = new League();
        Connection con = getConnection();

        String sql = "SELECT * FROM League WHERE ID_League = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ID);
        ResultSet Rs = pst.executeQuery();
        if (Rs.next()) { //IF because there should be 1 or 0 results
            readLeague.setID(Rs.getInt("ID_League"));
            readLeague.setName_league(Rs.getString("name_league"));
            readLeague.setCountry(Rs.getString("country"));
        }

        con.close();
        return readLeague;
    }

    @Override
    public void update(League entity) throws SQLException {
        Connection con = getConnection();

        String sql = "UPDATE League SET name_league = ?, country = ? WHERE ID_League = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, entity.getName_league());
        pst.setString(2, entity.getCountry());
        pst.setInt(3, entity.getID());

        pst.executeUpdate();

        con.close();
    }

    @Override
    public void delete(int ID) throws SQLException {
        Connection con = getConnection();
        String sql = "DELETE FROM League WHERE ID_League = ?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ID);
        pst.executeUpdate();

        con.close();
    }

    @Override
    public List<League> list() throws SQLException {
        ArrayList<League> lstLeague = new ArrayList<>();

        Connection con = getConnection();
        String sql = "SELECT * FROM League ORDER BY name_league ";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) { // While there is a next row of results
            League c = new League();
            c.setID( rs.getInt("ID_League") );
            c.setName_league( rs.getString("name_league") );
            c.setCountry( rs.getString("country") );

            lstLeague.add( c ); // add client to our Collection
        }

        return lstLeague;
    }
}
