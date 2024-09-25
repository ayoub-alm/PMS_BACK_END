package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.Court;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Long> {
}
