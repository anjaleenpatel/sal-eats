package anjaleep_CSCI201_Assignment2;

import java.util.ArrayList;

	public class Data {
		public ArrayList<Restaurant> data = new ArrayList<Restaurant>();
		
		public ArrayList<Restaurant> getData() {
			return data;
		}
		public void removeInd(int index) {
			data.remove(index);
		}
		public Restaurant getIndex(int i) {
			return data.get(i);
		}
		public void addRestaurant(Restaurant r) {
			data.add(r);
		}
	}

