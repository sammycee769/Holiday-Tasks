public class Bike{
    boolean isOn = false;
    int speed = 0;
    int gear = 1;

    public void turnOn(){
        isOn =  true;
    }    
    public void turnOff(){
        isOn = false;
    }
    public void updateGear() {
        if (speed <= 20) {
            gear = 1;
        } else if (speed <= 30) {
            gear = 2;
        } else if (speed <= 40) {
            gear = 3;
        } else {
            gear = 4;
        }
    }
    public void accelerate(){
        if (!isOn) 
        return;
        updateGear();
        speed += gear;
        updateGear();
    }
    public void decelerate(){
        if (!isOn) 
        return;
        updateGear();
        speed -= gear;
        if (speed < 0) 
            speed = 0;
        updateGear();
    }
} 
