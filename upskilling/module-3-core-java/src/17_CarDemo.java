class Car {
    String make;
    String model;
    int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    void displayDetails() {
        System.out.println(year + " " + make + " " + model);
    }
}

class CarDemo {
    public static void main(String[] args) {
        new Car("Toyota", "Corolla", 2024).displayDetails();
    }
}

