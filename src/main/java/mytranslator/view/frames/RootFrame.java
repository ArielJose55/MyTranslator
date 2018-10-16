/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytranslator.view.frames;


import java.awt.HeadlessException;

/**
 *
 * @author Ariel Arnedo
 */
public abstract class RootFrame extends javax.swing.JFrame {

    public RootFrame() throws HeadlessException {
        super();
    }

    public RootFrame(String title) throws HeadlessException {
        super(title);
    }
    
    public abstract void toPlace();
    
    public abstract void update();
    
}
