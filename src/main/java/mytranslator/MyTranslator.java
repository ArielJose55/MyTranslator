/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytranslator;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import mytranslator.view.frames.MainFrame;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author Ariel Arnedo
 */
public class MyTranslator implements NativeKeyListener, WindowFocusListener{

    private static MainFrame mainFrame = null;

    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        MyTranslator myTranslator = new MyTranslator();
        
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(myTranslator);
        } catch (NativeHookException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al inicializar el logger de keyboad","Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {}

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
        if(NativeKeyEvent.getKeyText(nke.getKeyCode()).compareTo("F8") == 0){
            showWindow();
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {}
    
    private void showWindow(){
        SwingUtilities.invokeLater(() -> {
            if(mainFrame == null){
                mainFrame = new MainFrame();
                mainFrame.addWindowFocusListener(this);
                mainFrame.requestFocusInWindow();
                mainFrame.setAlwaysOnTop(true);
                mainFrame.setVisible(true);
            }
        });
    }
    


    @Override
    public void windowGainedFocus(WindowEvent e) {}

    @Override
    public void windowLostFocus(WindowEvent e) {
        if(mainFrame != null){
            mainFrame.setVisible(false);
            mainFrame = null;
        }
        if(mainFrame == null)
            JOptionPane.showMessageDialog(null, "Hola MAma");
    }
}
