package ma.achat.achats_back.repository.data;


import ma.achat.achats_back.entity.data.SupplierType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierTypeRepository extends JpaRepository<SupplierType, Long> {
}
