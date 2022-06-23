package cars_proje_;

public class Office {
	
	private int office_id;
	private String office_number;
	private String office_adress;
	private String office_city;
	private int money;
	//**********************************************
	private Employee[] employeArray;
	private Car[] carArray;
	//**********************************************
	int emp_count=0;
	int car_count=0;
	
	public Office(int office_id, String office_number, String office_adress,String office_city)
	{
		this.office_id=office_id;
		this.office_number=office_number;
		this.office_adress=office_adress;
		this.office_city=office_city;
		employeArray = new Employee[3];
		carArray = new Car[100];
		money=0;
	}
		
	//*****************************************************
	
	public void addCar(Car car)
	{
		carArray[car_count]=car;
		car_count++;
	}	
	
	public int getOfficeId() 
	{
		return office_id;
	}
	
	public String getOfficeNumber()
	{
		return office_number;
	}
	
	public String getOfficeAdress() 
	{
		return office_adress;
	}
	
	public String getOfficeCity() {
		return office_city;
	}
	
	public Employee[] getEmployeeArray() {
		return employeArray;
	}
	
	public Car[] getCarArray() {
		return carArray;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money += money;
	}
	
	/////////////////////////////////
	public double[] averages_contract = new double[10];
	public void getTotal_averages(Contract[] c, int office_id, int day, int month, int year) {
		double sum = 0;
		int contract_count = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i]!=null) {
				if (c[i].getOfficeId()==office_id && c[i].getStartDate().getCompleteDate().equals(day+"/"+month+"/"+year)) {
					sum+=Integer.parseInt(String.valueOf(c[i].getAverage_day()));
					contract_count++;
				}
			}
			else
				break;
		}
		if (contract_count!=0) 
			setAverage_total_forday(sum/contract_count);
	}
	public double getTotal_averages_top10() {
		double sum = 0;
		for (int i = 0; i < averages_contract.length; i++) {
			sum+=averages_contract[i];
		}
		return sum;
	}
	public void setAverage_total_forday(double x) {
		averages_contract[Date.top10] = x;
	}
	public void setZero_average() {
		averages_contract[Date.top10] = 0;
	}
	
	public int GetEmpNumber() {
		int number = 0;
		for (int i = 0; i < employeArray.length; i++) {
			if (employeArray[i]!=null)
				number++;
		}
		return number;
	}
	public int GetCarNumber() {
		return car_count;
	}
	
	
}
