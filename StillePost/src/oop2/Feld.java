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
	
	   public boolean inGitter(int breite, int hoehe){
	        return this.x < breite  && this.x >= 0 && this.y < hoehe  && this.y >= 0;
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
    
    public void addPersonen(Mensch person) {
    	personen.add(person);
    }
    public int checkMeinung() {
        int count1 = 0;
        int count2 = 0;
        
        for(Mensch m : personen) {
        	if(m.getMeinung()==1) {
        		count1++;
        		
        	} else if (m.getMeinung() == 2) {
        		count2++;
        	}
        }


        if (count1 > count2) {
            for (Mensch m : personen) {
                m.setMeinung(1);
            }
            
            return 1;
            
        } else if (count1 < count2) {
            for (Mensch m : personen) {
                m.setMeinung(2);
            }
            
            return 2;
            
        } else {
            for (Mensch m : personen) {
                m.setMeinung(0);
            }
            
            return 0;
        }
    }
}
