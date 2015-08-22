package skillpoints.util;

public class MathUtil {

    /**
     * This code is taken out of newer versions of java.lang.Math
     * It is here in order for users to use the recommended Java version for this version of Minecraft
     * @param x The dividend.
     * @param y The divisor
     * @return the largest (closest to positive infinity) int value that is less than or equal to the algebraic quotient.
     */
    public static int floorDiv(int x, int y) {
        int r = x / y;
        // if the signs are different and modulo not zero, round down
        if ((x ^ y) < 0 && (r * y != x)) {
            r--;
        }
        return r;
    }
}
