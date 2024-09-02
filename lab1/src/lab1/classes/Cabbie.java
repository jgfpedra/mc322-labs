/*
 * Nome: Gabriel Henrique Pereira Lopes da Silva
 * RA: 200342
 * Nome: Joao Guilherme Ferreira Pedra
 * RA: 248349
 * 
 */

package lab1.classes;

public class Cabbie extends Person{
	private int money;
	private String name;
	
	public Cabbie(String name) {
		this.name = name;
		this.money = 0;
	}
	
	@Override
	public void performRole() {
		System.out.println("Taxista atende ao chamado");
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		try {
			return "Cabbie [name=" + this.name + ", money=" + this.money +"]";
		} catch(Exception e) {
			return e.toString();
		}
	}
}
