package Model1;


import java.util.*;

/**
 * 
 */
public class Scooter {
	public String modele;
	public int numero;
	public double kilometrage;
    public boolean estDisponible;

    //constructeur
    public Scooter(String modele, int numero, double kilometrage) {
		this.modele = modele;
		this.numero = numero;
		this.kilometrage = kilometrage;
		this.estDisponible = true;
	}
    public String toString() {
    	return "Scooter #"+this.numero+", Marque : "+this.modele+", kilométrage : "+this.kilometrage+", est Disponible "+this.estDisponible;
    }
    
    public String toSave() {
    	return this.numero+","+this.modele+","+this.kilometrage+","+this.estDisponible;
    }

    
    //public Modele listModele;

    //public Set<Location> listLoc;

}
