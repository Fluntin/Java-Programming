import java.io.*;
import java.util.*;

class Vegetable implements Comparable<Vegetable> {
    private String type;
    private String country;
    private int size;
    private String unit;

    public Vegetable(String type, String country, int size, String unit) {
        this.type = type;
        this.country = country;
        this.size = size;
        this.unit = unit;
    }

    @Override
    public int compareTo(Vegetable other) {
        // First, compare by vegetable type (alphabetical order)
        int typeComparison = this.type.compareTo(other.type);
        
        if (typeComparison != 0) {
            return typeComparison;
        } else {
            // If types are the same, compare by size (largest to smallest)
            int sizeComparison = Integer.compare(other.size, this.size);
            
            if (sizeComparison != 0) {
                return sizeComparison;
            } else {
                // If sizes are the same, compare by country name (alphabetical order)
                return this.country.compareTo(other.country);
            }
        }
    }

    @Override
    public String toString() {
        return type + " " + country + " " + size + " " + unit;
    }
}

public class LargestVegetables {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java LargestVegetables <input_file>");
            System.exit(1);
        }

        String inputFile = args[0];
        List<Vegetable> vegetables = new ArrayList<>();

        // Read input data from the file and create Vegetable objects
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 4) {
                    String type = parts[0];
                    String country = parts[1];
                    int size = Integer.parseInt(parts[2]);
                    String unit = parts[3];
                    vegetables.add(new Vegetable(type, country, size, unit));
                }
            }
        }

        // Sort the list of vegetable records
        Collections.sort(vegetables);

        // Print the sorted list of vegetable records
        for (Vegetable veg : vegetables) {
            System.out.println(veg);
        }
    }
}

