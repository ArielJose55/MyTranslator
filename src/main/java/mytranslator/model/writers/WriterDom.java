/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytranslator.model.writers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import javax.swing.SwingUtilities;
import javax.swing.text.Document;

import mytranslator.model.logic.Dom;
import mytranslator.model.logic.Word;

import org.jdom2.Attribute;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Ariel Arnedo
 */
public class WriterDom {
    
    
    public static void write(Word word) throws Exception{
        File file = new File("translations.xml");
        org.jdom2.Document document;
        org.jdom2.Element root;
        
        if(file.exists()){
            document = new org.jdom2.input.SAXBuilder().build(file);
            root = document.getRootElement();
        }else{
            root = new org.jdom2.Element("_words_");
            document = new org.jdom2.Document(root);
        }
        
        XMLOutputter writer = new XMLOutputter(Format.getPrettyFormat());
        
        Runnable run = ()->{
            Element wordXml = createElement(word.getWord().toLowerCase());
            
            word.getTranslations().forEach((main) -> {
                wordXml.addContent(new Element("_translations_").setText(main.toLowerCase()));
            });
            root.addContent(wordXml);
            FileOutputStream fileOut = null;
            try {
            	fileOut = new FileOutputStream(file);
                writer.output(document, fileOut);
            } catch (IOException ex) {
                Logger.getLogger(WriterDom.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
				if(fileOut != null) {
					try {
						fileOut.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
            
        };
        SwingUtilities.invokeLater(run);
    }
    
    private static Element createElement(String chain) {
    	String wordTemp, word;
    	wordTemp = word = chain.contains(" ") ? chain.replace(" ", "_") : chain;
    	StringBuilder sb = new StringBuilder();

    	for(Character ch : Dom.CHARS_VALIDED) {
    		
    		boolean contains = false;
    		StringBuilder sbchar = new StringBuilder(ch.toString());
    		
    		for(int i = 0; i < wordTemp.length(); i++) {
    			if(wordTemp.charAt(i) == ch) {
    				sbchar.append(i);
    				sbchar.append(",");
        			contains = true;
        		}
    		}
    		if(contains) {
    			sb.append(sbchar.substring(0, sbchar.length() - 1));
    			sb.append(":");
    			word = wordTemp.replace(ch, '_');
    			wordTemp = word;
    		}
    	}
    	
    	Element element = new Element(word);
    	
    	if(sb.length() > 0){
    		Attribute attribute = new Attribute("esp", sb.substring(0, sb.length() - 1));
    		element.setAttribute(attribute);
    	}
    	
    	return element;
    }
    
   
    
    
}
