package src;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Events extends JFrame {
    Connection con;
    PreparedStatement pst;
    PreparedStatement limit1;
    PreparedStatement limit2;
    PreparedStatement limit3;
    PreparedStatement limit4;
    PreparedStatement limit5;
    ResultSet rs;
    DefaultTableModel dtm;
    int value;
    WelcomePage abcd;
    private JButton addevbtn;
    private JComboBox<String> cboxevcat;
    private JButton delevbtn;
    private JTable evtable;
    private JButton jButton1;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextField txtevcode;
    private JTextField txtevname;
    private JTextField txtr1rno;
    private JTextField txtr2rno;
    private JTextField txtr3rno;
    private JTextField txtwinner;
    private JTextField txtwinrno;

    public Events() {
        this.initComponents();
        this.setLocationRelativeTo((Component)null);
        this.ShowData();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.addevbtn = new JButton();
        this.delevbtn = new JButton();
        this.jButton3 = new JButton();
        this.jButton4 = new JButton();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.txtevname = new JTextField();
        this.txtevcode = new JTextField();
        this.txtwinner = new JTextField();
        this.cboxevcat = new JComboBox();
        this.jLabel6 = new JLabel();
        this.txtwinrno = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.evtable = new JTable();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.txtr3rno = new JTextField();
        this.txtr1rno = new JTextField();
        this.txtr2rno = new JTextField();
        this.jButton1 = new JButton();
        this.setDefaultCloseOperation(2);
        this.jPanel1.setBackground(new Color(240, 229, 215));
        this.jPanel1.setCursor(new Cursor(0));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jLabel1.setFont(new Font("Lucida Grande", 0, 48));
        this.jLabel1.setText("Events");
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(10, 10, 160, 60));
        this.addevbtn.setText("Add Event");
        this.addevbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Events.this.addevbtnActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.addevbtn, new AbsoluteConstraints(140, 410, 100, 30));
        this.delevbtn.setText("Delete Event");
        this.delevbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Events.this.delevbtnActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.delevbtn, new AbsoluteConstraints(250, 410, 100, 30));
        this.jButton3.setText("Back");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Events.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton3, new AbsoluteConstraints(810, 400, 110, 40));
        this.jButton4.setText("Clear");
        this.jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Events.this.jButton4ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton4, new AbsoluteConstraints(30, 410, 100, 30));
        this.jLabel2.setFont(new Font("Tahoma", 1, 14));
        this.jLabel2.setText("Event Name");
        this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(20, 120, -1, -1));
        this.jLabel3.setFont(new Font("Tahoma", 1, 14));
        this.jLabel3.setText("Category");
        this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(20, 150, -1, -1));
        this.jLabel4.setFont(new Font("Tahoma", 1, 14));
        this.jLabel4.setText("Event Code");
        this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(20, 180, -1, -1));
        this.jLabel5.setFont(new Font("Tahoma", 1, 14));
        this.jLabel5.setText("Roll Number of 3rd Runner-up");
        this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(20, 330, -1, 20));
        this.txtevname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Events.this.txtevnameActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.txtevname, new AbsoluteConstraints(260, 110, 130, -1));
        this.jPanel1.add(this.txtevcode, new AbsoluteConstraints(260, 170, 130, -1));
        this.jPanel1.add(this.txtwinner, new AbsoluteConstraints(260, 200, 130, -1));
        this.cboxevcat.setModel(new DefaultComboBoxModel(new String[]{"Select", "Under 12", "Under 14", "Under 16", "Above 16"}));
        this.cboxevcat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Events.this.cboxevcatActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.cboxevcat, new AbsoluteConstraints(260, 140, 130, -1));
        this.jLabel6.setFont(new Font("Tahoma", 1, 14));
        this.jLabel6.setText("Name of the Winner");
        this.jPanel1.add(this.jLabel6, new AbsoluteConstraints(20, 210, -1, -1));
        this.txtwinrno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Events.this.txtwinrnoActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.txtwinrno, new AbsoluteConstraints(260, 230, 130, -1));
        this.evtable.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null}, {null, null, null, null, null}, {null, null, null, null, null}, {null, null, null, null, null}}, new String[]{"Event Name", "Category", "Event Code", "Name of the Winner", "Roll Number of the Winner"}) {
            Class[] types = new Class[]{String.class, String.class, Integer.class, String.class, Integer.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        });
        this.evtable.setCursor(new Cursor(0));
        this.evtable.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                Events.this.evtableFocusGained(evt);
            }
        });
        this.evtable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Events.this.evtableMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.evtable);
        this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(410, 90, 570, 240));
        this.jLabel7.setFont(new Font("Tahoma", 1, 14));
        this.jLabel7.setText("Roll Number of the Winner");
        this.jPanel1.add(this.jLabel7, new AbsoluteConstraints(20, 240, -1, -1));
        this.jLabel8.setFont(new Font("Tahoma", 1, 14));
        this.jLabel8.setText("Roll Number of 1st Runner-up");
        this.jPanel1.add(this.jLabel8, new AbsoluteConstraints(20, 270, -1, -1));
        this.jLabel9.setFont(new Font("Tahoma", 1, 14));
        this.jLabel9.setText("Roll Number of 2nd Runner-up");
        this.jPanel1.add(this.jLabel9, new AbsoluteConstraints(20, 300, -1, 20));
        this.jPanel1.add(this.txtr3rno, new AbsoluteConstraints(260, 330, 130, -1));
        this.txtr1rno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Events.this.txtr1rnoActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.txtr1rno, new AbsoluteConstraints(260, 270, 130, -1));
        this.jPanel1.add(this.txtr2rno, new AbsoluteConstraints(260, 300, 130, -1));
        this.jButton1.setText("Best Athlete");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Events.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(360, 410, 100, 30));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, 987, -2).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, 488, -2).addGap(0, 0, 32767)));
        this.pack();
    }

    private void addevbtnActionPerformed(ActionEvent evt) {
        String evname = this.txtevname.getText();
        String evcat = this.cboxevcat.getSelectedItem().toString();
        String evcode = this.txtevcode.getText();
        String winner = this.txtwinner.getText();
        String winrno = this.txtwinrno.getText();
        String runup1 = this.txtr1rno.getText();
        String runup2 = this.txtr2rno.getText();
        String runup3 = this.txtr3rno.getText();

        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.pst = this.con.prepareStatement("INSERT INTO Events (EvName,EvCat,EvCode,Winner,Winrno,Runup1,Runup2,Runup3) values (?,?,?,?,?,?,?,?)");
            this.limit1 = this.con.prepareStatement("SELECT Rno from Students where Age<12", 1005, 1008);
            this.limit2 = this.con.prepareStatement("SELECT Rno from Students where Age BETWEEN 12 AND 14 ", 1005, 1008);
            this.limit3 = this.con.prepareStatement("SELECT Rno from Students where Age BETWEEN 14 AND 16 ", 1005, 1008);
            this.limit4 = this.con.prepareStatement("SELECT Rno from Students where Age>16", 1005, 1008);
            boolean check = false;
            int ok = JOptionPane.showConfirmDialog(this.rootPane, "Please check the details", "Confirm to add", 0);
            if (ok == 0) {
                ResultSet search1 = this.limit1.executeQuery();
                ResultSet search2 = this.limit2.executeQuery();
                ResultSet search3 = this.limit3.executeQuery();
                ResultSet search4 = this.limit4.executeQuery();
                System.out.println("asdfghjkl");
                search1.beforeFirst();
                search2.beforeFirst();
                search3.beforeFirst();
                search4.beforeFirst();
                String hah;
                if (this.value == 1) {
                    while(search1.next() || !check) {
                        hah = search1.getString("Rno");
                        if (this.txtwinrno.getText().equals(hah)) {
                            check = true;
                        }
                    }
                } else if (this.value == 2) {
                    while(search2.next() || !check) {
                        hah = search2.getString("Rno");
                        if (this.txtwinrno.getText().equals(hah)) {
                            check = true;
                        }
                    }
                } else if (this.value == 3) {
                    while(search3.next() || !check) {
                        hah = search3.getString("Rno");
                        if (this.txtwinrno.getText().equals(hah)) {
                            check = true;
                        }
                    }
                } else if (this.value == 4) {
                    while(search4.next() || !check) {
                        hah = search4.getString("Rno");
                        if (this.txtwinrno.getText().equals(hah)) {
                            check = true;
                        }
                    }
                }

                if (check) {
                    this.pst.setString(1, evname);
                    this.pst.setString(2, evcat);
                    this.pst.setString(3, evcode);
                    this.pst.setString(4, winner);
                    this.pst.setString(5, winrno);
                    this.pst.setString(6, runup1);
                    this.pst.setString(7, runup2);
                    this.pst.setString(8, runup3);
                    this.pst.executeUpdate();
                    JOptionPane.showMessageDialog(this.rootPane, "Data is stored", "Event added", 1);
                } else {
                    JOptionPane.showMessageDialog(this.rootPane, "Error with age", "Please check category", 1);
                }
            }
        } catch (Exception var17) {
            JOptionPane.showMessageDialog((Component)null, var17);
        }

        this.ShowData();
        this.clearFields();
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        this.abcd = new WelcomePage();
        this.abcd.usertrack();
        this.abcd.restrict();
        this.dispose();
        this.abcd.setVisible(true);
    }

    private void txtevnameActionPerformed(ActionEvent evt) {
    }

    private void cboxevcatActionPerformed(ActionEvent evt) {
        this.value = this.cboxevcat.getSelectedIndex();
        System.out.println(this.value);
    }

    public void clearFields() {
        this.txtevname.setText("");
        this.txtevcode.setText("");
        this.txtwinner.setText("");
        this.txtwinrno.setText("");
        this.txtr1rno.setText("");
        this.txtr2rno.setText("");
        this.txtr3rno.setText("");
        this.cboxevcat.setSelectedIndex(0);
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        this.clearFields();
    }

    private void delevbtnActionPerformed(ActionEvent evt) {
        if (this.txtevcode.getText().equals("")) {
            JOptionPane.showMessageDialog((Component)null, "Please enter the code of the event to be deleted");
        } else {
            try {
                String sql = "DELETE FROM Events WHERE EvCode =?";
                this.con = src.MsAccessPro.Connection.getConnection();
                PreparedStatement pst = this.con.prepareStatement(sql);
                pst.setString(1, this.txtevcode.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog((Component)null, "Deleted Successfully");
            } catch (Exception var4) {
                System.out.println("" + var4);
            }
        }

        this.ShowData();
        this.clearFields();
    }

    private void evtableMouseClicked(MouseEvent evt) {
        boolean a = this.evtable.isEditing();
        if (!a) {
            JOptionPane.showMessageDialog((Component)null, "You cannot edit the table");
            this.evtable.setFocusable(false);
        }

    }

    private void txtr1rnoActionPerformed(ActionEvent evt) {
    }

    private void txtwinrnoActionPerformed(ActionEvent evt) {
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new Best_Athlete()).setVisible(true);
    }

    private void evtableFocusGained(FocusEvent evt) {
        boolean a = this.evtable.isEditing();
        if (!a) {
            JOptionPane.showMessageDialog((Component)null, "You cannot edit this table");
            this.evtable.setFocusable(false);
        }

    }

    public void ShowData() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            String sql = "Select Evname,Evcat,Evcode,Winner,Winrno from Events";
            PreparedStatement pst1 = this.con.prepareStatement(sql);
            ResultSet res = pst1.executeQuery();
            this.evtable.setModel(DbUtils.resultSetToTableModel(res));
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4);
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
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Events()).setVisible(true);
            }
        });
    }
}
