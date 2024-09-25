package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
