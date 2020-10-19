package part2;
import java.util.*;
//-------------------------------------------------
//Assignment 1
//© Jenish Soni
//written by: Jenish Soni(40132415)
//-------------------------------------------------
public class mainClass{
	static Scanner scan = new Scanner(System.in);
	static long newComps = 0;
	static long pointer = 0;
//Following is the static class Computer which works for both part 1 and part 2 of the assignment1-part2.
	static class Computer {
		private String brand;
		private String model;
		private long SN;
		private double price;
		private static String password;
		private static int counter = 0;
		static List<List<Object>> data = new ArrayList<>();

		//This method is responsible to return all the Computer Objects.
		public static List<List<Object>> getMaster(){
			return data;
		}
		
		//This method is responsible to set the List of lists of objects. 
		public static void setMaster(List<List<Object>> master) {
			data = master;
		}
		
		//This is the default constructor called when we create an object in the partOne.java file.
 		public Computer() {
			brand = "";
			model = "";
			SN = 0;
			price = 0.0;
		}
		
 		//This is the parameterized constructor explicitly called to pass the computer objects.
		public Computer(String brand, String model, long SN, double price) {
			this.brand = brand;
			this.model = model;
			this.SN = SN;
			this.price = price;
			List<Object> newData = new ArrayList<>();
			newData.add(brand);
			newData.add(model);
			newData.add(SN);
			newData.add(price);
			data.add(newData);
			counter += 1;
		}
		//This method is responsible to find the total number of computer objects created. 
		public int findNumberOfCreatedComputers() {
			return counter;
		}
		
		//This method is responsible to return a boolean value depending upon the type of objects passed in the method.
		public boolean areAttributesEqual(Computer c1, Computer c2) {
			return c1.brand.equals(c2.brand) && c1.model.equals(c2.model) && c1.price == c2.price;
		}
		
		//This method is responsible for the same purpose as above.
		public boolean areEqualObjects(Computer c1, Computer c2) {
			return areAttributesEqual(c1, c2);
		}
		
		//This method returns all the attributes' data of a computer object if not null. 
		public String getAllData() {
			return ("Brand: " + brand + " Model: " + model + "Serial Number: " + SN + " Price: " + price);
		}
		
		//This method is responsible to set the brand.
		public void setBrand(int index, String brand) {
			this.brand = brand;
		}
		
		//This method is responsible to return brand.
		public static String getBrand(int index) {
			return (String) data.get(index).get(0);
		}
		
		//This method is responsible to set the model.
		public void setModel(String model) {
			this.model = model;
		}
		
		//This method is responsible to return model.
		public static String getModel(int index) {
			return (String) data.get(index).get(1);
		}
		
		//This method is responsible to set the serial number.
		public void setSN(long SN) {
			this.SN = SN;
		}
		
		//This method is responsible to return serial number.
		public static long getSN(int index) {
			return (long) data.get(index).get(2);
		}
		
		//This method is responsible to set the price.
		public void setPrice(double price) {
			this.price = price;
		}
		
		//This method is responsible to return price.
		public static double getPrice(int index) {
			return (double) data.get(index).get(3);
		}
		
		//This static method is used to check for the password when the user selects option 1 or 2. 
		//The same thing could easily be done without a static method but we have tried to make this project as real as possible.
		public static String getPassword() {
			password = "password";
			return password;
		}

	}
	
	//The main method starts the infinite loop for the part2 of the assignment1-part2. 
	public static void main(String[] args) {
		starter();
		scan.close();
	}
	
	
	//This is the meat of the program which runs the actual implementation of the code. 
	public static void starter() {
		System.out.println("===========Welcome to the Store!==========\n");
		System.out.println("Please enter the maximum number of computers your store can contain:");
		String size = "";
		long maxCapacity = 0;
		//This infinite loop is because if the proper input is not entered for the size of the store, the program may crash immediately without even running. 
		//Therefore, it is ensured that the program do not crashes. 
		while(true) {
			System.out.print("Enter size: ");
			size = scan.next();
			try {
				maxCapacity = Long.parseLong(size);
			}catch(Exception e) {
				System.out.println("Please enter an Integer or a Long value.");
				continue;
			}
			if(maxCapacity < 0) {
				System.out.println("Please enter a valid size.\n");
				continue;
			}
			break;
		}
		long[] inventory = new long[(int) maxCapacity];
		pointer = maxCapacity;
		Arrays.fill(inventory, -1);
		//The main code starts from here, you'll be watching this on the console after you enter an int value. 
		while(true) {
			System.out.println("What do you want to do?");
			System.out.println("1. Enter new Computers (password required).");
			System.out.println("2. Change information of a computer (password required).");
			System.out.println("3. Display all computers  by a specific brand.");
			System.out.println("4. Display all computers under a specific price.");
			System.out.println("5. Quit\n");
			
			System.out.print("Please enter your choice>");
			String input = scan.next();
			int choice = 0;
			try {
				choice = Integer.parseInt(input);
			}catch(Exception e) {
				System.out.println("type: Please enter a valid number between 1 and 5 inclusive.");
				continue;
			}
			if(choice < 1 || choice > 5) {
				System.out.println("Please enter a valid number between 1 and 5 inclusive.");
				continue;
			}
			
			//The below switch statement is used for the different options selected by the user.
			switch(choice) {
			case 1:
				int count = 3;
				option1(count, pointer);
				continue;
			case 2: 
				//A couple of variables and pointers to keep track of the false passwords entered and values modified (boolean flags).
				count = 3;
				boolean flag = false;
				while(count > 0) {
					if(count <= 0) {
						break;
					}
					System.out.print("Enter the password to continue: ");
					scan.nextLine();
					String password = scan.next();
					count -= 1;
					if(password.equals(Computer.getPassword())) {
						int indexToModify = -1;
						while(true) {
							System.out.print("Enter the index you want to modify: ");
							try{
								indexToModify = scan.nextInt();
							}catch(Exception e) {
								scan.nextLine();
								System.out.println("Please enter valid Integer or Long values.");
								continue;
							}
							break;
						}
						if(indexToModify >= Computer.getMaster().size()) {
							System.out.println("I am afraid the computer you are looking for is beyond the size of your store.");
						}
						else if(indexToModify < 0 && indexToModify >= Computer.getMaster().size()) {
							System.out.println("data: " + Computer.getMaster().toString());
							System.out.println("This computer has no valid data yet.");
							System.out.println("Do you want to try again to retrieve the data?(y/n)");
							String response = scan.next();
							scan.next();
							if(response.equalsIgnoreCase("y")) {
								while(true) {
									System.out.print("Enter the index you want to modify: ");
									try{
										indexToModify = scan.nextInt();
									}catch(Exception e) {
										System.out.println("Please enter valid Integer or Long values.");
										continue;
									}
									break;
								}
								if(indexToModify >= inventory.length) {
									System.out.println("I am afraid the computer you are looking for is beyond the size of your store.");
								}
								if(inventory[indexToModify] == 0) {
									System.out.println("This computer has no valid data yet.");
								}
							}
						}
						else {
							System.out.println("Computer #" + indexToModify);
							System.out.println("Brand: " + Computer.getBrand(indexToModify));
							System.out.println("Model: " + Computer.getModel(indexToModify));
							System.out.println("SN: " + Computer.getSN(indexToModify));
							System.out.println("Price: $" + Computer.getPrice(indexToModify));
							//The below infinite while loop is for the option 2. As long as user enters values within 1-4 the values will change.
							//AFter clicking 5 this specific loop ends. 
							//This snippet would allow 3 illegal choices other than 1-5. 
							//Then, it will return to the main menu of the code. 
							while(true) {
								System.out.println("What information would you like to change?");
								System.out.println("1. Brand");
								System.out.println("2. Model");
								System.out.println("3. SN");
								System.out.println("4. Price");
								System.out.println("5. Quit");
								System.out.print("Enter your choice>");
								String response = scan.next();
								int opt = 0;
								try {
									opt = Integer.parseInt(response);
								}catch(Exception e) {
									System.out.println("Please enter a valid integer input number.");
								}
								if(opt > 5 || opt <= 0) {
									System.out.println("Enter a valid number between 1 and 5 inclusive.");
									break;
								}
								else {
									switch(opt) {
									case 1:
										System.out.print("Enter new Brand: ");
										String newBrand = scan.next();
										List<List<Object>> data = Computer.getMaster();
										List<Object> objectToModify = data.get(indexToModify);
										data.remove(indexToModify);
										objectToModify.set(0, newBrand);
										data.add(indexToModify, objectToModify);
										Computer.setMaster(data);
										System.out.println("Computer #" + indexToModify);
										System.out.println("Brand: " + objectToModify.get(0));
										System.out.println("Model: " + objectToModify.get(1));
										System.out.println("SN: " + objectToModify.get(2));
										System.out.println("Price: $" + objectToModify.get(3));
										break;
										
									case 2:
										System.out.print("Enter the new Model: ");
										String newModel = scan.next();
										data = Computer.getMaster();
										objectToModify = data.get(indexToModify);
										data.remove(indexToModify);
										objectToModify.set(1, newModel);
										data.add(indexToModify, objectToModify);
										Computer.setMaster(data);
										System.out.println("Computer #" + indexToModify);
										System.out.println("Brand: " + objectToModify.get(0));
										System.out.println("Model: " + objectToModify.get(1));
										System.out.println("SN: " + objectToModify.get(2));
										System.out.println("Price: $" + objectToModify.get(3));
										break;
										
									case 3:
										long SN = -1;
										while(true) {
											System.out.print("Enter the new SN: ");
											try{
												SN = scan.nextLong();
											}catch(Exception e) {
												scan.nextLine();
												System.out.println("Please enter valid Integer or Long values.");
												continue;
											}
											break;
										}
										data = Computer.getMaster();
										objectToModify = data.get(indexToModify);
										data.remove(indexToModify);
										objectToModify.set(2, SN);
										data.add(indexToModify, objectToModify);
										Computer.setMaster(data);
										System.out.println("Computer #" + indexToModify);
										System.out.println("Brand: " + objectToModify.get(0));
										System.out.println("Model: " + objectToModify.get(1));
										System.out.println("SN: " + objectToModify.get(2));
										System.out.println("Price: $" + objectToModify.get(3));
										break;
										
									case 4:
										double price = -1;
										while(true) {
											System.out.print("Enter the new Price: ");
											try{
												price = scan.nextLong();
											}catch(Exception e) {
												scan.nextLine();
												System.out.println("Please enter valid Integer or Long values.");
												continue;
											}
											break;
										}
										data = Computer.getMaster();
										objectToModify = data.get(indexToModify);
										data.remove(indexToModify);
										objectToModify.set(3, price);
										data.add(indexToModify, objectToModify);
										Computer.setMaster(data);
										System.out.println("Computer #" + indexToModify);
										System.out.println("Brand: " + objectToModify.get(0));
										System.out.println("Model: " + objectToModify.get(1));
										System.out.println("SN: " + objectToModify.get(2));
										System.out.println("Price: $" + objectToModify.get(3));
										break;
									case 5:
										flag = true;
										break;
									}
									if(flag) break;
								}
								if(flag) break;
							}	
							if(flag) break;
						}
						if(flag) break;
					}
					else {
						System.out.println("The password you entered does not match with the system.");
						System.out.println("Please try again, you have " + count + " tries left.");
					}
				}
				continue;
			//This is the implementation of the option 3 of the  main menu where, if the correct brand is entered, all computer objects with...
			// that brand name are displayed. Else nothing is displayed. 
			case 3:
				System.out.print("Enter the brand name to search: ");
				String searchByBrand = scan.next();
				List<List<Object>> data = Computer.getMaster();
				int counter = 0;
				for(List<Object> computer: data) {
					if(computer.get(0).equals(searchByBrand)) {
						System.out.println("Computer #" + counter);
						System.out.println("Brand: " + computer.get(0));
						System.out.println("Model: " + computer.get(1));
						System.out.println("SN: " + computer.get(2));
						System.out.println("Price: $" + computer.get(3));
						System.out.println();
					}
				}
				continue;
			//After entering an integer value, all the computer objects having the price attribute less than the entered price will be displayed on the console. 
			case 4:
				double price = -1;
				while(true) {
					System.out.print("Enter the value (price): ");
					try{
						price = scan.nextLong();
					}catch(Exception e) {
						System.out.println("Please enter valid Integer or Long values.");
						scan.nextLine();
						continue;
					}
					break;
				}
				data = Computer.getMaster();
				counter = 0;
				for(List<Object> computer: data) {
					if((double) computer.get(3) < price) {
						System.out.println("Computer #" + counter++);
						System.out.println("Brand: " + computer.get(0));
						System.out.println("Model: " + computer.get(1));
						System.out.println("SN: " + computer.get(2));
						System.out.println("Price: $" + computer.get(3));
						System.out.println();
					}
				}
				continue;
			//The below case is for terminating the code. 
			case 5:
				System.out.println("See you again.");
				break;
			}
			break;
		}
	}
	
	
	//This method is responsible for executing the method one. 
	//Since this method is a bit involved, so is the reason I have used a separate static method for the execution. 
	public static void option1(int count, long pointer) {
		if(count <= 0) {
			System.out.println("You have entered the password incorrect for 3 times. Returning to the main menu.");
			return;
		}
		System.out.print("Enter the password to continue: ");
		String password = scan.next();
		if(!password.equals(Computer.getPassword())) {
			count -= 1;
			System.out.println("Incorrect password! " + count + " more tries left.");
			option1(count, pointer);
			return;
		}
		while(true) {
			System.out.print("Enter the number of computer you want to enter: ");
			String input = "";
			input = scan.next();
			try {
				newComps = Long.parseLong(input);
			}catch(Exception e) {
				System.out.println("Please enter valid Integer or Long values.");
				continue;
			}
			break;
		}
		
		if(newComps <= pointer) {
			pointer -= newComps;
			for(int i = 0; i < newComps; i++) {
				System.out.print("Enter the brand for computer #" + (i + 1) + ": ");
				String brand = scan.next();
				System.out.print("Enter the model for computer #" + (i + 1) + ": ");
				String model = scan.next();
				System.out.print("Enter the SN for computer #" + (i + 1) + ": ");
				long SN;
				try {
					SN = scan.nextLong();
				}catch(Exception e) {
					System.out.println("Please enter valid Integer or Long values.");
					i--;
					continue;
				}
				System.out.print("Enter the price for computer #" + (i + 1) + ": ");
				double price;
				try {
					price = scan.nextDouble();
				}catch(Exception e) {
					System.out.println("Please enter valid Integer or Long values.");
					i--;
					continue;
				}
				@SuppressWarnings("unused")
				Computer newObj = new Computer(brand, model, SN, price);
				pointer -= 1;
				decrementPointer();
			}
		}else {
			System.out.println("Sorry, the current capacity of your system is " + pointer);
		}
	}
	
	public static void decrementPointer() {
		pointer -= 1;
	}
}

