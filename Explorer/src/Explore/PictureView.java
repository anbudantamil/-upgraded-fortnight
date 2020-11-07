package Explore;

import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class PictureView {


	    public static void main(final String[] args) {
	        final JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	        jfc.setFileSelectionMode(1);
	        final int returnValue = jfc.showOpenDialog(null);
	        if (returnValue == 0 && jfc.getSelectedFile().isDirectory()) {
	            System.out.println("You selected the directory: " + jfc.getSelectedFile());
	        }
	    }
	}

	
