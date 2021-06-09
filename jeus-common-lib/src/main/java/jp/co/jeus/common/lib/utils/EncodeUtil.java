/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jp.co.jeus.common.lib.constants.EncodeType;

/**
 *
 * @author soyou
 */
public final class EncodeUtil {

    private EncodeUtil() {
        throw new IllegalStateException();
    }

    public static byte[] encode(String value, EncodeType encodeType) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(encodeType.name());
        return digest.digest(value.getBytes());
    }
}
