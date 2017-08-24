/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.testroom.bus;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author Roberto
 */
public class HandlerPorts extends SerialPort
{    
    private String strReadPort;
    
    public HandlerPorts(String portName) 
    {
        super(portName);
    }  
    
    public void SendFrame(int[] frame)
    {
        try 
        {
            writeIntArray(frame);
            JOptionPane.showMessageDialog(null, "Sent Command!!!");
        } 
        catch (SerialPortException ex) 
        {
            //Logger.getLogger(HandlerPorts.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cannot Send Command!!!");
        }        
    }
    
    public String readPort()
    {
        try 
        {
            strReadPort = readHexString();
        } 
        catch (SerialPortException ex) 
        {
            //Logger.getLogger(HandlerPorts.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cannot Read Port!!!!");
        }
        return strReadPort;
    }
    
    public void openPorts()
    {
        try 
        {
            openPort();
            setParams(BAUDRATE_115200, DATABITS_8, STOPBITS_1, PARITY_NONE);
            JOptionPane.showMessageDialog(null, "Opened Port!!!");
        } 
        catch (SerialPortException ex) 
        {
            //Logger.getLogger(HandlerPorts.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cannot Open Port!!!");
        }
    }
    
    public void closePorts()
    {
        try 
        {
            closePort();
            JOptionPane.showMessageDialog(null, "Closed Port!!!!");
        } 
        catch (SerialPortException ex) 
        {
            //Logger.getLogger(HandlerPorts.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cannot close Port!!!");
        }
    }    
}
