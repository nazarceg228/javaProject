package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class TourService {
    private Integer x;
    private String name;
    private BigDecimal price;
    private LocalDate from;
    private LocalDate to;
    public boolean isAvailableOn(LocalDate data) {
        return !(from.isAfter(data) || from.isBefore(data));
    }
    public Integer getX() {
        return x;
    }

    public String getName() {
        return name;
    }

    public LocalDate getTo() {
        return to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public TourService(Integer x, String name, BigDecimal price, LocalDate from, LocalDate to) {
        this.x = x;
        this.name = name;
        this.price = price;
        this.from = from;
        this.to = to;
    }

    public TourService() {
        this.x = null;
        this.name = null;
        this.price = null;
        this.from = null;
        this.to = null;
    }
    public abstract BigDecimal calculateTotalPrice(int participants);
}
