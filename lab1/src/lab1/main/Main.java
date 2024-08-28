package lab1.main;
import java.util.Scanner;

import lab1.classes.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name, destino, escolha = null;
		Scanner scan = new Scanner(System.in);
		Taxi taxi = new Taxi();
		
		System.out.println("Qual eh o nome do(a) passageiro(a)?");
		name = scan.nextLine();
		while(escolha != "Nao") {
			System.out.println("Gostaria de chamar um taxi? (Sim | Nao)");
			escolha = scan.nextLine();
			if(escolha == "Sim" && !taxi.isHailed()) {
				
			} else if(taxi.isHailed()) {
				System.out.println("O taxi ja esta cheio");
			}
		}
	}

}
