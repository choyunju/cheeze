package cheeze_test.cheeze_test.Repository;

import cheeze_test.cheeze_test.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByNicknameOrEmail(String nickname, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByNickname(String nickname);

    Boolean existsByNickname(String nickname);

    Boolean existsByEmail(String email);
}

