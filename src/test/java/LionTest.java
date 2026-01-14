import com.example.*;
import org.junit.*;
import org.mockito.*;

import java.util.*;

public class LionTest {

    @Test
    public void getKittensShouldReturnValueFromFeline() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when((mockFeline).getKittens()).thenReturn(2);

        Lion lion = new Lion("Самец", mockFeline);
        int kittens = lion.getKittens();

        Assert.assertEquals("Ожидалось 2 котенка вместо " + kittens, 2, kittens);
        Mockito.verify(mockFeline).getKittens();
    }

    @Test
    public void getKittensShouldCallGetKittens() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when((mockFeline).getKittens()).thenReturn(2);

        Lion lion = new Lion("Самец", mockFeline);
        lion.getKittens();

        Mockito.verify(mockFeline).getKittens();
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.getFood("Хищник")).
                thenReturn(Arrays.asList("Кашка", "Молочко", "Творожок"));

        Lion lion = new Lion("Самец", mockFeline);
        List<String> expectedFood = Arrays.asList("Кашка", "Молочко", "Творожок");
        List<String> actualFood = lion.getFood();

        Assert.assertEquals("Ожидалась другая еда для льва", expectedFood, actualFood);
    }

    @Test
    public void getFoodShouldCallGetFoodForPredator() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.getFood("Хищник")).
                thenReturn(Arrays.asList("Кашка", "Молочко", "Творожок"));

        Lion lion = new Lion("Самец", mockFeline);
        lion.getFood();

        Mockito.verify(mockFeline).getFood("Хищник");
    }
}

