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
}
