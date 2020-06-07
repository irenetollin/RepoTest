import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTable; 
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeListener;


import javax.swing.JTabbedPane;


import javax.swing.border.BevelBorder;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.Color;
import java.awt.FlowLayout;

public class Main {

	ChangeListener listener;
	JPanel panel3 = new JPanel();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton btnlistino = new JButton("Listino");
	JButton btnmagazzino = new JButton("Magazzino");
	JButton btstordini = new JButton("Storico Ordini");
	JMenuBar menuBar = new JMenuBar();
	JMenu mfile = new JMenu("File");
	JMenu mconfigura = new JMenu("Configurazione");
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel panel_1;
	private JMenuItem mnserver;
	private JSeparator separator_3;
	private JMenuItem mnstampante;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JMenuItem mnbackup;
	private JSeparator separator_6;
	private JMenuItem mnimport;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnstats;



	public static void main(String args[]){  
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/processes","root","admin");  
	//here sonoo is database name, root is username and password  
	//Statement stmt=con.createStatement();  
	//ResultSet rs=stmt.executeQuery("select * from processes");  
	//while(rs.next())  
	//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	//con.close();
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new TableProcesses();
        }
    });
	
    }catch(Exception e)
		{ System.out.println(e);}

	}
	
}
	


