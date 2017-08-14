package org.freeq.common.data.repository;

import org.freeq.common.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksei Makarov on 14.08.2017.
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByPhone(@Param("phone") String phone);

    User deleteByPhone(@Param("phone") String phone);
}
