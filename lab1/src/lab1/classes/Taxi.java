package lab1.classes;

public class Taxi {
	private String destination;
	private boolean isHailed;
	public Taxi() {
		this.destination = "";
		this.isHailed = false;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public boolean isHailed() {
		return isHailed;
	}
	public void setHailed(boolean isHailed) {
		this.isHailed = isHailed;
	}
	@Override
	public String toString() {
		return "Taxi [destination=" + destination + ", isHailed=" + isHailed + "]";
	}
}
