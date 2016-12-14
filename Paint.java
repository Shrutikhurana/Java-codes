import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;


class mycanvas extends Canvas
{
 painti all;
 Color c1;
 BufferedImage buffimage=null;

 mycanvas(painti all)
 {
  //this.setBackground(Color.WHITE);
//  setBackground(Color.RED);
  
 this.all=all;
 }
 
 
 public void paint(Graphics g)
 {

  Graphics2D g2d=(Graphics2D)g;
  
  g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

  int w = this.getWidth();
  int h = this.getHeight();



  if(buffimage==null)
  {
   buffimage=(BufferedImage)this.createImage(w,h);

   Graphics2D g2=buffimage.createGraphics();

  }

  
  
  g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 


 g2d.drawImage(buffimage,null,0,0);



 if(all.flag==1)
 {
  Graphics2D gp=buffimage.createGraphics();
  gp.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
  gp.setColor(c1);  

  gp.drawLine(all.my.x , all.my.y ,all.my.x, all.my.y );    
 }

  

 else
 drawstate(g2d);
  
 }

  void drawstate(Graphics2D g)
  {  
   g.setColor(c1);   

  if(all.flag==1) //pen                                
  {g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     g.drawLine(all.my.x , all.my.y ,all.my.x, all.my.y );    }


  if(all.flag==2) //line
  { g.drawLine(all.my.x0 , all.my.y0 ,all.my.x, all.my.y );   }


  if(all.flag==3) //Rectangle
  {  g.drawRect(all.my.x0,all.my.y0,Math.abs(all.my.x-all.my.x0),Math.abs(all.my.y-all.my.y0));              }
  

  if(all.flag==4) //Oval
  {  g.drawOval(all.my.x0,all.my.y0,Math.abs(all.my.x-all.my.x0),Math.abs(all.my.y-all.my.y0));  }
  

    
  if(all.flag==5) //Filled Rectangle
  {  g.fillRect(all.my.x0,all.my.y0,Math.abs(all.my.x-all.my.x0),Math.abs(all.my.y-all.my.y0));   }  


  if(all.flag==6) //Filled Oval
  {  g.fillOval(all.my.x0,all.my.y0,Math.abs(all.my.x-all.my.x0),Math.abs(all.my.y-all.my.y0)); }

  
  
  }


}


//////////////////////////////////////////////////////////////////////////////////


class painti extends JFrame implements ActionListener
{
          
 JLabel jl[];                  //3
 static JTextField jtf[];      //3
 JButton jb[];                 //7

 mycanvas m;                   // object of mycanvas
 myml my;                      // object of myml
 
 int flag;                     // draw controller

 String capl[]={"Color Mode","Tool Mode","Cursor"};
 String capb[]={"Color Chooser","Pen","Line","Rectangle","Oval","Filled  Rectangle","Filled Oval"};

 painti()
 {
  int i;
  jl=new JLabel[3];
  jtf=new JTextField[3];
  jb=new JButton[8];
 
  setLayout(null); 
 
  for(i=0;i<3;i++)
  {
   jl[i]=new JLabel(capl[i]);
   jl[i].setBounds(300*(i+1)+100,30,170,100);
   add(jl[i]);  

   jtf[i]=new JTextField("NONE");
   jtf[i].setBounds(300*(i+1),20,200,50);  
   add(jtf[i]);
  }
 
  for(i=0;i<7;i++)
  {
   jb[i]=new JButton(capb[i]);
   jb[i].setBounds(20,80*(i+1),130,50);
   add(jb[i]);
   jb[i].addActionListener(this);
  }

  jb[7]=new JButton("Clear Canvas");
  jb[7].setBounds(20,10,130,50);
  add(jb[7]);
  jb[7].addActionListener(this);  


  m=new mycanvas(this);   // m is rid of mycanvas
  my=new myml(this);      // my is rid of mouse listener 

  m.addMouseMotionListener(my);
  m.addMouseListener(my);
  m.setBackground(Color.WHITE);
  m.setBounds(200,130,1100,500);   


  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  setVisible(true);
  setSize(400,400);
  add(m);
 }



public void actionPerformed(ActionEvent ae)
 {

  if(ae.getSource()==jb[0])
  {     
     jtf[1].setText("Color Chooser");

   Color bgColor = JColorChooser.showDialog(this, "Choose Background Color",this.getBackground());
   if(bgColor != null)
   {
    //getContentPane().setColor(bgColor);
    m.c1=bgColor;
     
   }
   jtf[0].setText(bgColor.toString());
  }


  if(ae.getSource()==jb[1])
  {
   flag=1;
   System.out.println("Pen");
   jtf[1].setText("Pen");   
  }

  if(ae.getSource()==jb[2])
  {
   flag=2;
   System.out.println("Line");
   jtf[1].setText("Line");   
  
  }
 
  if(ae.getSource()==jb[3])
  {
   flag=3;
   System.out.println("Rectangle");
   jtf[1].setText("Rectangle");   
   
 }
   
  if(ae.getSource()==jb[4])
  {
   flag=4;
   System.out.println("Oval");
   jtf[1].setText("Oval");   
    
}

  if(ae.getSource()==jb[5])
  {
   flag=5;
   System.out.println("Filled Rectangle");
   jtf[1].setText("Filled Rectangle");   
  
  }

  if(ae.getSource()==jb[6])
  {
   flag=6;
   System.out.println("Filled Oval");
   jtf[1].setText("Filled Oval");   
  
  }

  if(ae.getSource()==jb[7])
  {
   flag=7;
   jtf[1].setText("Clear Canvas");   
      
   System.out.println("Canvas clear"); 
   m.buffimage=null;
   m.repaint();    
  
 
  }



 }

 public static void main(String[] args)
 {
  new painti();
 
 }

}



//////////////////////////////////////////////////////////////////////////////////////////////
class myml extends MouseAdapter
{
  painti all;
  int x0,y0,x,y;
  int rel=0;

  
  myml(painti all)
  {
  this.all=all;
  }


  public void mouseReleased(MouseEvent e)
  {
   rel=1;
   all.m.drawstate(all.m.buffimage.createGraphics());
 
  }
 
 
  public void mousePressed(MouseEvent e)
  {
    x0=e.getX();  y0=e.getY();
    }
  

  public void mouseMoved(MouseEvent e)
  {
  all.jtf[2].setText("Mouse Moved:"+e.getX()+", "+e.getY());
  }

  public void mouseDragged(MouseEvent e)
  {
    
   x=e.getX();  y=e.getY();
   all.jtf[2].setText("Mouse Dragged:"+e.getX()+", "+e.getY());
  
  
   all.m.repaint();        //Figure drawn with this    
   
  
 
   }
  

}


/////////////////////////////////////////////////////////////////////////////////////////////////////











