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
import perspectives.properties.POptions;
import perspectives.properties.PSignal;
import perspectives.two_d.JavaAwtRenderer;

class Date
{
	public Date(String s){
		
		String[] split = s.split(" ");
		
		if (split.length == 1){
			day = -1;
			month = -1;
			year = Integer.parseInt(split[0]);
		}
		else{
		day = Integer.parseInt(split[0]);
		year = Integer.parseInt(split[2]);
		
		if (split[1].equalsIgnoreCase("January")) month = 1;
		else if (split[1].equalsIgnoreCase("February")) month = 2;
		else if (split[1].equalsIgnoreCase("March")) month = 3;
		else if (split[1].equalsIgnoreCase("April")) month = 4;
		else if (split[1].equalsIgnoreCase("May")) month = 5;
		else if (split[1].equalsIgnoreCase("June")) month = 6;
		else if (split[1].equalsIgnoreCase("July")) month = 7;
		else if (split[1].equalsIgnoreCase("August")) month = 8;
		else if (split[1].equalsIgnoreCase("September")) month = 9;
		else if (split[1].equalsIgnoreCase("October")) month = 10;
		else if (split[1].equalsIgnoreCase("November")) month = 11;
		else if (split[1].equalsIgnoreCase("December")) month = 12;
		else System.out.println("Unrecognized Date Month:" + split[1]);}
	}
	int month;
	int day;
	int year;
}

class Actor
{
	String name;
	boolean male;
	boolean female;
	Date birth;
	Date death;
	int height;
	
	int[] movies;
}

class Movie
{
	String title;
	int[] actors;
	
	Date year;
	double rating;
	String[] directors;
	
	boolean genreDocumentary = false;	
	boolean genreCrime = false;	
	boolean genreDrama = false;	
	boolean genreAction = false;	
	boolean genreShortmovie = false;
	boolean genreSport = false;	
	boolean genreMusical = false;	
	boolean genreRomance = false;	
	boolean genreBiography = false;	
	boolean genreThriller = false;	
	boolean genreAdventure = false;	
	boolean genreMystery = false;	
	boolean genreScifi = false;	
	boolean genreHistory = false;	
	boolean genreAnimation = false;	
	boolean genreWestern = false;	
	boolean genreNews = false;	
	boolean genreHorror = false;
}

public class IMDBViewerBase extends Viewer implements JavaAwtRenderer {
	
	Actor[] actors;
	double[] actorX;
	double[] actorY;
	double[] fActorX;
	double[] fActorY;
	int[] actorConnections1;
	int[] actorConnections2;
	double[] actorConnectionStrength;
	
	Movie[] movies;
	double[] movieX;
	double[] movieY;
	double[] fMovieX;
	double[] fMovieY;
	int[] movieConnections1;
	int[] movieConnections2;
	double[] movieConnectionStrength;
	

	int[] actorDegrees;
	int[] movieDegrees;

	String mode;
	
	boolean showEdges;
	boolean showLabels;
	
	boolean debug;
	
	public IMDBViewerBase(String name) {
		super(name);
		
		load("c:/MovieSmall.txt", "c:/ActorSmall.txt");
		
		mode = "Actors";
		
		computeConnections();
		computeDegrees();
		
		Property<POptions> actmov = new Property<POptions>("Show", new POptions(new String[]{"Actors", "Movies"}))
				{
			@Override
			protected boolean updating(POptions newvalue) {
				mode = newvalue.options[newvalue.selectedIndex];
				requestRender();
				return super.updating(newvalue);
			}
				};
		addProperty(actmov);
		
		Property<PSignal> simstep = new Property<PSignal>("Step", new PSignal())
				{

					@Override
					protected boolean updating(PSignal newvalue) {
						simulate();
						requestRender();
						return super.updating(newvalue);
					}
				};
		addProperty(simstep);		
				
		Property<PBoolean> deb = new Property<PBoolean>("Debug", new PBoolean(true))
					{
							@Override
							protected boolean updating(PBoolean newvalue) {
								debug = newvalue.boolValue();
								return true;
							}
						};
		addProperty(deb);
				
		Property<PBoolean> showlab = new Property<PBoolean>("Show Labels", new PBoolean(true))
						{

							@Override
							protected boolean updating(PBoolean newvalue) {
								showLabels = newvalue.boolValue();
								requestRender();
								return super.updating(newvalue);
							}
						};
		this.addProperty(showlab);
		showLabels = true;
		
		Property<PBoolean> showedge = new Property<PBoolean>("Show Edges", new PBoolean(true))
				{

					@Override
					protected boolean updating(PBoolean newvalue) {
						showEdges = newvalue.boolValue();
						requestRender();
						return super.updating(newvalue);
					}
				};
		this.addProperty(showedge);
		showEdges = true;
		
	}
	
	protected double actorConnection(int a1, int a2)
	{
		return 0;
	}
	
	protected double movieConnection(int m1, int m2)
	{
		return 0;
	}
	
	protected void computeActorForces(){
		
	}
	
	protected void applyActorForces(){
		
	}

	protected void computeMovieForces(){
		
	}
	
	protected void applyMovieForces(){
		
	}

	@Override
	public void simulate() {
		super.simulate();
		if (mode.equals("Actors")){
		computeActorForces();
		applyActorForces();
		}
		else{
			computeMovieForces();
			applyMovieForces();
		}
		requestRender();
	}
	
	
	@Override
	public void render(Graphics2D g) {
		if (mode.equals("Actors"))
			renderActors(g);
		else renderMovies(g);
		renderDebug(g);
	}
	
	protected void renderActors(Graphics2D g){
		
	}
	
	protected void renderMovies(Graphics2D g){
		
	}
	
	protected void renderDebug(Graphics2D g)
	{
		if (debug){
			g.setColor(Color.green);
			if (mode.equals("Actors")){
				if (actors == null || actorX == null || actorY == null || fActorX == null || fActorY == null)
					return;
				for (int i=0; i<actors.length; i++){
					g.drawLine((int)actorX[i], (int)actorY[i], (int)(actorX[i] + fActorX[i]), (int)(actorY[i]+fActorY[i]));
				}
			}
			else if (mode.equals("Movies")){
				if (movies == null || movieX == null || movieY == null || fMovieX == null || fMovieY == null)
					return;
				for (int i=0; i<movies.length; i++){
					g.drawLine((int)movieX[i], (int)movieY[i], (int)(movieX[i] + fMovieX[i]), (int)(movieY[i]+fMovieY[i]));
				}
			}
		}
	}
	
	public void computeDegrees()
	{
		this.actorDegrees = new int[actors.length];
		for (int i=0; i<actors.length; i++)
		{
			int nrconn = 0;
			for (int j=0; j<actors.length; j++)
				if (i != j && actorConnection(i, j) > 0)
					nrconn++;
			actorDegrees[i] = nrconn;
		}
		
		this.movieDegrees = new int[movies.length];
		for (int i=0; i<movies.length; i++)
		{
			int nrconn = 0;
			for (int j=0; j<movies.length; j++)
				if (i != j && movieConnection(i, j) > 0)
					nrconn++;
			movieDegrees[i] = nrconn;
		}
	}
	
	public void computeConnections()
	{
		int nrconn = 0;
		for (int i=0; i<actors.length-1; i++)
			for (int j=i+1; j<actors.length; j++)
				if (this.actorConnection(i, j) > 0)
					nrconn++;
		
		actorConnections1 = new int[nrconn];
		actorConnections2 = new int[nrconn];
		actorConnectionStrength = new double[nrconn];
		
		nrconn=0;
		for (int i=0; i<actors.length-1; i++)
			for (int j=i+1; j<actors.length; j++){
				double c = actorConnection(i,j);
				if (c > 0)
				{
					actorConnections1[nrconn] = i;
					actorConnections2[nrconn] = j;
					actorConnectionStrength[nrconn++] = c;
				}
			}
		
		nrconn = 0;
		for (int i=0; i<movies.length-1; i++)
			for (int j=i+1; j<movies.length; j++)
				if (this.movieConnection(i, j) > 0)
					nrconn++;
		
		movieConnections1 = new int[nrconn];
		movieConnections2 = new int[nrconn];
		movieConnectionStrength = new double[nrconn];
		
		nrconn=0;
		for (int i=0; i<movies.length-1; i++)
			for (int j=i+1; j<movies.length; j++){
				double c = movieConnection(i,j);
				if (c > 0)
				{
					movieConnections1[nrconn] = i;
					movieConnections2[nrconn] = j;
					movieConnectionStrength[nrconn++] = c;
				}
			}
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
	
	private void load(String moviefile, String actorfile)
	{		
		try{
		
		File f = new File(moviefile);
		BufferedReader brm = new BufferedReader(new InputStreamReader( new DataInputStream(new FileInputStream(f))));
		
		String line = "";
		
		File f2 = new File(actorfile);
		BufferedReader bra = new BufferedReader(new InputStreamReader( new DataInputStream(new FileInputStream(f2))));
		
		ArrayList<Actor> act = new ArrayList<Actor>();
		while ((line = bra.readLine()) != null)
		{
			String[] split = line.split("\t");

			Actor a = new Actor();			
			a.name = split[0];			
			if (split[1].trim().equalsIgnoreCase("m"))
				a.male = true;
			else if (split[1].trim().equals("f"))
				a.female = true;
			else System.out.println("Unrecognized gender: " + split[1].trim());
			
			split[2] = split[2].trim();
			if (split[2].length() > 0)
				a.birth = new Date(split[2]);
			else a.birth = null;
			split[3] = split[3].trim();
			if (split[3].length() > 0)
				a.death = new Date(split[3]);
			else a.death = null;
			
			a.height = parseHeight(split[4]);
						
			act.add(a);
		}
		actors = new Actor[act.size()];
		for (int i=0; i<act.size(); i++)
			actors[i] = act.get(i);
		
		ArrayList<Movie> mov = new ArrayList<Movie>();
		while ((line = brm.readLine()) != null)
		{
			String[] split = line.split("\t");
			
			Movie m = new Movie();
			m.title = split[0];
			m.year = new Date(split[1]);
			m.rating = Double.parseDouble(split[2]);
			
			String[] genres = split[3].split(",");
			for (int i=0; i<genres.length; i++){
				genres[i] = genres[i].trim();
				if (genres[i].equalsIgnoreCase("documentary"))
					m.genreDocumentary = true;
				else if (genres[i].equalsIgnoreCase("crime"))
					m.genreCrime = true;
				else if (genres[i].equalsIgnoreCase("drama"))
					m.genreDrama = true;
				else if (genres[i].equalsIgnoreCase("action"))
					m.genreAction = true;
				else if (genres[i].equalsIgnoreCase("short"))
					m.genreShortmovie = true;
				else if (genres[i].equalsIgnoreCase("sport"))
					m.genreSport = true;
				else if (genres[i].equalsIgnoreCase("musical"))
					m.genreMusical = true;
				else if (genres[i].equalsIgnoreCase("romance"))
					m.genreRomance = true;
				else if (genres[i].equalsIgnoreCase("biography"))
					m.genreBiography = true;
				else if (genres[i].equalsIgnoreCase("thriller"))
					m.genreThriller = true;
				else if (genres[i].equalsIgnoreCase("adventure"))
					m.genreAdventure = true;
				else if (genres[i].equalsIgnoreCase("mystery"))
					m.genreMystery = true;
				else if (genres[i].equalsIgnoreCase("sci-fi"))
					m.genreScifi = true;
				else if (genres[i].equalsIgnoreCase("history"))
					m.genreHistory = true;
				else if (genres[i].equalsIgnoreCase("animation"))
					m.genreAnimation = true;
				else if (genres[i].equalsIgnoreCase("western"))
					m.genreWestern = true;
				else if (genres[i].equalsIgnoreCase("news"))
					m.genreNews = true;
				else if (genres[i].equalsIgnoreCase("horror"))
					m.genreHorror = true;
				else 
					System.out.println("unrecognized genre: " + genres[i]);
			}
			
			m.directors = split[4].split(",");
			for (int i=0; i<m.directors.length; i++) m.directors[i] = m.directors[i].trim();
			
			String[] acts = split[5].split(",");
			
			if (acts.length < 2) continue;
			
			m.actors = new int[acts.length];
			for (int i=0; i<acts.length; i++)
			{
				acts[i] = acts[i].trim();
				int index = -1;
				for (int j=0; j<act.size(); j++)
					if (act.get(j).name.equals(acts[i]))
					{
						index = j;
						break;
					}
				if (index < 0)
					System.out.println("Error: unknown actor: " + acts[i]);
				m.actors[i] = index;
			}
			
			mov.add(m);
		}
		movies = new Movie[mov.size()];
		for (int i=0; i<mov.size(); i++)
			movies[i] = mov.get(i);
		
		for (int i=0; i<actors.length; i++)
		{
			int nrm = 0;
			for (int j=0; j<movies.length; j++)
			{
				for (int k=0; k<movies[j].actors.length; k++)
					if (movies[j].actors[k] == i)
					{
						nrm++;
						break;
					}
			}
			
			actors[i].movies = new int[nrm];
			nrm = 0;
			for (int j=0; j<movies.length; j++)
			{
				for (int k=0; k<movies[j].actors.length; k++)
					if (movies[j].actors[k] == i)
					{
						actors[i].movies[nrm] = j;
						nrm++;
						break;
					}
			}
		}
		
		actorX = new double[actors.length];
		actorY = new double[actors.length];
		
		for (int i=0; i<actorX.length; i++)
		{
			actorX[i] = Math.random()*1000;
			actorY[i] = Math.random()*1000;
		}
		
		movieX = new double[movies.length];
		movieY = new double[movies.length];
		
		for (int i=0; i<movieX.length; i++)
		{
			movieX[i] = Math.random()*4000;
			movieY[i] = Math.random()*4000;
		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private int parseHeight(String h){
		if (h.equals("?"))
			return -1;
		else if (h.indexOf("cm") >= 0){
			h = h.replace("cm", "");
			return (int)(Double.parseDouble(h.trim()) * 0.3937);
		}
		String[] split = h.split(" ");
		split[0] = split[0].replace("'", "");
		int f = Integer.parseInt(split[0]);
		
		int i = 0;
		if (split.length > 1){
			split[1] = split[1].replace("\"", "");
			i = Integer.parseInt(split[1]);
		}
		
		return 12*f + i;
	}
	

}
