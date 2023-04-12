package test.edf.agregio.parc.application;

import org.springframework.stereotype.Service;
import test.edf.agregio.parc.domain.ParcProducteur;
import test.edf.agregio.parc.domain.ParcRepository;

@Service
public class ParcApplicationService {

    private final ParcRepository parcRepository;

    public ParcApplicationService(ParcRepository parcRepository) {
        this.parcRepository = parcRepository;
    }

    public void save(ParcProducteur parcProducteur) {
        parcRepository.save(parcProducteur);
    }
}
