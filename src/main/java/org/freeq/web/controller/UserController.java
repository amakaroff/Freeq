package org.freeq.web.controller;

import org.freeq.common.manager.UserManager;
import org.freeq.common.manager.validator.exception.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aleksei Makarov on 14.08.2017.
 */

@RestController
public class UserController {

    @Autowired
    private UserManager userManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Value("${user.create.success}")
    private String userCreateSuccess;

    @Value("${user.create.failed}")
    private String userCreateFailed;

    @Value("${user.update.success}")
    private String userUpdateSuccess;

    @Value("${user.update.failed}")
    private String userUpdateFailed;

    @Value("${user.update.phone.success}")
    private String userUpdatePhoneSuccess;

    @Value("${user.update.phone.failed}")
    private String userUpdatePhoneFailed;

    @RequestMapping(value = "/user/register", method = RequestMethod.POST, params = {"phone", "password"})
    public String registration(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        String responseMessage;
        try {
            userManager.registerUser(phone, password);
            responseMessage = String.format("User: %s has bean successfully created!", phone);
            LOGGER.info(responseMessage);
        } catch (ValidateException exception) {
            LOGGER.error("User can't be created with error message: {}", exception.getMessage(), exception);
            responseMessage = exception.getMessage();
        }

        return responseMessage;
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST,
            params = {"phone", "password", "email", "firstName", "lastName"})
    public String updateUser(@RequestParam("phone") String phone, @RequestParam("password") String password,
                             @RequestParam("email") String email, @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName) {
        String responseMessage;
        try {
            userManager.updateUser(phone, password, email, firstName, lastName);
            responseMessage = String.format("User: %s has bean successfully updated!", phone);
            LOGGER.info(responseMessage);
        } catch (ValidateException exception) {
            LOGGER.error("User: {} can't be updated with error message: {}", phone, exception.getMessage(), exception);
            responseMessage = exception.getMessage();
        }

        return responseMessage;
    }

    @RequestMapping(value = "/user/update/phone", method = RequestMethod.POST, params = {"phone", "password"})
    public String updatePhone(@RequestParam("oldPhone") String oldPhone, @RequestParam("newPhone") String newPhone) {
        String responseMessage;
        try {
            userManager.updatePhone(oldPhone, newPhone);
            responseMessage = String.format("User phone successfully updated. Old phone: %s. New phone: %s.", oldPhone, newPhone);
            LOGGER.info(responseMessage);
        } catch (ValidateException exception) {
            LOGGER.error("User: {} can't update phone. Error message: {}", oldPhone, exception.getMessage(), exception);
            responseMessage = exception.getMessage();
        }

        return responseMessage;
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST, params = {"phone", "password"})
    public String deleteUser(@RequestParam("phone") String phone) {
        String responseMessage;
        try {
            userManager.deleteUser(phone);
            responseMessage = "";
            LOGGER.info(responseMessage);
        } catch (ValidateException exception) {
            LOGGER.error("");
            responseMessage = exception.getMessage();
        }

        return responseMessage;
    }
}
