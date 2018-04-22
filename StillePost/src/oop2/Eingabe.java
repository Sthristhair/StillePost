package oop2;

import java.util.Scanner;

public class Eingabe {
	Scanner scan = new Scanner(System.in);
	int breite, hoehe, personen, rundenanzahl;
	
	public Eingabe() {
		
	}
	public void eingabe() {
		
	while(breite<1 || breite > 999){
		try {
		System.out.println("Breite des Spielfeldes: ");
		breite = scan.nextInt();
		breite -= 2;
		} 
		catch(Exception e) {
    		scan = new Scanner (System.in);
    		System.out.println("Pr�fe deine Eingabe! Die Eingabe muss eine Ganzzahl sein!\n");
		}
		
		}
	while(hoehe < 1 || hoehe > 999) {
		try {
        System.out.println("H�he des Spielfeldes: ");
        hoehe = scan.nextInt();
        hoehe -= 2;
		}
		catch(Exception e) {
    		scan = new Scanner (System.in);
    		System.out.println("Pr�fe deine Eingabe! Die Eingabe muss eine Ganzzahl sein!\n");
		}
		
	}
	
	while(personen <1) {
		try {
        System.out.println("Anzahl der Spieler: ");
        personen = scan.nextInt();
        personen -= 2;
		}
		catch(Exception e) {
    		scan = new Scanner (System.in);
    		System.out.println("Pr�fe deine Eingabe! Die Eingabe muss eine Ganzzahl sein!\n");
		}
	}
	
	while(rundenanzahl < 1 || rundenanzahl >999) {
		try {
        System.out.println("Anzahl der Runden: ");
        rundenanzahl = scan.nextInt();
		}
		catch(Exception e) {
    		scan = new Scanner (System.in);
    		System.out.println("Pr�fe deine Eingabe! Die Eingabe muss eine Ganzzahl sein!\n");
		}
	}
	
	Gitter gitter = new Gitter(breite,hoehe, personen, rundenanzahl);
	
	gitter.spielablauf();
	}
}
