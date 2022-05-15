package Model1;


import java.util.*;

/**
 * 
 */
public class Parc {
    public Scooter[] listeScooters;
    ArrayList<Client> listeClients;
    ArrayList<Location> listeLocations;

    /**
     * Default constructor
     */
    public Parc(Scooter[] listeScooter, ArrayList<Client> listeClients, ArrayList<Location> listeLocations) {
    	this.listeScooters = listeScooter;
    	this.listeClients = listeClients;
    	this.listeLocations = listeLocations;
    }

}