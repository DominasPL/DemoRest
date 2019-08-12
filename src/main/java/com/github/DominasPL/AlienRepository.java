package com.github.DominasPL;

import com.github.DominasPL.models.Alien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AlienRepository {

    private List<Alien> aliens;

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

//        try {
//
//            Statement st = this.conn.createStatement();
//            ResultSet resultSet = st.executeQuery(sql);
//
//
//            if (resultSet.next()) {
//                alien.setId(resultSet.getInt(1));
//                alien.setName(resultSet.getString(2));
//                alien.setPoints(resultSet.getInt(3));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//

        return alien;
    }


    public void create(Alien alien) {

        String sql = "INSERT INTO aliens VALUES (?,?,?)";
//
//        try {
//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//            preparedStatement.setInt(1, alien.getId());
//            preparedStatement.setString(2, alien.getName());
//            preparedStatement.setInt(3, alien.getPoints());
//
//            preparedStatement.executeUpdate(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
