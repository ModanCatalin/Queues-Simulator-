package model;

import java.util.List;

public class Distributor {

	List<WaitingQueue> queues;

	public Distributor(List<WaitingQueue> queues) {
		
		this.queues = queues;
	}
	
	
	public void add(WaitingQueue queue) {
		if(queues.isEmpty()==true) {
			queues.add(queue);
		}
		else {
			for(WaitingQueue temp:queues) {
				if(queue.getTotalWaitingTime()>=temp.getTotalWaitingTime()) {
					queues.add(queues.indexOf(temp), queue);
					break;
					
				}
				else {
					if(queues.indexOf(temp)==(queues.size()-1)) {
						queues.add(queue);
						break;
					}
				}
			}
		}
	}
	public void redistribute() {
		
		if(queues.size()>1)
		{
			WaitingQueue last= queues.get(queues.size()-1);
			WaitingQueue max;
			while(queues.indexOf(last)==(queues.size()-1))
			{   max=queues.get(0);
				for(int i=0;i<queues.size()-2;i++)
				{
					if(max.getLast().getWaiting_Time()<queues.get(i).getLast().getWaiting_Time())
					{
						max=queues.get(i);
					}
				}
				if(max.getLast().getWaiting_Time()<last.getTotalWaitingTime())
				distribute(max.removeLast());
				else break;
			}
		}
	}
	
	
	public void distribute(Client client) {
		
		
			WaitingQueue temp_Queue;
			temp_Queue=queues.get(queues.size()-1);
			System.out.println(temp_Queue.getName());
			temp_Queue.add(client);
			queues.remove(temp_Queue);
			add(temp_Queue);
		
	
	}
	

}
