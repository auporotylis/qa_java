import com.example.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.mockito.*;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    public String sex;

    @Parameterized.Parameters
    public static Object[][] lionSexData() {
        return new Object[][]{
                {"Самец"},
                {"Самка"},
                {"Медуза"},
        };
    }

    public LionParameterizedTest(String sex) {
        this.sex = sex;
    }

    @Test
    public void doesHaveManeShouldBeTrueForMaleAndFalseForFemale() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, mockFeline);
        if (sex.equals("Самец")) {
            Assert.assertTrue("Самец без гривы", lion.doesHaveMane());
        } else if (sex.equals("Самка")) {
            Assert.assertFalse("Самка с гривой", lion.doesHaveMane());
        }
    }
}