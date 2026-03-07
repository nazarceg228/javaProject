package model;

import java.math.BigDecimal;

public class HotelStay extends TourService {
    int stars;
    int nights;
    RoomType roomType;
    public void setStars(int stars) {
        this.stars = stars;
    }
    public void nights(int nights) {
        this.nights = nights;
    }
    public void setRoomType(RoomType room){
        this.roomType = room;
    }
    @Override
    public String toString() {
        return "User{Сколько звезд=\"" + stars + "\", Сколько ночей=\"" +nights + "\", Тип комнаты=\"" + (roomType != null ? roomType.name() : "не указан") + "\"}";
    }
    @Override
    public BigDecimal calculateTotalPrice(int participants) {
        var newPr = getPrice().multiply(BigDecimal.valueOf(participants));
        double hadN;
        double starsMulti = 1.0+((double) stars)/10;
        hadN = switch (nights) {
            case 0 -> 1.0;
            case 1 -> 1.2;
            case 2 -> 1.4;
            case 3 -> 1.6;
            default -> 2.0;
        };
        return newPr.multiply(new BigDecimal(hadN)).multiply(BigDecimal.valueOf(starsMulti));
    }
}
