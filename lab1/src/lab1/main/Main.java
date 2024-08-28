/*
 * Nome:
 * RA:
 * Nome: Joao Guilherme Ferreira Pedra
 * RA: 248349
 * 
 */


package lab1.main;
import java.util.ArrayList;
import java.util.Scanner;

import lab1.classes.*;

public class Main {
	public static void main() {
		String name, destino;
		int escolha = 0, posPassageiro = 0, posTaxi = 0, posicao = 0, isLivre = 0;
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Passenger> passageiros = new ArrayList<Passenger>();
		ArrayList<Taxi> taxis = new ArrayList<Taxi>();
		
		while(escolha != (-1)) {	
			System.out.println("------------------MENU-----------------");
			System.out.println("Escolha entre uma das opcoes");
			System.out.println("1 - Adicionar novo passageiro");
			System.out.println("2 - Selecionar passageiro");
			System.out.println("3 - Mudar destino");
			System.out.println("4 - Adicionar novo taxi");
			System.out.println("5 - Chamar um taxi");
			System.out.println("6 - Visualizar informacoes");
			System.out.println("7 - Verificar se passageiro ja chegou ao destino");
			System.out.println("-1 - Sair do programa");
			escolha = scan.nextInt();
			
			switch(escolha) {
				case 1:
					System.out.println("Qual eh o nome do(a) passageiro(a)?");
					name = scan.next();
					Passenger passageiro = new Passenger(name);
					
					System.out.println("Qual eh o destino do(a) passageiro(a) " + passageiro.getName() + "?");
					destino = scan.next();
					passageiro.setDestination(destino);
					
					System.out.println(passageiro.getName() + " define um destino (" + passageiro.getDestination() + ")");
					passageiros.add(passageiro);
					System.out.println();
					break;
				case 2:
					System.out.println("Selecione um passageiro: ");
					if(passageiros.size() > 0) {
						for(posPassageiro = 0; posPassageiro < passageiros.size(); posPassageiro++) {
							System.out.println(posPassageiro + " " + passageiros.get(posPassageiro).getName());
						}
						posPassageiro = scan.nextInt();
						
						System.out.println("Selecionado o passageiro de nome: " + passageiros.get(posPassageiro).getName());
					} else {
						System.out.println("Adicione um passageiro");
					}
					System.out.println();
					break;
				case 3:
					if(passageiros.size() > 0) {
						System.out.println("Adicione um destino novo: ");
						destino = scan.next();
						passageiros.get(posPassageiro).setDestination(destino);
					} else {
						System.out.println("Adicione um passageiro");
					}
					break;
				case 4:
					System.out.println("Qual eh o nome do taxista?");
					name = scan.next();
					Cabbie taxista = new Cabbie(name);
					Taxi taxi = new Taxi(taxista);
					taxis.add(taxi);
					System.out.println("Taxi adicionado");
					System.out.println();
					break;
				case 5:
					if(passageiros.size() > 0) {
						if(taxis.size() > 0) {
							if(!taxis.get(posTaxi).isHailed()) {
								isLivre = 0;
								for(posTaxi = 0; posTaxi < taxis.size(); posTaxi++) {
									if(!taxis.get(posTaxi).isHailed()) {
										passageiros.get(posPassageiro).performRole();
										taxis.get(posTaxi).getTaxista().performRole();
										
										taxis.get(posTaxi).setPassageiro(passageiros.get(posPassageiro));
		
										System.out.println(passageiros.get(posPassageiro).getName() + " entra no taxi");
										
										System.out.println("Taxista " + taxis.get(posTaxi).getTaxista().getName() + " esta dirigindo ate o destino (" + taxis.get(posTaxi).getPassageiro().getDestination() + ")");
										isLivre = 1;
										System.out.println("teset etstest");
										break;
									}
								}
								if(isLivre == 0) {
									System.out.println("Todos os taxis estao em uso. Tente outra hora ou adicione um novo.");
								}
							} else {
								System.out.println(taxis.get(posTaxi).getPassageiro().getName() + " ja esta em um taxi");
							}
						} else {
							System.out.println("Adicione um taxi");
						}
					} else {
						System.out.println("Adicione um passageiro");
					}
					System.out.println();
					break;
				case 6:
					if(passageiros.size() != 0) {
						System.out.println("O passageiro " + passageiros.get(posPassageiro).getName());
						for(posicao = 0; posicao < taxis.size(); posicao++) {
							if(taxis.get(posicao).getPassageiro() == passageiros.get(posPassageiro)) {
								System.out.println("Esta no taxi " + posicao);
							}
						}
						posicao++;
						if(posicao == taxis.size()) {
							System.out.println("Passageiro nao esta em um taxi");
						}
					} else {
						System.out.println("Adicione passageiros");
					}
					System.out.println();
					break;
				case 7:
					if(taxis.size() > 0) {
						if(taxis.get(posTaxi).chegouDestino()) {
							System.out.println(taxis.get(posTaxi).getPassageiro().getName() + " chegou ao destino");
							System.out.println(taxis.get(posTaxi).getPassageiro().getName() + " paga o taxista (sem gorjeta)");
							taxis.get(posTaxi).getTaxista().setMoney(100);
							System.out.println(taxis.get(posTaxi).getPassageiro().getName() + " sai do taxi " + posTaxi);
							taxis.get(posTaxi).chegouDestino();
						} else {
							System.out.println("Horario do destino de " + taxis.get(posTaxi).getPassageiro().getName() + " passou em 1 hora.");
							taxis.get(posTaxi).passarHorario();
							System.out.println("Taxi ainda esta dirigindo");
							System.out.println();
						}
					} else {
						System.out.println("Adicione um passageiro ou taxi");
					}
					System.out.println();
					break;
			}
		}
		
		System.out.println("-----------------------------------");
		System.out.println("Final do programa: ");
		for(posicao = 0; posicao < taxis.size(); posicao++) {
			taxis.get(posicao).getPassageiro().toString();
			taxis.get(posicao).getTaxista().toString();
		}
		taxis.toString();
		scan.close();
	}

}
