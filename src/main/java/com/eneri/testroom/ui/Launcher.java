/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.testroom.ui;

import java.awt.EventQueue;

/**
 *
 * @author Roberto
 */
public class Launcher
{
  public static JFrameMain mainFrame = new JFrameMain();
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        Launcher.getMainFrame().setVisible(true);
        Launcher.getMainFrame().setLocationRelativeTo(null);
      }
    });
  }
  
  public static JFrameMain getMainFrame()
  {
    return mainFrame;
  }
}
