package com.DesignPattern;
import java.util.Observable;
import java.util.Observer;
public class ObserverPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData wd = new WeatherData();
		Board b = new Board();
		wd.addObserver(b);
	}
	static class WeatherData extends Observable {
	}
	static class Board implements Observer {
		Observable o;
		float temperature;
		float pressure;
		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
			this.pressure = ((Message)arg).pressure;
			this.temperature = ((Message)arg).temperature;
		}
		
	}
	static class Message {
		float temperature;
		float pressure;
	}

}
