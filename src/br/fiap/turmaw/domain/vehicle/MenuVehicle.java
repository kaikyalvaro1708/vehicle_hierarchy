package br.fiap.turmaw.domain.vehicle;

import br.fiap.turmaw.domain.vehicle.vehicles.Car;
import br.fiap.turmaw.domain.vehicle.vehicles.Motorcycle;
import br.fiap.turmaw.domain.vehicle.vehicles.Truck;

public class MenuVehicle {
    public static void menuVehicles() {
        int speed;

        System.out.println("""
                --------------------
                Informações do carro:
                """);
        Car car = new Car("Ford", "Focus", 2020);
        car.getStatus();
        System.out.println("""
                ----------------------------------
                Status do carro depois de acelerar ou
                desacelerar e ligar o ar-condicionado:
                ----------------------------------""");
        speed = 100; //valor de aceleração ou desaceleração
        //car.accelerate(speed);
        car.reduceSpeed(speed);
        car.isCarOn();
        car.getStatus();

        //#######################################################################//

        System.out.println("""
                --------------------
                Informações da moto:
                """);
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR 1000", 2022);
        motorcycle.getStatus();
        System.out.println("""
                ----------------------------------
                Status da moto depois de acelerar e 
                verificar se é possível empinar ou não:
                ----------------------------------""");
        speed = 9;
        motorcycle.accelerate(speed);
        //motorcycle.reduceSpeed(speed);
        motorcycle.wheelie();
        motorcycle.getStatus();

        //#######################################################################//

        System.out.println("""
                ------------------------
                Informações do caminhão: 
                """);

        Truck truck = new Truck("Scania", "R500", 2019);
        truck.getStatus();
        System.out.println("""
                ----------------------------------
                Status do caminhão depois de acelerar
                e verificar o tamanho da carga:
                ----------------------------------""");
        speed = 10;
        truck.accelerate(speed);
        //truck.reduceSpeed(speed);
        truck.transportCargo(0.5);
        truck.getStatus();
    }
}