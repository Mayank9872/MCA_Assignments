class Device{
   String deviceId;
   void displayStatus(){
      System.out.println("\nDevice ID : "+deviceId);
    }
}

class Thermostat extends Device{
    double temperatureSetting;
    void displayStatus(){
      System.out.println("\nDevice ID : "+deviceId);
      System.out.println("\nTemperature setting : "+temperatureSetting+"degree Celsius");
    }
}
public class smartHomeDevice{
   public static void main(String[] args) {
       Thermostat thrm=new Thermostat();
       thrm.deviceId="12A";
       thrm.temperatureSetting=34.56;
       thrm.displayStatus();
   }
}