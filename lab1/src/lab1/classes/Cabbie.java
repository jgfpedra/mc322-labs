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
		return "Cabbie [money=" + money + "]";
	}
}
