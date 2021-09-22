import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

/*tick tock*/
class second extends Thread
{
 clock3 c;
 second(clock3 c)
 {
  this.c=c;
 }

 public void run()
 {

  while(c.flag!=-2)
  {
/*   if(c.m.sec==60)
   {
    c.m.min++;
    c.m.repaint();
    c.m.sec=0;
   
   }

  if(c.m.min==60)
   {
    c.m.hr++;
    c.m.repaint();
    c.m.min=0;
   
   }

*/
    c.m.sec++;
    c.m.min=c.m.min+(1/(double)60);
    c.m.hr=c.m.hr+(1/(double)(60*60));
  //  System.out.println(c.m.sec+" "+c.m.min+" "+c.m.hr); 

    c.m.repaint();
  

  try{Thread.sleep(1000);} catch(Exception e){}

      
   run();
  }

 }


}



class minute extends Thread
{
 clock3 c;
 minute(clock3 c)
 {
  this.c=c;
 }

 public void run()
 {
System.out.println("in minute  ");
  while(c.flag!=-2)
  {
  
  if(c.m.sec==60)
{
  c.m.min=c.m.min+1;  
  c.m.repaint();
  c.m.sec=0; 
 }
  if(c.m.min%60==0)
  {
   c.ht.start();
  } 

  }
 }

 
}


class hour extends Thread
{
 clock3 c;
 hour(clock3 c)
 {
  this.c=c;
 }

 public void run()
 {
System.out.println("in hour ");

  while(c.flag!=-2)
 {
  if(c.m.min==60)
 {
  c.m.hr=c.m.hr+1;  
  
  c.m.repaint();
 c.m.min=0; 

 }
 }

 }
}



class clock3 extends JFrame 
{
 my m;
 String s;

// JLabel jb[];
 String cap[]={"12",".",".",".",".","1",".",".",".",".","2",".",".",".",".","3",".",".",".",".","4",".",".",".",".","5",".",".",".",".","6",".",".",".",".","7",".",".",".",".","8",".",".",".",".","9",".",".",".",".","10",".",".",".",".","11",".",".",".",".",}; 
 int i;


 second st;
 minute mt;
 hour ht;

 JLabel jb[];

 JLabel jl[];
 
 disp d;
 int flag=-1;
 
 clock3()
 {
 
 

 m=new my(this);
 st=new second(this);
 mt=new minute(this);
 ht=new hour(this);



 setUndecorated(true);
 setShape(new Arc2D.Double(new Rectangle2D.Double(0,0,500,500),90,360,Arc2D.PIE));
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setSize(500,500);


 setVisible(true);

 

 Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
 int x = (int) ((dimension.getWidth()-this.getWidth()) );
 int y = (int) ((dimension.getHeight()-this.getWidth()) );

 System.out.println(dimension.getWidth()+" "+dimension.getHeight());
 setLocation(x/2,y/2);



// jb[0].setBounds(240,240,20,20); //Center coordinates
 


 jl=new JLabel[3];

  
 jl[0]=new JLabel("Hour");
 jl[0].setBounds(240,320,60,40);
 jl[0].setForeground(Color.BLACK);
 add(jl[0]);
 
 jl[1]=new JLabel("Minute");
 jl[1].setBounds(240,320+30,60,40);
 jl[1].setForeground(Color.BLUE);
 add(jl[1]);
 
 jl[2]=new JLabel("Second");
 jl[2].setBounds(240,320+60,60,40);
 jl[2].setForeground(Color.RED);
 add(jl[2]);
 





 
 jb=new JLabel[60];

 int x0=250, y0=250;

 for(i=0;i<60;i++)
 {
 jb[i]=new JLabel(cap[i]);
 }





 

 jb[0].setBounds(x0+(int)(250*Math.sin(180*Math.PI/180))-10,y0+(int)(250*Math.cos(180*Math.PI/180)),20,20);
 
 int l=174;
 for(i=1;i<=4;i++)
 {
 jb[i].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180)),y0+(int)(250*Math.cos(l*Math.PI/180))-10,20,20);
 l=l-6;
 }

 jb[5].setBounds(x0+(int)(250*Math.sin(152*Math.PI/180)),y0+(int)(250*Math.cos(152*Math.PI/180)),20,20);

 l=144+1;
 for(i=6;i<=9;i++)
 {
  jb[i].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180)),y0+(int)(250*Math.cos(l*Math.PI/180))-10,20,20);
  l=l-6;
 }

 l=120; 
 jb[10].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-10,y0+(int)(250*Math.cos(l*Math.PI/180))-10,20,20);
 
 l=l-6+1;
 for(i=11;i<=14;i++)
 {
  jb[i].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-5,y0+(int)(250*Math.cos(l*Math.PI/180))-10,20,20);
  l=l-6;
 }

 l=90;
 jb[15].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-10,y0+(int)(250*Math.cos(l*Math.PI/180))-10,20,20);
 

 l=l-6+1;
 for(i=16;i<=19;i++)
 {
  jb[i].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-10,y0+(int)(250*Math.cos(l*Math.PI/180))-10,20,20);
  l=l-6;
 }

 l=60;
 jb[20].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-12,y0+(int)(250*Math.cos(l*Math.PI/180))-15,20,20);

 l=l-6+1;
 jb[21].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-10,y0+(int)(250*Math.cos(l*Math.PI/180))-13,20,20);

 l=l-6+1;
 jb[22].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-12,y0+(int)(250*Math.cos(l*Math.PI/180))-10,20,20);

 l=l-6+1;
 jb[23].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-14,y0+(int)(250*Math.cos(l*Math.PI/180))-8,20,20);

 l=l-6+1;
 jb[24].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-15,y0+(int)(250*Math.cos(l*Math.PI/180))-8,20,20);


 l=30;
 jb[25].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-10,y0+(int)(250*Math.cos(l*Math.PI/180))-18,20,20);


 l=24;
 jb[26].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-3,y0+(int)(250*Math.cos(l*Math.PI/180))-16,20,20);

 l=18;
 jb[27].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-3,y0+(int)(250*Math.cos(l*Math.PI/180))-16,20,20);

 l=12;
 jb[28].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-3,y0+(int)(250*Math.cos(l*Math.PI/180))-16,20,20);
 
 l=6;
 jb[29].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-3,y0+(int)(250*Math.cos(l*Math.PI/180))-16,20,20);

 l=0;
 jb[30].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-5,y0+(int)(250*Math.cos(l*Math.PI/180))-20,20,20);


 l=-6;
 for(i=31;i<=39;i++)
 {
 jb[i].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))+3,y0+(int)(250*Math.cos(l*Math.PI/180))-20,20,20);
 l=l-6;
 }

 
 jb[40].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))+3,y0+(int)(250*Math.cos(l*Math.PI/180))-15,20,20);
 l=l-6;


 for(i=41;i<50;i++)
 {
 if(i!=45)
 jb[i].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))+3,y0+(int)(250*Math.cos(l*Math.PI/180))-15,20,20);
 l=l-6;
 }

 l=-90;
 jb[45].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))+3,y0+(int)(250*Math.cos(l*Math.PI/180))-12,20,20);

 l=-120;
 jb[50].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))+3,y0+(int)(250*Math.cos(l*Math.PI/180))-5,20,20);



 l=-120-6; 
 for(i=51;i<=54;i++)
 {
 
 jb[i].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180)),y0+(int)(250*Math.cos(l*Math.PI/180))-10,20,20);
 l=l-6;
 }

 for(i=55;i<60;i++)
 {
 jb[i].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180)),y0+(int)(250*Math.cos(l*Math.PI/180))-8,20,20);
 l=l-6;
 }

 l=-150;
 jb[55].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-5,y0+(int)(250*Math.cos(l*Math.PI/180)),20,20);
 
 
 //jb[i].setBounds(x0+(int)(250*Math.sin(l*Math.PI/180))-5,y0+(int)(250*Math.cos(l*Math.PI/180)),20,20);
 
// jb[45].setBounds(230,480,20,20); //Center coordinates


 
 
 


 for(i=0;i<60;i++)
 {
 add(jb[i]);
 }  

   
/*
 jb[0]=new JLabel(cap[0]);
 jb[0].setBounds(240,0,20,20); //Center coordinates
 add(jb[0]);

 jb[5]=new JLabel(cap[5]);
 jb[5].setBounds(490,240,20,20); //Center coordinates
 add(jb[5]);

 jb[10]=new JLabel(cap[10]);
 jb[10].setBounds(230,480,20,20); //Center coordinates
 add(jb[10]);

 jb[15]=new JLabel(cap[15]);
 jb[15].setBounds(10,240,20,20); //Center coordinates
 add(jb[15]);
*/


 
 
 


//add(m);

//  m.setOpaque(true); 
//  m.setBackground(Color.BLACK);

   m.repaint();
   st.start();
//   mt.start(); 
//   ht.start();






 }

 public static void main(String[] args) throws Exception
 {
  new clock3();

 }

}


class my extends JComponent//Canvas
{
 clock3 c;
 double hr,min,sec;
 String s;
 int t=1; 
 JLabel jl[];

 my(clock3 c)
 {
  this.c=c;
  c.add(this);
  //setBackground(Color.YELLOW);


 }
 
 public void paint(Graphics g)
 {
   if(t==1)
   {
   Date date=new Date();
   s=date.toString();
   hr=Integer.parseInt(s.substring(11,13));
   min=Integer.parseInt(s.substring(14,16));
   sec=Integer.parseInt(s.substring(17,19));


   min=min+(sec/(double)60);
   hr=hr+(min/(double)(60*60));
  


   t=2;
   }   
   setSize(c.getWidth(),c.getHeight());  


   Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
   int x = (int) ((getWidth())/2 );
   int y = (int) ((getHeight())/2);

   g.setColor(Color.ORANGE);
   g.drawOval(240,240,20,20);
   g.drawOval(190,190,120,120);


    //Seconds
    double angle=180-(360*sec/60);
  //  System.out.println(angle);
    angle=angle*Math.PI/180;
    g.setColor(Color.RED);
    g.drawLine(x,y,x+(int)(250*Math.sin(angle)),y+(int)(250*Math.cos(angle)));
   

   //Minutes
    double angle1=180-(360*min/60);
  //  System.out.println("minute angle"+angle1);
    angle1=angle1*Math.PI/180;
    g.setColor(Color.BLUE);
    g.drawLine(x,y,x+(int)(250*Math.sin(angle1)),y+(int)(250*Math.cos(angle1)));
   
    
   //Hours
    if(hr>12)
    hr=hr-12;
    double angle2=180-(30*hr);
 //   System.out.println("minute angle"+angle1);
    angle2=angle2*Math.PI/180;
    g.setColor(Color.BLACK);
    g.drawLine(x,y,x+(int)(250*Math.sin(angle2)),y+(int)(250*Math.cos(angle2)));

   
  
 }

}

