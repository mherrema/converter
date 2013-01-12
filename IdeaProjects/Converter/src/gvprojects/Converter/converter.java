package gvprojects.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: mitchherrema
 * Date: 1/11/13
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class converter {

    public static void Convert(int num, int base1, int base2) {
        int baseTen = 0;
        int newBase = 0;
        int[] powers1 = new int[32];
        int[] powers2 = new int[32];
        int[] tenPowers = new int[32];
        for (int i = 0; i < 32; i++) {
            powers1[i] = (int) Math.pow(base1, i);
            powers2[i] = (int) Math.pow(base2, i);
            tenPowers[i] = (int) Math.pow(10, i);
        }
        for (int i = 31; i >= 0; i--) {

            int tenPow = tenPowers[i];
            if (num / tenPow != 0) {
                int current = num / tenPow;
                baseTen += current * powers1[i];
                num -= tenPow * current;
            }
        }
        System.out.println(baseTen);
        for (int i = 31; i >= 0; i--) {
            int tenPow = tenPowers[i];
            if (baseTen / powers2[i] != 0) {
                int current = baseTen / powers2[i];

                newBase += current * tenPow;
                baseTen -= powers2[i] * current;
            }
        }
        System.out.println(newBase);
    }

    public static void main(String[] args) {
        Convert(1000, 2, 5);
    }

}