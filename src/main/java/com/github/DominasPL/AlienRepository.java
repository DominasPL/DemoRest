package com.github.DominasPL;

import com.github.DominasPL.models.Alien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AlienRepository {

    private Connection conn;

    public AlienRepository() {
        conn = CreateConnection.getConnection();
    }

    public List<Alien> getAliens() {

        List<Alien> aliens = new ArrayList<>();
        String sql = "SELECT * FROM alien";

        try {

            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);

            while (resultSet.next()) {

                Alien alien = new Alien();
                alien.setId(resultSet.getInt(1));
                alien.setName(resultSet.getString(2));
                alien.setPoints(resultSet.getInt(3));

                aliens.add(alien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aliens;
    }

    public Alien getAlien(int id) {

        String sql = "SELECT * FROM alien WHERE id =" + id;
        Alien alien = new Alien();

        try {

            Statement st = this.conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);


            if (resultSet.next()) {
                alien.setId(resultSet.getInt(1));
                alien.setName(resultSet.getString(2));
                alien.setPoints(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return alien;
    }


    public void create(Alien a) {

        String sql = "INSERT INTO alien VALUES (?,?,?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, a.getId());
            preparedStatement.setString(2, a.getName());
            preparedStatement.setInt(3, a.getPoints());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Alien alien) {

        String sql = "UPDATE alien SET name = ?, points = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, alien.getName());
            preparedStatement.setInt(2, alien.getPoints());
            preparedStatement.setInt(3, alien.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int id) {
        String sql = "DELETE FROM alien WHERE id = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
