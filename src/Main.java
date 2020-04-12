import java.util.ArrayList;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

import java.util.HashMap;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {

		Graph graph = new SingleGraph("Tutorial 1");
		
		graph.addNode("A" );
		graph.addNode("B" );
		graph.addNode("C" );
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");
		
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

		Viewer viewer = graph.display();
		

		

		Fichier fichier = new Fichier("Articles/test.txt");
		ArrayList <String> array= fichier.arrayListOfWord();
		
		Hashtable<String,Integer>redondance=ApparitionMot.redondanceMot(array);
		Hashtable<String,Float>redondanceFrequence=ApparitionMot.redondanceMotFrequence(redondance);
		
		/*try { 
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
		System.out.println();*/
	
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
	} 
}