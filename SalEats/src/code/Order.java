package anjaleep_CSCI201_Assignment2;

import java.util.concurrent.Semaphore;

public class Order extends Thread{
	String restaurantName;
	int readyTime;
	String menuItem;
	double distance;
	Semaphore s = null;

	Order(int readyTime, String restaurantName, String menuItem, double distance, Semaphore s){
		this.readyTime = readyTime;
		this.restaurantName = restaurantName;
		this.menuItem = menuItem;
		this.distance = distance; 
		this.s = s;

	}
	
	public void run() {
		//System.out.println(restaurantName + menuItem + readyTime + " " + distance);
		try {
			Thread.sleep(readyTime*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createDriver();
	}
	
	public void createDriver() {
		
		RestaurantDriver r = new RestaurantDriver(restaurantName, menuItem, distance, s);
		r.start();
	}
}

