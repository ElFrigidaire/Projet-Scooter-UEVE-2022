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
    
    
    public void debug() {
  	    for (int i=0;i<this.listeClients.size();i++) {
  	    	System.out.println("Client : "+this.listeClients.get(i).toString());
  	    }
  	    for (int i=0;i<this.listeScooters.length;i++) {
	    	System.out.println("Scooter : "+this.listeScooters[i].toString());
	    }
    }
    
	public void affichageEtatParcScooter() {
		System.out.printf("Voici l'état du parc de scooters : ");
  	    for (int i=0;i<this.listeScooters.length;i++) {
	    	System.out.printf("\n Scooter : "+this.listeScooters[i]);
	    }

	}


}