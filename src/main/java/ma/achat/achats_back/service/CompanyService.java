package ma.achat.achats_back.service;

import jakarta.persistence.EntityNotFoundException;
import ma.achat.achats_back.entity.Company;
import ma.achat.achats_back.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * This function allows to get companies that are not soft deleted
     * @return {List<Company>} the list of companies
     */
    public List<Company> findAllCompanies() {
        return companyRepository.findAllByDeletedAtIsNull();
    }

    /**
     * This function allows to find company with deleted_at is null and ID
     * @param id the ID of the company to get
     * @return Optional<Company>
     * @throws {EntityNotFoundException}
     */
    public Optional<Company> findCompanyById(Long id) {
        return companyRepository.findByDeletedAtIsNullAndId(id);
    }

    /**
     * This function allows to soft delete a company
     * @param id the ID of the company to delete
     * @throws {EntityNotFoundException}
     */
    public void softDeleteCompany(Long id) throws EntityNotFoundException {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entreprise n'existe pas"));

        // Set deletedAt to the current time
        company.setDeletedAt(LocalDateTime.now());
        companyRepository.save(company);
    }

    /**
     * This function allows to update a company
     * @param id the ID of the company to update
     * @param companyDetails the new details of the company
     * @return the updated Company
     * @throws {EntityNotFoundException}
     */
    public Company updateCompany(Long id, Company companyDetails) throws EntityNotFoundException {
        Company existingCompany = companyRepository.findByDeletedAtIsNullAndId(id)
                .orElseThrow(() -> new EntityNotFoundException("Entreprise n'existe pas ou est supprimée"));

        companyDetails.setId(existingCompany.getId());
        existingCompany = companyDetails;

        return companyRepository.save(existingCompany);
    }

    /**
     * This function allows to get all companies including soft deleted ones
     * @return {List<Company>} the list of all companies
     */
    public List<Company> findAllCompaniesIncludingDeleted() {
        return companyRepository.findAll();
    }


    /**
     * This function allows to restore a soft deleted company
     * @param id the ID of the company to restore
     * @throws {EntityNotFoundException}
     */
    public Company restoreCompany(Long id) throws EntityNotFoundException {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entreprise n'existe pas"));
        // Check if the company is soft deleted
        if (company.getDeletedAt() == null) {
            throw new RuntimeException("L'entreprise n'est pas supprimée.");
        }
        // Restore the company by setting deletedAt to null
        company.setDeletedAt(null);
        return companyRepository.save(company);
    }


    /**
     * Add a new company to the system.
     * @param company The company object to add.
     * @return The saved Company object.
     */
    public Company addCompany(Company company) {
        // Set the deletedAt to null to ensure it’s not marked as deleted
        company.setDeletedAt(null);
        return companyRepository.save(company);
    }
}
