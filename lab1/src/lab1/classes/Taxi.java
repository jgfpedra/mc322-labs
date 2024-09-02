/*
 * Nome: Gabriel Henrique Pereira Lopes da Silva
 * RA: 200342
 * Nome: Joao Guilherme Ferreira Pedra
 * RA: 248349
 * 
 */

package lab1.classes;

import java.util.Random;

public class Taxi {
	private int id;
	private String destination;
	private boolean isHailed;
	private Cabbie taxista;
	private Passenger passageiro;
	private int horas, total;
	
	public Taxi(int id, Cabbie taxista) {
		this.id = id;
		this.destination = "";
		this.isHailed = false;
		this.taxista = taxista;
	}
	public int getId() {
		return this.id;
	}
	public String getDestination() {
		return destination;
	}
	public int getHoras() {
		return this.horas;
	}
	public Cabbie getTaxista() {
		return this.taxista;
	}
	public Passenger getPassageiro() {
		return this.passageiro;
	}
	public void setPassageiro(Passenger passageiro) {
		this.passageiro = passageiro;
	}
	public void setIsHailed(boolean isHailed) {
		this.isHailed = isHailed;
	}
	public void setDestination(String destination) {
		Random rand = new Random();
		
		this.destination = destination;
		this.horas = rand.nextInt(5);
		this.total = rand.nextInt(100);
	}
	public boolean isHailed() {
		return isHailed;
	}
	public void passarHorario() {
		this.horas += 1;
	}
	public boolean chegouDestino() {
		if(this.horas == 5) {
			System.out.println("a");
			this.isHailed = false;
			this.horas = 0;
			this.taxista.setMoney(this.total + this.taxista.getMoney());
			return true;
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		try {
			return "Taxi [id=" + id + ", destination=" + destination + ", isHailed=" + isHailed + ", taxista=" + taxista
							+ ", passageiro=" + passageiro + ", horas=" + horas + ", total=" + total + "]";
		} catch(Exception e) {
			return e.toString();
		}
	}
}
