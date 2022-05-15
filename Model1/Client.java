package Model1;


import java.util.*;

/**
 * 
 */



public class Client {

	public String numero_client;
	public String adresse;
	public String mail;
	public int telephone;
	public String nom;
	public String prenom;
	public int age;
	public Park park;

	/**
     * Default constructor
     */
    public Client(String numero_client,String adresse, String mail, int telephone , String nom, String prenom, int age, Park park) {
    	this.numero_client = numero_client;
    	this.adresse = adresse;
    	this.mail = mail;
    	this.telephone = telephone;
    	this.nom = nom;
    	this.prenom = prenom;
    	this.age=age;
    	this.park = park;
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

    /**
     * 
     */
    public Set<Location> listClient;

}