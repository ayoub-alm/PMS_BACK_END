package ma.achat.achats_back.repository.data;


import ma.achat.achats_back.entity.data.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    /**
     * Retrun all where deleted_at is null
     * @return
     */
    List<Bank> findAllByDeletedAtIsNull();

    Optional<Bank> findByDeletedAtIsNullAndId(Long id);
}
