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
    	this.age = age;
    }
    
    public String toString() { 
    	return "Client #"+this.numero_client+", adresse : "+this.adresse+", email : "+this.mail+", téléphone :"+this.telephone+", nom : "+this.nom+", prénom : " +this.prenom + ", age : " + this.age;
    } 
    
    //
    public String toSave() {
    	String s = "CLIENT,"+this.numero_client+","+this.adresse+","+this.mail+","+this.telephone+","+this.nom+","+this.prenom+","+this.age;
    	return s;
    	}
    
    
    public Scooter choixDuScooterALouer(Scooter[] listeScooter) {
    	Scanner clav = new Scanner(System.in);
    	int numChoisi;
    	boolean arreterLeChoix = false;    	
    	while (!arreterLeChoix) {
        	System.out.println("Veuillez entrer le numéro du Scooter choisi");
        	numChoisi = Integer.parseInt(clav.nextLine());
        	boolean scooterTrouve = false;
        	
    		//Je parcours la liste des scooters
    		for (int a = 0; a < listeScooter.length; a++) {
    		
    			//Je regarde si le scooter est dans la BDD
    			if (listeScooter[a].numero == numChoisi) {
    				Scooter scooterChoisi = listeScooter[a];
        		
    				//Est-ce que ce scooter est disponible?
    				if (scooterChoisi.estDisponible) {
    					System.out.println("Le Scooter #"+numChoisi+" est disponible");
    					return scooterChoisi;
    				}
    				else {
    					System.out.println("Ce Scooter est déjà loué, il sera discponible le :"/**+Location.date_fin*/);
    					scooterTrouve = true;
    					break;
    					}
        			}
        		}
    		
    		if (!scooterTrouve) {
    			System.out.println("Erreur, ce numéro n'est pas attribué");
    		}
    		
    		System.out.println("Voulez-vous entrer un autre numéro? [y]/n");
        	String choix = clav.nextLine();
        	System.out.println(choix);
        	if (choix.equals("n")) {
        		arreterLeChoix=true;
        	}

    	}
    	return null;
}
	public ArrayList<Integer> récupérerNumeroScooterDuClient(Parc monParc) {
		ArrayList<Integer> listeNumeroLocation = new ArrayList<Integer>(); 
		for (int i=0; i<monParc.listeLocations.size();i++) {
			if(this.numero_client==monParc.listeLocations.get(i).client.numero_client) {
				listeNumeroLocation.add(monParc.listeLocations.get(i).scooterLoué.numero);
			}
			}
			return listeNumeroLocation;
	}
    
    public int choixDuScooterARetourner(Parc monParc) {
    	Scanner clav = new Scanner(System.in);
    	int numChoisi;
    	boolean arreterLeChoix = false;
    	while (!arreterLeChoix) {
        	System.out.println("Veuillez entrer le numéro du Scooter à retourner");
        	numChoisi = Integer.parseInt(clav.nextLine());
        	boolean scooterTrouve = false;
        	
    		//Je parcours la liste de ,location du client 
    		for (int a = 0; a < monParc.listeLocations.size(); a++) {
    			
    			//Je regarde si le scooter est dans la liste des locations
    			if (monParc.listeLocations.get(a).scooterLoué.numero == numChoisi) {
    				Scooter scooterChoisi = monParc.listeLocations.get(a).scooterLoué;
				//Est-ce que ce scooter a été loué?
					if (scooterChoisi.estDisponible) {
						System.out.println("Le Scooter #"+numChoisi+" n'a pas été loué");
						scooterTrouve=true;
						break;
					}
					else {
						System.out.println("Merci de votre confiance. Nous espérons que la location s'est bien passée");
						scooterTrouve = true;
						return a;
						}					
    			}
    		}
    		if(scooterTrouve==false) {
    			System.out.println("Vous n'avez pas loué ce scooter. Cependant, vous avez loué les scooters "+this.récupérerNumeroScooterDuClient(monParc)); 
    		}
    		System.out.println("Voulez-vous entrer un autre numéro? [y]/n");
        	String choix = clav.nextLine();
        	System.out.println(choix);
        	if (choix.equals("n")) {
        		arreterLeChoix=true;
        	}
    	}
    	return -666;
    }
    


    
}