import java.util.ArrayList;
import java.util.Hashtable;

public class ApparitionMot {
	static private int somme;
	static public Hashtable<String,Integer> redondanceMot (ArrayList<String>[] listePhrase) {
		Hashtable<String,Integer> hashtable= new Hashtable<String,Integer>();	
		
		for (int i=0;i<listePhrase.length;i++) {
			for (int j=0;j<listePhrase[i].size();j++) {
				Integer n = hashtable.putIfAbsent(listePhrase[i].get(j),1);
			 	
			 	if (n != null) {
				 	n++;
				 	hashtable.replace(listePhrase[i].get(j), n);
			 	}
			}
		 	
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
}
