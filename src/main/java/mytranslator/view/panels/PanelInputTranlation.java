/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytranslator.view.panels;

import java.util.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import mytranslator.model.logic.Word;
import mytranslator.model.writers.WriterDom;
import mytranslator.view.SwingAttribute;
import mytranslator.view.dialogs.DialogMean;

/**
 *
 * @author Ariel Arnedo
 */
public class PanelInputTranlation extends javax.swing.JPanel implements SwingAttribute{

    private final Word word;
    private final JDialog parent;
    
    public PanelInputTranlation(JDialog parent, Word word) {
        this.parent = parent;
        this.word = word;
        initComponents();
        update();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        laberWord = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textTranslation = new javax.swing.JEditorPane();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(COLOR_BACKGROUND);
        setBorder(BORDER_SECUNDARY);

        laberWord.setFont(FONT_LABEL_PRIMARY);
        laberWord.setForeground(COLOR_FOREGROUND_LABEL);

        textTranslation.setFont(FONT_TEXT);
        textTranslation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textTranslationKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(textTranslation);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(laberWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(laberWord, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textTranslationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTranslationKeyTyped
         if(evt.isControlDown()){
             if(evt.getKeyChar() == KeyEvent.VK_ENTER){
                 if(textTranslation.getText().compareTo("") != 0){
                     word.setTranslations(getTranslations());
                     try{
                        WriterDom.write(word);
                     }catch(Exception ex){
                         JOptionPane.showMessageDialog(null, ex.getMessage(),"Error de Escritura", JOptionPane.WARNING_MESSAGE);
                     }
                     ((DialogMean)parent).doClose();
                 }else{
                     java.awt.Toolkit.getDefaultToolkit().beep();
                 }
             }else if(evt.getKeyChar() == KeyEvent.VK_DELETE){
                 ((DialogMean)parent).doClose();
             }
         }
    }//GEN-LAST:event_textTranslationKeyTyped

    private void update(){
        laberWord.setText(word.getWord());
    }
    
    private List<String> getTranslations(){
        List<String> list = new ArrayList<>();
        String translations[] = textTranslation.getText().split(",");
        for (int i = 0; i < translations.length ; i++) {
            if(translations[i].startsWith(" ")){
                if(translations[i].split(" ").length > 1){
                    translations[i] = translations[i].replaceFirst(" ", "");
                }else{
                    translations[i] = translations[i].replaceAll(" ", "");
                }
            }  
        }
        list.addAll(java.util.Arrays.asList(translations));
        return list;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel laberWord;
    private javax.swing.JEditorPane textTranslation;
    // End of variables declaration//GEN-END:variables
}
