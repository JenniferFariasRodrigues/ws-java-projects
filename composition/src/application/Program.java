/* Link aula:
 * https://www.youtube.com/watch?v=gj80JEqk5ms*/
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner enterData = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = enterData.nextLine();
		System.out.print("Email: ");
		String email = enterData.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(enterData.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(enterData.next());
		
		Order order = new Order(new Date(), orderStatus, client);
		
		System.out.print("How many items to this order? ");
		int items = enterData.nextInt();
		for (int i=1; i<=items; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			enterData.nextLine();
			String productName = enterData.nextLine();
			System.out.print("Product price: ");
			double productPrice = enterData.nextDouble();

			Product product = new Product(productName, productPrice);

			System.out.print("Quantity: ");
			int quantity = enterData.nextInt();

			OrderItem orderItem = new OrderItem(quantity, productPrice, product); 

			order.addItem(orderItem);
		}
		

		System.out.println("/n ORDER SUMMARY:"  + order);
		enterData.close();
	}
}
