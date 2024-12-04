import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Product class
class Product {
    private String name;
    private double price;
    private String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

// ShoppingCart class
class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}

// User class
class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
class Main {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product("Product 1", 10.99, "Description of product 1");
        Product product2 = new Product("Product 2", 9.99, "Description of product 2");
        Product product3 = new Product("Product 3", 12.99, "Description of product 3");

        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Create user
        User user = new User("Abhay", "password123");

        // Login user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            System.out.println("Login successful!");

            // Display products
            System.out.println("Products:");
            System.out.println("1. " + product1.getName() + " - $" + product1.getPrice());
            System.out.println("2. " + product2.getName() + " - $" + product2.getPrice());
            System.out.println("3. " + product3.getName() + " - $" + product3.getPrice());

            // Add products to cart
            System.out.print("Enter product number to add to cart: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    cart.addProduct(product1);
                    break;
                case 2:
                    cart.addProduct(product2);
                    break;
                case 3:
                    cart.addProduct(product3);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            // Display cart contents
            System.out.println("Cart contents:");
            for (Product product : cart.getProducts()) {
                System.out.println(product.getName() + " - $" + product.getPrice());
            }

            // Checkout
            System.out.println("Total price: $" + cart.getTotalPrice());
            System.out.print("Enter payment method (1 for cash, 2 for card): ");
            int paymentMethod = scanner.nextInt();
            if (paymentMethod == 1) {
                System.out.println("Payment successful! Thank you for shopping!");
            } else if (paymentMethod == 2) {
                System.out.print("Enter card number: ");
                String cardNumber = scanner.next();
                System.out.print("Enter expiration date (MM/YY): ");
                String expirationDate = scanner.next();
                System.out.print("Enter CVV: ");
                String cvv = scanner.next();
                System.out.println("Payment successful! Thank you for shopping!");
            } else {
                System.out.println("Invalid payment method!");
            }
        } else {
            System.out.println("Invalid username or password!");
        }
    }
}


