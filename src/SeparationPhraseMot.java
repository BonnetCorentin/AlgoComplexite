import java.util.ArrayList;

public class SeparationPhraseMot {
	static public ArrayList<String> SeparationMot(String phrase) {
		ArrayList<String> motParPhrase = new ArrayList<String>();
		
		StopWords sw = new StopWords("StopWords/FrenchEnglishSW.txt");
		String[] separateur = phrase.toLowerCase().split("[|,|“|’|”|;|:|\"|'|+|*|-|«|»|(|)|{|}|<|>|#]");
		phrase=new String ();
		phrase = separateur[0].trim();
		for (int j=1;j<separateur.length;j++) {
			phrase=phrase+" "+separateur[j].trim ();
		}
		System.out.println(phrase);
		String[] separateur2 = phrase.toLowerCase().split(" | ");
		for (int i=0;i<separateur2.length;i++) {
			separateur2[i]=separateur2[i].trim();
			if(!sw.verif(separateur2[i])) {
				motParPhrase.add(separateur2[i]);
			}
		}
		return motParPhrase;
	}
	
	static public String[] SeparationPhrase(String fichier) {
			
			String[] separateur = fichier.toLowerCase().split("[|.|!|?|]");
			for (int i=0;i<separateur.length;i++) {
				separateur[i]=separateur[i].trim();
			}
				
			return separateur;
		}
}
