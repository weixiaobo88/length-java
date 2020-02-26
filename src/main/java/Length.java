import java.util.HashMap;

public class Length {
    private final double value;
    private final String unit;
    private static final String FOOT = "foot";
    private static final String YARD = "yard";
    private static final String INCH = "inch";
    private static final double YARD_TO_FOOT = 3;
    private static final double FOOT_TO_INCH = 12;
    private static final double YARD_TO_INCH = 36;
    private double FOOT_TO_YARD = 1.0 / YARD_TO_FOOT;
    private double INCH_TO_FOOT = 1.0 / FOOT_TO_INCH;
    private double INCH_TO_YARD = 1.0 / YARD_TO_INCH;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String unit) {
        return new Length(this.value * getConversion(this.unit, unit), unit);
    }

    public double getVal() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }

    private double getConversion(String from, String to) {
        HashMap<String, Double> conversions = new HashMap<>();
        double SAME_RATIO = 1.0;

        if (from.equals(FOOT)) {
            conversions.put(FOOT, SAME_RATIO);
            conversions.put(YARD, FOOT_TO_YARD);
            conversions.put(INCH, FOOT_TO_INCH);
        }

        if (from.equals(YARD)) {
            conversions.put(YARD, SAME_RATIO);
            conversions.put(FOOT, YARD_TO_FOOT);
            conversions.put(INCH, YARD_TO_INCH);
        }

        if (from.equals(INCH)) {
            conversions.put(INCH, SAME_RATIO);
            conversions.put(FOOT, INCH_TO_FOOT);
            conversions.put(YARD, INCH_TO_YARD);
        }

        return conversions.get(to);
    }
}
