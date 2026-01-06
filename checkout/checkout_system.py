from datetime import datetime

print("=== SIMPLE CHECKOUT SYSTEM ===\n")

items = []
quantities = []
prices = []
totals = []

customer_name = input("What is the customer's name: \n")
while True:
    item = input("What did the customer buy: \n")
    quantity = input("How many pieces: \n")
    price = input("How much per unit: \n")
    
    while not quantity.isdigit():
        print("Invalid! Enter a number.\n")
        quantity = input("How many pieces: \n")
    quantity = int(quantity)

    while not price.replace('.', '', 1).isdigit():
        print("Invalid! Enter a number.\n")
        price = input("How much per unit: \n")
    price = float(price)

    items.append(item)
    quantities.append(quantity)
    prices.append(price)
    
    more_items = input("Add more items? \n").lower()
    while more_items not in ("no", "yes"):
        print("Enter valid optiom")
        more_items = input("Add more items? \n").lower()
    if more_items == "no":
        break


cashier_name = input("What is your name? ")
discount_percent = float(input("How much discount will he get? "))

sub_total = 0

for count in range(len(items)):
    items_total = quantities[count] * prices[count]
    totals.append(items_total)
    sub_total += items_total
discount = (discount_percent / 100) * sub_total
VAT = (7.5 / 100) * sub_total
bill_total = sub_total - discount + VAT

print("SEMICOLON STORES")
print("MAIN BRANCH")
print("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.")
print("TEL: 03293828343")
print("Date:", datetime.now().strftime("%d-%b-%y %I:%M:%S %p"))
print("Cashier:", cashier_name)
print("Customer Name:", customer_name)

print("=" * 60)
print(f"{'ITEM':<15}{'QTY':>5}{'PRICE':>15}{'TOTAL(NGN)':>18}")
print("-" * 60)

for count in range(len(items)):
    print(f"{items[count]:<15}{quantities[count]:>5}{prices[count]:>15.2f}{totals[count]:>16.2f}")

print("-" * 60)
print(f"{'Sub Total:':<40}{sub_total:>10.2f}")
print(f"{'Discount:':<40}{discount:>10.2f}")
print(f"{'VAT @ 7.5%:':<40}{VAT:>10.2f}")

print("=" * 60)
print(f"{'Bill Total:':<40}{bill_total:>10.2f}")
print("=" * 60)
print(f"THIS IS NOT A RECEIPT KINDLY PAY {bill_total:.2f}")
print("=" * 60)

amount_paid = float(input("How much did the the customer give you?\n"))
balance = amount_paid - bill_total


print("SEMICOLON STORES")
print("MAIN BRANCH")
print("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.")
print("TEL: 03293828343")
print("Date:", datetime.now().strftime("%d-%b-%y %I:%M:%S %p"))
print("Cashier:", cashier_name)
print("Customer Name:", customer_name)

print("=" * 60)
print(f"{'ITEM':<15}{'QTY':>5}{'PRICE':>15}{'TOTAL(NGN)':>18}")
print("-" * 60)

for count in range(len(items)):
    print(f"{items[count]:<15}{quantities[count]:>5}{prices[count]:>15.2f}{totals[count]:>16.2f}")

print("-" * 60)
print(f"{'Sub Total:':<40}{sub_total:>10.2f}")
print(f"{'Discount:':<40}{discount:>10.2f}")
print(f"{'VAT @ 7.5%:':<40}{VAT:>10.2f}")

print("=" * 60)
print(f"{'Bill Total:':<40}{bill_total:>10.2f}")
print("=" * 60)
print(f"{'Amount Paid:':<40}{amount_paid:>10.2f}")
if balance > 0:
    print(f"{'Balance:':<40}{balance:>10.2f}")
print("=" * 60)
print(f"{'THANKS FOR YOUR PATRONAGE':^60}")
print("=" * 60)
