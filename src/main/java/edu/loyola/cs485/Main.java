package edu.loyola.cs485;

import java.sql.*;
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

        System.out.println("test");
    }
}
