package Model1;


import java.util.*;

/**
 * 
 */
public class Location {
	public Date date_debut;
	public Date date_fin;
	public Scooter scooterLoué;
	public Client client;

    /**
     * Default constructor
     */
    public Location(Date date_debut, Date date_fin, Scooter scooterLoué, Client client) {
    	this.date_debut = date_debut;
    	this.date_fin= date_fin;
    	this.scooterLoué = scooterLoué;
    	this.scooterLoué.estDisponible = false;
    	this.client = client;
    }
    
    public String toString() {
    	return "Date début : "+this.date_debut+", date fin : "+this.date_fin+"\nScooter loué :\n"+this.scooterLoué+"\n Client n° "+this.client;
    }
    
    public String toSave() {
    	return "LOCATION,"+this.date_debut+","+this.date_fin+","+this.scooterLoué.toSave()+","+this.client.toSave();
    }
    
    

}