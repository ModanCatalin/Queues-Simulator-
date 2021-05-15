package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import view.View;
import model.*;

public class Controller {
	private View view;
	
	public Controller(View view)
	{
		 this.view=view;
		 this.view.start(new Start());
	}

	class Start implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			
					
						
					int nrq,minA,maxA,minS,maxS,duration,nrClient;
					nrq= view.nrQueues();
					minA=view.minA();
					maxA=view.maxA();
					minS=view.minS();
					maxS=view.maxS();
					nrClient=view.getNrClient();
					duration=view.getDuration();
					Logger.setReal_Time(view.getEvolution());
					
					
					List<Client> list= new ArrayList<Client>(Generator.generateClients(nrClient,minA,maxA,minS,maxS));
					Simulation sim1 = new Simulation(list,duration,nrq);
				
					sim1.startSimulation();
					view.getLog().append(Logger.getReport()+"\n"+sim1.getReport());
					
			
		}
	}
}

