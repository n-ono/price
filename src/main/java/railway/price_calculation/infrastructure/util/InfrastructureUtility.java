package railway.price_calculation.infrastructure.util;

import io.vavr.API;
import railway.price_calculation.domain.common.*;
import railway.price_calculation.domain.price.Passenger;

import static io.vavr.API.$;

public class InfrastructureUtility {
  public static String getDestination(Destination destination) {
    return API.Match(destination)
        .of(
            API.Case($(Destination.SHINOSAKA), "shinosaka"),
            API.Case($(Destination.HIMEJI), "himeji"));
  }

  public static String getTripType(TripType tripType) {
    return API.Match(tripType)
        .of(API.Case($(TripType.ONE_WAY), "one-way"), API.Case($(TripType.ROUND), "round"));
  }

  public static String getTrainType(TrainType trainType) {
    return API.Match(trainType)
        .of(API.Case($(TrainType.NOZOMI), "nozomi"), API.Case($(TrainType.HIKARI), "hikari"));
  }

  public static String getSeatType(SeatType seatType) {
    return API.Match(seatType)
        .of(API.Case($(SeatType.FREE), "free"), API.Case($(SeatType.RESERVED), "reserved"));
  }

  public static int getChildren(Passenger passenger) {
    return passenger.getChildren().getNumbers().getValue();
  }

  public static int getAdults(Passenger passenger) {
    return passenger.getAdults().getNumbers().getValue();
  }

  public static String getDepartureMonthDay(DepartureDate departureDate) {
    return String.format("%02d%02d", departureDate.getMonthValue(), departureDate.getDayOfMonth());
  }
}
