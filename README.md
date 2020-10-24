# StringCalculator
### Online Technical Assessment ###
1. Create a simple String calculator with a method signature:
    1. int Add(string numbers)
    2. The method can take up to two numbers, separated by commas, and will return their sum. 
    3. for example “” or “1” or “1,2” as inputs.
    4. (for an empty string it will return 0)
2. Allow the Add method to handle an unknown amount of numbers
3. Allow the Add method to handle new lines between numbers (instead of commas).
4. Support different delimiters to change a delimiter, the beginning of the string will contain a separate line that looks like this: “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
5. Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed. 
6. if there are multiple negatives, show all of them in the exception message.
7. Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
8. Delimiters can be of any length with the following format: “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
9. Allow multiple delimiters like this: “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.
