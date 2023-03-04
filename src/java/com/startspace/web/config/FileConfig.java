/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startspace.web.config;

import com.startspace.database.exception.DatabaseFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mamit
 */
public class FileConfig {
    
    public static String get(File file,String property) throws DatabaseFileException{
        try (Scanner scan=new Scanner(file)){
            while(scan.hasNext()){
                String line=scan.next();
                if(line.split("=")[0].equalsIgnoreCase(property)){
                    return line.split("=")[1];
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return "404";
    }
    
    
}
