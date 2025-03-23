package com.bjorn.boot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info {

    @JsonProperty("n")
    private String name;

    private String partner;
    private int exp;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "info{" +
                "name='" + name + '\'' +
                ", partner='" + partner + '\'' +
                ", exp=" + exp +
                '}';
    }
}
