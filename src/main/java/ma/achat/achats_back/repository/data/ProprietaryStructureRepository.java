package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.ProprietaryStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaryStructureRepository extends JpaRepository<ProprietaryStructure, Long> {
    // Additional query methods can be defined here if needed
}
