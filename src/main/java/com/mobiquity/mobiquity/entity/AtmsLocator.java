package com.mobiquity.mobiquity.entity;

import lombok.*;

import java.util.List;

//@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtmsLocator {
    public Address address;
    public int distance;
    public List<OpeningHour> openingHours;
    public String functionality;
    public String type;

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setOpeningHours(List<OpeningHour> openingHours) {
        this.openingHours = openingHours;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public int getDistance() {
        return distance;
    }

    public List<OpeningHour> getOpeningHours() {
        return openingHours;
    }

    public String getFunctionality() {
        return functionality;
    }

    public String getType() {
        return type;
    }
}
