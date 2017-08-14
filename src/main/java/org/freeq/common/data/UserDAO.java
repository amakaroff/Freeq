package org.freeq.common.data;

import org.freeq.common.model.User;

/**
 * Created by Aleksei Makarov on 14.08.2017.
 */

public interface UserDAO {

    void save(User user);

    User findUserByPhone(String phone);

    void deleteUserByPhone(String phone);
}
