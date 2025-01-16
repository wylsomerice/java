package com.example.JavaCRUD.entity;

import jakarta.persistence.*;

@Entity
public class DeviceTypes {

    @Id
    private Integer id;

    private String name;

    @Column(name = "portsPoe")
    private Integer portsPoe;

    @Column(name = "portsWithoutPoe")
    private Integer portsWithoutPoe;

    @Column(name = "portsSfp")
    private Integer portsSfp;

    @Column(name = "portsUplink")
    private Integer portsUplink;

    private Integer inputs;
    private Integer outputs;
    private Integer ups;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPortsPoe() {
        return portsPoe;
    }

    public void setPortsPoe(Integer portsPoe) {
        this.portsPoe = portsPoe;
    }

    public Integer getPortsWithoutPoe() {
        return portsWithoutPoe;
    }

    public void setPortsWithoutPoe(Integer portsWithoutPoe) {
        this.portsWithoutPoe = portsWithoutPoe;
    }

    public Integer getPortsSfp() {
        return portsSfp;
    }

    public void setPortsSfp(Integer portsSfp) {
        this.portsSfp = portsSfp;
    }

    public Integer getPortsUplink() {
        return portsUplink;
    }

    public void setPortsUplink(Integer portsUplink) {
        this.portsUplink = portsUplink;
    }

    public Integer getInputs() {
        return inputs;
    }

    public void setInputs(Integer inputs) {
        this.inputs = inputs;
    }

    public Integer getOutputs() {
        return outputs;
    }

    public void setOutputs(Integer outputs) {
        this.outputs = outputs;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }
}
