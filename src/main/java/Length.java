public class Length {
    private final double value;
    private final String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String unit) {
        Length length = this;
        String foot = "f";
        String yard = "yard";
        String inch = "inch";
        int YARD_TO_FOOT = 3;
        int FOOT_TO_INCH = 12;
        int YARD_TO_INCH = 36;

        if (this.unit.equals(foot)) {
            if (unit.equals(yard)) {
                length = new Length(this.value / YARD_TO_FOOT, unit);
            } else if (unit.equals(inch)) {
                length = new Length(this.value * FOOT_TO_INCH, unit);
            }
        }

        if (this.unit.equals(yard)) {
            if (unit.equals(inch)) {
                length = new Length(this.value * YARD_TO_INCH, unit);
            } else if (unit.equals(foot)){
                length = new Length(this.value * YARD_TO_FOOT, unit);
            }
        }

        if (this.unit.equals(inch)) {
            if (unit.equals(foot)) {
                length = new Length(this.value / FOOT_TO_INCH, unit);
            } else if (unit.equals(yard)) {
                length = new Length(this.value / YARD_TO_INCH, unit);
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
