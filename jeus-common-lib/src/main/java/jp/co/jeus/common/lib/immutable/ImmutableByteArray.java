/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.immutable;

import java.nio.ByteBuffer;

/**
 *
 * @author soyou
 */
public final class ImmutableByteArray {

    private byte[] bytes;

    public ImmutableByteArray(String stringValue) {
        this.bytes = stringValue.getBytes();
    }

    public ImmutableByteArray(byte[] bytes) {
        this.bytes = new byte[bytes.length];
        System.arraycopy(bytes, 0, this.bytes, 0, this.bytes.length);
    }

    public ImmutableByteArray(byte[] bytes, int offset, int length) {
        this.bytes = new byte[length];
        System.arraycopy(bytes, offset, this.bytes, 0, length);
    }

    public byte[] concat(byte[] b) {
        return ByteBuffer.allocate(this.getLength() + b.length)
                .put(this.bytes)
                .put(b)
                .array();
    }

    public byte[] getBytes() {
        return this.bytes.clone();
    }

    public int getLength() {
        return this.bytes.length;
    }

    public boolean equalsArray(byte[] b) {
        if (b == null || bytes.length != b.length) {
            return false;
        }
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        } else if (this == o) {
            return true;
        } else {
            return equalsArray(((ImmutableByteArray) o).getBytes());
        }
    }

}
