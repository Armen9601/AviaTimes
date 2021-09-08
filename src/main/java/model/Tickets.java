package model;


import lombok.*;

import java.util.Objects;


public class Tickets {

    private String origin;
    private String originName;
    private String desination;
    private String desinationName;
    private String departure_date;
    private String departure_time;
    private String arrival_time;
    private String arrival_date;
    private String carrier;
    private long stops;
    private long price;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDesination() {
        return desination;
    }

    public void setDesination(String desination) {
        this.desination = desination;
    }

    public String getDesinationName() {
        return desinationName;
    }

    public void setDesinationName(String desinationName) {
        this.desinationName = desinationName;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public long getStops() {
        return stops;
    }

    public void setStops(long stops) {
        this.stops = stops;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return stops == tickets.stops && price == tickets.price && Objects.equals(origin, tickets.origin) && Objects.equals(originName, tickets.originName) && Objects.equals(desination, tickets.desination) && Objects.equals(desinationName, tickets.desinationName) && Objects.equals(departure_date, tickets.departure_date) && Objects.equals(departure_time, tickets.departure_time) && Objects.equals(arrival_time, tickets.arrival_time) && Objects.equals(arrival_date, tickets.arrival_date) && Objects.equals(carrier, tickets.carrier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, originName, desination, desinationName, departure_date, departure_time, arrival_time, arrival_date, carrier, stops, price);
    }
}
