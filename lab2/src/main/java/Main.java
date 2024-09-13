/*
 * Nome: Gabriel Henrique Pereira Lopes da Silva
 * RA: 200342
 * Nome: Joao Guilherme Ferreira Pedra
 * RA: 248349
 */
package main.java;

import java.util.ArrayList;
import java.util.Scanner;

import classes.taxi.Cabbie;
import classes.taxi.Passenger;
import classes.taxi.Payment;
import classes.taxi.Ride;
import classes.taxi.Vehicle;
import classes.taxi.utils.CabbieInfoGenerator;
import classes.taxi.utils.PassengerInfoGenerator;

public class Main {
    public static void main(String[] args) {
        //Auxiliares
        int escolha = 0, paymentId = 0;
        String paymentMethod;
        Scanner scan = new Scanner(System.in);
        Ride ride = new Ride();

        //Geradores
        PassengerInfoGenerator passRand = new PassengerInfoGenerator();
        CabbieInfoGenerator cabbRand = new CabbieInfoGenerator();
        
        //Arrays
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        ArrayList<Passenger> passangers = new ArrayList<Passenger>();
        ArrayList<Cabbie> cabbies = new ArrayList<Cabbie>();
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
            System.out.print("Selecione uma opcao: ");
            escolha = scan.nextInt();
        
            switch (escolha) {
                case 1:
                    /*      --> criacao de um passageiro com infos necessarias
                    *       --> atualizacao de algum campo
                    */
                    
                    System.out.println("---------------------------------------");
                    System.out.println("1 - Criar um passageiro ou motorista");
                    System.out.println("2 - Atualizar campo de passageiro");
                    System.out.println("---------------------------------------");
                    try {
                        System.out.print("Selecione uma opcao: ");
                        escolha = scan.nextInt();
                    } catch (Exception exc) {
                        System.out.println("Inicie o programa novamente");
                        break;
                    }
                    switch(escolha){
                        case 1:
                        // Criacao de passageiro ou motorista
                        //TODO: fazer print da opcao entre passageiro ou motorista
                        
                        System.out.println("---------------------------------------");
                        System.out.println("1 - Passageiro");
                        System.out.println("2 - Motorista");
                        System.out.println("---------------------------------------");
                        System.out.print("Selecione uma opcao: ");
                        escolha = scan.nextInt();
                        switch(escolha){
                            case 1:
                                // Passageiro
                                Passenger passenger = new Passenger(passRand.getPassengerId(), passRand.getName(), passRand.getEmail(), passRand.getEmail());
                                passangers.add(passenger);
                                System.out.println("Criado o motorista: " + passenger.toString());
                            break;
                            case 2:
                                // Motorista
                                Cabbie cabbie = new Cabbie(cabbRand.getCabbieId(), cabbRand.getName(), cabbRand.getEmail(), cabbRand.getPhone(), cabbRand.getRate(), cabbRand.getLicenseNumber());
                                cabbies.add(cabbie);
                                System.out.println("Criado o motorista: " + cabbie.toString());
                            break;
                        }
                        break;
                        case 2:
                        // Atualizacao de campo do passageiro
                        // TODO: verificar qual id pegar
                        // TODO: fazer escolha se eh passageiro ou motorista
                        try {
                            System.out.print("Selecione uma opcao: ");
                            escolha = scan.nextInt();
                        } catch (Exception exc) {
                            System.out.println("Inicie o programa novamente");
                            break;
                        }
                        switch(escolha){
                            case 1:
                                // Passageiro
                                //TODO: fazer update e prints
                            break;
                            case 2:
                                // Motorista
                                //TODO: fazer update e prints
                            break;
                        }
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
                    //TODO: verificar como pegar um id
                    switch(escolha){
                        case 1:
                            Vehicle vehicle = new Vehicle(cabbies.get());
                            vehicles.add(vehicle);
                        break;
                        case 2:
                            // TODO: colocar os campos que serao atualizados
                            vehicles.get(1).update(null, null);
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
                    // TODO: como pegar o rideId;
                    paymentMethod = scan.next();
                    Payment payment = new Payment(paymentId, 1, 1, paymentMethod);
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