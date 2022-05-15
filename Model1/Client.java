package Model1;


import java.util.*;

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
    
//    public String choixDuScooter() {
//    	System.out.println
//    }
    
    //public Set<Location> listClient;

}