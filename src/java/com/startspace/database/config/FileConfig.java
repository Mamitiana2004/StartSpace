/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startspace.database.config;

import com.startspace.database.exception.DatabaseFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mamit
 */
public class FileConfig {
    private String path;
    
    public FileConfig() throws DatabaseFileException{
        String filepath=System.getProperty("user.dir")+"\\web\\config\\database.ini";
        File file=new File(filepath);
        path=file.getAbsolutePath();    
        System.out.println(path);
        if(!file.exists()){
            throw new DatabaseFileException("The file database.ini is not in the web\\config");
        }
    }
    
    public String get(String property) throws DatabaseFileException{
        File file=new File(path);
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
        throw new DatabaseFileException("The property '"+property+"' is not in the file database.ini");
    }
    
}
