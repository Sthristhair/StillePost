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
				//System.out.println(i+","+j);
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
		this.personen.add(new Mensch("Berta Bl�mchen", 2, breite-1, hoehe-1));
	}
	
	public void spielablauf() {
		
		ArrayList<Runde> runden = new ArrayList<Runde>();
		for (int i = 1; i <= anzahlRunden; i++) {
			//Rundenabl�ufe
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
			System.out.println(i + ". Runde beendet!");
		}
		beenden(runden);
	}
	
	
    private boolean validMove(Person p, int richtung) {
        if (p.getY() == hoehe-1 && richtung == 1) {
            return false;
        } else if (p.getX() == breite-1 && richtung == 2) {
            return false;
        } else if (p.getY() == 0 && richtung == 3) {
            return false;
        } else if (p.getX() == 0 && richtung == 4) {
            return false;
        } else {
            return true;
        }

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
    	double wert = (double) tmp / personen.size();
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
     * @param gitter das zugeh�rige Spielfeld auf dem verteilt werden soll.
     */
    private void personenSetzen(ArrayList<Mensch> menschen, Feld[][] spielfeld) {
        for (Mensch tmp : menschen) {
            int pX = tmp.getX();
            int pY = tmp.getY();
            spielfeld[pX][pY].getPersonen().add(tmp);
            //System.out.println(spielfeld[pX][pY].getPersonen().size());
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
    
    private void meinungChecken(Feld[][] gitter) {
        for (Feld[] feldX : gitter) {
            for (Feld feldY : feldX) {
                if (!feldY.getPersonen().isEmpty()) {
                    feldY.checkMeinung();
                }
            }
        }
    }
}
