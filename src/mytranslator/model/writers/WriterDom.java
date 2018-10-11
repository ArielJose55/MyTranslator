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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import mytranslator.model.logic.Word;
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
            Element wordXml = new Element(word.getWord().toLowerCase());
            
            word.getTranslations().forEach((main) -> {
                wordXml.addContent(new Element("_translations_").setText(main.toLowerCase()));
            });
            root.addContent(wordXml);
            
            try {
                writer.output(document, new FileOutputStream(file));
            } catch (IOException ex) {
                Logger.getLogger(WriterDom.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        };
        new Thread(run).start();
    }
}
