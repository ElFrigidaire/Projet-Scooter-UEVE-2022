package Model1;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 */
public class Location {
	public Date date_debut;
	public Date date_fin;
	public Scooter scooterLou�;
	public Client client;

    /**
     * Default constructor
     */
    public Location(Date date_debut, Date date_fin, Scooter scooterLou�, Client client) {
    	this.date_debut = date_debut;
    	this.date_fin= date_fin;
    	this.scooterLou� = scooterLou�;
    	this.scooterLou�.estDisponible = false;
    	this.client = client;
    }
    
    public Location(String prisDuTxt)throws Exception {
    	SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
    	String[] tableauString = prisDuTxt.split(",");
    	this.date_debut = parser.parse(tableauString[1]);
    	this.date_fin= parser.parse(tableauString[2]);
    	this.scooterLou� = new Scooter(tableauString[3]+","+tableauString[4]+","+tableauString[5]+","+tableauString[6]+","+tableauString[7]);
    	this.client = new Client(tableauString[8]+","+tableauString[9]+","+tableauString[10]+","+tableauString[11]+","+tableauString[12]+","+tableauString[13]+","+tableauString[14]+","+tableauString[15]);
    }

    
    public String toString() {
    	return "Date d�but : "+this.date_debut+", date fin : "+this.date_fin+"\nScooter lou� :\n"+this.scooterLou�+"\n Client n� "+this.client;
    }
    
    public String toSave() {
    	SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");

    	return "LOCATION,"+d1.format(this.date_debut)+","+d1.format(this.date_fin)+","+this.scooterLou�.toSave()+","+this.client.toSave();
    }
    
    

}