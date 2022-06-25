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

public class BhaskarHouse extends JFrame {
    Connection con;
    PreparedStatement pst;
    PreparedStatement bhas1;
    PreparedStatement bhas2;
    PreparedStatement bhas3;
    PreparedStatement bhas4;
    PreparedStatement mulbhas1;
    PreparedStatement mulbhas2;
    PreparedStatement mulbhas3;
    PreparedStatement mulbhas4;
    PreparedStatement cal;
    ResultSet rs;
    int score;
    private JButton jButton1;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JTextField txtscore;

    public BhaskarHouse() {
        this.initComponents();
        this.setLocationRelativeTo((Component)null);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jButton1 = new JButton();
        this.jButton3 = new JButton();
        this.txtscore = new JTextField();
        this.jLabel2 = new JLabel();
        this.jButton4 = new JButton();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBackground(new Color(240, 229, 215));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jLabel1.setFont(new Font("Lucida Grande", 0, 48));
        this.jLabel1.setText("Bhaskar House");
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(10, 10, 350, 60));
        this.jButton1.setText("Back");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BhaskarHouse.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(180, 250, 120, 40));
        this.jButton3.setText("Calculate Score");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BhaskarHouse.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton3, new AbsoluteConstraints(290, 100, 130, 30));
        this.txtscore.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                BhaskarHouse.this.txtscoreFocusGained(evt);
            }
        });
        this.jPanel1.add(this.txtscore, new AbsoluteConstraints(120, 120, 50, 30));
        this.jLabel2.setFont(new Font("Tahoma", 0, 14));
        this.jLabel2.setText("Total Score");
        this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(30, 120, 80, 30));
        this.jButton4.setText("Display Score");
        this.jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BhaskarHouse.this.jButton4ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton4, new AbsoluteConstraints(290, 140, 130, 30));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, 483, -2).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, 323, -2));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new House_Points()).setVisible(true);
    }

    public void Insert() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.bhas1 = this.con.prepareStatement("INSERT INTO Bhaskar (4P) SELECT [Winrno] FROM Events INNER JOIN Students ON Events.Winrno=Students.Rno WHERE Students.House='Bhaskar'");
            this.bhas2 = this.con.prepareStatement("INSERT INTO Bhaskar (3P) SELECT [Runup1] FROM Events INNER JOIN Students ON Events.Runup1=Students.Rno WHERE Students.House='Bhaskar'");
            this.bhas3 = this.con.prepareStatement("INSERT INTO Bhaskar (2P) SELECT [Runup2] FROM Events INNER JOIN Students ON Events.Runup2=Students.Rno WHERE Students.House='Bhaskar'");
            this.bhas4 = this.con.prepareStatement("INSERT INTO Bhaskar (1P) SELECT [Runup3] FROM Events INNER JOIN Students ON Events.Runup3=Students.Rno WHERE Students.House='Bhaskar'");
            this.bhas1.executeUpdate();
            this.bhas2.executeUpdate();
            this.bhas3.executeUpdate();
            this.bhas4.executeUpdate();
        } catch (SQLException var2) {
            System.out.println("" + var2);
        }

    }

    public void Multiply() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.mulbhas1 = this.con.prepareStatement("INSERT INTO TotalPoints ( Bhaskar ) SELECT Count([4P])*4 FROM Bhaskar WHERE [4P]<>0");
            this.mulbhas2 = this.con.prepareStatement("INSERT INTO TotalPoints ( Bhaskar ) SELECT Count([3P])*3 FROM Bhaskar WHERE [3P]<>0");
            this.mulbhas3 = this.con.prepareStatement("INSERT INTO TotalPoints ( Bhaskar ) SELECT Count([2P])*2 FROM Bhaskar WHERE [2P]<>0");
            this.mulbhas4 = this.con.prepareStatement("INSERT INTO TotalPoints ( Bhaskar ) SELECT Count([1P])*1 FROM Bhaskar WHERE [1P]<>0");
            this.mulbhas1.executeUpdate();
            this.mulbhas2.executeUpdate();
            this.mulbhas3.executeUpdate();
            this.mulbhas4.executeUpdate();
        } catch (SQLException var2) {
            System.out.println("" + var2);
        }

    }

    public void Sumdisplay() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.cal = this.con.prepareStatement("SELECT SUM (Bhaskar) FROM TotalPoints");
            this.rs = this.cal.executeQuery();
            this.rs.next();
            this.score = this.rs.getInt(1);
            String LA = Integer.toString(this.score);
            this.txtscore.setText(LA);
        } catch (SQLException var2) {
            System.out.println("" + var2);
        }

    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        this.Insert();
        this.Multiply();
        this.jButton3.setEnabled(false);
    }

    private void txtscoreFocusGained(FocusEvent evt) {
        boolean a = this.txtscore.isEditable();
        if (a) {
            JOptionPane.showMessageDialog((Component)null, "You cannot edit this value");
            this.txtscore.setText("");
            this.txtscore.setFocusable(false);
        }

    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        this.Sumdisplay();
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
            Logger.getLogger(BhaskarHouse.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(BhaskarHouse.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(BhaskarHouse.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(BhaskarHouse.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new BhaskarHouse()).setVisible(true);
            }
        });
    }
}

