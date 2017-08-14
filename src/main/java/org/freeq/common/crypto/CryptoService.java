package org.freeq.common.crypto;

/**
 * Created by Aleksei Makarov on 14.08.2017.
 */

public interface CryptoService {

    String hashing(String data);

    boolean check(String hash, String data);
}
