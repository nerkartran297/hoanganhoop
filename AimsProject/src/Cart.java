import java.util.Locale;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. The disc \"" + disc.getTitle() + "\" could not be added.");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is now full.");
        } else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 2) {
            System.out.println("The cart is almost full.");
        }
    }

    // Overloading by differing the type of the parameter (9.1).
    // A varargs parameter is compiled to an array parameter, so Java does not allow
    // addDigitalVideoDisc(DigitalVideoDisc[] dvdList) and addDigitalVideoDisc(DigitalVideoDisc... dvds)
    // in the same class. The varargs version is kept: it accepts an array as well as
    // any number of separate DVDs (see answers.txt).
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }

    // Overloading by differing the number of parameters (9.2)
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                // shift the remaining items to the left to keep the order they were added in
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                qtyOrdered--;
                itemsOrdered[qtyOrdered] = null;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
                return;
            }
        }
        System.out.println("The disc \"" + disc.getTitle() + "\" is not in the cart.");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void print() {
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - "
                    + String.format(Locale.US, "%.2f", itemsOrdered[i].getCost()));
        }
        System.out.println("Total Cost is: " + String.format(Locale.US, "%.2f", totalCost()));
    }
}
