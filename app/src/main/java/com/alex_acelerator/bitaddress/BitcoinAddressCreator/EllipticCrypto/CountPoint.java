package com.alex_acelerator.bitaddress.BitcoinAddressCreator.EllipticCrypto;

import java.math.BigInteger;

public final class CountPoint {
    static final BigInteger curveOrder = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141",16);
    public static String count(BigInteger n) throws Exception {
        Point R = new Point("79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798",
                "483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8");
        if (n.compareTo(curveOrder) > 0 ) throw new Exception("Private key must be less then curve order.");
        Point result = new Point();
        Point sum = new Point(R.x, R.y);

        String str = n.toString(2);
        int[] arr = new int[str.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(arr.length - 1 - i)));

        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) result.addPoint(sum);
            sum.doublePoint();
        }
        R.x = result.x;
        R.y = result.y;
        StringBuilder Rx = new StringBuilder();
        Rx.append("0".repeat(64-R.x.toString(16).length()));
        Rx.append(R.x.toString(16));
        StringBuilder Ry = new StringBuilder();
        Ry.append("0".repeat(64-R.y.toString(16).length()));
        Ry.append(R.y.toString(16));
        StringBuilder resultString = new StringBuilder();
        resultString.append("04").append(Rx).append(Ry);
        return resultString.toString();
    }

    public static void main(String[] args) throws Exception {
        Point P = new Point(
        );
        String str = new CountPoint().count(new BigInteger(
                "3ede3845253f98f39170c2beef914d4eeadfec7345baed76c66300ce500656a9", 16));
        System.out.println(str);
        System.out.println("1e7bcc70c72770dbb72fea022e8a6d07f814d2ebe4de9ae3f7af75bf706902a7");
        System.out.println(str.equals("1e7bcc70c72770dbb72fea022e8a6d07f814d2ebe4de9ae3f7af75bf706902a7"));
        System.out.println("79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798".length());
    }
}
