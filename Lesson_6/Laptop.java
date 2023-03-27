package Lesson_6;

import java.util.*;

public class Laptop {
    private String manufacturer;
    private String model;
    private Double screenDiagonal;
    private Integer volumeSSD;
    private String color;


    public Laptop(String manufacturer, String model,
                Double screenDiagonal,
                Integer volumeSSD, String color) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.screenDiagonal = screenDiagonal;
        this.volumeSSD = volumeSSD;
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" +
                "Производитель = '" + manufacturer + '\'' +
                ", Диагональ экрана = " + screenDiagonal +
                ", Обьем памяти(Гб) = " + volumeSSD + 
                ", Цвет = " + color +
                '}';
    }

 
    public void printLaptop(){
        System.out.println(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, screenDiagonal, volumeSSD, color);
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public Double getScreenDiagonal() {
        return screenDiagonal;
    }
    public Integer getVolumeSSD() {
        return volumeSSD;
    }
    public String getColor() {
        return color;
    }
}