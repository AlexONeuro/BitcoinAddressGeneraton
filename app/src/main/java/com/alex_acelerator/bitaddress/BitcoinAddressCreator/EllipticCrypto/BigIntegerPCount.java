package com.alex_acelerator.bitaddress.BitcoinAddressCreator.EllipticCrypto;

import java.math.BigInteger;

public class BigIntegerPCount {
    private BigInteger n, m;
    private BigInteger a = BigInteger.ZERO;
    private BigInteger b = new BigInteger("7",10);
   // private BigInteger p = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F",16);
    private BigInteger p = BigInteger.valueOf(97);

  //  private Point P = new Point("79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798",
          //  "483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8");
    private Point P = new Point("5","36");

    private Point R = new Point(BigInteger.ZERO,BigInteger.ZERO);

    public Point count(BigInteger n){
        this.n = n;
       addP(new Point("13","78"));
        return R;
    }

    private void countR(){
       Point temp = new Point(P.x,P.y);
    String str =n.toString(2);
    char [] arr = new char[str.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(arr.length - 1 - i);
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
               temp = doubleP(temp);
            }
            else addP(temp);
        }

    }
    private Point doubleP(Point P){
        /**
         * уравнение y2 = x3 + 7
         * m = 3*x2 / 2*y
         */
        Point result = new Point(P.x,P.y);
        m = P.y.multiply(BigInteger.valueOf(2)).modInverse(p).multiply(P.x.pow(2).multiply(BigInteger.valueOf(3)).add(a));

        /**
         * xR = (m2 -xP - xQ) mod 97
         * yR = [yP + m*(xR-xP)] mod 97
         */
        result.x = m.pow(2).subtract(P.x).subtract(P.x).mod(p);
        result.y = result.x.subtract(P.x).multiply(m).add(P.y).abs().mod(p).multiply(BigInteger.valueOf(-1)).mod(p);
        return result;
    }

    private void addP(Point Q){
/**
 * m = (yP - yQ)*(xP-xQ)-1 mod 97 (if P!=Q)
 *
 * xR = m2 - xP - xQ
 *
 * yR = [yP + m*(xR-xP)] mod 97

 */

        Point P = new Point(R.x,R.y);
        m = P.x.subtract(Q.x).modInverse(p).multiply(P.y.subtract(Q.y));

        R.x = m.pow(2).subtract(P.x).subtract(Q.x).mod(p);
        R.y = R.x.subtract(P.x).multiply(m).add(P.y).abs().mod(p);

    }

}
