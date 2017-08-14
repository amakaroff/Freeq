package org.freeq.common.manager;

import org.freeq.common.model.User;

/**
 * Created by Aleksei Makarov on 14.08.2017.
 */

public interface UserManager {

    void registerUser(String phone, String password);

    boolean isExists(String login);

    void updateUser(String phone, String password, String email,
                    String firstName, String lastName);

    User getUserByPhone(String phone);

    void updatePhone(String oldPhone, String newPhone);

    void deleteUser(String phone);
}
