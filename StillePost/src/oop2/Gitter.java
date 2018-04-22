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
		
		this.gitter = new Feld[this.breite][this.hoehe];

		for (int i = 0; i < breite; i++) {
			for (int j = 0; j < hoehe; j++) {
				gitter[i][j] = new Feld(i,j);
			}
		}	
		
		this.personen = new ArrayList<>();
		
		Random rand = new Random();
		for (int i = 0; i < anzahlPersonen-2; i++) {
			int x = rand.nextInt(breite);
			int y = rand.nextInt(hoehe);
			this.personen.add(new Mensch(x,y));
		}
		
		this.personen.add(new Mensch("Anton Angeber", 1, 0, 0));
		this.personen.add(new Mensch("Berta Blümchen", 2, breite-1, hoehe-1));
	}
	
	public void spielablauf() {
		
		ArrayList<Runde> runden = new ArrayList<Runde>();
		for (int i = 1; i <= anzahlRunden; i++) {
			//Rundenabläufe
			personenSetzen(this.personen, this.gitter);
			meinungChecken(this.gitter);
			
			
			//Berechnung der Werte
			double prozent0 = prozentwertBerechnen(0);
			double prozent1 = prozentwertBerechnen(1);
			double prozent2 = prozentwertBerechnen(2);
			
			
			//Erzeugen der Runde
			Runde tmp = new Runde(i,prozent0,prozent1,prozent2);
			runden.add(tmp);
			
			personenBewegen(this.personen);
			clearFelder(this.gitter);
		}
		beenden(runden);
	}
  
	/**
	 * Auswertung der Runden am Ende der Simulation
	 * @param runden ArrayList mit Runden
	 */
    public void beenden(ArrayList<Runde> runden) {
    	System.out.println("Das Spiel ist beendet, hier die Auswertung:");
    	for (int i = 0; i < runden.size(); i++) {
			System.out.println(runden.get(i).toString());
		}
    }

    /**
     * Methode, die den Prozentwert an Menschen berechnet, die eine gewisse Meinung haben
     * @param meinung für die der Prozenzwert berechnet werden soll
     * @return prozentualer Anteil als double
     */
    public double prozentwertBerechnen(int meinung) {
    	int tmp = 0;
    	for (int i = 0; i < personen.size(); i++) {
			if (personen.get(i).getMeinung()==meinung) {
				tmp++;
			}
		}
    	double wert = (double) tmp / personen.size();
    	return wert;
    }
    
    private void meinungChecken(Feld[][] gitter) {
        for (Feld[] feldX : gitter) {
            for (Feld feldY : feldX) {
                if (!feldY.getPersonen().isEmpty()) {
                    feldY.checkMeinung();
                }
            }
        }
    }
	
    private void clearFelder(Feld[][] feld) {
        for (int i = 0; i < breite; i++) {
            for (int j = 0; j < hoehe; j++) {
                feld[i][j].getPersonen().clear();
            }
        }
    }
    
    /**
     * Verteilt die Menschen anhand ihrer X-Y-Koordinaten auf dem Spielfeld.
     * @param menschen die zu verteiltenden Menschen.
     * @param gitter das zugehörige Spielfeld auf dem verteilt werden soll.
     */
    private void personenSetzen(ArrayList<Mensch> menschen, Feld[][] spielfeld) {
        for (Mensch tmp : menschen) {
            int pX = tmp.getX();
            int pY = tmp.getY();
            spielfeld[pX][pY].getPersonen().add(tmp);
        }
    }
    
    /**
     * Bewegt die Menschen auf dem Spielfeld nach Zufall
     * @param personen die zu bewegenden Menschen.
     */
    private void personenBewegen(ArrayList<Mensch> personen) {
        for (Mensch tmp : personen) {
          		tmp.move(zufaelligeBewegung(), breite, hoehe);
        }
    }
    
    /**
     * generiert eine zufällige Zahl, die die Bewegungsrichtung eines Menschen steuert
     * @return Zufallszahl zwischen 1 und 5
     */
    public int zufaelligeBewegung(){
    	int randomNum = ThreadLocalRandom.current().nextInt(1,6);
    	return randomNum;
    }
    
	public int getWidth() {
		return breite;
	}

	public int getHeight() {
		return hoehe;
	}
}
