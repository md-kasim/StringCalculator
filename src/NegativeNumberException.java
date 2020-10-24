public class NegativeNumberException extends RuntimeException{

    public NegativeNumberException(String number){
        System.out.println("negatives not allowed : "+number);
    }

}
