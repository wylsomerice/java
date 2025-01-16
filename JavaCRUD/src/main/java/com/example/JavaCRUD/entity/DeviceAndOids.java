package com.example.JavaCRUD.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DeviceAndOids", schema = "public")  // Убедитесь, что схема указана, если используется другая, например, "public"
public class DeviceAndOids {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Используется автоинкремент
    private Integer key;

    @Column(name = "deviceForMonitoringKey")
    private Integer deviceForMonitoringKey;

    @Column(name = "oidForDeviceKey")
    private Integer oidForDeviceKey;

    private Integer timeout;

    private Boolean invertible = false;  // Значение по умолчанию
    private Boolean invert = false;      // Значение по умолчанию

    private Boolean enable;

    private String deviceip;

    @Column(name = "sendEmail")
    private Boolean sendEmail;

    // Геттеры и сеттеры
    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getDeviceForMonitoringKey() {
        return deviceForMonitoringKey;
    }

    public void setDeviceForMonitoringKey(Integer deviceForMonitoringKey) {
        this.deviceForMonitoringKey = deviceForMonitoringKey;
    }

    public Integer getOidForDeviceKey() {
        return oidForDeviceKey;
    }

    public void setOidForDeviceKey(Integer oidForDeviceKey) {
        this.oidForDeviceKey = oidForDeviceKey;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Boolean getInvertible() {
        return invertible;
    }

    public void setInvertible(Boolean invertible) {
        this.invertible = invertible;
    }

    public Boolean getInvert() {
        return invert;
    }

    public void setInvert(Boolean invert) {
        this.invert = invert;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getDeviceip() {
        return deviceip;
    }

    public void setDeviceip(String deviceip) {
        this.deviceip = deviceip;
    }

    public Boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }
}
