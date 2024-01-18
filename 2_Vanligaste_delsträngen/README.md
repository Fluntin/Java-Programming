# Most Frequent Substring Finder

This program is designed to find the most frequently occurring substring of a specified length in a longer string.

## Overview

The program takes as input a longer string `S` and an integer `n`, representing the desired length of the substring to search for. It then identifies the substring `d` of length `n` that occurs most frequently in the input string `S`. If multiple substrings of the specified length have the same highest frequency, the program returns the one that comes first in alphabetical order.

## Example

Suppose `n = 3` and `S = "ABCDABCDABADAB"`. The most frequent substring of length 3 in `S` is "DAB," which is returned by the program.

## Input

The program expects the following input format:

1. An integer `n` on a separate line.
2. A non-line-breaking string `S`, which can be up to 100,000,000 characters long, and is terminated with a line break or EOF.

The characters in the input string are limited to digits 0-9, uppercase letters A-Z, and lowercase letters a-z. The correct alphabetical order for these characters is: "0123456789ABCDEGHIJKLMNOPQRSTUVWXYZabcdefhijklmnopqrstuvwxyz".

## Output

The program will output the most frequently occurring substring `d` of length `n` found in the input string `S`.

## Usage

To run the program, provide the input as described above and execute the program. Here's an example of how to run it:

```shell
$ python most_frequent_substring.py
3
ABCDABCDABADAB
```

The program will then output the result.

## Sample Inputs and Outputs

### Sample Input 1
```
3
ABCDABCDABADAB
```
### Sample Output 1
```
DAB
```

### Sample Input 2
```
2
123abcABCDabcd1234
```
### Sample Output 2
```
12
```

### Sample Input 3
```
2
ABABBBBCD
```
### Sample Output 3
```
BB
```