package railway.price_calculation.domain.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

/**
 * 出発日
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DepartureDate {
  private final LocalDate value;

  public static DepartureDate from(LocalDate localDate) {
    return new DepartureDate(localDate);
  }

  public int getMonthValue() {
    return value.getMonthValue();
  }

  public int getDayOfMonth() {
    return value.getDayOfMonth();
  }
}
