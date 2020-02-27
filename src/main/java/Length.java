public class Length {
    private final double value;
    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as_temp(Unit unit) {
        return new Length(calculateValue(unit), unit);
    }

    private double calculateValue(Unit unit) {
        double value = this.value;

        if (this.unit == Unit.FOOT) {
            if (unit == Unit.YARD) {
                return this.value / 3;
            }
            if (unit == Unit.INCH) {
                return this.value * 12;
            }
        }

        if (this.unit == Unit.YARD) {
            if (unit == Unit.INCH) {
                return this.value * 36;
            }
            if (unit == Unit.FOOT){
                return this.value * 3;
            }
        }

        if (this.unit == Unit.INCH) {
            if (unit == Unit.FOOT) {
                return this.value / 12;
            }
            if (unit == Unit.YARD) {
                return this.value / 36;
            }
        }

        return value;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return unit;
    }
}
