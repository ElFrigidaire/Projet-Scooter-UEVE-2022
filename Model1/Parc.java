package Model1;


import java.util.*;

/**
 * 
 */
public class Parc {
    public Scooter[] listeScooters;
    ArrayList<Client> listeClients;
    ArrayList<Location> listeLocations;
    ArrayList<Retour> listeRetours;
    /**
     * Default constructor
     */
    public Parc(Scooter[] listeScooter, ArrayList<Client> listeClients, ArrayList<Location> listeLocations, ArrayList<Retour> listeRetours) {
    	this.listeScooters = listeScooter;
    	this.listeClients = listeClients;
    	this.listeLocations = listeLocations;
    	this.listeRetours = listeRetours;
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
	
	public int recupererNombreScooterLocation() {
		return this.listeLocations.size();
	}
	
	public int recupererNombreScooterDisponible() {
		return this.listeScooters.length-this.listeLocations.size();
	}
	
	
	public double calculKilometrageMoyen() {
		double kilometrageMoyen=0;
		for (int i=0; i<this.listeScooters.length;i++) {
		  kilometrageMoyen+=this.listeScooters[i].kilometrage;
		  }
		kilometrageMoyen=kilometrageMoyen/this.listeScooters.length;
		return kilometrageMoyen;
	}
	
	public ArrayList<Integer> numeroScooterLocation() {
		ArrayList<Integer> listeNumeroLocation = new ArrayList<Integer>(); 
		for (int i=0; i<this.listeLocations.size();i++) {
			listeNumeroLocation.add(this.listeLocations.get(i).scooterLoué.numero);
			  }
			return listeNumeroLocation;

	}
	
	public ArrayList<Integer> numeroScooterDisponible() {
		ArrayList<Integer> listeNumeroDisponible = new ArrayList<Integer>(); 
		for (int i=0; i<this.listeScooters.length;i++) {
			if(listeScooters[i].estDisponible) {
				listeNumeroDisponible.add(this.listeScooters[i].numero);
				}
			}
			return listeNumeroDisponible;
	}

	
	
	
	
	public void afficherResumeParcScooters() {
		System.out.println("Voici le résumé du parc de scooters : ");
		System.out.println("Il y a "+this.listeScooters.length+" scooters au total.");
		System.out.println("Il y a "+recupererNombreScooterLocation()+" scooters en location.");
		System.out.println("Les numéros d'identification des scooters loués sont : "+numeroScooterLocation());
		System.out.println("Il y a "+recupererNombreScooterDisponible()+" Scooters disponibles.");
		System.out.println("Les numéros d'identification des scooters disponibles sont : "+numeroScooterDisponible());
		System.out.println("Le kilométrage moyen de l'ensemble des scooters est : "+calculKilometrageMoyen()+" km");
	}



}