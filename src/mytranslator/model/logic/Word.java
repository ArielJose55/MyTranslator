/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytranslator.model.logic;

import java.util.List;

/**
 *
 * @author Ariel Arnedo
 */
public class Word {
    
    private String word;
    private List<String> translations;

    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    public Word(String word, List<String> translations) {
        this.word = word;
        this.translations = translations;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }

    @Override
    public String toString() {
        return word;
    }
    
    
}
