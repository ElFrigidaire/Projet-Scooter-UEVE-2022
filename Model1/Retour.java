package Model1;


import java.util.*;

/**
 * 
 */
public class Retour {
    public Date date;
    public Scooter scooteurARetourner;
    public Client client;

    /**
     * Default constructor
     */
    public Retour(Date date, Scooter scooteurARetourner, Client client) {
    	this.date = date;
    	this.scooteurARetourner = scooteurARetourner;
    	this.scooteurARetourner.estDisponible=true;
    	this.client = client;
    }
    
    public String toString() {
    	return "Date de retour : " + this.date + ", Scooter retourné : "+this.scooteurARetourner + "\n Client n° "+this.client; 
    }
    
    public String toSave() {
    	return "RETOUR,"+this.date+","+this.scooteurARetourner.toSave()+","+this.client.toSave();
    }

    public double demanderKilometrage() {
    	double kilometrageEffectue;
    	Scanner clav = new Scanner(System.in);
    	System.out.println("Veuillez entrer kilometrage effectué avec ce scooter: ");
    	kilometrageEffectue = Integer.parseInt(clav.nextLine());
    	this.scooteurARetourner.kilometrage+=kilometrageEffectue;
    	return kilometrageEffectue;
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
    public Location signifie;

}