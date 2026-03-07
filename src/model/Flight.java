package model;

import java.math.BigDecimal;

public class Flight extends TourService {
    private String origin;
    private String destination;
    private String flightNumber;
    boolean baggageInclude;
    @Override
    public String toString() {
        return "User{Источник=\"" + origin + "\", Место назначения=\"" + destination + "\", Номер рейса=\""+flightNumber+"\", Багаж}";
    }
    @Override
    public BigDecimal calculateTotalPrice(int participants) {
        var newPr = getPrice().multiply(BigDecimal.valueOf(participants));
        return baggageInclude ? newPr.multiply(new BigDecimal("1.3")) : newPr;
    }
}
