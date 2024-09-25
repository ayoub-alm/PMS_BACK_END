package ma.achat.achats_back.repository;

import ma.achat.achats_back.entity.CompanyBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyBankAccountRepository extends JpaRepository<CompanyBankAccount,Long> {
    Optional<CompanyBankAccount> getCompanyBankAccountByIdAndDeletedAtIsNull(Long id);

    Optional<CompanyBankAccount> getCompanyBankAccountByIdAndDeletedAtIsNotNull(Long id);

    Iterable<CompanyBankAccount> getCompanyBankAccountByDeletedAtIsNull();
}
