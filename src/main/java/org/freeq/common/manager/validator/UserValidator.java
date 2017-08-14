package org.freeq.common.manager.validator;

import org.freeq.common.manager.validator.exception.ValidateException;

/**
 * Created by Aleksei Makarov on 14.08.2017.
 */

public interface UserValidator {

    String validatePhone(String phone) throws ValidateException;

    String validatePassword(String password) throws ValidateException;

    String validateName(String name) throws ValidateException;

    String validateEmail(String email) throws ValidateException;
}
