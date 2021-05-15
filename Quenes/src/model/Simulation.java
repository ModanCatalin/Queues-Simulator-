package model;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
	
	private List<Client> clients;
	private List<WaitingQueue> queues;
	private int duration;
	private int peakTime;
	private int maxClients;
	private float average;
	private String report;
	private static int current_Time;
	private int nrOfQueues;
	
	private Distributor distributor;
	public Simulation(List<Client> clients, int duration,int nrOfQueues)
	{
		this.clients = clients;
		this.duration = duration;
		this.nrOfQueues = nrOfQueues;
		peakTime=0;
		maxClients=0;
		report=null;
		
		queues=new ArrayList<WaitingQueue>();
		initSimulation();
	}
	
	public void runSimulation() {
		for( current_Time= 0; current_Time <= duration; current_Time++){
			int temp=0;
			String s = "";
			for(WaitingQueue queue: queues) {
				temp+=queue.getSize();
				s+=queue.toString()+"\n";
			}
			Logger.setReal(s);
			if(maxClients<temp) {
				maxClients=temp;
				peakTime=current_Time;
			}
			for(Client client : clients) {
				
				if(client.getArrival_Time()==current_Time) {
					 distributor.distribute(client);
				}
			}			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		average();
		generateReport();
		stopSimulation();
		System.out.println("has stopped");
	}
	private void stopSimulation() {
		for(WaitingQueue queue : queues)
		{
			queue.stopQueue();
		}
	}
	
	private void initSimulation() {
		

		distributor = new Distributor(queues);
		WaitingQueue queue;
		

		for(int i=0;i<nrOfQueues;i++) {
			
			queue = new WaitingQueue("Queue"+i);
			
			distributor.add(queue);
			
			
		}
		
		
	}
	public void startSimulation() {
		for(WaitingQueue q : queues)
		{
			q.startQueue();
		}
		runSimulation();
	}
	public List<WaitingQueue> getQueues() {
		return queues;
	}

	public void addQueue(WaitingQueue queue) {
		distributor.add(queue);
		distributor.redistribute();
	}
	private void average() {
		
		average=0;
		for(WaitingQueue queue: queues ) {
			average+=queue.getAverageWaitingTime();
		}
		average/=queues.size();
	}
	private void generateReport() {
		 report= "peak time: "+ peakTime +"\n" + "average time "+ average ;
	}
	
	public String getReport() {
		return report;
	}
	public static int getCurrentTime() {
		return current_Time;
	}
}
