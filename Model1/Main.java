package Model1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.text.SimpleDateFormat;


public class Main {
	
	static public Scooter[] init_BDD_scoot(int numScoot, String[] listeNomsMarques) {
		Scooter[] listeScooter= new Scooter[numScoot];
		for (int i=0; i<listeScooter.length;i++) {
		  Random random = new Random();
		  int idxMarque=random.nextInt(listeNomsMarques.length + 0);
		  double kilometrage = random.nextDouble(1000);
		  listeScooter[i] = new Scooter(listeNomsMarques[idxMarque], i, kilometrage);
		  System.out.println(listeScooter[i].toString());
		  }
		return listeScooter;
	}
	
	static public ArrayList<Client> init_BDD_clients(int numClients, String[] nomsRues, String[] prenoms, String[] noms){
		//Je choisis une arrayList car le nombre de clients va changer au fur et � mesure que les clients s'inscrivent 
	  	ArrayList<Client> listeClients = new ArrayList<Client>();
		for (int i = 0; i<numClients;i++) {
	  		  Random random = new Random();
	  		  int numRue = random.nextInt(90)+1;
	  		  int idxRue = random.nextInt(nomsRues.length);
	  		  int idxPrenom = random.nextInt(prenoms.length);
	  		  int idxNom = random.nextInt(noms.length);
	  		  
	  		  String adresse = numRue+" "+nomsRues[idxRue];
	  		  String email = prenoms[idxPrenom]+"."+noms[idxNom]+"@POO.fr";
	  		  int age = random.nextInt(75)+18;
	  		  
	  		  listeClients.add(new Client(i, adresse, email, "00000000", noms[idxNom],prenoms[idxPrenom], age));
	  		  System.out.println(listeClients.get(i).toString());
	  		  }
		return listeClients;
	}
	
  	public static void main(String[] args)throws Exception {
  		//Initialisation de la BDD 
  		String[] listeNomsMarques= {"Yamaha", "Honda", "Piaggio", "Suzuki"};
  	    Scooter[] listeScooter = init_BDD_scoot(20, listeNomsMarques);
  	  
  	    String[] nomsRues = {"avenue de POO","rue de Cacahou�te","boulevard du Frigidaire"};
  	    String[] prenoms = {"Jonathan","Thomas","Plouf","Antoinette"};
  	    String[] noms = {"Barneche", "Auzannet","Tarek", "Melliti"};
  	    ArrayList<Client> listeClients = init_BDD_clients(4, nomsRues,prenoms,noms);	
  	    
  	    //Location d'un scooter
  	    louerUnScooter(listeClients,listeScooter);
  	    
  	    //Debug
  	    for (int i=0;i<listeClients.size();i++) {
  	    	System.out.println("Client : "+listeClients.get(i).toString());
  	    }
  	    for (int i=0;i<listeScooter.length;i++) {
	    	System.out.println("Scooter : "+listeScooter[i].toString());
	    }
  	    }
  	    
	static public Client identificationClient(ArrayList<Client> listeClient) {
		Scanner clav = new Scanner(System.in);
	    int numClient;
	   	System.out.println("Veuillez entrer votre num�ro de client");
	   	numClient = Integer.parseInt(clav.nextLine());
	   	
	   	//Je Parcours la liste des clients pour v�rifier si le client est pr�sent
	   	for (int a = 0; a < listeClient.size(); a++) {
	   		
	   		//Si il est dans la base de donn�e
	       	if (listeClient.get(a).numero_client == numClient) {
	       		Client client = listeClient.get(a);
	       		System.out.println("Bonjour "+client.prenom);
	       		
	       		return client;
	       	}
	   	}
	   	
	   	//Le client n'a pas �t� trouv� alors on le cr��
	   	System.out.println("Vous n'�tes pas client chez nous, veuillez donner vos informations pour vous inscrire: ");
	    System.out.println("adresse :");
	    String adresse = clav.nextLine();
		System.out.println("adresse email :");
		String email = clav.nextLine();
		System.out.println("t�l�phone :");
		String telephone = clav.nextLine();
		System.out.println("nom :");       		
		String nom = clav.nextLine();
		System.out.println("pr�nom :");
		String prenom = clav.nextLine();
		System.out.println("�ge :");
		int age = Integer.parseInt(clav.nextLine());
		Client client = new Client(listeClient.size(), adresse, email, telephone, nom ,prenom, age);
		listeClient.add(client);
		System.out.println("Vous avez bien �t� cr��, bienvenue!");
	
	   	return client;
	}
	
	public static void louerUnScooter(ArrayList<Client> listeClients, Scooter[] listeScooters) throws Exception {
		//Identification du client 
  	    Client clientEnCours = identificationClient(listeClients);
  	    
  	  //Demande du scooter choisi
  	    Scooter scooterChoisi = clientEnCours.choixDuScooterALouer(listeScooters);
  	    if (scooterChoisi == null) {
  	    	System.out.println("Nous regrettons ne pas avoir de quoi vous satisfaire, nous esp�rons vous revoir une prochaine fois.");
  	    	return ;
  	    }
  	    
  	    //Cr�ation de la location
  	    Date date_debut = new SimpleDateFormat("dd/MM/yyyy").parse("18/01/2002");
  	    Date date_fin = new SimpleDateFormat("dd/MM/yyyy").parse("20/01/2002");
  	    Location location = new Location(date_debut, date_fin, scooterChoisi);
  	    clientEnCours.listeLocationsEnCours.add(location);
  	    //parc.location=location;
	}
	
	public static void retournerUnScooter(Scooter[] listeScooters, ArrayList<Client> listeClient)throws Exception {
		
		//Identification du client 
  	    Client clientEnCours = identificationClient(listeClient);
    	  
  	    //Demande du scooter r�serv�
  	    int idxLocation = clientEnCours.choixDuScooterARetourner();
  	    Scooter scooterChoisi = clientEnCours.listeLocationsEnCours.get(idxLocation).scooterLou�;
  	    
  	    //Cr�ation du retour
  	    Date date = new SimpleDateFormat("dd/MM/yyyy").parse("18/01/2002");
  	    Retour retour = new Retour(date, scooterChoisi);
  	    retour.demanderKilometrage();
  	    Location location = clientEnCours.listeLocationsEnCours.remove(idxLocation);
  	    clientEnCours.listeRetours.add(retour);

	}
	
	public static void verifierEtatScooter() {
	}
	
	public static void affichageEtatParcScooter() {
	}
	
	public static void afficherResumeParcScooters() {
	}
	
	public static void quitterProgramme() {
		
	}
}    



