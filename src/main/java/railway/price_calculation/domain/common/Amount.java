package railway.price_calculation.domain.common;

import lombok.*;

/**
 * 料金
 * 10 円未満は切り捨てる
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Amount {
  @Getter private final int value;

  public static Amount from(int value) {
    return new Amount(adjust(value));
  }

  private static int adjust(int value) {
    return (int) Math.floor(value / 10) * 10;
  }

  public Amount plus(Amount other) {
    return Amount.from(adjust(value + other.value));
  }

  public Amount half() {
    return new Amount(adjust(value / 2));
  }

  public Amount twice() {
    return new Amount(adjust(value * 2));
  }

  public Amount multiply(Numbers numbers) {
    return new Amount(adjust(value * numbers.getValue()));
  }
}
