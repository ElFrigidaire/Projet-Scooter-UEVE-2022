package Model1;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.nio.file.*;
import java.nio.charset.*;



public class Main {
	
	static public Scooter[] init_BDD_scoot(int numScoot, String[] listeNomsMarques) {
		Scooter[] listeScooter= new Scooter[numScoot];
		for (int i=0; i<listeScooter.length;i++) {
		  Random random = new Random();
		  int idxMarque=random.nextInt(listeNomsMarques.length + 0);
		  double kilometrage = random.nextDouble(1000);
		  listeScooter[i] = new Scooter(listeNomsMarques[idxMarque], i, kilometrage);
		  }
		return listeScooter;
	}
	
	static public ArrayList<Client> init_BDD_clients(int numClients, String[] nomsRues, String[] prenoms, String[] noms){
		//Je choisis une arrayList car le nombre de clients va changer au fur et à mesure que les clients s'inscrivent 
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
	  		  }
		return listeClients;
	}
	
  	public static void main(String[] args)throws Exception {
  		//Initialisation de la BDD 
  		String[] listeNomsMarques= {"Yamaha", "Honda", "Piaggio", "Suzuki"};
  	    Scooter[] listeScooter = init_BDD_scoot(20, listeNomsMarques);
  	  
  	    String[] nomsRues = {"avenue de POO","rue de Cacahouète","boulevard du Frigidaire"};
  	    String[] prenoms = {"Jonathan","Thomas","Plouf","Antoinette"};
  	    String[] noms = {"Barneche", "Auzannet","Tarek", "Melliti"};
  	    ArrayList<Client> listeClients = init_BDD_clients(4, nomsRues,prenoms,noms);	
  	    ArrayList<Retour> listeRetours = new ArrayList<Retour>();
  	    ArrayList<Location> listeLocations = new ArrayList<Location>();
  	    
  	    //Création du parc
  	    Parc monParc= new Parc(listeScooter, listeClients, listeLocations, listeRetours);
  	    
  	    //Création et affichage du menu
  	    menu(monParc);
  	}
  	    

 
  	      	    


  	    
	static public Client identificationClient(ArrayList<Client> listeClient) {
		Scanner clav = new Scanner(System.in);
	    int numClient;
	   	System.out.println("Veuillez entrer votre numéro de client");
	   	numClient = Integer.parseInt(clav.nextLine());
	   	
	   	//Je Parcours la liste des clients pour vérifier si le client est présent
	   	for (int a = 0; a < listeClient.size(); a++) {
	   		
	   		//Si il est dans la base de donnée
	       	if (listeClient.get(a).numero_client == numClient) {
	       		Client client = listeClient.get(a);
	       		System.out.println("Bonjour "+client.prenom);
	       		
	       		return client;
	       	}
	   	}
	   	
	   	//Le client n'a pas été trouvé alors on le créé
	   	System.out.println("Vous n'êtes pas client chez nous, veuillez donner vos informations pour vous inscrire: ");
	    System.out.println("adresse :");
	    String adresse = clav.nextLine();
		System.out.println("adresse email :");
		String email = clav.nextLine();
		System.out.println("téléphone :");
		String telephone = clav.nextLine();
		System.out.println("nom :");       		
		String nom = clav.nextLine();
		System.out.println("prénom :");
		String prenom = clav.nextLine();
		System.out.println("âge :");
		int age = Integer.parseInt(clav.nextLine());
		Client client = new Client(listeClient.size(), adresse, email, telephone, nom ,prenom, age);
		listeClient.add(client);
		System.out.println("Vous avez bien été créé, bienvenue!");
	
	   	return client;
	}
	
	public static void louerUnScooter(Parc monParc) throws Exception {
		//Identification du client 
  	    Client clientEnCours = identificationClient(monParc.listeClients);
  	    
  	  //Demande du scooter choisi
  	    Scooter scooterChoisi = clientEnCours.choixDuScooterALouer(monParc.listeScooters);
  	    if (scooterChoisi == null) {
  	    	System.out.println("Nous regrettons ne pas avoir de quoi vous satisfaire, nous espérons vous revoir une prochaine fois.");
  	    	return ;
  	    }
  	    
  	    //Création de la location
  	    Date date_debut = new SimpleDateFormat("dd/MM/yyyy").parse("18/01/2002");
  	    Date date_fin = new SimpleDateFormat("dd/MM/yyyy").parse("20/01/2002");
  	    Location location = new Location(date_debut, date_fin, scooterChoisi, clientEnCours);
  	    monParc.listeLocations.add(location);
	}
	
	public static void retournerUnScooter(Parc monParc)throws Exception {
		
		//Identification du client 
  	    Client clientEnCours = identificationClient(monParc.listeClients);
    	  
  	    //Demande du scooter réservé
  	    int idxLocationParc = clientEnCours.choixDuScooterARetourner(monParc);
  	    if (idxLocationParc == -666) {
  	    	System.out.println("Nous regrettons ne pas avoir de quoi vous satisfaire, nous espérons vous revoir une prochaine fois.");
  	    	return ;
  	    }
  	    Scooter scooterChoisi = monParc.listeLocations.get(idxLocationParc).scooterLoué;

  	    
  	    //Création du retour
  	    Date date = new SimpleDateFormat("dd/MM/yyyy").parse("18/01/2002");
  	    Retour retour = new Retour(date, scooterChoisi, clientEnCours);
  	    retour.demanderKilometrage();
  	    
  	    //Mise à jour des liste de location des clients
  	    Location location = monParc.listeLocations.remove(monParc.indexLocationParc(scooterChoisi.numero));
  	    monParc.listeRetours.add(retour);
	}
	
	public static Scooter verifierEtatScooter(Scooter[] listeScooter) {
		Scanner clav = new Scanner(System.in);
		int numChoisi;
		boolean arreterLeChoix = false;
    	
    	while (!arreterLeChoix) {
    		System.out.println("De quel Scooter voulez-vous vérifier l'état? ");
    		numChoisi = Integer.parseInt(clav.nextLine());
    		boolean scooterTrouve = false;
        	
    		//Je parcours la liste des scooters
    		for (int a = 0; a < listeScooter.length; a++) {
    		
    			//Je regarde si le scooter est dans la BDD
    			if (listeScooter[a].numero == numChoisi) {
    				Scooter scooterChoisi = listeScooter[a];
        		
    				System.out.printf("Voici l'état de ce scooter : "+listeScooter[a]);
    				scooterTrouve=true;
    				break;
    					}
        			}    		
    		if (!scooterTrouve) {
    			System.out.println("Erreur, ce numéro n'est pas attribué");
    		}
    		
    		System.out.println("\n Voulez-vous entrer un autre numéro? [y]/n");
        	String choix = clav.nextLine();
        	if (choix.equals("n")) {
        		arreterLeChoix=true;
        	}

    	}
    	return null;


		
	}
	
	public static void menu(Parc monParc)throws Exception {
		Scanner clav = new Scanner(System.in);
		System.out.println("\n Veuillez choisir une option du menu : \n 1 : Louer un Scooter \n 2 : Retour d'un scooter \n 3 : État d'un scooter \n 4 : Affichage de l'état du parc des scooters \n 5: Saisie du parc des scooters \n [6] : Quitter le programme");
	   	int choixMenu = Integer.parseInt(clav.nextLine());
		if(choixMenu==1) {
			
	  	    //Location d'un scooter
	  	    System.out.println("########### Location d'un scooter : ###########");
	  	    louerUnScooter(monParc);
	  	    
	  	    //On retourne au menu de démarrage
	  	    menu(monParc);
	  	    
		}
		else if (choixMenu==2) {
			
	  	    //Retour d'un scooter
	  	    System.out.println("########### Retour d'un scooter : ###########");
	  	    retournerUnScooter(monParc);
	  	    
	  	    //On retourne au menu de démarrage
	  	    menu(monParc);
		}
		else if (choixMenu==3) {
			
			//Vérification de l'état d'un scooter
	  	    System.out.println("########### Vérification de l'état d'un scooter : ###########");
	  	    verifierEtatScooter(monParc.listeScooters);
	  	    
	  	    //On retourne au menu de démarrage
	  	    menu(monParc);
		}
		else if (choixMenu==4) {
			
			//Affichage de l'état du parc des scooters
	  	    monParc.affichageEtatParcScooter();
	  	    
	  	    
	  	    //On retourne au menu de démarrage
	  	    menu(monParc);
		}
		else if (choixMenu==5 ) {
			monParc.afficherResumeParcScooters();
	  	    
	  	    //On retourne au menu de démarrage
	  	    menu(monParc);
			}
		else {
	        try {
	        	  
	            // Recevoir le fichier 
	            File f = new File("D:\\BDD.txt");
	  
	            // Créer un nouveau fichier
	            // Vérifier s'il n'existe pas
	            if (f.createNewFile())
	                System.out.println("File created");
	            else
	                System.out.println("File already exists");
	        }
    		catch (IOException e)
    		{
    		 //Gestion des exceptions en cas de problème d'accès au fichier
    		}

	        
	        try(FileWriter fw = new FileWriter("D:\\BDD.txt", true);
	        		BufferedWriter bw = new BufferedWriter(fw);
	        		PrintWriter out = new PrintWriter(bw))
	        		{
	        		 out.println("Ouais test tes t test");
	        		 out.println(" 1 1 1 1 1 1 1 1 1 1 11 ");
	        		}
	        		catch (IOException e)
	        		{
	        		 //Gestion des exceptions en cas de problème d'accès au fichier
	        		}
	        quitterProgramme();

	        }
		}
	
	public static void quitterProgramme() {
		System.exit(0);
	}
}    



