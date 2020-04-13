import java.util.ArrayList;
import java.util.Hashtable;

import javafx.scene.control.Tab;

public class ApparitionMot {
	static private int somme;
	static public Hashtable<String,Integer> redondanceMot (ArrayList <String> listOfWord) {
		Hashtable<String,Integer> hashtable= new Hashtable<String,Integer>();	
		
		for (int i=0;i<listOfWord.size();i++) {
		 	Integer n = hashtable.putIfAbsent(listOfWord.get(i),1);
		 	
		 	if (n != null) {
			 	n++;
			 	hashtable.replace(listOfWord.get(i), n);
		 	}
		 	hashtable.remove("");
		}
		
		return hashtable;
	}
	
	static public Hashtable<String,Float> redondanceMotFrequence (Hashtable<String,Integer> redondance){
		Hashtable<String,Float>hashtable = new Hashtable<>();
		somme=0;
		try { 
			redondance.forEach((k, v) -> { 
				 somme+=v;
			 }
			); 
	      } 
	      catch (Exception e) { 
	    	  System.out.println("Exception: " + e); 
	      }
		try { 
			redondance.forEach((k, v) -> { 
				 Float a = ((float)v)/((float)somme)*100;
				//if(a>2.1) {									
					hashtable.put(k,a);
				//}
			 }
			); 
	      } 
	      catch (Exception e) { 
	    	  System.out.println("Exception: " + e); 
	      } 
		
		return hashtable;
	}
	
	static public ArrayList<String> suppStopWords(ArrayList<String> array, ArrayList<String> arraySW){
		ArrayList<String> arrayOfWordFinal= new ArrayList<>();
		
		arrayOfWordFinal = array;
		
		for (int i=0;i<arraySW.size();i++) {
			for(int j=0;j<array.size();j++) {
				if(arraySW.get(i).compareTo(array.get(j))==0) {
					arrayOfWordFinal.remove(j);
				}
			}
		}
		return arrayOfWordFinal;
	}
}
