package donggukthon.team10.igloo.repository;

import donggukthon.team10.igloo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
    boolean existsByUsername(String username);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByUsernameAndAndKorName(String username, String korName);
}
