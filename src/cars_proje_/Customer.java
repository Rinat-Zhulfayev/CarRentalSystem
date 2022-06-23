package cars_proje_;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerSurname;
	private int[] rented_counts;
	
	Customer(int customerId, String customerName, String customerSurname)
	{
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		rented_counts = new int[10];
	}
	
	public int[] getRented_counts() {
		return rented_counts;
	}

	public void setRented_count(int x) {
		rented_counts[Date.top10] = x;
	}
	
	public int getTotal_renteds() {
		int sum = 0;
		for (int i = 0; i < rented_counts.length; i++) {
			sum+=rented_counts[i];
		}
		return sum;
	}
	
	public void setZero_rented() {
		rented_counts[Date.top10] = 0;
	}
	/////////////////////////////////
	public int getCustomerId() {
		return customerId;
	}
	
	public String getCustomerName() {
		 return customerName;
	}
	
	public String getCustomerSurname() {
		return customerSurname;
	}
}
