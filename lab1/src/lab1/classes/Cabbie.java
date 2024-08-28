package lab1.classes;

public class Cabbie extends Person{
	private int money;
	public Cabbie() {
		this.money = 0;
	}
	@Override
	public void performRole() {
	}
	public int getMoney() {
		return money;
	}
	@Override
	public String toString() {
		return "Cabbie [money=" + money + "]";
	}
}
