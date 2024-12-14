package task3.sensor;

public class Main {
    public static void main(String[] args) {

        TemperatureSensor celsiusSensor = new CelsiusSensor(100);
        System.out.println("Температура з celsiusSensor " + celsiusSensor.getTemperature());

        FahrenheitSensor fahrenheitSensor = new FahrenheitSensor(100);

        TemperatureSensor adapter = new TemperatureAdapter(fahrenheitSensor);
        System.out.println("Температура з fahrenheitSensor через адаптер: " + adapter.getTemperature());
    }
}

interface TemperatureSensor {
    double getTemperature();
}

class CelsiusSensor implements TemperatureSensor {
    private double temperature;

    public CelsiusSensor(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}

class FahrenheitSensor {
    private double temperatureFahrenheit;

    public FahrenheitSensor(double temperatureFahrenheit) {
        this.temperatureFahrenheit = temperatureFahrenheit;
    }

    public double getTemperatureFahrenheit() {
        return temperatureFahrenheit;
    }
}

class TemperatureAdapter implements TemperatureSensor {
    private FahrenheitSensor fahrenheitSensor;

    public TemperatureAdapter(FahrenheitSensor fahrenheitSensor) {
        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getTemperature() {
        return (fahrenheitSensor.getTemperatureFahrenheit() - 30) / 2;
    }
}