package ma.achat.achats_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.achat.achats_back.entity.data.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "companies")
public class Company extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String logo;
    @Column(nullable = false)
    private String name;
    private String sigle;
    @Column(nullable = false)
    private String capital;
    @Column(nullable = false)
    private String headOffice;
    @Column(nullable = false)
    private String legalRepresentative;
    private String yearOfCreation;
    private Date dateOfRegistration;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    private String fax;
    private String whatsapp;
    private String website;
    private String linkedin;
    @Column(nullable = false)
    private String ice;
    @Column(nullable = false)
    private String rc;
    @Column(nullable = false)
    private String ifm;
    @Column(nullable = false)
    private String patent;
    private String cnss;
    private String CertificationText;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String businessDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "legal_status_id", nullable = false)
    private LegalStatus legalStatus;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "court_id", nullable = false)
    private Court court;

    @ManyToOne
    @JoinColumn(name = "company_size_id", nullable = false)
    private CompanySize companySize;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "indusrty_id", nullable = false)
    private Industry industry;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "proprietary_structure_id", nullable = false)
    private ProprietaryStructure proprietaryStructure;

    @ManyToOne
    @JoinColumn(name = "title_id", nullable = false)
    private Title title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_title_id", nullable = false)
    private JobTitle reprosentaveJobTitle;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CompanyBankAccount> companyBankAccounts;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<WalletSpace> wallets;


    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CompanyCertification> companyCertifications;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CompanyDoc> companyDocs;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Project> projects;


    @JsonIgnore
    @ManyToMany(mappedBy = "companies") // This matches the mappedBy in User
    private Set<User> employees; // Change to Set or List as needed



}
