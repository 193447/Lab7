package it.polito.tdp.dizionario.model;

import java.util.*;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

public class Model {
	

    public List<String> word=new LinkedList<String>();

	
	List<String>parole=new LinkedList<String>();
	


	SimpleGraph<String,DefaultEdge> graph= new SimpleGraph<String,DefaultEdge>(DefaultEdge.class);
	
	public void creagrafo(){
	 	for(String s:word){
	 		graph.addVertex(s);
	 		}
	 	
	 	for(String s:word){
	 		parole.add(s);
		 	for(String s1:word){
		 		if(controlWord(s,s1) && !parole.contains(s1) )
		 			graph.addEdge(s, s1);
		 	}
	 	}

	}

	private boolean controlWord(String s,String s1) {
		int j=0;
		for(int i=0;i<s.length();i++){
			char st=s.charAt(i);
			char st1=s1.charAt(i);
			
			if(st==st1)
				j++;
		}
		if(j>=3)
			return true;
		return false;
	}
	
	public Collection<String> TrovaVicini(String s){
		Collections.sort(Graphs.neighborListOf(graph,s),new Comparatore());
		return Graphs.neighborListOf(graph,s);
		}

	public Collection<String> TrovaConnessi(String parola) {
		List<String> Visited = new LinkedList<String>();
		GraphIterator<String, DefaultEdge> dfv = new DepthFirstIterator<String, DefaultEdge>(graph, parola);
		while (dfv.hasNext()) {
			String t = dfv.next();
			if(controlWord1(parola,t))
				Visited.add(t);
		}
		//Collections.sort(Visited,new Comparatore1());
		return Visited;
	}
	
	private boolean controlWord1(String s,String s1) {
		int j=0;
		for(int i=0;i<s.length();i++){
			char st=s.charAt(i);
			char st1=s1.charAt(i);
			
			if(st==st1)
				j++;
		}
		if(j>=1)
			return true;
		return false;
	}
		
	}

	

