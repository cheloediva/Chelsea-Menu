package RestaurantMenu;
import java.util.*;

public class RestaurantMenu {
    private Map<String, Double> menu;
    
    public RestaurantMenu() {
        menu = new HashMap<>();
        menu.put("Pizza", 500.0);
        menu.put("Burger", 300.0);
        menu.put("French fries", 200.0);
        menu.put("Coke", 100.0);
        menu.put("Water", 50.0);
    }
    
    public void listMenu() {
        System.out.println("Menu:");
        for (Map.Entry<String, Double> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + " - Ksh " + entry.getValue());
        }
    }
    
    public void addMenu(String item, double price) {
        menu.put(item, price);
        System.out.println("Added " + item + " to the menu for Ksh " + price);
    }
    
    public void order() {
        Scanner scanner = new Scanner(System.in);
        List<String> items = new ArrayList<>();
        double total = 0.0;
        System.out.println("Enter your order (press 'x' to stop):");
        while (true) {
            String item = scanner.nextLine().trim();
            if (item.equals("x")) {
                break;
            }
            if (menu.containsKey(item)) {
                items.add(item);
                total += menu.get(item);
            } else {
                System.out.println("Invalid item. Please try again.");
            }
        }
        System.out.println("Your order:");
        for (String item : items) {
            System.out.println(item + " - Ksh " + menu.get(item));
        }
        System.out.println("Total: Ksh " + total);
    }
    
    public void makePayment() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter payment amount in Ksh: ");
            double amount = scanner.nextDouble();
            System.out.println("Payment of Ksh " + amount + " received via mobile money.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }
    
    public static void main(String[] args) {
        RestaurantMenu restaurantMenu = new RestaurantMenu();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Welcome to the restaurant!");
                System.out.println("1. List menu");
                System.out.println("2. Add to menu");
                System.out.println("3. Order");
                System.out.println("4. Make payment");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        restaurantMenu.listMenu();
                        break;
                    case 2:
                        System.out.print("Enter item name: ");
                        String item = scanner.next();
                        System.out.print("Enter item price: ");
                        double price = scanner.nextDouble();
                        restaurantMenu.addMenu(item, price);
                        break;
                    case 3:
                        restaurantMenu.order();
                        break;
                    case 4:
                        restaurantMenu.makePayment();
                        break;
                    case 5:
                        System.out.println("Thank you for dining!");
                        System.exit(0); // terminate the program
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
