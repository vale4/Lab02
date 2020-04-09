package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class Word {
	
	private String alienWord;
	//private String translation;
	private List<String>translations;
	
	

	
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translations=new ArrayList<>();
		this.translations.add(translation);
	}
	
	public Word(String alienWord) {
		this.alienWord = alienWord;
		this.translations=new ArrayList<>();
	}
	
	

	//esercizio 2

	public String getTranslations() {
		String s="";
		for(String t : translations) {
			s+=t+"\n";
		}
		return s;
	}

	public void setTranslations(String translation) {
		if(!translations.contains(translation))
			translations.add(translation);
	}
	
	

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	
	

	
	
	
	
}
