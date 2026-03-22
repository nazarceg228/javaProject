package model;

import exception.TourServiceValidationException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.regex.Pattern;

public final class Client {
  private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
  private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
  private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+\\d{10,15}$");

  final UUID clientId;
  String fullName;
  String email;
  String phone;
  String passportNumber;
  int loyaltyPoints;

  public Client(String fullName, String email, String phone, String passportNumber,
                int loyaltyPoints) throws TourServiceValidationException {
    this.clientId = UUID.randomUUID();
    if (fullName == null || fullName.trim().split("\\s+").length < 2) {
      throw new TourServiceValidationException(
          "fullName=" + fullName + " (должно быть минимум 2 слова)");
    }
    for (String word : fullName.trim().split("\\s+")) {
      if (word.length() < 2) {
        throw new TourServiceValidationException(
            "fullName=" + fullName + " (каждое слово минимум 2 символа)");
      }
    }
    if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
      throw new TourServiceValidationException("email=" + email + " (неверный формат)");
    }

    if (phone == null || !PHONE_PATTERN.matcher(phone).matches()) {
      throw new TourServiceValidationException(
          "phone=" + phone + " (должен начинаться с + и содержать 10-15 цифр)");
    }

    if (passportNumber == null || passportNumber.length() != 10) {
      throw new TourServiceValidationException(
          "passportNumber=" + passportNumber + " (должно быть 10 символов)");
    }

    if (loyaltyPoints < 0) {
      throw new TourServiceValidationException(
          "loyaltyPoints=" + loyaltyPoints + " (не может быть отрицательным)");
    }

    this.fullName = fullName;
    this.email = email;
    this.phone = phone;
    this.passportNumber = passportNumber;
    this.loyaltyPoints = loyaltyPoints;
  }

  public Client() {
    this.clientId = UUID.randomUUID();
  }

  public void addLoyaltyPoints(int points) {
    if (points > 0) {
      this.loyaltyPoints += points;
    }
  }

  @Override
  public String toString() {
    return "User{ClientId=\"" + clientId + "\", FullName=\"" + fullName + "\", Email=\"" + email +
        "\", Phone=\"" + phone + "\", PassportNumber=\"" + getMaskedPassportNumber() +
        "\", LoyaltyPoints=\"" + loyaltyPoints + "\"}";
  }

  public BigDecimal getDiscountRate() {
    if (loyaltyPoints >= 5000) {
      return new BigDecimal("0.20");
    }
    if (loyaltyPoints >= 1000) {
      return new BigDecimal("0.15");
    }
    if (loyaltyPoints >= 500) {
      return new BigDecimal("0.10");
    }
    if (loyaltyPoints >= 100) {
      return new BigDecimal("0.05");
    }
    return BigDecimal.ZERO;
  }

  public String getMaskedPassportNumber() {
    return "******" + passportNumber.substring(6);
  }

  public UUID getClientId() {
    return clientId;
  }

  public String getFullName() {
    return fullName;
  }

  public int getLoyaltyPoints() {
    return loyaltyPoints;
  }
}
