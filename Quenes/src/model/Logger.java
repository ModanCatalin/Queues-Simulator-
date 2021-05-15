package model;

import java.awt.TextArea;

public class Logger {
	private static String report="";

	private static TextArea real_Time;



	public static void setReal(String real_Time) {
		Logger.real_Time.setText(real_Time);
	}

	public static void setReal_Time(TextArea textArea) {
		Logger.real_Time=textArea;
	}
	public static String getReport() {
		return report;
	}

	
	public static void update(String receive) {
		report+="\n"+receive;
	}
}
