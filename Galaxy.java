import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class Galaxy extends JFrame implements ActionListener,HyperlinkListener,WindowListener{
	public JTextField enter;
	public JEditorPane display;
  public Galaxy(){
	  super("Galaxy Web Browser");
	  Container c=getContentPane();
	 // setContentPane(new JLabel(new ImageIcon("image/1.jpg")));
	  c.setBackground(Color.blue);
	  enter=new JTextField("Enter URL"); 
	  enter.setFont(new Font("Times Roman", Font.BOLD, 15));
	  enter.addActionListener(this);
	  c.add(enter,BorderLayout.NORTH);
	  //JEditorPane
	  display=new JEditorPane();
	  display.setBackground(Color.WHITE);
	  display.setEditable(false);
	  display.addHyperlinkListener(this);
	  c.add(new JScrollPane(display),BorderLayout.CENTER);
	  setSize(400, 300);
	  setVisible(true);
	  show();
	  setLocationRelativeTo(null);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }	
	
	public static void main(String[] args) {
		Galaxy app=new Galaxy();
		app.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ae){
				System.exit(0);
			}
		}
		);
	}
	


	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		
	}

	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {
		if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED);
		getThePage(e.getURL().toString());
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		getThePage(arg0.getActionCommand());
		
	}

	private void getThePage(String location) {
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		try{
			display.setPage("http://"+location);
			enter.setText("पेज हेरनुहोस");
			
		}
		catch(IOException io){
			JOptionPane.showMessageDialog(this, "Error retrieving specified URl","मुला  आलि हेरेरा URL हान हे",JOptionPane.ERROR_MESSAGE);	
		}
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

}
