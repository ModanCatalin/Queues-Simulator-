package model;

 


import java.util.concurrent.CopyOnWriteArrayList;



public class WaitingQueue extends Thread {
	private boolean is_Running;
	private CopyOnWriteArrayList<Client> queue;
	private int count;
	private int waiting_Time;
	private int empty_Time;
	private float average_Waiting_Time;
	private int unique_Clients;
	private String name;

	public String getQueueName() {
		return name;
	}


	public WaitingQueue(String name) {
		this.name=name;
		queue=new CopyOnWriteArrayList<Client>();
		is_Running=true;
		
	
	}
	

	public boolean isIs_Running() {
		return is_Running;
	}

	public void startQueue() {
		start();
	}
	public void run() {
		while(is_Running==true) {
			
			if(queue.isEmpty()==false) {
					checker();
			}
			else {
				empty_Time++;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public CopyOnWriteArrayList<Client> getQueue() {
		return queue;
	}


	public void add(Client client) {
		if(queue.isEmpty()==true) {
			initialize();
			
			
		}
		queue.add(client);
	
		unique_Clients++;
		average_Waiting_Time+=waiting_Time;
		client.setWaiting_Time(waiting_Time);
		waiting_Time += client.getService_Time();
		average_Waiting_Time+=waiting_Time;
		Logger.update("Client "+ client.getName() +" has entered queue " + name+ " at time: "+ Simulation.getCurrentTime() );
	}
	
	private Client remove() {
		waiting_Time-= queue.get(0).getService_Time();
	
		count=0;
		Logger.update("Client "+ queue.get(0).getName() +" has exited " + name+ " at time: "+ Simulation.getCurrentTime() );
		return queue.remove(0);
	}
	public Client getLast() {
		return queue.get(queue.size()-1);
	}
	public Client removeLast() {
		
		waiting_Time-=queue.get(queue.size()-1).getService_Time();
		return queue.remove(queue.size()-1);
	}
	
	private void initialize() {
		
		count=0;
		waiting_Time=0;
		average_Waiting_Time=0;
		unique_Clients=0;
		
	}
	
	private void checker() {
		count++;
		
		if(count==queue.get(0).getService_Time()) {
			
			remove();
		}
		
		
	}
	public void stopQueue()
	{
		is_Running = false;
	}
	public int getTotalWaitingTime() {
		return waiting_Time-count;
	}


	public int getEmpty_Time() {
		return empty_Time;
	}


	public void setEmpty_Time(int empty_Time) {
		this.empty_Time = empty_Time;
	}
	public float getAverageWaitingTime() {
		if(unique_Clients>0)
		{
			return average_Waiting_Time/unique_Clients;
		}
		else 
			return 0;
	}
	
	public int getSize() {
		return queue.size();
	}
	public String toString() {
		String s = name + ": ";
		for(Client c : queue)
		{
			s+=" "+c.getName();
		}
		return s;
	}
}
