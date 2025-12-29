import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirConditionerTest{

    @Test
    void turnOnAcIfItExists(){
    AirConditioner ac = new AirConditioner();
    ac.turnOn();
    assertTrue(ac.isOn);
    }

    @Test
    void turnOffAcIfItExists(){
    AirConditioner ac = new AirConditioner();
    ac.turnOn();
    ac.turnOff();
    assertFalse(ac.isOn);
    }

    @Test
    void turnOffAcWhenItsAlreadyOff(){
    AirConditioner ac = new AirConditioner();
    ac.turnOff();
    assertFalse(ac.isOn);
    }

    @Test
    void turnOnAcWhenItsAlreadyOn(){
    AirConditioner ac = new AirConditioner();
    ac.turnOn();
    ac.turnOn();
    assertTrue(ac.isOn);
    }

    @Test
    void increaseTemperatureAbove30(){
    AirConditioner ac = new AirConditioner();
    ac.turnOn();

    ac.increaseTemperature();
    assertEquals(30, ac.temperature);
    }

    @Test
    void increaseTemperaturebelow30(){
    AirConditioner ac = new AirConditioner();
    ac.turnOn();
    ac.decreaseTemperature();
    ac.decreaseTemperature();
    ac.decreaseTemperature();

    ac.increaseTemperature();
    assertEquals(28, ac.temperature);
    assertTrue(ac.isOn);
    }

    @Test
    void decreaseTemperatureBelow16(){
    AirConditioner ac = new AirConditioner();
    ac.turnOn();
    ac.temperature = 16;

    ac.decreaseTemperature();
    assertEquals(16, ac.temperature);
    assertTrue(ac.isOn);
    }

    @Test
    void decreaseTemperatureAbove16(){
    AirConditioner ac = new AirConditioner();
    ac.turnOn();

    ac.decreaseTemperature();
    assertEquals(29, ac.temperature);
    assertTrue(ac.isOn);
    }

    @Test
    void decreaseTemperatureAbove16WhenAcIsOff(){
    AirConditioner ac = new AirConditioner();

    int previousTempperatue = ac.temperature;
    ac.decreaseTemperature();                 
    assertEquals(previousTempperatue, ac.temperature);    
    assertFalse(ac.isOn);   
    }
    @Test
    void increaseTemperatureAbove16WhenAcIsOff(){
    AirConditioner ac = new AirConditioner();

    int previousTempperatue = ac.temperature;
    ac.increaseTemperature();                 
    assertEquals(previousTempperatue, ac.temperature);    
    assertFalse(ac.isOn);   
    }
}
