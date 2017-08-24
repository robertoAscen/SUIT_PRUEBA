/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.testroom.frames;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class CalculateCRC 
{
    public long calculateCRC(int[] data, int numberOfints, int startint)
    {
        int[] auchCRCHi = {0, 193, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, 193, 129, 64, 1, 192, 128, 65, 0, 193, 129, 64, 0, 193, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, 193, 129, 64, 0, 193, 129, 64, 1, 192, 128, 65, 0, 193, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, 193, 129, 64, 1, 192, 128, 65, 0, 193, 129, 64, 0, 193, 129, 64, 1, 192, 128, 65, 0, 193, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, 193, 129, 64, 0, 193, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, 193, 129, 64, 1, 192, 128, 65, 0, 193, 129, 64, 0, 193, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, 193, 129, 64, 0, 193, 129, 64, 1, 192, 128, 65, 0, 193, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, 193, 129, 64, 0, 193, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, 193, 129, 64, 1, 192, 128, 65, 0, 193, 129, 64, 0, 193, 129, 64, 1, 192, 128, 65, 0, 193, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, 193, 129, 64, 1, 192, 128, 65, 0, 193, 129, 64, 0, 193, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, 193, 129, 64, 0, 193, 129, 64, 1, 192, 128, 65, 0, 193, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, 193, 129, 64};
	int[] auchCRCLo = {0, 192, 193, 1, 195, 3, 2, 194, 198, 6, 7, 199, 5, 197, 196, 4, 204, 12, 13, 205, 15, 207, 206, 14, 10, 202, 203, 11, 201, 9, 8, 200, 216, 24, 25, 217, 27, 219, 218, 26, 30, 222, 223, 31, 221, 29, 28, 220, 20, 212, 213, 21, 215, 23, 22, 214, 210, 18, 19, 211, 17, 209, 208, 16, 240, 48, 49, 241, 51, 243, 242, 50, 54, 246, 247, 55, 245, 53, 52, 244, 60, 252, 253, 61, 255, 63, 62, 254, 250, 58, 59, 251, 57, 249, 248, 56, 40, 232, 233, 41, 235, 43, 42, 234, 238, 46, 47, 239, 45, 237, 236, 44, 228, 36, 37, 229, 39, 231, 230, 38, 34, 226, 227, 35, 225, 33, 32, 224, 160, 96, 97, 161, 99, 163, 162, 98, 102, 166, 167, 103, 165, 101, 100, 164, 108, 172, 173, 109, 175, 111, 110, 174, 170, 106, 107, 171, 105, 169, 168, 104, 120, 184, 185, 121, 187, 123, 122, 186, 190, 126, 127, 191, 125, 189, 188, 124, 180, 116, 117, 181, 119, 183, 182, 118, 114, 178, 179, 115, 177, 113, 112, 176, 80, 144, 145, 81, 147, 83, 82, 146, 150, 86, 87, 151, 85, 149, 148, 84, 156, 92, 93, 157, 95, 159, 158, 94, 90, 154, 155, 91, 153, 89, 88, 152, 136, 72, 73, 137, 75, 139, 138, 74, 78, 142, 143, 79, 141, 77, 76, 140, 68, 132, 133, 69, 135, 71, 70, 134, 130, 66, 67, 131, 65, 129, 128, 64 };
		
	int usDataLen = numberOfints;
	int uchCRCHi = 255;
	int uchCRCLo = 255;
	int i = 0;
	while (usDataLen > 0)
	{
            usDataLen--;
	    int uIndex = uchCRCLo ^ data[(i + startint)];
	    uchCRCLo = uchCRCHi ^ auchCRCHi[uIndex];
	    uchCRCHi = auchCRCLo[uIndex];
	    i++;
	}	    
	return uchCRCHi << 8 | uchCRCLo;
    }
	
    public static int[] DetectRawBytes(String textField)
    {
        List<Integer> arrayList = new ArrayList();
	int startChar = 0;int stopChar = 0;
	    
	boolean endReached = false;
	while (stopChar >= 0)
	{
            stopChar = textField.indexOf(',', startChar);
	    if (stopChar == -1) 
            {
                stopChar = textField.indexOf(' ', startChar);
	    }
	    if (stopChar == -1)
	    {
	       stopChar = textField.length();
	       endReached = true;
	    }
	    String stringValue = textField.substring(startChar, stopChar);
	    //int intValue;
	    int intValue = ConvertHexToDecimal(stringValue);
	    arrayList.add(Integer.valueOf(intValue));
	    startChar = stopChar + 1;
	    if (endReached) 
            {
	        break;
            }
	}
	int[] array = new int[arrayList.size()];
	for (int i = 0; i < arrayList.size(); i++) 
        {
            array[i] = ((Integer)arrayList.get(i)).intValue();
	}
	return array;
    }
	  
    public static int ConvertHexToDecimal(String HexValue)
    {
        int length = HexValue.length();
        int value = 0;
	for (int i = 0; i < length; i++) 
        {
            value += GetHexValue(HexValue.charAt(length - i - 1)) * (int)Math.pow(16.0D, i);
	}
	return value;
    }
    
    public static int GetHexValue(char charValue)
    {
        int value = 0;
	switch (charValue)
	{
	    case '0': 
	      value = 0;
	      break;
	    case '1': 
	      value = 1;
	      break;
	    case '2': 
	      value = 2;
	      break;
	    case '3': 
	      value = 3;
	      break;
	    case '4': 
	      value = 4;
	      break;
	    case '5': 
	      value = 5;
	      break;
	    case '6': 
	      value = 6;
	      break;
	    case '7': 
	      value = 7;
	      break;
	    case '8': 
	      value = 8;
	      break;
	    case '9': 
	      value = 9;
	      break;
	    case 'a': 
	      value = 10;
	      break;
	    case 'b': 
	      value = 11;
	      break;
	    case 'c': 
	      value = 12;
	      break;
	    case 'd': 
	      value = 13;
	      break;
	    case 'e': 
	      value = 14;
	      break;
	    case 'f': 
	      value = 15;
	      break;
	    case 'A': 
	      value = 10;
	      break;
	    case 'B': 
	      value = 11;
	      break;
	    case 'C': 
	      value = 12;
	      break;
	    case 'D': 
	      value = 13;
	      break;
	    case 'E': 
	      value = 14;
	      break;
	    case 'F': 
	      value = 15;
	      break;
	    case ':': 
	    case ';': 
	    case '<': 
	    case '=': 
	    case '>': 
	    case '?': 
	    case '@': 
	    case 'G': 
	    case 'H': 
	    case 'I': 
	    case 'J': 
	    case 'K': 
	    case 'L': 
	    case 'M': 
	    case 'N': 
	    case 'O': 
	    case 'P': 
	    case 'Q': 
	    case 'R': 
	    case 'S': 
	    case 'T': 
	    case 'U': 
	    case 'V': 
	    case 'W': 
	    case 'X': 
	    case 'Y': 
	    case 'Z': 
	    case '[': 
	    case '\\': 
	    case ']': 
	    case '^': 
	    case '_': 
	    case '`': 
	    default: 
	      value = 0;
	}
	return value;
    }
}
