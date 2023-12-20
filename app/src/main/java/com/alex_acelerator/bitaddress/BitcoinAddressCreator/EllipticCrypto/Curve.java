package com.alex_acelerator.bitaddress.BitcoinAddressCreator.EllipticCrypto;

import java.math.BigInteger;

public class Curve {
    public BigInteger a, b, m, p;

    public Curve(BigInteger a, BigInteger b, BigInteger p) {
        this.a = a;
        this.b = b;
        this.p = p;

    }
}
