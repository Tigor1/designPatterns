public class CarDirector {
    public void buildBMWM5(Builder builder) {
        builder.make("BMW");
        builder.model("X5");
        builder.vin("12H42P415");
        builder.typeCar(TypeCar.SUV);
        builder.horsePower(340);
    }

    public void buildMercedesS500(Builder builder) {
        builder.make("Mercedes-benz");
        builder.model("S500");
        builder.vin("1352KL98Y");
        builder.typeCar(TypeCar.SEDAN);
        builder.horsePower(450);
    }
}