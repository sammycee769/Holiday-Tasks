import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckoutSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== SIMPLE CHECKOUT SYSTEM ===\n");

        ArrayList<String> items = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        ArrayList<Double> totals = new ArrayList<>();

        System.out.print("What is the customer's name: ");
        String customerName = input.nextLine();

        while (true) {
            System.out.print("What did the customer buy: ");
            String item = input.nextLine();

            String qtyInput;
            int quantity;
            while (true) {
                System.out.print("How many pieces: ");
                qtyInput = input.nextLine();
                if (qtyInput.matches("\\d+")) {
                    quantity = Integer.parseInt(qtyInput);
                    break;
                }
                System.out.println("Invalid! Enter a number.");
            }

            String priceInput;
            double price;
            while (true) {
                System.out.print("How much per unit: ");
                priceInput = input.nextLine();
                if (priceInput.matches("\\d+(\\.\\d+)?")) {
                    price = Double.parseDouble(priceInput);
                    break;
                }
                System.out.println("Invalid! Enter a number.");
            }

            items.add(item);
            quantities.add(quantity);
            prices.add(price);

            System.out.print("Add more items? (yes/no): ");
            String moreItems = input.nextLine().toLowerCase();

            while (!moreItems.equals("yes") && !moreItems.equals("no")) {
                System.out.println("Enter valid option");
                System.out.print("Add more items? (yes/no): ");
                moreItems = input.nextLine().toLowerCase();
            }

            if (moreItems.equals("no")) {
                break;
            }
        }

        System.out.print("What is your name? ");
        String cashierName = input.nextLine();

        System.out.print("How much discount will he get? ");
        double discountPercent = input.nextDouble();

        double subTotal = 0;

        for (int i = 0; i < items.size(); i++) {
            double itemTotal = quantities.get(i) * prices.get(i);
            totals.add(itemTotal);
            subTotal += itemTotal;
        }

        double discount = (discountPercent / 100) * subTotal;
        double vat = (7.5 / 100) * subTotal;
        double billTotal = subTotal - discount + vat;

        printReceipt(items, quantities, prices, totals, subTotal, discount, vat,
                billTotal, cashierName, customerName);

        System.out.print("\nHow much did the customer give you? ");
        double amountPaid = input.nextDouble();
        double balance = amountPaid - billTotal;

        printReceipt(items, quantities, prices, totals, subTotal, discount, vat,
                billTotal, cashierName, customerName);

        System.out.printf("%-40s%10.2f%n", "Amount Paid:", amountPaid);
        if (balance > 0) {
            System.out.printf("%-40s%10.2f%n", "Balance:", balance);
        }

        System.out.println("=".repeat(60));
        System.out.printf("%^60s%n", "THANKS FOR YOUR PATRONAGE");
        System.out.println("=".repeat(60));

    }

    public static void printReceipt(
            ArrayList<String> items,
            ArrayList<Integer> quantities,
            ArrayList<Double> prices,
            ArrayList<Double> totals,
            double subTotal,
            double discount,
            double vat,
            double billTotal,
            String cashierName,
            String customerName) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MMM-yy hh:mm:ss a");

        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
        System.out.println("TEL: 03293828343");
        System.out.println("Date: " + LocalDateTime.now().format(formatter));
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);

        System.out.println("=".repeat(60));
        System.out.printf("%-15s%5s%15s%18s%n",
                "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
        System.out.println("-".repeat(60));

        for (int count = 0; count < items.size(); count++) {
            System.out.printf("%-15s%5d%15.2f%16.2f%n",
                    items.get(count),
                    quantities.get(count),
                    prices.get(count),
                    totals.get(count));
        }

        System.out.println("-".repeat(60));
        System.out.printf("%-40s%10.2f%n", "Sub Total:", subTotal);
        System.out.printf("%-40s%10.2f%n", "Discount:", discount);
        System.out.printf("%-40s%10.2f%n", "VAT @ 7.5%:", vat);

        System.out.println("=".repeat(60));
        System.out.printf("%-40s%10.2f%n", "Bill Total:", billTotal);
        System.out.println("=".repeat(60));
    }
}

