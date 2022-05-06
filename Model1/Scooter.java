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
	/**
	J'ai été con, j'ai codé ça comme si on avait pas d'interface graphique. ça sert donc à rien mais au moins on a le squelette/ un exemple
	*/
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
