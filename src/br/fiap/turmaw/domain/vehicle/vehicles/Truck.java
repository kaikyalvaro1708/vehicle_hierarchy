package br.fiap.turmaw.domain.vehicle.vehicles;

public class Truck extends VehicleAtribute {
    public Truck(String brand, String model, int year) {
        super(brand, model, year);
        setMaxSpeed(100);
        setCurrentSpeed(70);
    }

    public void transportCargo(double cargo) {
        if (cargo <= 1.0) {
            System.out.println("Carga de " + cargo + " toneladas transportada.");
        }
        System.out.println("Carga muito pesada para este caminhão.");
    }
}
