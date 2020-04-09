package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word>dizionario=new ArrayList<>();
	
	public void add(String alienWord, String translation) {
		Word w=new Word(alienWord, translation);
		if(dizionario.contains(w)) {
			dizionario.get(dizionario.indexOf(w)).setTranslations(translation);
			return;
		}
		w.setTranslations(translation);
		dizionario.add(w);
	}
	
	public String translateWord(String alienWord) {
		Word w=new Word(alienWord);
		if(dizionario.contains(w)) {
			return dizionario.get(dizionario.indexOf(w)).getTranslations();
		}
		return null;
	}

}
