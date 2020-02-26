public class Length {
    private final double value;
    private final String unit;
    private static final String FOOT = "foot";
    private static final String YARD = "yard";
    private static final String INCH = "inch";
    private static final int YARD_TO_FOOT = 3;
    private static final int FOOT_TO_INCH = 12;
    private static final int YARD_TO_INCH = 36;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String unit) {
        Length length = this;

        if (this.unit.equals(FOOT)) {
            if (unit.equals(YARD)) {
                length = new Length(this.value / YARD_TO_FOOT, unit);
            } else if (unit.equals(INCH)) {
                length = new Length(this.value * FOOT_TO_INCH, unit);
            }

        }

        if (this.unit.equals(YARD)) {
            if (unit.equals(INCH)) {
                length = new Length(this.value * YARD_TO_INCH, unit);
            } else if (unit.equals(FOOT)){
                length = new Length(this.value * YARD_TO_FOOT, unit);
            }
        }

        if (this.unit.equals(INCH)) {
            if (unit.equals(FOOT)) {
                length = new Length(this.value / FOOT_TO_INCH, unit);
            } else if (unit.equals(YARD)) {
                length = new Length(this.value / YARD_TO_INCH, unit);
            }
        }

        return length;
    }

    public double getVal() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
