import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Fichier {
	private String nomFichier;
	private BufferedReader bufferLecture;
	
	public Fichier (String nomFichier) {
		this.nomFichier = nomFichier;
	}
	
	public void debutTraitement () {
		try {
			bufferLecture = new BufferedReader(new InputStreamReader(new FileInputStream(nomFichier),"UTF-8"));    		    

		}
		catch (IOException e) {
		    	e.printStackTrace();
		}
	}
	
	public void finDeTraitement () {
		try {
			bufferLecture.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> arrayListOfWord () {
		ArrayList<String> arrayOfWord= new ArrayList<>();
		String line;
		debutTraitement ();
		
		try {	
		    while ((line = bufferLecture.readLine()) != null) {
		    	String[] wordsLine = line.toLowerCase().split("[| |'|-|,|!|;|«|»|.|\"|?|:|(|)|{|}|]");
		    	for (int i=0; i<wordsLine.length;i++){
		    		arrayOfWord.add(wordsLine[i]);
		    	}
		    }
		}
		catch (IOException e) {
		    	e.printStackTrace();
		}		
		
		finDeTraitement ();
		
		return arrayOfWord;
		
	}
	
	public HashMap<Integer, ArrayList<DoubleString>> TopKOccurence (){
		
		debutTraitement ();
		
		HashMap <Integer,ArrayList<DoubleString>>motCroissements = new HashMap<>();
		
		try {
			String line2;
			String texte = new String();
			
		    while ((line2 = bufferLecture.readLine()) != null) {
		    	texte += line2;
		    }
		    String[] motsParPhrase = SeparationPhrase(texte);
		    for(int x = 0; x<motsParPhrase.length;x++) {
				ArrayList <DoubleString> value=new ArrayList <DoubleString>();
				String[] phrase = motsParPhrase[x].toLowerCase().split("[| |]");
				for(int i=0; i<phrase.length;i++) {		//Premiere ligne commence à 0, indice mots1
			    		for(int j=0;j<phrase.length;j++) {		//indice mot2
			    			try{
			    				String mot1 = phrase[i];
			    				String mot2 = phrase[j];
			    				
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
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finDeTraitement ();
		return motCroissements;
	}
	
	public String[] SeparationPhrase(String fichier) {
		String[] separateur = fichier.toLowerCase().split("[|.|!|?|]");
		for (int i=0;i<separateur.length;i++) {
			
			String[] separateur2 = separateur[i].toLowerCase().split("[|,|;|:|\"|'|-|«|»|(|)|{|}|]");
			separateur[i]=new String ();
			for (int j=0;j<separateur2.length;j++) {
				separateur2[j]=separateur2[j].trim ();
				separateur[i]=separateur[i]+" "+separateur2[j];
			}
			separateur[i]=separateur[i].trim();
		}
			
		return separateur;
	}
}
