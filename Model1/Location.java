package Model1;


import java.util.*;

/**
 * 
 */
public class Location {
	public Date date_debut;
	public Date date_fin;
	public Scooter scooterLou�;

    /**
     * Default constructor
     */
    public Location(Date date_debut, Date date_fin, Scooter scooterLou�) {
    	this.date_debut = date_debut;
    	this.date_fin= date_fin;
    	this.scooterLou� = scooterLou�;
    	this.scooterLou�.estDisponible = false;
    }
    
    public String toString() {
    	return "Date d�but : "+this.date_debut+", date fin : "+this.date_fin+"\nScooter lou� :\n"+this.scooterLou�;
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

    /**
     * 
     */
    
	public Scooter scoot;
	public Retour induit;
    /**
     * 
     */
    public Client listLocation;

}