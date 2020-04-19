import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Thesaurus {

	private String nomFichierT;
	private static BufferedReader bufferLectureT;
	
	
	public Thesaurus (String nomFichierT) {
		this.nomFichierT = nomFichierT;
	}
	
	public void debutTraitement () {
		try {
			bufferLectureT = new BufferedReader(new InputStreamReader(new FileInputStream(nomFichierT),"UTF-8"));    		    

		}
		catch (IOException e) {
		    	e.printStackTrace();
		}
	}
	
	public void finDeTraitement () {
		try {
			bufferLectureT.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	static ArrayList<String> arrayOfWordThe= new ArrayList<>();
	
	public ArrayList<String> arrayListOfWordThe() {
		String line;
		debutTraitement ();
		
		try {	
		    while ((line = bufferLectureT.readLine()) != null) {
		    	String[] wordsLine = line.toLowerCase().split("[|1]");
		    	for (int i=0; i<wordsLine.length;i++){
		    		arrayOfWordThe.add(wordsLine[i]);
		    	}
		    }
		}
		catch (IOException e) {
		    	e.printStackTrace();
		}		
		
		finDeTraitement ();
		return arrayOfWordThe;
	}
	
	static public List<String> splitBarre(String fichierASplit) {
		String str[] = fichierASplit.split("[|]");
		List<String> tempo = new ArrayList<String>();
		tempo = Arrays.asList(str);
		return tempo;
	}
	
	static HashMap<String,ArrayList<String>> hm = new HashMap<String,ArrayList<String>>();
	
	public HashMap<String,ArrayList<String>> creationHmSynonyme(ArrayList<String>[] listePhrase){
		String line;
		int i=0;
		String[] wordsLine = new String[3];
		String[] wordsLine2;
		debutTraitement ();
		
		try {	
		    while ((line = bufferLectureT.readLine()) != null) {
				ArrayList<String> listWord = new ArrayList<String>();
		    	if(i==0) {
		    		wordsLine = line.toLowerCase().split("[|1]");
		    		i++;
		    	}
		    	else {
		    		wordsLine2 = line.toLowerCase().split("[|]");
		    		for(int j=1;j<wordsLine2.length;j++) {
		    			listWord.add(wordsLine2[j]);
		    		}
		    		Boolean estDansTexte = false;
		    		for (int x=0;x<listePhrase.length;x++) {
		    			if(listePhrase[x].contains(wordsLine[0].toLowerCase())) {
		    				estDansTexte = true;
		    			}
		    		}
		    		if (estDansTexte)
		    			hm.put(wordsLine[0],listWord);
		    		i=0;
		    	}
		    }
		}
		catch (IOException e) {
		    	e.printStackTrace();
		}		
		
		finDeTraitement ();
		return hm;
	}
	
	public Boolean verifContientSyn(Hashtable<String,Integer> hashtable, String value) { //Mauvaise taille hashtable
		
		for(int i=0;i<hashtable.size();i++) {
			if(hashtable.containsKey(value)) {	//ne rentre jamais dans cette boucle
				return true;
			}
		}
		return false;
	}
	
	public Boolean verif(String e) {
		return hm.containsKey(e);
	}


}