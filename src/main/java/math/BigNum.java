package math;

import javafx.scene.layout.Pane;

public class BigNum {
    public enum Sign {
        ZERO,
        POSITIVE,
        NEGATIVE;

        public Sign negate() {
            return switch (this) {
                case ZERO -> ZERO;
                case POSITIVE -> NEGATIVE;
                case NEGATIVE -> POSITIVE;
            };
        }
    }

    public final Sign sign;
    public final double layer;
    public final double magnitude;

    public BigNum() {
        sign = Sign.ZERO;
        layer = 0;
        magnitude = 0;
    }

    public BigNum(double num) {
        if (num == 0) {
            sign = Sign.ZERO;
            layer = 0;
            magnitude = 0;
            return;
        }

        sign = num < 0 ? Sign.NEGATIVE : Sign.POSITIVE;
        double positiveNum = Math.abs(num);

        boolean increaseLayer = positiveNum > Constants.MAX_SAFE_INTEGER;
        layer = increaseLayer ? 1 : 0;
        magnitude = increaseLayer ? Math.log10(positiveNum) : positiveNum;
    }

    public BigNum(Sign sign, double layer, double magnitude) {
        this.sign = sign;
        this.layer = layer;
        this.magnitude = magnitude;
    }

    public BigNum add(BigNum rhs) {
        if (sign == Sign.ZERO) return rhs;
        if (rhs.sign == Sign.ZERO) return this;

        if (layer >= 2 && rhs.layer >= 2) {
            return max(this, rhs);
        }

        boolean isLhsNegative = sign == Sign.NEGATIVE;
        boolean isRhsNegative = rhs.sign == Sign.NEGATIVE;

        if (!isLhsNegative && !isRhsNegative) {

        }
    }

    public BigNum sub(BigNum rhs) {
        return this.add(rhs.neg());
    }

    public BigNum mul(BigNum rhs) {
        return new BigNum();
    }

    public BigNum div(BigNum rhs) {
        return new BigNum();
    }

    public BigNum neg() {
        return new BigNum(sign.negate(), layer, magnitude);
    }

    public int cmp(BigNum rhs) {
        if (sign == Sign.ZERO) {
            return switch (rhs.sign) {
                case POSITIVE -> -1;
                case ZERO -> 0;
                case NEGATIVE -> 1;
            };
        }

        if (sign == Sign.POSITIVE) {
            if (rhs.sign != Sign.POSITIVE) return 1;

            if (layer > rhs.layer) return 1;
            if (layer < rhs.layer) return -1;
            if (layer == rhs.layer) {
                return Double.compare(magnitude, rhs.magnitude);
            }
        }

        return -(this.neg().cmp(rhs.neg()));
    }

    public static BigNum max(BigNum a, BigNum b) {
        return b.cmp(a) == -1 ? a : b;
    }

    public static BigNum min(BigNum a, BigNum b) {
        return a.cmp(b) == -1 ? a : b;
    }
}
