public class Length {
    private final double value;
    private Unit temp_unit;

    public Length(double value, Unit temp_unit) {
        this.value = value;
        this.temp_unit = temp_unit;
    }

    public Length as_temp(Unit temp_unit) {
        Length length = this;
        if (this.temp_unit == Unit.FOOT) {
            if (temp_unit == Unit.YARD) {
                length = new Length(this.value / 3, temp_unit);
            } else if (temp_unit == Unit.INCH) {
                length = new Length(this.value * 12, temp_unit);
            }
        }

        if (this.temp_unit == Unit.YARD) {
            if (temp_unit == Unit.INCH) {
                length = new Length(this.value * 36, temp_unit);
            } else if (temp_unit == Unit.FOOT) {
                length = new Length(this.value * 3, temp_unit);
            }
        }

        if (this.temp_unit == Unit.INCH) {
            if (temp_unit == Unit.FOOT) {
                length = new Length(this.value / 12, temp_unit);
            } else if (temp_unit == Unit.YARD) {
                length = new Length(this.value / 36, temp_unit);
            }
        }

        return length;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getTemp_unit() {
        return temp_unit;
    }
}
