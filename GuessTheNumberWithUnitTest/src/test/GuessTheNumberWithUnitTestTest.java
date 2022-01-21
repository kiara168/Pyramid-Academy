import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberWithUnitTestTest {

    GuessTheNumberWithUnitTest GuessTheNumberWithUnitTest;

    @BeforeEach
    void setUp() {
        GuessTheNumberWithUnitTest = new GuessTheNumberWithUnitTest();
    }

    @Test
    void  toHigh() {
        assertEquals("Your guess is too high. \nTake a guess.", GuessTheNumberWithUnitTest.toHigh(), "test failed");
    }

    @Test
    void  toLow() {
        assertEquals("Your guess is too low. \nTake a guess.", GuessTheNumberWithUnitTest.toLow(), "test failed");
    }

    @AfterEach
    void tearDown() {
    }


}