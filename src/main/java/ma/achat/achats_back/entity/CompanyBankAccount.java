package ma.achat.achats_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.achat.achats_back.entity.data.Bank;
import ma.achat.achats_back.entity.data.BaseEntity;
import ma.achat.achats_back.entity.data.Devise;
import ma.achat.achats_back.enums.ActiveInactiveEnum;
import ma.achat.achats_back.enums.BankAccountType;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "company_bank_accounts")
public class CompanyBankAccount extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String CityCode;

    @Column(nullable = false)
    private String ribCode;

    @Column(nullable = false)
    private String ibanCode;

    @Column(nullable = false)
    private String swiftCode;

    @Column(nullable = false)
    BankAccountType bankAccountType;

    LocalDateTime openDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "devis_id", nullable = false)
    private Devise devise;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    ActiveInactiveEnum activeInactive = ActiveInactiveEnum.ACTIVE;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

}
