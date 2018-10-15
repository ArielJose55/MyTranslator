/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytranslator.model.readers;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import mytranslator.model.logic.Word;
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
            
            Element element = root.getChild(chain.toLowerCase());
            if(element != null){
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
}
