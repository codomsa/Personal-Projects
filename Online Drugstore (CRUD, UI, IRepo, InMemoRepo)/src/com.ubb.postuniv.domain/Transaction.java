package com.ubb.postuniv.domain;

public class Transaction extends Entity {
    private Integer idDrug;
    private Integer idCardClient;
    private String dateTime;
    private int count;

    public Transaction(int id, Integer idDrug, Integer idCardClient, String dateTime, int count) {
        setId(id);
        this.idDrug = idDrug;
        this.idCardClient = idCardClient;
        this.dateTime = dateTime;
        this.count = count;
    }

    public Integer getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(Integer idDrug) {
        this.idDrug = idDrug;
    }

    public Integer getIdCardClient() {
        return idCardClient;
    }

    public void setIdCardClient(Integer idCardClient) {
        this.idCardClient = idCardClient;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + this.getId() +
                ", idDrug=" + idDrug +
                ", idCardClient=" + idCardClient +
                ", dateTime='" + dateTime + '\'' +
                ", count=" + count +
                '}';
    }
}