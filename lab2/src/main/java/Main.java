/*
 * Nome: Gabriel Henrique Pereira Lopes da Silva
 * RA: 200342
 * Nome: Joao Guilherme Ferreira Pedra
 * RA: 248349
 */
package main.java;

import java.util.ArrayList;
import java.util.Scanner;

import classes.taxi.Payment;
import classes.taxi.Vehicle;

public class Main {
    public static void main(String[] args) {
        int escolha = 0;
        Scanner scan = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        ArrayList<Vehicle> passangers = new ArrayList<Vehicle>();
        ArrayList<Vehicle> taxis = new ArrayList<Vehicle>();
        ArrayList<Payment> payments = new ArrayList<Payment>();

        /*
         * 1 - Cadastro de um novo passageiro
         *      --> criacao de um passageiro com infos necessarias
         *      --> atualizacao de algum campo
         * 2 - Cadastro de um novo veiculo
         *      --> criacao de um novo veiculo
         *      --> atualizacao de infos especificas
         * 3 - Cadastro de um novo taxista
         *      --> criacao
         *      --> atualizacao de infos especificas
         * 4 - Criacao de uma corrida
         *      --> Requisicao de uma corrida
         *      --> calculo do valor
         * 5 - Criacao de pagamento
         *      --> selecao tipo pagamento
         *             ---> credit card, cash ou debit card
         * 6 - Finalizar corrida
         */
        while (escolha != 6) {
            System.out.println("------------------MENU-----------------");
            System.out.println("Escolha entre uma das opcoes");
            System.out.println("1 - Cadastrar passageiro");
            System.out.println("2 - Cadastrar veiculo");
            System.out.println("3 - Cadastrar taxista");
            System.out.println("4 - Criacao de uma corrida");
            System.out.println("5 - Selecao de pagamento");
            System.out.println("6 - Finalizar corrida");
            System.out.println("---------------------------------------");
            try {
                System.out.print("Selecione uma opcao: ");
                escolha = scan.nextInt();
            } catch (Exception exc) {
                System.out.println("Inicie o programa novamente");
                break;
            }
            switch (escolha) {
                case 1:
                    /*      --> criacao de um passageiro com infos necessarias
                    *       --> atualizacao de algum campo
                    */
                    System.out.println("1 - Criar um passageiro");
                    System.out.println("2 - Atualizar campo de passageiro");
                    try {
                        System.out.print("Selecione uma opcao: ");
                        escolha = scan.nextInt();
                    } catch (Exception exc) {
                        System.out.println("Inicie o programa novamente");
                        break;
                    }
                    switch(escolha){
                        case 1:
                        break;
                        case 2:
                        break;
                    }
                break;
                case 2:
                    /*      --> criacao de um veiculo com infos necessarias
                    *       --> atualizacao de algum campo
                    */
                    System.out.println("1 - Criar um veiculo");
                    System.out.println("2 - Atualizar campo de veiculo");
                    try {
                        System.out.print("Selecione uma opcao: ");
                        escolha = scan.nextInt();
                    } catch (Exception exc) {
                        System.out.println("Inicie o programa novamente");
                        break;
                    }
                    switch(escolha){
                        case 1:
                        break;
                        case 2:
                        break;
                    }
                break;
                case 3:
                    /*      --> criacao de um taxista com infos necessarias
                    *       --> atualizacao de algum campo
                    */
                    System.out.println("1 - Criar um taxista");
                    System.out.println("2 - Atualizar campo do taxista");
                    try {
                        System.out.print("Selecione uma opcao: ");
                        escolha = scan.nextInt();
                    } catch (Exception exc) {
                        System.out.println("Inicie o programa novamente");
                        break;
                    }
                    switch(escolha){
                        case 1:
                        break;
                        case 2:
                        break;
                    }
                case 4:
                    /*      --> requisicao de uma corrida
                    *       --> calculo do valor
                    */
                    System.out.println("1 - Requisitar uma corrida");
                    System.out.println("2 - Calcular valor corrida");
                    try {
                        System.out.print("Selecione uma opcao: ");
                        escolha = scan.nextInt();
                    } catch (Exception exc) {
                        System.out.println("Inicie o programa novamente");
                        break;
                    }
                    switch(escolha){
                        case 1:
                        break;
                        case 2:
                        break;
                    }
                break;
                case 5:
                    /*      --> Selecao de metodo de pagamento
                    */
                break;
                case 6:
                    /*      --> finalizar corrida
                    */
                break;
            }
        }
        scan.close();
    }
}