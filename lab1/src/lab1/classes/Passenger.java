/*
 * Nome: Gabriel Henrique Pereira Lopes da Silva
 * RA: 200342
 * Nome: Joao Guilherme Ferreira Pedra
 * RA: 248349
 * 
 */

package lab1.classes;

public class Passenger extends Person {
	private String destination;
	private String name;
	public Passenger(String a_name) {
		this.destination = "";
		this.name = a_name;
	}
	@Override
	public void performRole() {
		System.out.println(this.name + " chama um taxi");
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Passenger [destination=" + destination + ", name=" + name + "]";
	}
}
