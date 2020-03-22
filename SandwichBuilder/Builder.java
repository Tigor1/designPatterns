interface Builder {
    Builder make(String make);
    Builder model(String model);
    Builder vin(String vin);
    Builder typeCar(TypeCar type);
    Builder horsePower(int horsePower);
    Car build();
}