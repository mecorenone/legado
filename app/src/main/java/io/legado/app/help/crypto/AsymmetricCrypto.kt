package io.legado.app.help.crypto

import cn.hutool.crypto.asymmetric.AsymmetricCrypto as HutoolAsymmetricCrypto
import cn.hutool.crypto.asymmetric.KeyType
import cn.hutool.crypto.KeyUtil
import java.io.InputStream

class AsymmetricCrypto(algorithm: String) : HutoolAsymmetricCrypto(algorithm) {

    fun setPrivateKey(key: ByteArray): AsymmetricCrypto {
        setPrivateKey(
            KeyUtil.generatePrivateKey(this.algorithm, key)
        )
        return this
    }
    fun setPrivateKey(key: String): AsymmetricCrypto = setPrivateKey(key.encodeToByteArray())

    fun setPublicKey(key: ByteArray): AsymmetricCrypto {
        setPublicKey(
            KeyUtil.generatePublicKey(this.algorithm, key)
        )
        return this
    }
    fun setPublicKey(key: String): AsymmetricCrypto = setPublicKey(key.encodeToByteArray())

    private fun getKeyType(usePublicKey: Boolean? = true): KeyType {
        return when {
            usePublicKey == true -> KeyType.PublicKey
            else -> KeyType.PrivateKey
        }
    }

    @JvmOverloads
    fun decrypt(data: Any, usePublicKey: Boolean? = true): ByteArray {
        return when {
            data is ByteArray -> decrypt(data, getKeyType(usePublicKey))
            data is String -> decrypt(data, getKeyType(usePublicKey))
            data is InputStream -> decrypt(data, getKeyType(usePublicKey))
            else -> throw IllegalArgumentException("Unexpected input type")
        }
    }

    @JvmOverloads
    fun decryptStr(data: Any, usePublicKey: Boolean? = true): String {
        return when {
            data is ByteArray -> decryptStr(data, getKeyType(usePublicKey))
            data is String -> decryptStr(data, getKeyType(usePublicKey))
            data is InputStream -> decryptStr(data, getKeyType(usePublicKey))
            else -> throw IllegalArgumentException("Unexpected input type")
        }
    }

    @JvmOverloads
    fun encrypt(data: Any, usePublicKey: Boolean? = true): ByteArray {
        return when {
            data is ByteArray -> encrypt(data, getKeyType(usePublicKey))
            data is String -> encrypt(data, getKeyType(usePublicKey))
            data is InputStream -> encrypt(data, getKeyType(usePublicKey))
            else -> throw IllegalArgumentException("Unexpected input type")
        }
    }

    @JvmOverloads
    fun encryptHex(data: Any, usePublicKey: Boolean? = true): String {
        return when {
            data is ByteArray -> encryptHex(data, getKeyType(usePublicKey))
            data is String -> encryptHex(data, getKeyType(usePublicKey))
            data is InputStream -> encryptHex(data, getKeyType(usePublicKey))
            else -> throw IllegalArgumentException("Unexpected input type")
        }
    }

    @JvmOverloads
    fun encryptBase64(data: Any, usePublicKey: Boolean? = true): String {
        return when {
            data is ByteArray -> encryptBase64(data, getKeyType(usePublicKey))
            data is String -> encryptBase64(data, getKeyType(usePublicKey))
            data is InputStream -> encryptBase64(data, getKeyType(usePublicKey))
            else -> throw IllegalArgumentException("Unexpected input type")
        }
    }

}