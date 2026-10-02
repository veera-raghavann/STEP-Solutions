import java.util.ArrayList;
import java.util.List;

public class PaymentProcessingShoppingSystem {

    enum OrderStatus {
        PENDING,
        PAID
    }

    static class Customer {
        private final String name;

        Customer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Product {
        private final String name;
        private final double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    static class OrderItem {
        private final Product product;
        private final int quantity;

        OrderItem(Product product, int quantity) {
            if (quantity <= 0) {
                throw new IllegalArgumentException(
                    "Quantity must be positive."
                );
            }

            this.product = product;
            this.quantity = quantity;
        }

        public double getTotal() {
            return product.getPrice() * quantity;
        }
    }

    interface PaymentMethod {
        boolean processPayment(Order order);
    }

    static class CreditCardPayment implements PaymentMethod {
        public boolean processPayment(Order order) {
            return true;
        }
    }

    static class PayPalPayment implements PaymentMethod {
        public boolean processPayment(Order order) {
            return false;
        }
    }

    static class BankTransferPayment implements PaymentMethod {
        public boolean processPayment(Order order) {
            return true;
        }
    }

    static class Order {
        private final String orderId;
        private final Customer customer;
        private final List<OrderItem> items = new ArrayList<>();
        private OrderStatus status = OrderStatus.PENDING;

        Order(String orderId, Customer customer) {
            this.orderId = orderId;
            this.customer = customer;
        }

        public void addProduct(Product product, int quantity) {
            items.add(new OrderItem(product, quantity));
        }

        public boolean isEmpty() {
            return items.isEmpty();
        }

        public OrderStatus getStatus() {
            return status;
        }

        public double getTotal() {
            double total = 0;

            for (OrderItem item : items) {
                total += item.getTotal();
            }

            return total;
        }

        public void pay(PaymentMethod paymentMethod) {
            if (isEmpty()) {
                System.out.println(
                    "Cannot process payment for an empty order."
                );
                return;
            }

            System.out.printf(
                "Payment initiated via %s for Order %s.%n",
                paymentMethod.getClass().getSimpleName(),
                orderId
            );

            boolean successful = paymentMethod.processPayment(this);

            if (successful) {
                status = OrderStatus.PAID;
                System.out.printf(
                    "Payment for Order %s successful. Order status: Paid.%n",
                    orderId
                );
            } else {
                System.out.printf(
                    "Payment for Order %s failed. Order status: Pending.%n",
                    orderId
                );
            }
        }
    }

    public static void main(String[] args) {
        Customer customerX = new Customer("Customer X");
        Customer customerY = new Customer("Customer Y");
        Customer customerZ = new Customer("Customer Z");

        Product productA = new Product("Product A", 100);
        Product productB = new Product("Product B", 200);
        Product productC = new Product("Product C", 150);

        Order orderX = new Order("X", customerX);
        orderX.addProduct(productA, 2);
        orderX.addProduct(productB, 1);

        System.out.println(
            "Order created for " + customerX.getName() + "."
        );
        orderX.pay(new CreditCardPayment());

        Order orderY = new Order("Y", customerY);

        System.out.println(
            "Order created for " + customerY.getName() + "."
        );
        orderY.pay(new CreditCardPayment());

        Order orderZ = new Order("Z", customerZ);
        orderZ.addProduct(productC, 1);

        System.out.println(
            "Order created for " + customerZ.getName() + "."
        );
        orderZ.pay(new PayPalPayment());
    }
}
