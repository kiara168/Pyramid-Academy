import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DragonCaveWithUnitTestTest {

    DragonCaveWithUnitTest DragonCaveWithUnitTest;

    @BeforeEach
    void setUp() {
        DragonCaveWithUnitTest = new DragonCaveWithUnitTest();
    }

    @Test
    void WhichDragon(){
        assertEquals("You approach the cave... \nIt is dark and spooky... \nA large dragon jumps out in front of you! He opens his jaws and... \nGobbles you down in one bite!", DragonCaveWithUnitTest.WhichDragon(1), "test 1 failed");
        assertEquals("You approach the cave... \nIt is dark and spooky... \nA large dragon jumps out in front of you! He opens his jaws and... \nTells you that you can take as much treasure as you want!", DragonCaveWithUnitTest.WhichDragon(2), "Test 2 failed");
    }


    @AfterEach
    void tearDown() {
    }

}