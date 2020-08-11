package anjaleep_CSCI201_Assignment2;

import java.util.concurrent.Semaphore;

public class RestaurantDriver extends Thread{
	String restaurantName;
	String menuItem;
	double distance;
	Semaphore s = null;
	
	public RestaurantDriver(String restaurantName, String menuItem, double distance, Semaphore s){
		this.restaurantName = restaurantName;
		this.menuItem = menuItem;
		this.distance = distance;
		this.s = s;
	}
	
	public void run() {
		try {
			s.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		makeDelivery();
		s.release();
	}
	
	public void makeDelivery(){
		Util.printMessage("Starting delivery of " + menuItem + " from " + restaurantName + "!");
		try {
			Thread.sleep((long) distance*1000);
		} catch (InterruptedException ie) {
			Util.printMessage("ie cutting customer's hair" + ie.getMessage());
		}
		
		Util.printMessage("Finished delivery of " + menuItem + " from " + restaurantName + "!");
	}
}

