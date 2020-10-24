public class StringCalculator {

    private boolean isEmpty(String numbers){
        return numbers.length() == 0;
    }

    private String[] splitNumbers(String numbers){
        String[] numbersString;
        if(numbers.startsWith("//")){
            numbersString = splitNumbersWithCustomDelimiter(numbers);
        }else {
            numbersString = numbers.split("[\n,]+");
        }
        return numbersString;
    }

    private String[] splitNumbersWithCustomDelimiter(String numbers){
        String[] numbersString = numbers.split("[\n]+", 2);
        String delimiter = numbersString[0].substring(2);
        numbersString = numbersString[1].split(delimiter);
        return numbersString;
    }

    private void validateNumbers(int[] numbers){
        for(int n:numbers){
            if(n<0) throw new NegativeNumberException(n);
        }
    }

    private int[] stringToInteger(String[] numbersString){
        int numbers[] = new int[numbersString.length];
        for(int i=0;i< numbersString.length;i++){
            numbers[i] = Integer.parseInt(numbersString[i]);
        }
        return numbers;
    }

    private int[] extractNumbers(String numbers) {
        if (isEmpty(numbers)) // for empty string
            return new int[0];

        String[] numbersString = splitNumbers(numbers);

        int[] numberArray = stringToInteger(numbersString);

        validateNumbers(numberArray);

        return numberArray;
    }

    private int getSum(int[] numberArray){
        int sum=0;
        for(int n:numberArray){
            sum += n;
        }
        return sum;
    }

    public int add(String numbers){
        int[] numberArray = extractNumbers(numbers);
        return getSum(numberArray);
    }
}
