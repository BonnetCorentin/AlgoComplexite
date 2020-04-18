import java.util.ArrayList;

import java.util.HashMap;
import java.util.Hashtable;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;



public class Main {

	public static void main(String[] args) {	
		
		Fichier fichier = new Fichier("Articles/test.txt");
		ArrayList<String>[] listePhrase = fichier.arrayListOfWord();
		
		Hashtable<String,Integer>redondance=ApparitionMot.redondanceMot(listePhrase);
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
				 System.out.println (k+" : "+v+"% fr�quence du mot");
			 }
			); 
	      } 
	      catch (Exception e) { 
	    	  System.out.println("Exception: " + e); 
	      }
		System.out.println();
		HashMap<Integer, ArrayList<DoubleString>>a=NombreOccurence.coOccurence(listePhrase);

		try { 
			 a.forEach((k, v) -> { 
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
		
		HashMap<String,Integer> hm = NombreOccurence.TopKOccurence(a);
		Graph graph = new SingleGraph("Tutorial 1");
		try { 
			hm.forEach((k, v) -> { 
				
					String[] b = k.split("=");
					b[0]=b[0].trim();
					b[1]=b[1].trim();
					System.out.println(k+" apparait :"+v+" fois");
					if (graph.getNode(b[0]) == null)
						graph.addNode(b[0]);
					if (graph.getNode(b[1]) == null)
						graph.addNode(b[1]);
					graph.addEdge(b[0]+b[1], b[0], b[1]);
				
			 }
			); 
	      } 
	      catch (Exception e) { 
	    	  System.out.println("Exception: " + e); 
	      }
		System.out.println();		
		graph.addAttribute("ui.stylesheet", "url('file:/C:/Users/coren/Documents/Cours 3A/Algo et complexit�/AlgoComplexite/StyleSheet/css.css')");

		for (Node nd: graph) {
			nd.addAttribute("ui.label", nd.getId());
		}
		
		graph.display();
	}     
}