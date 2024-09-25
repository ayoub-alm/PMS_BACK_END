package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.OnlinePaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlinePaymentMethodRepository extends JpaRepository<OnlinePaymentMethod, Long> {
}
