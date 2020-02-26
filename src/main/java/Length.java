public class Length {
    private final double value;
    private final String unit;
    public static final String INCH = "inch";
    public static final String FOOT = "foot";
    public static final String YARD = "yard";

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String targetUnit) {
        Length length = this;
        if (this.unit.equals(Length.FOOT)) {
            if (targetUnit.equals(Length.YARD)) {
                length = new Length(this.value / 3, targetUnit);
            } else if (targetUnit.equals(Length.INCH)) {
                length = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals(Length.YARD)) {
            if (targetUnit.equals(Length.INCH)) {
                length = new Length(this.value * 36, targetUnit);
            } else if (targetUnit.equals(Length.FOOT)){
                length = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals(Length.INCH)) {
            if (targetUnit.equals(Length.FOOT)) {
                length = new Length(this.value / 12, targetUnit);
            } else if (targetUnit.equals(Length.YARD)) {
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
