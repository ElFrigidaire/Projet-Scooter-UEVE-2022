package Model1;


import java.util.*;

/**
 * 
 */
public class Scooter {
    public String modele;
    public int numero;
    public double kilometrage;
    public Park park;

    public Scooter(String modele, int numero, double kilometrage, Park park) {
    	this.modele = modele;
    	this.numero = numero;
    	this.kilometrage = kilometrage;
    	this.park = park;
    }

	public void numScooter() {
		Scanner clav = new Scanner(System.in);
		System.out.print("Entrez le numéro du scooter que vous voulez réserver : ");
		numero = clav.nextInt();

		for (int a = 0; a < Main.listescooter.size(); a++) {
			if (Main.listescooter.get(a).numero != numero) { // on recherche si l'id est disponible
				System.out.println("Erreur, ce scooter est déjà reservé, retour au menu");
				Main.main(null);
			}
		}
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
    public Modele listModele;

    /**
     * 
     */
    public Set<Location> listLoc;

}
