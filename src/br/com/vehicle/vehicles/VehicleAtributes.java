package br.com.vehicle.vehicles;

public class VehicleAtributes {
    private String brand;
    private String model;
    private int year;
    private int maxSpeed;
    private int currentSpeed;

    public VehicleAtributes(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    //Methods
    public int accelerate(int increment) {
        if (currentSpeed + increment > maxSpeed) {
            currentSpeed = maxSpeed;
        } else {
            currentSpeed += increment;
        }
        return increment;
    }

    public int reduceSpeed(int decrement) {
        if (currentSpeed + decrement > maxSpeed) {
            currentSpeed = maxSpeed;
        } else {
            currentSpeed += decrement;
        }
        return decrement;
    }

    public void getStatus() {
        System.out.println("Marca: " + brand);
        System.out.println("Modelo: " + model);
        System.out.println("Ano: " + year);
        System.out.println("Velocidade Máxima: " + maxSpeed + " km/h");
        System.out.println("Velocidade Atual: " + currentSpeed + " km/h");
    }

    //Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }


}
