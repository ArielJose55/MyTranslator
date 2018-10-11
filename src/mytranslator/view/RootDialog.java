/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytranslator.view;

import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author Ariel Arnedo
 */
public class RootDialog  extends javax.swing.JDialog{


    public RootDialog() {
        super(new JFrame());
    }

    public RootDialog(boolean modal) {
        super(new JFrame(), modal);
    }

    public RootDialog( String title) {
        super(new JFrame(), title);
    }
    
    
    
}
