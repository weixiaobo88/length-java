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
        Unit tempUnit = null;
        if (targetUnit.equals(FOOT)) {
            tempUnit = Unit.FOOT;
        }
        if (targetUnit.equals(INCH)) {
            tempUnit = Unit.INCH;
        }
        if (targetUnit.equals(YARD)) {
            tempUnit = Unit.YARD;
        }

        return asTemp(targetUnit, tempUnit);
    }

    public Length asTemp(String targetUnit, Unit tempUnit) {
        return new Length(getTargetValue(tempUnit), targetUnit);
    }

    private double getTargetValue(Unit tempUnit) {
        double value = this.value;

        if (this.unit.equals(FOOT)) {
            if (tempUnit == Unit.YARD) {
                value = this.value / 3;
            } else if (tempUnit == Unit.INCH) {
                value = this.value * 12;
            }
        }

        if (this.unit.equals(YARD)) {
            if (tempUnit == Unit.INCH) {
                value = this.value * 36;
            } else if (tempUnit == Unit.FOOT) {
                value = this.value * 3;
            }
        }

        if (this.unit.equals(INCH)) {
            if (tempUnit == Unit.FOOT) {
                value = this.value / 12;
            } else if (tempUnit == Unit.YARD) {
                value = this.value / 36;
            }
        }

        return value;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
