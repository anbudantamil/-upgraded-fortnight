package WebPackage;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JFrame;



public class Browser extends JFrame {
	
		private JTextField addressField;
	    private JEditorPane window;
	    
	    public Browser() {
	        super("Web Browser Model");
	        addressField = new JTextField("");
	        addressField.addActionListener(
	                new ActionListener() {
	                    public void actionPerformed(ActionEvent event) {
	                        loadSite(event.getActionCommand());
	                    }
	                }
	                );

	        add(addressField, BorderLayout.NORTH);

	        window = new JEditorPane();
	        window.setEditable(false);
	        window.addHyperlinkListener(
	                new HyperlinkListener() {
	                    public void hyperlinkUpdate1(HyperlinkEvent event) {
	                        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
	                        loadSite(event.getURL().toString());
	                        }
}

						public void hyperlinkUpdate(HyperlinkEvent arg0) {
							// TODO Auto-generated method stub
							
						}
});

	        add(new JScrollPane(window), BorderLayout.CENTER);
	    }

	    private void loadSite(String text) {
	        try {
	            window.setPage(text);
	            addressField.setText(text);
	        }
	        catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Invalid URL!");
	        }
	    }

	    public static void main(final String[] args) {
	        final Browser browser = new Browser();
	        browser.setDefaultCloseOperation(3);
	        browser.setSize(1000, 1000);
	        browser.setVisible(true);
	    }
	}

