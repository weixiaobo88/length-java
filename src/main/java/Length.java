public class Length {
    private final double value;
    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit targetUnit) {
        double value = this.calculateValue(targetUnit);
        return new Length(value, targetUnit);
    }

    private double calculateValue(Unit targetUnit) {
        double value = this.value;

        if (this.unit == Unit.FOOT) {
            if (targetUnit == Unit.YARD) {
                return this.value / 3;
            }
            if (targetUnit == Unit.INCH) {
                return this.value * 12;
            }
        }

        if (this.unit == Unit.YARD) {
            if (targetUnit == Unit.INCH) {
                return this.value * 36;
            }
            if (targetUnit == Unit.FOOT){
                return this.value * 3;
            }
        }

        if (this.unit == Unit.INCH) {
            if (targetUnit == Unit.FOOT) {
                return this.value / 12;
            }
            if (targetUnit == Unit.YARD) {
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
