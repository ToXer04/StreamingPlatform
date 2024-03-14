package tryxe.co.Streaming.website.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tryxe.co.Streaming.website.entities.Membership;

public interface MembershipController extends JpaRepository<Membership, Long> {
}
