/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.*;
/**
 *
 * @author HP
 */
public class payment extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form payment
     */
    public payment() {
        initComponents();
        
          
      //  jDialog1.setVisible(true);
        
       jProgressBar1.setVisible(false);
        jProgressBar1.setStringPainted(true);
        setLocationRelativeTo(null);
           setTitle("Account Book 1.0");
                setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("payment.png")));
      
       
        
         String query="select * from log_dates";
        String val[]={"tdate","edate","check"};
        String get_dates[]=Finance.getValuesfromDb(query,val);
        
     // 
        String d="update log_dates set tdate=current_date;";
        Finance.executeQuery(d);
        
        
        
        
        String today_date=get_dates[0];
                String expiry_date=get_dates[1];
        
                if(expiry_date.equals("2100-01-01"))
                {
                    String update="update log_dates set edate=(SELECT date('now','7 day')),tdate=(select date('now'));";
                      Finance.executeQuery(update);
                }
        
   String dates[]=Finance.getValuesfromDb(query,val);
        //System.out.println(dates[0]+""+dates[1]);
    today_date=dates[0];
           expiry_date=dates[1];
                
                    Comparable today=(Comparable)today_date;
         Comparable expiry=(Comparable)expiry_date;
         
       
         
                        if(expiry.compareTo(today)>today.compareTo(expiry))
                        {
                            jLabel6.setText("Trail version expires on "+dates[1]);
                               jProgressBar1.setVisible(true);
                               jButton1.setVisible(false);
                               jTextField1.setVisible(false);
                               jLabel1.setText("Welcome To Account Book 1.0");
                                                              jLabel2.setVisible(false);
                               jLabel3.setVisible(false);

                            timer=new Timer(10,new bari());
             timer.start();
          int n=jProgressBar1.getValue();
            if(n<100)
            {
                n++;
                jProgressBar1.setValue(n);
            }
            else{
                timer.stop();
           //  new face().setVisible(true);
             //dispose();
            }
                        }
                        else{
  
           jLabel6.setText("");
            try
                {
                     Connection con= Finance.connecrdb();
                 String a="select * from log where id=1";
              
                    Statement st=con.createStatement();
                 
                    ResultSet rs=st.executeQuery(a);
                  String key_value="";
                  int attempt=0;
                               
                    while(rs.next())
                    {
                         key_value=rs.getString("key");
                         attempt=rs.getInt("attempt");
                        
                    }
                    String abc=Finance.matrix_revolutions_mr_anderson_neo_zenon();   
                  
                         if( key_value.equals(abc) )
                         {
                              
                           
                           
                                jProgressBar1.setVisible(true);
                               jButton1.setVisible(false);
                               jTextField1.setVisible(false);
                               jLabel1.setText("Welcome To Account Book 1.0");
                                                              jLabel2.setVisible(false);
                               jLabel3.setVisible(false);

                            timer=new Timer(10,new bari());
             timer.start();
          int n=jProgressBar1.getValue();
            if(n<100)
            {
                n++;
                jProgressBar1.setValue(n);
            }
            else{
                timer.stop();
           //  new face().setVisible(true);
             //dispose();
            }
                         }
                         else
                         {
                             
                         
                                  try
        {
          /*  String g=get_ip();
            if(g.equals("not"))
            {
                JOptionPane.showMessageDialog(this,"Please Check your Internet Connection"+"\n"+"You need Internet to Activate your software");
            }
            else{
                JOptionPane.showMessageDialog(this,"First time user detected/nPress OK to register,It may take more than 2 minutes");
            // new payment().setVisible(false); 
         //      jDialog1.setSize(800,600);
        //jDialog1.setLocationRelativeTo(null);
            // jDialog1.setVisible(true);
           
       /*       Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mobileshopdb9356", "mobileshopuser01", "9356899053");
       
        Statement stg=conn.createStatement();
        
   String get="select user from online;";
  
    ResultSet vs=stg.executeQuery(get);
    int z=0;
    while(vs.next())
    {
        z=vs.getInt("user");
    }
    int user=z+1;
   //  String slm="insert into online value('"+abc+"',curdate(),curtime(),'"+user+"','"+g+"','Mobile shop');";
  // stg.execute(slm);
   conn.close();
   jDialog1.setVisible(false);
                  check_user*/
         //   JOptionPane.showMessageDialog(this,"Failed to load the software");
         
            //}
        }
         catch(Exception ex)
        {
               JOptionPane.showMessageDialog(this,ex);
        }
          
                         }                 
                              
                               
                       
                        
                        }
                    catch(Exception ex)
                            {
                            JOptionPane.showMessageDialog(this, ex+"dkjfh");
                            }
                

                        }
     
    }
    public static String get_text()
    {
        
        String x=jTextField1.getText();
        return x;
    }
    public void check_user()
    {
         String get="select * from log where id=1;";
       int a=0;String b="";
          try{
               Connection con=Finance.connecrdb();
              
                 Statement st=con.createStatement();
                   ResultSet vs=st.executeQuery(get);
                   while(vs.next())
                   {
                       a=vs.getInt("attempt");
                         b=vs.getString("key");
                      
                       jLabel3.setText(a+"/5");
                   }
                   if(a==5)
                   {
                          payment. jTextField1.setText("You Have Exceeded your attempts,please call:09356899053");
            payment.jTextField1.setEditable(false);
            jButton1.setVisible(false);
                   }
                   else{
                       if(b.equals(""))
                       {
                              jProgressBar1.setVisible(false);
                               jButton1.setVisible(true);
                               jTextField1.setVisible(true);
                            payment.jTextField1.setEditable(true);
            jButton1.setVisible(true);
                       }
                       else{
                           String abc=Finance.matrix_revolutions_mr_anderson_neo_zenon();
                           if(b.equals(abc))
                           {
                              
                              jProgressBar1.setVisible(true);
                               jButton1.setVisible(false);
                               jTextField1.setVisible(false);
                               jLabel1.setText("Welcome To Account Book 1.0");
                                                              jLabel2.setVisible(false);
                               jLabel3.setVisible(false);

                            timer=new Timer(10,new bari());
             timer.start();
         int n=jProgressBar1.getValue();
            if(n<100)
            {
                n++;
                jProgressBar1.setValue(n);
            }
            else{
                timer.stop();
              // new face().setVisible(true);
              //dispose();
             
            }
                        
                   
                           }
                           else{
                                     jTextField1.setVisible(true);
                                  payment.jTextField1.setEditable(true);
            jButton1.setVisible(true);
                           }
                       }
                   }
          }
          catch(Exception ex)
          {
             
          }
    }
      public  class bari implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int n=jProgressBar1.getValue();
            if(n<100)
            {
                n++;
                jProgressBar1.setValue(n);
            }
            else{
                timer.stop();
        new Login().setVisible(true);
          dispose();
         
            }
        }
        
    }
      public static String get_ip()
{
          InetAddress ip = null;
          String xyz="";
    try {

      ip = InetAddress.getLocalHost();
       //System.out.println("Current IP address : " + ip.getHostAddress());
       String abc=ip.getHostAddress();
       if(abc.equals("127.0.0.1"))
       {
            xyz="not";
       }
       else{
   xyz=abc;
       }
         } catch (UnknownHostException e) {

        e.printStackTrace();
         }
    return xyz;
}
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(51, 255, 51));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel5.setText("Welcome to Account Book 1.0");

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(51, 255, 51));

        jTextField2.addActionListener(this);

        jLabel10.setText("Name");

        jLabel11.setText("Mobile");

        jTextField3.addActionListener(this);

        jLabel12.setText("City");

        jTextField4.addActionListener(this);

        jButton2.setText("Register");
        jButton2.addActionListener(this);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(71, 71, 71))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(110, 110, 110))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(174, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(130, 130, 130)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(108, 108, 108)))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Enter your Activation Licence key");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(this);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Attempts");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("0/5");

        jPanel1.setBackground(new java.awt.Color(51, 255, 51));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel4.setText("Account Book 1.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(9, 9, 9))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jButton1) {
            payment.this.jButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == jTextField2) {
            payment.this.jTextField2ActionPerformed(evt);
        }
        else if (evt.getSource() == jTextField3) {
            payment.this.jTextField3ActionPerformed(evt);
        }
        else if (evt.getSource() == jTextField4) {
            payment.this.jTextField4ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton2) {
            payment.this.jButton2ActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String x=jTextField1.getText().toString();
         String abc=Finance.matrix_revolutions_mr_anderson_neo_zenon();
         if(x.equals(abc))
         {
             try{
                 String up="update log set key='"+x+"',attempt=1  where id=1;";
                     Connection con=Finance.connecrdb();
             
                    Statement st=con.createStatement();
                                          st.execute(up);
          jProgressBar1.setVisible(true);
                               jButton1.setVisible(false);
                               jTextField1.setVisible(false);
                               jLabel1.setText("Welcome To Account Book 1.0");
                                                              jLabel2.setVisible(false);
                               jLabel3.setVisible(false);

                            timer=new Timer(10,new bari());
             timer.start();
          int n=jProgressBar1.getValue();
            if(n<100)
            {
                n++;
                jProgressBar1.setValue(n);
            }
            else{
                timer.stop();
             // new face().setVisible(true);
               //dispose();
            }
       
             }
             catch(Exception ex)
             {
                   JOptionPane.showMessageDialog(this,ex,"error",JOptionPane.ERROR_MESSAGE);
             }
         }
         else{
             JOptionPane.showMessageDialog(this,"Invalid Licence Key,Please try again","error",JOptionPane.ERROR_MESSAGE);
            
           
             try{Connection con=Finance.connecrdb();
             
                    Statement st=con.createStatement();
                                      int a=Finance.documents();
                                      if(a==5)
                                      {
                                           payment. jTextField1.setText("You Have Exceeded your attempts,please call:09356899053");
            payment.jTextField1.setEditable(false);
            jButton1.setVisible(false);
                                      }
                                      else
                                      {
                                          if(a==4)
                                          {
                                              JOptionPane.showMessageDialog(this,"Only Last attempt is left!!"+"\n"+"After 5th attempt the application will Lock and all data will be deleted");
                                          }
                                      if(a<5)
                                      {
                                          int b=a+1;
                                          jLabel3.setText(b+"/5");
                                           String attempt="update log set attempt='"+b+"' where id=1;";
                                             st.execute(attempt);
                                      }
                                      }
             }
             catch(Exception ex)
             {
                   JOptionPane.showMessageDialog(this,ex,"error",JOptionPane.ERROR_MESSAGE);
             }
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String name=jTextField1.getText();
        String phone=jTextField2.getText();
        String city=jTextField3.getText();
         String abc=Finance.matrix_revolutions_mr_anderson_neo_zenon();   
        if(!name.equals("") && !phone.equals("") && !city.equals(""))
        {
         //  jDialog2.setVisible(true);
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

                @Override
                protected Void doInBackground() throws Exception {

                    try{
                           Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mobileshopdb9356", "mobileshopuser01", "9356899053");
       
        Statement stg=conn.createStatement();
        
   String get="select user from online;";
  
    ResultSet vs=stg.executeQuery(get);
    int z=0;
    while(vs.next())
    {
        z=vs.getInt("user");
    }
    int user=z+1;
     String slm="insert into online value('"+abc+"',curdate(),curtime(),'"+user+"','"+name+" "+phone+"','Accounts-"+city+"');";
   stg.execute(slm);
   conn.close();
//   jDialog2.setVisible(false);
                  check_user();

                    }
                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    return null;
                }
            };

            worker.execute();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Please fill the values");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
try
     {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
     }
     catch(Exception ex){}
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new payment().setVisible(true);
            }
        });
    }
private Timer timer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JDialog jDialog1;
    public static javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JProgressBar jProgressBar1;
    public static javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
