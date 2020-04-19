import java.io.File;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Hashtable;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;



public class Main {

	public static void main(String[] args) {	
		
		Graph graph = new SingleGraph("Tutorial 1");
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
				 System.out.println (k+" : "+v+"% fréquence du mot");
				 if(redondanceFrequence.get(k)>3) {	//Supérieur a 3% d'apparition
					 if(graph.getNode(k)==null) {
						 graph.addNode(k).addAttribute("ui.style","text-color:white; text-style: bold; fill-color: white; ");
					 }
				 }
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
				 System.out.print ("Phrase "+k+" : ");
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

		try { 
			hm.forEach((k, v) -> { 
				
					String[] b = k.split("=");
					b[0]=b[0].trim();
					b[1]=b[1].trim();
					System.out.println(k+" apparait :"+v+" fois");
					if (graph.getNode(b[0]) == null) //ajoute un noeud
						graph.addNode(b[0]);
					if (graph.getNode(b[1]) == null) //ajoute un noeud
						graph.addNode(b[1]);
						graph.addEdge(b[0]+b[1], b[0], b[1]);	//ajoute les arrêtes
						if(v==2){										// A CHANGER
							graph.getEdge(b[0]+b[1]).addAttribute("ui.style", "fill-color:#f7ff00;");
						}
						if(v==3){										// A CHANGER
							graph.getEdge(b[0]+b[1]).addAttribute("ui.style", "fill-color:#ffb500\r\n" + 
									";");
						}
						if(v==4){										// A CHANGER
							graph.getEdge(b[0]+b[1]).addAttribute("ui.style", "fill-color: #ff6c00;");
						}
						if(v>4){										// A CHANGER
							graph.getEdge(b[0]+b[1]).addAttribute("ui.style", "fill-color: red;");
						}
			 }
			); 
	      } 
	      catch (Exception e) { 
	    	  System.out.println("Exception: " + e); 
	      }

		File fileCss = new File("StyleSheet/css.css");
		String path = fileCss.getAbsolutePath();
		
		System.out.println();		
		graph.addAttribute("ui.stylesheet", "url('"+path+"')");
		for (Node nd: graph) {
			nd.addAttribute("ui.label", nd.getId());
		}
		
		graph.display();
	}     

}