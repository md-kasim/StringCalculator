import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeAll
    public void init(){
        calculator = new StringCalculator();
    }

    @Test
    public void emptyStringTest(){
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void oneNumberTest(){
        assertEquals(6, calculator.add("6"));
    }

    @Test
    public void twoNumberTest(){
        assertEquals(14, calculator.add("6,8"));
    }

    @Test
    public void NNumberTest(){
        assertEquals(22, calculator.add("6,8,3,5"));
    }

    @Test
    public void newLineDelimiter(){
        assertEquals(22, calculator.add("6,8\n3,5"));
    }

    @Test
    public void customDelimiterTest(){
        assertEquals(3, calculator.add("//;\n2;1"));
    }

    @Test
    public void negativeNumberTest(){
        assertThrows(NegativeNumberException.class, ()->{
            calculator.add("1,-2");
        });
    }

    @Test
    public void multipleNegativesTest(){
        assertThrows(NegativeNumberException.class, ()->{
            calculator.add("//;\n1;-2;-3");
        });
    }

    @Test
    public void ignoreBiggerNumberTest(){
        assertEquals(2, calculator.add("2,1001"));
    }

    @Test
    public void delimiterOfAnyLengthTest(){
        assertEquals(7, calculator.add("//[***]\n1***2***4"));
    }

    @Test
    public void multipleDelimitersTest(){
        assertEquals(10, calculator.add("//[*][%]\n1*3%2*4"));
    }

    @Test
    public void multipleDelimitersOfAnyLengthTest(){
        assertEquals(27, calculator.add("//[***][%%%][#%#]\n1#%#7***4#%#5***2%%%8"));
    }
}