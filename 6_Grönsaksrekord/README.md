# Gronsaker - Vegetable Record Tracker

This Java program reads vegetable records from the standard input, processes them to find the largest vegetable of each type from each country, and then outputs the records in a sorted order.

## How It Works

1. **Reading Input:**
   - The program continuously reads input until there is no more data. 
   - Each record consists of a vegetable type, a country name (which may consist of multiple words), a vegetable size, and a measurement unit.

2. **Processing Records:**
   - The program uses a `HashMap` to keep track of the largest vegetable of each type from each country.
   - A unique key is generated for each vegetable-country combination.
   - If a new vegetable record has a larger size than the current one in the map, it updates the record.

3. **Sorting and Output:**
   - The program collects all records from the map into a list and sorts them first by vegetable type (alphabetically), then by size (in descending order), and finally by country name (alphabetically).
   - The sorted records are printed to the standard output.

## Classes and Methods

### `Gronsaker`

#### `public static void main(String[] args)`

- Reads input and processes vegetable records.
- Uses a `Scanner` to read from standard input.
- Stores the largest vegetable records in a `HashMap`.
- Sorts and prints the records.

### `VegetableRecord` implements `Comparable<VegetableRecord>`

#### `public VegetableRecord(String vegetableType, String countryName, int size, String measurementUnit)`

- Constructor to initialize a vegetable record.
- **Parameters:**
  - `vegetableType`: The type of vegetable.
  - `countryName`: The country of origin.
  - `size`: The size of the vegetable.
  - `measurementUnit`: The unit of measurement for the size.

#### `public int compareTo(VegetableRecord other)`

- Compares vegetable records for sorting.
- **Returns:**
  - Comparison result based on vegetable type, size, and country name.

#### `public String toString()`

- Formats the vegetable record as a string for output.
- **Returns:**
  - Formatted string representing the vegetable record.

## Example

### Input
```
Carrot USA 20 cm
Carrot Canada 25 cm
Carrot USA 15 cm
Tomato Mexico 50 g
Tomato USA 60 g
```

### Output
```
Carrot Canada 25 cm
Carrot USA 20 cm
Tomato USA 60 g
Tomato Mexico 50 g
```