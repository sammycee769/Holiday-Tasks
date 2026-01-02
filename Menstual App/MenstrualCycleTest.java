import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MenstrualCycleTest {

    @Test
    void nextFlowDate_shouldBeMarch29() {
        String result = MenstrualCycle.getNextFlowDate(1, 3, 28);
        assertEquals("March 29", result);
    }

    @Test
    void ovulationDate_shouldBeMarch15() {
        String result = MenstrualCycle.getOvulationDate(1, 3, 28);
        assertEquals("March 15", result);
    }

    @Test
    void fertileWindowStart_shouldBeMarch10() {
        String result = MenstrualCycle.getFertileWindowStart(1, 3, 28);
        assertEquals("March 10", result);
    }

    @Test
    void fertileWindowEnd_shouldBeMarch15() {
        String result = MenstrualCycle.getFertileWindowEnd(1, 3, 28);
        assertEquals("March 15", result);
    }

    @Test
    void safePeriodOneStart_shouldBeMarch1() {
        String result = MenstrualCycle.getSafePeriodStartOne(1, 3);
        assertEquals("March 1", result);
    }

    @Test
    void safePeriodOneEnd_shouldBeMarch9() {
        String result = MenstrualCycle.getSafePeriodEndOne(1, 3, 28);
        assertEquals("March 9", result);
    }

    @Test
    void safePeriodTwoStart_shouldBeMarch16() {
        String result = MenstrualCycle.getSafePeriodStartTwo(1, 3, 28);
        assertEquals("March 16", result);
    }

    @Test
    void safePeriodTwoEnd_shouldBeMarch28() {
        String result = MenstrualCycle.getSafePeriodEndTwo(1, 3, 28);
        assertEquals("March 28", result);
    }

    @Test
    void nextFlowDate_shouldMoveToNextMonth() {
        String result = MenstrualCycle.getNextFlowDate(25, 1, 10);
        assertEquals("February 4", result);
    }

    @Test
    void nextFlowDate_shouldMoveToNextYear() {
        String result = MenstrualCycle.getNextFlowDate(20, 12, 15);
        assertEquals("January 4", result);
    }

}

