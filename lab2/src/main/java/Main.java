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
        int escolha = 0, paymentId = 0, pos, passengerId, cabbieId, vehicleId;
        String paymentMethod, escolhaCadastro, campoCadastro;
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
            System.out.println();
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
                        // TODO: fazer logica para nao pegar mesmo ID de pass/motorista na criacao
                        // Criacao de passageiro ou motorista
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
                        // Atualizacao de campo do passageiro ou motorista
                        System.out.println("---------------------------------------");
                        System.out.println("1 - Passageiro");
                        System.out.println("2 - Motorista");
                        System.out.println("---------------------------------------");
                        System.out.print("Selecione uma opcao: ");
                        escolha = scan.nextInt();
                        System.out.println();
                        switch(escolha){
                            case 1:
                                // Passageiro
                                if(passangers != null){
                                    System.out.println("---------------------------------------");
                                    System.out.println("Escolha o ID do passageiro: ");
                                    for(pos = 0; pos < passangers.size(); pos++){
                                        System.out.println("ID " + pos + ": " + passangers.get(pos).getUserId());
                                    }
                                    passengerId = scan.nextInt();
                                    if(passangers.get(passengerId) != null){
                                        System.out.println("---------------------------------------");
                                        System.out.println("Campos para atualizar");
                                        System.out.println("1 - Nome");
                                        System.out.println("2 - E-mail");
                                        System.out.println("3 - Telefone");
                                        System.out.println("---------------------------------------");
                                        System.out.print("Selecione uma opcao: ");
                                        escolhaCadastro = scan.next();
                                        System.out.println();
                                        System.out.println("---------------------------------------");
                                        System.out.println("Digite o novo valor do campo:");
                                        campoCadastro = scan.next();

                                        passangers.get(passengerId).update(escolhaCadastro, campoCadastro);
                                    } else {
                                        System.out.println("ID nao corresponde a nenhum passageiro");
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("Adicione um passageiro");
                                    System.out.println();
                                }
                            break;
                            case 2:
                                // Motorista
                                if(cabbies != null){
                                    System.out.println("---------------------------------------");
                                    System.out.println("Escolha o ID do passageiro: ");
                                    for(pos = 0; pos < cabbies.size(); pos++){
                                        System.out.println("ID " + pos + ": " + cabbies.get(pos).getCabbieId());
                                    }
                                    cabbieId = scan.nextInt();
                                    if(cabbies.get(cabbieId) != null){
                                        System.out.println("---------------------------------------");
                                        System.out.println("Campos para atualizar");
                                        System.out.println("1 - Nome");
                                        System.out.println("2 - E-mail");
                                        System.out.println("3 - Telefone");
                                        System.out.println("---------------------------------------");
                                        System.out.print("Selecione uma opcao: ");
                                        escolhaCadastro = scan.next();
                                        System.out.println();
                                        System.out.println("---------------------------------------");
                                        System.out.println("Digite o novo valor do campo:");
                                        campoCadastro = scan.next();
                                        cabbies.get(cabbieId).update(escolhaCadastro, campoCadastro);
                                    } else {
                                        System.out.println("ID nao corresponde a nenhum motorista");
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("Adicione um motorista");
                                    System.out.println();
                                }
                            break;
                        }
                        break;
                    }
                break;
                case 2:
                    /*      --> criacao de um veiculo com infos necessarias
                    *       --> atualizacao de algum campo
                    */
                    System.out.println("---------------------------------------");
                    System.out.println("1 - Criar um veiculo");
                    System.out.println("2 - Atualizar campo de veiculo");
                    System.out.println("---------------------------------------");
                    System.out.print("Selecione uma opcao: ");
                    escolha = scan.nextInt();
                    System.out.println();
                    switch(escolha){
                        case 1:
                            if(cabbies != null){
                                System.out.println("---------------------------------------");
                                System.out.print("Selecione o Motorista que ira dirigir o veiculo: ");
                                for(pos = 0; pos < cabbies.size(); pos++){
                                    System.out.println("ID " + pos + ": " + cabbies.get(pos).getCabbieId());
                                }
                                System.out.println("---------------------------------------");
                                System.out.print("Selecione uma opcao: ");
                                cabbieId = scan.nextInt();
                                Vehicle vehicle = new Vehicle(cabbieId);
                                vehicles.add(vehicle);
                                System.out.println();
                            } else {
                                System.out.println("Adicione um motorista");
                                System.out.println();
                            }
                        break;
                        case 2:
                            if(vehicles != null){
                                System.out.println("---------------------------------------");
                                System.out.print("Selecione o ID do Veiculo: ");
                                for(pos = 0; pos < vehicles.size(); pos++)
                                    System.out.println("ID " + pos + ": " + vehicles.get(pos).getVehicleId());
                                System.out.println("---------------------------------------");
                                System.out.print("Selecione uma opcao: ");
                                vehicleId = scan.nextInt();
                                if(vehicles.get(vehicleId) != null){
                                    System.out.println("---------------------------------------");
                                    System.out.println("Campos para atualizar");
                                    System.out.println("1 - Modelo");
                                    System.out.println("2 - Ano");
                                    System.out.println("3 - Numero de registro");
                                    System.out.println("4 - ID motorista relacionado");
                                    System.out.println("---------------------------------------");
                                    System.out.print("Selecione uma opcao: ");
                                    escolhaCadastro = scan.next();
                                    if(escolhaCadastro == "4"){
                                        System.out.println("---------------------------------------");
                                        System.out.print("Selecione o Motorista que ira dirigir o veiculo: ");
                                        for(pos = 0; pos < cabbies.size(); pos++){
                                            // TODO: fazer logica para nao pegar mesmo ID de motorista
                                            System.out.println("ID " + pos + ": " + cabbies.get(pos).getCabbieId());
                                        }
                                        System.out.println("---------------------------------------");
                                        System.out.println();
                                    }
                                    System.out.println("Digite o novo valor do campo:");
                                    campoCadastro = scan.next();
                                    vehicles.get(1).update(escolhaCadastro, campoCadastro);
                                } else {
                                    System.out.println("ID nao corresponde a nenhum veiculo");
                                    System.out.println();
                                }
                        } else {
                            System.out.println("Adicione um veiculo");
                            System.out.println();
                        }
                        break;
                    }
                break;
                case 3:
                    /*      --> criacao de um taxista com infos necessarias
                    *       --> atualizacao de algum campo
                    */
                    System.out.println("1 - Criar um taxista");
                    System.out.println("2 - Atualizar campo do taxista");
                    System.out.print("Selecione uma opcao: ");
                    escolha = scan.nextInt();
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
                            --> Adicionar rating ao cabbie
                    */
                break;
            }
        }
        scan.close();
    }
}