import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @ParameterizedTest(name = "[{index}] {3}")
    @CsvSource(
            value = {
                    "'registered user, under limit', 100060, 30, true",
                    "'registered user, over limit', 100000060, 500, true",
                    "'unregistered user, under limit', 100061, 10, false",
                    "'unregistered user, over limit', 250000000, 500, false",
                    "'registered user, over limit', 350000000, 500, true",
                    "'unregistered user, over limit', 55000000, 500, false",

            }
    )
    void shouldCalculate(String test, long amount, long expected, boolean registered) {
        BonusService service = new BonusService();

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}


