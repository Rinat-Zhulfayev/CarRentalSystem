package cars_proje_;

public class CarRequest {
	
	private int requestId;
	private int officeId;
	private int customerId;
	private String carBrand;
	private String carModel;
	private String carClass;
	private Date startDate;
	private Date endDate;
	
	public CarRequest(int requestId,int officeId, int customerId,String carBrand,String carModel,String carClass,Date startDate,Date endDate)
	{
		this.requestId=requestId;
		this.officeId=officeId;
		this.customerId=customerId;
		this.carBrand=carBrand;
		this.carModel=carModel;
		this.carClass=carClass;
		this.startDate=startDate;
		this.endDate=endDate;
	}

	public int getRequestId() {
		return requestId;
	}

	public int getOfficeId() {
		return officeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public String getCarClass() {
		return carClass;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
}
