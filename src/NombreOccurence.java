import java.util.ArrayList;
import java.util.HashMap;

public class NombreOccurence {
	
	public static HashMap<String,Integer> TopKOccurence(HashMap<Integer,ArrayList<DoubleString>>HashMapCroisementMot) {
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
	}
	
	public static HashMap<Integer, ArrayList<DoubleString>> coOccurence (ArrayList<String>[] arrayListOfWord){
			
			HashMap <Integer,ArrayList<DoubleString>>motCroissements = new HashMap<>();
			    
			    for(int x = 0; x<arrayListOfWord.length;x++) {
					ArrayList <DoubleString> value=new ArrayList <DoubleString>();
					
					for(int i=0; i<arrayListOfWord[x].size();i++) {		//Premiere ligne commence à 0, indice mots1
				    		for(int j=0;j<arrayListOfWord[x].size();j++) {		//indice mot2
				    			try{
				    				String mot1 = arrayListOfWord[x].get(i);
				    				String mot2 = arrayListOfWord[x].get(j);
				    				
				    				int compare = mot1.compareTo(mot2);
					    			DoubleString ds = new DoubleString(mot1,mot2);
					    				
					    			if(compare<0){					//gestion des doublons
							    		value.add(ds);
							    		motCroissements.put(x, value);
							    	}
				    			}
				    			catch (ArrayIndexOutOfBoundsException a){
				    					a.printStackTrace();
				    			}
				    		}
			    		}
			    }
			return motCroissements;
		}
}
