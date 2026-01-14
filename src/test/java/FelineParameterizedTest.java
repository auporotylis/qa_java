import com.example.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    public int kittens;
    public int expectedKittens;

    public FelineParameterizedTest(int kittens, int expectedKittens){
        this.kittens = kittens;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getKittenData() {
        return new Object[][]{
                {5, 5},
                {3, 3},
        };
    }

    @Test
    public void getKittensWithParamShouldReturnPassedValue() {
        Feline feline = new Feline();

        int actualKittens = feline.getKittens(kittens);
        Assert.assertEquals("Количество котят не совпадает с ожидаемым", expectedKittens, actualKittens);
    }
}