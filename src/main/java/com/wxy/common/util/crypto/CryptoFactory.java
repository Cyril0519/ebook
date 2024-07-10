package com.wxy.common.util.crypto;

/**
 * 加密工厂类
 */
public class CryptoFactory {
    /**
     * 获取加密实例
     *
     * @param type 加密类型
     * @return 加密实例
     */
    public static Crypto getCrypto(String type) {
        if (CryptoType.AES.getType().equals(type)) {
            return new AES();
        } else if (CryptoType.DES.getType().equals(type)) {
            return new DES();
        }
        throw new IllegalArgumentException("不支持的加密类型");

    }
}
