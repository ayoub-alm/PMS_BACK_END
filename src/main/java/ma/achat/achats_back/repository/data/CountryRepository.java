package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
