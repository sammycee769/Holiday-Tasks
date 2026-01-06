print("=== SIMPLE CHECKOUT SYSTEM ===\n")

items = []
prices = []

while True:
    name = input("Enter product name (or 'done' to finish): ")

    if name.lower() == "done":
        break

    price = input("Enter price: ")

    while price.isdigit() == False:
        print("Invalid! Enter a number.")
        price = input("Enter price: ")

    items.append(name)
    prices.append(int(price))

if len(items) == 0:
    print("No items entered.")
    exit()

subtotal = sum(prices)
vat = subtotal * 0.075
total = subtotal + vat


print("\n=== INVOICE ===")
for item in range(len(items)):
    print(f"{item+1}. {items[item]} - ₦{prices[item]}")

print("Subtotal:", subtotal)
print("VAT (7.5%):", vat)
print("Total:", total)


payment = input("\nEnter payment: ")

while payment.isdigit() == False or float(payment) < total:
    print("Invalid or insufficient payment!")
    payment = input("Enter payment: ")

payment = float(payment)
change = payment - total

print("\n=== RECEIPT ===")
print("Subtotal:", subtotal)
print("VAT:", vat)
print("Total:", total)
print("Payment:", payment)
print("Change:", change)

print("\nThank you for shopping!")

