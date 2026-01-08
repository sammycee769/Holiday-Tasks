public class ParkingSystem {

//    public static void main(String[] args) {
//
//        int parkedSlot = parkAutomatically();
//        System.out.println("Parked at slot: " + parkedSlot);
//
//        boolean parked = parkAtSlot(5);
//        System.out.println("Park at slot 5: " + parked);
//
//        boolean removed = removeCar(5);
//        System.out.println("Remove from slot 5: " + removed);
//
//        display(getSlots());
//    }
//
//    public static void display(int[] slots) {
//        for (int count = 0; count < slots.length; count++) {
//            System.out.println("Slot " + (count + 1) + ": " +
//                    (slots[count] == 0 ? "Empty" : "Occupied"));
//        }
//   }

 int[] slots = new int[20];

    public int parkAutomatically() {
        for (int count = 0; count < slots.length; count++) {
            if (slots[count] == 0) {
                slots[count] = 1;
                return count + 1; 
            }
        }
        return -1;
    }

    public boolean parkAtSlot(int slotNumber) {
        if (!isValidSlot(slotNumber)) 
            return false;

        if (slots[slotNumber - 1] == 0) {
            slots[slotNumber - 1] = 1;
            return true;
        }
        return false;
    }

    public boolean removeCar(int slotNumber) {
        if (!isValidSlot(slotNumber)) 
            return false;

        if (slots[slotNumber - 1] == 1) {
            slots[slotNumber - 1] = 0;
            return true;
        }
        return false;
    }

    public int[] getSlots() {
        return slots;
    }

    public boolean isValidSlot(int slotNumber) {
        return slotNumber >= 1 && slotNumber <= 20;
    }
}

