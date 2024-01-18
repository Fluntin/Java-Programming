# Unique Permutations

This program reads a string `S` and prints a line-separated list of all unique permutations that can be made from the string, sorted in alphabetical order. The list should not contain any duplicates.

## Overview

Given a string `S`, the program generates and displays all unique possible permutations of the string in alphabetical order. For example, if `S = "ABA"`, the unique permutations are "AAB", "ABA", and "BAA".

## Input

The input consists of a non-line-breaking string `S`, which comprises characters from 'A' to 'Z'.

## Output

The program outputs a line-separated list, sorted alphabetically, with one permutation per line.

## Usage

To run the program, provide the input string as described above and execute it. Here's an example of how to run it:

```shell
$ python unique_permutations.py
ABA
```

The program will then display the result.

## Sample Inputs and Outputs

### Sample Input 1
```
ABA
```

### Sample Output 1
```
AAB
ABA
BAA
```

### Sample Input 2
```
JAVAP
```

### Sample Output 2
```
AAJPV
AAJVP
AAPJV
AAPVJ
AAVJP
AAVPJ
AJAPV
AJAVP
AJPAV
AJPVA
AJVAP
AJVPA
APAJV
APAVJ
APJAV
APJVA
APVAJ
APVJA
AVAJP
AVAPJ
AVJAP
AVJPA
AVPAJ
AVPJA
JAAPV
JAAVP
JAPAV
JAPVA
JAVAP
JAVPA
JPAAV
JPAVA
JPVAA
JVAAP
JVAPA
JVPAA
PAAJV
PAAVJ
PAJAV
PAJVA
PAVAJ
PAVJA
PJAAV
PJAVA
PJVAA
PVAAJ
PVAJA
PVJAA
VAAJP
VAAPJ
VAJAP
VAJPA
VAPAJ
VAPJA
VJAAP
VJAPA
VJPAA
VPAAJ
VPAJA
VPJAA
```