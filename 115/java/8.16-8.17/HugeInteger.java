import java.util.Arrays;

public class HugeInteger {
    private int[] digits;

    public HugeInteger() {
        digits = new int[40];
    }

    public void parse(String input) {
        for (int i = 0; i < input.length(); i++) {
            digits[40 - input.length() + i] = input.charAt(i) - '0';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;

        for (int digit : digits) {
            if (digit != 0) {
                leadingZero = false;
            }
            if (!leadingZero) {
                sb.append(digit);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public HugeInteger add(HugeInteger num) {
        HugeInteger res = new HugeInteger();
        int car = 0;

        for (int i = 39; i >= 0; i--) {
            int sum = this.digits[i] + num.digits[i] + car;
            res.digits[i] = sum % 10;
            car = sum / 10;
        }
        return res;
    }

    public HugeInteger subtract(HugeInteger num) {
        HugeInteger res = new HugeInteger();
        int borrow = 0;

        for (int i = 39; i >= 0; i--) {
            int diff = this.digits[i] - num.digits[i] - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            res.digits[i] = diff;
        }
        return res;
    }

    public boolean isEqualTo(HugeInteger num) {
        return Arrays.equals(this.digits, num.digits);
    }

    public boolean isNotEqualTo(HugeInteger num) {
        return !isEqualTo(num);
    }

    public boolean isGreaterThan(HugeInteger num) {
        for (int i = 0; i < 40; i++) {
            if (this.digits[i] > num.digits[i])
                return true;
            if (this.digits[i] < num.digits[i])
                return false;
        }
        return false;
    }

    public boolean isLessThan(HugeInteger num) {
        return !isGreaterThan(num) && !isEqualTo(num);
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger num) {
        return isGreaterThan(num) || isEqualTo(num);
    }

    public boolean isLessThanOrEqualTo(HugeInteger num) {
        return isLessThan(num) || isEqualTo(num);
    }

    public boolean isZero() {
        for (int digit : digits) {
            if (digit != 0)
                return false;
        }

        return true;
    }
}