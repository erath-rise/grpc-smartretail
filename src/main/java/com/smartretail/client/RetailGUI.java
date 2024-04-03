package com.smartretail.client;

import com.smartretail.generated.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;
import java.util.Scanner;


public class RetailGUI {
    private ManagedChannel channel;
    private InventoryServiceGrpc.InventoryServiceBlockingStub inventoryStub;
    private OrderServiceGrpc.OrderServiceBlockingStub orderStub;
    private ProductServiceGrpc.ProductServiceBlockingStub productStub;

    public void run() {
        // create connection with server
        channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

        // create stub
        inventoryStub = InventoryServiceGrpc.newBlockingStub(channel);
        orderStub = OrderServiceGrpc.newBlockingStub(channel);
        productStub = ProductServiceGrpc.newBlockingStub(channel);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please select an operation:");
            System.out.println("1. Get product information");
            System.out.println("2. Get inventory information");
            System.out.println("3. Create order");
            System.out.println("0. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    getProduct(sc);
                    break;
                case 2:
                    getInventory(sc);
                    break;
                case 3:
                    createOrder(sc);
                    break;
                case 0:
                    System.out.println("Exiting application...");
                    channel.shutdown();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public void getProduct(Scanner sc) {
        System.out.println("Please enter product ID: (apple, pear, banana, orange, grape)");
        String productId = sc.next();

        ProductProto.ProductRequest request = ProductProto.ProductRequest.newBuilder()
                .setProductId(productId)
                .build();

        com.smartretail.generated.ProductProto.ProductResponse response = productStub.getProduct(request);
        System.out.println("The product information is as follows:");
        System.out.println("Product ID: " + response.getProductId());
        System.out.println("Name: " + response.getName());
        System.out.println("Description: " + response.getDescription());
        System.out.println("Price: " + response.getPrice());
    }

    public void getInventory(Scanner sc) {
        System.out.println("Please enter product ID: (apple, pear, banana, orange, grape)");
        String productId = sc.next();

        InventoryProto.InventoryRequest request = InventoryProto.InventoryRequest.newBuilder()
                .setProductId(productId)
                .build();

        com.smartretail.generated.InventoryProto.InventoryResponse response = inventoryStub.getInventory(request);
        System.out.println("The inventory information is as follows:");
        System.out.println("Product ID: " + productId);
        System.out.println("Quantity: " + response.getQuantity());
    }

    public void createOrder(Scanner sc) {
        System.out.println("Please enter user ID:");
        String userId = sc.next();

        OrderProto.OrderRequest.Builder orderRequestBuilder = OrderProto.OrderRequest.newBuilder()
                .setUserId(userId);

        String productId;
        do {
            System.out.println("Please enter product ID: (apple, pear, banana, orange, grape)");
            productId = sc.next();

            System.out.println("Please enter quantity:");
            int quantity = sc.nextInt();

            OrderProto.OrderItem orderItem = OrderProto.OrderItem.newBuilder()
                    .setProductId(productId)
                    .setQuantity(quantity)
                    .build();

            orderRequestBuilder.addItems(orderItem);

            System.out.println("Do you want to add more items to the order? (yes/no)");
        } while (sc.next().equals("yes"));

        OrderProto.OrderRequest orderRequest = orderRequestBuilder.build();
        System.out.println("Creating order...");

        Iterator<OrderProto.OrderResponse> responseIterator = orderStub.createOrder(orderRequest);
        System.out.println("Order creation result:");
        while (responseIterator.hasNext()) {
            OrderProto.OrderResponse response = responseIterator.next();
            System.out.println("Order ID: " + response.getOrderId());
            System.out.println("User ID: " + userId);
            System.out.println("Status: " + response.getStatus());
            System.out.println("Total price: " + response.getTotalPrice());
        }
    }
}
