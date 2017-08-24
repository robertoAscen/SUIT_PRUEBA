/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.testroom.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Roberto
 */
public class Stamp 
{
    private String timeStampComplete;
    
    public String getTimeStamp()
    {
        timeStampComplete  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        
        return timeStampComplete;
    }    
}
