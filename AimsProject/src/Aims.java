public class Aims {

    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // Print the items and the total cost of the cart
        System.out.println();
        anOrder.print();

        // Test removeDigitalVideoDisc (section 8)
        System.out.println("\n--- Remove \"Star Wars\" ---");
        anOrder.removeDigitalVideoDisc(dvd2);
        anOrder.print();

        System.out.println("\n--- Remove a disc that is not in the cart ---");
        anOrder.removeDigitalVideoDisc(dvd2);

        // Test the overloaded addDigitalVideoDisc methods (section 9)
        System.out.println("\n--- Add two DVDs ---");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 15.5f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 22.0f);
        anOrder.addDigitalVideoDisc(dvd4, dvd5);

        System.out.println("\n--- Add an array of DVDs ---");
        DigitalVideoDisc[] dvdList = {
                new DigitalVideoDisc("Frozen", "Animation", 17.25f),
                new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 194, 20.0f)
        };
        anOrder.addDigitalVideoDisc(dvdList);

        System.out.println("\n--- Add any number of DVDs (varargs) ---");
        anOrder.addDigitalVideoDisc(new DigitalVideoDisc("Up"),
                new DigitalVideoDisc("Coco", "Animation", 16.0f),
                new DigitalVideoDisc("Cars", "Animation", "John Lasseter", 14.75f));

        System.out.println();
        anOrder.print();

        System.out.println("\nNumber of DVDs created: " + DigitalVideoDisc.getNbDigitalVideoDiscs());
    }

}
