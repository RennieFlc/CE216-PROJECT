package com.example.ce216project;

import java.util.ArrayList;
import java.util.List;

public class Language {
    private String LanguageName; //changed string name in UML to LanguageName, so it'd be more specific.
    private String Alphabet; //instead of string Script , Alphabet is replaced which is more clear.
    private List<Word> Word; //a list of word objects which basically represents the words all the words in languages

    public Language(String LanguageName, String Alphabet){
        this.LanguageName = LanguageName;
        this.Alphabet = Alphabet;
        Word = new ArrayList<>();
    }

    //some methods up until now.

    public String getLanguageName(){
        return LanguageName;
    }
    public String getAlphabet(){
        return Alphabet;
    }
    public List<Word> getWord(){
        return Word;
    }
    public void addWord(Word word){
        Word.add(word);
    }
    public void removeWord(Word word){
        Word.remove(word);
    }
    public void findWord(){
    }


}
