package cars_proje_;

public class Employee 
{
	private int employeeId;
	private String empName;
	private String empSurname;
	private String empGender;
	private String empBirthDate;
	private int empOfficeId;
	private boolean avaliable;
	private int[] rented_counts;
	private int[] profitables;
	private int incomes;
	private int expenses;
	
	public Employee(int employeeId,String empName,String empSurname,String empGender,String empBirthDate,int empOfficeId)
	{
		this.employeeId=employeeId;
		this.empName=empName;
		this.empSurname=empSurname;
		this.empGender=empGender;
		this.empBirthDate=empBirthDate;
		this.empOfficeId=empOfficeId;
		this.avaliable = true;
		rented_counts = new int[10];
		profitables = new int[10];
		incomes=0;
		expenses=0;
	}
	
	public int getTotal_profitables() {
		int sum = 0;
		for (int i = 0; i < profitables.length; i++) {
			sum+=profitables[i];
		}
		return sum;
	}
	
	public int getBest_total_profit() {
		int most = 0;
		for (int i = 0; i < profitables.length; i++) {
			if (profitables[i]>most) {
				most=profitables[i];
			}
		}
		return most;
	}
	
	public void setProfit(int x, int y) {
		incomes=x;
		expenses=y;
		profitables[Date.top10] = x-y;
	}
	
	public String displayProfit() {
		return "("+String.valueOf(incomes)+" - "+String.valueOf(expenses)+" = "+String.valueOf(incomes-expenses)+" cp)";
	}
	
	public void setZero_profit() {
		profitables[Date.top10] = 0;
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
	public int getEmpId(){
		return employeeId;
	}
	
	public String getEmpName(){
		return empName;
	}
	
	public String getEmpSurname(){
		return empSurname;
	}
	
	public String getEmpGender(){
		return empGender;
	}
	
	public String getEmpBirthDate(){
		return empBirthDate;
	}
	
	public int getEmpOfficeId() {
		return empOfficeId;
	}
	
	public boolean getAvaliable() {
		return avaliable;
	}
	
	public void setAvaliable(boolean situation) {
		avaliable=situation;
	}
	
}
