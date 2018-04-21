package oop2;

public class Runde {
	
	private int rundenzahl;
	private double prozentMeinung0;
	private double prozentMeinung1;
	private double prozentMeinung2;
	
	public Runde(int rundenzahl, double prozentMeinung0, double prozenzMeinung1, double prozentMeinung2) {
		this.rundenzahl = rundenzahl;
		this.prozentMeinung0 = prozentMeinung0;
		this.prozentMeinung1 = prozenzMeinung1;
		this.prozentMeinung2 = prozentMeinung2;	
	}
	@Override
	public String toString() {
		return rundenzahl + ". Runde: " + prozentMeinung0 + "% sind unentschlossen, " + prozentMeinung1 + "% glauben an die heirat, " + prozentMeinung2 + "% glauben nicht an die Heirat.";
	}
	
}

