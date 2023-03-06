/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startspace.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author mamit
 */
public class ListeTag extends TagSupport{
    private String nom;
    private String genre;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre(String genre){
        if(genre.equalsIgnoreCase("homme") || genre.equalsIgnoreCase("m")){
            return " Mr ";
        }
        else{
            return " Mme ";
        }
    }
    

    @Override
    public int doStartTag() throws JspException {
        JspWriter out=pageContext.getOut();
        try {
            out.println("<p>Bonjour "+getGenre(genre)+nom+"</p>");
            out.println("<button  onclick=\"alert('Bonjour "+getGenre(genre)+nom+"')\">Greet</button>");
        } catch (Exception e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
    
    
    
}
