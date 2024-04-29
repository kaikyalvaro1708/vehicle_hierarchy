package br.com.vehicle;

import br.com.vehicle.vehicles.Car;
import br.com.vehicle.vehicles.Motorcycle;
import br.com.vehicle.vehicles.Truck;

public class MenuVehicles {
    public static void menuVehicles() {
        int increment;

        System.out.println("""
                --------------------
                Informações do carro: 
                """);
        Car car = new Car("Ford", "Focus", 2020);
        car.getStatus();
        System.out.println("""
                ----------------------------------
                Status do carro depois de acelerar
                e ligar o ar-condicionado:
                ----------------------------------""");
        increment = 90; //valor de aceleração
        //Faz a verificação se o valor da aceleração somado com a velocidade atual
        // é maior que o limite máximo estabelicido
        // se for, vai decrementar a velocidade até a velocidade máxima permitida
        if (car.getCurrentSpeed() + increment > car.getMaxSpeed()) {
            car.reduceSpeed(car.getCurrentSpeed() + increment - car.getMaxSpeed());
        }
        car.accelerate(increment);
        car.turnOnAirConditioning();
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
        increment = 9;
        if (motorcycle.getCurrentSpeed() + increment > motorcycle.getMaxSpeed()) {
            motorcycle.reduceSpeed(motorcycle.getCurrentSpeed() + increment - motorcycle.getMaxSpeed());
        }
        motorcycle.accelerate(increment);
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
        increment = 10;
        if (truck.getCurrentSpeed() + increment > truck.getMaxSpeed()) {
            truck.reduceSpeed(truck.getCurrentSpeed() + increment - truck.getMaxSpeed());
        }
        truck.accelerate(increment);
        truck.transportCargo(1.5);
        truck.getStatus();
    }
}