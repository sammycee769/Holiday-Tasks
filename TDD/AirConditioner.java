public class AirConditioner{
    boolean isOn = false;
    int temperature = 30;
    
    public void turnOn(){
        isOn = true;
    } 
    
    public void turnOff(){
        isOn = false;
    } 
    
    public void increaseTemperature(){
        if (!isOn) {
            return;
        }

        if(temperature < 30){
            temperature++;
        }
    } 
    
    public void decreaseTemperature(){
        if (!isOn) {
        return;
        }

        if(temperature > 16){
            temperature--;
        }
    } 
}
