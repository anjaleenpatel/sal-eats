package anjaleep_CSCI201_Assignment2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Restaurant{
	public String name;
	public String address;
	public double latitude;
	public double longitude;
	public int drivers;
	public double distance;
	public Semaphore sem;
	public ArrayList<String> menu; 
	
	public void setSem() {
		sem = new Semaphore(drivers);
		
	}
	public Semaphore getSem() {
		return this.sem;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String a) {
		this.address = a;
	}
	public double getLong() {
		return longitude;
	}
	public void setLong(double l) {
		this.longitude = l;
	}
	public double getLat() {
		return latitude;
	}
	public void setLat(double la) {
		this.latitude = la;
	}
	public ArrayList<String> getMenu() {
		return menu; 
	}
	public String getMenuItem(int i) {
		return menu.get(i);
	}
	public void setMenu(ArrayList<String> m) {
		this.menu = m;
	}
	public int getDrivers() {
		return drivers;
	}

	public double calcDistance(double latit, double longit) {
		distance = 3963.0 * Math.acos((Math.sin(Math.toRadians(latit)) * Math.sin(Math.toRadians(this.latitude))) + Math.cos(Math.toRadians(latit))
        * Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(longit) - Math.toRadians(this.longitude)));
		return distance*2;
	}
}
