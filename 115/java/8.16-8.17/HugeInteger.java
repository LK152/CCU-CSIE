public class HugeInteger {
    private int[] digits = new int[40];

    public void parse(String input) {
        for (int i = 0;i<input.length();i++) {
            digits[40 - input.length() + i] = Character.getNumericValue(input.charAt(i));
        }
    }

    @Override
    public String toString() {

    }

    public void add(HugeInteger num) {
        int carry = 0;
        for (int i = 39; i >= 0; i--) {
            int sum = this.digits[i] + num.digits[i] + carry;
            this.digits[i] = sum % 10;
            carry = sum / 10;
        }
    }

    public void subtract(HugeInteger other) {
        if (this.isLessThan(other)) {
            System.out.println("Result would be negative; not supported in this basic version.");
            return;
        }
        for (int i = 39; i >= 0; i--) {
            if (this.digits[i] < other.digits[i]) {
                this.digits[i] += 10;
                this.digits[i - 1]--;
            }
            this.digits[i] -= other.digits[i];
        }
    }

    // --- Comparison Methods ---

    public boolean isEqualTo(HugeInteger other) {
        return Arrays.equals(this.digits, other.digits);
    }

    public boolean isNotEqualTo(HugeInteger other) {
        return !isEqualTo(other);
    }

    public boolean isGreaterThan(HugeInteger other) {
        for (int i = 0; i < 40; i++) {
            if (this.digits[i] > other.digits[i]) return true;
            if (this.digits[i] < other.digits[i]) return false;
        }
        return false;
    }

    public boolean isLessThan(HugeInteger other) {
        return !isGreaterThan(other) && !isEqualTo(other);
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger other) {
        return isGreaterThan(other) || isEqualTo(other);
    }

    public boolean isLessThanOrEqualTo(HugeInteger other) {
        return isLessThan(other) || isEqualTo(other);
    }

    public boolean isZero() {
        for (int digit : digits) {
            if (digit != 0) return false;
        }
        return true;
    }
}