package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProducts;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	List<Product> list = new ArrayList<>();
	System.out.print("Enter the number of products: ");
	int n = sc.nextInt();
	for (int i=1; i<=n; i++) {
		System.out.println("Product #" + i + " data:");
		System.out.print("Common, used or imported (c/u/i)? ");
		char ch = sc.next().charAt(0);
		sc.nextLine();
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Price: ");
		double price = sc.nextDouble();
//		System.out.print("Customs Fee: ");
//		double customsFee = sc.nextInt();
		if (ch == 'c') {
			list.add(new Product(name,price));
		}	
		else if(ch=='u'){
			System.out.print("Manufacture date (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			list.add(new UsedProduct(name, price, date));
		}else {
			System.out.println("Customs fee: ");
			double customsFee = sc.nextDouble();
			list.add(new ImportedProducts(name, price, customsFee));
		}
			
	}
	System.out.println();
	System.out.println("PRICE TAGS: ");
	for (Product prod : list) {
		System.out.println(prod.priceTag());
	}
	sc.close();
	}

}
