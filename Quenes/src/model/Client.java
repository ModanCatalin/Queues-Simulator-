package model;

public class Client {
	public Client(int service_Time, int arrival_Time, String name) {
		this.service_Time = service_Time;
		this.arrival_Time = arrival_Time;
		this.name = name;
	}

	private int waiting_Time;
	private int service_Time;
	private int arrival_Time;
	private String name;
	
	public String getName() {
		return name;
	}

	public int getWaiting_Time() {
		return waiting_Time;
	}
	
	public void setWaiting_Time(int waiting_Time) {
		this.waiting_Time = waiting_Time;
	}
	
	public int getService_Time() {
		return service_Time;
	}
	
	public void setService_Time(int service_Time) {
		this.service_Time = service_Time;
	}

	public int getArrival_Time() {
		return arrival_Time;
	}

	public void setArrival_Time(int arrival_Time) {
		this.arrival_Time = arrival_Time;
	}
	
	
	
}
