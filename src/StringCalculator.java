public class StringCalculator {

    private boolean isEmpty(String numbers){
        if(numbers.length()==0) return true;
        return false;
    }

    private String[] splitNumbers(String numbers){
        String[] numbersString = numbers.split(",");
        return numbersString;
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

        return stringToInteger(numbersString);
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
        int sum = getSum(numberArray);
        return sum;
    }
}
