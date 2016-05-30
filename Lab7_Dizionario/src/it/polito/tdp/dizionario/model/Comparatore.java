package it.polito.tdp.dizionario.model;

import java.util.Comparator;

public class Comparatore implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int j=0;
		for(int i=0;i<o1.length();i++){
			char st=o1.charAt(i);
			char st1=o2.charAt(i);
			
			if(st==st1)
				j++;
		}
		if(j>=3)
			return o1.compareTo(o2);
		else if(j>=2)
			return o1.compareTo(o2);
		else if(j>=1)
			return o1.compareTo(o2);
		else
			return 0;
	}

}
