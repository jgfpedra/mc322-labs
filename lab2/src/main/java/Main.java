/*
 * Nome: Gabriel Henrique Pereira Lopes da Silva
 * RA: 200342
 * Nome: Joao Guilherme Ferreira Pedra
 * RA: 248349
 */
package main.java;

import java.util.ArrayList;
import java.util.List;
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
    /**
    * Metodo Main que contem o programa de taxi.
    * <p>
    * Esse metodo serve como o ponto de entrada para a criacao de um sistema de taxi.
    * Nele temos a descricao de algumas opcoes {@link switch}, em que:
    *   - Caso 1, temos a criacao do objeto passageiro ou a modificacao de alguma atributo de um passageiro ja criado.
    *   - Caso 2, temos a criacao do objeto motorista ou a modificacao de alguma atributo de um motorista ja criado.
    *   - Caso 3, temos a criacao do objeto veiculo ou a modificacao de alguma atributo de um veiculo ja criado.
    *   - Caso 4, temos a definicao dos atributos da corrida.
    *   - Caso 5, temos a definicao do metodo de pagamento para a corrida.
    *   - Caso 6, temos a finalizacao da corrida - o programa atual so compromete uma corrida por vez.
    *   - Caso 7, temos a finalizacao do programa.
    * </p>
    *
    * @throws IllegalArgumentException se, no caso 5, for selecionado um metodo de pagamento diferente do esperado.
    */
    public static void main(String[] args) {
        //Auxiliares
        int escolha = 0, paymentId = 0, pos, passengerId, cabbieId, vehicleId = 0, rideId = 0;
        String paymentMethod, escolhaCadastro, campoCadastro, partida, destino;
        boolean validPaymentMethod = false, validCabbie, validId = false;

        // Objetos Auxiliares
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        Ride ride = new Ride();
        Payment payment = new Payment();

        //Geradores
        PassengerInfoGenerator passRand = new PassengerInfoGenerator();
        CabbieInfoGenerator cabbRand = new CabbieInfoGenerator();
        
        //ArrayLists
        List<Passenger> passengers = new ArrayList<Passenger>();
        List<Cabbie> cabbies = new ArrayList<Cabbie>();
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        
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
                            // Criacao de um objeto passageiro e sua adicao no ArrayList
                            // Logica para gerar outro ID caso pegue o mesmo de outro ja criado.
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
                            Passenger passenger = new Passenger(passRand.getPassengerId(), passRand.getName(), passRand.getEmail(), passRand.getEmail());
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
                            // Criacao de um objeto vehicle e adicao ao ArrayList vehicles
                            if(!cabbies.isEmpty()){
                                System.out.println("---------------------------------------");
                                System.out.print("Selecione o Motorista que ira dirigir o veiculo: ");
                                System.out.println();
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
                            // Atualizacao do campo de um veiculo do ArrayList vehicles
                            if(!vehicles.isEmpty()){
                                pos = 0;
                                System.out.println("---------------------------------------");
                                System.out.print("Selecione o ID do Veiculo: ");
                                System.out.println();
                                for(Vehicle vehicleIterator : vehicles)
                                    System.out.println(pos + ": ID do veiculo - "  + vehicleIterator.getVehicleId());
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
                    scan.nextLine(); // Consome o buffer de nova linha
                    System.out.println();
                    switch(escolha){
                        // Requisicao de uma corrida com instanciacao dos atributos do objeto ride
                        case 1:
                            if(ride.getStatus() == "Livre"){
                                if(!passengers.isEmpty()){
                                    pos = rand.nextInt(passengers.size());
                                    passengerId = pos;
                                    if(!cabbies.isEmpty()){
                                        pos = rand.nextInt(cabbies.size());
                                        cabbieId = pos;
                                        if(!vehicles.isEmpty()){
                                            for(Vehicle vehicle : vehicles){
                                                if(vehicle.getCabbieId() == cabbieId){
                                                    vehicleId = vehicle.getVehicleId();
                                                }
                                            }
                                            System.out.println("---------------------------------------");
                                            System.out.println("Defina o local de partida: ");
                                            partida = scan.nextLine();
                                            System.out.println("---------------------------------------");
                                            System.out.println();
                                            System.out.println("---------------------------------------");
                                            System.out.println("Defina o local de destino: ");
                                            destino = scan.nextLine();
                                            System.out.println("---------------------------------------");
                                            ride.requestRide(rideId, passengerId, cabbieId, vehicleId, partida, destino);
                                            System.out.println();
                                            System.out.println("---------------------------------------");
                                            System.out.println("Corrida chamada por pessoa passageira " + passengerId + " de " + ride.getPickupLocation() + " para " + ride.getDropLocation());
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
                            // Mostra o valor da corrida, ja definido no caso anterior
                            if(ride.getStatus() == "Ocupado"){
                                System.out.println("---------------------------------------");
                                System.out.println("Valor da corrida definido: R$ " + ride.getFare());
                                System.out.println("---------------------------------------");
                                System.out.println();
                            } else {
                                System.out.println("---------------------------------------");
                                System.out.println("Nenhuma corrida no momento.");
                                System.out.println("---------------------------------------");
                                System.out.println();
                            }
                            break;
                    }
                break;
                case 5:
                    // Definicao de um metodo de pagamento a partir da insercao de novos atributos para o objeto pagamento
                    if(ride.getStatus() == "Ocupado"){
                        while(!validPaymentMethod){
                            scan.nextLine();
                            System.out.println("---------------------------------------");
                            System.out.println("Defina a forma de pagamento: ");
                            paymentMethod = scan.nextLine();
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
                                // Caso usuario digite outro tipo de pagamento, recebe um retorno de erro
                                System.out.println("---------------------------------------");
                                System.out.println(e.getMessage());
                                System.out.println("---------------------------------------");
                                System.out.println();
                            }
                        }
                    } else {
                        System.out.println("---------------------------------------");
                        System.out.println("Nenhuma corrida no momento.");
                        System.out.println("---------------------------------------");
                        System.out.println();
                    }
                break;
                case 6:
                    // Caso para finalizar a corrida atual
                    if(ride.getStatus() == "Ocupado"){
                        ride.completeRide();
                        System.out.println("---------------------------------------");
                        System.out.println("Corrida finalizada.");
                        System.out.println("---------------------------------------");
                        System.out.println();
                    } else {
                        System.out.println("---------------------------------------");
                        System.out.println("Nenhuma corrida no momento.");
                        System.out.println("---------------------------------------");
                        System.out.println();
                    }
                break;
            }
        }
        // Relatorio com dados nos ArrayLists e objetos do sistema
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