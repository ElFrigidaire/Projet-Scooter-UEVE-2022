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
    	this.age=age;
    }
    
    public String toString() { 
    	return "Client #"+this.numero_client+", adresse : "+this.adresse+", email : "+this.mail+", téléphone :"+this.telephone+", nom : "+this.nom+", prénom : " +this.prenom + ", age : " + this.age;
    } 
    
    public Scooter choixDuScooter(Scooter[] listeScooter) {
    	Scanner clav = new Scanner(System.in);
    	int numChoisi;
    	boolean arreterLeChoix = false;
    	
    	while (!arreterLeChoix) {
        	System.out.println("Veuillez entrer le numéro du Scooter choisi");
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
    					return scooterChoisi;
    				}
    				else {
    					System.out.println("Ce Scooter est déjà loué, il sera discponible le :"/**+Location.date_fin*/);
    					scooterTrouve = true;
    					break;
    					}
        			}
        		}
    		
    		if (!scooterTrouve) {
    			System.out.println("Erreur, ce numéro n'est pas attribué");
    		}
    		
    		System.out.println("Voulez-vous entrer un autre numéro? [y]/n");
        	String choix = clav.nextLine();
        	System.out.println(choix);
        	if (choix.equals("n")) {
        		arreterLeChoix=true;
        	}

    	}
    	return null;
}
}