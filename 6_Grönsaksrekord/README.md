# Largest Vegetables

This program reads a data file containing information about various vegetables grown in different countries and prints a sorted list of the largest vegetable of each type.

**Note:** In this lab, you must create an additional class that can store vegetable data records and implement the `Comparable` interface to allow sorting of arrays of records.

The International Agriculture Association compiles an annual list of where the largest vegetables of various types have been produced. The list is primarily sorted by vegetable type (in alphabetical order), and secondarily by size (largest to smallest). Each country can only contribute one vegetable of each type. So, if Sweden were to produce the 17 largest cucumbers in a particular year, only the largest one counts. The second-largest cucumber on the list would be the largest vegetable from the other countries, and so on. If two countries tie for a record for a particular vegetable, they should be listed in alphabetical order.

However, registration for the competition is decentralized, and each farmer can register as many vegetables as they want. This means that the input may contain multiple examples of the same type of vegetable from the same country. Your program should ensure that only the largest vegetable of each type is included for each country.

## Input

The input consists of a file where each line corresponds to a specific vegetable with information about where it was grown and how large it is, following this pattern:

<Vegetable Type (one word)> <Country Name (one or more words)> <Size (integer)> <unit (one word)>

You can assume that all vegetables of the same type are measured in the same unit.

You can assume that there are at most 1,000,000 lines in the input file.

## Output

A sorted, line-separated list, with at most one record of each vegetable from each country. Each line follows the same pattern as described above.

## Usage

To run the program, provide the input data file as described above and execute it. Here's an example of how to run it:

```shell
$ python largest_vegetables.py input.txt
```

The program will then display the sorted list.

## Sample Input and Output

### Sample Input
```
cucumber Spain 32 cm
tomato Greece 19 hg
cucumber United Arab Emirates 31 cm
tomato Greece 21 hg
```

### Sample Output
```
cucumber Spain 32 cm
cucumber United Arab Emirates 31 cm
tomato Greece 21 hg
```