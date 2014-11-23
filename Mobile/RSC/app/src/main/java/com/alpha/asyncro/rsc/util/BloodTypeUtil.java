package com.alpha.asyncro.rsc.util;

/**
 * Created by dmacan on 23.11.2014..
 */
public class BloodTypeUtil {

    private static final int A = 1;
    private static final int B = 2;
    private static final int AB = 3;
    private static final int O = 4;

    public static int getBloodTypeId(String type) {
        if (type.equals("A"))
            return A;
        else if (type.equals("B"))
            return B;
        else if (type.equals("AB"))
            return AB;
        else if (type.equals("O"))
            return O;
        return 0;
    }

}
