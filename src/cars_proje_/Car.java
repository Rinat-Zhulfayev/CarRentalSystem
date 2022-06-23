package cars_proje_;

public class Car {
	private int carId;
	private String carBrand;
	private String carModel;
	private String carClass;
	private int carKm;
	private int carOfficeId;
	private boolean avaliable;
	private int[] rented_counts;
	private int[] profits;
	
	public Car(int carId, String carBrand,String carModel,String carClass,int carKm,int carOfficeId,boolean avaliable)
	{
		this.carId=carId;
		this.carBrand=carBrand;
		this.carModel=carModel;
		this.carClass=carClass;
		this.carKm=carKm;
		this.carOfficeId=carOfficeId;
		this.avaliable=avaliable;
		rented_counts = new int[10];
		profits = new int[10];
	}
	
	public int[] getProfits() {
		return profits;
	}

	public void setProfit(int x) {
		profits[Date.top10] = x;
	}
	
	public int getTotal_profits() {
		int sum = 0;
		for (int i = 0; i < profits.length; i++) {
			sum+=profits[i];
		}
		return sum;
	}
	
	public void setZero_profit() {
		profits[Date.top10] = 0;
	}
	/////////////////////////////////
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
	public void setCarAvaliable(boolean usage) {
		avaliable = usage;
	}
	
	public boolean getCarUsage() {
		return avaliable;
	}
	
	public int getCarId()
	{
		return carId;
	}
	
	public String getCarBrand()
	{
		return carBrand;
	}
	
	public String getCarClass() {
		return carClass;	
	}
	
	public String getCarModel() {
		return carModel;
	}
	
	public int getCarKm() {
		return carKm;
	}
	
	public int getCarOfficeId() {
		return carOfficeId;
	}
	
		
}
