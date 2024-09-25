package ma.achat.achats_back.repository;

import ma.achat.achats_back.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    /**
     * Get All banks where delete at is null
     */
    List<Company> findAllByDeletedAtIsNull();

    /**
     * Get company where delete at is null
     * @param id
     * @return
     */
    Optional<Company> findByDeletedAtIsNullAndId(Long id);
}
