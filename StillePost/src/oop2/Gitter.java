package oop2;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


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
		this.personen.add(new Mensch("Berta Bl�mchen", 2, breite, hoehe));
	}
	
	public void spielablauf() {
		
		ArrayList<Runde> runden = new ArrayList<Runde>();
		for (int i = 1; i <= anzahlRunden; i++) {
			//Rundenabl�ufe
			personenSetzen(this.personen, this.gitter);
			personenBewegen(this.personen);
			//Berechnung der Werte
			
			
			//Erzeugen der Runde
			Runde tmp = new Runde(i,1,1,1);
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
	
    /**
     * generiert eine zuf�llige Zahl, die die Bewegungsrichtung eines Menschen steuert
     * @return Zufallszahl zwischen 1 und 5
     */
    public int zufaelligeBewegung(){
    	int randomNum = ThreadLocalRandom.current().nextInt(1,6);
    	return randomNum;
    }
    
    public boolean inGitter(int x, int y){
        return x < breite  && x >= 0 && y < hoehe  && y >= 0;
    }

    /**
     * Methode, die den Prozentwert an Menschen berechnet, die eine gewisse Meinung haben
     * @param meinung f�r die der Prozenzwert berechnet werden soll
     * @return prozentualer Anteil als double
     */
    public double prozentwertBerechnen(int meinung) {
    	int tmp = 0;
    	for (int i = 0; i < personen.size(); i++) {
			if (personen.get(i).getMeinung()==meinung) {
				tmp++;
			}
		}
    	double wert = tmp / personen.size();
    	return wert;
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
        	if(inGitter(tmp.getX(),tmp.getY())) {
        		tmp.move(zufaelligeBewegung());
        	}
        }
    }
}
