package workshop;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import perspectives.base.Property;
import perspectives.base.Viewer;
import perspectives.properties.PBoolean;
import perspectives.properties.PSignal;
import perspectives.two_d.JavaAwtRenderer;


public class IMDBViewer extends IMDBViewerBase {
	
		
	public IMDBViewer(String name) {
		super(name);
		
		//this.startSimulation(100);
	}
	
	protected double actorConnection(int a1, int a2){
		return 0;
	}
	
	protected double movieConnection(int m1, int m2){
		return 0;
	}
	
	@Override
	protected void computeActorForces(){
		
	}
	
	@Override
	protected void applyActorForces(){
		
	}
	
	
	@Override
	protected void computeMovieForces(){
		
	}
	
	@Override
	protected void applyMovieForces(){
		
	}


	@Override
	protected void renderActors(Graphics2D g) {
		
		g.setColor(new Color(100,100,100,100));			
						
		g.setColor(Color.black);
		for (int i=0; showLabels && i<actors.length; i++){
			g.fillOval((int)actorX[i]-5, (int)actorY[i]-5, 10,10);
		}

	}
	
	@Override
	protected void renderMovies(Graphics2D g){
	}
	
	
	
	
}
