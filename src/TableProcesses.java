import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

public class TableProcesses extends JFrame implements ActionListener {
	  JFrame frame1;

	    JLabel l0, l1, l2;

	    JComboBox c1;

	    JButton b1;

	    Connection con;

	    ResultSet rs, rs1;

	    Statement st, st1;

	    PreparedStatement pst;

	    String ids;

	    static JTable table;

	    String[] columnNames = {"Process Name", "Periodicity","Execution Date", "Execution Time", "Execution Status"};

	    String from;

	 

	    TableProcesses() {

	 

	        l0 = new JLabel("Process Information");

	        l0.setForeground(Color.red);

	        l0.setFont(new Font("Serif", Font.BOLD, 20));

	        l1 = new JLabel("Select Process");

	        b1 = new JButton("Search");

	 

	        l0.setBounds(100, 50, 350, 40);

	        l1.setBounds(40, 110, 200, 20);

	        b1.setBounds(150, 150, 150, 20);

	        b1.addActionListener(this);

	 

	        setTitle("Fetching Process Info");

	        setLayout(null);

	        setVisible(true);

	        setSize(700, 700);

	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	 

	        add(l0);

	        add(l1);;

	        add(b1);

	        try {

	        	Class.forName("com.mysql.jdbc.Driver");  

	            con = DriverManager.getConnection(  
	            		"jdbc:mysql://localhost:3306/processes","root","admin");  

	            st = con.createStatement();

	            rs = st.executeQuery("select ID from processes");

	            Vector v = new Vector();

	            while (rs.next()) {

	                ids = rs.getString(1);

	                v.add(ids);

	            }

	            c1 = new JComboBox(v);

	            c1.setBounds(150, 110, 150, 20);

	 

	            add(c1);

	            st.close();

	            rs.close();

	        } catch (Exception e) {

	        }

	    }

	 

	    public void actionPerformed(ActionEvent ae) {

	        if (ae.getSource() == b1) {

	            showTableData();

	        }

	 

	    }

	 

	    public void showTableData() {

	 

	        frame1 = new JFrame("Result for process execution");

	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        frame1.setLayout(new BorderLayout());

	//TableModel tm = new TableModel();

	        DefaultTableModel model = new DefaultTableModel();

	        model.setColumnIdentifiers(columnNames);

	//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

	//table = new JTable(model);

	        table = new JTable();

	        table.setModel(model);

	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

	        table.setFillsViewportHeight(true);

	        JScrollPane scroll = new JScrollPane(table);

	        scroll.setHorizontalScrollBarPolicy(

	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	        scroll.setVerticalScrollBarPolicy(

	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

	        from = (String) c1.getSelectedItem();

	//String textvalue = textbox.getText();
	        
	        String ProcessName = "";
	        
	        String Periodicity = "";

	        Date  ExecutionDate;
	        
	        Time ExecutionTime;

	        String ExecutionStatus = "";



	 

	        try {

	            pst = (PreparedStatement) con.prepareStatement
	            		("select ProcessName, periodicity.Periodicity, Execution_Date, Execution_Status from execution_processes "
	            				+ "JOIN processes ON execution_processes.Process_ID = processes.ID "
	            				+ "JOIN periodicity ON processes.periodicity = periodicity.IDPeriodicity "
	            				+ "WHERE Process_ID = "+(String) c1.getSelectedItem() );

	            ResultSet rs = pst.executeQuery();

	            int i = 0;

	            while (rs.next()) {
	            	
	            	ProcessName = rs.getString("ProcessName");
	            	
	            	Periodicity = rs.getString("Periodicity");

	            	ExecutionDate = rs.getDate("Execution_Date");

	            	ExecutionTime = rs.getTime("Execution_Date");
	            	ExecutionStatus = rs.getString("Execution_Status");



	                model.addRow(new Object[]{ProcessName, Periodicity, ExecutionDate, ExecutionTime, ExecutionStatus});

	                i++;

	            }

	            if (i < 1) {

	                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

	            }

	            if (i == 1) {

	                System.out.println(i + " Record Found");

	            } else {

	                System.out.println(i + " Records Found");

	            }

	        } catch (Exception ex) {

	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

	        }

	        frame1.add(scroll);

	        frame1.setVisible(true);

	        frame1.setSize(700, 700);

	    }
}