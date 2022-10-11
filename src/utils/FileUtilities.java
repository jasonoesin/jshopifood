package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import data.Data;
import models.Beverage;
import models.Dessert;
import models.Food;

public class FileUtilities {

	public static void GetData(){
		try {
			Scanner scanner = new Scanner(new File("src/source.txt"));
			while (scanner.hasNextLine()) {
				
				String[] split = scanner.nextLine().split("#");
				
			    if(split[0].equals("food")) {
			    	Data.addOrder(new Food(split[1], Integer.parseInt(split[2]),  Integer.parseInt(split[3])
			    			, split[4], split[5].equals("1") ? true : false));
			    }
			    else if(split[0].equals("beverage")) {
			    	Data.addOrder(new Beverage(split[1], Integer.parseInt(split[2])
			    			, Integer.parseInt(split[3]), split[4].charAt(0)));
			    }
			    else {
			    	Data.addOrder(new Dessert(split[1], Integer.parseInt(split[2])
			    			, Integer.parseInt(split[3]), split[4].equals("1") ? true : false));
			    }
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}
