package oop2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		Gitter gitter = new Gitter(5,5,100,10);
		
		Eingabe e1 = new Eingabe();
		while(true) {
			e1.eingabe();
		
		
        System.out.print("Wollen Sie weiterspielen (j): ");
        if (scan.next().equals("j")) {
            break;
        	}

		}
	}
}
