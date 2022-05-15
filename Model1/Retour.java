package Model1;


import java.util.*;

/**
 * 
 */
public class Retour {
    public Date date;
    public Scooter scooteurARetourner;

    /**
     * Default constructor
     */
    public Retour(Date date, Scooter scooteurARetourner) {
    	this.date = date;
    	this.scooteurARetourner = scooteurARetourner;
    	this.scooteurARetourner.estDisponible=true;
    }
    
    public String toString() {
    	return "Date de retour : " + this.date + ", Scooter retourné : "+this.scooteurARetourner; 
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