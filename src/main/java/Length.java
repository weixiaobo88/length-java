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
        return as_temp(targetUnit, null);
    }

    public Length as_temp(String targetUnit, Unit temp_unit) {
        Length length = this;
        if (this.unit.equals(FOOT)) {
            if (targetUnit.equals(YARD)) {
                length = new Length(this.value / 3, targetUnit);
            } else if (targetUnit.equals(INCH)) {
                length = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals(YARD)) {
            if (targetUnit.equals(INCH)) {
                length = new Length(this.value * 36, targetUnit);
            } else if (targetUnit.equals(FOOT)){
                length = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals(INCH)) {
            if (targetUnit.equals(FOOT)) {
                length = new Length(this.value / 12, targetUnit);
            } else if (targetUnit.equals(YARD)) {
                length = new Length(this.value / 36, targetUnit);
            }
        }

        return length;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
