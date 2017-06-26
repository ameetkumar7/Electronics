/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.text.*;
import java.awt.print.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Finance extends javax.swing.JFrame implements ActionListener, KeyListener, MouseListener, ChangeListener {

    /**
     * Creates new form Finance
     */
    public Finance() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("payment.png")));
        setTitle("Account Book 1.0");
      //  setLocationRelativeTo(null);
        Dimension d=getToolkit().getScreenSize();
       setSize(d);
            jDialog4.setSize(700,570);
        jDialog4.setLocationRelativeTo(null);
            jDialog4.setModal(true);
            
                 jDialog5.setSize(300,180);
        jDialog5.setLocationRelativeTo(null);
            jDialog5.setModal(true);
            
              jDialog6.setSize(395,265);
        jDialog6.setLocationRelativeTo(null);
            jDialog6.setModal(true);
            
               jDialog7.setSize(410,370);
        jDialog7.setLocationRelativeTo(null);
            jDialog7.setModal(true);
    
         jDialog2.setSize(420,380);
        jDialog2.setLocationRelativeTo(null);
            jDialog2.setModal(true);
            
            
            
             jDialog1.setSize(400,350);
        jDialog1.setLocationRelativeTo(null);
            jDialog1.setModal(true);
            
                  jDialog8.setSize(570,365);
        jDialog8.setLocationRelativeTo(null);
            jDialog8.setModal(true);
            
                  jDialog9.setSize(790,575);
        jDialog9.setLocationRelativeTo(null);
            jDialog9.setModal(true);
            
                   jDialog11.setSize(370,300);
        jDialog11.setLocationRelativeTo(null);
            jDialog11.setModal(true);
     
       
            
            
               jFrame1.setSize(d);
        jFrame1.setLocationRelativeTo(null);
        
        //   jFrame2.setSize(1100,680);
              jFrame2.setSize(d);
        jFrame2.setLocationRelativeTo(null);
       //     jFrame1.setModal(true);
               jFrame3.setSize(d);
        jFrame3.setLocationRelativeTo(null);
      // jButton7.setVisible(false);
         //    jButton22.setVisible(false);

  
      
  //select name,customer.phone,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%2017%'),(select sum(payment) from installments where customer.phone=installments.phone and pay_day like '%2017%') as Credit,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%2017%')-(select sum(payment) from installments where products.phone=installments.phone and pay_day like '%2017%') as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC    
   //select name,customer.phone,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%2017%' or pay_day='e'),(select sum(payment) from installments where customer.phone=installments.phone and pay_day like '%2017%') as Credit,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%2017%' or pay_day='e')-(select sum(payment) from installments where products.phone=installments.phone and pay_day like '%2017%' or pay_day='e') as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC       
       //   jTable3.setEnabled(false);
           //  jTable1.setEnabled(false);
       jTable3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         //  jTable14.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                  jTable17.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                  
                   jTable19.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
           jTable18.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
               
     
int year=jYearChooser1.getYear();
                  //before date query
           //  String data="select name,customer.phone,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC ;";
                        String data= "select name,customer.phone,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%"+year+"%' or pay_day='e'),(select sum(payment) from installments where customer.phone=installments.phone and pay_day like '%"+year+"%' or pay_day='e') as Credit,(select sum(price) as Debit from products where customer.phone=products.phone)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC;";       

                   String [] col={"Name","Contact","Products Cost","Payment recieved","Net Balance"};

            int [] width={};
            dataInTable(data, col,jTable2,false,width);
            Date date=new Date(); 
              try
                {
                     Connection con= Finance.connecrdb();
                 String a="select * from account where rowid=1";
              
                    Statement st=con.createStatement();
                 
                    ResultSet rs=st.executeQuery(a);
                  String key_value="";
                  int attempt=0;
                               
                    while(rs.next())
                    {
                         key_value=rs.getString("date");
                     
                 }
                      jLabel19.setText("Last login at "+key_value);
                       String query="update account set date='"+date+"';";
                          st.execute(query);
                  
                }
              catch(Exception ex)
              {
                  
              }
          //  jButton10.setOpaque(true);
            //jButton10.setText("<html><a>delete</a></html>");
        //    jButton10.setText("<HTML><FONT color=\"#000099\">Delete</FONT>"+ "</HTML>");
	//         jButton10.setBorderPainted(false);
	    //     jButton10.setOpaque(false);
             //       jButton8.setText("<HTML><FONT color=\"#000099\">Delete</FONT>"+ "</HTML>");
	//         jButton8.setBorderPainted(false);
	    //     jButton8.setOpaque(false);
	       // jButton10.setBackground(Color.WHITE);
               
                        String query="select (select sum(price) from products)-(select sum(payment) from installments) as net ";

            //   String query="select (select sum(price) from products where pay_day like '%"+year+"%')-(select sum(payment) from installments where pay_day like '%"+year+"%') as net ";
            String f[]={"net"};
    String get[]=getValuesfromDb(query,f);
    
    
    
  jLabel77.setText(get[0]);
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog4 = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        jTextField25 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel39 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel78 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jDialog2 = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDialog1 = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jDialog3 = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel50 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel55 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel57 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jTextField17 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jFrame1 = new javax.swing.JFrame();
        jPanel14 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel62 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel64 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel70 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jLabel72 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jTextField27 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel65 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jLabel79 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jFrame2 = new javax.swing.JFrame();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable15 = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable16 = new javax.swing.JTable();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jDialog5 = new javax.swing.JDialog();
        jPanel20 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jButton33 = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        jDialog6 = new javax.swing.JDialog();
        jPanel21 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jButton34 = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDialog7 = new javax.swing.JDialog();
        jPanel22 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jButton35 = new javax.swing.JButton();
        jDialog8 = new javax.swing.JDialog();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable17 = new javax.swing.JTable();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jLabel96 = new javax.swing.JLabel();
        jDialog9 = new javax.swing.JDialog();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTable18 = new javax.swing.JTable();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable19 = new javax.swing.JTable();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jDialog10 = new javax.swing.JDialog();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTable20 = new javax.swing.JTable();
        jFrame3 = new javax.swing.JFrame();
        jPanel26 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel106 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTable21 = new javax.swing.JTable();
        jLabel108 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTable22 = new javax.swing.JTable();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTable23 = new javax.swing.JTable();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jLabel113 = new javax.swing.JLabel();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jLabel114 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTable24 = new javax.swing.JTable();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jButton44 = new javax.swing.JButton();
        jTextField43 = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel120 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jLabel119 = new javax.swing.JLabel();
        jTextField46 = new javax.swing.JTextField();
        jDialog11 = new javax.swing.JDialog();
        jPanel29 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel124 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel125 = new javax.swing.JLabel();
        jTextField45 = new javax.swing.JTextField();
        jButton46 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jButton38 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPanel11.setBackground(new java.awt.Color(0, 204, 255));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Create the Sale");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Name*");

        jTextField8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField8.setNextFocusableComponent(jTextField9);
        jTextField8.addKeyListener(this);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Phone*");

        jTextField9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Product*");

        jTextField10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField10.addKeyListener(this);

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Brand");

        jTextField11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField11.addKeyListener(this);

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Quantity");

        jTextField12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Price*");

        jTextField13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Payment");

        jButton26.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton26.setText("ADD");
        jButton26.addActionListener(this);

        jTextField25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("City");

        jLabel2.setText("AC,TV,Fridge e.t.c..");

        jTextField14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTextField16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField16.setText("NIL");
        jTextField16.addActionListener(this);

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Cheque No.");

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Date*");

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(this);

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel78.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Model");

        jCheckBox11.setText("Auto suggest");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton26)
                        .addGap(123, 123, 123))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox11)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField9)
                                .addComponent(jTextField8)
                                .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField11)
                                .addComponent(jTextField12)
                                .addComponent(jTextField13)
                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField14)
                                .addComponent(jTextField16)))))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton6))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addGap(23, 23, 23)
                .addComponent(jCheckBox11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton26)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(51, 204, 0));

        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Payment");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Phone");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Name");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Pending");

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Cheque No.");

        jTextField7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButton21.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton21.setText("ADD");
        jButton21.addActionListener(this);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("jLabel4");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("jLabel6");

        jTextField15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField15.setText("NIL");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Payment");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Date");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 61, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton21)
                    .addComponent(jTextField7)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField15)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton21)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(51, 255, 51));

        jLabel18.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 14)); // NOI18N
        jLabel18.setText("Account Book 1.0");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField2.addActionListener(this);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Change Username or Password");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Username");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Old Password");

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setText("Change");
        jButton9.addActionListener(this);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("New Password");

        jPasswordField2.addActionListener(this);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jButton9)
                    .addComponent(jPasswordField1)
                    .addComponent(jPasswordField2))
                .addGap(71, 71, 71))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton9)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setText("Invoice No.");

        jTextField3.setText("jTextField3");

        jLabel25.setText("Customer Name");

        jTextField4.setText("jTextField4");

        jLabel26.setText("Date");

        jLabel27.setText("Phone Number");

        jTextField5.setText("jTextField5");

        jLabel46.setText("Select Brand");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jLabel47.setText("Select Item");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        jLabel52.setText("Payment");

        jTextField19.setText("jTextField19");

        jLabel53.setText("Invoice Items");

        jLabel54.setText("Address");

        jTextField18.setText("jTextField18");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(51, 51, 255));
        jLabel45.setText("Units Left");

        jTextField6.setText("jTextField6");

        jLabel48.setText("Price");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel50.setText("Units");

        jButton12.setText("Return");

        jButton11.setText("Add");
        jButton11.addActionListener(this);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 153, 51));
        jLabel56.setText("Total :");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(jButton12))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72)
                            .addComponent(jLabel50))
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(jTable7);

        jLabel55.setText("Select product");

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "TAXES"));

        jCheckBox1.setText("jCheckBox1");

        jCheckBox2.setText("jCheckBox2");

        jCheckBox3.setText("jCheckBox3");

        jCheckBox4.setText("jCheckBox4");

        jCheckBox5.setText("jCheckBox5");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jCheckBox4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jCheckBox5)))
                        .addContainerGap())
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox3)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox5)
                .addGap(39, 39, 39))
        );

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 153, 51));
        jLabel57.setText("Total After tax:");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 153, 51));
        jLabel51.setText("Sub Total :");

        jButton13.setText("Transact");
        jButton13.addActionListener(this);

        jButton14.setText("TR-Invoice");

        jButton15.setText("Invoice");
        jButton15.addActionListener(this);

        jTextField17.setText("jTextField17");

        jLabel49.setText("Additional Charges");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)
                                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(230, 230, 230)
                                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel52)
                                        .addGap(36, 36, 36))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                            .addComponent(jTextField3))
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel54))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                .addGap(32, 32, 32)
                                                .addComponent(jLabel27)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextField18)))
                                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)))
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel54)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel49)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton14)
                    .addComponent(jButton13))
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel58.setText("Invoice No.");

        jTextField20.setText("jTextField3");

        jLabel59.setText("Customer Name");

        jTextField21.setText("jTextField4");

        jLabel60.setText("Date");

        jLabel62.setText("Phone Number");

        jTextField22.setText("jTextField5");

        jLabel63.setText("Select Brand");

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(jTable8);

        jLabel64.setText("Select Item");

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(jTable9);

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(jTable10);

        jLabel66.setText("Invoice Items");

        jLabel67.setText("Address");

        jTextField24.setText("jTextField18");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(51, 51, 255));
        jLabel68.setText("Units Left");

        jTextField26.setText("jTextField6");

        jLabel69.setText("Price");

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel70.setText("Units");

        jButton16.setText("Return");
        jButton16.addActionListener(this);

        jButton17.setText("Add");
        jButton17.addActionListener(this);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 153, 51));
        jLabel71.setText("Total :");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jTextField26, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jLabel70))
                            .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                        .addGap(33, 33, 33)))
                .addGap(28, 28, 28))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField26)
                    .addComponent(jSpinner2))
                .addGap(22, 22, 22)
                .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(jTable11);

        jLabel72.setText("Select product");

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "TAXES"));

        jCheckBox6.setText("jCheckBox1");

        jCheckBox7.setText("jCheckBox2");

        jCheckBox8.setText("jCheckBox3");

        jCheckBox9.setText("jCheckBox4");

        jCheckBox10.setText("jCheckBox5");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 153, 51));
        jLabel73.setText("Final Amount :");

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 153, 51));
        jLabel74.setText("Sub Total :");

        jButton18.setText("Transact");
        jButton18.addActionListener(this);

        jButton19.setText("TR-Invoice");

        jButton20.setText("Invoice");
        jButton20.addActionListener(this);

        jTextField27.setText("jTextField17");

        jLabel75.setText("Additional Charges");

        jLabel65.setText("Discount");

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(jTable12);

        jLabel79.setText("Paid");

        jTextField23.setText("jTextField23");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 153, 51));
        jLabel80.setText("Balance:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addGap(796, 796, 796))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addGap(35, 35, 35)))
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addGap(409, 409, 409))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(31, 31, 31))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(151, 151, 151)
                                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField23))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jTextField27)
                                                            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                                                .addComponent(jSpinner3)
                                                                .addGap(49, 49, 49))))
                                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                                        .addGap(28, 28, 28)
                                                        .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(5, 5, 5))
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(102, 102, 102))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jTextField20)
                                .addGap(88, 88, 88)))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addComponent(jTextField24))
                        .addGap(93, 93, 93)))
                .addGap(34, 34, 34))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton19, jButton20});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField22)
                        .addComponent(jTextField21)
                        .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel66))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)
                                .addComponent(jTextField27)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner3)
                                .addGap(71, 71, 71))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton20))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel79)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel80)))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTable14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        jScrollPane14.setViewportView(jTable14);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel18.setBackground(new java.awt.Color(204, 204, 255));

        jButton24.setText("Products");
        jButton24.addActionListener(this);

        jButton25.setText("Brands");
        jButton25.addActionListener(this);

        jButton27.setText("Distributors");
        jButton27.addActionListener(this);

        jButton28.setText("Add Items");
        jButton28.addActionListener(this);

        jButton29.setText("Update ");

        jButton30.setText("Remove");

        jButton31.setText("Details");

        jButton32.setText("Statement");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton24)
                .addGap(18, 18, 18)
                .addComponent(jButton25)
                .addGap(18, 18, 18)
                .addComponent(jButton27)
                .addGap(18, 18, 18)
                .addComponent(jButton28)
                .addGap(18, 18, 18)
                .addComponent(jButton29)
                .addGap(18, 18, 18)
                .addComponent(jButton30)
                .addGap(18, 18, 18)
                .addComponent(jButton31)
                .addGap(18, 18, 18)
                .addComponent(jButton32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(204, 255, 204));

        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(jTable13);

        jTable15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(jTable15);

        jTable16.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        jScrollPane16.setViewportView(jTable16);

        jTextField28.setText("jTextField28");

        jTextField29.setText("jTextField29");

        jLabel81.setText("Search Item");

        jLabel82.setText("Product");

        jLabel83.setText("Company");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel82)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel83)))
                .addContainerGap(296, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame2Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jFrame2Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jLabel84.setText("Product");

        jTextField30.setText("jTextField30");

        jButton33.setText("ADD");
        jButton33.addActionListener(this);

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("Enter Product category");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel84)
                .addGap(33, 33, 33)
                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButton33)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel85)
                .addGap(28, 28, 28)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton33)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jDialog5Layout = new javax.swing.GroupLayout(jDialog5.getContentPane());
        jDialog5.getContentPane().setLayout(jDialog5Layout);
        jDialog5Layout.setHorizontalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog5Layout.setVerticalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog5Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel86.setText("Select product ");

        jLabel87.setText("Brand name");

        jButton34.setText("ADD");
        jButton34.addActionListener(this);

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("Enter Brand name");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel88)
                .addGap(45, 45, 45)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87))
                .addGap(34, 34, 34)
                .addComponent(jButton34)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog6Layout = new javax.swing.GroupLayout(jDialog6.getContentPane());
        jDialog6.getContentPane().setLayout(jDialog6Layout);
        jDialog6Layout.setHorizontalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog6Layout.setVerticalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel89.setText("Enter Distributor");

        jLabel90.setText("Name");

        jLabel91.setText("Phone");

        jLabel92.setText("email");

        jLabel93.setText("Address");

        jLabel94.setText("City");

        jLabel95.setText("Company");

        jButton35.setText("ADD");
        jButton35.addActionListener(this);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel94)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel22Layout.createSequentialGroup()
                                    .addComponent(jLabel92)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                                    .addComponent(jLabel91)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                                    .addComponent(jLabel90)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel93)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel95)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel89)
                .addGap(37, 37, 37)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton35)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog7Layout = new javax.swing.GroupLayout(jDialog7.getContentPane());
        jDialog7.getContentPane().setLayout(jDialog7Layout);
        jDialog7Layout.setHorizontalGroup(
            jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog7Layout.setVerticalGroup(
            jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTable17.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane17.setViewportView(jTable17);

        jButton36.setText("ADD");
        jButton36.addActionListener(this);

        jButton37.setText("Remove");

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel96.setText("jLabel96");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane17)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(198, 198, 198)))
                .addGap(28, 28, 28))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton36)
                .addGap(18, 18, 18)
                .addComponent(jButton37)
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel96)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog8Layout = new javax.swing.GroupLayout(jDialog8.getContentPane());
        jDialog8.getContentPane().setLayout(jDialog8Layout);
        jDialog8Layout.setHorizontalGroup(
            jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog8Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jDialog8Layout.setVerticalGroup(
            jDialog8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTable18.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        jScrollPane18.setViewportView(jTable18);

        jTable19.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane19.setViewportView(jTable19);

        jLabel97.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 0, 204));
        jLabel97.setText("Client Business details");

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 153, 0));
        jLabel98.setText("jLabel98");

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 153, 0));
        jLabel99.setText("jLabel99");

        jLabel100.setText("jLabel100");

        jLabel101.setText("jLabel101");

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(204, 0, 0));
        jLabel102.setText("jLabel102");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(291, 291, 291))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(324, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(jLabel100))
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel101)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                    .addContainerGap(115, Short.MAX_VALUE)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jDialog9Layout = new javax.swing.GroupLayout(jDialog9.getContentPane());
        jDialog9.getContentPane().setLayout(jDialog9Layout);
        jDialog9Layout.setHorizontalGroup(
            jDialog9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog9Layout.setVerticalGroup(
            jDialog9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTable20.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        jTable20.addMouseListener(this);
        jScrollPane20.setViewportView(jTable20);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog10Layout = new javax.swing.GroupLayout(jDialog10.getContentPane());
        jDialog10.getContentPane().setLayout(jDialog10Layout);
        jDialog10Layout.setHorizontalGroup(
            jDialog10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog10Layout.setVerticalGroup(
            jDialog10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jLabel103.setText("Invoice No.");

        jLabel104.setText("Distributor");

        jTextField39.addKeyListener(this);

        jLabel105.setText("Date");

        jLabel106.setText("Phone Number");

        jLabel107.setText("Select Brand");

        jTable21.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        jTable21.addMouseListener(this);
        jScrollPane21.setViewportView(jTable21);

        jLabel108.setText("Select Item");

        jTable22.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        jTable22.addMouseListener(this);
        jTable22.addKeyListener(this);
        jScrollPane22.setViewportView(jTable22);

        jTable23.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        jScrollPane23.setViewportView(jTable23);

        jLabel109.setText("Invoice Items");

        jLabel110.setText("Address");

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(51, 51, 255));
        jLabel111.setText("Units Left");

        jLabel112.setText("Buy Price");

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
        jSpinner5.setNextFocusableComponent(jTextField46);
        jSpinner5.addChangeListener(this);
        jSpinner5.addKeyListener(this);

        jLabel113.setText("Units");

        jButton41.setText("Return");
        jButton41.addActionListener(this);

        jButton42.setText("Add");
        jButton42.addActionListener(this);

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 153, 51));
        jLabel114.setText("Total :");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner5))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel113))
                            .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)))
                .addGap(19, 19, 19))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(jLabel112))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField42)
                    .addComponent(jSpinner5))
                .addGap(22, 22, 22)
                .addComponent(jLabel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        jTable24.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        jTable24.addMouseListener(this);
        jTable24.addKeyListener(this);
        jScrollPane24.setViewportView(jTable24);

        jLabel115.setText("Select product");

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(0, 153, 51));
        jLabel116.setText("Final Amount :");

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 153, 51));
        jLabel117.setText("Sub Total :");

        jButton44.setText("TR-Invoice");
        jButton44.addActionListener(this);

        jTextField43.addKeyListener(this);

        jLabel118.setText("Additional Charges");

        jLabel120.setText("Paid");

        jTextField44.addKeyListener(this);

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(0, 153, 51));
        jLabel121.setText("Balance:");

        jCheckBox13.setText("Auto suggest");

        jLabel119.setText("Sell price");

        jTextField46.addActionListener(this);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(796, 796, 796))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(35, 35, 35)))
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(440, 440, 440))
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel119))
                                        .addGap(174, 174, 174))))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(278, 278, 278)
                                        .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel26Layout.createSequentialGroup()
                                                .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField44))
                                            .addComponent(jLabel118, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                            .addComponent(jTextField43, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(144, 144, 144))
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField38)
                            .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jLabel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jTextField39)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel106)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jCheckBox13)
                        .addGap(89, 89, 89)))
                .addGap(34, 34, 34))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField39)
                                .addComponent(jTextField40)
                                .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox13))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel110))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jTextField38)
                        .addGap(26, 26, 26)
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel119)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel109)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel117)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField43)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel116)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel120)
                            .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel121)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jButton44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel122.setText("Add Items");

        jLabel123.setText("Product");

        jLabel124.setText("Brand");

        jLabel125.setText("Item/Model");

        jButton46.setText("ADD");
        jButton46.addActionListener(this);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel123, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel124, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel125, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, 0, 133, Short.MAX_VALUE)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField45))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel122)
                .addGap(26, 26, 26)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel123)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel124)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel125)
                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton46)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog11Layout = new javax.swing.GroupLayout(jDialog11.getContentPane());
        jDialog11.getContentPane().setLayout(jDialog11Layout);
        jDialog11Layout.setHorizontalGroup(
            jDialog11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog11Layout.setVerticalGroup(
            jDialog11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 0));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel15.setText("Account Book 1.0");

        jLabel19.setText("jLabel19");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton2.setText("Delete customer");
        jButton2.setMargin(new java.awt.Insets(-20, -20, -20, -20));
        jButton2.addActionListener(this);

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(this);

        jButton7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton7.setText("Admin");
        jButton7.addActionListener(this);

        jButton22.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton22.setText("Details");
        jButton22.addActionListener(this);

        jButton39.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton39.setText("Stock");
        jButton39.addActionListener(this);

        jButton40.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton40.setText("Bill");
        jButton40.addActionListener(this);

        jButton47.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton47.setText("Purchase");
        jButton47.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton47.addActionListener(this);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton47)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "PENDING" }));

        jButton5.setFont(new java.awt.Font("Source Sans Pro Semibold", 1, 14)); // NOI18N
        jButton5.setText("GET");
        jButton5.addActionListener(this);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer Selected");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mobile");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total Pending");

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Net Balance Filter");

        jLabel76.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Firm Net Balance");

        jLabel77.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jTable2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(this);
        jTable2.addKeyListener(this);
        jScrollPane2.setViewportView(jTable2);

        jTextField1.addKeyListener(this);

        jLabel1.setText("Search");

        jButton38.setText("Load");
        jButton38.addActionListener(this);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(jButton38)))
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        jTable3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel9.setText("Customer Products ");

        jButton10.setFont(new java.awt.Font("Source Sans Pro Semibold", 1, 14)); // NOI18N
        jButton10.setText("Delete");
        jButton10.addActionListener(this);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 255));
        jLabel16.setText("Select to Remove product from Customer Account");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addGap(35, 35, 35)))
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel7.setText("Customer Payments");

        jButton8.setFont(new java.awt.Font("Source Sans Pro Semibold", 1, 14)); // NOI18N
        jButton8.setText("Delete");
        jButton8.addActionListener(this);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 255));
        jLabel17.setText("Select to Remove payment");

        jButton23.setFont(new java.awt.Font("Source Sans Pro Semibold", 1, 14)); // NOI18N
        jButton23.setText("Print");
        jButton23.addActionListener(this);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jButton23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8)
                                .addGap(6, 6, 6))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));

        jButton3.setFont(new java.awt.Font("Source Sans Pro Semibold", 1, 14)); // NOI18N
        jButton3.setText("Make Payment");
        jButton3.addActionListener(this);

        jButton4.setFont(new java.awt.Font("Source Sans Pro Semibold", 1, 14)); // NOI18N
        jButton4.setText("Create sale");
        jButton4.addActionListener(this);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(375, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jButton2) {
            Finance.this.jButton2ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton1) {
            Finance.this.jButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton7) {
            Finance.this.jButton7ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton22) {
            Finance.this.jButton22ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton39) {
            Finance.this.jButton39ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton40) {
            Finance.this.jButton40ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton47) {
            Finance.this.jButton47ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton5) {
            Finance.this.jButton5ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton38) {
            Finance.this.jButton38ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton10) {
            Finance.this.jButton10ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton8) {
            Finance.this.jButton8ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton23) {
            Finance.this.jButton23ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton3) {
            Finance.this.jButton3ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton4) {
            Finance.this.jButton4ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton26) {
            Finance.this.jButton26ActionPerformed(evt);
        }
        else if (evt.getSource() == jTextField16) {
            Finance.this.jTextField16ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton6) {
            Finance.this.jButton6ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton21) {
            Finance.this.jButton21ActionPerformed(evt);
        }
        else if (evt.getSource() == jTextField2) {
            Finance.this.jTextField2ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton9) {
            Finance.this.jButton9ActionPerformed(evt);
        }
        else if (evt.getSource() == jPasswordField2) {
            Finance.this.jPasswordField2ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton11) {
            Finance.this.jButton11ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton13) {
            Finance.this.jButton13ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton15) {
            Finance.this.jButton15ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton16) {
            Finance.this.jButton16ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton17) {
            Finance.this.jButton17ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton18) {
            Finance.this.jButton18ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton20) {
            Finance.this.jButton20ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton24) {
            Finance.this.jButton24ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton25) {
            Finance.this.jButton25ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton27) {
            Finance.this.jButton27ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton28) {
            Finance.this.jButton28ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton33) {
            Finance.this.jButton33ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton34) {
            Finance.this.jButton34ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton35) {
            Finance.this.jButton35ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton36) {
            Finance.this.jButton36ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton41) {
            Finance.this.jButton41ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton42) {
            Finance.this.jButton42ActionPerformed(evt);
        }
        else if (evt.getSource() == jTextField46) {
            Finance.this.jTextField46ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton46) {
            Finance.this.jButton46ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton44) {
            Finance.this.jButton44ActionPerformed(evt);
        }
    }

    public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getSource() == jSpinner5) {
            Finance.this.jSpinner5KeyPressed(evt);
        }
    }

    public void keyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getSource() == jTable2) {
            Finance.this.jTable2KeyReleased(evt);
        }
        else if (evt.getSource() == jTextField1) {
            Finance.this.jTextField1KeyReleased(evt);
        }
        else if (evt.getSource() == jTextField8) {
            Finance.this.jTextField8KeyReleased(evt);
        }
        else if (evt.getSource() == jTextField10) {
            Finance.this.jTextField10KeyReleased(evt);
        }
        else if (evt.getSource() == jTextField11) {
            Finance.this.jTextField11KeyReleased(evt);
        }
        else if (evt.getSource() == jTextField39) {
            Finance.this.jTextField39KeyReleased(evt);
        }
        else if (evt.getSource() == jTable22) {
            Finance.this.jTable22KeyReleased(evt);
        }
        else if (evt.getSource() == jSpinner5) {
            Finance.this.jSpinner5KeyReleased(evt);
        }
        else if (evt.getSource() == jTable24) {
            Finance.this.jTable24KeyReleased(evt);
        }
        else if (evt.getSource() == jTextField43) {
            Finance.this.jTextField43KeyReleased(evt);
        }
        else if (evt.getSource() == jTextField44) {
            Finance.this.jTextField44KeyReleased(evt);
        }
    }

    public void keyTyped(java.awt.event.KeyEvent evt) {
    }

    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == jTable2) {
            Finance.this.jTable2MouseClicked(evt);
        }
        else if (evt.getSource() == jTable20) {
            Finance.this.jTable20MouseClicked(evt);
        }
        else if (evt.getSource() == jTable21) {
            Finance.this.jTable21MouseClicked(evt);
        }
        else if (evt.getSource() == jTable22) {
            Finance.this.jTable22MouseClicked(evt);
        }
        else if (evt.getSource() == jTable24) {
            Finance.this.jTable24MouseClicked(evt);
        }
    }

    public void mouseEntered(java.awt.event.MouseEvent evt) {
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
    }

    public void mousePressed(java.awt.event.MouseEvent evt) {
    }

    public void mouseReleased(java.awt.event.MouseEvent evt) {
    }

    public void stateChanged(javax.swing.event.ChangeEvent evt) {
        if (evt.getSource() == jSpinner5) {
            Finance.this.jSpinner5StateChanged(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
/* int row=jTable2.getSelectedRow();
          try{
            String mobile=(jTable2.getModel().getValueAt(row,1).toString());
            
              String s="select name,customer.phone,city,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone where customer.phone='"+mobile+"';";
              Connection con=connecrdb();
                 Statement st=con.createStatement();
               ResultSet rs=st.executeQuery(s);
               while(rs.next())
               {
                   String a=rs.getString("name");
                   jTextField8.setText(a+"");
                   String b=rs.getString("phone");
                        jTextField9.setText(b+"");
                   
                             String d=rs.getString("city");
                       jTextField25.setText(d+"");
                        
                        
                 
                     
               }
        }
        catch(Exception ex)
        {
         //   JOptionPane.showMessageDialog(this, ex);
        }*/
            
              jTextField8.setText("");
        jTextField9.setText("");
    jTextField25.setText("");
      jTextField10.setText("");
        jTextField11.setText("");
    jTextField12.setText("");
      jTextField13.setText("");
        jTextField14.setText("");
  jTextField16.setText("NIL");
 // jCheckBox11.setSelected();
jSpinner4.setValue(1);
        
        
        jDialog4.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

  
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row=jTable2.getSelectedRow();
          // String customer_mobile=(jTable2.getModel().getValueAt(row,0).toString());
        if(row==-1)
        {
            JOptionPane.showMessageDialog(null,"Please select a customer from above table");
        }
        else
        {
            try{
            String mobile=(jTable2.getModel().getValueAt(row,1).toString());
            
              String s="select name,customer.phone,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone where customer.phone='"+mobile+"';";
              Connection con=connecrdb();
                 Statement st=con.createStatement();
               ResultSet rs=st.executeQuery(s);
               while(rs.next())
               {
                   String a=rs.getString("name");
                   jLabel5.setText(a+"");
                   String b=rs.getString("phone");
                        jLabel4.setText(b+"");
                   
                             int d=rs.getInt("net");
                       jLabel6.setText(d+"");
                        
                        
                 
                     
               }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }
            
            jDialog2.setVisible(true);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
    String phone=jLabel4.getText().toString();
       String payment_string=jTextField7.getText().toString();
       int payment=Integer.parseInt(payment_string);
       String mode=jTextField15.getText().toString();
   
     
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
     String date = sdf.format(jDateChooser1.getDate());
     
     if(!jLabel6.getText().equals("0"))
     {
      String query2="insert into installments  values('"+phone+"','"+payment+"',current_date,'"+mode+"','"+date+"');";
        executeQuery(query2);
        
                 JOptionPane.showMessageDialog(null,"Entry saved");

       int year=jYearChooser1.getYear();
                  //before date query
           //  String data="select name,customer.phone,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC ;";
                          String data= "select name,customer.phone,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%"+year+"%' or pay_day='e'),(select sum(payment) from installments where customer.phone=installments.phone and pay_day like '%"+year+"%' or pay_day='e') as Credit,(select sum(price) as Debit from products where customer.phone=products.phone)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC;";       

                   String [] col={"Name","Contact","Products Cost","Payment recieved","Net Balance"};

            int [] width={};
            dataInTable(data, col,jTable2,false,width);
            
             String data2="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='"+phone+"' and price!=0 and pay_day like '%"+year+"%'";
                      String [] col2={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width2={40,80,80,80,80,80,80,120};
            dataInTable(data2,col2,jTable3,true,width2);
            
                String data1="Select rowid,payment,mode,pay_day from installments where phone='"+phone+"' and payment <>0 and pay_day like '%"+year+"%'";
                      String [] col1={"Id","Payment","Cheq No.","Date"};

            int [] width1={20,80,80,80};
            dataInTable(data1,col1,jTable1,true,width1);
            
            
               String query3="select (select sum(price) from products)-(select sum(payment) from installments) as net ";
            String f[]={"net"};
             String get[]=getValuesfromDb(query3,f);
  jLabel77.setText(get[0]);
 // jLabel6.setText(get[0]);
  jTextField7.setText("");
     }
     else
     {
                          JOptionPane.showMessageDialog(null,"Cannot Make payment\nNo pending Balance for customer");

     }
     
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
     
     
        
          String name=jTextField8.getText().toString();
           String phone=jTextField9.getText().toString();
                      String city=jTextField25.getText().toString();
                                            String product=jTextField10.getText().toString();
                                                                  String brand=jTextField11.getText().toString();
                                                                                        String model=jTextField12.getText().toString();
                                                                                                              String price_string=jTextField14.getText().toString();
                                                                                                  
                                                                                                                                    String payment_string=jTextField13.getText().toString();
                                                                                                                                    if(payment_string.equals(""))
                                                                                                                                    {
                                                                                                                                        payment_string="0";
                                                                                                                                    }
                                                                                                                                       int payment=Integer.parseInt(payment_string);
String mode=jTextField16.getText().toString();

int quantity=(Integer) jSpinner4.getValue();


   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
     String date = sdf.format(jDateChooser2.getDate());

if(!price_string.equals(""))
{
       int price=Integer.parseInt(price_string);
   int total_price=price*quantity;
       
       
     
            String query="insert into customer  values('"+name+"','"+phone+"','"+city+"');";
            executeQuery(query);

    //    boolean check=
        //if(check){
            String query1="insert into products  values('"+phone+"','"+product+"','"+brand+"','"+model+"',"+total_price+",current_date,'"+date+"','"+quantity+"',"+price+");";
   executeQuery(query1);
   
   String query2="insert into installments  values('"+phone+"','"+payment+"',current_date,'"+mode+"','"+date+"');";
        executeQuery(query2);
        
        //These are empty entries
     
          String query3="INSERT INTO products(phone,price,quantity,unit,pay_day) \n" +
"SELECT '"+phone+"',0,0,0,'e'\n" +
"WHERE NOT EXISTS(SELECT phone FROM products WHERE phone = '"+phone+"' AND price=0 AND quantity=0 AND unit =0);";
   executeQuery(query3);
   
  // if(payment!=0){
   String query4="INSERT INTO installments(phone,payment,pay_day) \n" +
"SELECT '"+phone+"',0,'e'\n" +
"WHERE NOT EXISTS(SELECT phone FROM installments WHERE phone = '"+phone+"' AND payment=0);";
        executeQuery(query4);
  // }
        
         JOptionPane.showMessageDialog(null,"Entry saved");
        
    int year=jYearChooser1.getYear();
                  //before date query
           //  String data="select name,customer.phone,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC ;";
                         String data= "select name,customer.phone,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%"+year+"%' or pay_day='e'),(select sum(payment) from installments where customer.phone=installments.phone and pay_day like '%"+year+"%' or pay_day='e') as Credit,(select sum(price) as Debit from products where customer.phone=products.phone)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC;";       

                   String [] col={"Name","Contact","Products Cost","Payment recieved","Net Balance"};

            int [] width={};
            dataInTable(data, col,jTable2,false,width);
            
             String data2="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='"+phone+"' and price!=0 and pay_day like '%"+year+"%'";
                      String [] col2={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width2={40,80,80,80,80,80,80,120};
            dataInTable(data2,col2,jTable3,true,width2);
            
                String data1="Select rowid,payment,mode,pay_day from installments where phone='"+phone+"' and payment <>0 and pay_day like '%"+year+"%'";
                      String [] col1={"Id","Payment","Cheq No.","Date"};

            int [] width1={20,80,80,80};
            dataInTable(data1,col1,jTable1,true,width1);
            
               String query5="select (select sum(price) from products)-(select sum(payment) from installments) as net";
            String foo[]={"net"};
             String getoo[]=getValuesfromDb(query5,foo);
  jLabel77.setText(getoo[0]);
       }

        else
        {
             JOptionPane.showMessageDialog(null,"Please enter the Cost of product");
        }
       
   



        
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    jTextField8.setText("");
        jTextField9.setText("");
    jTextField25.setText("");
      jTextField10.setText("");
        jTextField11.setText("");
    jTextField12.setText("");
      jTextField13.setText("");
        jTextField14.setText("");
    jTextField16.setText("NIL");
  jSpinner4.setValue(1);

    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyReleased
     
        int year=jYearChooser1.getYear();
        String mobile=getValueFromTable(jTable2,1);
        String name=getValueFromTable(jTable2,0);
                String net=getValueFromTable(jTable2,4);
                jLabel10.setText(name);
                                jLabel11.setText(mobile);

                                                jLabel13.setText(net);


       String data="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='"+mobile+"' and price!=0 and pay_day like '%"+year+"%'";
                      String [] col={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width={40,80,80,80,80,80,80,120};
            dataInTable(data,col,jTable3,true,width);
            
                String data1="Select rowid,payment,mode,pay_day from installments where phone='"+mobile+"' and payment <>0 and pay_day like '%"+year+"%'";
                      String [] col1={"Id","Payment","Cheq No.","Date"};

            int [] width1={20,80,80,80};
            dataInTable(data1,col1,jTable1,true,width1);
            
            
    }//GEN-LAST:event_jTable2KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     String filter=jComboBox1.getSelectedItem().toString();
     if(filter.equals("ALL"))
     {
            int year=jYearChooser1.getYear();
                  //before date query
           //  String data="select name,customer.phone,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC ;";
                              String data= "select name,customer.phone,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%"+year+"%' or pay_day='e'),(select sum(payment) from installments where customer.phone=installments.phone and pay_day like '%"+year+"%' or pay_day='e') as Credit,(select sum(price) as Debit from products where customer.phone=products.phone)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC;";       

                   String [] col={"Name","Contact","Products Cost","Payment recieved","Net Balance"};

            int [] width={};
            dataInTable(data, col,jTable2,false,width);
            
                String data2="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='does not exist' and price!=0 and pay_day like '%"+year+"%'";
                      String [] col2={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width2={40,80,80,80,80,80,80,120};
            dataInTable(data2,col2,jTable3,true,width2);
            
                String data1="Select rowid,payment,mode,pay_day from installments where phone='does not exist' and payment <>0 and pay_day like '%"+year+"%'";
                      String [] col1={"Id","Payment","Cheq No.","Date"};

            int [] width1={20,80,80,80};
            dataInTable(data1,col1,jTable1,true,width1);
            
     }
     else if(filter.equals("PENDING"))
     {
                /* String data="select name,customer.phone,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone  having sum(price)-(select sum(payment) from installments where products.phone=installments.phone)>0 ORDER by name ASC ;";
            String [] col={"Name","Contact","Products Cost","Payment recieved","Net Balance"};
            int [] width={};
            dataInTable(data, col,jTable2,false,width);*/
            
            int year=jYearChooser1.getYear();
                  //before date query
           //  String data="select name,customer.phone,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC ;";
                            String data= "select name,customer.phone,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%"+year+"%' or pay_day='e'),(select sum(payment) from installments where customer.phone=installments.phone and pay_day like '%"+year+"%' or pay_day='e') as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as net  from customer  inner join products on products.phone=customer.phone group by customer.phone having sum(price)-(select sum(payment) from installments where products.phone=installments.phone)>0  ORDER by name ASC;";       

                   String [] col={"Name","Contact","Products Cost","Payment recieved","Net Balance"};

            int [] width={};
            dataInTable(data, col,jTable2,false,width);
            
                String data2="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='does not exist' and price!=0 and pay_day like '%"+year+"%'";
                      String [] col2={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width2={40,80,80,80,80,80,80,120};
            dataInTable(data2,col2,jTable3,true,width2);
            
                String data1="Select rowid,payment,mode,pay_day from installments where phone='does not exist' and payment <>0 and pay_day like '%"+year+"%'";
                      String [] col1={"Id","Payment","Cheq No.","Date"};

            int [] width1={20,80,80,80};
            dataInTable(data1,col1,jTable1,true,width1);
            
            
     }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
    
         int year=jYearChooser1.getYear();
        String search=jTextField1.getText();
      
                                    String data= "select name,customer.phone,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%"+year+"%' or pay_day='e'),(select sum(payment) from installments where customer.phone=installments.phone and pay_day like '%"+year+"%' or pay_day='e') as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone where name like '"+search+"%' or customer.phone like '"+search+"%' group by customer.phone ORDER by name ASC;";       

        
   //     String data="select name,customer.phone,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone where name like '"+search+"%' or customer.phone like '"+search+"%'group by customer.phone  ORDER by name ASC ;";
                              String [] col={"Name","Contact","Products Cost","Payment recieved","Net Balance"};

            int [] width={};
            dataInTable(data, col,jTable2,false,width);
      
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       String name=getValueFromTable(jTable2,0);
            String mobile=getValueFromTable(jTable2,1);
                  String net=getValueFromTable(jTable2,4);
        
        if(evt.getClickCount()==2)
        {
            
            String query="select sum(price) as total from products where phone='"+mobile+"' and price!=0;";
            String query1="select sum(payment) as total from installments where phone='"+mobile+"' and payment <>0;";
            String []v={"total"};
            
        String q[]=getValuesfromDb(query, v);
         String p[]=getValuesfromDb(query1, v);
            jLabel98.setText("Total product business - "+q[0]);
               jLabel99.setText("Total Payments - "+p[0]);
            
            jLabel100.setText("Client Name - "+name);
                 jLabel101.setText("Client Phone - "+mobile);
                    jLabel102.setText("Net Balance - "+net);
                    
                    
        String data="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='"+mobile+"' and price!=0;";
                      String [] col={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width={40,80,80,80,80,80,80,120};
            dataInTable(data,col,jTable19,true,width);
            
                String data1="Select rowid,payment,mode,pay_day from installments where phone='"+mobile+"' and payment <>0;";
                      String [] col1={"Id","Payment","Cheq No.","Date"};

            int [] width1={30,100,80,80};
            dataInTable(data1,col1,jTable18,true,width1);
                    
       jDialog9.setVisible(true);
        }
        
        int year=jYearChooser1.getYear();
      
      String q="select name,customer.phone,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC ;";
      String v[]={"debit","credit","net"};
        String total[]=getValuesfromDb(q,v);
     
      
        
                jLabel10.setText(name);
                                jLabel11.setText(mobile);

                                            jLabel13.setText(total[2]);


        String data="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='"+mobile+"' and price!=0 and pay_day like '%"+year+"%'";
                      String [] col={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width={40,80,80,80,80,80,80,120};
            dataInTable(data,col,jTable3,true,width);
            
                String data1="Select rowid,payment,mode,pay_day from installments where phone='"+mobile+"' and payment <>0 and pay_day like '%"+year+"%'";
                      String [] col1={"Id","Payment","Cheq No.","Date"};

            int [] width1={20,80,80,80};
            dataInTable(data1,col1,jTable1,true,width1);
            
            
            
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

           int row=jTable3.getSelectedRow();
             int row1=jTable2.getSelectedRow();
          // String customer_mobile=(jTable2.getModel().getValueAt(row,0).toString());
        if(row==-1 || row1==-1)
        {
            JOptionPane.showMessageDialog(null,"Please select a customer from above table or select entry");
        }
        else
        {
             int a= JOptionPane.showConfirmDialog(this,"Are you sure you want to delete Entry??","conformation message",JOptionPane.YES_NO_CANCEL_OPTION);
        if(a==JOptionPane.YES_OPTION)
        {
            
        String row_num=getValueFromTable(jTable3,0);
 String mobile=getValueFromTable(jTable2,1);
String query="delete from products where rowid='"+row_num+"';";
        executeQuery(query);
                   JOptionPane.showMessageDialog(null,"Product entry removed");
  
         
                   int year=jYearChooser1.getYear();
                     String data= "select name,customer.phone,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%"+year+"%' or pay_day='e'),(select sum(payment) from installments where customer.phone=installments.phone and pay_day like '%"+year+"%' or pay_day='e') as Credit,(select sum(price) as Debit from products where customer.phone=products.phone)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC;";       

                   String [] col={"Name","Contact","Products Cost","Payment recieved","Net Balance"};

            int [] width={};
            dataInTable(data, col,jTable2,false,width);
            
             String data2="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='"+mobile+"' and price!=0 and pay_day like '%"+year+"%'";
                      String [] col2={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width2={40,80,80,80,80,80,80,120};
            dataInTable(data2,col2,jTable3,true,width2);
            
            
            
            
             String query3="select (select sum(price) from products)-(select sum(payment) from installments) as net ";
            String f[]={"net"};
             String get[]=getValuesfromDb(query3,f);
  jLabel77.setText(get[0]);
        }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
          int row=jTable1.getSelectedRow();
             int row1=jTable2.getSelectedRow();
          // String customer_mobile=(jTable2.getModel().getValueAt(row,0).toString());
        if(row==-1 || row1==-1)
        {
            JOptionPane.showMessageDialog(this,"Please select a customer from above table or select entry");
        }
        else
        {
            
             int a= JOptionPane.showConfirmDialog(this,"Are you sure you want to delete Entry??","conformation message",JOptionPane.YES_NO_CANCEL_OPTION);
        if(a==JOptionPane.YES_OPTION)
        {
        String row_num=getValueFromTable(jTable1,0);
 String mobile=getValueFromTable(jTable2,1);
String query="delete from installments where rowid='"+row_num+"';";
        executeQuery(query);
                   JOptionPane.showMessageDialog(null,"Payment entry removed");
  
         int year=jYearChooser1.getYear();
         String data="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='"+mobile+"' and price!=0 and pay_day like '%"+year+"%'";
                      String [] col={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width={40,80,80,80,80,80,80,120};
            dataInTable(data,col,jTable3,true,width);
            
                String data1="Select rowid,payment,mode,pay_day from installments where phone='"+mobile+"' and payment <>0 and pay_day like '%"+year+"%'";
                      String [] col1={"Id","Payment","Cheq No.","Date"};

            int [] width1={20,80,80,80};
            dataInTable(data1,col1,jTable1,true,width1);
            
               String query3="select (select sum(price) from products)-(select sum(payment) from installments) as net ";
            String f[]={"net"};
             String get[]=getValuesfromDb(query3,f);
  jLabel77.setText(get[0]);
        }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           int row=jTable2.getSelectedRow();
          // String customer_mobile=(jTable2.getModel().getValueAt(row,0).toString());
        if(row==-1)
        {
            JOptionPane.showMessageDialog(this,"Please select a customer from above table or select entry");
        }
        else
        {
         int a= JOptionPane.showConfirmDialog(this,"Are you sure you want to delete Customer data\nThis will remove payments and products also??","conformation message",JOptionPane.YES_NO_CANCEL_OPTION);
        if(a==JOptionPane.YES_OPTION)
        {
             String phone=getValueFromTable(jTable2,1);
             
              String query="delete from customer where phone='"+phone+"';";
        executeQuery(query);
             
         String query1="delete from products where phone='"+phone+"';";
        executeQuery(query1);
        
             String query2="delete from installments where phone='"+phone+"';";
        executeQuery(query2);
        
                   JOptionPane.showMessageDialog(null,"Customer all records removed successfully!");
                   
                   int year=jYearChooser1.getYear();
                  //before date query
           //  String data="select name,customer.phone,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC ;";
                         String data= "select name,customer.phone,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%"+year+"%' or pay_day='e'),(select sum(payment) from installments where customer.phone=installments.phone and pay_day like '%"+year+"%' or pay_day='e') as Credit,(select sum(price) as Debit from products where customer.phone=products.phone)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC;";       

                   String [] col={"Name","Contact","Products Cost","Payment recieved","Net Balance"};

            int [] width={};
            dataInTable(data, col,jTable2,false,width);
            
             String data2="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='"+phone+"' and price!=0 and pay_day like '%"+year+"%'";
                      String [] col2={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width2={40,80,80,80,80,80,80,120};
            dataInTable(data2,col2,jTable3,true,width2);
            
                String data1="Select rowid,payment,mode,pay_day from installments where phone='"+phone+"' and payment <>0 and pay_day like '%"+year+"%'";
                      String [] col1={"Id","Payment","Cheq No.","Date"};

            int [] width1={20,80,80,80};
            dataInTable(data1,col1,jTable1,true,width1);
            
                 String query3="select (select sum(price) from products)-(select sum(payment) from installments) as net ";
            String f[]={"net"};
             String get[]=getValuesfromDb(query3,f);
  jLabel77.setText(get[0]);
            
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
/*PrinterJob job = PrinterJob.getPrinterJob();
        MessageFormat[] header = new MessageFormat[6];

            // Assign the arrays with 6 String values for the headers
            header[0] = new MessageFormat("hello");
            header[1] = new MessageFormat("world");
            header[2] = new MessageFormat("");
            header[3] = new MessageFormat("Scrud 60 - Grade Returns - Random Sample");
            header[4] = new MessageFormat("");
            header[5] = new MessageFormat("jkhsd"+" - "+"dsf"+" - "+"kjhsdf");*/
        MessageFormat header=new MessageFormat("All Customers record");


MessageFormat footer=new MessageFormat("Page{0,number,integer}");


try{
   //job.setPrintable(new Printable(( JTable.PrintMode.FIT_WIDTH, header, footer ) {});

            //job.print();
   jTable2.print(JTable.PrintMode.FIT_WIDTH,header, footer);
}
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(this, ex);
    }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        String name=jTextField2.getText();
     String password=jPasswordField1.getText();
         String new_password=jPasswordField2.getText();
        Date date=new Date();

        if(name.equals("")||password.equals("")||new_password.equals(""))
        {
              JOptionPane.showMessageDialog(null, "Please fill all the fields");
        }
              else
                {
                  
            try
            {
                Connection con= connecrdb();
                String a="select * from account where rowid=1";

                Statement st=con.createStatement();

                ResultSet rs=st.executeQuery(a);
                String key_value="";
                String pass="";
              

                while(rs.next())
                {
                    key_value=rs.getString("name");
                    pass=rs.getString("password");

                }
                if(name.equals(key_value) && password.equals(pass))
                {

                    String query="update account set password='"+new_password+"' where rowid=1;";
                    st.execute(query);
                          JOptionPane.showMessageDialog(null, "Username or password changed successfully");
             jTextField2.setText("");
     jPasswordField1.setText("");
     jPasswordField2.setText("");

                }
                  else
        {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
                

            }
            catch(Exception ex)
            {
                    JOptionPane.showMessageDialog(null,ex);

            }

        }
    

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      
         //  jFrame1.setVisible(true);

   jDialog1.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
  
        
      
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        StringBuilder sb=new StringBuilder();
     sb.append("<html><body onload=\"printDiv('printableArea')\"><div id=\"printableArea\">\n" +
"      <h1>Print me123</h1>\n" +
"<input type=\"button\" onclick=\"printDiv('printableArea')\" value=\"print a div!\" /></div>");
    
     
   //Javascript function to print  
     sb.append("<script>function printDiv(divName) {\n" +
"     var printContents = document.getElementById(divName).innerHTML;\n" +
"     var originalContents = document.body.innerHTML;\n" +
"\n" +
"     document.body.innerHTML = printContents;\n" +
"\n" +
"     window.print();\n" +
"\n" +
"     document.body.innerHTML = originalContents;\n" +
"}</script></body></html>");
    
        PrintBill(sb.toString());
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
      
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
      int row=jTable2.getSelectedRow();
          // String customer_mobile=(jTable2.getModel().getValueAt(row,0).toString());
        if(row==-1)
        {
            JOptionPane.showMessageDialog(null,"Please select a customer from above table");
        }
        else
        {
            
              String mobile=(jTable2.getModel().getValueAt(row,1).toString());
               String name=(jTable2.getModel().getValueAt(row,0).toString());
             MessageFormat header=new MessageFormat("Payment record of "+name);


MessageFormat footer=new MessageFormat("Page{0,number,integer}");


try{
 
   jTable1.print(JTable.PrintMode.FIT_WIDTH,header, footer);
}
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(this, ex);
    }
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed

            int row=jTable2.getSelectedRow();
          // String customer_mobile=(jTable2.getModel().getValueAt(row,0).toString());
        if(row==-1)
        {
            JOptionPane.showMessageDialog(null,"Please select a customer from above table");
        }
        else
        {
        
        String name=getValueFromTable(jTable2,0);
       String mobile=getValueFromTable(jTable2,1);
                  String net=getValueFromTable(jTable2,4);
    
            
            String query="select sum(price) as total from products where phone='"+mobile+"' and price!=0;";
            String query1="select sum(payment) as total from installments where phone='"+mobile+"' and payment <>0;";
            String []v={"total"};
            
        String q[]=getValuesfromDb(query, v);
         String p[]=getValuesfromDb(query1, v);
            jLabel98.setText("Total product business - "+q[0]);
               jLabel99.setText("Total Payments - "+p[0]);
            
            jLabel100.setText("Client Name - "+name);
                 jLabel101.setText("Client Phone - "+mobile);
                    jLabel102.setText("Net Balance - "+net);
                    
                    
        String data="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='"+mobile+"' and price!=0;";
                      String [] col={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width={40,80,80,80,80,80,80,120};
            dataInTable(data,col,jTable19,true,width);
            
                String data1="Select rowid,payment,mode,pay_day from installments where phone='"+mobile+"' and payment <>0;";
                      String [] col1={"Id","Payment","Cheq No.","Date"};

            int [] width1={30,100,80,80};
            dataInTable(data1,col1,jTable18,true,width1);
                    
       jDialog9.setVisible(true);
        }    
        //jFrame2.setVisible(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
 
        jLabel96.setText("Products categories");
   
          String query1="select rowid,* from product_type;";
               String [] col={"Product ID","Product Name"};

            int [] width={100,300};
            dataInTable(query1,col,jTable17,true,width);
                   jDialog8.setSize(570,365);
        jDialog8.setLocationRelativeTo(null);
            jDialog8.setModal(true);
        jDialog8.setVisible(true);
               
      
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
     jLabel96.setText("Brand categories");
    
       String query1="select rowid,* from brands;";
               String [] col={"ID","Product Name","Brand Name"};

            int [] width={50,160,160};
            dataInTable(query1,col,jTable17,true,width);
            try
                {
                     Connection con=connecrdb();
                 String a="Select * from product_type";
              
                    Statement st=con.createStatement();
                 
                    ResultSet rs=st.executeQuery(a);
                 
                 
                               
                    while(rs.next())
                    {
                      
                     jComboBox2.addItem(rs.getString("name"));
                 }
                }
                    catch(Exception ex)
                            {
                            JOptionPane.showMessageDialog(null,ex);
                            }
            
          jDialog8.setSize(570,365);
        jDialog8.setLocationRelativeTo(null);
            jDialog8.setModal(true);
        jDialog8.setVisible(true);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed

        
        jLabel96.setText("                          Distributors");
        
           String query1="select rowid,* from distributor;";
               String [] col={"ID","Company","Name","Phone","Email","Address","City"};

            int [] width={50,160,160,120,160,200,100};
            dataInTable(query1,col,jTable17,true,width);
       jDialog8.setSize(950, 500);
         jDialog8.setLocationRelativeTo(null);
        jDialog8.setVisible(true);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
      String check=jLabel96.getText();
      if(check.equals("Products categories"))
      {
            jDialog5.setVisible(true);
      }
      else if(check.equals("Brand categories"))
      {
           jComboBox2.removeAll();  
            jDialog6.setVisible(true);
      }
          else if(check.equals("                          Distributors"))
      {
            jDialog7.setVisible(true);
      }
        else if(check.equals("                          Item Categories"))
      {
            jDialog11.setVisible(true);
      }
      
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
int year=jYearChooser1.getYear();
                  //before date query
           //  String data="select name,customer.phone,sum(price) as Debit,(select sum(payment) from installments where customer.phone=installments.phone) as Credit,sum(price)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC ;";
                          String data= "select name,customer.phone,(select sum(price) as Debit from products where customer.phone=products.phone and pay_day like '%"+year+"%' or pay_day='e'),(select sum(payment) from installments where customer.phone=installments.phone and pay_day like '%"+year+"%' or pay_day='e') as Credit,(select sum(price) as Debit from products where customer.phone=products.phone)-(select sum(payment) from installments where products.phone=installments.phone) as Net  from customer  inner join products on products.phone=customer.phone group by customer.phone ORDER by name ASC;";       

                   String [] col={"Name","Contact","Products Cost","Payment recieved","Net Balance"};

            int [] width={};
            dataInTable(data, col,jTable2,false,width);
            
                String data2="Select rowid,type,brand,product,unit,quantity,price,pay_day from products where phone='does not exist' and price!=0 and pay_day like '%"+year+"%'";
                      String [] col2={"Id","Product","Brand","Model","Unit Cost","Qty.","Total Cost","Date"};

            int [] width2={40,80,80,80,80,80,80,120};
            dataInTable(data2,col2,jTable3,true,width2);
            
                String data1="Select rowid,payment,mode,pay_day from installments where phone='does not exist' and payment <>0 and pay_day like '%"+year+"%'";
                      String [] col1={"Id","Payment","Cheq No.","Date"};

            int [] width1={20,80,80,80};
            dataInTable(data1,col1,jTable1,true,width1);
            
            
                 String query="select (select sum(price) from products)-(select sum(payment) from installments) as net ";
            String f[]={"net"};
    String get[]=getValuesfromDb(query,f);
  jLabel77.setText(get[0]);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased

        String name=jTextField8.getText();
        
     if(jCheckBox11.isSelected())
     {
      
             String data="Select name,phone from customer where name like '"+name+"%'";
                      String [] col={"Customer","Phone"};

            int [] width={};
            dataInTable(data,col,jTable20,false,width);
    if(evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyCode() != KeyEvent.VK_CAPS_LOCK && evt.getKeyCode() != KeyEvent.VK_TAB )
    {  
         int row=jTable20.getRowCount();
               
        if(row!=0){
        jDialog10.setSize(170,190);
  jDialog10.setLocation(400,200);
   

  jDialog10.setTitle("Customers");
         jDialog10.setModal(true);
      jDialog10.setVisible(true);
            }
            }
     }
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTable20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable20MouseClicked
         String title=jDialog10.getTitle();
        
         if(title.equals("Customers"))
         {
         String phone=getValueFromTable(jTable20,1);
    String query="select * from customer where phone='"+phone+"'";
    String val[]={"name","phone","city"};
    
    String get[]=getValuesfromDb(query, val);
    jTextField8.setText(get[0]);
        jTextField9.setText(get[1]);

            jTextField25.setText(get[2]);
jDialog10.setVisible(false);
         }
         
         
           else  if(title.equals("Products"))
         {
         String product=getValueFromTable(jTable20,0);
    String query="select * from product_type where name='"+product+"'";
    String val[]={"name"};
    
    String get[]=getValuesfromDb(query, val);
    jTextField10.setText(get[0]);
    
jDialog10.setVisible(false);
         }
         
           else  if(title.equals("Brands"))
         {
         String product=getValueFromTable(jTable20,0);
    String query="select * from brands where name='"+product+"'";
    String val[]={"name"};
    
    String get[]=getValuesfromDb(query, val);
    jTextField11.setText(get[0]);
    
jDialog10.setVisible(false);
         }
           else  if(title.equals("Distributors"))
         {
         String product=getValueFromTable(jTable20,0);
    String query="select * from distributor where company='"+product+"'";
    String val[]={"company","phone","address","city"};
    
    String get[]=getValuesfromDb(query, val);
    jTextField39.setText(get[0]);
        jTextField40.setText(get[1]);

            jTextField41.setText(get[2]+"-"+get[3]);
  

jDialog10.setVisible(false);
         }
    
    }//GEN-LAST:event_jTable20MouseClicked

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
       String name=jTextField10.getText();
        
     if(jCheckBox11.isSelected())
     {
      
             String data="Select name from product_type where name like '"+name+"%' order by name ASC";
                      String [] col={"Product type"};

            int [] width={};
            dataInTable(data,col,jTable20,false,width);
         if(evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyCode() != KeyEvent.VK_CAPS_LOCK && evt.getKeyCode() != KeyEvent.VK_TAB)
    {  
         int row=jTable20.getRowCount();
            if(row!=0){
        jDialog10.setSize(170,190);
  jDialog10.setLocation(400,260);
  jDialog10.setTitle("Products");
         jDialog10.setModal(true);
      jDialog10.setVisible(true);
    }

       }
     
     }
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
       String name=jTextField11.getText();
         String type=jTextField10.getText();
         
     if(jCheckBox11.isSelected())
     {
      
             String data="Select name from brands where name like '"+name+"%' order by name ASC";
                      String [] col={"Brand type"};

            int [] width={};
            dataInTable(data,col,jTable20,false,width);
         if(evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyCode() != KeyEvent.VK_CAPS_LOCK && evt.getKeyCode() != KeyEvent.VK_TAB)
    {  
         int row=jTable20.getRowCount();
            if(row!=0){
        jDialog10.setSize(170,190);
  jDialog10.setLocation(400,300);
  jDialog10.setTitle("Brands");
         jDialog10.setModal(true);
      jDialog10.setVisible(true);
    }

       }
     
     }
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
 
          String data="Select id,product,brand,item,distributor,cost,sell,sum(units) as unit,date,status from stock group by item";
                      String [] col={"Item Id","Product","Brand","Item/Model No.","Distributor","Buy Price","Sell Price","Stock Left","Order Date","Status"};

            int [] width={100,200,200,200,300,150,150,100,200,150};
            dataInTable(data,col,jTable14,true,width);
        jFrame2.setVisible(true);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
    jFrame1.setVisible(true);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
    String price_string=jTextField42.getText();
  
    
    int unit=(int)jSpinner5.getValue();
    String invoice=jTextField38.getText();
    String distri=jTextField39.getText();
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
      
      Date d=jDateChooser5.getDate();
  
     String sell=jTextField46.getText();
    
  
    
    String product=getValueFromTable(jTable22,0);
        String brand=getValueFromTable(jTable24,0);
          String item_id=getValueFromTable(jTable21,0);
    String item=getValueFromTable(jTable21,1);
    
    
    String payment=jTextField43.getText();
    int charges;
    if(payment.equals(""))
    {
        charges=0;
    }
    else
    {
        charges=Integer.parseInt(payment);
    }
    
        String paid=jTextField44.getText();
          int paid_out;
    if(paid.equals(""))
    {
        paid_out=0;
    }
    else
    {
        paid_out=Integer.parseInt(paid);
    }

    
    
    if(!price_string.equals("")&& !distri.equals("")&&d!=null){
        
           String date = sdf.format(jDateChooser5.getDate());
          int price=Integer.parseInt(price_string);
            int total=price*unit;
            
            
    String query="insert into order_in values('"+product+"','"+brand+"','"+item+"',"+unit+","+price+","+total+")";
        executeQuery(query);
        
    
             String query2="insert into stock values('"+invoice+"','"+distri+"','"+product+"','"+brand+"','"+item+"','"+price+"','"+unit+"','"+sell+"','"+date+"','In-Stock','"+item_id+"')";

     executeQuery(query2);
        
   /*  String query3="insert into invoice values('"+invoice+"','"+date+"','"+charges+"')";
      executeQuery(query3);
      
      String query4="insert into invoice_payments values('"+invoice+"','"+paid_out+"','"+date+"','payment')";
            executeQuery(query4);*/

        
          String data="Select rowid,* from order_in";
                      String [] col={"No.","Product","Brand","Item","Units","Unit Price","Total"};

            int [] width={50,150,150,150,100,150,150};
            dataInTable(data,col,jTable23,true,width);
    
            String query1="Select sum(total) as sub from order_in";
            
            String val[]={"sub"};
            String get[]=getValuesfromDb(query1, val);
    jLabel117.setText("Sub Total = "+get[0]);
    jTextField42.setText("");
        jTextField46.setText("");

    }
    else
    {
        JOptionPane.showMessageDialog(null, "Please fill the entry");
    }
    
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
     jLabel96.setText("                          Item Categories");
     
           String query1="select rowid,* from items;";
               String [] col={"ID","Product Name","Brand Name","Item/Model No."};

                     int [] width={50,200,200,200};

            dataInTable(query1,col,jTable17,true,width);
            try
                {
                     Connection con=connecrdb();
                 String a="Select * from product_type";
              
                    Statement st=con.createStatement();
                 
                    ResultSet rs=st.executeQuery(a);
                 
                 
                               
                    while(rs.next())
                    {
                      
                     jComboBox3.addItem(rs.getString("name"));
                 }
                      String b="Select * from brands";
                                          ResultSet vs=st.executeQuery(b);
         while(vs.next())
                    {
                      
                     jComboBox4.addItem(vs.getString("name"));
                 }
                    
                }
                    catch(Exception ex)
                            {
                            JOptionPane.showMessageDialog(null,ex);
                            }
            
       jDialog8.setSize(800, 400);
         jDialog8.setLocationRelativeTo(null);
        jDialog8.setVisible(true);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
jCheckBox13.setSelected(true);
 jTextField42.setText("");
          jTextField46.setText("");
        //  jSpinner5.setValue(1);        
 
          String query="DELETE FROM order_in";
          executeQuery(query);

    String query1="select name from product_type;";
               String [] col={"Product Name"};

            int [] width={};
            dataInTable(query1,col,jTable22,false,width);

        jFrame3.setVisible(true);
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
    String product=jTextField30.getText();
    if(!product.equals("")){
    String query="INSERT INTO product_type(name)SELECT '"+product+"'";
        executeQuery(query);
        JOptionPane.showMessageDialog(null,"Product added");
        String query1="select rowid,* from product_type;";
               String [] col={"Product ID","Product Name"};

            int [] width={100,300};
            dataInTable(query1,col,jTable17,true,width);
            jTextField30.setText("");
    }
      else
     {
         JOptionPane.showMessageDialog(null,"Please provide the values");
     }
        
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
    
        String product=jComboBox2.getSelectedItem().toString();
        String brand=jTextField31.getText();
        
        if(!brand.equals("")){
    String query="INSERT INTO brands(type,name)SELECT '"+product+"','"+brand+"';";
        executeQuery(query);
        JOptionPane.showMessageDialog(null,"Brand added");
        
        String query1="select rowid,* from brands;";
               String [] col={"ID","Product Name","Brand Name"};

            int [] width={50,160,160};
            dataInTable(query1,col,jTable17,true,width);
            jTextField31.setText("");
        }
          else
     {
         JOptionPane.showMessageDialog(null,"Please provide the values");
     }
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
     String company=jTextField37.getText();
     String name=jTextField32.getText();
          String phone=jTextField33.getText();
     String email=jTextField34.getText();
     String address=jTextField35.getText();
     String city=jTextField36.getText();
     
     if(!company.equals("")&&!name.equals("")&&!phone.equals("")){
     String query="insert into distributor values('"+company+"','"+name+"','"+phone+"','"+email+"','"+address+"','"+city+"')";
        executeQuery(query);
         JOptionPane.showMessageDialog(null,"Distributor added");
        
        String query1="select rowid,* from distributor;";
               String [] col={"ID","Company","Name","Phone","Email","Address","City"};

            int [] width={50,160,160,120,160,200,100};
            dataInTable(query1,col,jTable17,true,width);
            jTextField37.setText("");
                        jTextField32.setText("");
            jTextField33.setText("");
            jTextField34.setText("");
            jTextField35.setText("");
            jTextField36.setText("");

            
                        
     }
     else
     {
         JOptionPane.showMessageDialog(null,"Please provide the values");
     }
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
       String product=jComboBox3.getSelectedItem().toString();
              String brand=jComboBox4.getSelectedItem().toString();
String item=jTextField45.getText();
  if(!item.equals("")){
String query="insert into items values('"+product+"','"+brand+"','"+item+"')";
      executeQuery(query);
         JOptionPane.showMessageDialog(null,"Item added");
        
        String query1="select rowid,* from items;";
                      String [] col={"ID","Product Name","Brand Name","Item/Model No."};


            int [] width={50,200,200,200};
            dataInTable(query1,col,jTable17,true,width);
            jTextField45.setText("");
           

            
                        
     }
     else
     {
         JOptionPane.showMessageDialog(null,"Please provide the values");
     }
  
  
  
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jTextField39KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField39KeyReleased

           if(jCheckBox13.isSelected())
     {
      
        String name=jTextField39.getText();
        
        String data="Select company,name,phone from distributor where company like '"+name+"%'";
                      String [] col={"Company"};

            int [] width={};
            dataInTable(data,col,jTable20,false,width);
    if(evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyCode() != KeyEvent.VK_CAPS_LOCK && evt.getKeyCode() != KeyEvent.VK_TAB )
    {  
         int row=jTable20.getRowCount();
               
        if(row!=0){
        jDialog10.setSize(170,190);
  jDialog10.setLocation(670,85);
   

  jDialog10.setTitle("Distributors");
         jDialog10.setModal(true);
      jDialog10.setVisible(true);
            }
    }
     }
    }//GEN-LAST:event_jTextField39KeyReleased

    private void jTable22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable22MouseClicked
   String name=getValueFromTable(jTable22, 0);
        
        String data="Select brand from items where product= '"+name+"'";
                      String [] col={"Company"};

            int [] width={};
            dataInTable(data,col,jTable24,false,width);
            
               String data1="Select * from items where item='does not exist'";
                      String [] col1={"Items/Model No."};

            int [] width1={};
            dataInTable(data1,col1,jTable21,false,width1);
    }//GEN-LAST:event_jTable22MouseClicked

    private void jTable22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable22KeyReleased
       String name=getValueFromTable(jTable22, 0);
        
              String data="Select brand from items where product= '"+name+"'";

                      String [] col={"Company"};

            int [] width={};
            dataInTable(data,col,jTable24,false,width);
            
                     String data1="Select * from items where item='does not exist'";
                      String [] col1={"Items/Model No."};

            int [] width1={};
            dataInTable(data1,col1,jTable21,false,width1);
    }//GEN-LAST:event_jTable22KeyReleased

    private void jTable24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable24KeyReleased
 
               String product=getValueFromTable(jTable22, 0);

        String name=getValueFromTable(jTable24, 0);
        
        String data="Select rowid,item from items where product= '"+product+"' and brand='"+name+"'";
                      String [] col={"Id","Items/Model No."};

            int [] width={60,300};
            dataInTable(data,col,jTable21,true,width);
    }//GEN-LAST:event_jTable24KeyReleased

    private void jTable24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable24MouseClicked
        String product=getValueFromTable(jTable22, 0);

        String name=getValueFromTable(jTable24, 0);
        
        String data="Select rowid,item from items where product= '"+product+"' and brand='"+name+"'";
                      String [] col={"Id","Items/Model No."};

            int [] width={60,300};
            dataInTable(data,col,jTable21,true,width);
    }//GEN-LAST:event_jTable24MouseClicked

    private void jSpinner5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner5StateChanged
    String pric=jTextField42.getText();
    int price=Integer.parseInt(pric);
    
    int quan=(Integer)jSpinner5.getValue();
    
    jLabel114.setText("Total : "+(price*quan));
    
    
    }//GEN-LAST:event_jSpinner5StateChanged

    private void jSpinner5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner5KeyReleased
     String pric=jTextField42.getText();
    int price=Integer.parseInt(pric);
    
    int quan=(Integer)jSpinner5.getValue();
    
    jLabel114.setText("Total : "+(price*quan));
    }//GEN-LAST:event_jSpinner5KeyReleased

    private void jSpinner5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner5KeyPressed
      String pric=jTextField42.getText();
    int price=Integer.parseInt(pric);
    
    int quan=(Integer)jSpinner5.getValue();
    
    jLabel114.setText("Total : "+(price*quan));
    }//GEN-LAST:event_jSpinner5KeyPressed

    private void jTextField46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField46ActionPerformed

    private void jTable21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable21MouseClicked
     jTextField42.setText("");
          jTextField46.setText("");
            jLabel114.setText("Total : ");
            
            String id=getValueFromTable(jTable21,0);
               String item=getValueFromTable(jTable21,1);
            
            String query="Select sum(units) as bal from stock where item='"+item+"' and id='"+id+"'";
            String values[]={"bal"};
            
            String get[]=getValuesfromDb(query, values);
            jLabel111.setText("Units Left : "+get[0]);
            
            
    

    }//GEN-LAST:event_jTable21MouseClicked

    private void jTextField43KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField43KeyReleased
     String cost=jTextField43.getText();
     if(!cost.equals("")){
        int costs=Integer.parseInt(cost);   
        
        String query1="Select sum(total) as sub from order_in";
            
            String val[]={"sub"};
            String get[]=getValuesfromDb(query1, val);
            
          int sub=Integer.parseInt(get[0]);
          
          jLabel116.setText("Final Amount : "+(costs+sub));
     }
     else
     {
           String query1="Select sum(total) as sub from order_in";
            
            String val[]={"sub"};
            String get[]=getValuesfromDb(query1, val);
            
          int sub=Integer.parseInt(get[0]);
          
          jLabel116.setText("Final Amount : "+(sub));
     }
          
    }//GEN-LAST:event_jTextField43KeyReleased

    private void jTextField44KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField44KeyReleased
      String payment=jTextField44.getText();
        String cost=jTextField43.getText();
         int costs;
     if(!payment.equals("")){
         if(!cost.equals("")){
  costs=Integer.parseInt(cost);   
         }
         else
         {
             costs=0;
         }
        int payments=Integer.parseInt(payment);   
        
        String query1="Select sum(total) as sub from order_in";
            
            String val[]={"sub"};
            String get[]=getValuesfromDb(query1, val);
            
          int sub=Integer.parseInt(get[0]);
          
          jLabel121.setText("Balance : "+((costs+sub)-payments));
     }
     else
     {
              if(!cost.equals("")){
  costs=Integer.parseInt(cost);   
         }
         else
         {
             costs=0;
         }
           String query1="Select sum(total) as sub from order_in";
            
            String val[]={"sub"};
            String get[]=getValuesfromDb(query1, val);
            
          int sub=Integer.parseInt(get[0]);
          
          jLabel121.setText("Balance : "+(sub+costs));
     }
          
    }//GEN-LAST:event_jTextField44KeyReleased

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
    String invoice=jTextField38.getText();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String date = sdf.format(jDateChooser5.getDate());
        String payment=jTextField43.getText();
    int charges;
    if(payment.equals(""))
    {
        charges=0;
    }
    else
    {
        charges=Integer.parseInt(payment);
    }
    
        String paid=jTextField44.getText();
          int paid_out;
    if(paid.equals(""))
    {
        paid_out=0;
    }
    else
    {
        paid_out=Integer.parseInt(paid);
    }
   String query1="insert into invoice values('"+invoice+"','"+date+"','"+charges+"')";
      executeQuery(query1);
      
      String query2="insert into invoice_payments values('"+invoice+"','"+paid_out+"','"+date+"','payment')";
            executeQuery(query2);
            
           
            JOptionPane.showMessageDialog(null,"Entry saved");
            
            jCheckBox13.setSelected(true);

        //  jSpinner5.setValue(1);        
 
          String query="DELETE FROM order_in";
          executeQuery(query);

    String query3="select name from product_type;";
               String [] col={"Product Name"};

            int [] width={};
            dataInTable(query3,col,jTable22,false,width);
            
               String data="Select rowid,* from order_in";
                      String [] colum={"No.","Product","Brand","Item","Units","Unit Price","Total"};

            int [] width1={50,150,150,150,100,150,150};
            dataInTable(data,colum,jTable23,true,width1);
            
             String data2="Select * from items where item='does not exist'";
                      String [] col1={"Items/Model No."};
                        String [] col2={"Brands"};

            int [] width2={};
            dataInTable(data2,col1,jTable21,false,width2);
    dataInTable(data2,col2,jTable24,false,width2);
            
            String query4="Select sum(total) as sub from order_in";
            
            String val[]={"sub"};
            String get[]=getValuesfromDb(query4, val);
    jLabel117.setText("Sub Total = "+get[0]);
    jTextField42.setText("");
        jTextField46.setText("");
           jTextField38.setText("");
           jTextField39.setText("");
           jTextField40.setText("");
           jTextField41.setText("");
               jTextField43.setText("");
           jTextField44.setText("");
           jLabel114.setText("Total : ");
           jLabel116.setText("Final Amount : ");
                      jLabel121.setText("Balance : ");


    
    }//GEN-LAST:event_jButton44ActionPerformed

      public static String getValueFromTable(JTable table,int col)
    {
        String value="";
         int row=table.getSelectedRow();
         if(row!=-1)
         {
                value=(table.getModel().getValueAt(row,col).toString());
      
         }
         else
         {
             JOptionPane.showMessageDialog(null,"Please select a entry from table");
         }
             return value;  
    }
    
    
          public static void dataInTable(String query,String[] col,JTable table,boolean flag,int []width)
 {
      try
              {
            
                   Connection con=connecrdb();
             String s=query;
             Statement st=con.createStatement();
               ResultSet rs=st.executeQuery(s);
             ResultSetMetaData rsmt=rs.getMetaData();
             int c=rsmt.getColumnCount();
             Vector column=new Vector(c);
             
        for(int i=0;i<col.length;i++)
             {
             column.add(col[i]); 
             }
        
             
             Vector data=new Vector();
             Vector row=new Vector();
             while(rs.next())
             {
                 row=new Vector(c);
                 for(int i=1;i<=c;i++)
                 {
                     row.add(rs.getString(i));
                     
                 }
                 data.add(row);
              
             }
           
        //    DefaultTableModel dm=new DefaultTableModel(data,column);
            
              DefaultTableModel dm = new DefaultTableModel(data, column) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
            table.setModel(dm);
            
            if(flag && width.length>0)
            {
               
               switch(width.length)
               {
                   case 1:
             table.getColumnModel().getColumn(0).setPreferredWidth(width[0]);
             break;
             
                   case 2:
                         table.getColumnModel().getColumn(0).setPreferredWidth(width[0]);
                           table.getColumnModel().getColumn(1).setPreferredWidth(width[1]);
                           break;
                            case 3:
                         table.getColumnModel().getColumn(0).setPreferredWidth(width[0]);
                           table.getColumnModel().getColumn(1).setPreferredWidth(width[1]);
                             table.getColumnModel().getColumn(2).setPreferredWidth(width[2]);
                             break;
                                case 4:
                         table.getColumnModel().getColumn(0).setPreferredWidth(width[0]);
                           table.getColumnModel().getColumn(1).setPreferredWidth(width[1]);
                             table.getColumnModel().getColumn(2).setPreferredWidth(width[2]);
                               table.getColumnModel().getColumn(3).setPreferredWidth(width[3]);
                               break;
                                         case 5:
                         table.getColumnModel().getColumn(0).setPreferredWidth(width[0]);
                           table.getColumnModel().getColumn(1).setPreferredWidth(width[1]);
                             table.getColumnModel().getColumn(2).setPreferredWidth(width[2]);
                               table.getColumnModel().getColumn(3).setPreferredWidth(width[3]);
                                      table.getColumnModel().getColumn(4).setPreferredWidth(width[4]);
                                      break;
                                           case 6:
                         table.getColumnModel().getColumn(0).setPreferredWidth(width[0]);
                           table.getColumnModel().getColumn(1).setPreferredWidth(width[1]);
                             table.getColumnModel().getColumn(2).setPreferredWidth(width[2]);
                               table.getColumnModel().getColumn(3).setPreferredWidth(width[3]);
                                 table.getColumnModel().getColumn(4).setPreferredWidth(width[4]);
                                      table.getColumnModel().getColumn(5).setPreferredWidth(width[5]);
                                      break;
                                              case 7:
                         table.getColumnModel().getColumn(0).setPreferredWidth(width[0]);
                           table.getColumnModel().getColumn(1).setPreferredWidth(width[1]);
                             table.getColumnModel().getColumn(2).setPreferredWidth(width[2]);
                               table.getColumnModel().getColumn(3).setPreferredWidth(width[3]);
                                 table.getColumnModel().getColumn(4).setPreferredWidth(width[4]);
                                      table.getColumnModel().getColumn(5).setPreferredWidth(width[5]);
                                         table.getColumnModel().getColumn(6).setPreferredWidth(width[6]);
                                      break;
                                                 case 8:
                         table.getColumnModel().getColumn(0).setPreferredWidth(width[0]);
                           table.getColumnModel().getColumn(1).setPreferredWidth(width[1]);
                             table.getColumnModel().getColumn(2).setPreferredWidth(width[2]);
                               table.getColumnModel().getColumn(3).setPreferredWidth(width[3]);
                                 table.getColumnModel().getColumn(4).setPreferredWidth(width[4]);
                                      table.getColumnModel().getColumn(5).setPreferredWidth(width[5]);
                                         table.getColumnModel().getColumn(6).setPreferredWidth(width[6]);
                                          table.getColumnModel().getColumn(7).setPreferredWidth(width[7]);
                                      break;
                                            case 9:
                         table.getColumnModel().getColumn(0).setPreferredWidth(width[0]);
                           table.getColumnModel().getColumn(1).setPreferredWidth(width[1]);
                             table.getColumnModel().getColumn(2).setPreferredWidth(width[2]);
                               table.getColumnModel().getColumn(3).setPreferredWidth(width[3]);
                                 table.getColumnModel().getColumn(4).setPreferredWidth(width[4]);
                                      table.getColumnModel().getColumn(5).setPreferredWidth(width[5]);
                                         table.getColumnModel().getColumn(6).setPreferredWidth(width[6]);
                                          table.getColumnModel().getColumn(7).setPreferredWidth(width[7]);
                                              table.getColumnModel().getColumn(8).setPreferredWidth(width[8]);
                                      break;
                                            case 10:
                         table.getColumnModel().getColumn(0).setPreferredWidth(width[0]);
                           table.getColumnModel().getColumn(1).setPreferredWidth(width[1]);
                             table.getColumnModel().getColumn(2).setPreferredWidth(width[2]);
                               table.getColumnModel().getColumn(3).setPreferredWidth(width[3]);
                                 table.getColumnModel().getColumn(4).setPreferredWidth(width[4]);
                                      table.getColumnModel().getColumn(5).setPreferredWidth(width[5]);
                                         table.getColumnModel().getColumn(6).setPreferredWidth(width[6]);
                                          table.getColumnModel().getColumn(7).setPreferredWidth(width[7]);
                                            table.getColumnModel().getColumn(8).setPreferredWidth(width[8]);
                                              table.getColumnModel().getColumn(9).setPreferredWidth(width[9]);
                                      break;
                                            case 11:
                         table.getColumnModel().getColumn(0).setPreferredWidth(width[0]);
                           table.getColumnModel().getColumn(1).setPreferredWidth(width[1]);
                             table.getColumnModel().getColumn(2).setPreferredWidth(width[2]);
                               table.getColumnModel().getColumn(3).setPreferredWidth(width[3]);
                                 table.getColumnModel().getColumn(4).setPreferredWidth(width[4]);
                                      table.getColumnModel().getColumn(5).setPreferredWidth(width[5]);
                                         table.getColumnModel().getColumn(6).setPreferredWidth(width[6]);
                                          table.getColumnModel().getColumn(7).setPreferredWidth(width[7]);
                                               table.getColumnModel().getColumn(8).setPreferredWidth(width[8]);
                                              table.getColumnModel().getColumn(9).setPreferredWidth(width[9]);
                                                table.getColumnModel().getColumn(10).setPreferredWidth(width[10]);

                                      break;

                                default:
               }
               
            }


         }
         catch(Exception ex)
         {
             if(!ex.toString().contains("unique"))
             JOptionPane.showMessageDialog(null, ex);
         }
        
 }
          
          public static Connection connecrdb()
    {
        try
        {
        Class.forName("org.sqlite.JDBC");
        Connection conn=DriverManager.getConnection("jdbc:sqlite:Accounts.sqlite");
       
        return conn;
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"connection not found");
            return null;
        }
    }
 
 public static boolean executeQuery(String query)
 {
     boolean check;
     try{
       Connection con=connecrdb();
             String s=query;
             Statement st=con.createStatement();
               st.execute(s);
               check=true;
     }
     catch(Exception ex)
     {
         if(!ex.toString().contains("unique")){
                JOptionPane.showMessageDialog(null,ex);
         }
                 check=false;

     }
     return check;
 }
 
    public static int documents()
   {
       String get="select * from log where id=1;";
       int a=0;
          try{
               Connection con=connecrdb();
              
                 Statement st=con.createStatement();
                   ResultSet vs=st.executeQuery(get);
                   while(vs.next())
                   {
                       a=vs.getInt("attempt");
                   }
          }
          catch(Exception ex)
          {
             
          }
       return a;
   }
    
    public static String matrix_revolutions_mr_anderson_neo_zenon()
   {
       StringBuilder abc=new StringBuilder();
          try{
    Process p = Runtime.getRuntime().exec("getmac /fo csv /nh");
    java.io.BufferedReader in = new java.io.BufferedReader(new  java.io.InputStreamReader(p.getInputStream()));
    String line;
    line = in.readLine();        
    String[] result = line.split(",");

    //System.out.println(result[0].replace('"', ' ').trim());
    String a=(result[0].replace('"', ' ').trim());
  
    char d[]=new char[17];
int v[]=new int[100];

for(int i=0;i<d.length;i++)
{
d[i]=a.charAt(i);
v[i]=(d[i]&d[2])|d[7]&d[3];
//System.out.print(v[i]);

abc.append(v[i]);

}
 
    }
    catch(Exception ex)
    {
        
    }
       
         return abc+"f";
   }
    
    
    public void PrintBill(String data)
	{
		   try{    
			
			   
			   File fout = new File("Bill.html");
			   
			 
				FileOutputStream fos = new FileOutputStream(fout);
			 
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	
					bw.write(data);
					bw.newLine();
		           bw.close();
                           
                              if (Desktop.isDesktopSupported()) {
                                  URI uri=fout.toURI();
	    Desktop.getDesktop().browse(uri);
	  
	    } else { /* TODO: error handling */ }
	          }catch(Exception e){System.out.println(e);}    
	        
	}
	
    public static String[] getValuesfromDb(String query,String values[])
    {
        
        String get[]=new String[values.length];
       
            try
                {
                     Connection con=connecrdb();
                 String a=query;
              
                    Statement st=con.createStatement();
                 
                    ResultSet rs=st.executeQuery(a);
                 
                 
                               
                    while(rs.next())
                    {
                        for(int i=0;i<values.length;i++)
                        {
                       get[i]=rs.getString(values[i]);
                        }
                     
                 }
                }
                    catch(Exception ex)
                            {
                            JOptionPane.showMessageDialog(null,ex);
                            }
            return get;
    }
    
    
    private static JTable getNewRenderedTable(final JTable table,int col_num) {
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                String status = (String)table.getModel().getValueAt(row, col_num);
                if ("active".equals(status)) {
                    setBackground(Color.BLACK);
                    setForeground(Color.WHITE);
                } else {
                    setBackground(table.getBackground());
                    setForeground(table.getForeground());
                }       
                return this;
            }   
        });
        return table;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       try
     {
         //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
       
     }
     catch(Exception ex){}
   
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Finance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton10;
    public javax.swing.JButton jButton11;
    public javax.swing.JButton jButton12;
    public javax.swing.JButton jButton13;
    public javax.swing.JButton jButton14;
    public javax.swing.JButton jButton15;
    public javax.swing.JButton jButton16;
    public javax.swing.JButton jButton17;
    public javax.swing.JButton jButton18;
    public javax.swing.JButton jButton19;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton20;
    public javax.swing.JButton jButton21;
    public javax.swing.JButton jButton22;
    public javax.swing.JButton jButton23;
    public javax.swing.JButton jButton24;
    public javax.swing.JButton jButton25;
    public javax.swing.JButton jButton26;
    public javax.swing.JButton jButton27;
    public javax.swing.JButton jButton28;
    public javax.swing.JButton jButton29;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton30;
    public javax.swing.JButton jButton31;
    public javax.swing.JButton jButton32;
    public javax.swing.JButton jButton33;
    public javax.swing.JButton jButton34;
    public javax.swing.JButton jButton35;
    public javax.swing.JButton jButton36;
    public javax.swing.JButton jButton37;
    public javax.swing.JButton jButton38;
    public javax.swing.JButton jButton39;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton40;
    public javax.swing.JButton jButton41;
    public javax.swing.JButton jButton42;
    public javax.swing.JButton jButton44;
    public javax.swing.JButton jButton46;
    public javax.swing.JButton jButton47;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    public javax.swing.JButton jButton9;
    public javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JCheckBox jCheckBox10;
    public javax.swing.JCheckBox jCheckBox11;
    public javax.swing.JCheckBox jCheckBox13;
    public javax.swing.JCheckBox jCheckBox2;
    public javax.swing.JCheckBox jCheckBox3;
    public javax.swing.JCheckBox jCheckBox4;
    public javax.swing.JCheckBox jCheckBox5;
    public javax.swing.JCheckBox jCheckBox6;
    public javax.swing.JCheckBox jCheckBox7;
    public javax.swing.JCheckBox jCheckBox8;
    public javax.swing.JCheckBox jCheckBox9;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JComboBox<String> jComboBox2;
    public javax.swing.JComboBox<String> jComboBox3;
    public javax.swing.JComboBox<String> jComboBox4;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    public com.toedter.calendar.JDateChooser jDateChooser2;
    public com.toedter.calendar.JDateChooser jDateChooser3;
    public com.toedter.calendar.JDateChooser jDateChooser4;
    public com.toedter.calendar.JDateChooser jDateChooser5;
    public javax.swing.JDialog jDialog1;
    public javax.swing.JDialog jDialog10;
    public javax.swing.JDialog jDialog11;
    public javax.swing.JDialog jDialog2;
    public javax.swing.JDialog jDialog3;
    public javax.swing.JDialog jDialog4;
    public javax.swing.JDialog jDialog5;
    public javax.swing.JDialog jDialog6;
    public javax.swing.JDialog jDialog7;
    public javax.swing.JDialog jDialog8;
    public javax.swing.JDialog jDialog9;
    public javax.swing.JFrame jFrame1;
    public javax.swing.JFrame jFrame2;
    public javax.swing.JFrame jFrame3;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel100;
    public javax.swing.JLabel jLabel101;
    public javax.swing.JLabel jLabel102;
    public javax.swing.JLabel jLabel103;
    public javax.swing.JLabel jLabel104;
    public javax.swing.JLabel jLabel105;
    public javax.swing.JLabel jLabel106;
    public javax.swing.JLabel jLabel107;
    public javax.swing.JLabel jLabel108;
    public javax.swing.JLabel jLabel109;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel110;
    public javax.swing.JLabel jLabel111;
    public javax.swing.JLabel jLabel112;
    public javax.swing.JLabel jLabel113;
    public javax.swing.JLabel jLabel114;
    public javax.swing.JLabel jLabel115;
    public javax.swing.JLabel jLabel116;
    public javax.swing.JLabel jLabel117;
    public javax.swing.JLabel jLabel118;
    public javax.swing.JLabel jLabel119;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel120;
    public javax.swing.JLabel jLabel121;
    public javax.swing.JLabel jLabel122;
    public javax.swing.JLabel jLabel123;
    public javax.swing.JLabel jLabel124;
    public javax.swing.JLabel jLabel125;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel24;
    public javax.swing.JLabel jLabel25;
    public javax.swing.JLabel jLabel26;
    public javax.swing.JLabel jLabel27;
    public javax.swing.JLabel jLabel28;
    public javax.swing.JLabel jLabel29;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel30;
    public javax.swing.JLabel jLabel31;
    public javax.swing.JLabel jLabel32;
    public javax.swing.JLabel jLabel33;
    public javax.swing.JLabel jLabel34;
    public javax.swing.JLabel jLabel35;
    public javax.swing.JLabel jLabel36;
    public javax.swing.JLabel jLabel37;
    public javax.swing.JLabel jLabel38;
    public javax.swing.JLabel jLabel39;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel40;
    public javax.swing.JLabel jLabel41;
    public javax.swing.JLabel jLabel42;
    public javax.swing.JLabel jLabel43;
    public javax.swing.JLabel jLabel44;
    public javax.swing.JLabel jLabel45;
    public javax.swing.JLabel jLabel46;
    public javax.swing.JLabel jLabel47;
    public javax.swing.JLabel jLabel48;
    public javax.swing.JLabel jLabel49;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel50;
    public javax.swing.JLabel jLabel51;
    public javax.swing.JLabel jLabel52;
    public javax.swing.JLabel jLabel53;
    public javax.swing.JLabel jLabel54;
    public javax.swing.JLabel jLabel55;
    public javax.swing.JLabel jLabel56;
    public javax.swing.JLabel jLabel57;
    public javax.swing.JLabel jLabel58;
    public javax.swing.JLabel jLabel59;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel60;
    public javax.swing.JLabel jLabel61;
    public javax.swing.JLabel jLabel62;
    public javax.swing.JLabel jLabel63;
    public javax.swing.JLabel jLabel64;
    public javax.swing.JLabel jLabel65;
    public javax.swing.JLabel jLabel66;
    public javax.swing.JLabel jLabel67;
    public javax.swing.JLabel jLabel68;
    public javax.swing.JLabel jLabel69;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel70;
    public javax.swing.JLabel jLabel71;
    public javax.swing.JLabel jLabel72;
    public javax.swing.JLabel jLabel73;
    public javax.swing.JLabel jLabel74;
    public javax.swing.JLabel jLabel75;
    public javax.swing.JLabel jLabel76;
    public javax.swing.JLabel jLabel77;
    public javax.swing.JLabel jLabel78;
    public javax.swing.JLabel jLabel79;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel80;
    public javax.swing.JLabel jLabel81;
    public javax.swing.JLabel jLabel82;
    public javax.swing.JLabel jLabel83;
    public javax.swing.JLabel jLabel84;
    public javax.swing.JLabel jLabel85;
    public javax.swing.JLabel jLabel86;
    public javax.swing.JLabel jLabel87;
    public javax.swing.JLabel jLabel88;
    public javax.swing.JLabel jLabel89;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabel90;
    public javax.swing.JLabel jLabel91;
    public javax.swing.JLabel jLabel92;
    public javax.swing.JLabel jLabel93;
    public javax.swing.JLabel jLabel94;
    public javax.swing.JLabel jLabel95;
    public javax.swing.JLabel jLabel96;
    public javax.swing.JLabel jLabel97;
    public javax.swing.JLabel jLabel98;
    public javax.swing.JLabel jLabel99;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel10;
    public javax.swing.JPanel jPanel11;
    public javax.swing.JPanel jPanel12;
    public javax.swing.JPanel jPanel13;
    public javax.swing.JPanel jPanel14;
    public javax.swing.JPanel jPanel15;
    public javax.swing.JPanel jPanel16;
    public javax.swing.JPanel jPanel17;
    public javax.swing.JPanel jPanel18;
    public javax.swing.JPanel jPanel19;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel20;
    public javax.swing.JPanel jPanel21;
    public javax.swing.JPanel jPanel22;
    public javax.swing.JPanel jPanel23;
    public javax.swing.JPanel jPanel24;
    public javax.swing.JPanel jPanel25;
    public javax.swing.JPanel jPanel26;
    public javax.swing.JPanel jPanel27;
    public javax.swing.JPanel jPanel29;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JPanel jPanel9;
    public javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JPasswordField jPasswordField2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane10;
    public javax.swing.JScrollPane jScrollPane11;
    public javax.swing.JScrollPane jScrollPane12;
    public javax.swing.JScrollPane jScrollPane13;
    public javax.swing.JScrollPane jScrollPane14;
    public javax.swing.JScrollPane jScrollPane15;
    public javax.swing.JScrollPane jScrollPane16;
    public javax.swing.JScrollPane jScrollPane17;
    public javax.swing.JScrollPane jScrollPane18;
    public javax.swing.JScrollPane jScrollPane19;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane20;
    public javax.swing.JScrollPane jScrollPane21;
    public javax.swing.JScrollPane jScrollPane22;
    public javax.swing.JScrollPane jScrollPane23;
    public javax.swing.JScrollPane jScrollPane24;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSeparator jSeparator2;
    public javax.swing.JSeparator jSeparator3;
    public javax.swing.JSpinner jSpinner1;
    public javax.swing.JSpinner jSpinner2;
    public javax.swing.JSpinner jSpinner3;
    public javax.swing.JSpinner jSpinner4;
    public javax.swing.JSpinner jSpinner5;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable10;
    public javax.swing.JTable jTable11;
    public javax.swing.JTable jTable12;
    public javax.swing.JTable jTable13;
    public javax.swing.JTable jTable14;
    public javax.swing.JTable jTable15;
    public javax.swing.JTable jTable16;
    public javax.swing.JTable jTable17;
    public javax.swing.JTable jTable18;
    public javax.swing.JTable jTable19;
    public javax.swing.JTable jTable2;
    public javax.swing.JTable jTable20;
    public javax.swing.JTable jTable21;
    public javax.swing.JTable jTable22;
    public javax.swing.JTable jTable23;
    public javax.swing.JTable jTable24;
    public javax.swing.JTable jTable3;
    public javax.swing.JTable jTable4;
    public javax.swing.JTable jTable5;
    public javax.swing.JTable jTable6;
    public javax.swing.JTable jTable7;
    public javax.swing.JTable jTable8;
    public javax.swing.JTable jTable9;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField10;
    public javax.swing.JTextField jTextField11;
    public javax.swing.JTextField jTextField12;
    public javax.swing.JTextField jTextField13;
    public javax.swing.JTextField jTextField14;
    public javax.swing.JTextField jTextField15;
    public javax.swing.JTextField jTextField16;
    public javax.swing.JTextField jTextField17;
    public javax.swing.JTextField jTextField18;
    public javax.swing.JTextField jTextField19;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField20;
    public javax.swing.JTextField jTextField21;
    public javax.swing.JTextField jTextField22;
    public javax.swing.JTextField jTextField23;
    public javax.swing.JTextField jTextField24;
    public javax.swing.JTextField jTextField25;
    public javax.swing.JTextField jTextField26;
    public javax.swing.JTextField jTextField27;
    public javax.swing.JTextField jTextField28;
    public javax.swing.JTextField jTextField29;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField30;
    public javax.swing.JTextField jTextField31;
    public javax.swing.JTextField jTextField32;
    public javax.swing.JTextField jTextField33;
    public javax.swing.JTextField jTextField34;
    public javax.swing.JTextField jTextField35;
    public javax.swing.JTextField jTextField36;
    public javax.swing.JTextField jTextField37;
    public javax.swing.JTextField jTextField38;
    public javax.swing.JTextField jTextField39;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField40;
    public javax.swing.JTextField jTextField41;
    public javax.swing.JTextField jTextField42;
    public javax.swing.JTextField jTextField43;
    public javax.swing.JTextField jTextField44;
    public javax.swing.JTextField jTextField45;
    public javax.swing.JTextField jTextField46;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    public javax.swing.JTextField jTextField7;
    public javax.swing.JTextField jTextField8;
    public javax.swing.JTextField jTextField9;
    public com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables
}
