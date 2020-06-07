
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import com.ibatis.common.jdbc.ScriptRunner;
import javax.swing.JTabbedPane;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Main {

	ChangeListener listener;
	JPanel panel3 = new JPanel();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);




	public static void main(String args[]){  
	try{  
	// Creation of database and its tables 
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection
	("jdbc:mysql://localhost/?user=root&password=admin"); 
	ScriptRunner runner=new ScriptRunner(con, false, false);
	InputStreamReader reader = new InputStreamReader(new FileInputStream("Dump/dump.sql"));
	runner.runScript(reader);
	reader.close();
	con.close();
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
	


