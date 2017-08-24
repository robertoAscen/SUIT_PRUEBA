/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.testroom.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Roberto
 */
public class HandlerFiles 
{
    private JFileChooser jfChooser;
    private File fileName;
    private FileWriter fileWrite = null;
    private JTextArea jtArea;
    private JPanel jpMessages;
    private String path;
    private PrintWriter pw;
    private String strContenido;
    private String[] guardarStr = new String[143];
    

    public HandlerFiles(JTextArea jtArea)
    {
        this.jtArea = jtArea;
    }
    
    private void writeFile(String path)
    {
        this.path = path;
        fileName = new File(path); 
        if(fileName.exists())
        {
            int request = JOptionPane.showConfirmDialog(null, "Replace existing file?");
            switch(request)
            {
                case 0:
                    try 
                    {
                        fileWrite = new FileWriter(fileName);
                        BufferedWriter bw = new BufferedWriter(fileWrite);                        
                        bw.append(jtArea.getText());
                        bw.newLine();
                        bw.close();
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(HandlerFiles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 1:
                    break;
                case 2:
                    break;            
            }           
        }
        else
        {
            try 
            {
                fileWrite = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fileWrite);                        
                bw.append(jtArea.getText());
                bw.newLine();
                bw.close();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(HandlerFiles.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
    
    public void xportFile()
    {
        jfChooser = new JFileChooser();
        jpMessages = new JPanel();
        jfChooser.showSaveDialog(jpMessages);
        if(jfChooser.getSelectedFile() != null)
        {
            writeFile(jfChooser.getSelectedFile()+".txt");
            JOptionPane.showMessageDialog(null, "Saved File");
        }
    }    
}
