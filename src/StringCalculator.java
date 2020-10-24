import java.util.regex.Pattern;
import java.util.regex.Matcher;


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
        String delimiter = extractDelimiter(numbersString[0]);
        numbersString = numbersString[1].split(delimiter);
        return numbersString;
    }

    private String hideMetaCharacter(String delimiter){
        String metaChars = ".\\+*^|$";
        for(char c:metaChars.toCharArray()){
            delimiter = delimiter.replace(Character.toString(c), "\\"+c);
        }
        return delimiter;
    }

    private String extractDelimiter(String str){
        String delimiter = "";
        if(str.endsWith("]")){
            Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(str);
            while (matcher.find()) {
                String exp = hideMetaCharacter(matcher.group(1));
                delimiter = delimiter + exp + "|";
            }
            delimiter = delimiter.replaceFirst(".$", "");
        }else{
            delimiter = str.substring(2);
            delimiter = hideMetaCharacter(delimiter);
        }
        return delimiter;
    }

    private void validateNumbers(int[] number){
        String negatives = "";
        for(int i=0;i<number.length;i++){
            if(number[i]<0) negatives = negatives + number[i] +", ";
            if(number[i]>1000) number[i] = 0;
        }
        if(!negatives.isEmpty()) throw new NegativeNumberException(negatives.replaceFirst(".{2}$", ""));
    }

    private int[] stringToInteger(String[] numbersString){
        int[] numbers = new int[numbersString.length];
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
