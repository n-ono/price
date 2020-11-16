package railway.price_calculation.domain.price;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import railway.price_calculation.domain.common.Adults;
import railway.price_calculation.domain.common.Children;

/**
 * 料金が無料になる乗客数
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ComplimentaryPassenger {
  @Getter private final Children children;
  @Getter private final Adults adults;
}
