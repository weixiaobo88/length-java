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

    public Length as(String unit) {
        Unit unit_temp = unit.equals(Unit.FOOT) ? Unit.FOOT : null;
        return this.as_temp(unit, unit_temp);
    }

    public Length as_temp(String unit, Unit unit_temp) {
        Length length = this;
        String foot = Length.FOOT;
        if (this.unit.equals(foot)) {
            if (unit.equals(Length.YARD)) {
                length = new Length(this.value / 3, unit);
            } else if (unit.equals(Length.INCH)) {
                length = new Length(this.value * 12, unit);
            }
        }

        if (this.unit.equals(Length.YARD)) {
            if (unit.equals(Length.INCH)) {
                length = new Length(this.value * 36, unit);
            } else if (unit.equals(foot)) {
                length = new Length(this.value * 3, unit);
            }
        }

        if (this.unit.equals(Length.INCH)) {
            if (unit.equals(foot)) {
                length = new Length(this.value / 12, unit);
            } else if (unit.equals(Length.YARD)) {
                length = new Length(this.value / 36, unit);
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
