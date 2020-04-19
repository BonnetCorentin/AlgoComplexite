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
		String[] wordsLine;
		String mot=new String ();
	
		debutTraitement ();
		try {	
		    while ((line = bufferLectureT.readLine()) != null) {
		    	wordsLine = line.toLowerCase().split("[|]");
				ArrayList<String> listWord = new ArrayList<String>();
		    	if(wordsLine[1].charAt(0)>=49 && wordsLine[1].charAt(0)<=57) {
		    		mot=wordsLine[0];
		    	}
		    	else {
		    		wordsLine = line.toLowerCase().split("[|]");
		    		for(int j=1;j<wordsLine.length;j++) {
		    			listWord.add(wordsLine[j]);
		    		}
		    		Boolean estDansTexte = false;
		    		for (int x=0;x<listePhrase.length;x++) {
		    			if(listePhrase[x].contains(mot.toLowerCase())) {
		    				estDansTexte = true;
		    			}
		    		}
		    		if (estDansTexte)
		    			hm.put(mot,listWord);
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