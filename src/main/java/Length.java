public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private final String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String targetUnit) {
        double value = this.value;

        if (this.unit.equals(FOOT)) {
            if (targetUnit.equals(YARD)) {
                value = this.value / 3;
            } else if (targetUnit.equals(INCH)) {
                value = this.value * 12;
            }
        }

        if (this.unit.equals(YARD)) {
            if (targetUnit.equals(INCH)) {
                value = this.value * 36;
            } else if (targetUnit.equals(FOOT)){
                value = this.value * 3;
            }
        }

        if (this.unit.equals(INCH)) {
            if (targetUnit.equals(FOOT)) {
                value = this.value / 12;
            } else if (targetUnit.equals(YARD)) {
                value = this.value / 36;
            }
        }

        return new Length(value, targetUnit);
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
