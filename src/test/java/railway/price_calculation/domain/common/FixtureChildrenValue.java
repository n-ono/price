package railway.price_calculation.domain.common;

public class FixtureChildrenValue {
  public static Children get(int n) {
    return Children.from(Numbers.from(n));
  }
}
