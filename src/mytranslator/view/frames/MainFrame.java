/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytranslator.view.frames;

import mytranslator.view.RootFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import mytranslator.view.panels.PanelWork;


/**
 *
 * @author Ariel Arnedo
 */
public class MainFrame extends RootFrame{


    public MainFrame() {
        super("MyTranslator");
        initComponents();
        update();
        toPlace();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelWork = new javax.swing.JPanel();

        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);

        panelWork.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWork, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWork, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void update(){
        panelWork.add(new PanelWork(), BorderLayout.CENTER);
        panelWork.updateUI();
    }
    
    
    private void toPlace(){
        Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = this.getSize();
        setLocation(screen.width - size.width, screen.height - size.height-40);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelWork;
    // End of variables declaration//GEN-END:variables
}
