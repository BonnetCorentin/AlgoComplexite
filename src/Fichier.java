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
	
	public ArrayList<String>[] arrayListOfWord () {		
		String line;
		String texte = new String();
		
		debutTraitement ();
		
	    try {
			while ((line = bufferLecture.readLine()) != null) {
				texte += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    String[] tab = SeparationPhraseMot.SeparationPhrase(texte);
	    
	    ArrayList<String> listePhrase[] = new ArrayList[tab.length];
	    
	    for(int i = 0 ; i < tab.length ; i++) { 
	    	listePhrase[i] = SeparationPhraseMot.SeparationMot(tab[i]);
	    }

		finDeTraitement ();
		
		return listePhrase;
		
	}
}
