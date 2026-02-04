package org.tesji.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.tesji.db.Db;
import org.tesji.dto.Greeting;

public class GreetingDAO {

    public void insert(String name, String email) throws Exception {

        String sql = "INSERT INTO saludos(name,email) VALUES (?,?)";

        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
        }
        
        System.out.println("Guardado en la base de datos: " + name);
    }
    
    public List<Greeting> findAll() throws Exception {

        List<Greeting> list = new ArrayList<>();

        String sql = "SELECT id, name, created_at FROM saludos ORDER BY created_at DESC";

        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Greeting(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getTimestamp("created_at")
                ));
            }
        }

        return list;
    }
    
    public void deleteById(int id) throws Exception {

        String sql = "DELETE FROM saludos WHERE id = ?";

        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
    public void updateName(int id, String name) throws Exception {

        String sql = "UPDATE saludos SET name = ? WHERE id = ?";

        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
    
    public Greeting findById(int id) throws Exception {

        String sql = "SELECT id, name, created_at FROM saludos WHERE id = ?";

        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Greeting(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at")
                    );
                }
            }
        }

        return null;
    }
    
}