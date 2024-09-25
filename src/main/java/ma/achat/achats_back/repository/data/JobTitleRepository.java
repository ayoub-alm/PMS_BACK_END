package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {
}
