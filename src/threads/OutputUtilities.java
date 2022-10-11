package threads;

import java.util.ArrayList;
import java.util.Scanner;

import data.Data;
import models.*;

public class OutputUtilities implements Runnable{

	boolean isRunning;
	Scanner in = new Scanner(System.in);

	private String getName(ArrayList<Customer> customers, int idx) {
		if(customers.isEmpty() || customers.size() - 1 < idx)
			return "-";
		else
			return "Customer " + customers.get(idx).getId().toString();
	}
	
	private String getPatience(ArrayList<Customer> customers, int idx) {
		if(customers.isEmpty() || customers.size() - 1 < idx)
			return "-";
		else
			return customers.get(idx).patience.toString();
	}
	
	private String getOrder(ArrayList<Customer> customers, int idx) {
		if(customers.isEmpty() || customers.size() - 1 < idx)
			return "-";
		else {
			Order o = customers.get(idx).getOrder();
			
			if(o instanceof Food) {
				return "Food - " + o.getName();
			}
			
			else if(o instanceof Beverage) {
				return "Beverage - " + o.getName();
			}
			
			else {
				return "Dessert - " + o.getName();
			}
		}
			
	}
	
	private String getCourierIndex(ArrayList<Customer> customers, int idx) {
		if(customers.isEmpty() || customers.size() - 1 < idx)
			return "-";
		return customers.get(idx).courier != null ? "Courier " + new Integer(idx + 1).toString() : "-";
	}
	
	
	private String getCourierState(ArrayList<Customer> customers, int idx) {
		if(customers.isEmpty() || customers.size() - 1 < idx)
			return "-";
		return customers.get(idx).courier != null ? 
				(customers.get(idx).courier.status.equals("C") ?
						customers.get(idx).courier.collectingState() : 
							customers.get(idx).courier.deliveringState())
				: "-";
	}
	
	@Override
	public void run() {
		isRunning = true;
		while(isRunning) {
			if(Data.getInMain())
				printMenu();
			else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private String getCookIndex(ArrayList<Prepare> cook, int idx) {
		if(cook.isEmpty() || cook.size() - 1 < idx)
			return "-";
		else
			return "Order " + (idx + 1);
	}
	
	private String getCookRemaining(ArrayList<Prepare> cook, int idx) {
		if(cook.isEmpty() || cook.size() - 1 < idx)
			return "";
		else
			return "("+ cook.get(idx).getTime_remaining() +"s)";
	}
	
	private String getCookOrder(ArrayList<Prepare> cook, int idx) {
		if(cook.isEmpty() || cook.size() - 1 < idx)
			return "-";
		else 
			return cook.get(idx).getOrder().getName();
	}
	
	public static void orderDoesntMatch() {
		for(int i = 0; i < 50 ;i++)
			System.out.println("");
		System.out.println("\tThe Order doesn't match ...");
		System.out.println("\tPress enter continue ...");
	}
	
	public void printMenu() {
		
		for(int i = 0; i < 50 ;i++)
			System.out.println("");
		
		ArrayList<Customer> customers = Data.getCustomers();
		ArrayList<Prepare> cook = Data.cook;
		
		System.out.println("\tGame Timer : " + Data.timer);
		System.out.println("\tTotal Money Earned : IDR " + Data.totalMoneyEarned);
		
		
		System.out.println("");
		
		for(int i = 0;i < 3;i++) { 
			System.out.printf("\t%-34s (%-2ss) | "
					,getName(customers,i)
					,getPatience(customers,i)
				);
			
		}
		
		System.out.println("");
		
		System.out.print("\t");
		for(int j = 0; j < 138;j++)
			System.out.print("-");
		
		System.out.println("");
		
		for(int i = 0;i < 3;i++) {
			System.out.printf("\t%-40s | "
					,getOrder(customers,i)
				);
		}
		
		System.out.println("\n\n\tKitchen");
		
		
		for(int i = 0;i < 3;i++) {
			
			
			System.out.printf("\t%-34s %-5s | "
					,getCookIndex(cook, i)
					,getCookRemaining(cook, i)
				);
		}
		System.out.print("\n");
		System.out.print("\t");
		
		for(int j = 0; j < 138;j++)
			System.out.print("-");
		System.out.print("\n");
		
		for(int i = 0;i < 3;i++) {
			
			
			System.out.printf("\t%-40s | "
					,getCookOrder(cook, i)
				);
		}
		
		System.out.println("\n\n\tCourier");
		
		
		for(int i = 0;i < 3;i++) {
			System.out.printf("\t%-40s | "
					,getCourierIndex(customers,i)
				);
		}
		System.out.print("\n\t");
		
		for(int j = 0; j < 138;j++)
			System.out.print("-");
		System.out.print("\n");
		
		for(int i = 0;i < 3;i++) {
			System.out.printf("\t%-40s | "
					,getCourierState(customers, i)	
				);
		}
		
		System.out.printf("\n\n\t%-20s %-20s %-20s\n", "[P] Prepare Food","[A] Assign Courier","[E] Exit Game");
		System.out.print("\t>> ");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static int showCustomers() {
		
		
		for(int i = 0; i < 50 ;i++)
			System.out.println("");
		
		System.out.println("\tSelect Customer");
		System.out.print("\t");
		for(int j = 0; j < 35;j++)
			System.out.print("-");
		
		ArrayList<Customer> clist = Data.getCustomers();
		int idx = 1;
		
		
		System.out.println("");
		
		for (Customer customer : clist) {
			System.out.printf("\t| "+idx++ + ". %-28s "+ "|\n", ("Customer" + customer.getId()));
		}
		System.out.print("\t");
		for(int j = 0; j < 35;j++)
			System.out.print("-");
		
		System.out.println("\n\n\t[0] Back");
		System.out.print("\t>>");
		
		
		return idx - 1;
	}
	
	public static void showReady() {
		for(int i = 0; i < 50 ;i++)
			System.out.println("");
		
		System.out.println("\tOrders Ready to Serve");
		System.out.print("\t");
		for(int j = 0; j < 50;j++)
			System.out.print("-");
		
		System.out.println("");
		
		System.out.printf("\t| No |  %-40s |", "Order Name");
		System.out.println("");
		
		
		int idx = 1;
		for (Order o : Data.ready) {
			System.out.printf("\t| %-2d |  %-40s |\n",idx++, o.getName());
		}
		
		System.out.print("\t");
		for(int j = 0; j < 50;j++)
			System.out.print("-");
		
		System.out.println("\n\n\t[0] Back");
		System.out.print("\t>> ");
	}
	
	public static void showMenu() {
		for(int i = 0; i < 50 ;i++)
			System.out.println("");
		System.out.println("\tPrepare Orders");
		System.out.print("\t");
		for(int j = 0; j < 40;j++)
			System.out.print("-");
		
		System.out.println("");
		
		System.out.println("\t1. Food");
		System.out.println("\t2. Beverage");
		System.out.println("\t3. Dessert");
		
		System.out.println("\n\t[0] Back");
		System.out.print("\t>> ");
	}
	
	public static int showFood() {
		for(int i = 0; i < 50 ;i++)
			System.out.println("");
		System.out.println("\tFoods Menu");
		System.out.print("\t");
		for(int j = 0; j < 88;j++)
			System.out.print("-");
		
		System.out.println("");
		
		System.out.printf("\t| No |  %-30s |  %-12s |  %-12s |  %-12s |", "Food Name", "Price", "Type", "Frozen");
		System.out.print("\n\t");
		
		for(int j = 0; j < 88;j++)
			System.out.print("-");
		
		System.out.println("");
		
		int idx = 1;
		for(Order o :Data.kitchen) {
			if(o instanceof Food) {
				System.out.printf("\t| %-2d |  %-30s |  %-12s |  %-12s |  %-12s |\n",idx++, o.getName(),"IDR "+ o.getPrice(), ((Food) o).getType(),
						(((Food) o).getIsFrozen() ? "Yes" : "No"));
			}
		}
		System.out.print("\t");
		
		for(int j = 0; j < 88;j++)
			System.out.print("-");
		
		System.out.println("\n\n\t[0] Back");
		System.out.print("\t>> ");
		
		return idx - 1;
	}

	public static int showBeverage() {
		for(int i = 0; i < 50 ;i++)
			System.out.println("");
		System.out.println("\tBeverage Menu");
		System.out.print("\t");
		for(int j = 0; j < 64;j++)
			System.out.print("-");
		
		System.out.println("");
		
		System.out.printf("\t| No |  %-30s |  %-12s |  %-4s |", "Beverage Name", "Price", "Size");
		System.out.print("\n\t");
		
		for(int j = 0; j < 64;j++)
			System.out.print("-");
		
		System.out.println("");
		
		int idx = 1;
		for(Order o :Data.kitchen) {
			if(o instanceof Beverage) {
				System.out.printf("\t| %-2d |  %-30s |  %-12s |  %-4s |\n",idx++, o.getName(),"IDR "+ o.getPrice(), ((Beverage) o).getSize());
			}
		}
		System.out.print("\t");
		
		for(int j = 0; j < 64;j++)
			System.out.print("-");
		
		System.out.println("\n\n\t[0] Back");
		System.out.print("\t>> ");
		
		return idx - 1;
	}


	public static int showDessert() {
		for(int i = 0; i < 50 ;i++)
			System.out.println("");
		System.out.println("\tDessert Menu");
		System.out.print("\t");
		for(int j = 0; j < 80;j++)
			System.out.print("-");
		
		System.out.println("");
		
		System.out.printf("\t| No |  %-30s |  %-12s |  %-20s |", "Dessert Name", "Price", "Has High Calories");
		System.out.println("");
		System.out.print("\t");
		for(int j = 0; j < 80;j++)
			System.out.print("-");
		
		System.out.println("");
		
		int idx = 1;
		for(Order o :Data.kitchen) {
			if(o instanceof Dessert) {
				System.out.printf("\t| %-2d |  %-30s |  %-12s |  %-20s |\n",idx++, o.getName(),"IDR "+ o.getPrice(),((Dessert) o).getHasHighCalories() ? "Yes" : "No" );
			}
		}
		System.out.print("\t");
		
		for(int j = 0; j < 80;j++)
			System.out.print("-");
		
		System.out.println("\n\n\t[0] Back");
		System.out.print("\t>> ");
		
		return idx - 1;
	}
	
	public static void exitLogo() {
		
		for(int i = 0; i < 50 ;i++)
			System.out.println("");
		
		System.out.println("\t\r\n" + 
				"\t\r\n" + 
				"\t                                  .......,*...                                  \r\n" + 
				"\t                           ......&..........,%&&&*&.......                      \r\n" + 
				"\t                         ...%.,.../(..&/,     .....,..(..,*....                 \r\n" + 
				"\t                      ..#,......#*,..............   ..../%.....                 \r\n" + 
				"\t                   .,/(.....(, .*....................  ...*                     \r\n" + 
				"\t                  .,#,...,,. .........................  ,...% .                 \r\n" + 
				"\t              ...&/((&#*,...............*&@@%...........  ,*,,....              \r\n" + 
				"\t             ..(,*.... ./,.%,...... /&@@@@@ .............  .*,/...              \r\n" + 
				"\t              ......./ .....*** &@@@@@&#.................. ..(,&                \r\n" + 
				"\t                 (,.,....,..(@@@@@@/./@@@@@@@@@#*.......,*...,*.(               \r\n" + 
				"\t                 %,,,..,,,.,.@@@@@@@#&......,@@@@@@@@@%.... .,/,%               \r\n" + 
				"\t               ..%,,. ..,..,,,,../@@@@@@@@.../@@@@@#...... ..*,*(,              \r\n" + 
				"\t               ..#... ..,,..,..........,,.(@@@@@ ......... ..../.,.             \r\n" + 
				"\t                ./.... .. ......... .,&@@@@@%............. .*.,% /.             \r\n" + 
				"\t                .  ...,#........... *@@@(.....,...........,(..#..,..            \r\n" + 
				"\t                    .*. ,................,......,.......,&,,..                  \r\n" + 
				"\t                     *.,.(...*......,.......,..,.. .  .&,..                     \r\n" + 
				"\t                       ..,,,* . .*..,......    ...,%(...(,..                    \r\n" + 
				"\t                        .,**#,*#,..(.#...,,,#&%###...*,*,...                     \r\n" + 
				"\t                         . ...&&/.*&,.*&.......(#.                               \r\n" + 
				"\t                                 ..*...,,..                                     \r\n" + 
				"\t                                   .......                                       ");
		
		System.out.println("\n\n\n\t\tThankyou for playing !!!");
		
		System.exit(0);
	}
	

}
