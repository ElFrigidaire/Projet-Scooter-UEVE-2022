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
  		  int j=random.nextInt(listeNomsMarques.length + 0);
  		  Park k= new Park(null ,"garage");
  		  listeScooter[i] = new Scooter(listeNomsMarques[j], i, 0, k);
  		  System.out.println(listeScooter[i].toString());
    }
  	  //Je choisis une arrayList car le nombre de clients va changer au fur et à mesure que les clients s'inscrivent 
  	  ArrayList<Client> listeClients = new ArrayList<Client>();
  	 
  	  for (int i = 0; i<4;i++) {
  		  listeClients.add(new Client(i,"18 avenue de POO", "POO@POO.fr", "00000000", "Benoit", "Richard", 18));
  		  System.out.println(listeClients.get(i).toString());
  }
  	 
  	  //Demande du numéro de scooter choisi
  	  
}
}

  

//ArrayList<String> listemarques = new ArrayList<>(Arrays.asList("Yamaha", "Honda", "Piaggio", "Suzuki"));
//ArrayList<int> listescooter =  new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
  

