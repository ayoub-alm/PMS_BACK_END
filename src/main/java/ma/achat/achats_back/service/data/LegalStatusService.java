package ma.achat.achats_back.service.data;

import ma.achat.achats_back.entity.data.LegalStatus;
import ma.achat.achats_back.repository.data.LegalStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegalStatusService {
    private final LegalStatusRepository legalStatusRepository;

    public LegalStatusService(LegalStatusRepository legalStatusRepository) {
        this.legalStatusRepository = legalStatusRepository;
    }

    public List<LegalStatus> getAllLegalStatuses() {
        return legalStatusRepository.findAll();
    }

    public Optional<LegalStatus> getLegalStatusById(Long id) {
        return legalStatusRepository.findById(id);
    }

    public LegalStatus saveLegalStatus(LegalStatus legalStatus) {
        return legalStatusRepository.save(legalStatus);
    }

    public void deleteLegalStatus(Long id) {
        legalStatusRepository.deleteById(id);
    }

    public LegalStatus updateLegalStatus(LegalStatus legalStatus) {
        return legalStatusRepository.save(legalStatus);
    }
}
