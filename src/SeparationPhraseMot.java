import java.util.ArrayList;

public class SeparationPhraseMot {
	static public ArrayList<String> SeparationMot(String phrase) {
		ArrayList<String> motParPhrase = new ArrayList<String>();
		StopWords sw = new StopWords("StopWords/FrenchEnglishSW.txt");
		
		String[] separateur = phrase.toLowerCase().split(" ");
		for (int i=0;i<separateur.length;i++) {
			if(!sw.verif(separateur[i])) {
				motParPhrase.add(separateur[i]);
			}
		}
			
		return motParPhrase;
	}
	
	static public String[] SeparationPhrase(String fichier) {
			
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
