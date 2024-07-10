package com.wxy.common.util.crypto;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

public class DES implements Crypto{
    private static final String key = "0123456789012345";
    SymmetricCrypto des;

    public DES() {
        des = new SymmetricCrypto(SymmetricAlgorithm.DES, key.getBytes());
    }

    @Override
    public String encrypt(String str) {
        return des.encryptHex(str);
    }

    @Override
    public String decrypt(String str) {
        return des.decryptStr(str, CharsetUtil.CHARSET_UTF_8);
    }

}
