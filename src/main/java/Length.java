public class Length {
    private final double value;
    private Unit unit;
    public static final String INCH = "inch";
    public static final String FOOT = "foot";
    public static final String YARD = "yard";

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit targetUnit) {
        Length length = this;
        if (this.unit == Unit.FOOT) {
            if (targetUnit == Unit.YARD) {
                length = new Length(this.value / 3, targetUnit);
            } else if (targetUnit == Unit.INCH) {
                length = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit == Unit.YARD) {
            if (targetUnit == Unit.INCH) {
                length = new Length(this.value * 36, targetUnit);
            } else if (targetUnit == Unit.FOOT){
                length = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit == Unit.INCH) {
            if (targetUnit == Unit.FOOT) {
                length = new Length(this.value / 12, targetUnit);
            } else if (targetUnit == Unit.YARD) {
                length = new Length(this.value / 36, targetUnit);
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
