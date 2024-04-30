package br.fiap.turmaw.domain.vehicle.vehicles;

public class Car extends VehicleAtributes {
    private boolean airConditioning;

    public Car(String brand, String model, int year){
        super(brand, model, year);
        setMaxSpeed(180);
        setCurrentSpeed(100);
        this.airConditioning = false;
    }

    public void turnOnAirConditioning() {
        airConditioning = true;
        System.out.println("Ar condicionado ligado.");
    }

    public void turnOffAirConditioning() {
        airConditioning = false;
        System.out.println("Ar condicionado desligado.");
    }

    @Override
    public void getStatus() {
        super.getStatus();
        System.out.println("Ar Condicionado: " + (airConditioning ? "ligado" : "desligado"));
    }
}
