package model;

public class Destinatie implements Comparable<Destinatie> {
    private String name;
    private int x;
    private int y;
    public double distance;

    public Destinatie(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt(x * x + y * y);
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }
    public int compareTo(Destinatie s) {
    	return (int) (this.distance - s.distance);
    } //desi nu folosim functia pentru ca e necesar cast to int, avem nevoie ca noua clasa sa fie comparabila;
}