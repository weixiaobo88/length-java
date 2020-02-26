public class Length {
    private final double value;
    private final String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String unit) {
        Length length = this;
        if (this.unit.equals("f")) {
            if (unit.equals("yard")) {
                length = new Length(this.value / 3, unit);
            } else if (unit.equals("inch")) {
                length = new Length(this.value * 12, unit);
            }
        }

        if (this.unit.equals("yard")) {
            if (unit.equals("inch")) {
                length = new Length(this.value * 36, unit);
            } else if (unit.equals("f")){
                length = new Length(this.value * 3, unit);
            }
        }

        if (this.unit.equals("inch")) {
            if (unit.equals("f")) {
                length = new Length(this.value / 12, unit);
            } else if (unit.equals("yard")) {
                length = new Length(this.value / 36, unit);
            }
        }

        return length;
    }

    public double getVal() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
