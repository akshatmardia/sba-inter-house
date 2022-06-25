package src;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class WelcomePage extends JFrame {
    Connection con;
    PreparedStatement pst;
    PreparedStatement checkuser;
    ResultSet rs;
    String curuser = null;
    private JButton end;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JTextArea jTextArea1;
    private JButton studbtn;

    public WelcomePage() {
        this.initComponents();
        this.setLocationRelativeTo((Component)null);
    }

    public WelcomePage(String name) {
        this.initComponents();
        this.setLocationRelativeTo((Component)null);
        this.jLabel4.setText(name);
        this.usertrack();
        this.restrict();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jSeparator3 = new JSeparator();
        this.jSeparator2 = new JSeparator();
        this.jPanel2 = new JPanel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.studbtn = new JButton();
        this.jButton3 = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.jLabel2 = new JLabel();
        this.jLabel4 = new JLabel();
        this.end = new JButton();
        this.setDefaultCloseOperation(2);
        this.setBackground(new Color(255, 255, 255));
        this.getContentPane().setLayout(new AbsoluteLayout());
        this.jPanel1.setBackground(new Color(240, 229, 215));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jLabel1.setFont(new Font("Lucida Grande", 0, 36));
        this.jLabel1.setText("Welcome");
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(10, 70, -1, 59));
        this.jLabel3.setFont(new Font("Lucida Grande", 0, 44));
        this.jLabel3.setText("Athletics");
        this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(370, 10, 190, 60));
        this.jPanel1.add(this.jSeparator3, new AbsoluteConstraints(210, 160, 650, -1));
        this.jSeparator2.setOrientation(1);
        this.jPanel1.add(this.jSeparator2, new AbsoluteConstraints(210, 160, 10, 310));
        this.jPanel2.setBackground(new Color(240, 229, 215));
        this.jPanel2.setBorder(new SoftBevelBorder(0));
        this.jButton1.setText("House Points");
        this.jButton1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                WelcomePage.this.jButton1MouseEntered(evt);
            }
        });
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                WelcomePage.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setText("Events");
        this.jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                WelcomePage.this.jButton2ActionPerformed(evt);
            }
        });
        this.studbtn.setText("Students");
        this.studbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                WelcomePage.this.studbtnActionPerformed(evt);
            }
        });
        this.jButton3.setText("Final Result");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                WelcomePage.this.jButton3ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jButton2, -2, 140, -2)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false).addComponent(this.jButton3, -1, -1, 32767).addComponent(this.jButton1, -1, 140, 32767).addComponent(this.studbtn, -1, 140, 32767)).addGap(0, 0, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(32, 32, 32).addComponent(this.jButton1, -2, 43, -2).addGap(32, 32, 32).addComponent(this.jButton2, -2, 43, -2).addGap(34, 34, 34).addComponent(this.studbtn, -2, 43, -2).addPreferredGap(ComponentPlacement.RELATED, 33, 32767).addComponent(this.jButton3, -2, 41, -2).addGap(23, 23, 23)));
        this.jPanel1.add(this.jPanel2, new AbsoluteConstraints(30, 160, -1, 330));
        this.jScrollPane1.setBorder((Border)null);
        this.jTextArea1.setEditable(false);
        this.jTextArea1.setBackground(new Color(240, 229, 215));
        this.jTextArea1.setColumns(20);
        this.jTextArea1.setFont(new Font("Lucida Grande", 0, 20));
        this.jTextArea1.setRows(5);
        this.jTextArea1.setText("This is a software where you can effectively and efficiently keep track of\nthe inter-house athletics events and generate house wise statistics.");
        this.jTextArea1.setBorder((Border)null);
        this.jScrollPane1.setViewportView(this.jTextArea1);
        this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(230, 180, 700, 140));
        this.jLabel2.setFont(new Font("Lucida Grande", 0, 17));
        this.jLabel2.setText("Description");
        this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(220, 140, -1, -1));
        this.jLabel4.setFont(new Font("Calibri", 1, 24));
        this.jLabel4.setText("jLabel4");
        this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(170, 90, 80, -1));
        this.end.setText("End Competition");
        this.end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                WelcomePage.this.endActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.end, new AbsoluteConstraints(740, 450, 140, 40));
        this.getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 940, 520));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new House_Points()).setVisible(true);
    }

    private void jButton1MouseEntered(MouseEvent evt) {
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new Events()).setVisible(true);
    }

    private void studbtnActionPerformed(ActionEvent evt) {
        this.dispose();
        (new Students()).setVisible(true);
    }

    public void deleteall() {
        int ok = JOptionPane.showConfirmDialog(this.rootPane, "Are you sure?", "", 0);
        if (ok == 0) {
            try {
                String del1 = "DELETE FROM Events";
                String del2 = "DELETE FROM Students";
                String del3 = "DELETE FROM HousePoints";
                String del4 = "DELETE FROM Aditya";
                String del5 = "DELETE FROM Martand";
                String del6 = "DELETE FROM Bhaskar";
                String del7 = "DELETE FROM Vivasvan";
                String del8 = "DELETE FROM LoginHistory";
                String del9 = "DELETE FROM BestAth";
                String del10 = "DELETE FROM Under12";
                String del11 = "DELETE FROM Under14";
                String del12 = "DELETE FROM Under16";
                String del13 = "DELETE FROM Above16";
                String del14 = "DELETE FROM TotalPoints";
                this.con = src.MsAccessPro.Connection.getConnection();
                PreparedStatement pst1 = this.con.prepareStatement(del1);
                PreparedStatement pst2 = this.con.prepareStatement(del2);
                PreparedStatement pst3 = this.con.prepareStatement(del3);
                PreparedStatement pst4 = this.con.prepareStatement(del4);
                PreparedStatement pst5 = this.con.prepareStatement(del5);
                PreparedStatement pst6 = this.con.prepareStatement(del6);
                PreparedStatement pst7 = this.con.prepareStatement(del7);
                PreparedStatement pst8 = this.con.prepareStatement(del8);
                PreparedStatement pst9 = this.con.prepareStatement(del9);
                PreparedStatement pst10 = this.con.prepareStatement(del10);
                PreparedStatement pst11 = this.con.prepareStatement(del11);
                PreparedStatement pst12 = this.con.prepareStatement(del12);
                PreparedStatement pst13 = this.con.prepareStatement(del13);
                PreparedStatement pst14 = this.con.prepareStatement(del14);
                pst1.executeUpdate();
                pst2.executeUpdate();
                pst3.executeUpdate();
                pst4.executeUpdate();
                pst5.executeUpdate();
                pst6.executeUpdate();
                pst7.executeUpdate();
                pst8.executeUpdate();
                pst9.executeUpdate();
                pst10.executeUpdate();
                pst11.executeUpdate();
                pst12.executeUpdate();
                pst13.executeUpdate();
                pst14.executeUpdate();
                JOptionPane.showMessageDialog((Component)null, "Congratulations! The competition has ended");
            } catch (Exception var30) {
                System.out.println("" + var30);
            }
        }

    }

    private void endActionPerformed(ActionEvent evt) {
        this.deleteall();
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new Final_Result()).setVisible(true);
    }

    public void restrict() {
        if (this.curuser.equals("admin")) {
            System.out.println(this.curuser + " is good to go");
        } else {
            this.studbtn.setEnabled(false);
            this.end.setEnabled(false);
            System.out.println(this.curuser + " not allowed");
        }

    }

    public void usertrack() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.checkuser = this.con.prepareStatement("SELECT LAST (History) from LoginHistory");
            this.rs = this.checkuser.executeQuery();
            this.rs.next();
            this.curuser = this.rs.getString(1);
            System.out.println(this.curuser);
        } catch (Exception var2) {
            System.out.println("" + var2);
        }

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
            Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new WelcomePage()).setVisible(true);
            }
        });
    }
}

