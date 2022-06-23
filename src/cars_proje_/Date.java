package cars_proje_;

import java.util.Random;

public class Date {
	
	private int day;
	private int month;
	private int year;
	
	
	public Date(int day,int month,int year) {
	
		this.day=day;
		this.month=month;
		this.year=year;
	
	}
	
	public void nextDay(Contract[] cont, Office[] o, Company c, CarRequest[] cr) {
		Random rnd = new Random();
		String line_2 = " ";
		System.out.println("--- Office Profits ---");
		for (int i = 0; i < o.length; i++) {
			boolean isContract = false;
			int incomes = 0;
			int expenses = 100;
			String context = "";
			int emp_count = 0;
			String emp_performance = "";
			int emp_expenses = 0;
			String car_maintenance = "";
			int car_expenses = 0;
			int sum_in = 0;
			int sum_ex = 0;
			if (o[i]!=null) {
				for (int j = 0; j < cont.length; j++) {
					if (cont[j]!=null) {
						if (o[i].getOfficeId()-1==cont[j].getOfficeId() && cont[j].getStartDate().getCompleteDate().equals(getCompleteDate())) {
							if (j!=0) {
								emp_performance+=" + ";
							}
							isContract=true;
							int rnd_km = rnd.nextInt(3)+1;
							if (cont[j].getCar().getCarClass().equalsIgnoreCase("economy")) {
								incomes+=100;
								context+="\n\tCar"+cont[j].getCar().getCarId()+": 100";
								emp_performance+="5";
								emp_expenses+=5;
								car_maintenance+="\n\tCar"+cont[j].getCar().getCarId()+" maintenance: 20 + "+(int)rnd_km*5+" = "+(int)((rnd_km*5)+20)+" ("+rnd_km*100+" km)";
								car_expenses+=20+(rnd_km*5);
							}
							else if (cont[j].getCar().getCarClass().equalsIgnoreCase("sports")) {
								incomes+=200;
								context+="\n\tCar"+cont[j].getCar().getCarId()+": 200";
								emp_performance+="10";
								emp_expenses+=10;
								car_maintenance+="\n\tCar"+cont[j].getCar().getCarId()+" maintenance: 70 + "+(int)rnd_km*10+" = "+(int)((rnd_km*10)+70)+" ("+rnd_km*100+" km)";
								car_expenses+=70+(rnd_km*10);
							}
							else if (cont[j].getCar().getCarClass().equalsIgnoreCase("luxury")) {
								incomes+=300;
								context+="\n\tCar"+cont[j].getCar().getCarId()+": 300";
								emp_performance+="15";
								emp_expenses+=15;
								car_maintenance+="\n\tCar"+cont[j].getCar().getCarId()+" maintenance: 120 + "+(int)rnd_km*15+" = "+(int)((rnd_km*15)+120)+" ("+rnd_km*100+" km)";
								car_expenses+=120+(rnd_km*15);
							}
							cont[j].getCar().setProfit(incomes-car_expenses);
							cont[j].getEmployee().setProfit(incomes, car_expenses);//for line8
							sum_in+=incomes;
							sum_ex+=car_expenses;
							incomes=0;
							car_expenses=0;
						}
					}
					else
						break;
				}
				System.out.println("Office"+o[i].getOfficeId()+" incomes: "+sum_in+" cp"+context);
				
				for (int j = 0; j < o[i].getEmployeeArray().length; j++) {
					if (o[i].getEmployeeArray()[j]!=null)
						emp_count++;
				}
				expenses+=(emp_count*30) + emp_expenses + sum_ex;
				System.out.println("Office"+o[i].getOfficeId()+" expenses: "+expenses+" cp"+"\n\tOffice rent: 100\n\tEmployee salaries: "+emp_count*30);
				if (isContract) {
					System.out.println("\tEmployee performance bonuses: "+emp_performance+" = "+emp_expenses+""+car_maintenance);
				}
				System.out.println("Office"+o[i].getOfficeId()+" profit: "+(sum_in-expenses)+" cp\n");
				
				o[i].setMoney(sum_in-expenses);
				
			}
			else
				break;
		}
		
		System.out.println("--- Office Statistics of the Last 10 Days ----");
		for (int i = 0; i < o.length; i++) {
			String line_1 = "";
			String line_1_1 = "";
			String line_3 = "";
			int most = 0;
			int most2 = 0;
			int most_line3 = 0;
			int[] car_classes_rent = new int[3];
			int[] car_classes_profit = new int[3];
			int isSameCar_index = 0;
			if (o[i]!=null) {
				for (int j = 0; j < o[i].getCarArray().length; j++) {
					if (o[i].getCarArray()[j]!=null) {
						if (o[i].getCarArray()[j].getTotal_renteds()>most) {
							most=o[i].getCarArray()[j].getTotal_renteds();
							line_1="Car"+o[i].getCarArray()[j].getCarId()+";"+o[i].getCarArray()[j].getCarBrand()+";"+o[i].getCarArray()[j].getCarModel();
							isSameCar_index=j;
						}
						if (o[i].getCarArray()[j].getTotal_profits()>most_line3) {
							most_line3=o[i].getCarArray()[j].getTotal_profits();
							line_3="Car"+o[i].getCarArray()[j].getCarId()+";"+o[i].getCarArray()[j].getCarBrand()+";"+o[i].getCarArray()[j].getCarModel();
						}
						if (o[i].getCarArray()[j].getCarClass().equalsIgnoreCase("economy")) {
							car_classes_rent[0]+=o[i].getCarArray()[j].getTotal_renteds(); //for line2
							car_classes_profit[0]+=o[i].getCarArray()[j].getTotal_profits(); //for line4
						}
						else if (o[i].getCarArray()[j].getCarClass().equalsIgnoreCase("sports")) {
							car_classes_rent[1]+=o[i].getCarArray()[j].getTotal_renteds();
							car_classes_profit[1]+=o[i].getCarArray()[j].getTotal_profits();
						}
						else if (o[i].getCarArray()[j].getCarClass().equalsIgnoreCase("luxury")) {
							car_classes_rent[2]+=o[i].getCarArray()[j].getTotal_renteds();
							car_classes_profit[2]+=o[i].getCarArray()[j].getTotal_profits();
						}
					}
					else
						break;
				}
				for (int j = 0; j < o[i].getCarArray().length; j++) {
					if (o[i].getCarArray()[j]!=null) {
						if (o[i].getCarArray()[j].getTotal_renteds()<=most && o[i].getCarArray()[j].getTotal_renteds()>most2 && isSameCar_index!=j) {
							most2=o[i].getCarArray()[j].getTotal_renteds();
							line_1_1=" - Car"+o[i].getCarArray()[j].getCarId()+";"+o[i].getCarArray()[j].getCarBrand()+";"+o[i].getCarArray()[j].getCarModel();
						}
					}
					else
						break;
				}
			}
			else
				break;
			System.out.println("--- Office"+o[i].getOfficeId()+" ---");
			System.out.println("The most rented car: "+line_1+line_1_1);
			
			line_2 = "";
			String line_2_2 = "";
			String line_4 = "";
			most = 0;//yenilerini oluşturmamak için bunları kullanıyorum.
			most2 = 0;
			most_line3 = 0;
			int isSame = 0;
			for (int j = 0; j < car_classes_rent.length; j++) {
				if (car_classes_rent[j]>most) {
					most=car_classes_rent[j];
					if (j==0) 
						line_2="Economy";
					else if (j==1) 
						line_2="Sports";
					else
						line_2="Luxury";
					isSame=j;
				}
				if (car_classes_rent[j]<=most && car_classes_rent[j]>most2 && isSame!=j) {
					most=car_classes_rent[j];
					if (j==0) 
						line_2_2=" - Economy";
					else if (j==1) 
						line_2_2=" - Sports";
					else
						line_2_2=" - Luxury";
				}
				if (car_classes_profit[j]>most_line3) {
					most_line3=car_classes_profit[j];
					if (j==0) 
						line_4="Economy";
					else if (j==1) 
						line_4="Sports";
					else
						line_4="Luxury";
				}
			}
			System.out.println("The most rented car class: "+line_2+line_2_2);
			System.out.println("The car with the highest profit: "+line_3);
			System.out.println("The car class with the highest profit: "+line_4);
			String line_6 = "";
			String line_6_2 = "";
			most = 0;
			most2 = 0;
			isSameCar_index = 0;
			for (int j = 0; j < cont.length; j++) {
				if (cont[j]!=null) {
					if (o[i].getOfficeId()-1==cont[j].getOfficeId()) {
						if (cont[j].getCustomer().getTotal_renteds()>most) { //for line_6
							most=cont[j].getCustomer().getTotal_renteds();
							line_6="Customer"+cont[j].getCustomer().getCustomerId()+";"+cont[j].getCustomer().getCustomerName()+";"+cont[j].getCustomer().getCustomerSurname();
							isSameCar_index=j;
						}
					}
					if (o[i].getOfficeId()-1==cont[j].getOfficeId()) {
						if (cont[j].getCustomer().getTotal_renteds()<=most && cont[j].getCustomer().getTotal_renteds()>most2 && isSameCar_index!=j) { //for line_6
							most2=cont[j].getCustomer().getTotal_renteds();
							line_6_2=" - Customer"+cont[j].getCustomer().getCustomerId()+";"+cont[j].getCustomer().getCustomerName()+";"+cont[j].getCustomer().getCustomerSurname();
						}
					}
				}
				else
					break;
			}
			o[i].getTotal_averages(cont, i, day, month, year);
			System.out.println("The average number of days the cars are rented: "+String.format("%.1f", o[i].getTotal_averages_top10())+" days");//line5
			System.out.println("The customer who rented most: "+line_6+line_6_2);
			String line_7 = "";
			String line_7_2 = "";
			most = 0;
			most2 = 0;
			isSame = 0;
			String line_8 = "";
			int most_line8 = 0;
			int emp_count = 0;
			int sum_line9 = 0;
			for (int j = 0; j < o[i].getEmployeeArray().length; j++) {
				if (o[i].getEmployeeArray()[j]!=null) {
					if (o[i].getEmployeeArray()[j].getTotal_renteds()>most) { // line7
						most=o[i].getEmployeeArray()[j].getTotal_renteds();
						line_7="Employee"+o[i].getEmployeeArray()[j].getEmpId()+";"+o[i].getEmployeeArray()[j].getEmpName()+";"+o[i].getEmployeeArray()[j].getEmpSurname();
						isSame=j;
					}
					if (o[i].getEmployeeArray()[j].getTotal_renteds()<=most && o[i].getEmployeeArray()[j].getTotal_renteds()>most2 && isSame!=j) { // line7
						most2=o[i].getEmployeeArray()[j].getTotal_renteds();
						line_7_2=" - Employee"+o[i].getEmployeeArray()[j].getEmpId()+";"+o[i].getEmployeeArray()[j].getEmpName()+";"+o[i].getEmployeeArray()[j].getEmpSurname();
					}
					if (o[i].getEmployeeArray()[j].getBest_total_profit()>most_line8) {
						most_line8=o[i].getEmployeeArray()[j].getBest_total_profit();
						line_8="Employee"+o[i].getEmployeeArray()[j].getEmpId()+";"+o[i].getEmployeeArray()[j].getEmpName()+";"+o[i].getEmployeeArray()[j].getEmpSurname()+" "+
								o[i].getEmployeeArray()[j].displayProfit();
					}
					sum_line9+=o[i].getEmployeeArray()[j].getTotal_profitables();
					emp_count++;
				}
				else
					break;
			}
			System.out.println("The employee who rented most: "+line_7+line_7_2);
			System.out.println("The most profitable employee: "+line_8);
			String line_9 = sum_line9+"/"+emp_count+" = "+String.valueOf(String.format("%.1f", (double)sum_line9/emp_count))+" cp";
			System.out.println("Average income levels of the employees for the office: "+line_9);
			
			
		}
		System.out.println("----System Recommendations---");
		for (int i = 0; i < o.length; i++) {			
			if(o[i] != null) {
				if ( o[i].GetEmpNumber()==0)
					System.out.println("Close the office " + (i+1) + " as there are no employees");
				for (int j = 0; j < o[i].getEmployeeArray().length; j++) {
					int avaliable_emp = 0;
					if(o[i].getEmployeeArray()[j] != null) {
						if(o[i].getEmployeeArray()[j].getAvaliable() == true)
							avaliable_emp++;
						if(avaliable_emp>=2)
							System.out.println("Fire an employee from the office " + (i+1) + " as there are too few contracts");						
						else if (avaliable_emp==0 && o[i].GetEmpNumber()!=3)
							System.out.println("Hire an employee in the office " + (i+1) + " as there are no free employees");
						break;
					}			
					if (o[i].getMoney()>= 300)
						System.out.println("Open a new office");
				}
				for (int j = 0; j < cr.length; j++) {
					int requestnumber=0;
					if(cr[j] != null) {
						if(cr[j].getOfficeId() == o[i].getOfficeId()) {
							requestnumber++;
						}
						if(requestnumber>5)
							System.out.println("By new car (" + line_2 + ") for the office" + (i+1));
					}
					
				}	
			}
			
		}

		upDay();
		for (int i = 0; i < o.length; i++) {
			if (o[i]!=null) {
				for (int j = 0; j < o[i].getCarArray().length; j++) {
					if (o[i].getCarArray()[j]!=null) {
						o[i].getCarArray()[j].setZero_rented();
						o[i].getCarArray()[j].setZero_profit();
					}
					else
						break;
				}
				for (int j = 0; j < o[i].getEmployeeArray().length; j++) {
					if (o[i].getEmployeeArray()[j]!=null) {
						o[i].getEmployeeArray()[j].setZero_rented();
						o[i].getEmployeeArray()[j].setZero_profit();
					}
					else
						break;
				}
				o[i].setZero_average();
			}
			else
				break;
		}
		for (int i = 0; i < c.getCustomerArray().length; i++) {//company
			if (c.getCustomerArray()[i]!=null) {
				c.getCustomerArray()[i].setZero_rented();
			}
			else
				break;
		}
		
		for (int i = 0; i < o.length; i++) {
			if (o[i]!=null) {
				for (int j = 0; j < cont.length; j++) {
					if (cont[j]!=null) {
						int car_id = cont[j].getCar().getCarId();
						int emp_id= cont[j].getEmployee().getEmpId();
						if (o[i].getOfficeId()-1==cont[j].getOfficeId() && cont[j].getEndDate().getCompleteDate().equals(getCompleteDate())) {
							for (int j2 = 0; j2 < o[i].getCarArray().length; j2++) {
								if (o[i].getCarArray()[j2]!=null) {
									if (o[i].getCarArray()[j2].getCarId()==car_id) {
										o[i].getCarArray()[j2].setCarAvaliable(true);
									}
								}
								else
									break;
							}
							for (int k = 0; k < o[i].getEmployeeArray().length; k++) {
								if (o[i].getEmployeeArray()[k]!=null) {
									if (o[i].getEmployeeArray()[k].getEmpId()==emp_id) {
										o[i].getEmployeeArray()[k].setAvaliable(true);
									}
								}
								else
									break;
							}
							cont[j].setActive(false);
						}
					}
					else
						break;
				}
			}
			else
				break;
		}
		
	}

	public int getDay() {
		return day;
	}


	public int getMonth() {
		return month;
	}


	public int getYear() {
		return year;
	}
	
	
	public String getCompleteDate() {
		return day+"/"+month+"/"+year;	
	}
	
	public void upDay() {
		switch (month) {
		case 1,3,5,7,8,10,12:
			if (day==31) {
				month++;
				day=0;
			}
			if (month==12 && day==31) {
				month=1;
				day=0;
				year++;
			}
			break;
		case 2:
			if (year%4==0 && day==29) {
				month++;
				day=0;
			}
			else if (!(year%4==0) && day==28) {
				month++;
				day=0;
			}
			break;
		case 4,6,9,11:
			if (day==30) {
				month++;
				day=0;
			}
			break;
		default:
			break;
		}
		
		if (top10%9==0 && top10!=0)
			top10=-1;
			
		day++;
		top10++;
	}
	public static int top10 = 0;
	
	
	
}
