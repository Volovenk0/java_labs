import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringCalculatorTest {
    StringCalculator stringCalculator;


    @BeforeEach
    void start(){
        stringCalculator = new StringCalculator();
    }

    @Test
    void firstTest(){
        assertEquals(3, stringCalculator.add("1,2"), "Work.");
    }

    @Test
    void secondTest(){
        assertEquals(68, stringCalculator.add("17,19,32"), "Work.");
    }

    @Test
    void thirdTest(){
        assertEquals(6, stringCalculator.add("1\n2,3"), "Work.");
    }

    @Test
    void fourthTest(){
        assertEquals(3, stringCalculator.add("//[;]\\n1;2"), "Work.");
    }

    @Test
    void fifthTest(){
        assertEquals(1,stringCalculator.add("//[;]\\n1;-2"), "Work.");
    }

    @Test
    void sixthTest(){
        assertEquals(1999, stringCalculator.add("1000,999,1001"), "Work.");
    }

    @Test
    void seventhTest(){
        assertEquals(6,stringCalculator.add("//[*]\\n1*2**3"), "Work.");
    }

    @Test
    void eighthTest(){
        assertEquals(6, stringCalculator.add("//[*][%]\\n1*2%3"), "Work.");
    }

    @Test
    void ninthTest(){
        assertEquals(6,stringCalculator.add("//[*][%]\\n1***2%%3"), "Work.");
    }

    @Test
    void tenthTest(){
        assertEquals(5,stringCalculator.add("//[*][%]\n1a*2%3"), "Work.");
    }


}
