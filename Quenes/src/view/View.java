package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private TextArea log,evolution;
	public void setLog(TextArea log) {
		this.log = log;
	}
	public TextArea getLog() {
		return log;
	}
	private JButton start;
	private JTextField nrQ,minA,maxA,minS,maxS,nrClient,duration;
	public View()
	{
		setName("Queues");
		setSize(1024, 800);
		
		panel = new JPanel();
		log = new TextArea();
		evolution = new TextArea();
		start = new JButton("Start");
		nrQ = new JTextField("Nr of queues:");
		nrClient = new JTextField("Nr of clients:");
		minA= new JTextField("Min arrival time:");
		duration= new JTextField("Duration:");
		maxA= new JTextField("max arrival time:");
		minS= new JTextField("Min service time:");
		maxS= new JTextField("max service time:");
		panel.setLayout(null);
		log.setBounds(4, 4, 780, 200);
		
		evolution.setBounds(4, 220, 600, 150);
		panel.setVisible(true);
		panel.add(log);
		panel.add(evolution);
		start.setBounds(20, 650, 90, 60);
		nrQ.setBounds(150, 650, 120, 40);
		minA.setBounds(280, 650, 120, 40);
		maxA.setBounds(410, 650, 120, 40);
		minS.setBounds(540, 650, 120, 40);
		maxS.setBounds(670, 650, 120, 40);
		nrClient.setBounds(930,650,120,40);
		duration.setBounds(800, 650, 120, 40);
		panel.add(start);
		panel.add(nrQ);
		panel.add(minA);
		panel.add(maxA);
		panel.add(minS);
		panel.add(maxS);

		panel.add(nrClient);
		panel.add(duration);
		log.append("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setVisible(true);
		
	}
	

	public TextArea getEvolution() {
		return this.evolution;
	}
	public void setEvolution(TextArea evolution) {
		this.evolution = evolution;
	}
	public int getNrClient() {
		return Integer.parseInt(nrClient.getText());
	}
	public int getDuration() {
		return Integer.parseInt(duration.getText());
	}
	public void setLog(String s)
	{
		log.setText(s);
	}
	
	public int nrQueues()
	{
		return Integer.parseInt(nrQ.getText());
	}
	public int minA()
	{
		return Integer.parseInt(minA.getText());
	}
	public int maxA()
	{
		return Integer.parseInt(maxA.getText());
	}
	public int minS()
	{
		return Integer.parseInt(minS.getText());
	}
	public int maxS()
	{
		return Integer.parseInt(maxS.getText());
	}

	public void start(ActionListener al)
	{
		start.addActionListener(al);
	}
}
