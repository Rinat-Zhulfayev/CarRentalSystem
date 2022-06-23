# CarRentalSystem
System for managing Car Rental Company

General Information
The system simulates a car rental company keeping the track of offices, employees, customers, cars and other necessary structures. In the simulation, 
all activities are daily based and simulation money unit is cp.

Company 
DEUCENG Car Rental Company rents cars for short periods of time ranging from 1 to 4 days. Cars are rented on daily basis. At the end of rental duration, 
cars are returned with the same amount of fuel. Rental car fees are taken from customer's credit card on daily basis. There is no car sale, they can only be rented. 

Office
The company has several offices. Each office has their unique ID, phone number, address. Each office has its employees and cars. Maximum 3 employees can work 
in an office. New offices can be set up or the current ones can be closed over time. 

Employee
Each employee has his/her unique ID, name, surname, gender, and birthdate. Each one can make a maximum of 1 contract per day. The company should pay 
compensation (200 cp) to employees whose employment has been terminated.

Car
Each car has its unique ID, brand, model, class (economy/sports/luxury), kilometers (on the basis of 100 km and its multiples). 
The rents of the cars are 100, 200 or 300 cp according to the car classes, economy, sports or luxury, respectively.

Customer
Each customer has his/her unique ID, name, surname. Customers request cars from the company.

Car Request
Customer's car requests have their unique ID, brand, model, class (economy/sports/luxury), rental start/end date. If there is no specific demand 
for an attribute, the symbol "*" is used for brand or model.

Contract
Accepted car requests turns into a contract. Each contract has its unique ID, customer ID, car ID, rental start/end date.

The car rental system starts on 1.1.2021. System uses auto-increment IDs for all items starting from 1. System can take commands from a file or command line. 
System waits for commands from the command line after finishing all file commands. System shows ">>>" before command line commands, shows ">" before file commands.

The number of car requests per day is at least 1, at most 7 (when it is random). Office and employee are randomly selected for the car requests if 
not determined. If the request is met, a contract is prepared, otherwise it will be canceled. Car request's start day is always the current day.
