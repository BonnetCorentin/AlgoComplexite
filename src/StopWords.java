import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StopWords {
	
	private String nomFichierSW;
	private BufferedReader bufferLectureSW;
	private ArrayList<String> arrayOfWordSW= new ArrayList<>();
	
	
	public StopWords (String nomFichierSW) {
		this.nomFichierSW = nomFichierSW;
		this.arrayListOfWordSW();
	}
	
	public void debutTraitement () {
		try {
			bufferLectureSW = new BufferedReader(new InputStreamReader(new FileInputStream(nomFichierSW),"UTF-8"));    		    

		}
		catch (IOException e) {
		    	e.printStackTrace();
		}
	}
	
	public void finDeTraitement () {
		try {
			bufferLectureSW.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> arrayListOfWordSW () {
		String line;
		
		debutTraitement ();
		
		try {	
		    while ((line = bufferLectureSW.readLine()) != null) {
		    	String[] wordsLine = line.toLowerCase().split(" ");
		    	for (int i=0; i<wordsLine.length;i++){
		    		arrayOfWordSW.add(wordsLine[i]);
		    	}
		    }
		}
		catch (IOException e) {
		    	e.printStackTrace();
		}		
		
		finDeTraitement ();
		return arrayOfWordSW;
	}
	
	public Boolean verif(String e) {
		return arrayOfWordSW.contains(e);
	}
}
