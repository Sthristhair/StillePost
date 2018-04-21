package oop2;

import java.util.ArrayList;

public class Feld {
	//Attribute
	private int x,y;
	private ArrayList<Mensch> personen;
	
	public Feld(int x, int y) {
		this.x = x;
		this.y =y;
		this.personen = new ArrayList<>();
	}
	
	
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public ArrayList<Mensch> getPersonen() {
        return personen;
    }
    
}
