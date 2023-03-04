/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startspace.web.util;

/**
 *
 * @author mamit
 */
public class URLHelper {
    
    public static String retrieveUrl(String rawUrl){
        return rawUrl.substring(rawUrl.indexOf("/", rawUrl.indexOf("/")+1)+1);
    }
    
    
    
    
}
