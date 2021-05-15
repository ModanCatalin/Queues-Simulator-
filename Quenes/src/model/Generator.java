package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
	
	public static List<Client> generateClients(int n,int minArrival,int maxArrival,int minService,int maxService) {
		
		List<Client> list = new ArrayList<Client>();
		Random rand = new Random();
		for(int i=0;i<n;i++)
		{
			list.add(new Client(rand.nextInt(maxService-minService)+minService,rand.nextInt(maxArrival-minArrival)+minArrival,"Client"+i));
		}
		return list;
	}
}
