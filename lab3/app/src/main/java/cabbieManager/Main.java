/*
 * Nome: Gabriel Henrique Pereira Lopes da Silva
 * RA: 200342
 * Nome: Joao Guilherme Ferreira Pedra
 * RA: 248349
 */
package cabbieManager;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import cabbieManager.utils.CabbieInfoGenerator;
import cabbieManager.utils.PassengerInfoGenerator;

public class Main {
    public static void main(String[] args) {
        System.out.println("teste");
        //Auxiliares
        int escolha = 0, pos, passengerPos, cabbiePos, partida, destino;
        String paymentMethod, escolhaCadastro, campoCadastro, passengerId, cabbieId = null, rideId;
        Location pickUpLocation = null, dropOutLocation = null;
        boolean validPaymentMethod = false, validCabbie, validId = false;

        // Objetos Auxiliares
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        //ArrayLists
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        ArrayList<Cabbie> cabbies = new ArrayList<Cabbie>();
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        
        while (escolha != 5) {
            System.out.println("------------------MENU-----------------");
            System.out.println("Escolha entre uma das opcoes");
            System.out.println("1 - Cadastrar passageiro");
            System.out.println("2 - Cadastrar taxista");
            System.out.println("3 - Cadastrar veiculo");
            System.out.println("4 - Requisitar Corrida");
            System.out.println("5 - Finalizar programa");
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
                            // Criacao de um objeto passageiro e sua adicao no ArrayList
                            // Logica para gerar outro ID caso pegue o mesmo de outro ja criado.
                            PassengerInfoGenerator passRand = new PassengerInfoGenerator();
                            passengerId = passRand.getPassengerId();
                            if(!passengers.isEmpty()){
                                while(validId == false){
                                    validId = true;
                                    for(Passenger passengerIterator : passengers){
                                        if(passengerIterator.getUserId() == passengerId){
                                            validId = false;
                                        }
                                    }
                                    if(validId == false){
                                        passRand.generateRandomInfo();
                                        passengerId = passRand.getPassengerId();
                                    }
                                }
                            }
                            Passenger passenger = new Passenger(passengerId, passRand.getName(), passRand.getEmail(), passRand.getPhone());
                            passengers.add(passenger);
                            System.out.println("---------------------------------------");
                            System.out.println("Pessoa passageira " + passenger.getUserId() + " (" + passenger.getName() + ") criada com sucesso");
                            System.out.println("---------------------------------------");
                            System.out.println();
                            break;
                        case 2:
                            // Atualizacao do campo de um passageiro do ArrayList passengers
                            if(!passengers.isEmpty()){
                                pos = 0;
                                System.out.println("---------------------------------------");
                                System.out.println("Escolha o ID do passageiro: ");
                                System.out.println();
                                for(Passenger passengerIterator : passengers){
                                    System.out.println(pos + ": ID pessoa passageiro - " + passengerIterator.getUserId());
                                    pos++;
                                }
                                System.out.println("---------------------------------------");
                                System.out.println();
                                System.out.println("Escolha da posicao do ID: ");
                                pos = scan.nextInt();
                                scan.nextLine(); // Consome o buffer de nova linha
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
                                    scan.nextLine(); // Consome o buffer de nova linha
                                    System.out.println();
                                    System.out.println("---------------------------------------");
                                    System.out.println("Digite o novo valor do campo: ");
                                    campoCadastro = scan.nextLine();
                                    System.out.println();
                                    passengers.get(pos).update(escolhaCadastro, campoCadastro);
                                    System.out.println(" atualizado para pessoa passageira " + passengers.get(pos).getUserId());
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
                    System.out.println("---------------------------------------");
                    System.out.println("1 - Criar um taxista");
                    System.out.println("2 - Atualizar campo de taxista");
                    System.out.println("---------------------------------------");
                    System.out.print("Selecione uma opcao: ");
                    escolha = scan.nextInt();
                    System.out.println();
                    switch(escolha){
                        case 1:
                            // Criacao de um objeto cabbie e adicao ao ArrayList cabbies
                            // Logica para gerar outro ID caso pegue o mesmo de outro ja criado.
                            
                            CabbieInfoGenerator cabbRand = new CabbieInfoGenerator();
                            cabbieId = cabbRand.getCabbieId();
                            if(!cabbies.isEmpty()){
                                while(validId == false){
                                    validId = true;
                                    for(Cabbie cabbieIterator : cabbies){
                                        if(cabbieIterator.getCabbieId() == cabbieId){
                                            validId = false;
                                        }
                                    }
                                    if(validId == false){
                                        cabbRand.generateRandomInfo();
                                        cabbieId = cabbRand.getCabbieId();
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
                            // Atualizacao do campo de um motorista do ArrayList cabbies
                            if(!cabbies.isEmpty()){
                                pos = 0;
                                System.out.println("---------------------------------------");
                                System.out.println("Escolha o ID do motorista: ");
                                System.out.println();
                                for(Cabbie cabbieIterator : cabbies){
                                    System.out.println(pos + ": ID pessoa motorista - " + cabbieIterator.getCabbieId());
                                    pos++;
                                }
                                System.out.println("---------------------------------------");
                                System.out.println("Escolha a posicao do ID: ");
                                pos = scan.nextInt();
                                scan.nextLine(); // Consome o buffer de nova linha
                                System.out.println();
                                for(Vehicle vehicleIterator: vehicles){
                                    if(vehicleIterator.getCabbieId().equals(cabbies.get(pos).getCabbieId())){
                                        
                                    }
                                }
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
                                    scan.nextLine(); // Consome o buffer de nova linha
                                    System.out.println();
                                    System.out.println("---------------------------------------");
                                    System.out.println("Digite o novo valor do campo:");
                                    campoCadastro = scan.nextLine();
                                    cabbies.get(pos).update(escolhaCadastro, campoCadastro);
                                    System.out.println();
                                    System.out.println("---------------------------------------");
                                    System.out.println(" atualizado para pessoa motorista" + cabbies.get(pos).getCabbieId());
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
                    scan.nextLine(); // Consome o buffer de nova linha
                    System.out.println();
                    switch(escolha){
                        case 1:
                            // Criacao de um objeto vehicle e adicao ao ArrayList vehicles
                            pos = 0;
                            if(!cabbies.isEmpty()){
                                System.out.println("---------------------------------------");
                                System.out.print("Selecione o Motorista que ira dirigir o veiculo: ");
                                System.out.println();
                                validCabbie = true;
                                for(Cabbie cabbieIterator : cabbies){
                                    validCabbie = true;
                                    for(Vehicle vehicleIterator : vehicles){
                                        if(cabbieIterator.getCabbieId().equals(vehicleIterator.getCabbieId())){
                                            validCabbie = false;
                                        }
                                    }
                                    if(validCabbie == true){
                                        System.out.println(pos + " - ID pessoa motorista livre: " + cabbieIterator.getCabbieId());
                                    }
                                }
                                if(validCabbie != false){
                                    try{
                                        validCabbie = false;
                                        System.out.println("---------------------------------------");
                                        System.out.print("Selecione uma posicao das opcoes de ID: ");
                                        pos = scan.nextInt();
                                        System.out.println();
                                        scan.nextLine(); // Consome o buffer de nova linha
                                        for(Cabbie cabbieIterator: cabbies){
                                            if(cabbieIterator.getCabbieId().equals(cabbies.get(pos).getCabbieId())){
                                                validCabbie = true;
                                            }
                                        }
                                        if(validCabbie != false){
                                            Vehicle vehicle = new Vehicle(cabbieId);
                                            vehicles.add(vehicle);
                                            System.out.println();
                                            System.out.println("---------------------------------------");
                                            System.out.println("Veiculo " + vehicle.getVehicleId() + " (" + vehicle.getModel() + " " + vehicle.getYear() + ") criado com sucesso");
                                            System.out.println("---------------------------------------");
                                            System.out.println();
                                        } else {
                                            System.out.println("---------------------------------------");
                                            System.out.println("Selecione um ID de motorista valido");
                                            System.out.println("---------------------------------------");
                                            System.out.println();
                                        }
                                    } catch (IndexOutOfBoundsException e){
                                        System.out.println("---------------------------------------");
                                        System.out.println("Digite uma opcao de posicao valida");
                                        System.out.println("---------------------------------------");
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("---------------------------------------");
                                    System.out.println("Todos os motoristas ja estao ligados a um veiculo");
                                    System.out.println("Adicione mais motoristas");
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
                        case 2:
                            // Atualizacao do campo de um veiculo do ArrayList vehicles
                            if(!vehicles.isEmpty()){
                                pos = 0;
                                System.out.println("---------------------------------------");
                                System.out.print("Selecione o ID do Veiculo: ");
                                System.out.println();
                                for(Vehicle vehicleIterator : vehicles){
                                    System.out.println(pos + ": ID do veiculo - "  + vehicleIterator.getVehicleId());
                                    pos++;
                                }
                                System.out.println("---------------------------------------");
                                System.out.print("Escolha uma posicao de ID: ");
                                pos = scan.nextInt();
                                scan.nextLine(); // Consome o buffer de nova linha
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
                                    scan.nextLine(); // Consome o buffer de nova linha
                                    System.out.println();
                                    if(escolhaCadastro == "4"){
                                        System.out.println("---------------------------------------");
                                        System.out.print("Selecione o ID do novo Motorista que ira dirigir o veiculo");
                                        for(Cabbie cabbieIterator : cabbies){
                                            validCabbie = true;
                                            for(Vehicle vehicleIterator : vehicles){
                                                if(cabbieIterator.getCabbieId() == vehicleIterator.getCabbieId()){
                                                    validCabbie = false;
                                                }
                                            }
                                            if(validCabbie == true){
                                                System.out.println("ID pessoa motorista livre: " + cabbieIterator.getCabbieId());
                                            }
                                        }
                                        System.out.println("---------------------------------------");
                                        System.out.println();
                                    }
                                    System.out.println("Digite o novo valor do campo:");
                                    campoCadastro = scan.nextLine();
                                    vehicles.get(pos).update(escolhaCadastro, campoCadastro);
                                    System.out.println();
                                    System.out.println("---------------------------------------");
                                    System.out.println(" atualizado para veiculo" + vehicles.get(pos).getVehicleId());
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
                rideId = UUID.randomUUID().toString();
                Ride ride = new Ride(rideId);
                    if(!passengers.isEmpty()){
                        pos = rand.nextInt(passengers.size());
                        passengerPos = pos;
                        if(!cabbies.isEmpty()){
                            pos = rand.nextInt(cabbies.size());
                            cabbiePos = pos;
                            if(!vehicles.isEmpty()){
                                for(Vehicle vehicle : vehicles){
                                    if(vehicle.getCabbieId() == cabbies.get(cabbiePos).getCabbieId()){
                                    }
                                }
                                System.out.println("---------------------------------------");
                                System.out.println("Defina o local de partida: ");
                                System.out.println("1 - Aeroporto");
                                System.out.println("2 - Estacao de trem");
                                System.out.println("3 - Shopping");
                                System.out.println("4 - Escola");
                                System.out.println("5 - Parque");
                                System.out.println("6 - Hospital");
                                System.out.println("7 - Biblioteca");
                                System.out.println("8 - Estadio");
                                System.out.println("---------------------------------------");
                                System.out.println("Digite o numero correspondente ao local de partida: ");
                                partida = scan.nextInt();
                                scan.nextLine();
                                switch(partida){
                                    case 1:
                                    pickUpLocation = Location.AEROPORTO;
                                    break;
                                    case 2:
                                    pickUpLocation = Location.ESTACAO_DE_TREM;
                                    break;
                                    case 3:
                                    pickUpLocation = Location.SHOPPING;
                                    break;
                                    case 4:
                                    pickUpLocation = Location.ESCOLA;
                                    break;
                                    case 5:
                                    pickUpLocation = Location.PARQUE;
                                    break;
                                    case 6:
                                    pickUpLocation = Location.HOSPITAL;
                                    break;
                                    case 7:
                                    pickUpLocation = Location.BIBLIOTECA;
                                    break;
                                    case 8:
                                    pickUpLocation = Location.ESTADIO;
                                    break;
                                }
                                System.out.println("---------------------------------------");
                                System.out.println();
                                System.out.println("---------------------------------------");
                                System.out.println("Defina o local de destino: ");
                                System.out.println("1 - Aeroporto");
                                System.out.println("2 - Estacao de trem");
                                System.out.println("3 - Shopping");
                                System.out.println("4 - Escola");
                                System.out.println("5 - Parque");
                                System.out.println("6 - Hospital");
                                System.out.println("7 - Biblioteca");
                                System.out.println("8 - Estadio");
                                System.out.println("---------------------------------------");
                                System.out.println("Escreva o local de partida: ");
                                destino = scan.nextInt();
                                scan.nextLine();
                                switch(destino){
                                    case 1:
                                    dropOutLocation = Location.AEROPORTO;
                                    break;
                                    case 2:
                                    dropOutLocation = Location.ESTACAO_DE_TREM;
                                    break;
                                    case 3:
                                    dropOutLocation = Location.SHOPPING;
                                    break;
                                    case 4:
                                    dropOutLocation = Location.ESCOLA;
                                    break;
                                    case 5:
                                    dropOutLocation = Location.PARQUE;
                                    break;
                                    case 6:
                                    dropOutLocation = Location.HOSPITAL;
                                    break;
                                    case 7:
                                    dropOutLocation = Location.BIBLIOTECA;
                                    break;
                                    case 8:
                                    dropOutLocation = Location.ESTADIO;
                                    break;
                                }
                                System.out.println("---------------------------------------");
                                System.out.println();
                                if(partida != destino){
                                    ride.requestRide(passengers.get(passengerPos).getUserId());
                                    ride.setPickupLocation(pickUpLocation);
                                    ride.setDropLocation(dropOutLocation);
                                    System.out.println();
                                    System.out.println("---------------------------------------");
                                    System.out.println("Corrida chamada por pessoa passageira " + passengers.get(passengerPos).getUserId() + " de " + ride.getPickupLocation() + " para " + ride.getDropLocation());
                                    System.out.println("Status da corrida: " + ride.getStatus());
                                    System.out.println("Distancia calculada: " + ride.calculateDistance());
                                    System.out.println("Corrida atendida por pessoa motorista " + cabbies.get(cabbiePos).getCabbieId());
                                    ride.updateRideStatus();
                                    System.out.println("Status da corrida: " + ride.getStatus());
                                    System.out.println("---------------------------------------");
                                    System.out.println();
                                    while(!validPaymentMethod){
                                        try{
                                            System.out.println("---------------------------------------");
                                            System.out.println("Defina uma forma de pagamento: ");
                                            System.out.println("- Cartão de Crédito");
                                            System.out.println("- Cartão de Débito");
                                            System.out.println("- PIX");
                                            System.out.println("- Dinheiro");
                                            System.out.println("- Voucher");
                                            System.out.println("---------------------------------------");
                                            System.out.println("Digite a opcao de pagamento: ");
                                            paymentMethod = scan.nextLine();
                                            System.out.println("---------------------------------------");
                                            System.out.println();
                                            RidePayment ridePayment = new RidePayment(rideId, ride.getStartime(), ride.calculateDistance(), paymentMethod);
                                            validPaymentMethod = true;
                                            ridePayment.processPayment();
                                            System.out.println();
                                        } catch (IllegalArgumentException e){
                                            System.out.println(e.getMessage());
                                        }
                                    }
                                    ride.completeRide();
                                    System.out.println("---------------------------------------");
                                    System.out.println();
                                } else {
                                    System.out.println("---------------------------------------");
                                    System.out.println("Voce ja esta no local que deseja.");
                                    System.out.println("---------------------------------------");
                                    System.out.println();
                                }
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
                break;
            }
        }
        scan.close();
        System.out.println("---------------------------------------");
        System.out.println("Relatorio final dos dados: ");
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Passageiros criados: ");
        System.out.println(passengers.toString());
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Taxistas criados: ");
        System.out.println(cabbies.toString());
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Veiculos criados: ");
        System.out.println(vehicles.toString());
        System.out.println("---------------------------------------");
        System.out.println();
    }
}