public class Main {

    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        ParkingSystem lot = new ParkingSystem();

        menu:while (true) {
            System.out.println("""
            === PARKING LOT MENU ===
            1. Park automatically
            2. Park at a specific slot
            3. Remove car
            4. Display parking status
            5. Exit
            """);
            System.out.println("Choose an option: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1 -> {
                    int slot = lot.parkAutomatically();
                    if (slot == -1) {
                        System.out.println("Parking lot is full.");
                    } else {
                        System.out.println("Car parked at slot " + slot);
                    }
                }

                case 2 -> {
                    System.out.print("Enter slot number (1–20): ");
                    int slotNumber = input.nextInt();

                    boolean parked = lot.parkAtSlot(slotNumber);
                    boolean validSlot = lot.isValidSlot(slotNumber);
                    if (parked) {
                        System.out.println("Car parked at slot " + slotNumber);
                    } else if(!validSlot){
                             System.out.println("Failed to park at slot " + slotNumber +  " " + "Out Of Range");
                        } else {
                        System.out.println("Failed to park at slot " + slotNumber + " " + "Already filled, pick a different slot");
                    }
                }

                case 3 -> {
                    System.out.print("Enter slot number to remove car: ");
                    int slotNumber = input.nextInt();

                    boolean removed = lot.removeCar(slotNumber);
                    if (removed) {
                        System.out.println("Car removed from slot " + slotNumber);
                    } else {
                        System.out.println("No car found at slot " + slotNumber);
                    }
                }

                case 4 -> display(lot.getSlots());

                case 5 -> {
                    System.out.println("Exiting parking lot system.");
                   break menu;
                }

                default -> System.out.println("Invalid option. Try again.");
            }
        }

    }

    static void display(int[] slots) {
        for (int count = 0; count < slots.length; count++) {
            System.out.println(
                "Slot " + (count + 1) + ": " +
                (slots[count] == 0 ? "Empty" : "Occupied")
            );
        }
    }
}

