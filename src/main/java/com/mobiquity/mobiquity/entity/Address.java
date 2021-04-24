package com.mobiquity.mobiquity.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    public String street;
    public String housenumber;
    public String postalcode;
    public String city;
    public GeoLocation geoLocation;

    public String getStreet() {
        return street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public String getCity() {
        return city;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }
}
