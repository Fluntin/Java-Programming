import java.util.*;

public class Gronsaker {
    public static void main(String[] args) {
        List<VegetableRecord> vegetableRecords = new ArrayList<>();
        Map<String, VegetableRecord> maxVegetableRecords = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String vegetableType = scanner.next();
            StringBuilder countryNameBuilder = new StringBuilder();

            // Extracting the country name which may consist of multiple words
            while (scanner.hasNext() && !scanner.hasNextInt()) {
                countryNameBuilder.append(scanner.next());
                if (scanner.hasNext() && !scanner.hasNextInt()) {
                    countryNameBuilder.append(" ");
                }
            }

            int vegetableSize = scanner.nextInt();
            String measurementUnit = scanner.next();
            String countryName = countryNameBuilder.toString();

            // Create a new vegetable record
            VegetableRecord vegetableRecord = new VegetableRecord(vegetableType, countryName, vegetableSize, measurementUnit);

            // Generate a unique key for each vegetable-country combination
            String recordKey = vegetableType + "-" + countryName;

            // Update the record in the map if the current vegetable is larger or if it's a new entry
            if (!maxVegetableRecords.containsKey(recordKey) || vegetableSize > maxVegetableRecords.get(recordKey).size) {
                maxVegetableRecords.put(recordKey, vegetableRecord);
            }
        }
        scanner.close();

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
    String vegetableType;
    String countryName;
    int size;
    String measurementUnit;

    // Constructor to initialize a vegetable record
    public VegetableRecord(String vegetableType, String countryName, int size, String measurementUnit) {
        this.vegetableType = vegetableType;
        this.countryName = countryName;
        this.size = size;
        this.measurementUnit = measurementUnit;
    }

    // Method to compare vegetable records for sorting
    @Override
    public int compareTo(VegetableRecord other) {
        // Compare vegetable type alphabetically
        int typeComparison = this.vegetableType.compareTo(other.vegetableType);
        if (typeComparison != 0) {
            return typeComparison;
        }

        // If the vegetables are the same, compare the size (descending order)
        int sizeComparison = Integer.compare(other.size, this.size);
        if (sizeComparison != 0) {
            return sizeComparison;
        }

        // If the sizes are the same, compare the country names alphabetically
        return this.countryName.compareTo(other.countryName);
    }

    // Method to format the vegetable record as a string for output
    @Override
    public String toString() {
        return vegetableType + " " + countryName + " " + size + " " + measurementUnit;
    }
}