public class Length {
    private final double value;
    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit unit) {
        Length length = this;
        if (this.unit == Unit.FOOT) {
            if (unit == Unit.YARD) {
                length = new Length(this.value / 3, unit);
            } else if (unit == Unit.INCH) {
                length = new Length(this.value * 12, unit);
            }
        }

        if (this.unit == Unit.YARD) {
            if (unit == Unit.INCH) {
                length = new Length(this.value * 36, unit);
            } else if (unit == Unit.FOOT) {
                length = new Length(this.value * 3, unit);
            }
        }

        if (this.unit == Unit.INCH) {
            if (unit == Unit.FOOT) {
                length = new Length(this.value / 12, unit);
            } else if (unit == Unit.YARD) {
                length = new Length(this.value / 36, unit);
            }
        }

        return length;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return unit;
    }
}
