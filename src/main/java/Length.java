public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private final String unit;
    private Unit temp_unit;

    public Length(double value, String unit, Unit temp_unit) {
        this.value = value;
        this.unit = unit;
        this.temp_unit = temp_unit;
    }

    public Length as_temp(Unit temp_unit) {
        Length length = this;
        if (this.temp_unit == Unit.FOOT) {
            if (temp_unit == Unit.YARD) {
                length = new Length(this.value / 3, null, temp_unit);
            } else if (temp_unit == Unit.INCH) {
                length = new Length(this.value * 12, null, temp_unit);
            }
        }

        if (this.temp_unit == Unit.YARD) {
            if (temp_unit == Unit.INCH) {
                length = new Length(this.value * 36, null, temp_unit);
            } else if (temp_unit == Unit.FOOT) {
                length = new Length(this.value * 3, null, temp_unit);
            }
        }

        if (this.temp_unit == Unit.INCH) {
            if (temp_unit == Unit.FOOT) {
                length = new Length(this.value / 12, null, temp_unit);
            } else if (temp_unit == Unit.YARD) {
                length = new Length(this.value / 36, null, temp_unit);
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

    public Unit getTemp_unit() {
        return temp_unit;
    }
}
