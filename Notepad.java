import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.undo.*;


class n3 implements ActionListener 
{
 JTextArea jtf; 
 JScrollPane jsp;
 JFrame jf;
 JFrame jf1;
 JFrame jf2;
 JFrame jf3;
 JFrame jf4;
 JFrame jf5;

 int t=0;
 
 Font font;  
 
 JLabel jl1;
 JTextField jtf1;
 JButton jb1[]=null;


 JLabel jl2[];
 JTextField jtf2[];
 JButton jb2[];

 JLabel jl3;
 JTextField jtf3;
 JButton jb3;

 JLabel jl4;

 JLabel jl5[]; // Font ,Font Style,Size
 String c1[]={}; GraphicsEnvironment ge=null;
 String c2[]={"Font.BOLD","Font.ITALIC"};
 String c3[]={"10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};

 JComboBox jcb[];//3
 JButton jb5;//3



 UndoManager undomanager=null;
 
 Highlighter highlighter=null; 
 
 controller c;

 JMenuBar menuBar;
 JMenu menu,menu1,menu2,menu3;
 JMenuItem menuItem[],menuItem1[],menuItem2,menuItem3;
 
 String s[]={"New","Open","Save","Save As","Exit"};  
 String s1[]={"Undo","Redo","Cut","Copy","Paste","Find","Replace","Go To"};

 int key[]={KeyEvent.VK_N,KeyEvent.VK_O,KeyEvent.VK_S,KeyEvent.VK_Q,KeyEvent.VK_E};
 int key1[]={KeyEvent.VK_Z,KeyEvent.VK_U,KeyEvent.VK_C,KeyEvent.VK_C,KeyEvent.VK_P,KeyEvent.VK_F,KeyEvent.VK_R,KeyEvent.VK_G};
 

 n3()
 {
 int i;

 
   jf=new JFrame();


   jf1=new JFrame("Find");
   jl1=new JLabel("Find what:");
   jtf1=new JTextField();
   
   jb1=new JButton[2];
   jb1[0]=new JButton("Find Next"); 
   jb1[1]=new JButton("Cancel"); 
   
   jf1.setSize(350,150);
   jl1.setBounds(10,10,60,20);   
   jtf1.setBounds(100,10,200,20);
   jb1[0].setBounds(10,50,100,25);
   jb1[1].setBounds(130,50,100,25);

   jb1[0].addActionListener(this);
   jb1[1].addActionListener(this);
     

   jf1.add(jl1);
   jf1.add(jtf1);
   jf1.add(jb1[0]);
   jf1.add(jb1[1]); 




   jf2=new JFrame("Replace");

   jl2=new JLabel[2];
   jl2[0]=new JLabel("Find what:");
   jl2[1]=new JLabel("Replace with:");
 
   jtf2=new JTextField[2];
   jtf2[0]=new JTextField();    
   jtf2[1]=new JTextField();

   jb2=new JButton[2];
   jb2[0]=new JButton("replace"); 
   jb2[1]=new JButton("close"); 
   
   jf2.setSize(350,150);
   
   jl2[0].setBounds(10,10,80,20);
   jl2[1].setBounds(10,40,80,20);   
   
   jtf2[0].setBounds(100,10,200,20);
   jtf2[1].setBounds(100,40,200,20);
 
   jb2[0].setBounds(10,80,100,20);
   jb2[1].setBounds(130,80,100,20);

   jb2[0].addActionListener(this);
   jb2[1].addActionListener(this);

   jf2.setLayout(null);     

   jf2.add(jl2[0]); jf2.add(jl2[1]);
   jf2.add(jtf2[0]);   jf2.add(jtf2[1]);
   jf2.add(jb2[0]);
   jf2.add(jb2[1]); 




   jf3=new JFrame("Go To Line");
   jl3=new JLabel("Line Number");
   jtf3=new JTextField();
    jtf3.setText("0");   

   jb3=new JButton("Go To");

   jf3.setSize(350,150);
   jl3.setBounds(10,10,80,20);
   jtf3.setBounds(100,10,200,20);
   jb3.setBounds(10,80,100,20);


   jb3.addActionListener(this);  

   jf3.setLayout(null);
   jf3.add(jl3);
   jf3.add(jtf3);
   jf3.add(jb3);
  


   jf4=new JFrame("About");
   jl4=new JLabel("              This is a simple notepad made by Shruti"); 
   
   jf4.setSize(350,150);
   jl4.setBounds(0,0,300,100);
   
   jf4.add(jl4);
   jf4.setLayout(null);
   




   jf5=new JFrame("Font");

   jl5=new JLabel[3];
   jl5[0]=new JLabel("Font");
   jl5[1]=new JLabel("Font Style");
   jl5[2]=new JLabel("Size");
   
   ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
   c1=ge.getAvailableFontFamilyNames();
   
   jcb=new JComboBox[3];
   jcb[0]=new JComboBox(c1);
   jcb[1]=new JComboBox(c2);
   jcb[2]=new JComboBox(c3);

   for(int k=0;k<3;k++)
   jcb[k].addActionListener(this);

   jb5=new JButton("Set");
  
   jf5.setSize(550,200); 
   jl5[0].setBounds(20,20,50,50);
   jl5[1].setBounds(200,20,150,50);
   jl5[2].setBounds(380,20,150,50);
   jb5.setBounds(20,120,100,20);
   jb5.addActionListener(this);

   jcb[0].setBounds(20,50,150,20);
   jcb[1].setBounds(200,50,150,20);
   jcb[2].setBounds(380,50,150,20);
 

   jf5.add(jl5[0]);
   jf5.add(jl5[1]);
   jf5.add(jl5[2]);

   jf5.add(jcb[0]);
   jf5.add(jcb[1]);
   jf5.add(jcb[2]);
   jf5.add(jb5);      

   



  menuBar = new JMenuBar();
  
  menu = new JMenu("File");
  menuBar.add(menu);
  
  menuItem=new JMenuItem[5];
  for(i=0;i<5;i++)
  {
   menuItem[i] = new JMenuItem(s[i],key[i]);
   menuItem[i].setAccelerator(KeyStroke.getKeyStroke(key[i], ActionEvent.CTRL_MASK));
   menuItem[i].addActionListener(this);
   menu.add(menuItem[i]);
   menu.addSeparator();
  }
  

  menu1 = new JMenu("Edit");
  menuBar.add(menu1);
 
  menuItem1=new JMenuItem[8];
  for(i=0;i<8;i++)
  {
   menuItem1[i] = new JMenuItem(s1[i],key1[i]);
   menuItem1[i].setAccelerator(KeyStroke.getKeyStroke(key1[i], ActionEvent.CTRL_MASK));
   menuItem1[i].addActionListener(this);
   menu1.add(menuItem1[i]);
   menu1.addSeparator();
  }


   menu2 = new JMenu("Format");
   menuBar.add(menu2);
 
   menuItem2=new JMenuItem();
   menuItem2 = new JMenuItem("Font",KeyEvent.VK_F);
   menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
   menuItem2.addActionListener(this);
   menu2.add(menuItem2);
   menu2.addSeparator();
  

   menu3 = new JMenu("Help");
   menuBar.add(menu3);
 
   menuItem3=new JMenuItem();
   menuItem3 = new JMenuItem("About",KeyEvent.VK_H);
  // menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_, ActionEvent.CTRL_MASK));
   menuItem3.addActionListener(this);
   menu3.add(menuItem3);
   menu3.addSeparator();
  

   jtf=new JTextArea();
   jtf.setBounds(0,0,1500,1000);
   jsp=new JScrollPane(jtf);


  jf.add(jsp);
//  jf.add(jtf);
   

  jf.setJMenuBar(menuBar);
               
  jf.setVisible(true);
  jf.setSize(400,400);
  jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 

    undomanager=new UndoManager();
    jtf.getDocument().addUndoableEditListener(undomanager);
    System.out.println(undomanager.canUndo());
 
  font=jtf.getFont();
 System.out.println(font);
 }






 public void actionPerformed(ActionEvent ae) 
 { 
  JFrame f[]=new JFrame[3];
  
  if(ae.getActionCommand()=="Exit")
  {
   System.out.println("Exit");
   jf.dispose();
  }

  
  if(ae.getActionCommand()=="Open")
  {
   JFileChooser chooser = new JFileChooser();  // open current directory
   int returnVal = chooser.showOpenDialog(jf); //replace null with your swing container

  try{
    File file=null;
       
    if(returnVal == JFileChooser.APPROVE_OPTION)     
    {
     file = chooser.getSelectedFile();    

     FileInputStream fis=new FileInputStream(file);    
     char s;
     jtf.setText("");
     int b=0;
     while(( b=fis.read()) != (-1))
     {
//    System.out.print((char)b);
      s=(char)b;
      jtf.append(s+"");    
     }

    }  
   }
  catch(Exception e){}
  }


  if(ae.getActionCommand()=="Save")  
  {
   JFileChooser chooser1 = new JFileChooser();  // open current directory
   int returnVal1 = chooser1.showSaveDialog(jf); //replace null with your swing container
   File file1;

   if(returnVal1 == JFileChooser.APPROVE_OPTION)     
   {
    try
    {
     file1=chooser1.getSelectedFile();
     FileOutputStream fos=new FileOutputStream(file1);
     String s=jtf.getText();
     byte[] b=s.getBytes();
     fos.write(b);
    }
   catch(Exception e){}       
   }

  }  

  if(ae.getActionCommand()=="Save As")  
  {
   JFileChooser chooser2 = new JFileChooser();  // open current directory
   int returnVal2 = chooser2.showSaveDialog(jf); //replace null with your swing container
   File file2;

   if(returnVal2 == JFileChooser.APPROVE_OPTION)     
   {
    try
    {
     file2=chooser2.getSelectedFile();
     FileOutputStream fos=new FileOutputStream(file2);
     String s1=jtf.getText();
     byte[] b1=s1.getBytes();
     fos.write(b1);
    }
   catch(Exception e){}       
   }

  }  


  if(ae.getActionCommand()=="Find")
  {

   jf1.setLayout(null);
   jf1.setVisible(true);
   jf1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
   
   jf1.setResizable(false);
   String sr="";
  }




   if(ae.getActionCommand()=="Find Next") // in find in edit   
   {
   System.out.println("jb");//in jtf
   System.out.println(jtf1.getText());
   
   String st=jtf.getText();
   
   highlighter=jtf.getHighlighter();
   
   HighlightPainter painter=new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);

      
   int p0=st.indexOf(jtf1.getText(),t);    

   int p1=p0+jtf1.getText().length();

   t=p1;
   System.out.println(p0+" "+p1);
 
   try{
   highlighter.addHighlight(p0,p1,painter);
      }
   catch(Exception e){}   
   }

   if(ae.getActionCommand()=="Cancel")
   {
    if(highlighter!=null)
    highlighter.removeAllHighlights();
    jf1.setVisible(false);
  
   }
   

   if(ae.getActionCommand()=="Replace")
   {
    System.out.println("In replace");
    
    jf2.setLayout(null);
    jf2.setVisible(true);
    jf2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
   
    jf2.setResizable(false);
 
   }

   if(ae.getActionCommand()=="replace")
   {
   System.out.println("Replace button pressed");
   String s1=jtf2[0].getText(); // to replace
   String s2=jtf2[1].getText(); // replace with this
  
   String s=jtf.getText();
   
   s=rep(s,s1,s2);
   jtf.setText(s); 

   }

   if(ae.getActionCommand()=="close")
   {
    jf2.setVisible(false);
  
   }


   if(ae.getActionCommand()=="Cut")
   {
    jtf.cut();
 
   }

   if(ae.getActionCommand()=="Copy")
   {
    jtf.copy();
 
   }

   if(ae.getActionCommand()=="Paste")
   {
    jtf.paste();
 
   }

  
   if(ae.getActionCommand()=="Undo")
   {
    //System.out.println("Inside undo"); 
    
    //UndoManager undomanager=new UndoManager();
    //jtf.getDocument().addUndoableEditListener(undomanager);
    //System.out.println(undomanager.canUndo());
    if(undomanager.canUndo()!=false)
    undomanager.undo();

   }


   if(ae.getActionCommand()=="Redo")
   {
    //System.out.println("Inside undo"); 
    
    //UndoManager undomanager=new UndoManager();
    //jtf.getDocument().addUndoableEditListener(undomanager);
    //System.out.println(undomanager.canUndo());
    if(undomanager.canRedo()!=false)
    undomanager.redo();
   }


   if(ae.getActionCommand()=="Go To")
   {
    int l=0;    
    System.out.println("in goto");
     
    jf3.setVisible(true);
    jf3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    jf3.setResizable(false);
   

    l=Integer.parseInt(jtf3.getText());   

    System.out.println(l);


    String rt=jtf.getText();
    
    int cnt=0,cntl=0;

    for(int i=0;i<rt.length();i++)
    {
     if(cntl==l-1)
     {
      break;
     }

     if(rt.charAt(i)=='\n')
     {
      cntl++;
     }
    cnt++;

    }

    jtf.setCaretPosition(cnt);   

  // jf3.dispose();
   }


   if(ae.getActionCommand()=="About")
   {
    System.out.println("In help");
    
    jf4.setLayout(null);
    jf4.setVisible(true);
    jf4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
   
    jf4.setResizable(false);
   }


   if(ae.getActionCommand()=="New")
   {
    System.out.println("New");
    new n3();
   }


   if(ae.getActionCommand()=="Font")
   {
    System.out.println("Font");
    jf5.setLayout(null);
    jf5.setVisible(true);
    jf5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
   
    jf5.setResizable(false);
   
   }

   if(ae.getActionCommand()=="Set")
   {
    System.out.println("Set");

    String tt=jtf.getSelectedText();
    System.out.println(tt);
   
    String co1,co22;
    int co2=-1;
    int co3;

    co1=(String)jcb[0].getSelectedItem();    

    co22=(String)jcb[1].getSelectedItem();    

    System.out.println(co22);
    if(co22=="Font.ITALIC")
    {    co2=Font.ITALIC;
         System.out.println("**"+co22);
    }
       
    if(co22=="Font.BOLD")
    {
         System.out.println("**"+co22);co2=Font.BOLD;
    }
    co3=Integer.parseInt((String)jcb[2].getSelectedItem());
      
    
  
    Font font1=new Font(co1,co2,co3);
  
        
 
    jtf.setFont(font1);
    

   }




}

  String rep(String s1,String s2,String s3)
 {
  int x,i,j;
  System.out.println(s3);
  String s5=new String();
  for(i=0;i<=s1.length();i++)
  {
   for(j=0;j<=s2.length();j++)
   {
try{ 
   if(s1.charAt(i)==s2.charAt(j))
    { System.out.println(s2.length()-1);
     if(s2.equals(s1.substring(i,i+s2.length())))
     { 
       s1=s1.substring(0,i) + s3 + s1.substring(i+s2.length());
       System.out.println(i+" "+s2.length());
       System.out.println(s1); 
       System.out.println("*"+s1.substring(0,i) +" *"+ s3 +"* " +s1.substring(i+s2.length()));
        break;
     }
    }
}
catch(Exception e){}
   }   
 
   }
  
   return s1;
 }

 public static void main(String[] args) 
 {
   new n3();
 }

}





