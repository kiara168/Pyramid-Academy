import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DragonCaveWithUnitTestTest {

    @BeforeEach
    void setUp() {
        Object DragonCaveWithUnitTest = new DragonCaveWithUnitTest();
    }

    @Test
    void main(String[] args) {
        int a = 1;
        System.out.print(DragonCaveWithUnitTest.main(String[] args));
        assertEquals("",DragonCaveWithUnitTest.main(),"Test failed");
    }

    @AfterEach
    void tearDown() {
    }

}