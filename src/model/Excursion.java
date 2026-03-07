package model;

import java.math.BigDecimal;
import java.math.MathContext;

public class Excursion extends TourService {
    String where;
    int day;

    @Override
    public String toString() {
        return "User{Где экскурсия=\"" + where + "\", Сколько дней экскурсия=\"" +day + "\"}";
    }

    @Override
    public BigDecimal calculateTotalPrice(int participants) {
        var Discount = getPrice().multiply(BigDecimal.valueOf(participants));
        Discount = participants > 10 ? Discount.subtract(Discount.divide(BigDecimal.valueOf(10), MathContext.DECIMAL128)) : Discount;
        return Discount;
    }
}
