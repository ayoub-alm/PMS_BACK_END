package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.Devise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviseRepository extends JpaRepository<Devise, Long> {
}
