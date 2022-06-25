package src;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class House_Points extends JFrame {
    WelcomePage abcd;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;

    public House_Points() {
        this.initComponents();
        this.setLocationRelativeTo((Component)null);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jButton1 = new JButton();
        this.jPanel2 = new JPanel();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.jButton4 = new JButton();
        this.jButton5 = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.setDefaultCloseOperation(2);
        this.jPanel1.setBackground(new Color(240, 229, 215));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jLabel1.setFont(new Font("Lucida Grande", 0, 48));
        this.jLabel1.setText("House Points");
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(10, 10, 310, 60));
        this.jButton1.setText("Back");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                House_Points.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(240, 370, 130, 40));
        this.jPanel2.setBackground(new Color(240, 229, 215));
        this.jPanel2.setLayout(new AbsoluteLayout());
        this.jButton2.setText("Aditya House");
        this.jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                House_Points.this.jButton2ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jButton2, new AbsoluteConstraints(50, 40, 110, 40));
        this.jButton3.setText("Bhaskar House");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                House_Points.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jButton3, new AbsoluteConstraints(280, 40, 110, 40));
        this.jButton4.setText("Martand House");
        this.jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                House_Points.this.jButton4ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jButton4, new AbsoluteConstraints(50, 170, 110, 40));
        this.jButton5.setText("Vivasvan House");
        this.jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                House_Points.this.jButton5ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jButton5, new AbsoluteConstraints(280, 170, 110, 40));
        this.jPanel1.add(this.jPanel2, new AbsoluteConstraints(80, 120, 440, 240));
        this.jScrollPane1.setBorder((Border)null);
        this.jTextArea1.setEditable(false);
        this.jTextArea1.setBackground(new Color(240, 229, 215));
        this.jTextArea1.setColumns(20);
        this.jTextArea1.setFont(new Font("Lucida Grande", 0, 20));
        this.jTextArea1.setRows(5);
        this.jTextArea1.setText("Please use this functionality only when all the events are added.");
        this.jTextArea1.setBorder((Border)null);
        this.jScrollPane1.setViewportView(this.jTextArea1);
        this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(10, 80, 570, 140));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, 437, -2));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.abcd = new WelcomePage();
        this.abcd.usertrack();
        this.abcd.restrict();
        this.dispose();
        this.abcd.setVisible(true);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new AdityaHouse()).setVisible(true);
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new BhaskarHouse()).setVisible(true);
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new MartandHouse()).setVisible(true);
    }

    private void jButton5ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new VivasvanHouse()).setVisible(true);
    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for (LookAndFeelInfo info : var1) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(House_Points.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(House_Points.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(House_Points.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(House_Points.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new House_Points()).setVisible(true);
            }
        });
    }
}
