package ma.achat.achats_back.repository.data;

import ma.achat.achats_back.entity.data.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
