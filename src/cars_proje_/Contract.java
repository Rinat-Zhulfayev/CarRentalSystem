package cars_proje_;

public class Contract {
	
	private int contractId;
	private Customer customer;
	private Car car;
	private Employee employee;
	private Date startDate;
	private Date endDate;
	private int officeId;
	private int average_day;
	private boolean isActive;
	
	public Contract(int contractId, Customer customer, Car car,Employee employee, Date startDate,Date endDate)
	{
		this.contractId=contractId;
		this.customer=customer;
		this.car=car;
		this.employee=employee;
		this.startDate=startDate;
		this.endDate=endDate;	
		officeId = -2;
		average_day = 0;
		isActive=true;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	////////////////////////////////
	public int getAverage_day() {
		if (startDate.getDay()<endDate.getDay()) {
			average_day=endDate.getDay()-startDate.getDay()+1;
			return average_day;
		}
		else {
			average_day=30+endDate.getDay()-startDate.getDay()+1;
			return average_day;
		}
	}

	public void setAverage_days(int average_day) {
		this.average_day = average_day;
	}
	////////////////////////////////
	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public int getContractId() {
		return contractId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Car getCar() {
		return car;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
}