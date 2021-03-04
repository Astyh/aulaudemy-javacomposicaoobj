/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compraproduto;

import entites.Client;
import entites.Order;
import entites.OrderItem;
import entites.Product;
import entites.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class Aplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
       
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
               
        

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY) : ");
        Date birthDate = sdf.parse(sc.next());
        
        Client client = new Client(clientName, clientEmail, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        Order order = new Order(new Date(), status, client);
        
        System.out.print("How many items to this order?: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.printf("Enter #%d item data: ", i);
            sc.nextLine();            
            System.out.print("\nProduct name: ");
            String productName = sc.nextLine();
            System.out.print("Product Price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            
            Product product = new Product(productName, productPrice);
            OrderItem orderitem = new OrderItem(quantity, productPrice, product);
            order.addItem(orderitem);            
        }
        
        System.out.println("");
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        sc.close();
    }

}
