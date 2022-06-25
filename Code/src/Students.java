package src;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Students extends JFrame {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    WelcomePage abcd;
    private JComboBox<String> cboxgrade;
    private JComboBox<String> cboxhouse;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JButton reset;
    private JButton submit;
    private JTextField txtage;
    private JTextField txtfname;
    private JTextField txtlname;
    private JTextField txtrno;

    public Students() {
        this.initComponents();
        this.setLocationRelativeTo((Component)null);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jButton1 = new JButton();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.submit = new JButton();
        this.reset = new JButton();
        this.txtfname = new JTextField();
        this.txtlname = new JTextField();
        this.txtage = new JTextField();
        this.txtrno = new JTextField();
        this.cboxhouse = new JComboBox();
        this.cboxgrade = new JComboBox();
        this.setDefaultCloseOperation(2);
        this.jPanel1.setBackground(new Color(240, 229, 215));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jButton1.setText("Back");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Students.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(350, 340, 90, 30));
        this.jLabel1.setFont(new Font("Lucida Grande", 0, 48));
        this.jLabel1.setText("Students");
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(10, 10, -1, -1));
        this.jLabel3.setFont(new Font("Tahoma", 1, 14));
        this.jLabel3.setText("Grade");
        this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(140, 240, 90, 20));
        this.jLabel4.setFont(new Font("Tahoma", 1, 14));
        this.jLabel4.setText("First Name");
        this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(140, 120, 90, 20));
        this.jLabel5.setFont(new Font("Tahoma", 1, 14));
        this.jLabel5.setText("Last Name");
        this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(140, 150, 90, 20));
        this.jLabel6.setFont(new Font("Tahoma", 1, 14));
        this.jLabel6.setText("House");
        this.jPanel1.add(this.jLabel6, new AbsoluteConstraints(140, 270, 90, 20));
        this.jLabel7.setFont(new Font("Tahoma", 1, 14));
        this.jLabel7.setText("Roll Number");
        this.jPanel1.add(this.jLabel7, new AbsoluteConstraints(140, 210, 90, 20));
        this.jLabel8.setFont(new Font("Tahoma", 1, 14));
        this.jLabel8.setText("Age");
        this.jPanel1.add(this.jLabel8, new AbsoluteConstraints(140, 180, 90, 20));
        this.submit.setText("Submit");
        this.submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Students.this.submitActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.submit, new AbsoluteConstraints(130, 340, 90, 30));
        this.reset.setText("Clear");
        this.reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Students.this.resetActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.reset, new AbsoluteConstraints(240, 340, 90, 30));
        this.jPanel1.add(this.txtfname, new AbsoluteConstraints(270, 120, 170, -1));
        this.jPanel1.add(this.txtlname, new AbsoluteConstraints(270, 150, 170, -1));
        this.txtage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Students.this.txtageActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.txtage, new AbsoluteConstraints(270, 180, 170, -1));
        this.jPanel1.add(this.txtrno, new AbsoluteConstraints(270, 210, 170, -1));
        this.cboxhouse.setModel(new DefaultComboBoxModel(new String[]{"Select", "Aditya", "Bhaskar", "Martand", "Vivasvan"}));
        this.jPanel1.add(this.cboxhouse, new AbsoluteConstraints(270, 270, 170, -1));
        this.cboxgrade.setModel(new DefaultComboBoxModel(new String[]{"Select", "5", "6", "7", "8", "9", "10", "11", "12"}));
        this.jPanel1.add(this.cboxgrade, new AbsoluteConstraints(270, 240, 170, -1));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, 592, -2));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, Alignment.TRAILING, -1, 458, 32767));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.abcd = new WelcomePage();
        this.abcd.usertrack();
        this.abcd.restrict();
        this.dispose();
        this.abcd.setVisible(true);
    }

    private void submitActionPerformed(ActionEvent evt) {
        String fname = this.txtfname.getText();
        String lname = this.txtlname.getText();
        String age = this.txtage.getText();
        String rno = this.txtrno.getText();
        String grade = this.cboxgrade.getSelectedItem().toString();
        String house = this.cboxhouse.getSelectedItem().toString();

        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.pst = this.con.prepareStatement("INSERT INTO Students (First_Name,Last_Name,Age,Rno,Grade,House) values (?,?,?,?,?,?)");
            this.pst.setString(1, fname);
            this.pst.setString(2, lname);
            this.pst.setString(3, age);
            this.pst.setString(4, rno);
            this.pst.setString(5, grade);
            this.pst.setString(6, house);
            int ok = JOptionPane.showConfirmDialog(this.rootPane, "Please check the details", "Confirm to add", 0);
            if (ok == 0) {
                this.pst.execute();
                JOptionPane.showMessageDialog(this.rootPane, "Data is stored", "Student added", 1);
            }

            this.clearFields();
        } catch (Exception var9) {
            System.out.println("" + var9);
        }

    }

    private void txtageActionPerformed(ActionEvent evt) {
    }

    private void resetActionPerformed(ActionEvent evt) {
        this.clearFields();
    }

    public void clearFields() {
        this.txtfname.setText("");
        this.txtlname.setText("");
        this.txtage.setText("");
        this.txtrno.setText("");
        this.cboxgrade.setSelectedIndex(0);
        this.cboxhouse.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Students()).setVisible(true);
            }
        });
    }
}

