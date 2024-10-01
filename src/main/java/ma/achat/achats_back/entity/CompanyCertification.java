package ma.achat.achats_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.achat.achats_back.entity.data.BaseEntity;
import org.springframework.stereotype.Service;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "company_certifications")
public class CompanyCertification extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String path;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(nullable = false, name = "company_id")
    private Company company;
}
