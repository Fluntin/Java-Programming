# Comment Remover

This program removes comments from a text written by the author Filip. Filip tends to write comments to himself while writing books. To distinguish comments from regular text, he begins and ends comments with special characters. Earlier in his career, he used "%" to start and end comments, so his text looked like this:

"Charles knocked on the door and a woman opened it. % Don't forget that Charles has already met this woman in chapter 5! % She looked at him.

- Yes?, she said."

Later on, Filip decided to start comments with "/*" and end them with "*/". With this format, his text looks like this:

"Charles knocked on the door and a woman opened it. /* Don't forget that Charles has already met this woman in chapter 5! */ She looked at him.

- Yes?, she said."

Now Filip uses both systems alternately, so the same text may contain both comments between two "%" characters and comments between "/*" and "*/". This drives his publisher crazy. Your task is to write a program that removes all comments from Filip's manuscript and keeps only the text.

## Input

The input consists of text with comments. You can assume that the text is between 2 and 10,000 characters long and only contains the characters a-z, A-Z, 0-9, and some common punctuation marks (.,!?%/*'-).

## Output

The output should contain the filtered text without comments. If a comment is opened, either with "%" or "/*", but is never closed, it is assumed to continue until the end of the text.

## Usage

To run the program, provide the input text as described above and execute it. Here's an example of how to run it:

```shell
$ python comment_remover.py input.txt
```

The program will then display the text with comments removed.

## Sample Input and Output

### Sample Input
```
Charles knocked on the door and a woman 
opened it. % Don't forget that Charles 
has already met this woman in chapter 5! % 
She looked at him.
- Yes?, she said.
```

### Sample Output
```
Charles knocked on the door and a woman 
opened it.  
She looked at him.
- Yes?, she said.
```