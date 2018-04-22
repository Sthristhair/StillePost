package oop2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
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
