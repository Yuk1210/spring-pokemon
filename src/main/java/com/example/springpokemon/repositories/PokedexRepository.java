package com.example.springpokemon.repositories;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.utility.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokedexRepository {

    public List<Pokemon> getALlFirePokemon() throws SQLException {
        List<Pokemon> allFirePokemon = new ArrayList<>();
        Connection database = new ConnectionManager().getConnection();

        try {
            PreparedStatement preparedStatement = database.prepareStatement("SELECT * FROM pokemon WHERE primary_type = ?");
            preparedStatement.setString(1, "Fire");
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Pokemon pokemon = new Pokemon(
                        rs.getInt("pokedex_number"),
                        rs.getString("name"),
                        rs.getInt("speed"),
                        rs.getInt("special_defence"),
                        rs.getInt("special_attack"),
                        rs.getInt("defence"),
                        rs.getInt("attack"),
                        rs.getInt("hp"),
                        rs.getString("primary_type"),
                        rs.getString("secondary_type")
                );
                allFirePokemon.add(pokemon);
            }
        } catch (SQLException e) {
            System.out.println("Could not prepare statement");;
        }
        return allFirePokemon;
    }

    public Pokemon getSingleById(String id) throws SQLException {
        Pokemon returnPokemon = null;
        Connection database = new ConnectionManager().getConnection();

        PreparedStatement preparedStatement = database.prepareStatement("SELECT * FROM pokemon WHERE pokedex_number = ?");
        preparedStatement.setInt(1, Integer.parseInt(id));
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        returnPokemon = new Pokemon(
                rs.getInt("pokedex_number"),
                rs.getString("name"),
                rs.getInt("speed"),
                rs.getInt("special_defence"),
                rs.getInt("special_attack"),
                rs.getInt("defence"),
                rs.getInt("attack"),
                rs.getInt("hp"),
                rs.getString("primary_type"),
                rs.getString("secondary_type")
        );
        return returnPokemon;
    }
}
