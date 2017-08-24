/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.testroom.frames;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;

/**
 *
 * @author Roberto Ascencio
 */
public class LastLine 
{
    private String lineText;
    private int numLines;
    private int lineStart;
    private int lineEnd;
    
    public String getLastLine(JTextArea jTextArea)
    {
        try 
        {
            Document document = jTextArea.getDocument();
            Element rootElem = document.getDefaultRootElement();
            numLines = rootElem.getElementCount();
            Element lineElem = rootElem.getElement(numLines - 1);
            lineStart = lineElem.getStartOffset();
            lineEnd = lineElem.getEndOffset();
            lineText = document.getText(lineStart, lineEnd - lineStart);
        } 
        catch (BadLocationException ex) 
        {
            Logger.getLogger(LastLine.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lineText;
    }   
}
