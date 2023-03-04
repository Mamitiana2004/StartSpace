/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startspace.database.util;

import com.startspace.database.config.FileConfig;
import com.startspace.database.exception.DatabaseFileException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mamit
 */
public class Connect {
    public static String getUrl() {
        try {
            FileConfig fileConfig = new FileConfig();
            return fileConfig.get("url");
        } catch (DatabaseFileException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public static String getPort(){
        try {
            FileConfig fileConfig=new FileConfig();
            return fileConfig.get("port");
        } catch (DatabaseFileException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public static String getUser(){
        try {
            FileConfig fileConfig=new FileConfig();
            return fileConfig.get("user");
        } catch (DatabaseFileException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public static String getPassword(){
        try {
            FileConfig fileConfig=new FileConfig();
            return fileConfig.get("password");
        } catch (DatabaseFileException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public static String getDatabase(){
        try {
            FileConfig fileConfig=new FileConfig();
            return fileConfig.get("database");
        } catch (DatabaseFileException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public static String getDriver(){
        try {
            FileConfig fileConfig=new FileConfig();
            return fileConfig.get("driver");
        } catch (DatabaseFileException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName(Connect.getDriver());
            String url=getUrl()+getPort()+"/"+getDatabase();
            return DriverManager.getConnection(url, getUser(), getPassword());
        } catch (ClassNotFoundException ex) {
            System.err.println("Erreur de connection a la base de donne");
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
