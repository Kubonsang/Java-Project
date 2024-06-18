package Model;

import java.util.Date;

public class dayInfo {
    private Date date;
    private double exerciseTime;
    private double height;
    private double weight;
    private int kcal;

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getExerciseTime() {
        return exerciseTime;
    }

    public void setExerciseTime(double exerciseTime) {
        this.exerciseTime = exerciseTime;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
