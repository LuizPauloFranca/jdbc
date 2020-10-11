package com.javalearn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public MovieDAO(){
        conn = new ConnectionFactory().getConnection();
    }

    public List<Movie> findAll() throws SQLException {

        String query = "SELECT id, name FROM movies";

        List<Movie> movies = new ArrayList<Movie>();

        pstmt = conn.prepareStatement(query);

        ResultSet result = pstmt.executeQuery();

        while (result.next()){

            movies.add(new Movie(result.getInt("id"), result.getString("name")));

        }

        return movies;
    }

    public Movie findById(Integer id) throws SQLException {

        String query = "SELECT id, name FROM movies WHERE id = ?";

        pstmt = conn.prepareStatement(query);

        pstmt.setInt(1, id);

        ResultSet result = pstmt.executeQuery();

        Movie movie = null;

        while (result.next()){
            movie = new Movie(result.getInt("id"), result.getString("name"));
        }

        return movie;
    }

    public void insert(Movie movie) throws SQLException {

        String query = "INSERT INTO movies (name) VALUES (?)";

        pstmt = conn.prepareStatement(query);

        pstmt.setString(1, movie.getName());

        pstmt.execute();
    }

    public void update(Movie movie) throws SQLException {

        String query = "UPDATE movies SET name = ? WHERE id = ?";

        pstmt = conn.prepareStatement(query);

        pstmt.setString(1, movie.getName());

        pstmt.setInt(2, movie.getId());

        pstmt.execute();
    }

    public void remove(Movie movie) throws SQLException {

        String query = "DELETE FROM movies WHERE id = ?";

        pstmt = conn.prepareStatement(query);

        pstmt.setInt(1,movie.getId());

        pstmt.execute();
    }
}
