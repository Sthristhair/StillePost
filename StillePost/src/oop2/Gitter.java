package oop2;

import java.util.ArrayList;
import java.util.Random;


public class Gitter {
	//Attribute
	private int breite;
	private int hoehe;
	private int anzahlRunden;

	private Feld[][] gitter;
	
	private ArrayList<Mensch> personen;
	
	public Gitter(int breite, int hoehe, int anzahlPersonen, int anzahlRunden){
		this.breite = breite;
		this.hoehe = hoehe;
		this.anzahlRunden = anzahlRunden;
		gitter = new Feld[breite][hoehe];
		
		for (int i = 0; i < breite; i++) {
			for (int j = 0; j < hoehe; j++) {
				gitter[i][j] = new Feld(i,j);
			}
		}	
		
		this.personen = new ArrayList<>();
		
		Random rand = new Random();
		for (int i = 0; i < anzahlPersonen; i++) {
			int x = rand.nextInt(breite);
			int y = rand.nextInt(hoehe);
			this.personen.add(new Mensch(x,y));
		}
		
		this.personen.add(new Mensch("Anton Angeber", 1, 0, 0));
		this.personen.add(new Mensch("Berta Blümchen", 2, breite, hoehe));
	}
	
	public void spielablauf() {
		
		ArrayList<Runde> runden = new ArrayList<Runde>();
		for (int i = 1; i < anzahlRunden; i++) {
			//Rundenabläufe
			
			//Berechnung der Werte
			
			//Erzeugen der Runde
			Runde tmp = new Runde(1,1,1,1);
			runden.add(tmp);
		}
	}
	
	
    public ArrayList<Feld> getNachbarn(Feld start){
        ArrayList<Feld> nachbarn = new ArrayList<Feld>();
        // get start coordinates
        int x = start.getX();
        int y = start.getY();
        
        // if neighbor is in gitter then add to neighbor list
        if(inGitter(x-1, y)){
            nachbarn.add(gitter[x-1][y]);
        }
        if(inGitter(x+1, y)){
            nachbarn.add(gitter[x+1][y]);
        }
        if(inGitter(x, y+1)){
            nachbarn.add(gitter[x][y+1]);
        }
        if(inGitter(x, y-1)){
            nachbarn.add(gitter[x][y-1]);
        }
        return nachbarn;
    }
	
    public boolean inGitter(int x, int y){
        return x < breite  && x >= 0 && y < hoehe  && y >= 0;
    }

	public int getWidth() {
		return breite;
	}

	public int getHeight() {
		return hoehe;
	}
	
    /**
     * Verteilt die Menschen anhand ihrer X-Y-Koordinaten auf dem Spielfeld.
     * @param menschen die zu verteiltenden Menschen.
     * @param gitter das zugehoerige Spielfeld auf dem verteilt werden soll.
     */
    private void personenSetzen(ArrayList<Mensch> menschen, Feld[][] gitter) {
        for (Mensch tmp : personen) {
            int pX = tmp.getX();
            int pY = tmp.getX();
            gitter[pX][pY].getPersonen().add(tmp);
        }
    }
    
    
    /**
     * Bewegt die Menschen auf dem Spielfeld nach Zufall
     * @param personen die zu bewegenden Menschen.
     */
    private void personenBewegen(ArrayList<Mensch> personen) {
        for (Mensch tmp : personen) {
   
        }
    }
}
