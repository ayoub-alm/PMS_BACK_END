package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
