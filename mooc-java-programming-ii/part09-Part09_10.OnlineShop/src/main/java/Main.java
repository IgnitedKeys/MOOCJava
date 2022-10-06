
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Test your app here
    }

    public static class Warehouse {

        Map<String, Integer> products;
        Map<String, Integer> stocks;

        public Warehouse() {
            this.products = new HashMap<>();
            this.stocks = new HashMap<>();
        }

        public void addProject(String product, int price, int stock) {
            products.put(product, price);
            stocks.put(product, stock);
        }

        public int price(String product) {
            return this.products.getOrDefault(product, -99);
        }

        public int stock(String product) {
            return this.products.getOrDefault(product, 0);
        }

        public boolean take(String product) {
            if (stock(product) >= 0) {
                stocks.put(product, stocks.get(product) - 1);
                return true;
            }
            return false;
        }

        public Set<String> products() {
            Set<String> keys = this.products.keySet();
            return keys;
        }
    }

    public static class Item {

        private String product;
        private int qty;
        private int unitPrice;

        public Item(String product, int qty, int unitPrice) {
            this.product = product;
            this.qty = qty;
            this.unitPrice = unitPrice;
        }

        public int price() {
            return this.qty * this.unitPrice;
        }

        public void increaseQuantity() {
            this.qty += 1;
        }

        public String toString() {
            return this.product + ":" + this.qty;
        }
    }

    public static class ShoppingCart {

        Map<String, Item> cart;

        public ShoppingCart() {
            this.cart = new HashMap<>();
        }

        public void add(String product, int price) {
            if (cart.containsKey(product)) {
                increaseQuantity(product);
            }
            cart.put(product, new Item(product, 1, price));
        }

        public int price() {
            int total = 0;
            for (Item item : cart.values()) {
                total += item.price();
            }

            return total;
        }

        public void print() {
            for (String item : cart.keySet()) {
                System.out.println(cart.get(item).toString());
            }
        }

        public void increaseQuantity(String product) {
            this.cart.get(product).increaseQuantity();
        }
    }

    public static class Store {

        private Warehouse warehouse;
        private Scanner scanner;

        public Store(Warehouse warehouse, Scanner scanner) {
            this.warehouse = warehouse;
            this.scanner = scanner;
        }

        // the method that handles the customers visit to the store.
        public void shop(String customer) {
            ShoppingCart cart = new ShoppingCart();
            System.out.println("Welcome to the store " + customer);
            System.out.println("our selection:");

            for (String product : this.warehouse.products()) {
                System.out.println(product);
            }

            while (true) {
                System.out.print("What to put in the cart (press enter to go to the register): ");
                String product = scanner.nextLine();
                if (product.isEmpty()) {
                    break;
                }
                if (warehouse.stock(product) > 0) {
                    warehouse.take(product);
                    cart.add(product, warehouse.price(product));
                }

                // If there is any in the warehouse, and reduces the stock in the warehouse
                // Don't touch any of the other code!
            }

            System.out.println("your shoppingcart contents:");
            cart.print();
            System.out.println("total: " + cart.price());
        }

    }
}
