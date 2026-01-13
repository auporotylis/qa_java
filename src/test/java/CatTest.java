import com.example.*;
import org.junit.*;
import org.mockito.*;

import java.util.*;

public class CatTest {

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.eatMeat()).
                thenReturn(Arrays.asList("Кашка", "Молочко", "Творожок"));
        Cat cat = new Cat(mockFeline);

        List<String> expectedFood = Arrays.asList("Кашка", "Молочко", "Творожок");
        List<String> actualFood = cat.getFood();

        Assert.assertEquals("Ожидалась еда для хищника: \"Кашка\", \"Молочко\", \"Творожок\"", expectedFood, actualFood);
        Mockito.verify(mockFeline).eatMeat();
    }

    @Test
    public void getSoundShouldReturnMeow() {
        Feline mockFeline = Mockito.mock(Feline.class);
        Cat cat = new Cat(mockFeline);

        String expectedSound = "Мяу";
        String actualSound = cat.getSound();

        Assert.assertEquals("Кошка издала не \"Мяу\"", expectedSound, actualSound);
    }
}