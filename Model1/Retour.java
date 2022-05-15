package Model1;


import java.util.*;

/**
 * 
 */
public class Retour {
    public Date date;
    public int numero_scooter;

    /**
     * Default constructor
     */
    public Retour(Date date, int numero_scooter) {
    	this.date = date;
    	this.numero_scooter = numero_scooter;
    }
    
    public String toString() {
    	return "Date de retour : " + this.date + ", Scooter retourné : "+this.numero_scooter; 
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