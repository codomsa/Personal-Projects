package model;

public class Destinatii {
    private String name;
    private int x;
    private int y;
    public double distance;

    public Destinatii(String name, int x, int y) {
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
}

	
