package oop2;

import java.util.Random;

public class Mensch {
	//Attribute
	private String name;
	private int meinung;
	private int x,y;
	
	
	public Mensch(int x, int y) {
		this.meinung = 0;
		this.x = x;
		this.y = y;
						
	}
	/**
	 * 
	 * @param name
	 * @param meinung Meinungen: 0 = unentschlossen, 1 = heiraten, 2 = heiraten nicht
	 * @param x
	 * @param y
	 */
	public Mensch(String name, int meinung, int x, int y) {
		this.name = name;
		this.meinung = meinung;
		this.x = x;
		this.y = y;
	}
	
    public int getMeinung() {
        return meinung;
    }
    
    public void setMeinung(int meinung) {
   
            this.meinung = meinung;
            //return meinung;
    }
 
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    /**
     * Bewegt den Spieler, indem seine Koordinaten verändert werden.
     * @param richtung 1 hoch, 2 rechts, 3 unten, 4 links, 5 bleibt stehen
     * @return
     */
    public int move(int richtung) {
        if (richtung == 1) {
            this.setXY(this.x, this.y - 1);
            return 1;
        } else if (richtung == 2) {
            this.setXY(this.x + 1, this.y);
            return 2;
        } else if (richtung == 3) {
            this.setXY(this.x, this.y + 1);
            return 3;
        } else if (richtung == 4){
            this.setXY(this.x - 1, this.y);
            return 4;
        } else if (richtung == 5){
            this.setXY(this.x, this.y);
            return 5;
        } else {
            return 0;
        }
    }
}
