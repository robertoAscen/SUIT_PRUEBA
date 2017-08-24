/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.testroom.ui;

import com.eneri.testroom.bus.HandlerPorts;
import com.eneri.testroom.files.HandlerFiles;
import com.eneri.testroom.frames.DefragFrame;
import com.eneri.testroom.frames.HandlerFrames;
import com.eneri.testroom.frames.IdCommand;
import com.eneri.testroom.frames.LastLine;
import com.eneri.testroom.frames.ReceivedFrame;
import com.eneri.testroom.frames.SendFrames;
import com.eneri.testroom.thread.ThreadBusRead;
import com.eneri.testroom.time.Stamp;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.KeyStore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import jssc.SerialPortList;

/**
 *
 * @author Roberto
 */
public class JFrameMain extends JFrame
{
//*******************************************************************************************************************************
//***********atributes for bar***************************************************************************************************
//*******************************************************************************************************************************
    private JMenuBar jmBar;
    private JMenu jmFile;
    private JMenu jmBus;
    private JMenu jmStages;
    private JMenu jmDevices;
    private JMenu jmCoordinator;
    private JMenu jmLog;   
    private JMenu jmHelp;
    private JMenuItem jmiSaveFile;
    private JMenuItem jmiExit;
    private JMenuItem jmiOpenPort;
    private JMenuItem jmiClosePort;
    private JMenuItem jmiRefreshPort;
    private JMenuItem jmiSeeStages;    
    private JMenuItem jmiSeeCoordinator;
    private JMenuItem jmiReboot;
    private JMenuItem jmiGabinet;
    private JMenuItem jmiMeter;
    private JMenuItem jmiSeeLog;
    private JMenuItem jmiClearLog;
    private JMenuItem jmiStopLog;
    private JMenuItem jmiContinueLog;
    private JMenuItem jmiAbout;
    
    
//*******************************************************************************************************************************
//***********atributes for panel Bus*********************************************************************************************
//*******************************************************************************************************************************    
    private TitledBorder titlePanelBus;
    private JPanel jPanelBus;
    private JLabel jlPorts;
    private JLabel jlIndicateMac;
    private JLabel jlShowMac;
    private SerialPortList splistPorts;
    private HandlerPorts hPorts;
    private DefaultComboBoxModel<String> dcbPorts;
    private JComboBox<String> jcbPorts;
    private JButton jbOpenPort;
    private JButton jbClosePort;
    
//*******************************************************************************************************************************
//***********atributes for panel TAB Coordinator*********************************************************************************
//*******************************************************************************************************************************    
    private JTabbedPane jtabPanel;
    private JPanel jpCoordinator;
    private ImageIcon iconQuestion;
    private ImageIcon iconGood;
    private ImageIcon iconFail;
    private JLabel jlIndicateStartOfFrame;
    private JLabel jlIndicateLengthOfFrame;
    private JLabel jlIndicateMacOfFrame;
    private JLabel jlIndicateCommandOfFrame;
    private JLabel jlIndicateCrcOfFrame;
    private JLabel jlIndicateEndOfFrame;
    private JLabel jlShowStartOfFrame;
    private JLabel jlShowLengthOfFrame;
    private JLabel jlShowMacOfFrame;
    private JLabel jlShowCommandOfFrame;
    private JLabel jlShowCrcOfFrame;
    private JLabel jlShowEndOfFrame;
    private JLabel jlValidatorStartOfFrame;
    private JLabel jlValidatorLengthOfFrame;
    private JLabel jlValidatorMacOfFrame;
    private JLabel jlValidatorCommandOfFrame;
    private JLabel jlValidatorCrcOfFrame;
    private JLabel jlValidatorEndOfFrame;    
    private JLabel jlFragmentOfFrame;
    private JLabel jlFragmentOfFrameHex;
    private JLabel jlFragmentOfValidate;
    
//*******************************************************************************************************************************
//***********atributes for panel TAB Stages**************************************************************************************
//*******************************************************************************************************************************    
    private JPanel jpStages;
    
    private JPanel jpCards;  
    private JPanel jpResults;
    private CardLayout cardLayout;
    private TitledBorder titleCards;
    private TitledBorder titleResults;
    
    private JPanel jpSysnc;
    private JPanel jpReadMode;    
    private JPanel jpRefreshDevTable;
    private JPanel jpReadCoordinatorDate;
    private JPanel jpReadChannel;
    private JPanel jpReadPanId;
    private JPanel jpEraseMeterTable;
    private JPanel jpEraseDevicesTable;    
    private JPanel jpDoorAlarmP;
    private JPanel jpDoorAlarmS;
    private JPanel jpSingleMeasure;
    private JPanel jpTurnRelay;
    
    private JLabel jlSysnc;
    private JLabel jlReadMode;    
    private JLabel jlRefreshTable;
    private JLabel jlReadCordinatorDate;
    private JLabel jlReadChannel;
    private JLabel jlReadPanId;
    private JLabel jlEraseMeterTable;
    private JLabel jlEraseDevicesTable;   
    private JLabel jlDoorAlarmP;
    private JLabel jlDoorAlarmS;
    private JLabel jlSingleMeasure;
    private JLabel jlTurnRelay;  
    private JLabel jlFrameSend;
    private JLabel jlshowFrameSend;
    private JLabel jlFrameRecived;
    private JLabel jlshowFrameRecived;
    private JLabel jlSelectStage;
    private JButton jbSendCommand;
    private String[] strStages = {"SYSNC REQUEST PROCESS 0x28",
                                  "READ MODE VERSION COORDINATOR PROCESS 0x40",
                                  "REFRESH DEVICES TABLE 0x31",
                                  "READ COORDINATOR DATE 0x51",
                                  "READ CHANNEL 0x70",
                                  "READ PAN ID 0x61",
                                  "ERASE METER TABLE 0x34",
                                  "ERASE DEVICES TABLE 0x35",
                                  /*"DOOR ALARM PROCESS 0x25",
                                  "DOOR ALARM STATUS 0x2A",
                                  "SINGLE MEASURE PROCESS 0x10",
                                  "TURN ON RELAY PROCESS 0x12"*/};
    private DefaultComboBoxModel<String> dcbStages;
    private JComboBox<String> jcbStages;   
    
    private JLabel jlTestCase;
    private JLabel jlAnswer;
    private JLabel jlPassFail;
    
    private JLabel jl0x28;
    private JLabel jl0x40;
    private JLabel jl0x51;
    private JLabel jl0x61;
    private JLabel jl0x31;
    private JLabel jl0x70;
    private JLabel jl0x34;
    private JLabel jl0x35;
    
    //private JLabel jl0x25;
    //private JLabel jl0x2A;
    //private JLabel jl0x10;
    //private JLabel jl0xB2;
    //private JLabel jl0xB1;
    
    private JLabel jlA0x28;
    private JLabel jlA0x40;
    private JLabel jlA0x51;
    private JLabel jlA0x61;
    private JLabel jlA0x31;
    private JLabel jlA0x70;    
    private JLabel jlA0x34;
    private JLabel jlA0x35;
    
    
    //private JLabel jlA0x25;    
    //private JLabel jlA0x2A;
    //private JLabel jlA0x10;
    //private JLabel jlA0xB2;
    //private JLabel jlA0xB1;
    
    private JLabel jlPF0x28;
    private JLabel jlPF0x40;
    private JLabel jlPF0x51;
    private JLabel jlPF0x61;
    private JLabel jlPF0x31;
    private JLabel jlPF0x70;
    private JLabel jlPF0x34;
    private JLabel jlPF0x35;
    
    //private JLabel jlPF0x25;
    //private JLabel jlPF0x2A;
    //private JLabel jlPF0x10;
    //private JLabel jlPF0xB2;
    //private JLabel jlPF0xB1;
    
//*******************************************************************************************************************************    
//*******************************************************************************************************************************
//*******************************************************************************************************************************    
    
    private final SendFrames sendFrames = new SendFrames();
    private final HandlerFrames hFrames = new HandlerFrames();
    private final IdCommand idCommand = new IdCommand();    
    private final Stamp timeStamp;
    private DefragFrame dFrame;
    
//*******************************************************************************************************************************
//***********atributes for panel TAB Log*****************************************************************************************
//*******************************************************************************************************************************
    private JPanel jpLog;
    private JTextArea jTextArea;
    private JScrollPane jScrollPane; 
    
//*******************************************************************************************************************************
//***********atributes for Thread************************************************************************************************
//*******************************************************************************************************************************    
    private ThreadBusRead thread;
    
//*******************************************************************************************************************************
//***********atributes for the first frame received******************************************************************************
//*******************************************************************************************************************************
    private ReceivedFrame rFrames;    
    private int requestDialog;          //Atribute for request JOP.    
    private HandlerFiles hFiles;        //Atributo for driving files.
    
    public JFrameMain()
    {
        this.timeStamp = new Stamp();
        initComponents();
    }
    
    public void initComponents()
    {
        setLayout(null);                            //parameters for configuration JFrame
        
//*******************************************************************************************************************************
//***********Objects for bar*****************************************************************************************************
//*******************************************************************************************************************************
        this.jmBar = new JMenuBar();
        this.jmFile = new JMenu("File");
        this.jmBus = new JMenu("Bus");
        this.jmStages = new JMenu("Stages");
        this.jmDevices = new JMenu("Devices");
        this.jmLog = new JMenu("Log");    
        this.jmHelp = new JMenu("Help");
        this.jmiSaveFile = new JMenuItem("Save File");
        this.jmiExit = new JMenuItem("Exit");
        this.jmiOpenPort = new JMenuItem("Open Port");
        this.jmiClosePort = new JMenuItem("Close Port");
        this.jmiRefreshPort = new JMenuItem("Refresh Ports");
        this.jmiSeeStages = new JMenuItem("View Stages");
        this.jmCoordinator = new JMenu("Coordinator");
        this.jmiSeeCoordinator = new JMenuItem("View Coordinator");
        this.jmiReboot = new JMenuItem("Reboot");
        this.jmiGabinet = new JMenuItem("Gabinet");
        this.jmiMeter = new JMenuItem("Meter");
        this.jmiSeeLog = new JMenuItem("View Log");
        this.jmiClearLog = new JMenuItem("Clear Log");
        this.jmiStopLog = new JMenuItem("Stop Log");
        this.jmiContinueLog = new JMenuItem("Continue Log");
        this.jmiAbout = new JMenuItem("About");
        
        
//*******************************************************************************************************************************
//***********Objects for panel Bus***********************************************************************************************
//*******************************************************************************************************************************        
        this.titlePanelBus = new TitledBorder("Bus");
        this.jPanelBus = new JPanel(null);
        this.jlPorts = new JLabel("Port");
        this.jlIndicateMac = new JLabel("MacAddress");
        this.jlShowMac = new JLabel("Here will be shown the MacAddress");
        this.splistPorts = new SerialPortList();        
        this.dcbPorts = new DefaultComboBoxModel<String>(splistPorts.getPortNames());
        this.jcbPorts = new JComboBox<String>(dcbPorts);
        this.jbOpenPort = new JButton("Open Port");
        this.jbClosePort = new JButton("Close Port");
        this.hPorts = new HandlerPorts((String) jcbPorts.getSelectedItem());   
        
//*******************************************************************************************************************************
//***********Objects for panel Tab Coordinator***********************************************************************************
//*******************************************************************************************************************************          
        this.jtabPanel = new JTabbedPane();
        this.jpCoordinator = new JPanel(null);
        //this.iconQuestion = new ImageIcon("C:/Users/Roberto Ascencio/Documents/NetBeansProjects/TESTROOM/src/main/resources/image/Question.png");
        //this.iconGood = new ImageIcon("C:/Users/Roberto Ascencio/Documents/NetBeansProjects/TESTROOM/src/main/resources/image/check.png");
        //this.iconFail = new ImageIcon("C:/Users/Roberto Ascencio/Documents/NetBeansProjects/TESTROOM/src/main/resources/image/Uncheck.png");
        this.iconQuestion = new ImageIcon("image/Question.png");
        this.iconGood = new ImageIcon("image/check.png");
        this.iconFail = new ImageIcon("image/Uncheck.png");
        this.jlFragmentOfFrame = new JLabel("FRAGMENT OF FRAME");
        this.jlFragmentOfFrameHex = new JLabel("RECIVED FRAGMENT");
        this.jlFragmentOfValidate = new JLabel("VALIDATED FRAGMENT");
        this.jlIndicateStartOfFrame = new JLabel("START OF FRAME");
        this.jlIndicateLengthOfFrame = new JLabel("LENGTH OF FRAME");
        this.jlIndicateMacOfFrame = new JLabel("MAC ADDRESS");
        this.jlIndicateCommandOfFrame = new JLabel("COMMAND ID");
        this.jlIndicateCrcOfFrame = new JLabel("CRC OF FRAME");
        this.jlIndicateEndOfFrame = new JLabel("END OF FRAME");
        this.jlShowStartOfFrame = new JLabel("????????");
        this.jlShowLengthOfFrame = new JLabel("????????");
        this.jlShowMacOfFrame = new JLabel("????????");
        this.jlShowCommandOfFrame = new JLabel("????????");
        this.jlShowCrcOfFrame = new JLabel("????????");
        this.jlShowEndOfFrame = new JLabel("????????");
        this.jlValidatorStartOfFrame = new JLabel(iconQuestion);
        this.jlValidatorLengthOfFrame = new JLabel(iconQuestion);
        this.jlValidatorMacOfFrame = new JLabel(iconQuestion);
        this.jlValidatorCommandOfFrame = new JLabel(iconQuestion);
        this.jlValidatorCrcOfFrame = new JLabel(iconQuestion);
        this.jlValidatorEndOfFrame = new JLabel(iconQuestion);       
        
//*******************************************************************************************************************************
//****************Objects for panel Tab Stages***********************************************************************************
//*******************************************************************************************************************************         
        this.jpStages = new JPanel(null); 
        
        this.cardLayout = new CardLayout();
        this.jpCards = new JPanel(cardLayout);
        this.titleCards = new TitledBorder("");
        this.titleResults = new TitledBorder("Sumary");
        
        this.jpResults = new JPanel(null);
        
        this.jpSysnc = new JPanel(null);
        this.jpReadMode = new JPanel(null);
        this.jpRefreshDevTable = new JPanel(null);
        this.jpReadCoordinatorDate = new JPanel(null);
        this.jpReadChannel = new JPanel(null);
        this.jpReadPanId = new JPanel(null);
        this.jpEraseMeterTable = new JPanel(null);
        this.jpEraseDevicesTable = new JPanel(null);
        this.jpDoorAlarmP = new JPanel(null);
        this.jpDoorAlarmS = new JPanel(null);
        this.jpSingleMeasure = new JPanel(null);
        this.jpTurnRelay = new JPanel(null);
        
        this.jlSelectStage = new JLabel("Select Stage");
        this.dcbStages = new DefaultComboBoxModel<String>(strStages);
        this.jcbStages = new JComboBox<String>(dcbStages);
        
        this.jlSysnc = new JLabel("SYSNC REQUEST PROCESS 0x28");
        this.jlReadMode = new JLabel("READ MODE VERSION COORDINATOR PROCESS 0x40");        
        this.jlRefreshTable = new JLabel("REFRESH DEVICES TABLE 0x31");
        this.jlReadCordinatorDate = new JLabel("READ COORDINATOR DATE 0x51");
        this.jlReadChannel = new JLabel("READ CHANNEL 0x70");
        this.jlReadPanId = new JLabel("READ PAN ID 0x61");
        this.jlEraseMeterTable = new JLabel("ERASE METER TABLE 0x34");
        this.jlEraseDevicesTable = new JLabel("ERASE DEVICES TABLE 0x35");        
        this.jlDoorAlarmP = new JLabel("DOOR ALARM PROCESS 0x25");
        this.jlDoorAlarmS = new JLabel("DOOR ALARM STATUS 0x2A");
        this.jlSingleMeasure = new JLabel("SINGLE MEASURE PROCESS 0x10");
        this.jlTurnRelay = new JLabel("TURN ON RELAY PROCESS 0x12"); 
        
        this.jlFrameSend = new JLabel("FRAME TO SEND");
        this.jlshowFrameSend = new JLabel();
        this.jlFrameRecived = new JLabel("RECEIVED FRAME");
        this.jlshowFrameRecived = new JLabel();   
        
        this.jbSendCommand = new JButton("Send Command");  
        
        this.jlTestCase = new JLabel("TEST CASE");
        this.jlAnswer = new JLabel("ANSWER");
        this.jlPassFail = new JLabel("PASS/FAIL");
        
        jl0x28 = new JLabel("SYSNC REQUEST PROCESS 0x28");
        jl0x40 = new JLabel("READ MODE VERSION COORDINATOR 0x40");
        jl0x51 = new JLabel("READ COORDINATOR DATE 0x51");
        jl0x61 = new JLabel("READ PAN ID 0x61");
        jl0x31 = new JLabel("REFRESH DEVICES TABLE 0x31");
        jl0x70 = new JLabel("READ CHANNEL 0x70");
        jl0x34 = new JLabel("ERASE METER TABLE 0x34");
        jl0x35 = new JLabel("ERASE DEVICES TABLE 0x35");
        
        //jl0x25 = new JLabel("DOOR ALARM PROCESS 0x25");
        //jl0x2A = new JLabel("DOOR ALARM STATUS 0x2A");
        //jl0x10 = new JLabel("SINGLE MEASURE PROCESS 0x10");
        //jl0xB2 = new JLabel("TURN ON RELAY PROCESS 0xB2");
        //jl0xB1 = new JLabel("TURN OFF RELAY PROCESS 0xB1");
    
        jlA0x28 = new JLabel("----------");
        jlA0x40 = new JLabel("----------");
        jlA0x51 = new JLabel("----------");
        jlA0x61 = new JLabel("----------");
        jlA0x31 = new JLabel("----------");
        jlA0x70 = new JLabel("----------");
        jlA0x34 = new JLabel("----------");
        jlA0x35 = new JLabel("----------");
        
        /*jlA0x25 = new JLabel("----------");
        jlA0x2A = new JLabel("----------");
        jlA0x10 = new JLabel("----------");
        jlA0xB2 = new JLabel("----------");
        jlA0xB1 = new JLabel("----------");*/
    
        jlPF0x28 = new JLabel("----------");
        jlPF0x40 = new JLabel("----------");
        jlPF0x51 = new JLabel("----------");
        jlPF0x61 = new JLabel("----------");
        jlPF0x31 = new JLabel("----------");
        jlPF0x70 = new JLabel("----------");
        jlPF0x34 = new JLabel("----------");
        jlPF0x35 = new JLabel("----------");
        
        /*jlPF0x25 = new JLabel("----------");
        jlPF0x2A = new JLabel("----------");
        jlPF0x10 = new JLabel("----------");
        jlPF0xB2 = new JLabel("----------");
        jlPF0xB1 = new JLabel("----------");*/
        
//*******************************************************************************************************************************
//****************Objects for panel Tab Log**************************************************************************************
//*******************************************************************************************************************************        
        this.jTextArea = new JTextArea(1,1);
        this.jScrollPane = new JScrollPane(jTextArea);    
        this.jpLog = new JPanel(null);        
        this.thread = new ThreadBusRead(jTextArea, hPorts);
        
//*******************************************************************************************************************************
//****************Objects for Driving files**************************************************************************************
//*******************************************************************************************************************************         
        this.hFiles = new HandlerFiles(jTextArea);       
        
//*******************************************************************************************************************************
//****************General Configurations*****************************************************************************************
//*******************************************************************************************************************************        
        this.jPanelBus.setBorder(titlePanelBus);                //Configuration panel bus
        this.jPanelBus.setLayout(null);                         //Configuration panel bus
        
        this.jTextArea.setBackground(Color.black);              //Configuration JTextArea
        this.jTextArea.setForeground(Color.orange);             //Configuration JTextArea
        this.jTextArea.setLineWrap(true);                       //Configuration JTextArea
        this.jTextArea.setWrapStyleWord(true);                  //Configuration JTextArea
        
        this.jbClosePort.setEnabled(false);                     //Configuration initials Enable Components 
        this.jmiClosePort.setEnabled(false);                    //Configuration initials Enable Components
        this.jlIndicateMac.setEnabled(false);                   //Configuration initials Enable Components
        this.jlShowMac.setEnabled(false);                       //Configuration initials Enable Components
        this.jmiSaveFile.setEnabled(false);                     //Configuration initials Enable Components
        this.jmiClearLog.setEnabled(false);                     //Configuration initials Enable Components    
        this.jmiStopLog.setEnabled(false);                      //Configuration initials Enable Components    
        this.jmiContinueLog.setEnabled(false);                  //Configuration initials Enable Components
        this.jlIndicateStartOfFrame.setEnabled(false);          //Configuration initials Enable Components    
        this.jlIndicateLengthOfFrame.setEnabled(false);         //Configuration initials Enable Components
        this.jlIndicateMacOfFrame.setEnabled(false);            //Configuration initials Enable Components
        this.jlIndicateCommandOfFrame.setEnabled(false);        //Configuration initials Enable Components
        this.jlIndicateCrcOfFrame.setEnabled(false);            //Configuration initials Enable Components
        this.jlIndicateEndOfFrame.setEnabled(false);            //Configuration initials Enable Components
        this.jlShowStartOfFrame.setEnabled(false);              //Configuration initials Enable Components
        this.jlShowLengthOfFrame.setEnabled(false);             //Configuration initials Enable Components
        this.jlShowMacOfFrame.setEnabled(false);                //Configuration initials Enable Components
        this.jlShowCommandOfFrame.setEnabled(false);            //Configuration initials Enable Components
        this.jlShowCrcOfFrame.setEnabled(false);                //Configuration initials Enable Components
        this.jlShowEndOfFrame.setEnabled(false);                //Configuration initials Enable Components
        this.jlValidatorStartOfFrame.setEnabled(false);         //Configuration initials Enable Components 
        this.jlValidatorLengthOfFrame.setEnabled(false);        //Configuration initials Enable Components    
        this.jlValidatorMacOfFrame.setEnabled(false);           //Configuration initials Enable Components  
        this.jlValidatorCommandOfFrame.setEnabled(false);       //Configuration initials Enable Components
        this.jlValidatorCrcOfFrame.setEnabled(false);           //Configuration initials Enable Components
        this.jlValidatorEndOfFrame.setEnabled(false);           //Configuration initials Enable Components 
        
        this.jmiSeeCoordinator.setEnabled(false);
        this.jmiReboot.setEnabled(false);
        this.jmiGabinet.setEnabled(false);
        this.jmiMeter.setEnabled(false);
        
        this.jmiSeeLog.setEnabled(false); 
        this.jmiSeeStages.setEnabled(false);
        
        this.jlSelectStage.setEnabled(false);
        this.jcbStages.setEnabled(false);
        this.jlFrameSend.setEnabled(false);
        this.jlshowFrameSend.setEnabled(false);
        this.jlFrameRecived.setEnabled(false);
        this.jlshowFrameRecived.setEnabled(false);
        this.jbSendCommand.setEnabled(false);
        
        this.jmiSaveFile.setToolTipText("Save the Log");                    //Set the tooltip 
        this.jmiExit.setToolTipText("Exit application");                    //Set the tooltip 
        this.jmiOpenPort.setToolTipText("Open the selected port");          //Set the tooltip 
        this.jbOpenPort.setToolTipText("Open the selected port");           //Set the tooltip 
        this.jmiClosePort.setToolTipText("Close the selected port");        //Set the tooltip 
        this.jbClosePort.setToolTipText("Close the selected port");         //Set the tooltip 
        this.jmiClearLog.setToolTipText("Clean the log");                   //Set the tooltip 
        this.jmiStopLog.setToolTipText("Stop the log");                     //Set the tooltip 
        this.jmiContinueLog.setToolTipText("Continue the log");             //Set the tooltip 
        this.jcbPorts.setToolTipText("COM Assigned");                       //Set the tooltip
        this.jlShowMac.setToolTipText("Coordinator Mac Address");           //Set the tooltip 
        
        this.jmiRefreshPort.setToolTipText("Refresh Ports");
        this.jmiSeeStages.setToolTipText("View Stages");
        this.jmiSeeLog.setToolTipText("View Log");
        this.jmiSeeCoordinator.setToolTipText("View Coordinator");
        this.jmiReboot.setToolTipText("Reboot Coordinator");
        this.jcbStages.setToolTipText("Select a Stage");
        this.jbSendCommand.setToolTipText("Send Command");
        this.jTextArea.setToolTipText("LOG"); 
        
        this.jpCards.setBorder(titleCards);
        this.jpResults.setBorder(titleResults);
        
        this.jmiReboot.setAccelerator(KeyStroke.getKeyStroke("control N"));
        this.jmiSaveFile.setAccelerator(KeyStroke.getKeyStroke("control S"));
        this.jmiOpenPort.setAccelerator(KeyStroke.getKeyStroke("control O"));
        this.jmiClosePort.setAccelerator(KeyStroke.getKeyStroke("control Y"));
        this.jmiRefreshPort.setAccelerator(KeyStroke.getKeyStroke("control R"));
        this.jmiSeeStages.setAccelerator(KeyStroke.getKeyStroke("control W"));
        this.jmiSeeCoordinator.setAccelerator(KeyStroke.getKeyStroke("control Q"));
        this.jmiSeeLog.setAccelerator(KeyStroke.getKeyStroke("control E"));
        this.jmiClearLog.setAccelerator(KeyStroke.getKeyStroke("control L"));
        this.jmiStopLog.setAccelerator(KeyStroke.getKeyStroke("control P"));
        this.jmiContinueLog.setAccelerator(KeyStroke.getKeyStroke("control A"));       
        
//*******************************************************************************************************************************
//******************General Position*********************************************************************************************
//*******************************************************************************************************************************        
        this.jmBar.setBounds(0, 0, 1200, 20);                   //Position bar
        
        this.jPanelBus.setBounds(20, 30, 1160, 150);            //Position panel bus
        this.jlPorts.setBounds(30, 20, 80, 30);
        this.jcbPorts.setBounds(30, 50, 100, 25);
        this.jbOpenPort.setBounds(160, 50, 120, 25);
        this.jbClosePort.setBounds(160, 90, 120, 25);
        this.jlIndicateMac.setBounds(900, 20, 80, 20);                      
        this.jlShowMac.setBounds(865, 40, 160, 20);
        this.jtabPanel.setBounds(20, 200, 1160, 450);       
        
        this.jlFragmentOfFrame.setBounds(20, 50, 150, 20);                   //Position Components TAB Coordinator
        this.jlFragmentOfFrameHex.setBounds(200, 50, 150, 20);
        this.jlFragmentOfValidate.setBounds(400, 40, 150, 40);
        
        this.jlIndicateStartOfFrame.setBounds(20, 90, 100, 20);             //Position Components TAB Coordinator
        this.jlShowStartOfFrame.setBounds(220, 90, 150, 20);
        this.jlValidatorStartOfFrame.setBounds(440, 90, 40, 40); 
        
        this.jlIndicateLengthOfFrame.setBounds(20, 130, 150, 20);            //Position Components TAB Coordinator
        this.jlShowLengthOfFrame.setBounds(220, 130, 150, 20);
        this.jlValidatorLengthOfFrame.setBounds(440, 130, 40, 40); 
        
        this.jlIndicateMacOfFrame.setBounds(20, 170, 100, 20);              //Position Components TAB Coordinator
        this.jlShowMacOfFrame.setBounds(220, 170, 150, 20);
        this.jlValidatorMacOfFrame.setBounds(440, 170, 40, 40); 
        
        this.jlIndicateCommandOfFrame.setBounds(20, 210, 100, 20);          //Position Components TAB Coordinator
        this.jlShowCommandOfFrame.setBounds(220, 210, 150, 20);
        this.jlValidatorCommandOfFrame.setBounds(440, 210, 40, 40);
        
        this.jlIndicateCrcOfFrame.setBounds(20, 250, 100, 20);              //Position Components TAB Coordinator
        this.jlShowCrcOfFrame.setBounds(220, 250, 150, 20);
        this.jlValidatorCrcOfFrame.setBounds(440, 250, 40, 40);
        
        this.jlIndicateEndOfFrame.setBounds(20, 290, 100, 20);              //Position Components TAB Coordinator
        this.jlShowEndOfFrame.setBounds(220, 290, 150, 20);
        this.jlValidatorEndOfFrame.setBounds(440, 290, 40, 40);         
        
        this.jlSelectStage.setBounds(10, 10, 100, 30);                      //Position Components TAB Stages
        this.jcbStages.setBounds(10, 40, 450, 25);
        this.jpCards.setBounds(10, 75, 450, 340);
        
        this.jpResults.setBounds(470, 10, 675, 407);                        //Position Components TAB Stages
        this.jlTestCase.setBounds(10, 20, 100, 20);
        this.jlAnswer.setBounds(313, 20, 100, 20);
        this.jlPassFail.setBounds(580, 20, 100, 20);
        
        jl0x28.setBounds(10, 60, 250, 20);
        jl0x40.setBounds(10, 95, 250, 20);
        jl0x51.setBounds(10, 130, 250, 20);
        jl0x61.setBounds(10, 165, 250, 20);
        jl0x31.setBounds(10, 200, 250, 20);
        jl0x70.setBounds(10, 235, 250, 20);
        jl0x34.setBounds(10, 270, 250, 20);
        jl0x35.setBounds(10, 305, 250, 20);
        
        /*jl0x25.setBounds(10, 235, 250, 20);
        jl0x2A.setBounds(10, 270, 250, 20);
        jl0x10.setBounds(10, 305, 250, 20);
        jl0xB2.setBounds(10, 340, 250, 20);
        jl0xB1.setBounds(10, 375, 250, 20);*/
    
        jlA0x28.setBounds(320, 60, 100, 20);
        jlA0x40.setBounds(320, 95, 100, 20);
        jlA0x51.setBounds(320, 130, 100, 20);
        jlA0x61.setBounds(320, 165, 100, 20);
        jlA0x31.setBounds(320, 200, 100, 20);
        jlA0x70.setBounds(320, 235, 100, 20);
        jlA0x34.setBounds(320, 270, 100, 20);
        jlA0x35.setBounds(320, 305, 100, 20);
        
        /*jlA0x25.setBounds(320, 235, 100, 20);
        jlA0x2A.setBounds(320, 270, 100, 20);
        jlA0x10.setBounds(320, 305, 100, 20);
        jlA0xB2.setBounds(320, 340, 100, 20);
        jlA0xB1.setBounds(320, 375, 100, 20);*/
    
        jlPF0x28.setBounds(590, 60, 100, 20);
        jlPF0x40.setBounds(590, 95, 100, 20);
        jlPF0x51.setBounds(590, 130, 100, 20);
        jlPF0x61.setBounds(590, 165, 100, 20);
        jlPF0x31.setBounds(590, 200, 100, 20);
        jlPF0x70.setBounds(590, 235, 100, 20);
        jlPF0x34.setBounds(590, 270, 100, 20);
        jlPF0x35.setBounds(590, 305, 100, 20);
        
        /*jlPF0x25.setBounds(590, 235, 100, 20);
        jlPF0x2A.setBounds(590, 270, 100, 20);
        jlPF0x10.setBounds(590, 305, 100, 20);
        jlPF0xB2.setBounds(590, 340, 100, 20);
        jlPF0xB1.setBounds(590, 375, 100, 20);*/
        
        
        this.jpSysnc.setBounds(10, 10, 1125, 330);
        this.jpReadMode.setBounds(10, 10, 1125, 330);                       //Position Components TAB Stages        
        this.jpDoorAlarmP.setBounds(10, 10, 1125, 330);
        this.jpDoorAlarmS.setBounds(10, 10, 1125, 330);
        this.jpSingleMeasure.setBounds(10, 10, 1125, 330);
        this.jpTurnRelay.setBounds(10, 10, 1125, 330);
        
        this.jlSysnc.setBounds(10, 10, 350, 25);
        this.jlReadMode.setBounds(10, 10, 350, 25);        
        this.jlRefreshTable.setBounds(10, 10, 350, 25);
        this.jlReadCordinatorDate.setBounds(10, 10, 350, 25);                   //Position Components TAB Stages
        this.jlReadChannel.setBounds(10, 10, 350, 25);
        this.jlReadPanId.setBounds(10, 10, 350, 25);
        this.jlEraseMeterTable.setBounds(10, 10, 350, 25);
        this.jlEraseDevicesTable.setBounds(10, 10, 350, 25);        
        this.jlDoorAlarmP.setBounds(10, 10, 350, 25);
        this.jlDoorAlarmS.setBounds(10, 10, 350, 25);
        this.jlSingleMeasure.setBounds(10, 10, 350, 25);
        this.jlTurnRelay.setBounds(10, 10, 350, 25);
        
        this.jlFrameSend.setBounds(10, 50, 100, 25);
        this.jlshowFrameSend.setBounds(120, 50, 400, 25);                   //Position Components TAB Stages
        this.jlFrameRecived.setBounds(10, 80, 100, 25);
        this.jlshowFrameRecived.setBounds(120, 80, 400, 25);
        
        this.jbSendCommand.setBounds(10, 120, 150, 30);
        
         this.jScrollPane.setBounds(10, 10, 1140, 400);                      //Position for JTextArea
        
//*******************************************************************************************************************************
//*********************add panel TAB Coordinator*********************************************************************************
//*******************************************************************************************************************************        
        this.add(this.jtabPanel);
        this.jtabPanel.add("Coordinator", this.jpCoordinator);
        this.jpCoordinator.add(this.jlFragmentOfFrame);
        this.jpCoordinator.add(this.jlFragmentOfFrameHex);
        this.jpCoordinator.add(this.jlFragmentOfValidate);
        this.jpCoordinator.add(this.jlIndicateStartOfFrame);
        this.jpCoordinator.add(this.jlShowStartOfFrame);
        this.jpCoordinator.add(this.jlValidatorStartOfFrame);        
        this.jpCoordinator.add(this.jlIndicateLengthOfFrame);
        this.jpCoordinator.add(this.jlShowLengthOfFrame);
        this.jpCoordinator.add(this.jlValidatorLengthOfFrame);        
        this.jpCoordinator.add(this.jlIndicateMacOfFrame);
        this.jpCoordinator.add(this.jlShowMacOfFrame);
        this.jpCoordinator.add(this.jlValidatorMacOfFrame);        
        this.jpCoordinator.add(this.jlIndicateCommandOfFrame);
        this.jpCoordinator.add(this.jlShowCommandOfFrame);
        this.jpCoordinator.add(this.jlValidatorCommandOfFrame);        
        this.jpCoordinator.add(this.jlIndicateCrcOfFrame);
        this.jpCoordinator.add(this.jlShowCrcOfFrame);
        this.jpCoordinator.add(this.jlValidatorCrcOfFrame);        
        this.jpCoordinator.add(this.jlIndicateEndOfFrame);
        this.jpCoordinator.add(this.jlShowEndOfFrame);
        this.jpCoordinator.add(this.jlValidatorEndOfFrame);       
        
//*******************************************************************************************************************************
//*********************add panel TAB Stages**************************************************************************************
//*******************************************************************************************************************************         
        this.jtabPanel.add("Stages", this.jpStages);
        this.jpStages.add(this.jlSelectStage);
        this.jpStages.add(this.jcbStages);
        this.jpStages.add(this.jpCards);
        this.jpStages.add(this.jpResults);
        
        this.jpResults.add(this.jlTestCase);
        this.jpResults.add(this.jlAnswer);
        this.jpResults.add(this.jlPassFail);
        
        this.jpResults.add(this.jl0x28);
        this.jpResults.add(this.jl0x40);
        this.jpResults.add(this.jl0x51);
        this.jpResults.add(this.jl0x61);
        this.jpResults.add(this.jl0x31);
        this.jpResults.add(this.jl0x70);
        this.jpResults.add(this.jl0x34);
        this.jpResults.add(this.jl0x35);
        
        /*this.jpResults.add(this.jl0x25);
        this.jpResults.add(this.jl0x2A);
        this.jpResults.add(this.jl0x10);
        this.jpResults.add(this.jl0xB2);
        this.jpResults.add(this.jl0xB1);*/
        
        this.jpResults.add(this.jlA0x28);
        this.jpResults.add(this.jlA0x40);
        this.jpResults.add(this.jlA0x51);
        this.jpResults.add(this.jlA0x61);
        this.jpResults.add(this.jlA0x31);
        this.jpResults.add(this.jlA0x70);
        this.jpResults.add(this.jlA0x34);
        this.jpResults.add(this.jlA0x35);
        
        /*this.jpResults.add(this.jlA0x25);
        this.jpResults.add(this.jlA0x2A);
        this.jpResults.add(this.jlA0x10);
        this.jpResults.add(this.jlA0xB2);
        this.jpResults.add(this.jlA0xB1);*/
        
        this.jpResults.add(this.jlPF0x28);
        this.jpResults.add(this.jlPF0x40);
        this.jpResults.add(this.jlPF0x51);
        this.jpResults.add(this.jlPF0x61);
        this.jpResults.add(this.jlPF0x31);
        this.jpResults.add(this.jlPF0x70);
        this.jpResults.add(this.jlPF0x34);
        this.jpResults.add(this.jlPF0x35);
        
        /*this.jpResults.add(this.jlPF0x25);
        this.jpResults.add(this.jlPF0x2A);
        this.jpResults.add(this.jlPF0x10);
        this.jpResults.add(this.jlPF0xB2);
        this.jpResults.add(this.jlPF0xB1);*/      
        
        this.jpCards.add(this.jpSysnc,"SYSNC");
        this.jpCards.add(this.jpReadMode,"READ MODE");        
        this.jpCards.add(this.jpRefreshDevTable, "REFRESH");
        this.jpCards.add(this.jpReadCoordinatorDate, "READ COORD");
        this.jpCards.add(this.jpReadChannel, "READ CHANNEL");
        this.jpCards.add(this.jpReadPanId, "READ PAN ID");
        this.jpCards.add(this.jpEraseMeterTable, "ERASE METER TABLE");
        this.jpCards.add(this.jpEraseDevicesTable, "ERASE DEVICES TABLE");        
        this.jpCards.add(this.jpDoorAlarmP,"DOOR ALARM P");
        this.jpCards.add(this.jpDoorAlarmS,"DOOR ALARM S");
        this.jpCards.add(this.jpSingleMeasure,"SINGLE MEASURE");
        this.jpCards.add(this.jpTurnRelay,"TURN RELAY");
        
        this.jpSysnc.add(this.jlSysnc);
        this.jpReadMode.add(this.jlReadMode);       
        this.jpRefreshDevTable.add(this.jlRefreshTable);
        this.jpReadCoordinatorDate.add(this.jlReadCordinatorDate);
        this.jpReadChannel.add(this.jlReadChannel);
        this.jpReadPanId.add(this.jlReadPanId);
        this.jpEraseMeterTable.add(this.jlEraseMeterTable);
        this.jpEraseDevicesTable.add(this.jlEraseDevicesTable);      
        this.jpDoorAlarmP.add(this.jlDoorAlarmP);
        this.jpDoorAlarmS.add(this.jlDoorAlarmS);
        this.jpSingleMeasure.add(this.jlSingleMeasure);
        this.jpTurnRelay.add(this.jlTurnRelay);
        
        this.jpSysnc.add(this.jlFrameSend);
        this.jpSysnc.add(this.jlshowFrameSend);
        this.jpSysnc.add(this.jlFrameRecived);
        this.jpSysnc.add(this.jlshowFrameRecived);
        this.jpSysnc.add(this.jbSendCommand);
        this.jlshowFrameSend.setText("------");
        this.jlshowFrameRecived.setText("------");
        
//*******************************************************************************************************************************
//*********************add panel TAB Log*****************************************************************************************
//*******************************************************************************************************************************        
        this.jtabPanel.add("Log",this.jpLog);
        this.jpLog.add(this.jScrollPane);  
        this.jpLog.add(this.jScrollPane); 
        
//*******************************************************************************************************************************
//*********************add panel bus*********************************************************************************************
//*******************************************************************************************************************************
        this.add(this.jPanelBus);
        this.jPanelBus.add(this.jlPorts);
        this.jPanelBus.add(this.jcbPorts);
        this.jPanelBus.add(this.jbOpenPort);
        this.jPanelBus.add(this.jbClosePort);
        this.jPanelBus.add(this.jlIndicateMac);
        this.jPanelBus.add(this.jlShowMac);      
        
//*******************************************************************************************************************************
//*********************add Bar***************************************************************************************************
//*******************************************************************************************************************************
        this.add(this.jmBar);        
        this.jmBar.add(this.jmFile);
        this.jmBar.add(this.jmBus);
        this.jmBar.add(this.jmStages);
        this.jmBar.add(this.jmDevices);
        this.jmBar.add(this.jmLog); 
        this.jmBar.add(this.jmHelp);
        this.jmFile.add(this.jmiSaveFile);        
        this.jmFile.add(this.jmiExit);              
        this.jmBus.add(this.jmiOpenPort);
        this.jmBus.add(this.jmiClosePort);
        this.jmBus.add(this.jmiRefreshPort);
        this.jmStages.add(this.jmiSeeStages);
        this.jmDevices.add(this.jmCoordinator);
        this.jmDevices.add(this.jmiGabinet);
        this.jmDevices.add(this.jmiMeter);
        this.jmCoordinator.add(this.jmiSeeCoordinator);
        this.jmCoordinator.add(this.jmiReboot);       
        this.jmLog.add(this.jmiSeeLog);
        this.jmLog.add(this.jmiClearLog);
        this.jmLog.add(this.jmiStopLog);    
        this.jmLog.add(this.jmiContinueLog);
        this.jmHelp.add(this.jmiAbout);
        
        
//*******************************************************************************************************************************
//*********************************Action Listeners******************************************************************************
//*******************************************************************************************************************************      
        
        this.jmiExit.addActionListener(new ActionListener()             //Action Listener for JMenuItem exit, this action listener is for exit software
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiExtiPerformed(evt);
            }
        });       
        
        this.jbOpenPort.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jbOpenPortPerformed(evt);
            }
        });
        
        this.jmiOpenPort.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiOpenPortPerformed(evt);
            }
        });
        
        this.jmiClearLog.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiClearLogPerformed(evt);
            }
        });
        
        this.jmiStopLog.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                jmiStopLogPerformed(evt);
            }
        });
        
        this.jmiAbout.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiAboutPerformed(evt);
            }
        });
        
        this.jmiContinueLog.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiContinueLogPerformed(evt);
            }
        });
        
        jmiRefreshPort.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiRefreshPortsPerformed(evt);
            }
        });
        
        this.jmiSaveFile.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiSaveFilePerformed(evt);
            }
        });
        
        this.jmiSeeLog.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiSeeLogPerformed(evt);
            }
        });
        
        this.jmiSeeStages.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiSeeStagesPerformed(evt);
            }
        });
        
        this.jmiSeeCoordinator.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiSeeCoordinatorPerformed(evt);
            }
        });
        
        this.jmiReboot.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiRebootPerformed(evt);
            }
        });
        
        this.jcbStages.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jcbStagesPerformed(evt);
            }
        });
        
        this.jbSendCommand.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jbSendCommandPerformed(e);
            }
        });
        
        setSize(1200, 700);                         //parameters for configuration JFrame
        setResizable(false);                        //parameters for configuration JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //parameters for configuration JFrame
        setTitle("Test_Room");                      //parameters for configuration JFrame       
    }
    
    private void jmiAboutPerformed(ActionEvent evt)
    {
        JOptionPane.showMessageDialog(null, "SUITE FOR TEST\nENERI\nwww.eneri.com.mx\nVersion 1.0.0\n14-12-2016");
    }
    
    private void jbOpenPortPerformed(ActionEvent evt)
    {
        this.hPorts.openPorts();
        this.thread.sleept(2000);
        this.jbOpenPort.setEnabled(false);
        this.jmiOpenPort.setEnabled(false);
        this.jcbPorts.setEnabled(false);        
        this.jbClosePort.setEnabled(true);
        this.jmiClosePort.setEnabled(true);
        this.jlIndicateMac.setEnabled(true);
        this.jlShowMac.setEnabled(true);
        this.jmiSaveFile.setEnabled(true);
        this.jmiClearLog.setEnabled(true);
        this.jmiStopLog.setEnabled(true);
        this.jlIndicateStartOfFrame.setEnabled(true);
        this.jlIndicateLengthOfFrame.setEnabled(true);
        this.jlIndicateMacOfFrame.setEnabled(true);
        this.jlIndicateCommandOfFrame.setEnabled(true);
        this.jlIndicateCrcOfFrame.setEnabled(true);
        this.jlIndicateEndOfFrame.setEnabled(true);
        this.jlShowStartOfFrame.setEnabled(true);
        this.jlShowLengthOfFrame.setEnabled(true);
        this.jlShowMacOfFrame.setEnabled(true);
        this.jlShowCommandOfFrame.setEnabled(true);
        this.jlShowCrcOfFrame.setEnabled(true);
        this.jlShowEndOfFrame.setEnabled(true);
        this.jlValidatorStartOfFrame.setEnabled(true);
        this.jlValidatorLengthOfFrame.setEnabled(true);
        this.jlValidatorMacOfFrame.setEnabled(true);
        this.jlValidatorCommandOfFrame.setEnabled(true);
        this.jlValidatorCrcOfFrame.setEnabled(true);
        this.jlValidatorEndOfFrame.setEnabled(true);  
        this.jmiSeeCoordinator.setEnabled(true);
        this.jmiReboot.setEnabled(true);
        this.jmiSeeStages.setEnabled(true);
        this.jmiSeeLog.setEnabled(true);        
        this.jlSelectStage.setEnabled(true);
        this.jcbStages.setEnabled(true);
        this.jlFrameSend.setEnabled(true);
        this.jlshowFrameSend.setEnabled(true);
        this.jlFrameRecived.setEnabled(true);
        this.jlshowFrameRecived.setEnabled(true);
        this.jbSendCommand.setEnabled(true);
        
        String lecturaPuerto = hPorts.readPort();
        
        if(lecturaPuerto != null)
        {
            this.rFrames = new ReceivedFrame(lecturaPuerto);
            this.jlShowMac.setText(this.rFrames.getMacAddresOfFrame());
            this.jlShowStartOfFrame.setText(this.rFrames.getStartOfFrame());
            this.jlShowLengthOfFrame.setText(this.rFrames.getLengthOfFrame());
            this.jlShowMacOfFrame.setText(this.rFrames.getMacAddresOfFrame());
            this.jlShowCommandOfFrame.setText(this.rFrames.getIdCommandOfFrame());
            this.jlShowCrcOfFrame.setText(this.rFrames.getCrcOfFrame());
            this.jlShowEndOfFrame.setText(this.rFrames.getEndOfFrame());            
            if(rFrames.getStartOfFrameCorrect())
            {
                this.jlValidatorStartOfFrame.setIcon(this.iconGood);
            }  
            else
            {
                this.jlValidatorStartOfFrame.setIcon(this.iconFail);
            }
            if(rFrames.getIdCommandOfFrameCorrec())
            {
                this.jlValidatorCommandOfFrame.setIcon(this.iconGood);
            }
            else
            {
                this.jlValidatorCommandOfFrame.setIcon(this.iconFail);
            }
            if(rFrames.getEndOfFrameCorrec())
            {
                this.jlValidatorEndOfFrame.setIcon(this.iconGood);
            } 
            else
            {
                this.jlValidatorEndOfFrame.setIcon(this.iconFail);
            }            
            this.jlValidatorLengthOfFrame.setIcon(this.iconGood);
            this.jlValidatorMacOfFrame.setIcon(this.iconGood);
            this.jlValidatorCommandOfFrame.setIcon(this.iconGood);
            this.jlValidatorCrcOfFrame.setIcon(this.iconGood);           
            this.thread.start();                  
        }
        else
        {
            int request = JOptionPane.showConfirmDialog(null, "Do you want to send the reboot command?");
            
            switch(request)
            {
                case 0:
                    String macCoordinador = JOptionPane.showInputDialog("Enter the Mac Address del Coordinador");
                    hPorts.SendFrame(sendFrames.getIntframe0x22(macCoordinador, IdCommand.SIZE_09_00, IdCommand.REBOOT));
                    this.rFrames = new ReceivedFrame(this.hPorts.readPort());
                    this.jlShowMac.setText(this.rFrames.getMacAddresOfFrame());
                    this.jlShowStartOfFrame.setText(this.rFrames.getStartOfFrame());
                    this.jlShowLengthOfFrame.setText(this.rFrames.getLengthOfFrame());
                    this.jlShowMacOfFrame.setText(this.rFrames.getMacAddresOfFrame());
                    this.jlShowCommandOfFrame.setText(this.rFrames.getIdCommandOfFrame());
                    this.jlShowCrcOfFrame.setText(this.rFrames.getCrcOfFrame());
                    this.jlShowEndOfFrame.setText(this.rFrames.getEndOfFrame());       
                    this.jlValidatorStartOfFrame.setIcon(this.iconGood);
                    this.jlValidatorLengthOfFrame.setIcon(this.iconGood);
                    this.jlValidatorMacOfFrame.setIcon(this.iconGood);
                    this.jlValidatorCommandOfFrame.setIcon(this.iconGood);
                    this.jlValidatorCrcOfFrame.setIcon(this.iconGood);
                    this.jlValidatorEndOfFrame.setIcon(this.iconGood);
                    this.thread.start(); 
                    break;
                case 1:
                    break;
                case 2:
                    break;                
            }    
        }       
    }
    
    private void jmiOpenPortPerformed(ActionEvent evt)
    {
        this.hPorts.openPorts();
        this.thread.sleept(2000);
        this.jbOpenPort.setEnabled(false);
        this.jmiOpenPort.setEnabled(false);
        this.jcbPorts.setEnabled(false);        
        this.jbClosePort.setEnabled(true);
        this.jmiClosePort.setEnabled(true);
        this.jlIndicateMac.setEnabled(true);
        this.jlShowMac.setEnabled(true);
        this.jmiSaveFile.setEnabled(true);
        this.jmiClearLog.setEnabled(true);
        this.jmiStopLog.setEnabled(true);
        this.jlIndicateStartOfFrame.setEnabled(true);
        this.jlIndicateLengthOfFrame.setEnabled(true);
        this.jlIndicateMacOfFrame.setEnabled(true);
        this.jlIndicateCommandOfFrame.setEnabled(true);
        this.jlIndicateCrcOfFrame.setEnabled(true);
        this.jlIndicateEndOfFrame.setEnabled(true);
        this.jlShowStartOfFrame.setEnabled(true);
        this.jlShowLengthOfFrame.setEnabled(true);
        this.jlShowMacOfFrame.setEnabled(true);
        this.jlShowCommandOfFrame.setEnabled(true);
        this.jlShowCrcOfFrame.setEnabled(true);
        this.jlShowEndOfFrame.setEnabled(true);
        this.jlValidatorStartOfFrame.setEnabled(true);
        this.jlValidatorLengthOfFrame.setEnabled(true);
        this.jlValidatorMacOfFrame.setEnabled(true);
        this.jlValidatorCommandOfFrame.setEnabled(true);
        this.jlValidatorCrcOfFrame.setEnabled(true);
        this.jlValidatorEndOfFrame.setEnabled(true); 
        this.jmiSeeCoordinator.setEnabled(true);
        this.jmiReboot.setEnabled(true);
        this.jmiSeeStages.setEnabled(true);
        this.jmiSeeLog.setEnabled(true);        
        this.jlSelectStage.setEnabled(true);
        this.jcbStages.setEnabled(true);
        this.jlFrameSend.setEnabled(true);
        this.jlshowFrameSend.setEnabled(true);
        this.jlFrameRecived.setEnabled(true);
        this.jlshowFrameRecived.setEnabled(true);
        this.jbSendCommand.setEnabled(true);
        
        String lecturaPuerto = hPorts.readPort();
        
        if(lecturaPuerto != null)
        {
            this.rFrames = new ReceivedFrame(lecturaPuerto);
            this.jlShowMac.setText(this.rFrames.getMacAddresOfFrame());
            this.jlShowStartOfFrame.setText(this.rFrames.getStartOfFrame());
            this.jlShowLengthOfFrame.setText(this.rFrames.getLengthOfFrame());
            this.jlShowMacOfFrame.setText(this.rFrames.getMacAddresOfFrame());
            this.jlShowCommandOfFrame.setText(this.rFrames.getIdCommandOfFrame());
            this.jlShowCrcOfFrame.setText(this.rFrames.getCrcOfFrame());
            this.jlShowEndOfFrame.setText(this.rFrames.getEndOfFrame());            
            if(rFrames.getStartOfFrameCorrect())
            {
                this.jlValidatorStartOfFrame.setIcon(this.iconGood);
            }  
            else
            {
                this.jlValidatorStartOfFrame.setIcon(this.iconFail);
            }
            if(rFrames.getIdCommandOfFrameCorrec())
            {
                this.jlValidatorCommandOfFrame.setIcon(this.iconGood);
            }
            else
            {
                this.jlValidatorCommandOfFrame.setIcon(this.iconFail);
            }
            if(rFrames.getEndOfFrameCorrec())
            {
                this.jlValidatorEndOfFrame.setIcon(this.iconGood);
            } 
            else
            {
                this.jlValidatorEndOfFrame.setIcon(this.iconFail);
            }            
            this.jlValidatorLengthOfFrame.setIcon(this.iconGood);
            this.jlValidatorMacOfFrame.setIcon(this.iconGood);
            this.jlValidatorCommandOfFrame.setIcon(this.iconGood);
            this.jlValidatorCrcOfFrame.setIcon(this.iconGood);           
            this.thread.start();                 
        }
        else
        {
            int request = JOptionPane.showConfirmDialog(null, "Do you want to send the reboot command?");
            
            switch(request)
            {
                case 0:
                    String macCoordinador = JOptionPane.showInputDialog("Enter the Mac Address del coordinador");
                    hPorts.SendFrame(sendFrames.getIntframe0x22(macCoordinador, IdCommand.SIZE_09_00, IdCommand.REBOOT));
                    this.rFrames = new ReceivedFrame(this.hPorts.readPort());
                    this.jlShowMac.setText(this.rFrames.getMacAddresOfFrame());
                    this.jlShowStartOfFrame.setText(this.rFrames.getStartOfFrame());
                    this.jlShowLengthOfFrame.setText(this.rFrames.getLengthOfFrame());
                    this.jlShowMacOfFrame.setText(this.rFrames.getMacAddresOfFrame());
                    this.jlShowCommandOfFrame.setText(this.rFrames.getIdCommandOfFrame());
                    this.jlShowCrcOfFrame.setText(this.rFrames.getCrcOfFrame());
                    this.jlShowEndOfFrame.setText(this.rFrames.getEndOfFrame());       
                    this.jlValidatorStartOfFrame.setIcon(this.iconGood);
                    this.jlValidatorLengthOfFrame.setIcon(this.iconGood);
                    this.jlValidatorMacOfFrame.setIcon(this.iconGood);
                    this.jlValidatorCommandOfFrame.setIcon(this.iconGood);
                    this.jlValidatorCrcOfFrame.setIcon(this.iconGood);
                    this.jlValidatorEndOfFrame.setIcon(this.iconGood);
                    this.thread.start(); 
                    break;
                case 1:
                    break;
                case 2:
                    break;                
            }    
        }
    }
    
    private void jmiExtiPerformed(ActionEvent evt)
    {
        dispose();
        System.exit(0);
    }
    
    private void jmiClearLogPerformed(ActionEvent evt)
    {
        requestDialog = JOptionPane.showConfirmDialog(null, "The contents of the log will be lost\nAre you sure to continue?");
        switch(requestDialog)
        {
            case 0:
                this.jTextArea.setText("");
                break;
            case 1:
                break;
            case 2:
                break;
        }        
    }
    
    public void jmiStopLogPerformed(ActionEvent evt)
    {
        thread.suspend();
        JOptionPane.showMessageDialog(null, "Stopped Log!!!");
        this.jmiContinueLog.setEnabled(true);
        this.jmiStopLog.setEnabled(false);
    }
    
    public void jmiContinueLogPerformed(ActionEvent evt)
    {
        thread.resume();
        JOptionPane.showMessageDialog(null, "Rebooting Log!!!");
        this.jmiContinueLog.setEnabled(false);
        this.jmiStopLog.setEnabled(true);
    }
    
    public void jmiSeeCoordinatorPerformed(ActionEvent evt)
    {
        this.jtabPanel.setSelectedIndex(0);
    }
    
    public void jmiSeeStagesPerformed(ActionEvent evt)
    {
        this.jtabPanel.setSelectedIndex(1);
    }
    
    public void jmiSeeLogPerformed(ActionEvent evt)
    {
        this.jtabPanel.setSelectedIndex(2);
    }   
    
    public void jmiSaveFilePerformed(ActionEvent evt)
    {
        if(thread.isAlive() == true)
        {
            thread.suspend();
            hFiles.xportFile();  
            thread.resume();
        }
        else
        {
            hFiles.xportFile(); 
            thread.resume();
        }
    }
    
    public void jbSendCommandPerformed(ActionEvent evt)
    {        
        if(jcbStages.getSelectedIndex() == 0)
        {
            jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x28(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_0E_00, IdCommand.SYSNC_REQUEST_PROCESS_0X28));
            hPorts.SendFrame(sendFrames.getIntframe0x28(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_0E_00, IdCommand.SYSNC_REQUEST_PROCESS_0X28));
            thread.sleept(2000);
            LastLine lastLine = new LastLine();            
            dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
            if(dFrame.getStrAnswer0x28().equals("50 01"))
            {
                jlA0x28.setText(dFrame.getStrAnswer0x28());
                if(dFrame.getBlAnswer0x28())
                {
                    jlPF0x28.setText("PASS");
                }
                else
                {
                    jlPF0x28.setText("FAIL");
                }               
            }
            else
            {
                jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x28(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_0E_00, IdCommand.SYSNC_REQUEST_PROCESS_0X28));
                hPorts.SendFrame(sendFrames.getIntframe0x28(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_0E_00, IdCommand.SYSNC_REQUEST_PROCESS_0X28));
                thread.sleept(2000);           
                dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
                jlA0x28.setText(dFrame.getStrAnswer0x28());
                if(dFrame.getBlAnswer0x28())
                {
                    jlPF0x28.setText("PASS");
                }
                else
                {
                    jlPF0x28.setText("FAIL");
                }              
            }
        }
        if(jcbStages.getSelectedIndex() == 1)
        {
            jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x40(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_MODE_VERSION_COORDINATOR_PROCESS_0x40));
            hPorts.SendFrame(sendFrames.getIntframe0x40(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_MODE_VERSION_COORDINATOR_PROCESS_0x40));            
            thread.sleept(2000);
            LastLine lastLine = new LastLine();            
            dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
            if(dFrame.getStrAnswer0x40().equals("40 01"))
            {
                jlA0x40.setText(dFrame.getStrAnswer0x40());
                if(dFrame.getBlAnswer0x40())
                {
                    jlPF0x40.setText("PASS");
                }
                else
                {
                    jlPF0x40.setText("FAIL");
                }               
            }
            else
            {
                jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x40(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_MODE_VERSION_COORDINATOR_PROCESS_0x40));
                hPorts.SendFrame(sendFrames.getIntframe0x40(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_MODE_VERSION_COORDINATOR_PROCESS_0x40));
                thread.sleept(2000);           
                dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
                jlA0x40.setText(dFrame.getStrAnswer0x40());
                if(dFrame.getBlAnswer0x40())
                {
                    jlPF0x40.setText("PASS");
                }
                else
                {
                    jlPF0x40.setText("FAIL");
                }              
            }
        }  
        if(jcbStages.getSelectedIndex() == 2)
        {
            jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x31(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.REFRESH_DEVICES_TABLE_0x31));
            hPorts.SendFrame(sendFrames.getIntframe0x31(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.REFRESH_DEVICES_TABLE_0x31));
            thread.sleept(2000);
            LastLine lastLine = new LastLine();            
            dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
            if(dFrame.getStrAnswer0x31().equals("31 01"))
            {
                jlA0x31.setText(dFrame.getStrAnswer0x31());
                if(dFrame.getBlAnswer0x31())
                {
                    jlPF0x31.setText("PASS");
                }
                else
                {
                    jlPF0x31.setText("FAIL");
                }               
            }
            else
            {
                jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x31(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.REFRESH_DEVICES_TABLE_0x31));
                hPorts.SendFrame(sendFrames.getIntframe0x31(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.REFRESH_DEVICES_TABLE_0x31));
                thread.sleept(2000);           
                dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
                jlA0x31.setText(dFrame.getStrAnswer0x31());
                if(dFrame.getBlAnswer0x31())
                {
                    jlPF0x31.setText("PASS");
                }
                else
                {
                    jlPF0x31.setText("FAIL");
                }              
            }
        }
        if(jcbStages.getSelectedIndex() == 3)
        {
            jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x51(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_COORDINATOR_DATE_0x51));
            hPorts.SendFrame(sendFrames.getIntframe0x51(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_COORDINATOR_DATE_0x51));
            thread.sleept(2000);
            LastLine lastLine = new LastLine();            
            dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
            if(dFrame.getStrAnswer0x51().equals("51 01"))
            {
                jlA0x51.setText(dFrame.getStrAnswer0x51());
                if(dFrame.getBlAnswer0x51())
                {
                    jlPF0x51.setText("PASS");
                }
                else
                {
                    jlPF0x51.setText("FAIL");
                }               
            }
            else
            {
                jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x51(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_COORDINATOR_DATE_0x51));
                hPorts.SendFrame(sendFrames.getIntframe0x51(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_COORDINATOR_DATE_0x51));
                thread.sleept(2000);           
                dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
                jlA0x51.setText(dFrame.getStrAnswer0x51());
                if(dFrame.getBlAnswer0x51())
                {
                    jlPF0x51.setText("PASS");
                }
                else
                {
                    jlPF0x51.setText("FAIL");
                }              
            }
        }
        if(jcbStages.getSelectedIndex() == 4)
        {
            jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x70(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_CHANNEL_0x70));
            hPorts.SendFrame(sendFrames.getIntframe0x70(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_CHANNEL_0x70));
            thread.sleept(2000);
            LastLine lastLine = new LastLine();            
            dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
            if(dFrame.getStrAnswer0x70().equals("70 01"))
            {
                jlA0x70.setText(dFrame.getStrAnswer0x70());
                if(dFrame.getBlAnswer0x70())
                {
                    jlPF0x70.setText("PASS");
                }
                else
                {
                    jlPF0x70.setText("FAIL");
                }               
            }
            else
            {
                jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x70(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_CHANNEL_0x70));
                hPorts.SendFrame(sendFrames.getIntframe0x70(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_CHANNEL_0x70));
                thread.sleept(2000);           
                dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
                jlA0x70.setText(dFrame.getStrAnswer0x70());
                if(dFrame.getBlAnswer0x70())
                {
                    jlPF0x70.setText("PASS");
                }
                else
                {
                    jlPF0x70.setText("FAIL");
                }              
            }
        }
        if(jcbStages.getSelectedIndex() == 5)
        {
            jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x61(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_PAN_ID_0x61));
            hPorts.SendFrame(sendFrames.getIntframe0x61(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_PAN_ID_0x61));
            thread.sleept(2000);
            LastLine lastLine = new LastLine();            
            dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
            if(dFrame.getStrAnswer0x61().equals("61 01"))
            {
                jlA0x61.setText(dFrame.getStrAnswer0x61());
                if(dFrame.getBlAnswer0x61())
                {
                    jlPF0x61.setText("PASS");
                }
                else
                {
                    jlPF0x61.setText("FAIL");
                }               
            }
            else
            {
                jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x61(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_PAN_ID_0x61));
                hPorts.SendFrame(sendFrames.getIntframe0x61(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_PAN_ID_0x61));
                thread.sleept(2000);           
                dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
                jlA0x61.setText(dFrame.getStrAnswer0x61());
                if(dFrame.getBlAnswer0x61())
                {
                    jlPF0x61.setText("PASS");
                }
                else
                {
                    jlPF0x61.setText("FAIL");
                }              
            }
        }
        if(jcbStages.getSelectedIndex() == 6)
        {
            jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x34(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.ERASE_METER_TABLE_0x34));
            hPorts.SendFrame(sendFrames.getIntframe0x34(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.ERASE_METER_TABLE_0x34));
            thread.sleept(2000);
            LastLine lastLine = new LastLine();            
            dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
            if(dFrame.getStrAnswer0x34().equals("34 01"))
            {
                jlA0x34.setText(dFrame.getStrAnswer0x34());
                if(dFrame.getBlAnswer0x34())
                {
                    jlPF0x34.setText("PASS");
                }
                else
                {
                    jlPF0x34.setText("FAIL");
                }               
            }
            else
            {
                jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x34(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.ERASE_METER_TABLE_0x34));
                hPorts.SendFrame(sendFrames.getIntframe0x34(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.ERASE_METER_TABLE_0x34));
                thread.sleept(2000);           
                dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
                jlA0x34.setText(dFrame.getStrAnswer0x34());
                if(dFrame.getBlAnswer0x34())
                {
                    jlPF0x34.setText("PASS");
                }
                else
                {
                    jlPF0x34.setText("FAIL");
                }              
            }
        }
        if(jcbStages.getSelectedIndex() == 7)
        {
            jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x35(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.ERASE_DEVICES_TABLE_0x35));
            hPorts.SendFrame(sendFrames.getIntframe0x35(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.ERASE_DEVICES_TABLE_0x35));
            thread.sleept(2000);
            LastLine lastLine = new LastLine();            
            dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
            if(dFrame.getStrAnswer0x35().equals("35 01"))
            {
                jlA0x35.setText(dFrame.getStrAnswer0x35());
                if(dFrame.getBlAnswer0x35())
                {
                    jlPF0x35.setText("PASS");
                }
                else
                {
                    jlPF0x35.setText("FAIL");
                }               
            }
            else
            {
                jTextArea.append("\nEnviado: "+timeStamp.getTimeStamp()+" ---> "+sendFrames.getStrframe0x35(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.ERASE_DEVICES_TABLE_0x35));
                hPorts.SendFrame(sendFrames.getIntframe0x35(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.ERASE_DEVICES_TABLE_0x35));
                thread.sleept(2000);           
                dFrame = new DefragFrame(lastLine.getLastLine(jTextArea));
                jlA0x35.setText(dFrame.getStrAnswer0x35());
                if(dFrame.getBlAnswer0x35())
                {
                    jlPF0x35.setText("PASS");
                }
                else
                {
                    jlPF0x35.setText("FAIL");
                }              
            }
        }
    }
    
    public void jmiRebootPerformed(ActionEvent evt)
    {
        hPorts.SendFrame(sendFrames.getIntframe0x22(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.REBOOT));        
    }
    
    public void jmiRefreshPortsPerformed(ActionEvent evt)
    {
        this.dcbPorts = ((DefaultComboBoxModel)jcbPorts.getModel());
        this.dcbPorts.removeAllElements();
        for(int i=0; i<splistPorts.getPortNames().length;i++)
        {
            dcbPorts.addElement(splistPorts.getPortNames()[i]);
        }
        this.jcbPorts.updateUI();
        this.jcbPorts.revalidate();
        this.jcbPorts.repaint();
    }
    
    public void jcbStagesPerformed(ActionEvent evt)
    {
        if(evt.getSource() == jcbStages)
        {
            if(jcbStages.getSelectedIndex() == 0)
            {
                this.cardLayout.show(jpCards,"SYSNC");
                this.jpSysnc.add(this.jlFrameSend);
                this.jpSysnc.add(this.jlshowFrameSend);
                this.jpSysnc.add(this.jlFrameRecived);
                this.jpSysnc.add(this.jlshowFrameRecived);
                this.jpSysnc.add(this.jbSendCommand);
                this.jlshowFrameSend.setText(sendFrames.getStrframe0x28(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_0E_00, IdCommand.SYSNC_REQUEST_PROCESS_0X28));                
            }
            if(jcbStages.getSelectedIndex() == 1)
            {
                this.cardLayout.show(jpCards,"READ MODE");
                this.jpReadMode.add(this.jlFrameSend);
                this.jpReadMode.add(this.jlshowFrameSend);
                this.jpReadMode.add(this.jlFrameRecived);
                this.jpReadMode.add(this.jlshowFrameRecived);
                this.jpReadMode.add(this.jbSendCommand);  
                this.jlshowFrameSend.setText(sendFrames.getStrframe0x40(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_MODE_VERSION_COORDINATOR_PROCESS_0x40));
                this.jlshowFrameRecived.setText("------");
            }
            if(jcbStages.getSelectedIndex() == 2)
            {
                this.cardLayout.show(jpCards,"REFRESH");
                this.jpRefreshDevTable.add(this.jlFrameSend);
                this.jpRefreshDevTable.add(this.jlshowFrameSend);
                this.jpRefreshDevTable.add(this.jlFrameRecived);
                this.jpRefreshDevTable.add(this.jlshowFrameRecived);
                this.jpRefreshDevTable.add(this.jbSendCommand);
                this.jlshowFrameSend.setText(sendFrames.getStrframe0x31(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.REFRESH_DEVICES_TABLE_0x31));
                this.jlshowFrameRecived.setText("------");
            }
            if(jcbStages.getSelectedIndex() == 3)
            {
                this.cardLayout.show(jpCards,"READ COORD");
                this.jpReadCoordinatorDate.add(this.jlFrameSend);
                this.jpReadCoordinatorDate.add(this.jlshowFrameSend);
                this.jpReadCoordinatorDate.add(this.jlFrameRecived);
                this.jpReadCoordinatorDate.add(this.jlshowFrameRecived);
                this.jpReadCoordinatorDate.add(this.jbSendCommand);
                this.jlshowFrameSend.setText(sendFrames.getStrframe0x51(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_COORDINATOR_DATE_0x51));
                this.jlshowFrameRecived.setText("------");
            }
            if(jcbStages.getSelectedIndex() == 4)
            {
                this.cardLayout.show(jpCards,"READ CHANNEL");
                this.jpReadChannel.add(this.jlFrameSend);
                this.jpReadChannel.add(this.jlshowFrameSend);
                this.jpReadChannel.add(this.jlFrameRecived);
                this.jpReadChannel.add(this.jlshowFrameRecived);
                this.jpReadChannel.add(this.jbSendCommand);
                this.jlshowFrameSend.setText(sendFrames.getStrframe0x70(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_CHANNEL_0x70));
                this.jlshowFrameRecived.setText("------");
            }
            if(jcbStages.getSelectedIndex() == 5)
            {
                this.cardLayout.show(jpCards,"READ PAN ID");
                this.jpReadPanId.add(this.jlFrameSend);
                this.jpReadPanId.add(this.jlshowFrameSend);
                this.jpReadPanId.add(this.jlFrameRecived);
                this.jpReadPanId.add(this.jlshowFrameRecived);
                this.jpReadPanId.add(this.jbSendCommand);
                this.jlshowFrameSend.setText(sendFrames.getStrframe0x61(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.READ_PAN_ID_0x61));
                this.jlshowFrameRecived.setText("------");
            }
            if(jcbStages.getSelectedIndex() == 6)
            {
                this.cardLayout.show(jpCards,"ERASE METER TABLE");
                this.jpEraseMeterTable.add(this.jlFrameSend);
                this.jpEraseMeterTable.add(this.jlshowFrameSend);
                this.jpEraseMeterTable.add(this.jlFrameRecived);
                this.jpEraseMeterTable.add(this.jlshowFrameRecived);
                this.jpEraseMeterTable.add(this.jbSendCommand);
                this.jlshowFrameSend.setText(sendFrames.getStrframe0x34(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.ERASE_METER_TABLE_0x34));
                this.jlshowFrameRecived.setText("------");
            }
            if(jcbStages.getSelectedIndex() == 7)
            {
                this.cardLayout.show(jpCards,"ERASE DEVICES TABLE");
                this.jpEraseDevicesTable.add(this.jlFrameSend);
                this.jpEraseDevicesTable.add(this.jlshowFrameSend);
                this.jpEraseDevicesTable.add(this.jlFrameRecived);
                this.jpEraseDevicesTable.add(this.jlshowFrameRecived);
                this.jpEraseDevicesTable.add(this.jbSendCommand);
                this.jlshowFrameSend.setText(sendFrames.getStrframe0x35(rFrames.getMacAddresOfFrame(), IdCommand.SIZE_09_00, IdCommand.ERASE_DEVICES_TABLE_0x35));
                this.jlshowFrameRecived.setText("------");
            }
            /*if(jcbStages.getSelectedIndex() == 8)
            {
                this.cardLayout.show(jpCards,"DOOR ALARM P");
                this.jpDoorAlarmP.add(this.jlFrameSend);
                this.jpDoorAlarmP.add(this.jlshowFrameSend);
                this.jpDoorAlarmP.add(this.jlFrameRecived);
                this.jpDoorAlarmP.add(this.jlshowFrameRecived);
                this.jpDoorAlarmP.add(this.jbSendCommand);
                this.jlshowFrameSend.setText("------");
                this.jlshowFrameRecived.setText("------");
            }
            if(jcbStages.getSelectedIndex() == 9)
            {
                this.cardLayout.show(jpCards,"DOOR ALARM S");
                this.jpDoorAlarmS.add(this.jlFrameSend);
                this.jpDoorAlarmS.add(this.jlshowFrameSend);
                this.jpDoorAlarmS.add(this.jlFrameRecived);
                this.jpDoorAlarmS.add(this.jlshowFrameRecived);
                this.jpDoorAlarmS.add(this.jbSendCommand);
                this.jlshowFrameSend.setText("------");
                this.jlshowFrameRecived.setText("------");
            }
            if(jcbStages.getSelectedIndex() == 10)
            {
                this.cardLayout.show(jpCards,"SINGLE MEASURE");
                this.jpSingleMeasure.add(this.jlFrameSend);
                this.jpSingleMeasure.add(this.jlshowFrameSend);
                this.jpSingleMeasure.add(this.jlFrameRecived);
                this.jpSingleMeasure.add(this.jlshowFrameRecived);
                this.jpSingleMeasure.add(this.jbSendCommand);
                this.jlshowFrameSend.setText("------");
                this.jlshowFrameRecived.setText("------");
            }
            if(jcbStages.getSelectedIndex() == 11)
            {
                this.cardLayout.show(jpCards,"TURN RELAY");
                this.jpTurnRelay.add(this.jlFrameSend);
                this.jpTurnRelay.add(this.jlshowFrameSend);
                this.jpTurnRelay.add(this.jlFrameRecived);
                this.jpTurnRelay.add(this.jlshowFrameRecived);
                this.jpTurnRelay.add(this.jbSendCommand);
                this.jlshowFrameSend.setText("------");
                this.jlshowFrameRecived.setText("------");
            }*/            
        }        
    }
}
