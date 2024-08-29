/*
 * Nome:
 * RA:
 * Nome: Joao Guilherme Ferreira Pedra
 * RA: 248349
 * 
 */


package lab1.main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lab1.classes.*;

public class Main {
	public static void main(String[] args) throws IOException {
		String name, destino;
		int escolha = 0, posPassageiro = 0, posTaxi = 0, posicao = 0, isLivre = 0;
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Passenger> passageiros = new ArrayList<Passenger>();
		ArrayList<Taxi> taxis = new ArrayList<Taxi>();
		
		// Menu com escolhas
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
			if(passageiros.size() != 0) {
				System.out.println("------------------PASSAGEIRO-----------------");
				System.out.println("O passageiro selecionado eh: " + passageiros.get(posPassageiro).getName());
				System.out.println("-----------------------------------");
			}
			System.out.println();
			
			try {
				System.out.print("Selecione uma opcao: ");
				escolha = scan.nextInt();
			} catch(Exception exc) {
				System.out.println("Inicie o programa novamente");
				break;
			}
			
			switch(escolha) {
				case 1:
					// Adicao do passageiro
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
					// Selecao entre passageiros adicionados
					if(passageiros.size() > 0) {
						System.out.println("Selecione um passageiro: ");
						for(posPassageiro = 0; posPassageiro < passageiros.size(); posPassageiro++) {
							System.out.println(posPassageiro + " " + passageiros.get(posPassageiro).getName());
						}
						posPassageiro = scan.nextInt();
						
						if(posPassageiro > passageiros.size()) {
							System.out.println("O sistema nao possui o passageiro selecionado.");
							System.out.println("Inicie o programa novamente");
							break;
						}
						
						System.out.println("Selecionado o passageiro de nome: " + passageiros.get(posPassageiro).getName());
						
						// Nao possui else, pois o usuario somente seleciona o passageiro
						if(taxis.size() > 0) {
							for(posicao = 0; posicao < taxis.size(); posicao++) {
								if(taxis.get(posicao).getPassageiro() == passageiros.get(posPassageiro)) {
									System.out.println("O passageiro esta no taxi: " + taxis.get(posicao).getId());
									isLivre = 1;
									break;
								} else {
									isLivre = 0;
								}
							}
							if(isLivre == 0) {
								System.out.println("O passageiro esta esperando");
							}
						}
					} else {
						System.out.println("Adicione um passageiro");
					}
					System.out.println();
					break;
				case 3:
					// Define um novo destino para o passageiro selecionado
					if(passageiros.size() > 0) {
						System.out.println("Adicione um destino novo: ");
						destino = scan.next();
						passageiros.get(posPassageiro).setDestination(destino);
						System.out.println("O destino do passageiro " + passageiros.get(posPassageiro).getName() + " se tornou " + passageiros.get(posPassageiro).getDestination());
					} else {
						System.out.println("Adicione um passageiro");
					}
					break;
				case 4:
					// Adiciona um taxi ao programa
					System.out.println("Qual eh o nome do taxista?");
					name = scan.next();
					Cabbie taxista = new Cabbie(name);
					Taxi taxi = new Taxi(posTaxi, taxista);
					taxis.add(taxi);
					posTaxi++;
					System.out.println("Taxi adicionado");
					System.out.println();
					break;
				case 5:
					if(passageiros.size() > 0) {
						if(taxis.size() > 0) {
							for(posicao = 0; posicao < taxis.size(); posicao++) {
								if(taxis.get(posicao).getPassageiro() == passageiros.get(posPassageiro)) {
									System.out.println(taxis.get(posicao).getPassageiro().getName() + " ja esta em um taxi");
									isLivre = 1;
									break;
								}
								if(!taxis.get(posicao).isHailed()) {
									passageiros.get(posPassageiro).performRole();
									taxis.get(posicao).getTaxista().performRole();
									
									taxis.get(posicao).setPassageiro(passageiros.get(posPassageiro));
									taxis.get(posicao).setIsHailed(true);
									
									System.out.println(passageiros.get(posPassageiro).getName() + " entra no taxi");
									
									System.out.println("Taxista " + taxis.get(posicao).getTaxista().getName() + " esta dirigindo ate o destino (" + taxis.get(posicao).getPassageiro().getDestination() + ")");
									isLivre = 1;
									break;
								}
							}
							if(isLivre == 0) {
								System.out.println("Todos os taxis estao em uso. Tente outra hora ou adicione um novo.");
							}
							isLivre = 0;
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
						if(taxis.size() != 0) {
							for(posicao = 0; posicao < taxis.size(); posicao++) {
								if(taxis.get(posicao).getPassageiro() == passageiros.get(posPassageiro)) {
									System.out.println("O passageiro " + passageiros.get(posPassageiro).getName() + " esta indo ao destino.");
									System.out.println("E esta no taxi " + posicao);
									isLivre = 1;
								}
							}
							if(isLivre == 0) {
								System.out.println("O passageiro " + passageiros.get(posPassageiro).getName() + " esta esperando");	
							}
							isLivre = 0;
						} else {
							System.out.println("Adicione um taxi e chame um taxi para o passageiro para " + passageiros.get(posPassageiro));
						}
					} else {
						System.out.println("Adicione passageiros");
					}
					System.out.println();
					break;
				case 7:
					if(passageiros.size() != 0) {
						if(taxis.size() != 0) {
							for(posicao = 0; posicao < taxis.size(); posicao++) {
								if(taxis.get(posicao).getPassageiro() == passageiros.get(posPassageiro)) {
									if(taxis.get(posicao).chegouDestino()) {
										System.out.println(taxis.get(posicao).getPassageiro().getName() + " chegou ao destino");
										System.out.println(taxis.get(posicao).getPassageiro().getName() + " paga o taxista (sem gorjeta)");
										System.out.println(taxis.get(posicao).getPassageiro().getName() + " sai do taxi " + posicao);
										taxis.get(posicao).setPassageiro(null);
									} else {
										System.out.println("Horario do destino de " + taxis.get(posicao).getPassageiro().getName() + " passou em 1 hora.");
										System.out.println("Restam " + (5 - taxis.get(posicao).getHoras()) + "h para chegar ao destino");
										taxis.get(posicao).passarHorario();
										System.out.println("Taxi ainda esta dirigindo");
										System.out.println();
									}
								} else {
									System.out.println("Chame um taxi");
								}
							}
						} else {
							System.out.println("Adicione um taxi e o chame");
						}
					} else {
						System.out.println("Adicione um passageiro");
					}
					System.out.println();
					break;
			}
		}
		// Finalizar isso
		System.out.println("-----------------------------------");
		System.out.println("Final do programa: ");
		for(posicao = 0; posicao < taxis.size(); posicao++) {
			taxis.get(posicao).getTaxista().toString();
		}
		for(posicao = 0; posicao < passageiros.size(); posicao++) {
			passageiros.get(posicao).toString();
		}
		taxis.toString();
		scan.close();
	}

}
