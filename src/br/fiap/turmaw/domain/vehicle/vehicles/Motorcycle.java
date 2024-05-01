package br.fiap.turmaw.domain.vehicle.vehicles;

public class Motorcycle extends VehicleAtribute {
    public Motorcycle(String brand, String model, int year) {
        super(brand, model, year);
        setMaxSpeed(120);
        setCurrentSpeed(40);
    }

    public void wheelie() {
        if (getCurrentSpeed() > 20 && getCurrentSpeed() < 50) {
            System.out.println("Moto empinada!");
        } else {
            System.out.println("Não é possível empinar a moto nesta velocidade.");
        }
    }
}
