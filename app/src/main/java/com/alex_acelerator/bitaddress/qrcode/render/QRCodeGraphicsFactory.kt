package com.alex_acelerator.bitaddress.qrcode.render


/**
 * A class used by [QRCode] to build instances of [QRCodeGraphics].
 *
 * It builds the default [QRCodeGraphics] available for the platform.
 *
 * You might extend it to generate customized [QRCodeGraphics] instances.
 *
 * @author Rafael Lins - g0dkar
 */

@Suppress("NON_EXPORTABLE_TYPE", "MemberVisibilityCanBePrivate")
 open class QRCodeGraphicsFactory {
    /**
     * Creates a `size` by `size` square [QRCodeGraphics] instance.
     */
    open fun newGraphicsSquare(size: Int) = newGraphics(size, size)

    /**
     * Creates a new [QRCodeGraphics] instance.
     */
     fun newGraphics(width: Int, height: Int): QRCodeGraphics = QRCodeGraphics(width, height)
}
