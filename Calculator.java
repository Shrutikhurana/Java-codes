import java.awt.*;
import java.awt.event.*;
/*This comment is added by yukti */

class cal extends WindowAdapter implements ActionListener
{
 Frame f;
 TextField tf;
 Button b[]; 
 String cap[]={"7","8","9","*","4","5","6","/","1","2","3","-","0","=",".","+"};
 int temp=0,val=0;
 int eq=0;
 int fl=0;
 String s=new String();
 String s1=new String(); 
 
cal()
{
  int i,j,t;
  f=new Frame("My Calculator");
  f.setSize(400,400);
  f.setLayout(null);
  f.setVisible(true);
 
  tf=new TextField();
  tf.setBounds(40,40,320,40);
  f.add(tf);
  f.addWindowListener(this);  
 
  b=new Button[16];
  t=0;
  for(i=0;i<4;i++)
  {
   for(j=0;j<4;j++)
    {
     b[t]=new Button(cap[t]);
     b[t].setBounds(40+j*90,100+70*i,50,50);
     f.add(b[t]);
     b[t].addActionListener(this); 
     t++;
    }
  } 
}
 

void cal(String t)
{
  int a=0,b=0,c=0,i,j,k,r;
  float af=0.0f,bf=0.0f,cf=0.0f;

  System.out.println("entered");

 for(i=0;i<t.length();i++)
  {
   if(t.charAt(i)=='+' || t.charAt(i)=='-' || t.charAt(i)=='*' || t.charAt(i)=='/')
   break;
  } 

if(t.charAt(0)=='-')
{
  for(r=1;r<t.length();r++)
  {
   if(t.charAt(r)=='+' || t.charAt(r)=='-' || t.charAt(r)=='*' || t.charAt(r)=='/')
   break;
  }
  System.out.println("r is" +r);
  if(fl==1)
  af=Float.parseFloat(t.substring(0,r));
  else
  a=Integer.parseInt(t.substring(0,r));
 System.out.println("$"+a);

  j=r;
  System.out.println("j is "+j);  
  if(fl==1)
  bf=Float.parseFloat(t.substring(r+1,t.length()-1));
  else
  b=Integer.parseInt(t.substring(r+1,t.length()-1));


} 



else
{
  if(fl==1)
  af=Float.parseFloat(t.substring(0,i));
  else
  a=Integer.parseInt(t.substring(0,i));
  
  j=i;
  System.out.println("j is "+j);  
  if(fl==1)
  bf=Float.parseFloat(t.substring(i+1,t.length()-1));
  else
  b=Integer.parseInt(t.substring(i+1,t.length()-1));

}
System.out.println("a is"+a);
System.out.println("b is"+b);

//  j=i;
  

  if(t.charAt(j)=='+')
  { 
   if(fl==1)
   cf=af+bf;
   else
   c=(a)+(b);
System.out.println("c is"+c);  }

  if(t.charAt(j)=='-')
  { 
   if(fl==1)
   cf=af-bf;
   else
   c=(a)-(b); 
System.out.println("c is"+c);  } 


  if(t.charAt(j)=='*')
  { 
   if(fl==1)
   cf=af*bf;
   else
   c=(a)*(b); 
System.out.println("c is"+c);  }  

  if(t.charAt(j)=='/')
  {
   if(fl==1)
   cf=af/bf;
   else 
   c=(a)/(b); 
System.out.println("c is"+c);
  }



if(fl==1)
s=cf+t.substring(t.length()-1); 
else 
s=c+t.substring(t.length()-1);



if(eq==1)
{
s=s.substring(0,s.length()-1);
//System.out.println(s);
}

 temp=1;
 tf.setText(s);

}

 public void actionPerformed(ActionEvent ae)
 {

  if(ae.getSource()==b[0])       {   s=s+cap[0];        }
  else if(ae.getSource()==b[1])  {   s=s+cap[1];        }
  else if(ae.getSource()==b[2])  {   s=s+cap[2];        }
  else if(ae.getSource()==b[3])  {   s=s+cap[3]; temp++;/*System.out.println(s.length());*/} 
  else if(ae.getSource()==b[4])  {   s=s+cap[4];        }
  else if(ae.getSource()==b[5])  {   s=s+cap[5];        }
  else if(ae.getSource()==b[6])  {   s=s+cap[6];        }
  else if(ae.getSource()==b[7])  {   s=s+cap[7];temp++;/*System.out.println(temp);*/ }
  else if(ae.getSource()==b[8])  {   s=s+cap[8];        }
  else if(ae.getSource()==b[9])  {   s=s+cap[9];        }
  else if(ae.getSource()==b[10]) {   s=s+cap[10];       }
  else if(ae.getSource()==b[11]) {   s=s+cap[11];/*System.out.println("*"+s.length());*/if(s.length()>1)temp++;/*System.out.println(temp);*/ }
  else if(ae.getSource()==b[12]) {   s=s+cap[12];       }
  else if(ae.getSource()==b[13]) {   s=s+cap[13];  eq=1; cal(s); temp=0; eq=0;}
  else if(ae.getSource()==b[14]) {   s=s+cap[14];fl=1;  }
  else if(ae.getSource()==b[15]) {   s=s+cap[15];temp++;/*System.out.println(temp); */}

 tf.setText(s);
//System.out.println("temp is" + temp);
 if(temp==2) 
  cal(s);
 }

 public void windowClosing(WindowEvent we)
 {
  System.exit(0);
 }

public static void main(String[] args)
{
 new cal();
}


}