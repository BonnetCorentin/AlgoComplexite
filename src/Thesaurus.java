import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Thesaurus {

	private String nomFichierT;
	private BufferedReader bufferLectureT;
	
	
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
	
	public ArrayList<String> arrayListOfWordSW () {
		ArrayList<String> arrayOfWordSW= new ArrayList<>();
		String line;
		debutTraitement ();
		
		try {	
		    while ((line = bufferLectureT.readLine()) != null) {
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
}
