package com.adnan.passwordmanager.data.encryption

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/**
 * Created by Adnan.
 */
class CryptoManager {

    private val key = "1234567890123456".toByteArray()

    fun encrypt(raw: String): String {
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"))
        return Base64.encodeToString(cipher.doFinal(raw.toByteArray()), Base64.DEFAULT)
    }

    fun decrypt(encoded: String): String {
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, "AES"))
        return String(cipher.doFinal(Base64.decode(encoded, Base64.DEFAULT)))
    }
}