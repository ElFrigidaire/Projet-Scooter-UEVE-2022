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
  	    ArrayList<Retour> listeRetours = new ArrayList<Retour>();
  	    ArrayList<Location> listeLocations = new ArrayList<Location>();
  	    
  	    //Cr�ation du parc
  	    Parc monParc= new Parc(listeScooter, listeClients, listeLocations, listeRetours);
  	    
  	    //Cr�ation et affichage du menu
  	    menu(monParc);
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
	
	public static void louerUnScooter(Parc monParc) throws Exception {
		//Identification du client 
  	    Client clientEnCours = identificationClient(monParc.listeClients);
  	    
  	  //Demande du scooter choisi
  	    Scooter scooterChoisi = clientEnCours.choixDuScooterALouer(monParc.listeScooters);
  	    if (scooterChoisi == null) {
  	    	System.out.println("Nous regrettons ne pas avoir de quoi vous satisfaire, nous esp�rons vous revoir une prochaine fois.");
  	    	return ;
  	    }
  	    
  	    //Cr�ation de la location
  	    Date date_debut = new SimpleDateFormat("dd/MM/yyyy").parse("18/01/2002");
  	    Date date_fin = new SimpleDateFormat("dd/MM/yyyy").parse("20/01/2002");
  	    Location location = new Location(date_debut, date_fin, scooterChoisi, clientEnCours);
  	    monParc.listeLocations.add(location);
	}
	
	public static void retournerUnScooter(Parc monParc)throws Exception {
		
		//Identification du client 
  	    Client clientEnCours = identificationClient(monParc.listeClients);
    	  
  	    //Demande du scooter r�serv�
  	    int idxLocationParc = clientEnCours.choixDuScooterARetourner(monParc);
  	    if (idxLocationParc == -666) {
  	    	System.out.println("Nous regrettons ne pas avoir de quoi vous satisfaire, nous esp�rons vous revoir une prochaine fois.");
  	    	return ;
  	    }
  	    Scooter scooterChoisi = monParc.listeLocations.get(idxLocationParc).scooterLou�;

  	    
  	    //Cr�ation du retour
  	    Date date = new SimpleDateFormat("dd/MM/yyyy").parse("18/01/2002");
  	    Retour retour = new Retour(date, scooterChoisi, clientEnCours);
  	    retour.demanderKilometrage();
  	    
  	    //Mise � jour des liste de location des clients
  	    Location location = monParc.listeLocations.remove(monParc.indexLocationParc(scooterChoisi.numero));
  	    monParc.listeRetours.add(retour);
	}
	
	public static Scooter verifierEtatScooter(Scooter[] listeScooter) {
		Scanner clav = new Scanner(System.in);
		int numChoisi;
		boolean arreterLeChoix = false;
    	
    	while (!arreterLeChoix) {
    		System.out.println("De quel Scooter voulez-vous v�rifier l'�tat? ");
    		numChoisi = Integer.parseInt(clav.nextLine());
    		boolean scooterTrouve = false;
        	
    		//Je parcours la liste des scooters
    		for (int a = 0; a < listeScooter.length; a++) {
    		
    			//Je regarde si le scooter est dans la BDD
    			if (listeScooter[a].numero == numChoisi) {
    				Scooter scooterChoisi = listeScooter[a];
        		
    				System.out.printf("Voici l'�tat de ce scooter : "+listeScooter[a]);
    				scooterTrouve=true;
    				break;
    					}
        			}    		
    		if (!scooterTrouve) {
    			System.out.println("Erreur, ce num�ro n'est pas attribu�");
    		}
    		
    		System.out.println("\n Voulez-vous entrer un autre num�ro? [y]/n");
        	String choix = clav.nextLine();
        	if (choix.equals("n")) {
        		arreterLeChoix=true;
        	}

    	}
    	return null;


		
	}
	
	public static void menu(Parc monParc)throws Exception {
		Scanner clav = new Scanner(System.in);
		System.out.println("\n Veuillez choisir une option du menu : \n 1 : Louer un Scooter \n 2 : Retour d'un scooter \n 3 : �tat d'un scooter \n 4 : Affichage de l'�tat du parc des scooters \n 5: Saisie du parc des scooters \n [6] : Quitter le programme");
	   	int choixMenu = Integer.parseInt(clav.nextLine());
		if(choixMenu==1) {
			
	  	    //Location d'un scooter
	  	    System.out.println("########### Location d'un scooter : ###########");
	  	    louerUnScooter(monParc);
	  	    
	  	    //On retourne au menu de d�marrage
	  	    menu(monParc);
	  	    
		}
		else if (choixMenu==2) {
			
	  	    //Retour d'un scooter
	  	    System.out.println("########### Retour d'un scooter : ###########");
	  	    retournerUnScooter(monParc);
	  	    
	  	    //On retourne au menu de d�marrage
	  	    menu(monParc);
		}
		else if (choixMenu==3) {
			
			//V�rification de l'�tat d'un scooter
	  	    System.out.println("########### V�rification de l'�tat d'un scooter : ###########");
	  	    verifierEtatScooter(monParc.listeScooters);
	  	    
	  	    //On retourne au menu de d�marrage
	  	    menu(monParc);
		}
		else if (choixMenu==4) {
			
			//Affichage de l'�tat du parc des scooters
	  	    monParc.affichageEtatParcScooter();
	  	    
	  	    
	  	    //On retourne au menu de d�marrage
	  	    menu(monParc);
		}
		else if (choixMenu==5 ) {
			monParc.afficherResumeParcScooters();
	  	    
	  	    //On retourne au menu de d�marrage
	  	    menu(monParc);
			}
		else {
	        try {
	        	  
	            // Recevoir le fichier 
	            File f = new File("D:\\BDD.txt");
	  
	            // Cr�er un nouveau fichier
	            // V�rifier s'il n'existe pas
	            if (f.createNewFile())
	                System.out.println("File created");
	            else
	                System.out.println("File already exists");
	        }
    		catch (IOException e)
    		{
    		 //Gestion des exceptions en cas de probl�me d'acc�s au fichier
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
	        		 //Gestion des exceptions en cas de probl�me d'acc�s au fichier
	        		}
	        quitterProgramme();

	        }
		}
	
	public static void quitterProgramme() {
		System.exit(0);
	}
}    



