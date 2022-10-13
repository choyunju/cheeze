package cheeze_test.cheeze_test.Repository;

import cheeze_test.cheeze_test.Model.Role;
import cheeze_test.cheeze_test.Model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
