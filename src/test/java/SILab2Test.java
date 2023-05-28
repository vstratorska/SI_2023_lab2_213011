import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private final SILab2 obj = new SILab2();

    @Test
     void functionEveryBranchTest()
    {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> obj.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        assertEquals(false, obj.function(new User(null, "Strumicaa**", "viktorija.s@gmail.com"), Arrays.asList(new User("olivera", "pasvord2233$", "oli.vera@yahoo.com"), new User("viktorija.s@gmail.com", "Strumicaa**", "viktorija.s@gmail.com"))));
        assertEquals(false, obj.function(new User("viksi", "pass123", "mail.gmail.com"), null));
        assertEquals(false, obj.function(new User("viksi", "12345 pass", "mail.gmail.com"), null));
        assertEquals(false, obj.function(new User("viksi", "pass12345", "mail.gmail.com"), null));
    }

    @Test
    void functionMultipleConditionTest()
    {
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> obj.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> obj.function(new User("Viktorija", null, null), null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> obj.function(new User("Viktorija", "pass12345", null), null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        assertEquals(true, obj.function(new User("Viktorija", "pass12345*", "viktorija.stra@gmail.com"), Arrays.asList(new User("olivera", "pasvord2233$", "oli.vera@yahoo.com"), new User("viktorija.s@gmail.com", "Strumicaa**", "viktorija.s@gmail.com"))));
    }
}