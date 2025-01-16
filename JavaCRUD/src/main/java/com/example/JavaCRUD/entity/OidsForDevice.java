package com.example.JavaCRUD.entity;

import jakarta.persistence.*;

@Entity
public class OidsForDevice {

    @Id
    private Integer key;

    @Column(name = "deviceTypeId")
    private Integer deviceTypeId;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String description;

    @Column(name = "okValue")
    private Integer okValue;

    @Column(name = "okValueText")
    private String okValueText;

    @Column(name = "badValue")
    private Integer badValue;

    @Column(name = "badValueText")
    private String badValueText;

    private Integer timeout;

    @Column(name = "invertible")
    private Integer invertible;

    private Integer enable;

    // Getters and setters
    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOkValue() {
        return okValue;
    }

    public void setOkValue(Integer okValue) {
        this.okValue = okValue;
    }

    public String getOkValueText() {
        return okValueText;
    }

    public void setOkValueText(String okValueText) {
        this.okValueText = okValueText;
    }

    public Integer getBadValue() {
        return badValue;
    }

    public void setBadValue(Integer badValue) {
        this.badValue = badValue;
    }

    public String getBadValueText() {
        return badValueText;
    }

    public void setBadValueText(String badValueText) {
        this.badValueText = badValueText;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getInvertible() {
        return invertible;
    }

    public void setInvertible(Integer invertible) {
        this.invertible = invertible;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}
