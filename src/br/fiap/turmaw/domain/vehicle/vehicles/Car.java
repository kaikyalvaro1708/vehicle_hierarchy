package br.fiap.turmaw.domain.vehicle.vehicles;

public class Car extends VehicleAtribute {
    private boolean airConditioningOn;
    private boolean carOn;

    public Car(String brand, String model, int year){
        super(brand, model, year);
        setMaxSpeed(180);
        setCurrentSpeed(100);
    }
    public boolean isCarOn () {
        if (getCurrentSpeed() == 0 ){
            System.out.println("Ar Condicionado e o carro estão desligados");
            return carOn == false && airConditioningOn == false;
        }
        System.out.println("Ar Condicionado: ligado");
        return true;
    }
}
