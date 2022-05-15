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
    	return "Model : "+this.modele+", num�ro : "+this.numero+", kilom�trage : "+this.kilometrage+", est Disponible "+this.estDisponible;
    }
    
	/**
	J'ai �t� con, j'ai codé ça comme si on avait pas d'interface graphique. ça sert donc à rien mais au moins on a le squelette/ un exemple
	*/
//	public void estDisponible() {
////		Scanner clav = new Scanner(System.in);
////		System.out.print("Entrez le numéro du scooter que vous voulez réserver : ");
////		numero = clav.nextInt();
//
//		for (int a = 0; a < Main.listeScooter.size(); a++) {
//			if (Main.listeScooter.get(a).numero != numero) { // on recherche si l'id est disponible
//				System.out.println("Erreur, ce scooter est déjà reservé, retour au menu");
//				Main.main(null);
//			}
//		}
//	}    

    //public Modele listModele;

    //public Set<Location> listLoc;

}
