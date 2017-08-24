/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.testroom.thread;

import com.eneri.testroom.bus.HandlerPorts;
import com.eneri.testroom.time.Stamp;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Roberto
 */
public class ThreadBusRead extends Thread
{
    private HandlerPorts ports;
    private JTextArea jtArea;
    private Stamp timeStamp = new Stamp();
    
    public ThreadBusRead(JTextArea jtArea, HandlerPorts ports)
    {
        this.jtArea = jtArea;
        this.ports = ports;        
    }
    
    public void run()
    {
        while(true)
        {
            try 
            {
                sleep(2000);
                String datosPuerto = ports.readPort();
                if(datosPuerto != null){
                    //jtArea.append("Recibido: "+timeStamp.getTimeStamp()+" <--- "+datosPuerto+"\n\r\t\r\t\n");
                    jtArea.append("\nRecibido: "+timeStamp.getTimeStamp()+" <--- "+datosPuerto);
                }
                
                DefaultCaret caret = (DefaultCaret)jtArea.getCaret();
                caret.setUpdatePolicy(2);
                jtArea.setCaretPosition(jtArea.getDocument().getLength());
            } 
            catch (InterruptedException ex)
            {
                Logger.getLogger(ThreadBusRead.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    public void sleept(long time)
    {
        try 
        {
            sleep(time);
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(ThreadBusRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
