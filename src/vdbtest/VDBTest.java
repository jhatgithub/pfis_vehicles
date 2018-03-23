/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vdbtest;

import javax.swing.JFrame;

/**
 *
 * @author jhughes
 */
public class VDBTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new VDBTestForm();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Vehicles Test");
        frame.setVisible(true);
    }
    
}
