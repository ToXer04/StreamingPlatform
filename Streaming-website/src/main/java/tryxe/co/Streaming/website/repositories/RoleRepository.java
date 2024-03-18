package tryxe.co.Streaming.website.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tryxe.co.Streaming.website.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
