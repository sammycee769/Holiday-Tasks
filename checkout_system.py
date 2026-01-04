print("=== SIMPLE CHECKOUT SYSTEM ===\n")

items = []
quantities = []
prices = []

customer_name = input("What is the customer's name: \n")
while True:
    item = input("What did the customer buy: \n")
    quantity = input("How many pieces: \n")
    price = input("How much per unit: \n")
    
    while not quantity.isdigit():
        print("Invalid! Enter a number.\n")
        quantity = input("How many pieces: \n")

    while not price.replace('.', '', 1).isdigit():
        print("Invalid! Enter a number.\n")
        price = input("How much per unit: \n")

    items.append(item)
    quantities.append(quantity)
    prices.append(price)
    
    more_items = input("Add more items? \n").lower()
    if more_items == "no":
        break
    while more_items != "yes":
        print("Enter valid optiom")
        more_items = input("Add more items? \n").lower()
        
    

    
