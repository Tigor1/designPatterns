public class CarBuilder implements Builder {
    private String make = "default";
    private String model = "default";
    private String vin = "000000000";
    private TypeCar type = TypeCar.SEDAN;
    private int horsePower = 210;

    public void make(String make) {
        this.make = make;
    }

    public void model(String model) {
        this.model = model;
    }

    public void vin(String vin) {
        this.vin = vin;
    }

    public void typeCar(TypeCar type) {
        this.type = type;
    }

    public void horsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public Car build() {
        return new Car(make, model, vin, type, horsePower);
    }
}