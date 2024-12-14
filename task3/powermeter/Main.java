package task3.powermeter;

public class Main {
    public static void main(String[] args) {

        PowerMeter basicPowerMeter = new BasicPowerMeter(1000.0);
        System.out.println("Потужність з BasicPowerMeter: " + basicPowerMeter.getPower() + " Вт");

        CurrentVoltageMeter currentVoltageMeter = new CurrentVoltageMeter(4.5, 220.0);

        PowerMeter adapter = new PowerAdapter(currentVoltageMeter);
        System.out.println("Потужність з CurrentVoltageMeter через адаптер: " + adapter.getPower() + " Вт");
    }

}

interface PowerMeter {
    double getPower();
}

class BasicPowerMeter implements PowerMeter {
    private double power;

    public BasicPowerMeter(double power) {
        this.power = power;
    }

    @Override
    public double getPower() {
        return power;
    }
}

class CurrentVoltageMeter {
    private double current;
    private double voltage;

    public CurrentVoltageMeter(double current, double voltage) {
        this.current = current;
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public double getVoltage() {
        return voltage;
    }
}

class PowerAdapter implements PowerMeter {
    private CurrentVoltageMeter currentVoltageMeter;

    public PowerAdapter(CurrentVoltageMeter currentVoltageMeter) {
        this.currentVoltageMeter = currentVoltageMeter;
    }

    @Override
    public double getPower() {
        double current = currentVoltageMeter.getCurrent();
        double voltage = currentVoltageMeter.getVoltage();
        return voltage * current;
    }
}