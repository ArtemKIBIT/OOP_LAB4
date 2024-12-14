package task4.weathermonitor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(30, 65, 1013);
        weatherData.setMeasurements(32, 70, 1012);
        weatherData.setMeasurements(28, 90, 1011);
    }
}

interface Observer {
    void update(float temperature, float humidity, float pressure);
}

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }


    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    private void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}

class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Поточні умови: " + temperature + "С градусів і " + humidity + "% вологості.");
    }
}

class StatisticsDisplay implements Observer {
    private float maxTemperature = Float.MIN_VALUE;
    private float minTemperature = Float.MAX_VALUE;
    private float sumTemperature = 0;
    private int numReadings = 0;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        sumTemperature += temperature;
        numReadings++;

        if (temperature > maxTemperature) {
            maxTemperature = temperature;
        }

        if (temperature < minTemperature) {
            minTemperature = temperature;
        }

        display();
    }

    public void display() {
        System.out.println("Середня/максимальна/мінімальна температура = " + (sumTemperature / numReadings) + "/" + maxTemperature + "/" + minTemperature);
    }
}

class ForecastDisplay implements Observer {
    private float lastPressure;
    private float currentPressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    public void display() {
        System.out.print("Прогноз: ");
        if (currentPressure > lastPressure) {
            System.out.println("Поліпшення погоди в дорозі!");
        } else if (currentPressure == lastPressure) {
            System.out.println("Більше того самого.");
        } else {
            System.out.println("Стережіться прохолодної та дощової погоди\n.");
        }
    }
}