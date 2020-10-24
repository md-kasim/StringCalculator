public class NegativeNumberException extends RuntimeException{

    public NegativeNumberException(int number){
        System.out.println("negatives not allowed : "+number);
    }

}
