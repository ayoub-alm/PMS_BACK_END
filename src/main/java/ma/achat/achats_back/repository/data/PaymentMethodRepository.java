package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
