/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.testroom.frames;

import java.util.StringTokenizer;

/**
 *
 * @author Roberto
 */
public class HandlerFrames 
{
    private static String START_OF_FRAME = "55 CC";
    private static String END_OF_FRAME = "33 CC";
    private CalculateCRC calculate = new CalculateCRC();
    
    public String getTri(String str)
    {
        StringTokenizer trim = new StringTokenizer(str);
        StringBuilder sb = new StringBuilder();
        
        while(trim.hasMoreElements())
        {
            sb.append(trim.nextToken());
        }
        
        return String.valueOf(sb);
    }
    
    public String getLengthFrameSend(String trimMacAddress, String trimCommandId)
    {
        String sizeFrame = trimMacAddress+trimCommandId;
        
        return String.format("%04x",sizeFrame.length()/2);
    }
    
    public StringBuilder getTrimFrameComplete(String lengthOfFrame, String macOfFrame, String commandId, String crcOfFrame)
    {
        StringTokenizer trim = new StringTokenizer(START_OF_FRAME+lengthOfFrame+macOfFrame+commandId+crcOfFrame+END_OF_FRAME);
        StringBuilder sb = new StringBuilder();
        
        while(trim.hasMoreElements())
        {
            sb.append(trim.nextToken());
        }
        
        return sb;
    }
    
    public String CRC(String mac, String command)
    {        
        int[] array;
        String strCrc;
        long crc;
        array = calculate.DetectRawBytes(mac+" "+command);
        crc = calculate.calculateCRC(array, array.length, 0);
        return strCrc = String.format("%02x",(crc & 0xFF)).toUpperCase()+" "+String.format("%02x",(crc & 0xFF00)>>8).toUpperCase();
    }  
    
    public int[] getFrameSend(StringBuilder frameComplete)
    {
        int[] frameInt = new int[frameComplete.length()/2];
        int numHex = 0;
        int count = 0;
        for(int i=0;i<frameComplete.length();i++)
        {
            if(i == 0 || i%2 == 0)
            {
                numHex = Integer.parseInt((String) frameComplete.subSequence(i, i+2),16);
                frameInt[count++] = numHex;
            }
        }
        return frameInt;
    }
}
