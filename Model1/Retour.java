package Model1;


import java.text.SimpleDateFormat;
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
    
    public Retour(String prisDuTxt)throws Exception {
    	SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
    	String[] tableauString = prisDuTxt.split(",");
    	this.date = parser.parse(tableauString[1]);
    	this.scooteurARetourner = new Scooter(tableauString[2]+","+tableauString[3]+","+tableauString[4]+","+tableauString[5]+","+tableauString[6]);
    	this.client = new Client(tableauString[7]+","+tableauString[8]+","+tableauString[9]+","+tableauString[10]+","+tableauString[11]+","+tableauString[12]+","+tableauString[13]+","+tableauString[14]);
    }

    
    public String toString() {
    	return "Date de retour : " + this.date + ", Scooter retourné : "+this.scooteurARetourner + "\n Client n° "+this.client; 
    }
    
    public String toSave() {
    	SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");

    	return "RETOUR,"+d1.format(this.date)+","+this.scooteurARetourner.toSave()+","+this.client.toSave();
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