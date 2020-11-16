package railway.price_calculation.domain.common;

import lombok.*;

/**
 * 大人の数
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Adults {
  @Getter private final Numbers numbers;

  public static Adults from(Numbers numbers) {
    return new Adults(numbers);
  }

  public Adults minus(Adults other) {
    return new Adults(numbers.minus(other.numbers));
  }
}
