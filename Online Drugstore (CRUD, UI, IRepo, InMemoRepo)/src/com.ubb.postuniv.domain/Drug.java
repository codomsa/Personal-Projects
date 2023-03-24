package com.ubb.postuniv.domain;

public class Drug extends Entity {
    private String name;
    private String producer;
    private double price;
    private boolean prescriptionNeed;

    public Drug(int id, String name, String producer, double price, boolean prescriptionNeed) {
        setId(id);
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.prescriptionNeed = prescriptionNeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getPrescriptionNeed() {
        return prescriptionNeed;
    }

    public void setPrescriptionNeed(boolean prescriptionNeed) {
        this.prescriptionNeed = prescriptionNeed;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", prescriptionNeed=" + prescriptionNeed +
                '}';
    }
}