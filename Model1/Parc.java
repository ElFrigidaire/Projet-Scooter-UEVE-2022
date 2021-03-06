package Model1;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 * 
 */
public class Parc {
    public Scooter[] listeScooters;
    ArrayList<Client> listeClients;
    ArrayList<Location> listeLocations;
    ArrayList<Retour> listeRetours;
	ArrayList<Scooter> listeScooters2 = new ArrayList<Scooter>();                

    /**
     * Default constructor
     */
    public Parc(Scooter[] listeScooter, ArrayList<Client> listeClients, ArrayList<Location> listeLocations, ArrayList<Retour> listeRetours) {
    	this.listeScooters = listeScooter;
    	this.listeClients = listeClients;
    	this.listeLocations = listeLocations;
    	this.listeRetours = listeRetours;
    }
    
    public Parc(String fichierDeSauvegarde) {
            try {
                File file = new File(fichierDeSauvegarde);
                
                //Commence ? lire le fichier
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String str;
        		this.listeRetours = new ArrayList<Retour>();
        		this.listeClients = new ArrayList<Client>();
        		this.listeLocations = new ArrayList<Location>();
                while ((str = reader.readLine()) != null) {
                	if (str.startsWith("SCOOTER")) {
                		listeScooters2.add(new Scooter(str));
                	}
                	else if (str.startsWith("CLIENT")) {
                		this.listeClients.add(new Client(str));
                	}
                	else if (str.startsWith("LOCATION")) {
                		this.listeLocations.add(new Location(str));
                	}
                	else if (str.startsWith("RETOUR")) {
                		this.listeRetours.add(new Retour(str));
                	}
                	}
                this.listeScooters = listeScooters2.toArray(new Scooter[listeScooters2.size()]);
                reader.close();
                } 
            catch (Exception e) {
            
            System.out.println(e);
            }
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
		System.out.printf("Voici l'?tat du parc de scooters : ");
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
			listeNumeroLocation.add(this.listeLocations.get(i).scooterLou?.numero);
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
		System.out.println("Voici le r?sum? du parc de scooters : ");
		System.out.println("Il y a "+this.listeScooters.length+" scooters au total.");
		System.out.println("Il y a "+recupererNombreScooterLocation()+" scooters en location.");
		System.out.println("Les num?ros d'identification des scooters lou?s sont : "+numeroScooterLocation());
		System.out.println("Il y a "+recupererNombreScooterDisponible()+" Scooters disponibles.");
		System.out.println("Les num?ros d'identification des scooters disponibles sont : "+numeroScooterDisponible());
		System.out.println("Le kilom?trage moyen de l'ensemble des scooters est : "+calculKilometrageMoyen()+" km");
	}
	
	public int indexLocationParc(int numero) {
		int indexLocationDuParc=0;
		for(int i=0;i<this.listeLocations.size();i++) {
			if(this.listeLocations.get(i).scooterLou?.numero==numero) {
				indexLocationDuParc=i;
				break;
			}
		}
		
		return indexLocationDuParc;
	}



}