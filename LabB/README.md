## Longest Sorted Substring Finder

This task involves finding the longest sorted substring within a longer string.

Your program should be able to take a longer string `S` as input and determine the length `L` of the longest substring that appears in sorted order.

For example, consider `S = "DCBABCBA"` (with the longest sorted substring "ABC" highlighted in bold for clarity). In this case, the correct value of `L` is 3.

### Input
A non-line-breaking string.
You can assume that all characters in the string are either the digits 0-9, uppercase letters A-Z, or lowercase letters a-z. The correct alphabetical order for these characters is "0123456789ABCDEGHIJKLMNOPQRSTUVWXYZabcdefhijklmnopqrstuvwxyz".

The length of `S` can be anywhere from 1 to 100,000,000 characters and is terminated by a line break or EOF.

### Output
An integer `L`.

#### Sample Input 1
```
DCBABCBA
```

#### Sample Output 1
```
3
```

#### Sample Input 2
```
$123 a b c A B C D a b c d 1234$
```

#### Sample Output 2
```
8
