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

public class MartandHouse extends JFrame {
    Connection con;
    PreparedStatement pst;
    PreparedStatement mar1;
    PreparedStatement mar2;
    PreparedStatement mar3;
    PreparedStatement mar4;
    PreparedStatement mulmar1;
    PreparedStatement mulmar2;
    PreparedStatement mulmar3;
    PreparedStatement mulmar4;
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

    public MartandHouse() {
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
        this.jLabel1.setText("Martand House");
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(10, 10, 340, 60));
        this.jButton1.setText("Back");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MartandHouse.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(170, 220, 110, 40));
        this.jButton3.setText("Calculate Score");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MartandHouse.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton3, new AbsoluteConstraints(270, 100, 130, 30));
        this.txtscore.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                MartandHouse.this.txtscoreFocusGained(evt);
            }
        });
        this.txtscore.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                MartandHouse.this.txtscoreMouseClicked(evt);
            }
        });
        this.txtscore.addInputMethodListener(new InputMethodListener() {
            public void caretPositionChanged(InputMethodEvent evt) {
            }

            public void inputMethodTextChanged(InputMethodEvent evt) {
                MartandHouse.this.txtscoreInputMethodTextChanged(evt);
            }
        });
        this.txtscore.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                MartandHouse.this.txtscoreKeyTyped(evt);
            }
        });
        this.jPanel1.add(this.txtscore, new AbsoluteConstraints(110, 120, 50, 30));
        this.jLabel2.setFont(new Font("Tahoma", 0, 14));
        this.jLabel2.setText("Total Score");
        this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(30, 120, 80, 30));
        this.jButton4.setText("Display Score");
        this.jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MartandHouse.this.jButton4ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton4, new AbsoluteConstraints(270, 140, 130, 30));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, 458, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, 320, 32767));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new House_Points()).setVisible(true);
    }

    public void Insert() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.mar1 = this.con.prepareStatement("INSERT INTO Martand (4P) SELECT [Winrno] FROM Events INNER JOIN Students ON Events.Winrno=Students.Rno WHERE Students.House='Martand'");
            this.mar2 = this.con.prepareStatement("INSERT INTO Martand (3P) SELECT [Runup1] FROM Events INNER JOIN Students ON Events.Runup1=Students.Rno WHERE Students.House='Martand'");
            this.mar3 = this.con.prepareStatement("INSERT INTO Martand (2P) SELECT [Runup2] FROM Events INNER JOIN Students ON Events.Runup2=Students.Rno WHERE Students.House='Martand'");
            this.mar4 = this.con.prepareStatement("INSERT INTO Martand (1P) SELECT [Runup3] FROM Events INNER JOIN Students ON Events.Runup3=Students.Rno WHERE Students.House='Martand'");
            this.mar1.executeUpdate();
            this.mar2.executeUpdate();
            this.mar3.executeUpdate();
            this.mar4.executeUpdate();
        } catch (SQLException var2) {
            System.out.println("" + var2);
        }

    }

    public void Multiply() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.mulmar1 = this.con.prepareStatement("INSERT INTO TotalPoints ( Martand ) SELECT Count([4P])*4 FROM Martand WHERE [4P]<>0");
            this.mulmar2 = this.con.prepareStatement("INSERT INTO TotalPoints ( Martand ) SELECT Count([3P])*3 FROM Martand WHERE [3P]<>0");
            this.mulmar3 = this.con.prepareStatement("INSERT INTO TotalPoints ( Martand ) SELECT Count([2P])*2 FROM Martand WHERE [2P]<>0");
            this.mulmar4 = this.con.prepareStatement("INSERT INTO TotalPoints ( Martand ) SELECT Count([1P])*1 FROM Martand WHERE [1P]<>0");
            this.mulmar1.executeUpdate();
            this.mulmar2.executeUpdate();
            this.mulmar3.executeUpdate();
            this.mulmar4.executeUpdate();
        } catch (SQLException var2) {
            System.out.println("" + var2);
        }

    }

    public void Sumdisplay() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.cal = this.con.prepareStatement("SELECT SUM (Martand) FROM TotalPoints");
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

    private void txtscoreInputMethodTextChanged(InputMethodEvent evt) {
    }

    private void txtscoreKeyTyped(KeyEvent evt) {
    }

    private void txtscoreMouseClicked(MouseEvent evt) {
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
            Logger.getLogger(MartandHouse.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(MartandHouse.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(MartandHouse.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(MartandHouse.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new MartandHouse()).setVisible(true);
            }
        });
    }
}

