import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    static final SILab2 wow = new SILab2();

    static ArrayList<Time> createlist(Time... times) {
        return new ArrayList<Time>(Arrays.asList(times));
    }

    static ArrayList<Integer> createlist_int(Integer... ints) {
        return new ArrayList<Integer>(Arrays.asList(ints));
    }

    @Test
    void Every_branch() {
        System.out.println("wow");
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> wow.function(createlist
                (new Time(-1, 0, 0))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));
        ex = assertThrows(RuntimeException.class, () -> wow.function(createlist
                (new Time(25, 0, 0))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));
        ex = assertThrows(RuntimeException.class, () -> wow.function(createlist
                (new Time(23, -1, 0))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
        ex = assertThrows(RuntimeException.class, () -> wow.function(createlist
                (new Time(23, 0, 69))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));
        ex = assertThrows(RuntimeException.class, () -> wow.function(createlist
                (new Time(25, 0, 0))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
        assertEquals(createlist_int(82845), wow.function(createlist
                (new Time(23, 0, 45))));
    }

    @Test
    void Multiple_condition() {

        RuntimeException ex;
        assertEquals(createlist_int(82800), wow.function(createlist
                (new Time(23, 0, 0))));
        assertEquals(createlist_int(80723), wow.function(createlist
                (new Time(22, 25, 23))));
        ex = assertThrows(RuntimeException.class, () -> wow.function(createlist
                (new Time(21, 69, 0))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
        ex = assertThrows(RuntimeException.class, () -> wow.function(createlist
                (new Time(22, 23, 69))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

    }

}