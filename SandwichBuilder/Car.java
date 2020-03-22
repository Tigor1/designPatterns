/**
 * Если же Вы придумаете какой-нибудь сложный объект, который очень трудно создавать и настраивать... вот тогда возникнет желание создать для него билдер.
 * И если Вы создадите для него понятный и простой билдер, то тогда не будет возникать в конце вполне себе адекватный вопрос: "А зачем всё это нужно?".
 * Зачем нужен этот паттерн?
 * Например: нужно создать Http Client-а. Но там очень много настроек, нужно прописывать протокол, если HTTPS то нужно прописывать сертификат, нужно ещё прокси,
 * прокси бывают разных типов; ещё нужна аутентификация - аутентификации бывают разные - получается, чтобы сделать какой-нибудь простой Http-запрос приходитсья
 * вываливать тонну когда.... хренова... чё-делать... и вот тут приходит на помощь билдер, который легко и просто в лесничной нотации позволяет всё это создать,
 * а сам процесс нудного создания HttpClient-а спрятать у себя где-то внутрях. В результате код получается чистый и аккуратный.
 * И вопроса "Зачем это нужно?", - не возникнет, потому что понятно зачем.Пусть у нас есть класс Car у которого в конструкторе много однотипных полей
 * */
public class Car {
    private final String make;
    private final String model;
    private final String vin;
    private TypeCar type;
    private int horsePower;

    public Car(CarBuilder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.vin = builder.vin;
        this.type = builder.type;
        this.horsePower = builder.horsePower;
    }

    public void setType(TypeCar type) {
        this.type = type;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public TypeCar getType() {
        return type;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return "make: " + make + "\nmodel: " + model + "\nvin: " + vin + "\ntype: " + type + "\nHorsepower: " + horsePower;
    }

    public static class CarBuilder implements Builder {
        //default value
        String make = "default make";
        String model = "default model";
        String vin = "000000000";
        TypeCar type = TypeCar.SEDAN;
        int horsePower = 180;

        public Builder make(String make) {
            this.make = make;
            return this;
        }
    
        public Builder model(String model) {
            this.model = model;
            return this;
        }
    
        public Builder vin(String vin) {
            this.vin = vin;
            return this;
        }
    
        public Builder typeCar(TypeCar type) {
            this.type = type;
            return this;
        }
    
        public Builder horsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }
    
        public Car build() {
            return new Car(this);
        }

        @Override
        public String toString() {
            return "make: " + make + "\nmodel: " + model + "\nvin: " + vin + "\ntype: " + type + "\nHorsepower: " + horsePower;
        }
    }    
}

enum TypeCar {
    SEDAN, SUV, COUPE, CROSSOVER;
}

class Main {
    public static void main(String[] args) {
        /**
         *  При создании такого объекта легко перепутать поля. Например я задал полю vin model.
         */
        //Car car = new Car("Mercedes-benz", "12H241Kd344", "s500",  TypeCar.SEDAN, 550);
        /**
         *  Теперь понятно какие именно поля обЪекта мы задаем при создании
         */
        Car car = new Car.CarBuilder()
                    .make("BMW")
                    .model("X5")
                    .vin("124873HUI")
                    .typeCar(TypeCar.SUV)
                    .build();
        System.out.println(car);    
    }
}