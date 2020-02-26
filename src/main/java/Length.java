import java.util.HashMap;

public class Length {
    private final double value;
    private final Unit unit;
    private static final double YARD_TO_FOOT = 3;
    private static final double FOOT_TO_INCH = 12;
    private static final double YARD_TO_INCH = 36;
    private double FOOT_TO_YARD = 1.0 / YARD_TO_FOOT;
    private double INCH_TO_FOOT = 1.0 / FOOT_TO_INCH;
    private double INCH_TO_YARD = 1.0 / YARD_TO_INCH;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit unit) {
        return new Length(this.value * getConversion(this.unit, unit), unit);
    }

    public double getVal() {
        return this.value;
    }

    public Unit getUnit() {
        return this.unit;
    }

    private double getConversion(Unit from, Unit to) {
        HashMap<Unit, Double> conversions = new HashMap<>();
        double SAME_RATIO = 1.0;

        if (from.equals(Unit.FOOT)) {
            conversions.put(Unit.FOOT, SAME_RATIO);
            conversions.put(Unit.YARD, FOOT_TO_YARD);
            conversions.put(Unit.INCH, FOOT_TO_INCH);
        }

        if (from.equals(Unit.YARD)) {
            conversions.put(Unit.YARD, SAME_RATIO);
            conversions.put(Unit.FOOT, YARD_TO_FOOT);
            conversions.put(Unit.INCH, YARD_TO_INCH);
        }

        if (from.equals(Unit.INCH)) {
            conversions.put(Unit.INCH, SAME_RATIO);
            conversions.put(Unit.FOOT, INCH_TO_FOOT);
            conversions.put(Unit.YARD, INCH_TO_YARD);
        }

        return conversions.get(to);
    }
}
