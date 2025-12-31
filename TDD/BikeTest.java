import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BikeTest{

    @Test
    void turnOnBike(){
    Bike bike = new Bike();
    bike.turnOn();
    assertTrue(bike.isOn);
    }

    @Test
    void turnOffBike(){
    Bike bike = new Bike();
    bike.turnOn();
    bike.turnOff();
    assertFalse(bike.isOn);
    }

    @Test
    void accelerateBikeInGearOne(){
    Bike bike = new Bike();
    bike.turnOn();
    bike.speed = 15;
    
    bike.accelerate();

    assertEquals(16, bike.speed);
    assertEquals(1, bike.gear);
    }

    @Test
    void accelerateBikeInGearTwo(){
    Bike bike = new Bike();
    bike.turnOn();
    bike.speed = 24;
    
    bike.accelerate();

    assertEquals(26, bike.speed);
    assertEquals(2, bike.gear);
    }

    @Test
    void accelerateBikeInGearThree(){
    Bike bike = new Bike();
    bike.turnOn();
    bike.speed = 35;
    
    bike.accelerate();

    assertEquals(38, bike.speed);
    assertEquals(3, bike.gear);
    }

    @Test
    void accelerateBikeInGearFour(){
    Bike bike = new Bike();
    bike.turnOn();
    bike.speed = 44;
    
    bike.accelerate();

    assertEquals(48, bike.speed);
    assertEquals(4, bike.gear);
    }

    @Test
    void decelerateInGearOne() {
    Bike bike = new Bike();
    bike.turnOn();
    bike.speed = 15;

    bike.decelerate();

    assertEquals(14, bike.speed);
    assertEquals(1, bike.gear);
    }

    @Test
    void decelerateInGearTwo() {
    Bike bike = new Bike();
    bike.turnOn();
    bike.speed = 24;

    bike.decelerate();

    assertEquals(22, bike.speed);
    assertEquals(2, bike.gear);
    }

    @Test
    void decelerateInGearThree() {
    Bike bike = new Bike();
    bike.turnOn();
    bike.speed = 35;

    bike.decelerate();

    assertEquals(32, bike.speed);
    assertEquals(3, bike.gear);
    }

    @Test
    void decelerateInGearFour() {
    Bike bike = new Bike();
    bike.turnOn();
    bike.speed = 45;

    bike.decelerate();

    assertEquals(41, bike.speed);
    assertEquals(4, bike.gear);
    }

    @Test
    void bikeDoesNotAccelerateWhenOff() {
    Bike bike = new Bike();
    bike.speed = 20;

    bike.accelerate();

    assertEquals(20, bike.speed);
    assertFalse(bike.isOn);
    }

    @Test
    void speedNeverGoesBelowZero() {
    Bike bike = new Bike();
    bike.turnOn();
    bike.speed = 1;

    bike.decelerate();

    assertEquals(0, bike.speed);
    assertEquals(1, bike.gear);
    }

    @Test
    void acceleratingWhileOffDoesNothing() {
    Bike bike = new Bike();
    bike.speed = 30;

    bike.accelerate();

    assertEquals(30, bike.speed);
    assertFalse(bike.isOn);
    }

}
