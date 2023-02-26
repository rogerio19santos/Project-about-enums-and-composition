package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
       System.out.println("Enter cliente data:");
       System.out.print("Name:");
       String name = sc.nextLine();
       System.out.print("Email:");
       String email = sc.nextLine();
       System.out.print("Birth date:");
       String date = sc.nextLine();
       LocalDate d_date = LocalDate.parse(date,fmt1);
       
       System.out.println("Enter order data:");
       System.out.print("Status:");
       String status = sc.nextLine();
       OrderStatus o_status = OrderStatus.valueOf(status);
       Client cliente = new Client(name,email,d_date);
 	  Order pedido = new Order(LocalDate.now(),o_status,cliente);

       
       System.out.print("How many items to this order?");
      int n = sc.nextInt();
      
  /*    System.out.println("ORDER SUMMARY:");
      System.out.println("Order moment: "+Instant.now());
      System.out.println("Order status: "+o_status);
      System.out.println("Client: "+name+""+date+"-"+email);
      System.out.println("Order items:");
      */
      for(int i = 0; i < n; i++) {
    	  System.out.printf("Enter #%d item data:\n", i+1);
    	 
    	  System.out.print("Product name:");
    	  String productName = sc.next();
    	 // System.out.println("");
    	  System.out.print("Product price:");
    	  double price = sc.nextDouble();
    	  System.out.println("");
    	  System.out.print("Quantity:");
    	  int quantity = sc.nextInt();
    	  Product produto = new Product(productName,price);
    	  OrderItem item  = new OrderItem(quantity,price,produto);
    	 
    	  pedido.addItem(item);
    	  
      }
      System.out.println("ORDER SUMMARY:");
      System.out.println("Order moment: "+Instant.now());
      System.out.println("Order status: "+o_status);
      System.out.println("Client: "+name+""+date+"-"+email);
      System.out.println("Order items:");
      for(int i = 0; i < n; i++) {
    	  System.out.println(pedido.getItems().get(i).getProduct().getName()+", $"+
                  pedido.getItems().get(i).getPrice()+
    			  ", Quantity: "+pedido.getItems().get(i).getQuantity()+
    			  ", Subtotal: $" + pedido.getItems().get(i).subTotal());
      }
      System.out.println("Total price: $"+pedido.total());
      sc.close();
	}

}
