package railway.price_calculation.domain.common;

public class FixtureAdultsValue {
  public static Adults get(int n) {
    return Adults.from(Numbers.from(n));
  }
}
