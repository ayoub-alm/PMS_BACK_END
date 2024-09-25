package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title, Long> {
}
