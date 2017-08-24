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
public class SendFrames 
{    
    private HandlerFrames hFrame = new HandlerFrames();
    
    public int[] getIntframe0x28(String macTrim, String sizeCommand, String command0x28)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x28);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x28, crc);
        return hFrame.getFrameSend(completeFrame);
    }    
    
    public String getStrframe0x28(String macTrim, String sizeCommand, String command0x28)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x28);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x28, crc);
        
        return String.valueOf(completeFrame);
    } 
    
    public int[] getIntframe0x40(String macTrim, String sizeCommand, String command0x40)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x40);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x40, crc);
        return hFrame.getFrameSend(completeFrame);
    }    
    
    public String getStrframe0x40(String macTrim, String sizeCommand, String command0x40)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x40);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x40, crc);
        
        return String.valueOf(completeFrame);
    }
    
    public int[] getIntframe0x22(String macTrim, String sizeCommand, String command0x40)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x40);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x40, crc);
        return hFrame.getFrameSend(completeFrame);
    }    
    
    public String getStrframe0x22(String macTrim, String sizeCommand, String command0x40)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x40);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x40, crc);
        
        return String.valueOf(completeFrame);
    }
    
    public int[] getIntframe0x31(String macTrim, String sizeCommand, String command0x31)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x31);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x31, crc);
        return hFrame.getFrameSend(completeFrame);
    }    
    
    public String getStrframe0x31(String macTrim, String sizeCommand, String command0x31)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x31);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x31, crc);
        
        return String.valueOf(completeFrame);
    }
    public int[] getIntframe0x51(String macTrim, String sizeCommand, String command0x51)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x51);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x51, crc);
        return hFrame.getFrameSend(completeFrame);
    }    
    
    public String getStrframe0x51(String macTrim, String sizeCommand, String command0x51)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x51);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x51, crc);
        
        return String.valueOf(completeFrame);
    }
    public int[] getIntframe0x70(String macTrim, String sizeCommand, String command0x70)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x70);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x70, crc);
        return hFrame.getFrameSend(completeFrame);
    }    
    
    public String getStrframe0x70(String macTrim, String sizeCommand, String command0x70)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x70);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x70, crc);
        
        return String.valueOf(completeFrame);
    }
    public int[] getIntframe0x61(String macTrim, String sizeCommand, String command0x61)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x61);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x61, crc);
        return hFrame.getFrameSend(completeFrame);
    }    
    
    public String getStrframe0x61(String macTrim, String sizeCommand, String command0x61)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x61);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x61, crc);
        
        return String.valueOf(completeFrame);
    }
    public int[] getIntframe0x34(String macTrim, String sizeCommand, String command0x34)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x34);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x34, crc);
        return hFrame.getFrameSend(completeFrame);
    }    
    
    public String getStrframe0x34(String macTrim, String sizeCommand, String command0x34)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x34);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x34, crc);
        
        return String.valueOf(completeFrame);
    }
    public int[] getIntframe0x35(String macTrim, String sizeCommand, String command0x35)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x35);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x35, crc);
        return hFrame.getFrameSend(completeFrame);
    }    
    
    public String getStrframe0x35(String macTrim, String sizeCommand, String command0x35)
    {
        //String length =  hFrame.getLengthFrameSend(macTrim, command0x28);
        String crc = hFrame.CRC(macTrim, command0x35);
        StringBuilder completeFrame = hFrame.getTrimFrameComplete(sizeCommand, macTrim, command0x35, crc);
        
        return String.valueOf(completeFrame);
    }
}
