package test.edf.agregio.offre.application;

import test.edf.agregio.offre.domain.Offre;
import test.edf.agregio.offre.domain.OffreRepository;

public class OffreApplicationService {

    private final OffreRepository offreRepository;

    public OffreApplicationService(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    public void save(Offre offre) {
        offreRepository.save(offre);
    }
}
