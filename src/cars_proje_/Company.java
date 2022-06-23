package cars_proje_;

public class Company {
	
	private Office[] officeArray = new Office[100];
	private Customer[] customerArray = new Customer[100];
	private CarRequest[] carRequestArray = new CarRequest[100];
	private Contract[] contracts = new Contract[50];
	
	private int countOffice;
	private int countCustomer;
	private int carRequestCount;
	private int contractCount;
	private int contract_index=0;
	
	public Company() {
		countOffice=0;
		countCustomer =0;
		carRequestCount=0;
		contractCount=0;
	}
	
	public void listOffice() {
		for(int i=0;i<officeArray.length;i++)
		{
			if(officeArray[i]!=null) {
				Office office= officeArray[i];
				System.out.println(office.getOfficeId()+".Office;"+office.getOfficeNumber()+";"+office.getOfficeAdress()+";"+office.getOfficeCity());
			}
		}
	}
	
	
	public void addEmployee(Employee employee, int officeId)
	{
		boolean added=false;
		for(int i=0; i<officeArray.length;i++) {
			
			if(officeArray[i].getOfficeId()==officeId) {
				
				if(officeArray[i].getEmployeeArray()[0]!=null && officeArray[i].getEmployeeArray()[1]!=null&&officeArray[i].getEmployeeArray()[2]!=null) {
					System.out.println("There is no place for employe in the office");
					added=true;
					break;
				}
				
				for(int j=0;i<officeArray[i].getEmployeeArray().length;j++) {
					
					if(officeArray[i].getEmployeeArray()[j]==null) {
						officeArray[i].getEmployeeArray()[j]=employee;
						System.out.println("Employee Added!");
						added=true;
						break;
					}
				}
				if(added==true) {
					break;
				}
			}
		}
	}
	
	public void listEmployee(int officeId) {
		
		for(int i=0; i<officeArray.length;i++) {
			
			if(officeArray[i]!=null && officeArray[i].getOfficeId()==officeId)
			{
				for(int j=0;j<officeArray[i].getEmployeeArray().length;j++) {
					if(officeArray[i].getEmployeeArray()[j]!=null) {
						Employee emp = officeArray[i].getEmployeeArray()[j];
						System.out.println(emp.getEmpId()+".Employee;"+emp.getEmpName()+";"+emp.getEmpSurname()+";"+emp.getEmpGender()+";"+emp.getEmpBirthDate()+";"+emp.getEmpOfficeId());
					}
				}
			}
		}	
	}
	
	
	public void addCar(Car car, int officeId)
	{
		boolean added = false;
		
		for(int i=0;i<officeArray.length;i++) {
			
			if(officeArray[i]!=null && officeArray[i].getOfficeId()==officeId) {
				
				for(int j=0;j<officeArray[i].getCarArray().length;j++) {
					if(officeArray[i].getCarArray()[j]==null) {
						
						officeArray[i].getCarArray()[j]=car;
						System.out.println("Car has been added succesfully!");
						added=true;
						break;
					}
				}
				if(added==true) {
					break;
				}
			}
		}
	}
	
	public void listCar(int officeId) {
		for(int i=0;i<officeArray.length;i++) {
			
			if(officeArray[i]!=null && officeArray[i].getOfficeId()==officeId) {
				
				for(int j=0;j<officeArray[i].getCarArray().length;j++) {
					
					if(officeArray[i].getCarArray()[j]!=null)
					{
						Car car = officeArray[i].getCarArray()[j];
						
						if(car.getCarUsage()==true) {
							System.out.println(car.getCarId()+".Car;"+car.getCarBrand()+";"+car.getCarModel()+";"+car.getCarClass()+";"+car.getCarKm()+";"+car.getCarOfficeId()+"-Avaliable");
						}
						else {
							System.out.println(car.getCarId()+".Car;"+car.getCarBrand()+";"+car.getCarModel()+";"+car.getCarClass()+";"+car.getCarKm()+";"+car.getCarOfficeId()+"-Not Avaliable");
						}
					}
				}
			}
		}
	}
	
	
	public void deleteEmployee(int officeId, int employeeId) {
		boolean done = false;
		for(int i=0;i<officeArray.length;i++) {
			
			if(officeArray[i].getOfficeId()==officeId) {
				
				for(int j=0; j<officeArray[i].getEmployeeArray().length; j++) {
					
					if(officeArray[i].getEmployeeArray()[j]!=null && officeArray[i].getEmployeeArray()[j].getEmpId()==employeeId) {
						officeArray[i].getEmployeeArray()[j]=null;
						System.out.println("Employee has been deleted from office");
						done = true;
						break;
					}
				}
				if(done==true) {
					break;
				}	
			}
		}
	}
	
	public void addOffice(Office office) {
		officeArray[countOffice]=office;
		System.out.println("Office has been added!");
		countOffice++;
	}
	
	public void addCustomer(Customer customer) {
		customerArray[countCustomer]=customer;
		System.out.println("Customer has been added!");
		countCustomer++;
	}
	
	public void listCustomer() {
		for(int i=0;i<customerArray.length;i++) {
			if(customerArray[i]!=null) {
				Customer customer = customerArray[i];
				System.out.println(customer.getCustomerId()+".Customer;"+customer.getCustomerName()+";"+customer.getCustomerSurname());
			}
		}
	}
	
	public void deleteOffice(int officeId) {
		
		for(int i=0;i<officeArray.length;i++) {
			
			if(officeArray[i] != null &&  officeArray[i].getOfficeId()==officeId) {
				Office office = officeArray[i];
				if(office.getEmployeeArray()[0]!=null ||office.getEmployeeArray()[1]!=null||office.getEmployeeArray()[2]!=null ) {
					System.out.println("First you should fire all employees in the office");
				}
				else if(office.getEmployeeArray()[0]==null && office.getEmployeeArray()[1]==null && office.getEmployeeArray()[2]==null) {
					officeArray[i]=null;
					System.out.println("Office Deleted Succesfully!");
				}
			}
			
		}
	}
	
	public void addCarRequest(CarRequest carRequest, Date currentDate) {
		
		carRequestArray[carRequestCount]=carRequest;
		carRequestCount++;
		
		Employee employee = null;
		Car car = null;
		
		boolean contractMade = false;
		boolean allowDate = true;
		
		int isci_indexi=0;
		int araba_indexi=0;
		
		int startDateDays = carRequest.getStartDate().getDay()*1+ carRequest.getStartDate().getMonth()*30+carRequest.getStartDate().getYear()*360;
		int endDateDays = carRequest.getEndDate().getDay()*1+carRequest.getEndDate().getMonth()*30+carRequest.getEndDate().getYear()*360;
		
		if(carRequest.getStartDate().getDay()!=currentDate.getDay() || carRequest.getStartDate().getMonth()!=currentDate.getMonth() || carRequest.getStartDate().getYear()!=currentDate.getYear()) {
			System.out.println("Request start date must be for today!");
			allowDate = false;
		}
		
		if(endDateDays-startDateDays>4 || endDateDays-startDateDays<0) {
			System.out.println("Request must be for 1-4 days!");
			allowDate=false;
		}
		
		
		
		
		
		if(carRequest.getOfficeId()!=-1) {
			
			//ofiste uygun employe olup olmad��� kontrol�
			for(int i=0;i<officeArray.length;i++) {
				
				if(officeArray[i]!=null && officeArray[i].getOfficeId()==carRequest.getOfficeId()) {
					
					//Bo� employee kontrol�
					for(int j=0; j<officeArray[i].getEmployeeArray().length; j++) {
						
						if(officeArray[i].getEmployeeArray()[j]!=null && officeArray[i].getEmployeeArray()[j].getAvaliable()==true ) {
							
							//officeArray[i].getEmployeeArray()[j].setAvaliable(false);
							employee = officeArray[i].getEmployeeArray()[j];
							isci_indexi=j;
							break;
						}
						
					}
					
					
					//Bo� araba kontrol�
					//++ * * belirli
					if(carRequest.getCarBrand().equals("*") && carRequest.getCarModel().equals("*") && !carRequest.getCarClass().equals("*")) {
						
						for(int j=0; j<officeArray[i].getCarArray().length; j++) {
							
							if(officeArray[i].getCarArray()[j]!=null && officeArray[i].getCarArray()[j].getCarUsage()==true && officeArray[i].getCarArray()[j].getCarClass().equals(carRequest.getCarClass()))
							{
								//officeArray[i].getCarArray()[j].setCarAvaliable(false);
								car = officeArray[i].getCarArray()[j];
								araba_indexi=j;
								break;
							}
							
						}
						
					}
					//* belirli belirli
					else if(!carRequest.getCarBrand().equals("*") && carRequest.getCarModel().equals("*") && carRequest.getCarClass().equals("*")) {
						for(int j=0; j<officeArray[i].getCarArray().length; j++) 
						{
							if(officeArray[i].getCarArray()[j]!=null && officeArray[i].getCarArray()[j].getCarUsage()==true &&
									officeArray[i].getCarArray()[j].getCarBrand().equals(carRequest.getCarBrand())) {
								
								car = officeArray[i].getCarArray()[j];
								araba_indexi=j;
								break;
								
							}
								
							
						}
					}
					else if(!carRequest.getCarBrand().equals("*") && /* */ !carRequest.getCarModel().equals("*") && /* */ !carRequest.getCarClass().equals("*")) {
							
						for(int j=0; j<officeArray[i].getCarArray().length; j++) 
						{
							if(officeArray[i].getCarArray()[j]!=null && officeArray[i].getCarArray()[j].getCarUsage()==true &&
									officeArray[i].getCarArray()[j].getCarModel().equals(carRequest.getCarModel()) && 
									officeArray[i].getCarArray()[j].getCarClass().equals(carRequest.getCarClass()) &&
									officeArray[i].getCarArray()[j].getCarBrand().equals(carRequest.getCarBrand())) {
								
								car = officeArray[i].getCarArray()[j];
								araba_indexi=j;
								break;
							}
								
							
						}
							
						
					}
					
					if(employee==null) {
						System.out.println("There is no employee");
						
					}
					if(car==null) {
						System.out.println("Car can not be rented");
						
					}
					
					if((employee != null && car==null)||(employee == null && car!=null)||allowDate==false) {
						
						employee=null;
						car=null;
						allowDate=true;
					
					}
					
					if(employee != null && car!=null && allowDate==true) {
						
						Contract contract = new Contract(contractCount+1, getCustomerArray()[carRequest.getCustomerId()-1], car,employee, carRequest.getStartDate(),carRequest.getEndDate());
						System.out.println("----------------------------------------------------------------------------");
						System.out.println("Contract: " +"Employee"+employee.getEmpId()+";Customer"+contract.getCustomer().getCustomerId()+";Car"+contract.getCar().getCarId()+";"+contract.getStartDate().getCompleteDate()+";"+contract.getEndDate().getCompleteDate());
						System.out.println("----------------------------------------------------------------------------");
						
						addContract(contract);
						contract.setOfficeId(i);
						officeArray[i].getCarArray()[araba_indexi].setRented_count(1);
						contract.getCustomer().setRented_count(1);
						contract.getEmployee().setRented_count(1);
						contractCount++;
						officeArray[i].getCarArray()[araba_indexi].setCarAvaliable(false);
						officeArray[i].getEmployeeArray()[isci_indexi].setAvaliable(false);
						
						employee=null;
						car=null;
						allowDate=true;
						
						
					}
				}
				
				
			}
		}
		else
		{
			for(int i=0; i<officeArray.length; i++) {
				
				if(officeArray[i]!=null) {
					
					for(int j=0;j<officeArray[i].getEmployeeArray().length;j++) {
						
						if(officeArray[i].getEmployeeArray()[j] != null && officeArray[i].getEmployeeArray()[j].getAvaliable() == true) {
							employee = officeArray[i].getEmployeeArray()[j];
							isci_indexi=j;
							break;
						}
						
					}
					
					//Bo� araba kontrol�
					//++ * * belirli
					if(carRequest.getCarBrand().equals("*") && carRequest.getCarModel().equals("*") && !carRequest.getCarClass().equals("*")) {
						
						for(int j=0; j<officeArray[i].getCarArray().length; j++) {
							
							if(officeArray[i].getCarArray()[j]!=null && officeArray[i].getCarArray()[j].getCarUsage()==true && officeArray[i].getCarArray()[j].getCarClass().equals(carRequest.getCarClass()))
							{
								//officeArray[i].getCarArray()[j].setCarAvaliable(false);
								car = officeArray[i].getCarArray()[j];
								araba_indexi=j;
								break;
							}
							
						}
						
					}
					//* belirli belirli
					else if(!carRequest.getCarBrand().equals("*") && carRequest.getCarModel().equals("*") && carRequest.getCarClass().equals("*")) {
						for(int j=0; j<officeArray[i].getCarArray().length; j++) 
						{
							if(officeArray[i].getCarArray()[j]!=null && officeArray[i].getCarArray()[j].getCarUsage()==true &&
									officeArray[i].getCarArray()[j].getCarBrand().equals(carRequest.getCarBrand())) {
								
								car = officeArray[i].getCarArray()[j];
								araba_indexi=j;
								break;
								
							}
								
							
						}
					}
					else if(!carRequest.getCarBrand().equals("*") && /* */ !carRequest.getCarModel().equals("*") && /* */ !carRequest.getCarClass().equals("*")) {
							
						for(int j=0; j<officeArray[i].getCarArray().length; j++) 
						{
							if(officeArray[i].getCarArray()[j]!=null && officeArray[i].getCarArray()[j].getCarUsage()==true &&
									officeArray[i].getCarArray()[j].getCarModel().equals(carRequest.getCarModel()) && 
									officeArray[i].getCarArray()[j].getCarClass().equals(carRequest.getCarClass()) &&
									officeArray[i].getCarArray()[j].getCarBrand().equals(carRequest.getCarBrand())) {
								
								car = officeArray[i].getCarArray()[j];
								araba_indexi=j;
								break;
							}
								
							
						}
					}
					
					if((employee != null && car==null)||(employee == null && car!=null)||allowDate==false) {
						
						employee=null;
						car=null;
						allowDate=true;
						contractMade = false;
					}
					
					if(employee != null && car!=null && allowDate==true) {
						
						Contract contract = new Contract(contractCount+1, getCustomerArray()[carRequest.getCustomerId()-1], car,employee, carRequest.getStartDate(),carRequest.getEndDate());
						System.out.println("----------------------------------------------------------------------------");
						System.out.println("Contract: " +"Employee"+employee.getEmpId()+";Customer"+contract.getCustomer().getCustomerId()+";Car"+contract.getCar().getCarId()+";"+contract.getStartDate().getCompleteDate()+";"+contract.getEndDate().getCompleteDate());
						System.out.println("----------------------------------------------------------------------------");
						
						addContract(contract);
						contract.setOfficeId(i);
						officeArray[i].getCarArray()[araba_indexi].setRented_count(1);
						contract.getCustomer().setRented_count(1);
						contract.getEmployee().setRented_count(1);
						contractCount++;
						officeArray[i].getCarArray()[araba_indexi].setCarAvaliable(false);
						officeArray[i].getEmployeeArray()[isci_indexi].setAvaliable(false);
						contractMade=true;
						
						employee=null;
						car=null;
						allowDate=true;
						
						
						
						break;
					}	
					
				}
				
				if(contractMade==true) {
					break;
				}
			}
			if(contractMade==false) {
				System.out.println("No car avaliable or no employe for the contract");
			}
		}
		
	}
			
		
	public void listCarRequest() {
		for(int i=0; i<carRequestArray.length;i++ ) {
			if(carRequestArray[i]!=null) {
				System.out.println(carRequestArray[i].getRequestId()+".CarRequest;"+carRequestArray[i].getOfficeId()+";"+carRequestArray[i].getCustomerId()+
						carRequestArray[i].getCarBrand()+";"+carRequestArray[i].getCarModel()+";"+carRequestArray[i].getCarClass()+";"+carRequestArray[i].getStartDate().getCompleteDate()+
						";"+carRequestArray[i].getEndDate().getCompleteDate());
			}
		}
	}
		
	public void listContract() {
		for(int i=0;i<contracts.length;i++) {
			
			if(contracts[i]!=null) {
				if (contracts[i].isActive()) {
					System.out.println(contracts[i].getContractId()+":Employee"+contracts[i].getEmployee().getEmpId()+";Customer"+
							contracts[i].getCustomer().getCustomerId()+";Car"+contracts[i].getCar().getCarId()+";"+contracts[i].getStartDate().getCompleteDate()+";"+
							contracts[i].getEndDate().getCompleteDate());
				}
				
			}
			else
				break;
			
		}
	}
	
	public Contract[] getContracts() {
		return contracts;	
	}
	
	public void addContract(Contract contract) {
		contracts[contract_index]=contract;
		contract_index++;
	}
	
	public Office[] getOfficeArray() {
		return officeArray;	
	}

	public Customer[] getCustomerArray() {
		return customerArray;
	}

	public CarRequest[] getCarRequestArray() {
		return carRequestArray;
	}
	
}
