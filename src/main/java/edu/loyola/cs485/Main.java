package edu.loyola.cs485;

import edu.loyola.cs485.controller.LeagueService;
import edu.loyola.cs485.model.dao.LeagueDAO;
import edu.loyola.cs485.model.entity.League;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String ConUrl = "jdbc:mysql://localhost"; //protocol + url
    static String Port = "3306"; //default MySQL port
    static String Database = "soccer_group_asn"; // database/schema name
    static String Username = "bsmoore"; //read this from a local file
    static String Password = "1223711RMCF$"; //Also read this from a file

    static String url = ConUrl+":"+Port+"/"+Database+ "?user="+Username+"&password="+Password;


    public static void main(String[] args) {




        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            LeagueDAO leagueDB = new LeagueDAO();
            LeagueService servicer = new LeagueService();

            switch (choice) {
                case 1:
                    System.out.println("Whats the name of the league?");
                    String leagueName = scanner.next();
                    System.out.println("What country is it in?");
                    String leagueCountry = scanner.next();
                    try {
                        League newLeague = servicer.createLeague(leagueName, leagueCountry);
                        leagueDB.create(newLeague);

                    } catch (Exception e){
                        System.out.println(e);
                    }

                case 2:
                    System.out.println("Do you want to list the whole table or do you want to print by ID? (1 for whole table, 2 for by ID)");
                    choice = scanner.nextInt();
                    if (choice == 1){
                        try {
                            List<League> arrLeagues = servicer.getALLLeagues();
                            for (League league : arrLeagues){
                                System.out.println(league);
                            }
                        }catch (Exception e){
                            System.out.println(e);
                        }
                    }
                    else{
                        System.out.println("What is the ID of the league to print?");

                        int idLeague = scanner.nextInt();
                        try {
                            leagueDB.read(idLeague);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }

                case 3:
                    System.out.println("Whats the ID to update?");
                    int idUpdate = scanner.nextInt();
                    System.out.println("What do you want to update? \n" +
                            "1 - Name of League\n" +
                            "2 - Country of League");
                    choice = scanner.nextInt();
                    League tempLeague = new League();
                    try {
                        tempLeague = leagueDB.read(idUpdate);

                        if (choice == 1) {
                            System.out.println("New League Name:");
                            String newName = scanner.next();
                            tempLeague.setName_league(newName);
                        } else{
                            System.out.println("New League Country: ");
                            String newCountry = scanner.next();
                            tempLeague.setCountry(newCountry);
                        }
                        leagueDB.update(tempLeague);
                    } catch (Exception e){
                        System.out.println(e);
                    }
                case 4:
                    System.out.println("What is the ID of the league to delete?");
                    int leagueDeleteID = scanner.nextInt();
                    try {
                        servicer.deleteLeague(leagueDeleteID);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                case 5:
                    System.out.println("Exiting program...");
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();


    }


}
