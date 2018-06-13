/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import ui.appmain_ui;
import ui.JLogin_ui;

/**
 *
 * @author REBOOTSYSTEM
 */
public class JMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        JFrame login = new JLogin_ui();
        login.setVisible(true);
        
        /*
        JFrame main_ui = new appmain_ui();
        main_ui.setVisible(true);
*/
    }
    
}
