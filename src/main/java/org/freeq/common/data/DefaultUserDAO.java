package org.freeq.common.data;

import org.freeq.common.data.repository.UserRepository;
import org.freeq.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by Aleksei Makarov on 14.08.2017.
 */

@Component
@Transactional
public class DefaultUserDAO implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public User findUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    public void deleteUserByPhone(String phone) {
        userRepository.deleteByPhone(phone);
    }
}
