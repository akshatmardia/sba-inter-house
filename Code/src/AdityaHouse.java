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

public class AdityaHouse extends JFrame {
    Connection con;
    PreparedStatement pst;
    PreparedStatement ad1;
    PreparedStatement ad2;
    PreparedStatement ad3;
    PreparedStatement ad4;
    PreparedStatement adviv1;
    PreparedStatement adviv2;
    PreparedStatement adviv3;
    PreparedStatement adviv4;
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

    public AdityaHouse() {
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
        this.jLabel1.setText("Aditya House");
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(10, 10, 310, 60));
        this.jButton1.setText("Back");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdityaHouse.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(170, 230, 120, 40));
        this.jButton3.setText("Calculate Score");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdityaHouse.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton3, new AbsoluteConstraints(290, 100, 130, 30));
        this.txtscore.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                AdityaHouse.this.txtscoreMouseDragged(evt);
            }

            public void mouseMoved(MouseEvent evt) {
                AdityaHouse.this.txtscoreMouseMoved(evt);
            }
        });
        this.txtscore.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                AdityaHouse.this.txtscoreFocusGained(evt);
            }
        });
        this.txtscore.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                AdityaHouse.this.txtscoreMouseClicked(evt);
            }
        });
        this.txtscore.addInputMethodListener(new InputMethodListener() {
            public void caretPositionChanged(InputMethodEvent evt) {
            }

            public void inputMethodTextChanged(InputMethodEvent evt) {
                AdityaHouse.this.txtscoreInputMethodTextChanged(evt);
            }
        });
        this.txtscore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdityaHouse.this.txtscoreActionPerformed(evt);
            }
        });
        this.txtscore.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                AdityaHouse.this.txtscoreKeyTyped(evt);
            }
        });
        this.jPanel1.add(this.txtscore, new AbsoluteConstraints(130, 120, 50, 30));
        this.jLabel2.setFont(new Font("Tahoma", 0, 14));
        this.jLabel2.setText("Total Score");
        this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(40, 120, 80, 30));
        this.jButton4.setText("Display Score");
        this.jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdityaHouse.this.jButton4ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton4, new AbsoluteConstraints(290, 140, 130, 30));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, 463, -2));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, 320, -2));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new House_Points()).setVisible(true);
    }

    public void Insert() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.ad1 = this.con.prepareStatement("INSERT INTO Aditya (4P) SELECT [Winrno] FROM Events INNER JOIN Students ON Events.Winrno=Students.Rno WHERE Students.House='Aditya'");
            this.ad2 = this.con.prepareStatement("INSERT INTO Aditya (3P) SELECT [Runup1] FROM Events INNER JOIN Students ON Events.Runup1=Students.Rno WHERE Students.House='Aditya'");
            this.ad3 = this.con.prepareStatement("INSERT INTO Aditya (2P) SELECT [Runup2] FROM Events INNER JOIN Students ON Events.Runup2=Students.Rno WHERE Students.House='Aditya'");
            this.ad4 = this.con.prepareStatement("INSERT INTO Aditya (1P) SELECT [Runup3] FROM Events INNER JOIN Students ON Events.Runup3=Students.Rno WHERE Students.House='Aditya'");
            this.ad1.executeUpdate();
            this.ad2.executeUpdate();
            this.ad3.executeUpdate();
            this.ad4.executeUpdate();
        } catch (SQLException var2) {
            System.out.println("" + var2);
        }

    }

    public void Multiply() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.adviv1 = this.con.prepareStatement("INSERT INTO TotalPoints ( Aditya ) SELECT Count([4P])*4 FROM Aditya WHERE [4P]<>0");
            this.adviv2 = this.con.prepareStatement("INSERT INTO TotalPoints ( Aditya ) SELECT Count([3P])*3 FROM Aditya WHERE [3P]<>0");
            this.adviv3 = this.con.prepareStatement("INSERT INTO TotalPoints ( Aditya ) SELECT Count([2P])*2 FROM Aditya WHERE [2P]<>0");
            this.adviv4 = this.con.prepareStatement("INSERT INTO TotalPoints ( Aditya ) SELECT Count([1P])*1 FROM Aditya WHERE [1P]<>0");
            this.adviv1.executeUpdate();
            this.adviv2.executeUpdate();
            this.adviv3.executeUpdate();
            this.adviv4.executeUpdate();
        } catch (SQLException var2) {
            System.out.println("" + var2);
        }

    }

    public void Sumdisplay() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.cal = this.con.prepareStatement("SELECT SUM (Aditya) FROM TotalPoints");
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

    private void txtscoreMouseClicked(MouseEvent evt) {
        boolean a = this.txtscore.isEditable();
        if (a) {
            JOptionPane.showMessageDialog((Component)null, "You cannot edit this value");
            this.txtscore.setText((String)null);
        }

    }

    private void txtscoreKeyTyped(KeyEvent evt) {
        boolean a = this.txtscore.isEditable();
        if (a) {
            JOptionPane.showMessageDialog((Component)null, "You cannot edit this value");
            this.txtscore.setText("");
        }

    }

    private void txtscoreMouseDragged(MouseEvent evt) {
    }

    private void txtscoreMouseMoved(MouseEvent evt) {
    }

    private void txtscoreInputMethodTextChanged(InputMethodEvent evt) {
        boolean a = this.txtscore.isEditable();
        if (a) {
            JOptionPane.showMessageDialog((Component)null, "You cannot edit this value");
            this.txtscore.setText("");
        }

    }

    private void txtscoreActionPerformed(ActionEvent evt) {
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
            Logger.getLogger(AdityaHouse.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(AdityaHouse.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(AdityaHouse.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(AdityaHouse.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new AdityaHouse()).setVisible(true);
            }
        });
    }
}
