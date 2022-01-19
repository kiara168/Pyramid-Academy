import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DragonCaveWithUnitTestTest {

    DragonCaveWithUnitTest DragonCaveWithUnitTest;

    @BeforeEach
    void setUp() {
        DragonCaveWithUnitTest = new DragonCaveWithUnitTest();
    }

    @Test
    String Intro(){
        System.out.print(Intro());
        assertEquals("You are in a land full of Dragons. In front of you, \nyou see two caves. In one cave, the dragon is friendly \nand will share his treasure with you. The other dragon \nis greedy and hungry and will eat you on sight. \nWhich cave will you go into? (1 or 2)", Intro(), "test failed");
        return Intro();
    }

    @Test
    void WhichDragon(int x){
        System.out.print(DragonCaveWithUnitTest.WhichDragon(1));
        System.out.print(WhichDragon (2));
    }

    //@Test
   // void main(String[] args) {
        //System.out.print(main(String[] args));
        //assertEquals("",main(String[] args),"Test failed");
   // }

    @AfterEach
    void tearDown() {
    }

}