package cars_proje_;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Company cmp = new Company();
		Scanner sc = new Scanner(System.in);
		Date currentDate = new Date(1,1,2021);
		
		int officeId=1;
		int employeeId=1;
		int carId=1;
		int customerId=1;
		int requestId=1;
		
		//README: PROGRAMDA ÇÖZEMEDİĞMİZ BİR HATA MEVCUT ÇOK KÜÇÜK BİR HATA OLMAKLA BERABER ÇOK YOL DENİYORUZ VE HALA BULAMADIK
		//PROGRAM KENDİSİ ÇOK İYİ BİR ŞEKİLDE ÇALIŞIYOR İSTENİLEN İŞLEMLERİ GAYET YERİNDE YAPIYOR FAKAT DOSYADAKİ İNPUTLARI OKURKEN NEDENSE 
		//İLK SATIRDAN BAŞLAMIYOR İKİNCİ SATIRDAN OKUMAYA BAŞLIYOR BU DA 2. OFİSİN ELEMANLARINI SIRALARKEN HATA VERMESİNE SEBEBİYET VERİYOR
		//BU SORUNLA BAYAĞI BİR UĞRAŞTIKTAN SONRA ZAMANIMIZI ÇOK DA ALMASIN PROJEMİZ İLERLEYEBİLSİN DİYE İNPUT DOSYALARINDAKİ SATIRLARI 2. SATIRDAN BAŞLATINCA
		//PROGRAM SORUNSUZ BİR ŞEKİLDE ÇALIŞIYOR ÜZERİNDE HALA ÇALIŞIYORUZ.
		//4. HAFTANIN ORTASINDAYIZ ŞU ANDA PROGRAMDA 1 HAFTA İLERİDEYİZ MÜMKÜN OLDUĞU KADAR KISA SÜREDE PROGRAMI BİTİRİP 
		//TUTABİLDİĞİMİZ KADAR STRES ALTINDA TUTARAK GEREKLİ HATALARI KONTROL ETMEYİ DE DÜŞÜNÜYORUZ
		//BAŞKA BİR ARKADAŞIN BİLGİSAYARINDA PROGRAM DENENDİĞİNDE İLK SATIRDAN OKUYABİLMESİ VE PROGRAMIN SORUNSUZ ÇALIŞMASI DA İLGİNÇ BİR DURUM OLDU
		
		System.out.println("Date: " + currentDate.getCompleteDate());
		while(true) {
			
			
			String input;
			System.out.print(">>>");
			String inputOrRead = sc.nextLine();
			
			String[] ReadOrInput = inputOrRead.split(";"); 
			
			if(ReadOrInput[0].equals("load")) {
				
				BufferedReader reader = new BufferedReader(new FileReader(ReadOrInput[1]));
				
				while((input = reader.readLine()) != null) {
					
					System.out.println(">"+input);
					String[] islem = input.split(";");
					
					if(islem[0].equals("addOffice"))
					{
						Office office = new Office(officeId,islem[1],islem[2],islem[3]);
						cmp.addOffice(office);
						officeId++;
					}
					else if(islem[0].equals("listOffice"))
					{
						cmp.listOffice();
					}
					else if(islem[0].equals("addEmployee"))
					{
						Employee employee = new Employee(employeeId,islem[1],islem[2],islem[3],islem[4],Integer.parseInt(islem[5]));
						cmp.addEmployee(employee, Integer.parseInt(islem[5]));
						employeeId++;
					}
					else if(islem[0].equals("listEmployee")) {
						cmp.listEmployee(Integer.parseInt(islem[1]));
					}
					else if(islem[0].equals("addCar"))
					{
						Car car = new Car(carId,islem[1],islem[2],islem[3],Integer.parseInt(islem[4]),Integer.parseInt(islem[5]),true);
						cmp.addCar(car, Integer.parseInt(islem[5]));
						carId++;
					}
					else if(islem[0].equals("listCar"))
					{
						cmp.listCar(Integer.parseInt(islem[1]));
					}
					else if(islem[0].equals("addCustomer")) {
						Customer customer = new Customer(customerId,islem[1],islem[2]);
						cmp.addCustomer(customer);
						customerId++;
					}
					else if(islem[0].equals("listCustomer")) {
						cmp.listCustomer();
					}
					else if(islem[0].equals("deleteEmployee")) {
						cmp.deleteEmployee(Integer.parseInt(islem[1]),Integer.parseInt(islem[2]));
					}
					else if(islem[0].equals("deleteOffice")) {
						cmp.deleteOffice(Integer.parseInt(islem[1]));
					}
					else if(islem[0].equals("addCarRequest")) {
						if(islem.length==8) {
							String[] startDatetime=islem[6].split("\\.");
							String[] endDatetime = islem[7].split("\\.");
							Date startDate = new Date(Integer.parseInt(startDatetime[0]),Integer.parseInt(startDatetime[1]),Integer.parseInt(startDatetime[2]));
							Date endDate = new Date(Integer.parseInt(endDatetime[0]),Integer.parseInt(endDatetime[1]),Integer.parseInt(endDatetime[2]));
							CarRequest carReq = new CarRequest(requestId,Integer.parseInt(islem[1]),Integer.parseInt(islem[2]),islem[3],islem[4],islem[5],startDate,endDate);
							cmp.addCarRequest(carReq,currentDate);
							requestId++;
						}
						else if(islem.length==7) {
							//rastgele ofis
							String[] startDatetime=islem[5].split("\\.");
							String[] endDatetime = islem[6].split("\\.");
							Date startDate = new Date(Integer.parseInt(startDatetime[0]),Integer.parseInt(startDatetime[1]),Integer.parseInt(startDatetime[2]));
							Date endDate = new Date(Integer.parseInt(endDatetime[0]),Integer.parseInt(endDatetime[1]),Integer.parseInt(endDatetime[2]));
							CarRequest carReq = new CarRequest(requestId,-1,Integer.parseInt(islem[1]),islem[2],islem[3],islem[4],startDate,endDate);
							cmp.addCarRequest(carReq,currentDate);
							requestId++;
						}
						
						
					}
					else if(islem[0].equals("listContract")) {
						cmp.listContract();
					}
					else if(islem[0].equals("listCarRequest")) {
						cmp.listCarRequest();
					}
					
				}
				
			}
			else if(ReadOrInput[0].equals("nextday")) {
				//BURADA PARA GÜN KONTROLÜ VE GEREKLİ İŞLEMLER YAPILACAK (İŞÇİLERİN ÇALIŞMA DURUMLARI GİBİ)
				
				
				
				
				currentDate.nextDay(cmp.getContracts(),cmp.getOfficeArray(),cmp, cmp.getCarRequestArray());
				System.out.println("--- Date: " + currentDate.getCompleteDate()+" ---");
			}
			else {
				
				if(ReadOrInput[0].equals("addOffice"))
				{
					Office office = new Office(officeId,ReadOrInput[1],ReadOrInput[2],ReadOrInput[3]);
					cmp.addOffice(office);
					officeId++;
				}
				else if(ReadOrInput[0].equals("listOffice"))
				{
					cmp.listOffice();
				}
				else if(ReadOrInput[0].equals("addEmployee"))
				{
					Employee employee = new Employee(employeeId,ReadOrInput[1],ReadOrInput[2],ReadOrInput[3],ReadOrInput[4],Integer.parseInt(ReadOrInput[5]));
					cmp.addEmployee(employee, Integer.parseInt(ReadOrInput[5]));
					employeeId++;
				}
				else if(ReadOrInput[0].equals("listEmployee")) {
					cmp.listEmployee(Integer.parseInt(ReadOrInput[1]));
				}
				else if(ReadOrInput[0].equals("addCar"))
				{
					Car car = new Car(carId,ReadOrInput[1],ReadOrInput[2],ReadOrInput[3],Integer.parseInt(ReadOrInput[4]),Integer.parseInt(ReadOrInput[5]),true);
					cmp.addCar(car, Integer.parseInt(ReadOrInput[5]));
					carId++;
				}
				else if(ReadOrInput[0].equals("listCar"))
				{
					cmp.listCar(Integer.parseInt(ReadOrInput[1]));
				}
				else if(ReadOrInput[0].equals("addCustomer")) {
					Customer customer = new Customer(customerId,ReadOrInput[1],ReadOrInput[2]);
					cmp.addCustomer(customer);
					customerId++;
				}
				else if(ReadOrInput[0].equals("listCustomer")) {
					cmp.listCustomer();
				}
				else if(ReadOrInput[0].equals("deleteEmployee")) {
					cmp.deleteEmployee(Integer.parseInt(ReadOrInput[1]),Integer.parseInt(ReadOrInput[2]));
				}
				else if(ReadOrInput[0].equals("deleteOffice")) {
					cmp.deleteOffice(Integer.parseInt(ReadOrInput[1]));
				}
				else if(ReadOrInput[0].equals("addCarRequest")) {
					if(ReadOrInput.length==8) {
						String[] startDatetime=ReadOrInput[6].split("\\.");
						String[] endDatetime = ReadOrInput[7].split("\\.");
						Date startDate = new Date(Integer.parseInt(startDatetime[0]),Integer.parseInt(startDatetime[1]),Integer.parseInt(startDatetime[2]));
						Date endDate = new Date(Integer.parseInt(endDatetime[0]),Integer.parseInt(endDatetime[1]),Integer.parseInt(endDatetime[2]));
						CarRequest carReq = new CarRequest(requestId,Integer.parseInt(ReadOrInput[1]),Integer.parseInt(ReadOrInput[2]),ReadOrInput[3],ReadOrInput[4],ReadOrInput[5],startDate,endDate);
						cmp.addCarRequest(carReq,currentDate);
						requestId++;
					}	
					else if(ReadOrInput.length==7) {
						//rastgele ofis
						String[] startDatetime=ReadOrInput[5].split("\\.");
						String[] endDatetime = ReadOrInput[6].split("\\.");
						Date startDate = new Date(Integer.parseInt(startDatetime[0]),Integer.parseInt(startDatetime[1]),Integer.parseInt(startDatetime[2]));
						Date endDate = new Date(Integer.parseInt(endDatetime[0]),Integer.parseInt(endDatetime[1]),Integer.parseInt(endDatetime[2]));
						CarRequest carReq = new CarRequest(requestId,-1,Integer.parseInt(ReadOrInput[1]),ReadOrInput[2],ReadOrInput[3],ReadOrInput[4],startDate,endDate);
						cmp.addCarRequest(carReq,currentDate);
						requestId++;
					}
					
					
				}
				else if(ReadOrInput[0].equals("listContract")) {
					cmp.listContract();
				}
				else if(ReadOrInput[0].equals("listCarRequest")) {
					cmp.listCarRequest();
				}
			}
			
			
			
			
			
		}
		
		
	}
}
