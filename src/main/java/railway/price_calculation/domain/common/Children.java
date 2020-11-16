package railway.price_calculation.domain.common;

import lombok.*;

/**
 * 子供の数
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Children {
  @Getter private final Numbers numbers;

  public static Children from(Numbers numbers) {
    return new Children(numbers);
  }

  public Children minus(Children other) {
    return new Children(numbers.minus(other.numbers));
  }
}
