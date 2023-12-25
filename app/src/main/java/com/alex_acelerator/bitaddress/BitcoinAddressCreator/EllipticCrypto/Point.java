package com.alex_acelerator.bitaddress.BitcoinAddressCreator.EllipticCrypto;

import java.math.BigInteger;

public class Point {
    private int radix = 16;
    public BigInteger x;
    public BigInteger y;

   public Curve curve = new Curve(
           BigInteger.ZERO,
           BigInteger.valueOf(7),
           new BigInteger(
                   "fffffffffffffffffffffffffffffffffffffffffffffffffffffffefffffc2f",radix));

   public void setRadix(int radix){
       this.radix = radix;
   }

   public Point(){
       this.x = BigInteger.ZERO;
       this.y = BigInteger.ZERO;
   }

    public Point(String x, String y){
        this.x = new BigInteger(x,radix);
        this.y = new BigInteger(y,radix);
    }

    public Point(BigInteger x, BigInteger y) {
        this.x = x;
        this.y = y;
    }

    public void setCurve(Curve curve){
       this.curve = curve;
    }

    public boolean equals(Point p) {
        return p.x.equals(this.x) && p.y.equals(this.y);
    }

    public String toString(){
        return "x = " + x.toString(radix) + " " + " y = " + y.toString(radix);
    }

    public void addPoint(Point Q){
       if (x.equals(BigInteger.ZERO) || y.equals(BigInteger.ZERO)) {x = Q.x; y = Q.y;}
       else if(x.equals(Q.x) && y.equals(Q.y)) {doublePoint();}
        else if (!Q.equals(new Point())) {
            try {
                curve.m = x.subtract(Q.x).modInverse(curve.p).multiply(y.subtract(Q.y));
            }
            catch (ArithmeticException e){
                System.out.println("x = Inf");
                System.out.println("y = Inf");
            }

           BigInteger Px = new BigInteger(String.valueOf(x));
           x = curve.m.pow(2).subtract(x).subtract(Q.x).mod(curve.p);
           y = x.subtract(Px).multiply(curve.m).add(y).mod(curve.p)
           .multiply(BigInteger.valueOf(-1)).mod(curve.p);
       }

    }

    public void doublePoint(){
        curve.m = y.multiply(BigInteger.valueOf(2)).modInverse(curve.p).multiply(x.pow(2).multiply(BigInteger.valueOf(3)).add(curve.a));

        BigInteger Px = new BigInteger(String.valueOf(x));
        x = curve.m.pow(2).subtract(x).subtract(Px).mod(curve.p);
        y = x.subtract(Px).multiply(curve.m).add(y).mod(curve.p)
              .multiply(BigInteger.valueOf(-1)).mod(curve.p);/**to use or not to use? **/
    }


    public static void main(String[] args) {
        Point p = new Point("2","1");
        p.addPoint(new Point("6","8"));
      //  p.doublePoint();
       // p.doublePoint();
        System.out.println("x = " + p.x);
        System.out.println("y = " + p.y);

    }
}
