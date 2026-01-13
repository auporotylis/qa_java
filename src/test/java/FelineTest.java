import com.example.*;
import org.junit.*;
import java.util.*;

public class FelineTest {

    @Test
    public void eatMeatShouldReturnPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals("Ожидалась еда: \"Животные\", \"Птицы\", \"Рыба\"", expectedFood, actualFood);
    }

    @Test
    public void getFamilyShouldReturnFeline() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();
        Assert.assertEquals("Ожидалось семейство кошачьих", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensShouldReturnOneKitten() {
        Feline feline = new Feline();
        int expectedKittens = 1;

        int actualKittens = feline.getKittens();
        Assert.assertEquals("Ожидался один котенок", expectedKittens, actualKittens);
    }
}