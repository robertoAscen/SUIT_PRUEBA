/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.testroom.frames;

/**
 *
 * @author Roberto Ascencio
 */
public class DefragFrame 
{
    private String frame;
    
    public DefragFrame(String frame)
    {
        this.frame = frame;
    }
    
    public String getStrAnswer0x28()
    {
        return this.frame.substring(71, 76);
    }
    
    public boolean getBlAnswer0x28()
    {
        if(this.frame.substring(71, 76).equals("50 01"))
        {
            return true;
        }
        return false;
    }
    
    public String getStrAnswer0x40()
    {
        return this.frame.substring(71, 76);
    }
    
    public boolean getBlAnswer0x40()
    {
        if(this.frame.substring(71, 76).equals("40 01"))
        {
            return true;
        }
        return false;
    }
    
    public String getStrAnswer0x31()
    {
        return this.frame.substring(71, 76);
    }
    
    public boolean getBlAnswer0x31()
    {
        if(this.frame.substring(71, 76).equals("31 01"))
        {
            return true;
        }
        return false;
    }
    
    public String getStrAnswer0x51()
    {
        return this.frame.substring(71, 76);
    }
    
    public boolean getBlAnswer0x51()
    {
        if(this.frame.substring(71, 76).equals("51 01"))
        {
            return true;
        }
        return false;
    }
    
    public String getStrAnswer0x70()
    {
        return this.frame.substring(71, 76);
    }
    
    public boolean getBlAnswer0x70()
    {
        if(this.frame.substring(71, 76).equals("70 01"))
        {
            return true;
        }
        return false;
    }
    
    public String getStrAnswer0x61()
    {
        return this.frame.substring(71, 76);
    }
    
    public boolean getBlAnswer0x61()
    {
        if(this.frame.substring(71, 76).equals("61 01"))
        {
            return true;
        }
        return false;
    }
    
    public String getStrAnswer0x34()
    {
        return this.frame.substring(71, 76);
    }
    
    public boolean getBlAnswer0x34()
    {
        if(this.frame.substring(71, 76).equals("34 01"))
        {
            return true;
        }
        return false;
    }
    
    public String getStrAnswer0x35()
    {
        return this.frame.substring(71, 76);
    }
    
    public boolean getBlAnswer0x35()
    {
        if(this.frame.substring(71, 76).equals("35 01"))
        {
            return true;
        }
        return false;
    }
}
