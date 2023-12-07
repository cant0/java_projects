interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    private String make;
    private String color;
    private String model;
    private int year;

    public Car(String make, String color, String model, int year) {
        this.make = make;
        this.color = color;
        this.model = model;
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println("Starting the car...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the car...");
    }

    @Override
    public String toString() {
        return year + " " + color + " " + make + " " + model;
    }
}

public class vehicleinterface {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Blue", "Camry", 2022);
        Car car2 = new Car("Ford", "Red", "Mustang", 2021);
        Car car3 = new Car("Honda", "Silver", "Accord", 2023);

        car1.start();
        car1.stop();

        car2.start();
        car2.stop();

        car3.start();
        car3.stop();

        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);
        System.out.println("Car 3: " + car3);
    }
}