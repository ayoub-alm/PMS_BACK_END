package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.DeliveryMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryMethodRepository extends JpaRepository<DeliveryMethod, Long> {
}
