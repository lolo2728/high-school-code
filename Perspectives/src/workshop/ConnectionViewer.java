package workshop;

import java.awt.Color;
import java.awt.Graphics2D;

import perspectives.base.Property;
import perspectives.base.Viewer;
import perspectives.properties.PBoolean;
import perspectives.properties.PSignal;
import perspectives.two_d.JavaAwtRenderer;

public class ConnectionViewer extends Viewer implements JavaAwtRenderer {
	
	private String[] points;
	private double[] pointX;
	private double[] pointY;
	private double[] fx;
	private double[] fy;
	
	private int[] connection1;
	private int[] connection2;
	private double[] strength;
	
	private boolean debug = true;


	
	public ConnectionViewer(String name) {
		super(name);
		
		//STUDENTS: you can change between createGraph1,2,3 or you can define your own network!
		createGraph3();

		
		//STUDENTS: don't change between here ...
		pointX = new double[points.length];
		pointY = new double[points.length];
		fx = new double[points.length];
		fy = new double[points.length];
		
		for (int i=0; i<points.length; i++){
			pointX[i] = Math.random()*500;
			pointY[i] = Math.random()*500;
		}
		
		Property<PSignal> step = new Property<PSignal>("Step", new PSignal())
				{
					@Override
					protected boolean updating(PSignal newvalue) {
						applyForces();
						computeForces();
						requestRender();
						return super.updating(newvalue);
					}
				};
		addProperty(step);
		
		Property<PBoolean> deb = new Property<PBoolean>("Debug", new PBoolean(true))
				{
					@Override
					protected boolean updating(PBoolean newvalue) {
						debug = newvalue.boolValue();
						return true;
					}
				};
		addProperty(deb);
		
		computeForces();
		requestRender();
		//... and here
		
		//STUDENTS: uncomment this if you want things to run automatically
		//this.startSimulation(100);
	}

	@Override
	public void render(Graphics2D g) {

		g.setColor(Color.black);
		
		for (int i = 0; i<points.length; i++){
			g.fillOval((int)pointX[i]-15, (int)pointY[i]-15, 30, 30);
			
			//STUDENTS: add some code here to show the labels of the points as well
		}
		
		//STUDENTS: add some code here to draw connections between points
		
		//don't change this
		if (debug)
			renderDebug(g);
		
	}
	
	private void renderDebug(Graphics2D g)
	{
		g.setColor(Color.green);
		for (int i=0; i<points.length; i++){
			g.drawLine((int)pointX[i], (int)pointY[i], (int)(pointX[i] + fx[i]), (int)(pointY[i]+fy[i]));
		}
	}
	
	private void computeForces(){
		
		//STUDENTS: initialize forces
		
		
		//STUDENTS: compute attraction/spring forces
		
		
		//STUDENTS: compute repulsion forces
		

	}
	
	private void applyForces()
	{
		//STUDENTS: apply the forces
	}	
	
	private void createGraph1(){
		points = new String[]{"p0","p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9"};
		
		connection1 = new int[]{0, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 7, 7};
		connection2 = new int[]{1, 2, 3, 2, 4, 5, 5, 5, 6, 7, 7, 8, 9, 7, 9};
		
		strength = new double[]{1, 1, 1, 1, 0.1, 1, 1, 1, 1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
	}
	
	private void createGraph2(){
		points = new String[]{"p0","p1", "p2", "p3"};
		
		connection1 = new int[]{0, 0, 0, 1, 1, 2};
		connection2 = new int[]{1, 2, 3, 2, 3, 3};
		
		strength = new double[]{1, 1, 1, 1, 1, 1};
	}
	
	private void createGraph3(){
		points = new String[]{"p0","p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11"};
		
		connection1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5};
		connection2 = new int[]{1, 2, 3, 4, 5, 0, 7, 8, 9, 10, 11, 6, 7, 8, 9, 10, 11};
		
		strength = new double[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1,  1,  1, 1, 1, 1, 1,  1};
	}
	
	
	@Override
	public void simulate() {
		computeForces();
		applyForces();
		requestRender();
	}

	@Override
	public Color getBackgroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean mousepressed(int x, int y, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mousereleased(int x, int y, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mousemoved(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mousedragged(int currentx, int currenty, int oldx, int oldy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void keyPressed(String key, String modifiers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(String key, String modifiers) {
		// TODO Auto-generated method stub
		
	}

}
