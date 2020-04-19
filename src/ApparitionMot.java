import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import scala.collection.immutable.HashMap;

public class ApparitionMot {
	static private int somme;
	static public Hashtable<String,Integer> redondanceMot (ArrayList<String>[] listePhrase) {
		Thesaurus the = new Thesaurus("thesaurus-v2.3/thes_fr.dat");
		
		
		Hashtable<String,Integer> hashtable= new Hashtable<String,Integer>();	
		ArrayList<String> synonyme = new ArrayList<String>();
		java.util.HashMap<String, ArrayList<String>> hmSynonyme = the.creationHmSynonyme(listePhrase);
		try {
		hmSynonyme.forEach((k, v) -> { 
		 System.out.println ("Synonyme de "+k);
		 for (String mot:v) {
			 System.out.print(mot+" ");
		 }
		 System.out.println();
		 System.out.println();
		}
			); 
		} 
		catch (Exception e) { 
			System.out.println("Exception: " + e); 
		}
		
		
		for (int i=0;i<listePhrase.length;i++) {
			for (int j=0;j<listePhrase[i].size();j++) {
				boolean synonymeDejaPresent = false;
					String ki = listePhrase[i].get(j);
				    synonyme = hmSynonyme.get(ki);
				    if (synonyme != null)
					    for (String s : synonyme){
					        if(hashtable.containsKey(s) && !synonymeDejaPresent){
					            hashtable.replace(s,hashtable.get(s)+1);
					            //listePhrase[i].set(j, s);
					            synonymeDejaPresent = true;
					        }
					    }
				
				if ((the.verif(listePhrase[i].get(j)) && !synonymeDejaPresent) || !the.verif(listePhrase[i].get(j))){
				    if(hashtable.containsKey(listePhrase[i].get(j))){
				        hashtable.replace(listePhrase[i].get(j), hashtable.get(listePhrase[i].get(j))+1);
				    }
				    else{
				        hashtable.put(listePhrase[i].get(j),1);
				    }
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
