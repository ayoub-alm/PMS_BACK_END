package ma.achat.achats_back.service.data;

import ma.achat.achats_back.entity.data.OnlinePaymentMethod;

import ma.achat.achats_back.repository.data.OnlinePaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OnlinePaymentMethodService {
    private final OnlinePaymentMethodRepository onlinePaymentMethodRepository;

    public OnlinePaymentMethodService(OnlinePaymentMethodRepository onlinePaymentMethodRepository) {
        this.onlinePaymentMethodRepository = onlinePaymentMethodRepository;
    }

    public List<OnlinePaymentMethod> getAllOnlinePaymentMethods() {
        return onlinePaymentMethodRepository.findAll();
    }

    public Optional<OnlinePaymentMethod> getOnlinePaymentMethodById(Long id) {
        return onlinePaymentMethodRepository.findById(id);
    }

    public OnlinePaymentMethod saveOnlinePaymentMethod(OnlinePaymentMethod onlinePaymentMethod) {
        return onlinePaymentMethodRepository.save(onlinePaymentMethod);
    }

    public void deleteOnlinePaymentMethod(Long id) {
        onlinePaymentMethodRepository.deleteById(id);
    }

    public OnlinePaymentMethod updateOnlinePaymentMethod(OnlinePaymentMethod onlinePaymentMethod) {
        return onlinePaymentMethodRepository.save(onlinePaymentMethod);
    }
}
