import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import perspectives.*;
import perspectives.base.Environment;
import workshop.ConnectionViewer;
import workshop.IMDBViewer;


public class main {

	  public static void main(String[] args) {  
		  
		 Environment e = new Environment(false);
		 
		 //e.addViewer(new IMDBViewer("imdb"));
	       e.addViewer(new ConnectionViewer("connections"));
	  }
	      
}