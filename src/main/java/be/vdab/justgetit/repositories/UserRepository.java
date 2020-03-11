package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(long id);
}
