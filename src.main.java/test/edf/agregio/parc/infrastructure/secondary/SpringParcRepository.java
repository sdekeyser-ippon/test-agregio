package test.edf.agregio.parc.infrastructure.secondary;

import org.springframework.stereotype.Repository;
import test.edf.agregio.parc.domain.ParcProducteur;
import test.edf.agregio.parc.domain.ParcRepository;

@Repository
public class SpringParcRepository implements ParcRepository {

    private final JpaParcRepository jpaParcRepository;

    public SpringParcRepository(JpaParcRepository jpaParcRepository) {
        this.jpaParcRepository = jpaParcRepository;
    }

    @Override
    public void save(ParcProducteur parcProducteur) {
        jpaParcRepository.save(ParcEntity.from(parcProducteur));
    }
}
