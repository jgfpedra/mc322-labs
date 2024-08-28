package lab1.classes;

import java.util.Random;

public class Taxi {
	private String destination;
	private boolean isHailed;
	private Cabbie taxista;
	private Passenger passageiro;
	private int horas, total;
	
	public Taxi(Cabbie taxista) {
		this.destination = "";
		this.isHailed = false;
		this.taxista = taxista;
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
		this.isHailed = true;
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
			this.isHailed = false;
			taxista.setMoney(this.total + taxista.getMoney());
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Taxi [destination=" + destination + ", isHailed=" + isHailed + "]";
	}
}
