import java.util.ArrayList;
import java.util.HashMap;

public class NombreOccurence {
	
	public static HashMap<String,Integer> coOccurence(HashMap<Integer,ArrayList<DoubleString>>HashMapCroisementMot) {
		HashMap <String,Integer>tableau = new HashMap<String,Integer>();
		for(int i=0;i<HashMapCroisementMot.size();i++) {
			for(int j=0;j<HashMapCroisementMot.get(i).size();j++) {
				String tempo = HashMapCroisementMot.get(i).get(j).getMotA()+ " = " + HashMapCroisementMot.get(i).get(j).getMotB();
				if(tableau.containsKey(tempo)) {
						tableau.put(tempo, tableau.get(tempo)+1);
				}
				else {
					tableau.put(tempo, 1);
				}
			}
		}
		
		return tableau;

		/*int z = tableau.size();
		
		for(int x=0;x<z;x++) {
			try { 
				 tableau.forEach((k, v) -> { 
					 if(v>0.5*HashMapCroisementMot.size()) {	//50% donc dans une phrase sur deux la combinaison apparait
						 tableau2.put(k,v);
					 }
				 }
				); 
		      } 
		      catch (Exception e) { 
		    	  System.out.println("Exception: " + e); 
		      }
		}
		
		return tableau2;*/
	}
}
