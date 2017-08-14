package org.freeq.common.manager;

import org.apache.commons.lang3.StringUtils;
import org.freeq.common.crypto.CryptoService;
import org.freeq.common.data.UserDAO;
import org.freeq.common.manager.validator.UserValidator;
import org.freeq.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 * Created by Aleksei Makarov on 14.08.2017.
 */

@Service
public class DefaultUserManager implements UserManager {

    private UserDAO userDAO;

    private UserValidator userValidator;

    private CryptoService service;

    @Override
    public void registerUser(String phone, String password) {
        User user = createUser();
        user.setPhone(userValidator.validatePhone(phone));
        user.setPassword(userValidator.validatePassword(password));

        userDAO.save(user);
    }

    @Override
    public boolean isExists(String phone) {
        return userDAO.findUserByPhone(userValidator.validatePhone(phone)) != null;
    }

    @Override
    public void updateUser(String phone, String password, String email, String firstName, String lastName)  {
        User user = getUserByPhone(userValidator.validatePhone(phone));
        if (user == null) {
            //TODO create or exception
            return;
        }

        if (!service.check(user.getPassword(), password)) {
            user.setPassword(userValidator.validatePassword(password));
        }

        if (!StringUtils.equals(user.getEmail(), email)) {
            user.setEmail(userValidator.validateEmail(email));
        }

        if (!StringUtils.equals(user.getFirstName(), firstName)) {
            user.setFirstName(userValidator.validateName(firstName));
        }

        if (!StringUtils.equals(user.getFirstName(), firstName)) {
            user.setFirstName(userValidator.validateName(firstName));
        }

        userDAO.save(user);
    }

    @Override
    public void updatePhone(String oldPhone, String newPhone) {
        User user = getUserByPhone(userValidator.validatePhone(oldPhone));
        if (user != null) {
            user.setPhone(userValidator.validatePhone(newPhone));
        }
    }

    @Override
    public void deleteUser(String phone) {
        if (isExists(userValidator.validatePhone(phone))) {
            userDAO.deleteUserByPhone(phone);
        }
    }

    @Override
    public User getUserByPhone(String phone) {
        return userDAO.findUserByPhone(phone);
    }

    @Lookup
    private User createUser() {
        return new User();
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @Autowired
    public void setService(CryptoService service) {
        this.service = service;
    }
}
