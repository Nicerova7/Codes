
# Corrector spelling ("Did you mean ... ?")

## Description

   We have a list of words which will be the set to run our code.
   An user will type a word:
   * If this word is in the list return a positive message.
   * If this word isn't in the list return a error message and a word will be suggested.

Note: We have few words, in this case words which begin with a letter.

## Examples

### Correct word

~~~
Type a word: almost
Word is spelled correctly.
~~~

~~~
Type a word: argue
Word is spelled correctly.
~~~

### Incorrect word

~~~
Type a word: akone
Word is not spelled correctly.
Did you mean "alone" ?
~~~

~~~
Type a word: american
Word is not spelled correctly.
Did you mean "American"?
~~~

~~~
Type a word: Aturod
Word is not spelled correctly.
No suggestion
~~~

## Future

   This code is only the little first part to a great corrector spelling.
   We hope to connect to a database and extract and compare with these words.
   Also other ideas will arise.

   

   