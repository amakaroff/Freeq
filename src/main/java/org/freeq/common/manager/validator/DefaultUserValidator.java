package org.freeq.common.manager.validator;

import org.freeq.common.crypto.CryptoService;
import org.freeq.common.manager.validator.exception.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aleksei Makarov on 14.08.2017.
 */

@Service
public class DefaultUserValidator implements UserValidator {

    private CryptoService cryptoService;

    @Override
    public String validatePhone(String phone) throws ValidateException {
        return null;
    }

    @Override
    public String validatePassword(String password) throws ValidateException {
        return null;
    }

    @Override
    public String validateName(String name) throws ValidateException {
        return null;
    }

    @Override
    public String validateEmail(String email) throws ValidateException {
        return null;
    }

    @Autowired
    public void setCryptoService(CryptoService cryptoService) throws ValidateException {
        this.cryptoService = cryptoService;
    }
}
