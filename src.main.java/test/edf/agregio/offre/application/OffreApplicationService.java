package test.edf.agregio.offre.application;

import test.edf.agregio.marche.domain.Reserve;
import test.edf.agregio.offre.domain.Offre;
import test.edf.agregio.offre.domain.OffreRepository;

import java.util.Set;

public class OffreApplicationService {

    private final OffreRepository offreRepository;

    public OffreApplicationService(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    public void save(Offre offre) {
        offreRepository.save(offre);
    }

    public Set<Offre> find(Reserve reserve) {
        return offreRepository.find(reserve);
    }
}
