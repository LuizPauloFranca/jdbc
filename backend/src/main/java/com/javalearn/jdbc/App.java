package com.javalearn.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        Movie movie = new Movie();
        MovieDAO dao = new MovieDAO();

        List<Movie> ListMovies = new ArrayList<Movie>();

        int option = 0;

        do{

            System.out.println("----------| MENU |----------");
            System.out.println("1 - List all movies");
            System.out.println("2 - Insert a new movie");
            System.out.println("3 - Update a movie");
            System.out.println("4 - Delete a movie");
            System.out.println("0 - Exit");
            System.out.println("----------------------------");

            System.out.println("Enter your choice here: ");

            option = Integer.parseInt(sc.nextLine());

            switch (option){

                case 1:

                    System.out.println("### Your choice is: To list movies ### ");

                    System.out.println();

                    ArrayList<Movie> data = (ArrayList<Movie>) dao.findAll();

                    for(Movie movies : data){

                        System.out.println("Id: " + movies.getId() + " - Name: " + movies.getName());

                    }

                    break;

                case 2:

                    System.out.println("### Your choice is: Insert a new movie ###");

                    System.out.println();

                    System.out.println("Enter movie name: ");

                    movie.setName(sc.nextLine());

                    dao.insert(movie);

                    break;

                case 3:

                    System.out.println("### Your choice is: Update a movie ###");

                    System.out.println();

                    System.out.println("Enter movie id");

                    Integer id = Integer.parseInt(sc.nextLine());

                    Movie movieExists = dao.findById(id);

                    if(movieExists != null){

                        System.out.println("Enter new movie name: ");

                        movie.setName(sc.nextLine());
                        movie.setId(movieExists.getId());

                        dao.update(movie);

                    } else {

                        System.out.println("Movie does not exists");

                    }

                    break;

                case 4:

                    System.out.println("### Your choice is: Delete a movie ###");

                    System.out.println();

                    System.out.println("Enter movie id:");

                    Integer idDelete = Integer.parseInt(sc.nextLine());

                    Movie movieExistsDelete = dao.findById(idDelete);

                    if(movieExistsDelete != null){

                        dao.remove(movieExistsDelete);

                    } else {

                        System.out.println("Id does not exists");
                    }

                    break;

                case 0:
                    sc.close();
                    System.out.println("Thanks!");
                    break;

                default:

                    System.out.println("Sorry! Invalid option. Please choice a number between 0 and 4");

            }

        }while (option != 0);

    }

}
