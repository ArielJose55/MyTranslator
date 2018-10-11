/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytranslator.view.frames;

import com.sun.javafx.binding.SelectBinding;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import mytranslator.view.IFrame;
import mytranslator.view.panels.PanelWork;

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
