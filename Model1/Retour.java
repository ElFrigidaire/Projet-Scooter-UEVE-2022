package Model1;


import java.util.*;

/**
 * 
 */
public class Retour {
    public Date date;
    public String modele;

    /**
     * Default constructor
     */
    public Retour(Date date, String modele) {
    	this.date = date;
    	this.modele = modele;
    }
    
    public String toString() {
    	return "Date de retour : " + this.date + ", modèle retourné : "+this.modele; 
    }

    /**
     * 
     */

    /**
     * 
     */

    /**
     * 
     */
    public Location signifie;

}