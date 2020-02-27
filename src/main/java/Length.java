public class Length {
    private final double value;
    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit unit) {
        double value = this.value;
        if (this.unit == Unit.FOOT) {
            if (unit == Unit.YARD) {
                value = this.value / 3;
            } else if (unit == Unit.INCH) {
                value = this.value * 12;
            }
        }

        if (this.unit == Unit.YARD) {
            if (unit == Unit.INCH) {
                value = this.value * 36;
            } else if (unit == Unit.FOOT) {
                value = this.value * 3;
            }
        }

        if (this.unit == Unit.INCH) {
            if (unit == Unit.FOOT) {
                value = this.value / 12;
            } else if (unit == Unit.YARD) {
                value = this.value / 36;
            }
        }

        return new Length(value, unit);
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return unit;
    }
}
