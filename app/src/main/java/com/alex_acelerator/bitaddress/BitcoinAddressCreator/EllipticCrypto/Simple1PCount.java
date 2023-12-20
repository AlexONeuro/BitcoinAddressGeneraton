package com.alex_acelerator.bitaddress.BitcoinAddressCreator.EllipticCrypto;

import static java.lang.Math.pow;

public class Simple1PCount {
    private float xP, yP;
   private float xR, yR;

    public Simple1PCount(float xP, float yP) {
        this.xP = xP;
        this.yP = yP;
    }

    public void simple1PCount(){
        this.xR = xR;
        System.out.println("Counting 1P");
        /**
         * уравнение y2 = x3 + ax + 7
         */
        int a = 0;
        float m;
        m = (float)(3*pow(xP,3) + a)/(2*yP);

        /**
         * xR = m2 - 2*x
         * yR = y + m*(xR - x)
         */

        xR = (float)(pow(m,2) - 2*xP);
        yR = -1*(yP + m*(xR -xP));

        System.out.println("m = "+ m);
        System.out.println("xR = " + xR);
        System.out.println("yR = " + yR);

    }

    public void showCoordinates(){
        System.out.println("xR = " + xR);
        System.out.println("yR = " + yR);
    }
}
