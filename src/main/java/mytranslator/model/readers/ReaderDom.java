/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytranslator.model.readers;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import mytranslator.model.logic.Dom;
import mytranslator.model.logic.Word;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Ariel Arnedo
 */
public class ReaderDom {
    
    public static Word read(String chain) throws Exception{
        
        File file = new File("translations.xml");
        
        if(!file.exists()){
            return null;
        }else{
            
            SAXBuilder reader = new SAXBuilder();
            Document document = reader.build(file);
            Element root = document.getRootElement();
            
            Element element = root.getChild(createWord(chain.toLowerCase()));
            if(element != null && validate(element, chain.toLowerCase())){
                Word wordXml = new Word(chain);
                List<String> translations = new ArrayList<>();
                element.getChildren().forEach((translation) -> {
                    translations.add(translation.getText());
                });
                wordXml.setTranslations(translations);
                return wordXml;
            }
            return null;
        }
    }
    
    private static String createWord(String chain) {
    	
    	String wordTemp, word;
    	wordTemp = word = chain.contains(" ") ? chain.replace(" ", "_") : chain;

    	for(Character ch : Dom.CHARS_VALIDED) {
    		
    		if(wordTemp.contains(ch.toString())) {
    			word = wordTemp.replace(ch, '_');
    			wordTemp = word;
    		}
    	}
    	
    	return word;
    }
    
    private static boolean validate(final Element element, final String chain) {
    	Attribute attr = element.getAttribute("esp");
    	if(attr == null)
    		return true;
    	
    	char[] characters = element.getName().toCharArray();
    	String attibute = attr.getValue();
    	
    	String[] values = attibute.split(":");
    	
    	for(String value : values) {
    		char character = value.split("-")[0].charAt(0);
    		String[] numbers = value.split("-")[1].split(",");
    		for(String number: numbers) {
    			int i = Integer.parseInt(number);
    			characters[i] = character;
    		}
    	}
    	String word = new String(characters).replace('_', ' ');
    	
    	return word.compareTo(chain) == 0;
    }
}
