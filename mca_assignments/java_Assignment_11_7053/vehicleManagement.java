class Vehicle{
   String model;
   Double maxSpeed;
}

interface Refuelable{
    void refuel();
}

class ElectricVehicle extends Vehicle{
    double charging;
    public void charge(){
        System.out.println("Electric vehicle is fully charged.");
    }
    void show(){
        System.out.println("Electric vehicle details :\n");
        System.out.println("Model : "+model);
        System.out.println("Max speed : "+maxSpeed+" km per hour");
        System.out.println("Available charging : "+charging+" %");
        
    }
}
class PetrolVehicle extends Vehicle implements Refuelable{
    double petrol;
    public void refuel(){
        System.out.println("Petrol vehicle is fully fueled.");
    }
    void show(){
        System.out.println("Petrol vehicle details :\n");
        System.out.println("Model : "+model);
        System.out.println("Max speed : "+maxSpeed+" km per hour");
        System.out.println("Available fuel : "+petrol+" litre");
        
    }
}
public class vehicleManagement{
    public static void main(String[] args) {
        ElectricVehicle ev=new ElectricVehicle();
        ev.model="Ev-123B";
        ev.maxSpeed=87.5;
        ev.charging=65.8;
        ev.show();
        ev.charge();

        PetrolVehicle pv=new PetrolVehicle();
        pv.model="D-45C";
        pv.maxSpeed=100.0;
        pv.petrol=0.63;
        pv.show();
        pv.refuel();
    }
}