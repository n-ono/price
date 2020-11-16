package railway.price_calculation.domain.common;

import lombok.*;

/**
 * 人数
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Numbers {
  @Getter private final int value;

  public static Numbers from(int value) {
    return new Numbers(value);
  }

  public Numbers minus(Numbers other) {
    return new Numbers(value - other.value);
  }
}
