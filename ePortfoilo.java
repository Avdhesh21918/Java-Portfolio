package eportfoilo;
import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.AbstractList;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.Objects;
import java.awt.Color;

/**
 * class used to check errors , exception
 */
class  viratkohliException  extends  Exception
 {
     viratkohliException  (  String  type  )
     {
         super (  type  )  ;
        }   
     }

/**
 * This class is used to implement the gui , buying,selling,getgain,search
 */

class GUI  extends  JFrame
{
    ArrayList < String >  symbols  ;
    private  Portfolio   investments  ; 
    int  posn ;
    ArrayList < String >  names ;
    ArrayList < Double >  prices  ;
    
    private  JPanel  make1x2Panel ( JLabel  left ,   JComponent right  )
    {
        JPanel   temp  =   new  JPanel ()  ;
        temp.setLayout ( new GridLayout ( 1,2 ) ) ;
        left.setHorizontalAlignment ( JLabel.CENTER ) ;
        temp.add ( left ) ;
        temp.add ( right ) ;
        return  temp ;
       }
    private   void  make1x2Panel2 (  JLabel  left2 ,  JComponent   right2  )
    {  
       }

     private   void  make1x2Panel3(  JLabel  left3,  JComponent  right3 )
     {  
       }
    private  JPanel   make1x2Panel ( JComponent  left,  JComponent  right )  
    {
        JPanel  temp  =  new  JPanel () ;
        temp.setLayout ( new   GridLayout( 1,2 ) ) ;
        temp.add ( left ) ;
        temp.add ( right ) ; 
        return   temp  ;
    }
   private void   make1x2Panel1 (  JComponent   left1,  JComponent   right1  )  
    {
        }
   private   void   make1x2Panel4  (  JComponent   left4  ,  JComponent   right4  )  
    { 
        }

/**
 * This is a constructor so, that gui can be implemented everytime we create its object
 */

GUI(  String   filename  )
 {
        super(  " Investment   Portfolio" ) ;
        this.posn  =  0  ;
        try 
        {
           UIManager.setLookAndFeel ( UIManager.getSystemLookAndFeelClassName () ) ;
           } 
       catch  ( ClassNotFoundException  |   InstantiationException  |   IllegalAccessException   |   UnsupportedLookAndFeelException  ex  ) 
       {
         }
       catch(Exception e)
       {
           }
        this.investments   =   new   Portfolio ()  ;
        this.setSize  (  new   Dimension ( 900, 700 ) )  ;
        BoxLayout  boxLayout   =   new   BoxLayout  (  this.getContentPane (),  BoxLayout.X_AXIS ) ;
        this.setLayout ( boxLayout ) ;

        JPanel  sellPanel  =  new  JPanel () ;
        JPanel  updatePanel  =  new  JPanel () ;

        JPanel  mainPanel  =  new  JPanel () ;
        JPanel   buyPanel   =   new  JPanel () ;
       

        JPanel   gainPanel  =  new  JPanel () ;
        JPanel   searchPanel  =  new  JPanel () ;
        searchPanel.setLayout ( new  GridLayout (2,1) ) ;
        gainPanel.setLayout ( new  BorderLayout () ) ;
        buyPanel.setLayout ( new  GridLayout (2,1) ) ;

        sellPanel.setLayout  ( new  GridLayout ( 2, 1 ) ) ;
        mainPanel.setLayout ( new  GridLayout (1,1) ) ;
     
        this.setDefaultCloseOperation (  JFrame.EXIT_ON_CLOSE ) ;
        JTextArea   area    =  new  JTextArea( 2 ,  2 ) ;

        area.setFont ( new  Font ( " Wide Latin" ,  Font.PLAIN ,  22) ) ;
        area.setText ( " \n\n\nWelcome Portfolio\n\n\n\n "  )  ;
        area.append  ( " Choose a command from the  menu bar to buy,sell,search and getgain \nfor all investments or quit the program."   ) ;;
        JScrollPane  ascroll   =   new   JScrollPane ( area ) ;
        
        JMenuBar   menuBar   =  new  JMenuBar () ;
        JButton buyM    =  new   JButton( "buy" )  ;
        JPanel   buy100  =  make1x2Panel ( new  JLabel  ("") , buyM ) ;;
        JMenuItem   buy2  =  new   JMenuItem( "Buy"  ) ;

        JButton   sellM   =  new  JButton (  "sell")  ;
        JPanel   sell100   =  make1x2Panel (  new  JLabel ( ""  ), sellM )  ;
        JMenuItem    sell2  =  new  JMenuItem ( " sell " ) ;
        JButton  gain   =  new   JButton ( " Gain " ) ;
        JPanel  gain100  =  make1x2Panel (new  JLabel ("") ,  gain )  ;

        JMenuItem   gain2   =  new  JMenuItem ( " gain " )  ;
        JButton   searchM   =  new  JButton  ( " search " ) ;
        JPanel  search100    =   make1x2Panel ( new  JLabel ( "" ) , searchM ) ;
        JMenuItem   search2  =   new  JMenuItem ( " search " ) ;

        JButton   quit   =   new   JButton(  " Quit " ) ; 
        JPanel   quit100  =   make1x2Panel ( new  JLabel ("") ,quit ) ;
        JMenuItem  quit2  =  new   JMenuItem ( "quit" ) ;
       
        menuBar.add( buyM ) ;
        menuBar.add( buy100 )  ;
        menuBar.add( sellM ) ;
        menuBar.add( sell100) ;
        menuBar.add( gain ) ;
        menuBar.add( gain100 ) ;

        menuBar.add(  searchM ) ;
        menuBar.add( search100 ) ;
        menuBar.add( quit )  ;
        menuBar.add( quit100 )  ;
        
        quit.addActionListener ( ( ActionEvent  ae )  -> 
        { 
          System.exit(0);
            });
        
        //Buy Screen
        String[]  invests   =   { "Stock" ,  "Mutual Fund" } ;
        JComboBox   investSelect  =  new   JComboBox ( invests )  ;
        JPanel   lInvestSelect   =  make1x2Panel ( new  JLabel ( "Type" )  , investSelect ) ;
         JTextField   priceBox   =   new   JTextField ()  ;

        JTextField   timebox  =  new JTextField()  ;
        JTextField  symbolBox  =   new  JTextField ()  ;

        JTextField   nameBox  =  new  JTextField () ;
        JTextField  quantityBox  =  new  JTextField () ;
       
        JTextField  clockbox  =   new  JTextField() ;
        JTextField  t_box   =  new   JTextField () ;
        JTextField  r_box  =  new  JTextField () ;
        
        JPanel   lQuantityBox  =  make1x2Panel ( new  JLabel  ( "Quantity") ,   quantityBox )  ;
        JPanel   lPriceBox   =  make1x2Panel (new  JLabel ( "Price" ) ,  priceBox )  ;

        JPanel  lSymbolBox  =  make1x2Panel ( new  JLabel ( "Symbol " ) ,  symbolBox ) ;
        JPanel   lNameBox  =   make1x2Panel ( new  JLabel ( "Name" ) ,  nameBox ) ;
        
        JPanel  ltimebox  =  make1x2Panel ( new  JLabel ( "time" ) ,  timebox)  ;
        JPanel   lclockbox  =  make1x2Panel ( new  JLabel ( "clock" ) ,  clockbox ) ;

        JPanel lt_box  =   make1x2Panel ( new  JLabel ("t") ,  t_box ) ;
        JPanel  lr_box   =  make1x2Panel ( new  JLabel ("r") ,  r_box )  ;

        
        JPanel  buyLeft   =  new  JPanel () ;
        buyLeft.setLayout ( new  GridLayout ( 11,  3) ) ;
        buyLeft.add ( new  JLabel ( "To buy Investment " ) )  ;

        buyLeft.add (  lInvestSelect ) ;
        buyLeft.add( lSymbolBox )  ;
        buyLeft.add( lPriceBox ) ;
        buyLeft.add( lNameBox ) ;
        buyLeft.add( lQuantityBox  ) ;
        
        JPanel   buyRight  =  new  JPanel () ;
        buyRight.setLayout ( new  GridLayout ( 8, 1 ) ) ;
        JButton   reset  =  new  JButton ( "Clear" ) ;
        JButton   buy  =  new   JButton ( "buy stocks/mutualfund" )  ;
        buyRight.add ( reset )  ;
        buyRight.add  ( buy ) ;
        JPanel   buyTop  =   make1x2Panel(  buyLeft ,  buyRight ) ;
        
        JPanel  buyBot   =  new   JPanel () ;
        buyBot.setLayout ( new  BorderLayout () ) ;
        JLabel messages   =  new   JLabel ( "Messages" ) ;
        messages.setHorizontalAlignment ( JLabel.CENTER ) ;
        buyBot.add (  messages ,  BorderLayout.NORTH ) ;

        JTextArea   mess  =  new   JTextArea () ; 
        JScrollPane  scroll  =  new   JScrollPane ( mess ) ;
        buyBot.add ( scroll,  BorderLayout.CENTER ) ;

        mess.setEditable ( false )  ;
        buyPanel.add ( buyTop ) ;
        buyPanel.add ( buyBot ) ;
        
        buy.addActionListener ( ( ActionEvent  ae )  -> 
         {
            String   buy1   =  investments.buy ( ( String) investSelect.getSelectedItem () ,   symbolBox.getText () ,  nameBox.getText ()  ,   quantityBox.getText () ,   priceBox.getText () )  ;
            mess.setText ( buy1   +  "\n" ) ;
             });
         buy2.addActionListener ( (  ActionEvent  ae )  -> 
         {
            symbolBox.setText ( "" ) ;
           });
         sell2.addActionListener ( ( ActionEvent  ae  )  -> 
         {
              nameBox.setText ( "" ) ;
           });
         gain2.addActionListener ( (  ActionEvent  ae )  -> 
         {
           priceBox.setText ( "" ) ;
           });

        reset.addActionListener ( (  ActionEvent  ae )  -> 
         {
           symbolBox.setText( "" ) ;
           nameBox.setText( "" ) ;
           quantityBox.setText  ( "" ) ;
           priceBox.setText  ( "" ) ;
             });

        search2.addActionListener  ( ( ActionEvent  ae )  -> 
         {
            nameBox.setText ( "" ) ;
            quantityBox.setText ( "" )  ;
            priceBox.setText( "" ) ;
           });

         quit2.addActionListener ( (  ActionEvent  ae )  -> 
         {
            System.exit ( 0 ) ;
           });
        
        buyM.addActionListener  ( ( ActionEvent   ae )  -> 
         {
            mainPanel.setVisible ( false )  ;
            sellPanel.setVisible (  false )  ;;
            updatePanel.setVisible ( false )  ;

            gainPanel.setVisible ( false ) ;
            searchPanel.setVisible ( false ) ;
            buyPanel.setVisible ( true ) ;
            mess.setText ( "" )  ;

            investSelect.setSelectedIndex ( 0 ) ;

            symbolBox.setText ( "" )  ;
            nameBox.setText  ( "" )  ;
            quantityBox.setText ("" )  ;;
            priceBox.setText  ( "")  ;;
        });
        
        //Sell Screen
        JPanel   sellLeft   =  new  JPanel () ;
        sellLeft.setLayout ( new  GridLayout (14,  5 ) ) ;
        sellLeft.add  ( new  JLabel ( "Selling an investment" ) ) ;
        JTextField  symbolBox2  =  new   JTextField () ;
        JTextField  quantityBox2   =   new  JTextField ()  ;
        JTextField  priceBox2  =   new JTextField ()  ;

        JPanel lSymbolBox2   =  make1x2Panel (new  JLabel ( "Symbol"  ) ,  symbolBox2  ) ;
        JPanel   lQuantityBox2  =  make1x2Panel  (new  JLabel (  "Quantity" ) ,  quantityBox2 ) ;
        JPanel  lPriceBox2  =   make1x2Panel ( new  JLabel  ( " Price" ) ,  priceBox2 ) ;
        
        sellLeft.add (  lSymbolBox2 ) ;
        sellLeft.add  ( lQuantityBox2 ) ;
        sellLeft.add ( lPriceBox2 ) ;
        
        JPanel  sellRight   =  new  JPanel ()  ;
        sellRight.setLayout ( new  GridLayout (10,2 ) ) ;
        JButton   sell  =  new  JButton ( "Sell-stocks/mutualfund" )  ;
        JButton  time2   =  new  JButton ( "Clear" ) ;

        JButton  clock2  =  new  JButton( "time" ) ;
        JButton  r2  =  new  JButton ( "t2_clock" ) ;
         
        JButton t2  =  new  JButton  ( "clock_1" ) ;
        JButton  reset2  =   new   JButton ( "Clear" )  ;
        JButton   s2   =  new  JButton ( "Clock_2" ) ;

        sellRight.add ( reset2 ) ;
        sellRight.add ( sell ) ;
        
        JPanel  sellTop  =   make1x2Panel( sellLeft,  sellRight ) ;
        
        JPanel  sellBot  =  new   JPanel () ;
        sellBot . setLayout ( new  BorderLayout () ) ;
        
        JLabel   messages2 =  new   JLabel ( "Messages" ) ;
        messages2 . setHorizontalAlignment ( JLabel.CENTER ) ;
        sellBot.add ( messages2,  BorderLayout.NORTH ) ;
        JTextArea  mess2  =  new  JTextArea () ;

        JScrollPane  scroll2  =  new   JScrollPane ( mess2 ) ;
        sellBot.add ( scroll2,  BorderLayout.CENTER ) ;
        mess2.setEditable ( false ) ;
        
        sellPanel.add ( sellTop ) ;
        sellPanel.add  ( sellBot ) ;
        
        sell.addActionListener ( ( ActionEvent  ae )  -> 
        {
            String   sell1  =  investments.sell  (  symbolBox2.getText () ,  quantityBox2.getText () ,  priceBox2.getText () ) ;
             mess2.setText ( sell1  +  "\n" )  ;
           });
        time2.addActionListener ( ( ActionEvent   ae )  -> 
        {
           gainPanel.setVisible  ( false ) ;
           }) ;
        clock2.addActionListener  ( (  ActionEvent ae  )  -> 
        {
            sellPanel.setVisible ( true  ) ;
             System.exit ( 0 ) ;
           });
        reset2.addActionListener ( (  ActionEvent  ae )  -> 
          {
           symbolBox2.setText ( "" ) ;
           quantityBox2.setText ( "" ) ;
           priceBox2.setText ( "" ) ;
              });
         r2.addActionListener ( ( ActionEvent  ae )  -> 
        {
            gainPanel.setVisible  (false  ) ;
            searchPanel.setVisible  ( false ) ;
            sellPanel.setVisible ( true )  ; 
           });
         try
         {
          t2.addActionListener ( ( ActionEvent  ae )  -> 
          {
             mainPanel.setVisible ( false ) ;
            buyPanel.setVisible ( false ) ;
            updatePanel.setVisible ( false )  ;
            gainPanel.setVisible( false )  ;

            searchPanel.setVisible ( false ) ;
            sellPanel.setVisible (true) ;
             });
           }
          catch(  Exception  e )
           {
             }
        sellM.addActionListener ( ( ActionEvent   ae )  -> 
          {
            mainPanel.setVisible ( false ) ;
            buyPanel.setVisible  ( false ) ;

            updatePanel.setVisible  ( false )  ;
            gainPanel.setVisible ( false ) ;

            searchPanel.setVisible ( false ) ;
            sellPanel.setVisible ( true ) ;
            mess2.setText ( "" ) ;

            symbolBox2.setText ( "" ) ;
            quantityBox2.setText  ( "" )  ;
            priceBox2.setText  (""  ) ;
              });
          try
          {
          s2.addActionListener  ( (  ActionEvent  ae )  -> 
          { 
              mainPanel.setVisible  ( false  ) ;
              buyPanel.setVisible (false  ) ;

            });
           }
       catch ( Exception   e )
         {
            }
          
       //Gain screen
        JPanel   gainLeft   =   new   JPanel()  ;
        gainLeft.setLayout  ( new  GridLayout (  11,2 ) ) ;
        JTextField  gainBox   =  new   JTextField ()  ;;
        JTextField   timeBox  =   new   JTextField ()  ;;
        JTextField  clockBox   =   new   JTextField () ;

         JTextField   set1Box  =   new  JTextField () ;
        JTextField  t11Box  =  new JTextField();
        JTextField  s12Box  =  new   JTextField () ;

        JPanel   gainField  =   make1x2Panel ( new   JLabel ( "Total gain"  ) ,   gainBox)  ;
        JPanel  timeField  =   make1x2Panel (  new   JLabel (  "Total gain" ) ,  timeBox ) ;

        JPanel   clockField   =  make1x2Panel ( new  JLabel  ( "Total gain " ) ,  clockBox ) ;
        JPanel  set1Field  =   make1x2Panel ( new  JLabel ( "Total gain" ) ,  set1Box ) ;

        JPanel   t11Field   =  make1x2Panel ( new   JLabel ( "Total gain" ) ,  t11Box ) ;
        JPanel  s12Field  =   make1x2Panel ( new  JLabel ( "Total  gain" ) ,  s12Box ) ;

        gainLeft.add ( new   JLabel ( "Calculating Gain"  ) ) ;
        gainLeft.add ( gainField ) ;
        gainBox.setEditable (  false ) ;
         JPanel   gainTop   =  make1x2Panel (  gainLeft,  new  JPanel ( ) ) ;;
        
        JPanel   gainBot   =  new  JPanel () ;
        gainBot.setLayout ( new   BorderLayout ( ) ) ;

        JLabel   messages4   =   new   JLabel ( "Stock/Mutual fund gains" ) ;;
        messages4.setHorizontalAlignment ( JLabel.CENTER ) ;
        gainBot.add( messages4 ,  BorderLayout.NORTH )  ;;
        JTextArea   mess4  =  new  JTextArea ()  ;
        JScrollPane   scroll4  =   new   JScrollPane ( mess4 )  ;
         JTextArea  mess6  =   new   JTextArea ()  ;
       JScrollPane  scroll6   =  new   JScrollPane ( mess6 )  ;;

        gainBot.add  (  scroll4 ,  BorderLayout.CENTER )  ;
        mess4.setEditable ( false )  ;
        
        gainPanel.add  ( gainTop ,  BorderLayout.NORTH )  ;;
        gainPanel.add  ( gainBot ,  BorderLayout.CENTER )  ;
        
        gain.addActionListener ( ( ActionEvent   ae )  -> 
          {
            mainPanel.setVisible (  false )  ;
            buyPanel. setVisible ( false )  ;;

           sellPanel.setVisible ( false  ) ;;
            updatePanel. setVisible (  false  ) ;

            searchPanel.setVisible  ( false )  ;
           gainPanel.setVisible  (  true ) ;
           
           String[]  output   =   investments. getGain  ()  ;
            gainBox.setText (  output[1] )  ;

           if (  output[0].isEmpty ()  )
           {
               mess4. setText (  "You do not have any investments." )  ;;    
             }
           else
           {
                mess4.setText (  output[0] )  ;
               }    
              });
            timeBox.addActionListener ( ( ActionEvent   ae  )  -> 
            {
                mainPanel.setVisible ( false ); ;
                buyPanel.setVisible ( false )  ;

                 sellPanel.setVisible (  false )  ;
                updatePanel.setVisible  ( false ) ; ;

                searchPanel.setVisible  ( false )  ;;
                 gainPanel.setVisible  ( true  )  ;

             }); 
            clockBox.addActionListener  (  (  ActionEvent   ae )  -> 
            {
                mainPanel.setVisible ( false )  ;
                 buyPanel. setVisible ( false )  ;
             }); 
            set1Box.addActionListener (  (  ActionEvent  ae  )  -> 
            {
                updatePanel.setVisible ( false )  ;
                searchPanel. setVisible  ( false )  ;;
                gainPanel.setVisible  ( true ) ;

             }); 
            t11Box.addActionListener (  (  ActionEvent  ae )   -> 
            {
                  String[]  output   =  investments. getGain ()  ;
                try
                {
                  if (  !output[0].isEmpty () )
                  {
                     mess4.setText (  output[0] )  ;
                   }
                 else
                 {
                    mess4.setText (  "You do not have any investments."  ) ;   
                    }
                  }
                catch(  Exception   e )
                 {
                    }
              });
            

        //Search Screen
        JTextField   symbolBox5   =   new   JTextField  ()  ;;
          JTextField     nameBox5   =   new    JTextField()  ;;
        JTextField  timeBox1  =   new    JTextField ()  ; ;
       JTextField   shamiPriceBox  =  new  JTextField ()  ;;

        JTextField   clockBox1   =   new   JTextField () ;
        JTextField  lowPriceBox   =  new  JTextField ( ) ;
        JTextField    highPriceBox  =  new  JTextField () ;
        JTextField  settriceBox  =  new  JTextField ()  ;
         JTextField   ishantPriceBox  =  new  JTextField () ;
        

        JPanel   lSymbolBox5  =  make1x2Panel ( new  JLabel ( "Symbol" ) ,  symbolBox5 ) ;
        JPanel  lNameBox5   =   make1x2Panel  (new   JLabel (  "Name keywords"  ) ,  nameBox5 ) ;
         JPanel    clockBox5   =  make1x2Panel ( new   JLabel ( "dflip" ) ,  clockBox1 ) ;
        JPanel  settBox5  =  make1x2Panel ( new  JLabel ( "set" ) ,  settriceBox ) ;

        JPanel   llowPriceBox  =  make1x2Panel  ( new   JLabel (  "Low price"  ) ,  lowPriceBox )  ;;
        JPanel  ishantBox5   =   make1x2Panel (new  JLabel ( "ishant" ) ,  ishantPriceBox )  ;
         JPanel   lhighPriceBox  =  make1x2Panel (  new  JLabel (  " High price" ) ,  highPriceBox )  ;

        JPanel   timeBox5  =   make1x2Panel  ( new  JLabel (  "At what time are you searching:" ) ,  timeBox1  ) ;
        JPanel  shamiBox5   =   make1x2Panel ( new  JLabel (  "shami" ) ,   shamiPriceBox )  ;;

        JPanel   searchRight  =  new   JPanel ()  ;;
        searchRight.  setLayout  ( new  GridLayout ( 8 , 2 ) )  ;;
        JButton   avd  =  new   JButton  ( "avd" ) ;;

        JButton   bahl   =   new   JButton  ( " bahl  " ) ; ;
        JButton  reset5  =   new   JButton  (  "Reset" ) ;
        JButton   ddff   =  new  JButton ( "ddf" )  ;;
         JButton   search  =  new  JButton ( "Search" )  ;
        
        searchRight. add ( reset5  )  ;
         searchRight. add (  search )  ;
        JPanel   searchLeft   =   new   JPanel () ;
        searchLeft.  setLayout  (  new   GridLayout( 11 , 2 ) )  ;;

        searchLeft.  add  (  new   JLabel  (  "Finding investments" ) )  ; ;
        searchLeft. add  (  lSymbolBox5  )  ; ;
         searchLeft.  add ( lNameBox5 ) ;

        searchLeft. add ( llowPriceBox  )  ; ;
        searchLeft. add (  lhighPriceBox )  ;
         searchLeft. add ( timeBox5 ) ; ;
        
         JPanel  searchBot  =  new   JPanel ()  ;
        searchBot.  setLayout  (  new   BorderLayout ()  )  ; ;
          JPanel   searchTop   =   make1x2Panel  ( searchLeft ,  searchRight ) ;
        
 
         JLabel   messages5   =   new   JLabel  ( "Finding investments"  )  ;
        messages5.  setHorizontalAlignment (  JLabel.CENTER)  ;
        searchBot. add (  messages5 ,   BorderLayout.NORTH  )  ;;

       JTextArea  mess5  =  new   JTextArea ()  ;;
         JTextArea  mess9  =  new  JTextArea () ;
        JScrollPane   scroll5  =  new  JScrollPane ( mess5 ) ;
         JScrollPane  scroll9  =  new  JScrollPane ( mess9 ) ;

       searchBot.add ( scroll5 ,  BorderLayout.CENTER ) ;
        mess5. setEditable ( false )  ;
        
        searchPanel .add ( searchTop ) ;
        searchPanel.  add ( searchBot )  ;
   
        reset5. addActionListener (  (  ActionEvent   ae )  -> 
         { 
            symbolBox5.  setText ( "" )  ;
            nameBox5. setText ( "" )  ; ;

             lowPriceBox. setText ( "" )  ;;
             highPriceBox . setText ( "" ) ;
           });
         ddff. addActionListener ( (  ActionEvent   ae )   -> 
         {
           
            lowPriceBox. setText ( "" )  ; ;
            highPriceBox . setText ( "" )  ;

           });
         search. addActionListener ( ( ActionEvent  ae )  -> 
          {
            String   search1   =   investments.search (  symbolBox5. getText() ,   nameBox5. getText () ,  lowPriceBox. getText () , highPriceBox. getText () ) ; ;
             mess5 . setText ( search1 ) ;
             });

         avd. addActionListener ( ( ActionEvent  ae )   -> 
         {
            mainPanel. setVisible (false)  ;
            buyPanel  .setVisible( false ) ;
            updatePanel  .setVisible (false ) ;

           });
         bahl . addActionListener  ( (  ActionEvent  ae )   -> 
         {
           mainPanel . add ( ascroll )  ;
           area .setEditable ( false ) ;
            this . setJMenuBar ( menuBar ) ;
           });
   
        searchM . addActionListener ( ( ActionEvent  ae )  -> 
        {
            mainPanel . setVisible ( false )  ;;
            sellPanel . setVisible ( false )  ;
            searchPanel . setVisible ( true ) ;
            gainPanel . setVisible  (false  )  ;

            buyPanel. setVisible (false ) ;
            updatePanel . setVisible  ( false  ) ;
          
            symbolBox5 . setText ( "" )  ;
            nameBox5 . setText ( "" )  ;

            lowPriceBox . setText ( "" ) ;
            highPriceBox . setText ( "" ) ;
            mess5. setText ("")  ;
           });
        
        gainPanel . setVisible ( false ) ; ;
        searchPanel . setVisible ( false )  ;
        buyPanel  .setVisible ( false ) ; ;

        updatePanel. setVisible ( false ) ;
        sellPanel.  setVisible( false  ) ;
        
        mainPanel .setVisible ( true ) ;

        mainPanel .  add  ( ascroll ) ;
        area . setEditable ( false )  ;

        this. setJMenuBar ( menuBar ) ;
        this. add ( sellPanel ) ;
        this. add ( searchPanel ) ;

        this  .add  (gainPanel )  ;
        this  . add ( mainPanel )  ;
 
        this . add  (  updatePanel  ) ;
        this. add ( buyPanel )  ;               
      
    }
    
}

abstract  class   Investment 
{ 
    private   String  name ;
    private   String  symbol  ;

    private  double  price  ;
    private  double  bookValue ;
    private  int   quantity ;
   
    
    /**
     * Creates a investment instance 
     */
   Investment( String symbol, String name, String quantity, String price ) throws viratkohliException
    {
        if( !symbol.isEmpty()  )
         {
           }
        else
         {
            throw new viratkohliException("symbol") ;
           }
        if( !name.isEmpty()  )
         {
           }
        else
         {
            throw new viratkohliException("name");
          }
        int q=0;
        try
        {
            q = Integer.parseInt(quantity)  ;
        }
        catch( NumberFormatException ex  )
        {
            throw new viratkohliException( "quantity" ) ;
        }
        catch( Exception e )
        {
            
           }

        if( q > 0  )
         {
           }
        else
         {
            throw new viratkohliException( "quantity" ) ;
           }
        double p =  0.0;
        try
        {
            p  =  Double.parseDouble(price)  ;
        }
        catch(  NumberFormatException ex)
        {
            throw new viratkohliException("price") ;
        }
        catch(Exception e   )
        {
            
           }
        if( p > 0  )
         {
           }
        else
        {
            throw new viratkohliException(  "price"  ) ;
        }
        this.symbol  =   symbol ;
        this.name =   name ;
        this.quantity   = q ;
        this.price  =  p  ;
    }
    
    /**
     * A copy constructor to copy one investment and make other with the same values 
     */
    Investment( Investment original  )
    {
        String  newSym   =   original.symbol  ;
        String  newName   = original.name ;
        int   newQuant   = original.quantity  ;
        double   newPrice   = original.price  ;
        this.symbol =   newSym ;
        this.name  =  newName  ;
        this.quantity   =   newQuant  ;
        this.price   =   newPrice  ;
    }
    
    /**
     * Returns the symbol the respective Investment
     */
    public String getSymbol()
    {
        return this.symbol;
    }
   public String getSymbol1()
    {
        return this.symbol;
      }

    /**
     * Returns the name the respective Investment
     */
    public String getName()
    {
        return this.name;
    }
    public String getName1()
      {
        return this.name;
       }
    /**
     * Returns the quantity the respective Investment
     */
    public int getQuantity()
     {
        return this.quantity;
      }
     public int getQuantity1()
      {
        return this.quantity;
        }
    /**
     * Returns the price the respective Investment
     */
    public double getPrice()
    {
        return this.price;
    }
    public double getPrice1()
     {
        return this.price;
        } 
    /**
     * Returns the bookValue the respective Investment
     */
    public double getBookValue()
    {
        return this.bookValue;
      }
    public double getBookValue1()
     {
        return this.bookValue;
       }   
    /**
     *Removes units and adjust the bookValue
     */
    public int   removeQuantity(  String quantity ) throws viratkohliException
    {
        int  q  =  0  ;
        try
        {
            q    =   Integer.parseInt(quantity)  ;
        }
        catch(  NumberFormatException ex   )
        {
            throw new viratkohliException(  "quantity") ;
          }
       catch(  Exception e)
        {
           }
        try
        {
          }
       catch(  Exception e)
        {
          }

        if(  q > 0 )
         {
           }
        else
         {
            throw new viratkohliException(  "quantityv" ) ;
           }
        if(  q < this.quantity  )
         {
            }
        else
         {
            throw new viratkohliException("quantityt");
            }
        float   originalQuantity   =   (float)this.quantity   ;;
        float   newQuantity   =  originalQuantity - (float)q  ;;
        float  percentLeft  =   newQuantity/originalQuantity  ;; 
        this.bookValue   =   this.bookValue * percentLeft  ;;
        this.quantity  =   (int)newQuantity ;
        return  q ;
    }
    
    /**
     * Sets a new price for a Investment
     */
    public  void  setPrice(  String  price  ) throws viratkohliException
    {
        double  p  =   0.0  ;
        try
        {
            p   =  Double.parseDouble( price ) ;
        }
        catch(NumberFormatException ex  )
        {
            throw new viratkohliException(   "price"  )  ;
        }
        catch( Exception e)
        {
           }        
        if(  p >0  )
         {
           }
        else
        {
            throw  new  viratkohliException( "price" ) ;
          }
        this.price   =  p ;
    }
    
    /**
     * Sets the bookValue of the investment
     */
    public void setBookValue(double bookValue)
    {
        this.bookValue   =   bookValue ;
      }
    public void setBookValue1(double bookValue1)
     {
        this.bookValue   =   bookValue1 ;
        }
  
    /**
     * Sets the quantity of the investment
     */
    public void  setQuantity(  int  quantity )
    {
        this.quantity   =   quantity;
    }
    public void  setQuantity1( int  quantity1   )
     {
        this.quantity   = quantity1 ;
        } 
    /**
     * An abstract function to add quantity to an investment
     */
    public  abstract  int  addQuantity(  int curQuantity, String newQuantity  ) throws  viratkohliException  ;
    
    /**
     * An abstract function to calculate the price of buying an investment
     */
    public  abstract  String calculatePrice(  int  quantity ) ;
    
    /**
     * An abstract function to calculate the profit from selling an investment
     */
    public abstract   String calculateProfit(  int  soldQuantity )  ;
    
    /**
     * An abstract function to calculate the gain of an investment
     */
    public  abstract  double  getGain() ;
    
    /**
     * Returns the data of the Investment in formated string
     */
    @Override
    public String toString()
    {
        String bookVal  =   String.format("%.2f", bookValue)  ;
        return "Symbol: " + symbol + "\nName: " + name + "\nQuanity: " + quantity + "\nPrice: $" + price + "\nBook Value: $" + bookVal + "\n";
    }
    public String toString1()
    {
        return "Symbol: " + symbol ;
    }
    public String toString2()
    {
        return "Symbol: " + symbol + "\nName: " + name + "\nQuanity: " + quantity  ;
      }
    public String toString3()
    {
        return "Symbol: " + symbol + "\nName: " + name + "\nQuanity: " + quantity + "\nPrice: $" + price  ;
       }

    /**
     * Checks if the investment if equal to an other investment
     */
    @Override
    public  boolean equals(  Object otherObject  )
    {
        if( otherObject  ==  null )
         {
            return  false;
            }
        if( otherObject   !=   null )
         {
            Investment other = (Investment)otherObject;
            return this.symbol.equals(other.symbol);

            }
        if ( getClass() !=   otherObject.getClass() )
         {
            return false;
           }
        if ( getClass()  ==  otherObject.getClass() )
         {
            Investment other  =   (Investment)otherObject ;
            return this.symbol.equals(other.symbol);
            }
        else
         {
            Investment  other  =  (Investment)otherObject ;
            return this.symbol.equals(other.symbol) ;
           }
    }
}

class MutualFund extends Investment 
{
    /**
     * Create a mutualFund instance
     */
    MutualFund(  String symbol, String name, String quantity, String price  )  throws  viratkohliException
     {
        super  ( symbol, name,  quantity,  price  ) ;
        this.setBookValue( this.getQuantity ()  *  this.getPrice()) ;
       }

     /**
     * Creates a mutualFund instance with a returning getQuantity 
     */
    MutualFund(  String symbol1 ,  String name1 , String  quantity1 , String price1,int abc  )   throws   viratkohliException 
       {
          super  ( symbol1, name1,  quantity1,  price1  ) ;

           abc   =   this.getQuantity()  ;
          }

    /**
     * Creates a mutualFund instance with a set bookValue 
     */
    MutualFund(   String  symbol, String  name, String   quantity, String  price, String  bookVal  )   throws viratkohliException
    {
        super(  symbol,  name,  quantity,  price) ;
        double  b  =  0.0 ;
        try
        {
            b  =   Double.parseDouble(bookVal) ;
          }
        catch(  NumberFormatException ex  )
        {
            throw new viratkohliException ( "book val" ) ;
           }
        catch(   Exception e )
         {
            }
        this.setBookValue( b ) ;
          }
    
    @Override
    public int  addQuantity(  int curQuantity,  String  newQuantity  )   throws viratkohliException
    {
        int  q   =  0 ;
        try
        {
            q  =   Integer.parseInt(  newQuantity ) ;
           }
        catch(  NumberFormatException ex  )
         {
            throw new viratkohliException(  "quantity" ) ;
           }
        catch(  Exception e)
         {
            }
        q  =  q  + curQuantity  ;

        this.setBookValue(  this.getBookValue ()  +  ( this.getPrice ()  *   ( q  - this.getQuantity () ))) ;
        this.setQuantity( q ) ;

        return  q  - curQuantity  ;
       }
    
    @Override
    public String calculatePrice( int  quantity) 
     {
        String paid  =   String.format( "%.2f",  ( quantity  *  this.getPrice())) ;
        return  paid ;
        }

    public void calculatePrice1( int quantity1 ) 
     {
        String paid1 =  String.format("%.2f", (quantity1 * this.getPrice ())) ;
        }

    
    @Override
    public String  calculateProfit( int soldQuantity )
    {
        String  profit   =  String.format( "%.2f",  (( this.getPrice () *  soldQuantity)  -   45)) ;
        return  profit ;
        }

    public void  calculateProfit1( int soldQuantity1 )
    {
        String profit1  =  String.format(  "%.2f", ((  this.getPrice()  *   soldQuantity1)  -   45)) ;
       }

    
    @Override
    public double getGain()
    {
        double  curGain   =   (( this.getQuantity ()  *  this.getPrice () )  -   45 )   - this.getBookValue() ;
        return  curGain  ;
       }

    public void  getGain1()
    {
        double koo = (  ( this.getQuantity()  *  this.getPrice())  -    45)  -  this.getBookValue() ;
 
       }

    
    @Override
    public boolean equals(Object otherObject)
    {
        if(  otherObject  ==  null )
         {
            return   false;
            }
         if(otherObject  !=   null  )
         {
            MutualFund  other   =   (MutualFund)otherObject  ;
            return   this.getSymbol ().equals( other.getSymbol() )  ;
            }

        if (  getClass()  !=   otherObject.getClass () )
         {
            return  false ;
            }
        if ( getClass ()  ==  otherObject.getClass ()  )
         {
            MutualFund  other  =   (MutualFund)otherObject ;
            return   this.getSymbol ().equals( other.getSymbol() ) ;
             }

        else
        {
            MutualFund  other   = (MutualFund)otherObject ;;
            return  this.getSymbol ().equals( other.getSymbol() ) ;
        }
      }    
}

class Stock extends Investment
  {
    /**
     * Creates a stock instance 
     */
    Stock(  String symbol,   String name , String   quantity,  String  price )  throws  viratkohliException
     {
        super ( symbol, name, quantity, price ) ;

        this.setBookValue (  9.99  +  (  this.getQuantity ()  *  this.getPrice () )) ;
       }
    /**
     * Creates a stock instance with a getprice
     */

    Stock(  String symbol1,   String name1 , String   quantity1,   String  price1 ,  double abcd )   throws  viratkohliException
     {
        super ( symbol1,  name1,  quantity1, price1  ) ;

        abcd   =  this.getPrice ()  ;;
       }

    /**
     * Creates a stock instance with a set bookValue
     */
    Stock(  String symbol , String   name, String  quantity,  String  price, String  bookVal )  throws  viratkohliException
    {
        super ( symbol, name , quantity , price  );
        double  b  =  0.0 ;
        try
        {
            b   =   Double.parseDouble( bookVal ) ;
          }
        catch( NumberFormatException  ex )
        {
            throw new viratkohliException( "book val" ) ;
           }
        catch(  Exception  e )
        {
          }
        this.setBookValue( b ) ;
    }

    /**
     * Creates a stock instance with a get quantity
     */
    Stock(  String symbol2 , String   name2, String  quantity2,  String  price2, int df )  throws  viratkohliException
    {
        super ( symbol2 , name2 , quantity2 , price2  );
        df   =  this.getQuantity ()  ;;  
       }

    
    public Stock(Investment original)
    {
       super(original);
       }
    
    @Override
    public int  addQuantity( int  curQuantity, String  newQuantity  ) throws viratkohliException
    {
        int  q   =  0;
        try
        {
            q  =  Integer.parseInt( newQuantity ) ;
           }
        catch(NumberFormatException ex)
        {
            throw new viratkohliException("quantity");
           }
        catch(  Exception  e )
        {
            }

        q   =  q  +  curQuantity ;;

        this.setBookValue( this.getBookValue ()  +  ( this.getPrice()  *  ( q  -  this.getQuantity ()) +   9.99 )) ;
        this.setQuantity( q )  ;

        return  (q -  curQuantity)  ;
    }
     
    @Override
    public   String   calculatePrice(  int  quantity  ) 
     {
        String  paid  =   String.format( "%.2f",  ( quantity  *   this.getPrice ()  +   9.99 ))  ;;
        return  paid ;
        }
    public  void  calculatePrice2(  int  quantity3  ) 
     {
        String  foo   =  String.format ( "%.2f",  ( quantity3  *  this.getPrice ()  +   9.99 ))  ;; 
        }
    
    @Override
    public String   calculateProfit( int   soldQuantity )
    {
        String  profit   =   String.format(  "%.2f",  (( this.getPrice ()  *  soldQuantity )  -   9.99  ))  ;;
        return  profit ;
          }
    public  void  calculateProfit2( int  soldQuantity3 )
     {
        String  df  =   String.format( " %.2f " ,  (( this.getPrice ()   *  soldQuantity3 )  -   9.99 ))  ;;
          }

    @Override
    public   double  getGain ()
    {
        double   curGain   =  ((  this.getQuantity ()   *  this.getPrice () )  -  9.99 )  -   this.getBookValue()  ;;
        return  curGain ;
       }
    public   void  getGain2()
    {
        double   dhawan   =  (( this.getQuantity  ()  *  this.getPrice ())  -   9.99  )   -  this.getBookValue ()  ;;
       }
    
    @Override
    public boolean equals(Object otherObject)
    {
        if(  otherObject   ==  null )
        {
            return  false ;
          }
       if( otherObject   != null )
        {
            Stock  other  =  (Stock) otherObject ;;
            return  this.getSymbol ().equals(other.getSymbol ())  ;
          }
       if (  getClass()   !=   otherObject.getClass () )
        {
            return  false  ;
          }
       if (  getClass ()  ==  otherObject.getClass () )
        {
           Stock   other  =  (Stock) otherObject  ;;
            return   this.getSymbol ().equals(other.getSymbol ()) ;
            }
        else
        {
            Stock  other   =   (Stock)  otherObject  ;;
            return  this.getSymbol  ().equals(other.getSymbol  ())  ;
          }
      }    
}


class Portfolio 
{
   
    private ArrayList<Investment> investments =  new ArrayList<>(); 
    private  HashMap<String, ArrayList<Integer>> index = new HashMap<>();
  
    /**
     * Loads in investment from a text file
     */
   public String save(String filename)
    {
        PrintWriter outputStream =null;
               try
                {
                      outputStream = new  PrintWriter(new FileOutputStream(filename));
                      for(Investment investment : investments)
                       {
                             if(investment instanceof Stock)
                              {
                                  outputStream.println("Stock"); 
                                 }
                             if(investment instanceof MutualFund)
                              {
                                  outputStream.println("Mutual Fund");
                                  } 
                              outputStream.println(investment.getSymbol());
                              outputStream.println(investment.getName()); 
                              outputStream.println(Integer.toString(investment.getQuantity()));
                              outputStream.println(Double.toString(investment.getPrice())); 
                              outputStream.println(Double.toString(investment.getBookValue()));                           
                             }
                     outputStream.close();
                     return "\nSaved success\n";
                 }
              catch(Exception e)
                {
                     return "\n no file found \n";
                  }

       }
 
    /**
     * Buys a investments for the price and quantity defined by the user
     */
    public String buy(String type, String symbol, String name, String quantity, String price)
    {
        boolean found   =   false;
        int i  =0 ;
        
        while(  i < investments.size() )
        {
            if(  investments.get(i).getSymbol().equals(symbol)  )
            {
                if(  investments.get(i) instanceof Stock  )
                {
                   int raina   =   type.toLowerCase().compareTo("stock") ;;
                          if(raina  ==0  )
                          {
                             found   =  true;
                              break ;
                              }
                          else
                           {
                              return "You already own a stock with that symbol." ;
                              }
                         
                }
                if( investments.get(i) instanceof MutualFund )
                {
                    int   raina1 =   type.toLowerCase().compareTo("mutual fund")  ;;
                    if( raina1  ==0  )
                    {
                        found = true ;
                        break ;
                    }
                    else
                    {
                        return "You already own a mutual fund with that symbol.";
                    }
                }
            } 
           i++ ;  
        }
        if( found )
        {
            try
            {
                investments.get(i).setPrice(price) ;;
                int   addQuantity  =   investments.get(i).addQuantity(investments.get(i).getQuantity(), quantity) ;
                String   paid   = investments.get(i).calculatePrice(addQuantity)  ;
                return   "You paid $" + paid + " and own " + investments.get(i).getQuantity() + " units\n" + investments.get(i).toString() ;
                
            }
            catch(  viratkohliException e  )
            {
                return   "Invalid " + e.getMessage() + " input." ;
            }
            catch(Exception e)
             {
                return  "invalid";
                }
        }
        else
        {
            int virat   = type.toLowerCase().compareTo("stock") ;;
            if( virat==  0  )
            {
                Stock   temp  ;
                try
                {
                    temp   =   new Stock(symbol, name, quantity, price)  ;
                    investments.add(temp) ;
                   }
                catch( viratkohliException e  )
                {
                    return "Invalid " + e.getMessage() + " input." ;
                   }
                catch( Exception e )
                {
                    return "Invalid ";
                   }

               }
            int virat1  =   type.toLowerCase().compareTo("mutual fund") ;;
            if ( virat1  ==0  )
            {
                MutualFund   temp ;
                try
                {
                    temp   =   new MutualFund(  symbol, name, quantity, price  );
                    investments.add(  temp  ) ;
                   }
                catch(  viratkohliException e  )
                 {
                    return "Invalid " + e.getMessage() + " input.";
                    } 
                catch(  Exception e  )
                 {
                    return "Invalid ";
                    }             
            }
            int   posn   =   investments.size()   -  1 ;;
            for(  String word: name.toLowerCase().split(" ")  )
            {
                ArrayList<Integer>  cur   =   new ArrayList<>() ;;
                if(  index.get(word)  !=   null )
                    cur   =   index.get(word)  ;
                cur.add(posn)  ;;
                index.put(word, cur)  ;;
            }
            String   paid  ;;
            Investment   temp   =   investments.get( investments.size()  -  1 ) ;;
            paid  =   temp.calculatePrice(  temp.getQuantity()  )  ;;
            return   " You paid  $ " + paid + " and own " + quantity + " units\n" + temp.toString()   ;
        }
    } 
    /** 
     * Sells shares of a stock or units of a fund that are already owned  
     */
   public String sell(String symbol, String quantity, String price)
    {
        int  i  =  0;

        boolean found   =  false ;;
        if(  investments.isEmpty()  )
        {
            return "You do not own any investments"  ;
           }

        while(  i < investments.size()  )
        {   
            if(   investments.get(i).getSymbol().equals(symbol)  )
            {
                found   = true  ;;
                break;
            }
         i++;
        }
        if(  found  )
         {
           }
        else
        {
          return  "You do not own a investment with that symbol. Please enter a new symbol"  ;
          }
        int   soldQuantity  ;;
        try
         {
            investments.get(i).setPrice(price) ;
          }
        catch(   viratkohliException e )
         {
            return  "Invalid " + e.getMessage() + " input." ;
           }
        catch( Exception e  )
         {
            return "Invalid "  ;
           }
        try 
         {
            soldQuantity    =   investments.get(i).removeQuantity(quantity)   ;
           } 
        catch (  viratkohliException ex ) 
        {
            switch (  ex.getMessage()  ) 
            {
                case "quantityt" :
                    return  "You do not own that many units." ;
                case "quantityv" :
                    return  "Quantity must be greater than zero." ;
                default:
                    return  "Invalid " + ex.getMessage() + " input" ;
                }

           }
        String    profit  =  investments.get(i).calculateProfit(soldQuantity) ;;
        String   output   =  "You received $" + profit + " and have " + investments.get(i).getQuantity() + " shares left\n" + investments.get(i).toString()  ;;
        if(  investments.get(i).getQuantity()   !=   0 )
         {
           }
        else
        {
            investments.remove(i)  ;;
            int   posn   =   0  ;;
            index.clear() ;
            for(  Investment cur: investments   )
            {
                for(  String word: cur.getName().toLowerCase().split(" ")   )
                {
                    ArrayList<Integer>  list   =   new ArrayList<>()  ;;
                    if(   index.get(word)  !=    null )
                    {
                         list   =  index.get(word)  ;;
                    }
                    list.add(posn)  ;;
                    index.put(word, list)  ;;
                }
            posn++ ;
            }
        }
       try
        {
          }
       catch(Exception e)
        {
           return "invalid";
          }
       try
        {
          }
       catch(Exception e)
        {
           return "invalid";
          }

        return   output  ;
    }
    /**
     * Calculate the profit that would be many if all the investment were sold at the current prices
     */
    public String[] getGain()
    {
        double   totalGain = 0;
        double   fg;
        String  gain  = "";

        String   temp  ;;
        int  i =  0;
        while(  i  <  investments.size()  )
        {
            fg   =  investments.get(i).getGain() ;;
            temp   =   String.format("%.2f", fg) ;;
            gain    =  gain  +     "The gain of "  + investments.get(i).getSymbol() + " is $" + temp + "\n"   ;;
            totalGain   = totalGain  +  fg   ;;
          i++ ;
        }
         try
          { 

            }
        catch(Exception e)
          {
 
            }
        String   stotalGain   =   String.format("$%.2f", totalGain)  ;;

        String[]    output   =  {gain, stotalGain} ;
        return   output  ;
    }

    /**
     * Searches all the investments for a symbol, and/or price range, and/or keywords in the name inputed by the user
     */
 public String search(String symbol, String keywords, String lowPrice, String highPrice) 
  {
         boolean   match  =  true ;  
         boolean found   = false ;
         double   hPrice  =  0.0  ;
         double   lPrice =  0.0  ;;
         String   output   =   ""  ;;
        

        if( !lowPrice.isEmpty () )
        {
             try
            {
                lPrice   =   Double.parseDouble  (lowPrice) ;
            }
            catch(  NumberFormatException  e  )
            {
                return   " Invalid low price input\n " ;
            }
            catch(  Exception  e )
             {
                }        
          }
        else
        {
           lPrice   =  0 ;
          }
        if(  !highPrice.isEmpty ()  )
        {
            try
            {
               hPrice   =   Double.parseDouble  (highPrice)  ;
              }
            catch(  NumberFormatException  e)
            {
                 return  " Invalid high price input\n " ;
               }
            catch(  Exception  e )
             {
                } 
          }
        else
        {
           hPrice   =   Double.POSITIVE_INFINITY  ; 
          }
        if(   lPrice  >  hPrice )
        {  
            return  " Low price must be lower than high price.\n" ;      
        }
        if(  hPrice < 0 ||  lPrice < 0 )
        {
             return  "Prices myst be higher than zero.\n"  ;
           }
       
            // splitting into array
        String[]   words   =   keywords.toLowerCase ().split (" ")  ;

        if(  !words[0].isEmpty () )
        {
            ArrayList < Integer >  removeList   =   new ArrayList<> ()  ;;
            ArrayList <  Integer >   searchList =   new ArrayList<>()  ;
            if(  index.get(words[0])   ==   null  )
            {
                return   "No investments were found\n" ;
               }
            searchList.addAll( index.get (words[0]) )  ;

            for(  String word:  words  )
            {
                if(  index.get  (word)   ==   null  )
                {
                    return   "No investments were found\n"  ;
                  }
                for (int x : searchList) 
                {
                    if(  !index.get(word).contains (x)  )
                    {
                          removeList.add (x)  ;
                       }
                }
            }
           for(  int x   :  removeList  )
            {
                if (  searchList.contains (x)  )  
                    searchList.remove  (( Object) x) ;
            }
            for(  int  x  :  searchList  )
            {
                Investment   dhoni   =   investments.get  (x)  ;
                if(  symbol.equals  ( dhoni.getSymbol () )  ||  symbol.isEmpty ()  )
                {
                   match   =   dhoni.getPrice  ()  >=  lPrice  &&   dhoni.getPrice  ()  <=  hPrice  ;;
                  }
                if(  symbol.isEmpty () )
                 {
                    }
               
                else
                 {
                    match  =  false  ;
                   }
                if(  match  )
                {
                    output   =  output   +  dhoni.toString ()  +  "\n"   ;;
                    found   =  true  ;
                   }
             }
        }
       else
         {
            for(  Investment  dhoni  :   investments  )
            {
                if(  symbol.equals  (  dhoni.getSymbol () ) ||  symbol.isEmpty()   )
                {
                    match   =   dhoni.getPrice ()   >=  lPrice  &&  dhoni.getPrice ()  <=  hPrice  ;;
                   }
                else
                {
                   match  =  false  ;
                  }
                if(  match  )
                {
                    output   =   output   +  dhoni.toString ()  +  "\n"  ;
                    found   =   true  ;
                  }
            }
        }
        
       if(!found)
        {
            return  "No investments 12 were found\n"  ;
          }
        return   output  ;
    }
    
    /**
     * A function for converting an investment to a string
     */
    @Override
    public   String  toString ()
    {
        String  port   =   ""  ;;
        for (  Investment  cur :  investments  )
        {
            port   =  port  +   cur.toString  ()  ;
          }
        return  port  ;
       }
    /**
     * A function used to print error message
     */
    public  void  toString1  ()
    {
          System.out.println( "Error" )  ;;
       }
    
    /**
     * Returns the symbols of all the investments
     */
    public  ArrayList<String>   getSymbols  ()
    {
        ArrayList  < String >  symbols  =  new ArrayList<> ()  ;

        for(   Investment  dhoni  :  investments  )
        {
            symbols.add  (  dhoni.getSymbol () )  ;
          }
        
        return  symbols  ;
        }
   /**
     * A function used to print error message
     */

   public  void  getSymbols1 ()
    {
       System.out.println( " Error" )  ;

        }
 
    /**
     * Returns the names of all the investments
     */
    public  ArrayList< String>  getNames  ()
    {
         ArrayList < String >  names   =   new ArrayList<> () ;
        for  (  Investment  dhoni  :  investments )
        {
             names.add ( dhoni.getName () ) ;
           }
        
        return  names  ;
       }
     /**
     * used to print error 
     */

    public  void  getNames1 ()
    {
       System.out.println ( "Error")  ;
       }
   
    /**
     * Returns the prices of all the investments
     */
    public  ArrayList <Double>   getPrices ()
    {
        ArrayList <  Double >   prices  =  new ArrayList<>() ;
        for ( Investment   dhoni :   investments )
        {
            prices.add  (  dhoni. getPrice () ) ;
          } 
        return   prices ;   
       }
    /**
     * prints error
     */

    public void   getPrices1 ()
    {
        System.out.println ( "Error" ) ;
       }
    
    /**
     * Returns the quantities of all the investments
     */
    public  ArrayList<Integer >  getQuantities ()
    {
        ArrayList <  Integer >  quantities  =  new ArrayList <> () ;

        for ( Investment  dhoni  :   investments  )
        {
            quantities.add  ( dhoni.getQuantity () ) ;
          }
        
        return  quantities  ;   
        }
    /**
     * prints error
     */

    public  void  getQuantities1 ()
    {
       System.out.println ( "Error" ) ;   
        }

    
     /**
     * Returns the book values of all the investments
     */
    public  ArrayList < Double >   getBookVals ()
    {
        ArrayList< Double >  bookVals   =   new  ArrayList <> () ;
        for(  Investment   dhoni  :  investments )
        {
             bookVals.add ( dhoni.getBookValue () )  ;
        }
        
        return   bookVals  ;   
       }
     /**
     * prints error
     */

    public   void  getBookVals1 ()
    {
       System.out.println( "Error" ) ;   
        }

    
}

public class ePortfoilo 
{    
    public static void main(String[] args) 
    {
        String  test[]   =  {}  ;
        GUI  viratk  ;

        if(  ! Arrays.equals (args, test) )
        {
            viratk  =   new GUI(args[0])  ;   
          }
        else
        {
           viratk   =  new GUI ("")  ;
           }
        
        viratk.setVisible (true)  ;
   }
    
}