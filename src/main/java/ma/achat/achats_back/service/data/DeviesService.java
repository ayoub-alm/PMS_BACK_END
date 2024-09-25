package ma.achat.achats_back.service.data;

import ma.achat.achats_back.entity.data.Devise;
import ma.achat.achats_back.repository.data.DeviseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviesService {
    private final DeviseRepository deviseRepository;

    public DeviesService(DeviseRepository deviseRepository) {
        this.deviseRepository = deviseRepository;
    }

  
    public List<Devise> findAll() {
        return deviseRepository.findAll();
    }

  
    public Devise findById(Long id) {
        return deviseRepository.findById(id).orElse(null);
    }

  
    public Devise save(Devise devise) {
        return deviseRepository.save(devise);
    }

  
    public void deleteById(Long id) {
        deviseRepository.deleteById(id);
    }
}
