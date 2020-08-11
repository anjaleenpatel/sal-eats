package anjaleep_CSCI201_Assignment2;


import java.util.ArrayList;


public class OrderData {
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	public ArrayList<Order> getOrderData() {
		return orders;
	}
	
	public Order getOrderIndex(int i) {
		return orders.get(i);
	}
	
	public void addOrder(Order ord) {
		orders.add(ord);
	}
}
