import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinerTrialFood{
	public static void main(String[] args) throws FileNotFoundException{
		double foodPrice = 0.0; //This initilalized variables for future things
		int tipOpt = 0;
		int cartItems = 0;
		int clearItems = 0;
		int clearTotal = 0;
		double tax = 0;
		Scanner scanner = new Scanner(System.in);
		double total = 0;
		System.out.println("----Welcome to MinerEats----");
		boolean isLoggedIn = true;
		
		while(isLoggedIn){
			System.out.println("------------ MENU ----------"); //This gives the choices
			System.out.println("Choose an option from (1-5):");
			System.out.println("1)Add a food\n2)View Cart\n3)Clear Cart\n4)Checkout\n5)Exit");
			int menuOption = scanner.nextInt();
			switch(menuOption){
				case 1:
					System.out.println("1)Add Food");
					try {
						File menu = new File("Food.txt"); //This reads the file and prints out what the file has in store
						Scanner myReader = new Scanner(menu);
						while (myReader.hasNextLine()){
							String data = myReader.nextLine();
							System.out.println(data);
						}
						myReader = new Scanner(menu);
						scanner.nextLine();
						System.out.println("Food choice?"); 
						String foodChoice = scanner.nextLine();
					
						while(myReader.hasNextLine()){
							String userChoice = myReader.next();
							foodPrice = myReader.nextDouble(); //this reads the next string or next decimal number
							if(userChoice.equals(foodChoice)){
								System.out.println("Food Quantity?");
								int foodQuant = scanner.nextInt();
								cartItems += foodQuant;
								total += (foodPrice * foodQuant);
								System.out.println("Your total = " + total);

							}
						}



					} catch (FileNotFoundException e) {
						System.out.println("An Error has Ocurred.");
						e.printStackTrace();
					}
				break;	
				case 2:
					System.out.println("2) View Cart");
					System.out.println("Cart items = "+ cartItems); 
					System.out.println("Total = "+ total);
				break;	
				case 3:
					System.out.println("3) Clear Cart");
					System.out.println("Your cart has been cleared");
					System.out.println("Total items = " + clearItems);
					System.out.println("Total = " + clearTotal);
					clearItems = 0; //helps reset the value back to 0
					clearTotal = 0;
				break;	
				case 4:
					System.out.println("4) Checkout");
					System.out.println("Pick from below");
					System.out.println("1) Pickup  2)Delivery");
					int pickOpt = scanner.nextInt();
					if(pickOpt == 1){
						System.out.println("Order information");
						total += (0.0725) * total;
						System.out.println("Number of items :" + cartItems);
						System.out.println("Total :" + total);
						System.out.println("Enter 16 digit card number to complete order :");
						String creditCard = scanner.next();
						System.out.println(creditCard); //this checks if the card is a valid number without any characters
						if(creditCard.length()==16){
							for(int i = 0; i < creditCard.length(); i++){
								if(!(creditCard.charAt(i)>= '0' &&(creditCard.charAt(i)<= '9'))){ // putting a range from 0,9 char just like acci
									System.out.println("Credit card invalid");
									break;
								}
								if(i == creditCard.length()){ //this prints out the int on credit card
									System.out.println(creditCard);
								}
							}
							System.out.println("Success!  Thank you for shopping at Miner Eats!");
							System.out.println("----------- Reciept ---------");
						}
						

						isLoggedIn = false; //this helps end the loop for sop the menu
					}else if (pickOpt == 2){
						total += 5;
						System.out.println("Theres a $5 delivery fee");
						System.out.println("Please enter address");
						String address = scanner.next();
						System.out.println("Would you like to add a tip?");
						System.out.println("1) Yes  2) No");
						tipOpt = scanner.nextInt();
						if(tipOpt==1){
							System.out.println("Order information");
							System.out.println("Number of items = " + cartItems);
							System.out.println("Total = " + total);
							total = (total*.1) + total;
							System.out.println("Address : " + address);
							scanner.nextLine();
							System.out.println("Enter 16 digit card number to complete order :");
							String creditCard = scanner.next();
							System.out.println(creditCard);
							if(creditCard.length()==16){
								for(int i = 0; i < creditCard.length(); i++){
									if(!(creditCard.charAt(i)>= '0' &&(creditCard.charAt(i)<= '9'))){
										System.out.println("Credit card invalid");
										break;
									}
									if(i == creditCard.length()){
										System.out.println(creditCard);
									}
								
								}
							}
							System.out.println("Success!  Thank you for shopping at Miner Eats!");
							System.out.println("----------- Reciept ---------");
							isLoggedIn = false;
						}
						if(tipOpt ==2){
						System.out.println("Proceed");
						}
						System.out.println("Success!  Thank you for shopping at Miner Eats!");
						System.out.println("----------- Reciept ---------");
						isLoggedIn = false;
					}
				break;				
				case 5:
					System.out.println("5) Exit");
					System.out.println("Ending Program");
					isLoggedIn = false;
					break;	
								
				
			
			}				
		} 
	}
}	
							 
						
								
							 						
			

						
						
							
						
				