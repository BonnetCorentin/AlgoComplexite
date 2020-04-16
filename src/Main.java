import java.util.ArrayList;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

import java.util.HashMap;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {
		
		

		/*Graph graph = new SingleGraph("Tutorial 1");
		
		graph.addNode("A" );
		graph.addNode("B" );
		graph.addNode("C" );
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");
		
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

		//Viewer viewer = graph.display();
		
		Thesaurus fichierDico = new Thesaurus("thesaurus-v2.3/thes_fr.dat");
		ArrayList<String> dico = fichierDico.arrayListOfWordThe();
		
		System.out.println(dico);*/

		Fichier fichier = new Fichier("Articles/test.txt");
		ArrayList <String> arrayWord= fichier.arrayListOfWord();
		
		
		
		/*ArrayList <String> array= ApparitionMot.suppStopWords(arrayWord, arraySW);
		
		Hashtable<String,Integer>redondance=ApparitionMot.redondanceMot(array);
		Hashtable<String,Float>redondanceFrequence=ApparitionMot.redondanceMotFrequence(redondance);
		
		try { 
			redondance.forEach((k,v) -> { 
            System.out.println (k + " : " + v + " occurences du mot");
	 			}); 
		} 
		catch (Exception e) { 
			System.out.println("Exception: " + e); 
		}
		System.out.println();
		
		try { 
				redondanceFrequence.forEach((k, v) -> { 
				 System.out.println (k+" : "+v+"% fréquence du mot");
			 }
			); 
	      } 
	      catch (Exception e) { 
	    	  System.out.println("Exception: " + e); 
	      }
		System.out.println();
	
		try { 
			 fichier.TopKOccurence().forEach((k, v) -> { 
				 System.out.print (k+" : ");
				 for(DoubleString compteur:v) {
					 System.out.print(compteur.ToString()+" ");
				 }
				 System.out.println();
			 }
			); 
	      } 
	      catch (Exception e) { 
	    	  System.out.println("Exception: " + e); 
	      }
		
		System.out.println();
		
		HashMap<String,Integer> hm = NombreOccurence.coOccurence(fichier.TopKOccurence());
		
		try { 
			hm.forEach((k, v) -> { 
				System.out.println(k+" apparait :"+v+" fois");
			 }
			); 
	      } 
	      catch (Exception e) { 
	    	  System.out.println("Exception: " + e); 
	      }
		System.out.println();
		
		StopWords sw = new StopWords("StopWords/FrenchEnglishSW.txt");
		System.out.println(sw.verif("je"));*/
	} 
}