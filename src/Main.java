import exception.TourServiceValidationException;
import model.Client;
import model.HotelStay;

public class Main {
  static void main(String[] args) {
    var b = new HotelStay();
    System.out.print(b);
    try {
      var client = new Client("", "", "", "", 0);
    } catch (TourServiceValidationException e) {
      e.getMessage();
    }

  }
}