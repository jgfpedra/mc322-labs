/*
 * Nome: Gabriel Henrique Pereira Lopes da Silva
 * RA: 200342
 * Nome: Joao Guilherme Ferreira Pedra
 * RA: 248349
 */
package main.java;

import java.util.ArrayList;
import java.util.Random;
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
        int escolha = 0, paymentId = 0, pos, passengerId, cabbieId, vehicleId = 0, rideId = 0;
        String paymentMethod, escolhaCadastro, campoCadastro, partida, destino;
        boolean validPaymentMethod = false;
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        Ride ride = new Ride();
        Payment payment = new Payment();

        //Geradores
        PassengerInfoGenerator passRand = new PassengerInfoGenerator();
        CabbieInfoGenerator cabbRand = new CabbieInfoGenerator();
        
        //ArrayLists
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        ArrayList<Cabbie> cabbies = new ArrayList<Cabbie>();
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        // TODO: colocar documentacao
        while (escolha != 7) {
            System.out.println("------------------MENU-----------------");
            System.out.println("Escolha entre uma das opcoes");
            System.out.println("1 - Cadastrar passageiro");
            System.out.println("2 - Cadastrar taxista");
            System.out.println("3 - Cadastrar veiculo");
            System.out.println("4 - Criacao de uma corrida");
            System.out.println("5 - Selecao de pagamento");
            System.out.println("6 - Finalizar corrida");
            System.out.println("7 - Finalizar programa");
            System.out.println("---------------------------------------");
            System.out.print("Selecione uma opcao: ");
            escolha = scan.nextInt();
            System.out.println();
            switch (escolha) {
                case 1:
                    System.out.println("---------------------------------------");
                    System.out.println("1 - Criar um passageiro");
                    System.out.println("2 - Atualizar campo de passageiro");
                    System.out.println("---------------------------------------");
                    System.out.print("Selecione uma opcao: ");
                    escolha = scan.nextInt();
                    System.out.println();
                    switch(escolha){
                        case 1:
                            // Criacao de passageiro
                            // Passageiro
                            // TODO: melhorar logica
                            // Logica para gerar outro ID caso pegue o mesmo de outro ja criado.
                            passengerId = passRand.getPassengerId();
                            if(passengers != null){
                                for(Passenger passengerIterator : passengers){
                                    if(passengerIterator.getUserId() == passengerId){
                                        passRand.generateRandomInfo();
                                    }
                                }
                            }
                            Passenger passenger = new Passenger(passRand.getPassengerId(), passRand.getName(), passRand.getEmail(), passRand.getEmail());
                            passengers.add(passenger);
                            System.out.println("---------------------------------------");
                            System.out.println("Pessoa passageira " + passenger.getUserId() + " (" + passenger.getName() + ") criada com sucesso");
                            System.out.println("---------------------------------------");
                            System.out.println();
                            break;
                        case 2:
                            if(passengers != null){
                                pos = 0;
                                System.out.println("---------------------------------------");
                                System.out.println("Escolha o ID do passageiro: ");
                                for(Passenger passengerIterator : passengers){
                                    System.out.println(pos + ": ID pessoa passageiro - " + passengerIterator.getUserId());
                                    pos++;
                                }
                                System.out.println("---------------------------------------");
                                System.out.println();
                                System.out.println("Escolha da posicao do ID: ");
                                pos = scan.nextInt();
                                System.out.println();
                                if(passengers.get(pos) != null){
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
                                    System.out.println("Digite o novo valor do campo: ");
                                    campoCadastro = scan.next();
                                    System.out.println();
                                    passengers.get(pos).update(escolhaCadastro, campoCadastro);
                                    System.out.println("---------------------------------------");
                                    System.out.println("Campo \"" + escolhaCadastro + "\" atualizado para pessoa passageira " + passengers.get(pos).getUserId());
                                    System.out.println("---------------------------------------");
                                    System.out.println();
                                } else {
                                    System.out.println("---------------------------------------");
                                    System.out.println("ID nao corresponde a nenhum passageiro");
                                    System.out.println("---------------------------------------");
                                    System.out.println();
                                }
                            } else {
                                System.out.println("---------------------------------------");
                                System.out.println("Adicione um passageiro");
                                System.out.println("---------------------------------------");
                                System.out.println();
                            }
                            break;
                    }
                    break;
                    case 2:
                    // Taxista
                    System.out.println("---------------------------------------");
                    System.out.println("1 - Criar um taxista");
                    System.out.println("2 - Atualizar campo de taxista");
                    System.out.println("---------------------------------------");
                    System.out.print("Selecione uma opcao: ");
                    escolha = scan.nextInt();
                    System.out.println();
                    switch(escolha){
                        case 1:
                            // TODO: melhorar logica
                            // Logica para gerar outro ID caso pegue o mesmo de outro ja criado.
                            cabbieId = cabbRand.getCabbieId();
                            if(cabbies != null){
                                for(Cabbie cabbie : cabbies){
                                    if(cabbie.getCabbieId() == cabbieId){
                                        cabbRand.generateRandomInfo();
                                    }
                                }
                            }
                            Cabbie cabbie = new Cabbie(cabbRand.getCabbieId(), cabbRand.getName(), cabbRand.getEmail(), cabbRand.getPhone(), cabbRand.getRate(), cabbRand.getLicenseNumber());
                            cabbies.add(cabbie);
                            System.out.println("---------------------------------------");
                            System.out.println("Pessoa motorista " + cabbie.getCabbieId() + " (" + cabbie.getName() + ") criada com sucesso");
                            System.out.println("---------------------------------------");
                            System.out.println();
                            break;
                        case 2:
                            if(cabbies != null){
                                pos = 0;
                                System.out.println("---------------------------------------");
                                System.out.println("Escolha o ID do motorista: ");
                                for(Cabbie cabbieIterator : cabbies){
                                    System.out.println(pos + " ID pessoa motorista - " + cabbieIterator.getCabbieId());
                                }
                                System.out.println("---------------------------------------");
                                System.out.println("Escolha da posicao do ID: ");
                                pos = scan.nextInt();
                                System.out.println();
                                if(cabbies.get(pos) != null){
                                    System.out.println("---------------------------------------");
                                    System.out.println("Campos para atualizar");
                                    System.out.println("1 - Nome");
                                    System.out.println("2 - E-mail");
                                    System.out.println("3 - Telefone");
                                    System.out.println("4 - Rating");
                                    System.out.println("---------------------------------------");
                                    System.out.print("Selecione uma opcao: ");
                                    escolhaCadastro = scan.next();
                                    System.out.println();
                                    System.out.println("---------------------------------------");
                                    System.out.println("Digite o novo valor do campo:");
                                    campoCadastro = scan.next();
                                    cabbies.get(pos).update(escolhaCadastro, campoCadastro);
                                    System.out.println();
                                    System.out.println("---------------------------------------");
                                    System.out.println("Campo \"" + escolhaCadastro + "\" atualizado para pessoa motorista" + cabbies.get(pos).getCabbieId());
                                    System.out.println("---------------------------------------");
                                    System.out.println();
                                } else {
                                    System.out.println("---------------------------------------");
                                    System.out.println("ID nao corresponde a nenhum motorista");
                                    System.out.println("---------------------------------------");
                                    System.out.println();
                                }
                            } else {
                                System.out.println("---------------------------------------");
                                System.out.println("Adicione um motorista");
                                System.out.println("---------------------------------------");
                                System.out.println();
                            }
                            break;
                    }
                    break;
                case 3:
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
                                for(Cabbie cabbie : cabbies){
                                    System.out.println("ID motorista: " + cabbie.getCabbieId() + "");
                                }
                                System.out.println("---------------------------------------");
                                System.out.print("Selecione uma opcao de ID: ");
                                cabbieId = scan.nextInt();
                                Vehicle vehicle = new Vehicle(cabbieId);
                                vehicles.add(vehicle);
                                System.out.println();
                                System.out.println("---------------------------------------");
                                System.out.println("Veiculo " + vehicle.getVehicleId() + " (" + vehicle.getRegistrationNumber() + ") criado com sucesso");
                                System.out.println("---------------------------------------");
                                System.out.println();
                            } else {
                                System.out.println("---------------------------------------");
                                System.out.println("Adicione um motorista");
                                System.out.println("---------------------------------------");
                                System.out.println();
                            }
                        break;
                        case 2:
                            if(vehicles != null){
                                pos = 0;
                                System.out.println("---------------------------------------");
                                System.out.print("Selecione o ID do Veiculo: ");
                                for(Vehicle vehicleIterator : vehicles)
                                    System.out.println(pos + "ID do veiculo - "  + vehicleIterator.getVehicleId());
                                System.out.println("---------------------------------------");
                                System.out.print("Escolha uma posicao de ID: ");
                                pos = scan.nextInt();
                                System.out.println();
                                if(vehicles.get(pos) != null){
                                    System.out.println("---------------------------------------");
                                    System.out.println("Campos para atualizar");
                                    System.out.println("1 - Modelo");
                                    System.out.println("2 - Ano");
                                    System.out.println("3 - Numero de registro");
                                    System.out.println("4 - ID motorista relacionado");
                                    System.out.println("---------------------------------------");
                                    System.out.print("Selecione uma opcao: ");
                                    escolhaCadastro = scan.next();
                                    // TODO: fazer logica para nao pegar mesmo ID de motorista
                                    if(escolhaCadastro == "4"){
                                        System.out.println("---------------------------------------");
                                        System.out.print("Selecione a posicao do Motorista que ira dirigir o veiculo: ");
                                        for(pos = 0; pos < cabbies.size(); pos++){
                                            System.out.println("ID " + pos + ": " + cabbies.get(pos).getCabbieId());
                                        }
                                        System.out.println("---------------------------------------");
                                        System.out.println();
                                    }
                                    System.out.println("Digite o novo valor do campo:");
                                    campoCadastro = scan.next();
                                    vehicles.get(pos).update(escolhaCadastro, campoCadastro);
                                    System.out.println();
                                    System.out.println("---------------------------------------");
                                    System.out.println("Campo \"" + escolhaCadastro + "\" atualizado para veiculo" + vehicles.get(pos).getVehicleId());
                                    System.out.println("---------------------------------------");
                                    System.out.println();
                                } else {
                                    System.out.println("---------------------------------------");
                                    System.out.println("ID nao corresponde a nenhum veiculo");
                                    System.out.println("---------------------------------------");
                                    System.out.println();
                                }
                        } else {
                            System.out.println("---------------------------------------");
                            System.out.println("Adicione um veiculo");
                            System.out.println("---------------------------------------");
                            System.out.println();
                        }
                        break;
                    }
                break;
                case 4:
                    System.out.println("---------------------------------------");
                    System.out.println("1 - Requisitar uma corrida");
                    System.out.println("2 - Calcular valor corrida");
                    System.out.println("---------------------------------------");
                    System.out.print("Selecione uma opcao: ");
                    escolha = scan.nextInt();
                    System.out.println();
                    switch(escolha){
                        case 1:
                            if(ride.getStatus() == "Livre"){
                                if(passengers != null){
                                    pos = rand.nextInt(passengers.size());
                                    passengerId = pos;
                                    if(cabbies != null){
                                        pos = rand.nextInt(cabbies.size());
                                        cabbieId = pos;
                                        if(vehicles != null){
                                            for(Vehicle vehicle : vehicles){
                                                if(vehicle.getCabbieId() == cabbieId){
                                                    vehicleId = vehicle.getVehicleId();
                                                }
                                            }
                                            System.out.println("---------------------------------------");
                                            System.out.println("Defina o local de partida: ");
                                            partida = scan.next();
                                            System.out.println("---------------------------------------");
                                            System.out.println("Defina o local de destino: ");
                                            destino = scan.next();
                                            System.out.println("---------------------------------------");
                                            ride.requestRide(rideId, passengerId, cabbieId, vehicleId, partida, destino);
                                            System.out.println();
                                            System.out.println("---------------------------------------");
                                            System.out.println("Corrida chamada por pessoa passageira " + passengerId + " de " + partida + " para " + destino);
                                            System.out.println("Corrida atendida por pessoa motorista " + cabbieId);
                                            System.out.println("---------------------------------------");
                                            System.out.println();
                                        } else {
                                            System.out.println("---------------------------------------");
                                            System.out.println("Crie um veiculo");
                                            System.out.println("---------------------------------------");
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("---------------------------------------");
                                        System.out.println("Crie um taxista");
                                        System.out.println("---------------------------------------");
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("---------------------------------------");
                                    System.out.println("Crie um passageiro");
                                    System.out.println("---------------------------------------");
                                    System.out.println();
                                }
                            } else {
                                System.out.println("---------------------------------------");
                                System.out.println("Corrida esta ocupada por outro passageiro!");
                                System.out.println("---------------------------------------");
                                System.out.println();
                            }
                        break;
                        case 2:
                            System.out.println("---------------------------------------");
                            System.out.println("Valor da corrida definido: R$ " + ride.getFare());
                            System.out.println("---------------------------------------");
                            System.out.println();
                            break;
                    }
                break;
                case 5:
                    while(!validPaymentMethod){
                        System.out.println("---------------------------------------");
                        System.out.println("Defina a forma de pagamento: ");
                        paymentMethod = scan.next();
                        System.out.println();
                        System.out.println("---------------------------------------");
                        System.out.println("Forma de pagamento: " + paymentMethod);
                        System.out.println("---------------------------------------");
                        System.out.println();
                        try{
                            validPaymentMethod = payment.definePagamento(paymentId, rideId, ride.getFare(), paymentMethod);
                            System.out.println("---------------------------------------");
                            System.out.println("Forma de pagamento aceita!");
                            System.out.println("---------------------------------------");
                            System.out.println();
                        } catch (IllegalArgumentException e){
                            System.out.println("---------------------------------------");
                            System.out.println(e.getMessage());
                            System.out.println("---------------------------------------");
                            System.out.println();
                        }
                    }
                break;
                case 6:
                    ride.completeRide();
                    System.out.println("---------------------------------------");
                    System.out.println("Corrida finalizada.");
                    System.out.println("---------------------------------------");
                    System.out.println();
                break;
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("Relatorio final dos dados: ");
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Passageiros criados: ");
        passengers.toString();
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Taxistas criados: ");
        cabbies.toString();
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Veiculos criados: ");
        vehicles.toString();
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Estado atual da corrida: ");
        ride.toString();
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Metodo atual de pagamento da corrida: ");
        payment.toString();
        System.out.println("---------------------------------------");
        System.out.println();
        scan.close();
    }
}