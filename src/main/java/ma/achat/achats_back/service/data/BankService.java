package ma.achat.achats_back.service.data;

import ma.achat.achats_back.entity.data.Bank;
import ma.achat.achats_back.repository.data.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    // Create a new Bank
    public Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    // Retrieve all Banks
    public List<Bank> getAllBanks() {
        return bankRepository.findAllByDeletedAtIsNull();
    }

    // Retrieve a Bank by ID
    public Optional<Bank> getBankById(Long id) {
        return bankRepository.findByDeletedAtIsNullAndId(id);
    }

//     Update a Bank
    public Bank updateBank(Long id, Bank bankDetails) {
        Bank existingBank = bankRepository.findByDeletedAtIsNullAndId(id)
                .orElseThrow(() -> new RuntimeException("Bank not found with id: " + id));
        existingBank.setName(bankDetails.getName());
        // Update other fields if needed
        return bankRepository.save(existingBank);
    }

    // Delete a Bank
    public boolean deleteBank(Long id) {
        if (!bankRepository.existsById(id)) {
            throw new RuntimeException("Bank not found with id: " + id);
        }
        bankRepository.deleteById(id);
        return true;
    }
}
