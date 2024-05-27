import java.util.*;


public class Gronsaker {
    //-----------------------------------------------------------------------------------
    // We start by creating a class VegetableRecord to store the information about each vegetable
    // The class implements the Comparable interface to allow sorting of the records
    //-----------------------------------------------------------------------------------

    public static void main(String[] args) {
        List<VegetableRecord> vegetableRecords = new ArrayList<>(); // List to store the vegetable records
        Map<String, VegetableRecord> maxVegetableRecords = new HashMap<>(); // Map to store the maximum vegetable records

        Scanner scanner = new Scanner(System.in);

        //-----------------------------------------------------------------------------------
        // This loop continues as long as there are more tokens to read from the input.
        while (scanner.hasNext()) {

            //-----------------------------------------------------------------------------------
            // read the next token as the vegetable type
            // which is the vegetable type -> a single word -> string
            String vegetableType = scanner.next(); 

            //-----------------------------------------------------------------------------------
            // Initializes a StringBuilder to store the country name
            StringBuilder countryNameBuilder = new StringBuilder(); // initi

            //-----------------------------------------------------------------------------------
            // Extracting the country name which may consist of multiple words
            while (scanner.hasNext() && !scanner.hasNextInt()) {
                countryNameBuilder.append(scanner.next());

                //-----------------------------------------------------------------------------------
                // If the next token is not an integer, add a space to separate the words
                if (scanner.hasNext() && !scanner.hasNextInt()) {
                    countryNameBuilder.append(" ");
                }
            }

            //-----------------------------------------------------------------------------------
            // Read the size of the vegetable and the measurement unit
            int vegetableSize = scanner.nextInt();
            String measurementUnit = scanner.next();

            //-----------------------------------------------------------------------------------
            // Build the country name from the StringBuilder
            String countryName = countryNameBuilder.toString();
            
            //-----------------------------------------------------------------------------------
            // Create a new vegetable record
            VegetableRecord vegetableRecord = new VegetableRecord(vegetableType, countryName, vegetableSize, measurementUnit);

            //-----------------------------------------------------------------------------------
            // Generate a unique key that combines the vegetable type and country name
            String recordKey = vegetableType + "-" + countryName;

            //-----------------------------------------------------------------------------------
            // Update the record in the map if the current vegetable is larger or if it's a new entry
            if (!maxVegetableRecords.containsKey(recordKey) || vegetableSize > maxVegetableRecords.get(recordKey).size) {
                maxVegetableRecords.put(recordKey, vegetableRecord);
            }
        }
        scanner.close();

        //-----------------------------------------------------------------------------------
        // Convert the values in the map to a list for sorting
        vegetableRecords.addAll(maxVegetableRecords.values());

        // Sort the vegetable records
        Collections.sort(vegetableRecords);

        // Print the sorted vegetable records
        for (VegetableRecord record : vegetableRecords) {
            System.out.println(record);
        }
    }
}

class VegetableRecord implements Comparable<VegetableRecord> {
    String vegetableType;   // Type of vegetable
    String countryName;     // Name of the country
    int size;               // Size of the vegetable
    String measurementUnit; // Unit of measurement

    // Constructor to initialize a vegetable record
    public VegetableRecord(String vegetableType, String countryName, int size, String measurementUnit) {
        this.vegetableType = vegetableType;
        this.countryName = countryName;
        this.size = size;
        this.measurementUnit = measurementUnit;
    }

    //-----------------------------------------------------------------------------------
    // Method to compare vegetable records for sorting
    // I'm overriding the compareTo method to compare the records based on the following criteria:
    // 1. Alphabetically by vegetable type
    // 2. By size in descending order
    // 3. Alphabetically by country name
    //-----------------------------------------------------------------------------------

    @Override
    public int compareTo(VegetableRecord other) {

        //-----------------------------------------------------------------------------------
        // First, compare the vegetable types alphabetically by using the String compareTo method
        int typeComparison = this.vegetableType.compareTo(other.vegetableType);
        if (typeComparison != 0) {
            return typeComparison;
        }
        //-----------------------------------------------------------------------------------
        // If the vegetables are the same, compare the size (descending order)
        int sizeComparison = Integer.compare(other.size, this.size);
        if (sizeComparison != 0) {
            return sizeComparison;
        }

        //-----------------------------------------------------------------------------------
        // If the sizes are the same, compare the country names alphabetically
        return this.countryName.compareTo(other.countryName);
    }

    //-----------------------------------------------------------------------------------
    // Method to format the vegetable record as a string for output
    // The format is "vegetableType countryName size measurementUnit"
    //-----------------------------------------------------------------------------------
    @Override
    public String toString() {
        return vegetableType + " " + countryName + " " + size + " " + measurementUnit;
    }
}