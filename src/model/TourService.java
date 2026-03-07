package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class TourService {
    private Integer x;
    private String name;
    private BigDecimal price;
    private LocalDate from;
    private LocalDate to;

    public BigDecimal getPrice() {
        return new BigDecimal(300);
    }
    public boolean isAvailableOn(LocalDate data) {
        return !(from.isAfter(data) || from.isBefore(data));
    }

    public abstract BigDecimal calculateTotalPrice(int participants);
}
