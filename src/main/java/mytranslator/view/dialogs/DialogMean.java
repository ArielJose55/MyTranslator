/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytranslator.view.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import mytranslator.model.logic.Word;
import mytranslator.view.RootDialog;
import mytranslator.view.panels.PanelInputTranlation;
import mytranslator.view.panels.PanelViewTranslation;

/**
 *
 * @author Ariel Arnedo
 */
public class DialogMean extends RootDialog {

    private final Word word;
    private final mytranslator.view.panels.Type type;
    
    public DialogMean(Word word, mytranslator.view.panels.Type type) {
        super(true);
        this.word = word;
        this.type = type;
        initComponents();
        toPlace();
    }

   
    private void toPlace(){
        Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = this.getSize();
        setLocation(screen.width - size.width, screen.height - size.height-40);
        
        if(this.type.compareTo(mytranslator.view.panels.Type.INPUT_TRANSLATION) == 0){
            panelWork.add(new PanelInputTranlation(this, word), BorderLayout.CENTER);
        }else{
            panelWork.add(new PanelViewTranslation(this, word), BorderLayout.CENTER);
        }
        panelWork.updateUI();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelWork = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);

        panelWork.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWork, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWork, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void doClose(){
        this.setVisible(false);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelWork;
    // End of variables declaration//GEN-END:variables
}
