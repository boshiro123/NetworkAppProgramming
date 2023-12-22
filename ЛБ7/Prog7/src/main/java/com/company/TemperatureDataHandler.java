package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TemperatureDataHandler {
    public List<Double> readTemperatureDataFromFile(String filePath) throws IOException {
        List<Double> temperatures = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                double temperature = Double.parseDouble(line.trim());
                temperatures.add(temperature);
            }
        }

        return temperatures;
    }

    public double calculateAverageTemperature(List<Double> temperatures) {
        if (temperatures.isEmpty()) {
            return 0.0; // Можно выбрать другое значение по умолчанию
        }

        double sum = 0.0;
        for (double temp : temperatures) {
            sum += temp;
        }

        return sum/temperatures.size();
    }
}
