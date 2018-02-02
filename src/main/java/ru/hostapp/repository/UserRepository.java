package ru.hostapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.hostapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    @Transactional
    User save(User user);

    User getByEmail(String email);
}
