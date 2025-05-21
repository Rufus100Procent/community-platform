package se.stykle.communityplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.stykle.communityplatform.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findByUserName(String username);
}
