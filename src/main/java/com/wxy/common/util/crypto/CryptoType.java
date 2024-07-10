package com.wxy.common.util.crypto;


import lombok.Getter;

/**
 * 对称加密 枚举
 */
@Getter
public enum CryptoType {
    AES("AES"),
    DES("DES");

    private final String type;

    CryptoType(String type) {
        this.type = type;
    }

}

