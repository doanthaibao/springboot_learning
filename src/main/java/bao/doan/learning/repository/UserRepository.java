package bao.doan.learning.repository;

import bao.doan.learning.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
