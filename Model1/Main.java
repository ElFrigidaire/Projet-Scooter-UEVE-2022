package Model1;

import java.util.Random;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {
  	public static void main(String[] args) {
  		 
  	  String[] listeNomsMarques= {"Yamaha", "Honda", "Piaggio", "Suzuki"};
  	  Scooter[] listeScooter= new Scooter[20];
  	  for (int i=0; i<listeScooter.length;i++) {
  		  Random random = new Random();
  		  int j=random.nextInt(listeNomsMarques.length + 0);
  		  Park k= new Park(null ,"garage");
  		  listeScooter[i] = new Scooter(listeNomsMarques[j], i, 0, k);
  		  System.out.println(listeScooter[i].toString());
    }
  }
}
  
  //ArrayList<int> listeclients = new ArrayList<>(Arrays.asList(20200411, 20200412, 20200413, 20200414));
//ArrayList<String> listemarques = new ArrayList<>(Arrays.asList("Yamaha", "Honda", "Piaggio", "Suzuki"));
//ArrayList<int> listescooter =  new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
  

