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
    public void emptyString(){
        assertEquals(0, calculator.add(""));
    }
}