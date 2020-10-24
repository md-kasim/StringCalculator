public class StringCalculator {

    private boolean isEmpty(String numbers){
        if(numbers.length()==0) return true;
        return false;
    }

    private int[] extractNumbers(String numbers) {
        if (isEmpty(numbers)) // for empty string
            return new int[0];
        return new int[0];
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
