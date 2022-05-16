package Model1;


import java.util.*;
import java.util.Scanner;

/**
 * 
 */



public class Client {

	public int numero_client;
	public String adresse;
	public String mail;
	public String telephone;
	public String nom;
	public String prenom;
	public int age;
	public ArrayList<Location> listeLocationsEnCours;
	public ArrayList<Retour> listeRetours;
	/**
     * Default constructor
     */
    public Client(int numero_client,String adresse, String mail, String telephone , String nom, String prenom, int age) {
    	this.numero_client = numero_client;
    	this.adresse = adresse;
    	this.mail = mail;
    	this.telephone = telephone;
    	this.nom = nom;
    	this.prenom = prenom;
    	this.age = age;
    	this.listeLocationsEnCours = new ArrayList<Location>();
    	this.listeRetours = new ArrayList<Retour>();
    }
    
    public String toString() { 
    	return "Client #"+this.numero_client+", adresse : "+this.adresse+", email : "+this.mail+", t�l�phone :"+this.telephone+", nom : "+this.nom+", pr�nom : " +this.prenom + ", age : " + this.age;
    } 
    
    public Scooter choixDuScooterALouer(Scooter[] listeScooter) {
    	Scanner clav = new Scanner(System.in);
    	int numChoisi;
    	boolean arreterLeChoix = false;
    	int nombreScootersLocation=0;
    	
    	while (!arreterLeChoix) {
        	System.out.println("Veuillez entrer le num�ro du Scooter choisi");
        	numChoisi = Integer.parseInt(clav.nextLine());
        	boolean scooterTrouve = false;
        	
    		//Je parcours la liste des scooters
    		for (int a = 0; a < listeScooter.length; a++) {
    		
    			//Je regarde si le scooter est dans la BDD
    			if (listeScooter[a].numero == numChoisi) {
    				Scooter scooterChoisi = listeScooter[a];
        		
    				//Est-ce que ce scooter est disponible?
    				if (scooterChoisi.estDisponible) {
    					System.out.println("Le Scooter #"+numChoisi+" est disponible");
    					nombreScootersLocation+=1;
    					return scooterChoisi;
    				}
    				else {
    					System.out.println("Ce Scooter est d�j� lou�, il sera discponible le :"/**+Location.date_fin*/);
    					scooterTrouve = true;
    					break;
    					}
        			}
        		}
    		
    		if (!scooterTrouve) {
    			System.out.println("Erreur, ce num�ro n'est pas attribu�");
    		}
    		
    		System.out.println("Voulez-vous entrer un autre num�ro? [y]/n");
        	String choix = clav.nextLine();
        	System.out.println(choix);
        	if (choix.equals("n")) {
        		arreterLeChoix=true;
        	}

    	}
    	return null;
}
    public int choixDuScooterARetourner() {
    	Scanner clav = new Scanner(System.in);
    	int numChoisi;
    	boolean arreterLeChoix = false;
    	while (!arreterLeChoix) {
        	System.out.println("Veuillez entrer le num�ro du Scooter � retourner");
        	numChoisi = Integer.parseInt(clav.nextLine());
        	boolean scooterTrouve = false;
        	
    		//Je parcours la liste de ,location du client 
    		for (int a = 0; a < this.listeLocationsEnCours.size(); a++) {
    			
    			//Je regarde si le scooter est dans la liste des locations
    			if (this.listeLocationsEnCours.get(a).scooterLou�.numero == numChoisi) {
    				Scooter scooterChoisi = this.listeLocationsEnCours.get(a).scooterLou�;
				//Est-ce que ce scooter a �t� lou�?
					if (scooterChoisi.estDisponible) {
						System.out.println("Le Scooter #"+numChoisi+" n'a pas �t� lou�");
						scooterTrouve=true;
						break;
					}
					else {
						System.out.println("Merci de votre confiance. Nous esp�rons que la location s'est bien pass�e");
						scooterTrouve = true;
						return a;
						}					
    			}
    		}
    		if(scooterTrouve==false) {
    			System.out.println("Vous n'avez pas lou� ce scooter. Cependant, les scooters "); 
    		}
    		System.out.println("Voulez-vous entrer un autre num�ro? [y]/n");
        	String choix = clav.nextLine();
        	System.out.println(choix);
        	if (choix.equals("n")) {
        		arreterLeChoix=true;
        	}
    	}
    	return -666;
    }
}