package com.wxy.common.util.crypto;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

public class AES implements Crypto {
    private static final String key = "0123456789012345";
    SymmetricCrypto aes;

    public AES() {
        aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes());
    }

    @Override
    public String encrypt(String str) {
        return aes.encryptHex(str);
    }

    @Override
    public String decrypt(String str) {
        return aes.decryptStr(str, CharsetUtil.CHARSET_UTF_8);
    }
}
