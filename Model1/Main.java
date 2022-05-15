package Model1;

import java.util.Random;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {
  	public static void main(String[] args) {
  		//Initialisation de la BDD 
  	  String[] listeNomsMarques= {"Yamaha", "Honda", "Piaggio", "Suzuki"};
  	  Scooter[] listeScooter= new Scooter[20];
  	  for (int i=0; i<listeScooter.length;i++) {
  		  Random random = new Random();
  		  int idxMarque=random.nextInt(listeNomsMarques.length + 0);
  		  double kilometrage = random.nextDouble(1000);
  		  listeScooter[i] = new Scooter(listeNomsMarques[idxMarque], i, kilometrage);
  		  System.out.println(listeScooter[i].toString());
    }
  	  //Je choisis une arrayList car le nombre de clients va changer au fur et à mesure que les clients s'inscrivent 
  	  ArrayList<Client> listeClients = new ArrayList<Client>();
  	  String[] nomsRues = {"avenue de POO","rue de Cacahouète","boulevard du Frigidaire"};
  	  String[] prenoms = {"Jonathan","Thomas","Plouf","Antoinette"};
  	  String[] noms = {"Barneche", "Auzannet","Tarek", "Melliti"};
  	  
  	  
  	  for (int i = 0; i<4;i++) {
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
  	 
  	  //Demande du numéro de scooter choisi
  	  
}
}

  

//ArrayList<String> listemarques = new ArrayList<>(Arrays.asList("Yamaha", "Honda", "Piaggio", "Suzuki"));
//ArrayList<int> listescooter =  new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
  

