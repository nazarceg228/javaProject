package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract sealed class TourService permits Flight, Excursion, HotelStay {
  private Integer x;
  private String name;
  private BigDecimal price;
  private LocalDate from;
  private LocalDate to;

  public TourService(Integer x, String name, BigDecimal price, LocalDate from, LocalDate to) {
    this.x = x;
    this.name = name;
    this.price = price;
    this.from = from;
    this.to = to;
  }

  public TourService() {
  }

  public abstract BigDecimal calculateTotalPrice(int participants);

  public boolean isAvailableOn(LocalDate data) {
    return !(from.isAfter(data) || from.isBefore(data));
  }

  public Integer getX() {
    return x;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getTo() {
    return to;
  }

  public void setTo(LocalDate to) {
    this.to = to;
  }

  public LocalDate getFrom() {
    return from;
  }

  public void setFrom(LocalDate from) {
    this.from = from;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
