/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.testroom.frames;

/**
 *
 * @author Roberto
 */
public class ReceivedFrame 
{
    private String frame;
    private String startOfFrame;
    private String lengthOfFrame;
    private String macAddresOfFrame;
    private String idCommandOfFrame;
    private String crcOfFrame;
    private String endOfFrame;
    private boolean correctLength = false;
    
    public ReceivedFrame(String frame)
    {
        this.frame = frame;
        this.startOfFrame = frame.substring(0, 5);
        this.lengthOfFrame = frame.substring(6,12);
        this.macAddresOfFrame = frame.substring(12, 35);
        this.idCommandOfFrame = frame.substring(35, 41);
        this.crcOfFrame = frame.substring(41, 47);
        this.endOfFrame = frame.substring(48, 53);
    }

    public String getFrame() 
    {
        return frame;
    }
    
    public boolean getStartOfFrameCorrect()
    {
        if(startOfFrame.equals("55 CC"))
        {
            return true;                        
        }
        return false;
    }
    
    public boolean getEndOfFrameCorrec()
    {
        if(endOfFrame.equals("33 CC"))
        {
            return true;                        
        }
        return false;        
    }
    
    public boolean getIdCommandOfFrameCorrec()
    {
        if(idCommandOfFrame.equals("28 01"))
        {
            return true;
        }
        return false;
    }
    
    public boolean getSizeFrameInitial(String frame)
    {
        if(frame.length() == 36)
        {
            return correctLength == true;
        }        
        return correctLength;
    }

    public void setFrame(String frame)
    {
        this.frame = frame;
    }

    public String getStartOfFrame() 
    {
        return startOfFrame;
    }

    public void setStartOfFrame(String startOfFrame)
    {
        this.startOfFrame = startOfFrame;
    }

    public String getLengthOfFrame() 
    {
        return lengthOfFrame;
    }

    public void setLengthOfFrame(String lengthOfFrame)
    {
        this.lengthOfFrame = lengthOfFrame;
    }

    public String getMacAddresOfFrame() 
    {
        return macAddresOfFrame;
    }

    public void setMacAddresOfFrame(String macAddresOfFrame) 
    {
        this.macAddresOfFrame = macAddresOfFrame;
    }

    public String getIdCommandOfFrame() 
    {
        return idCommandOfFrame;
    }

    public void setIdCommandOfFrame(String idCommandOfFrame) 
    {
        this.idCommandOfFrame = idCommandOfFrame;
    }

    public String getCrcOfFrame() 
    {
        return crcOfFrame;
    }

    public void setCrcOfFrame(String crcOfFrame)
    {
        this.crcOfFrame = crcOfFrame;
    }

    public String getEndOfFrame()
    {
        return endOfFrame;
    }

    public void setEndOfFrame(String endOfFrame)
    {
        this.endOfFrame = endOfFrame;
    }    
}
