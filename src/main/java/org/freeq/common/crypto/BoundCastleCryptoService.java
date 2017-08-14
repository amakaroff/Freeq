package org.freeq.common.crypto;

import org.springframework.stereotype.Service;

/**
 * Created by Aleksei Makarov on 14.08.2017.
 */

@Service
public class BoundCastleCryptoService implements CryptoService {

    @Override
    public String hashing(String data) {
        return null;
    }

    @Override
    public boolean check(String hash, String data) {
        return false;
    }
}
