package test.edf.agregio.offre.infrastructure.secondary;

import org.springframework.stereotype.Repository;
import test.edf.agregio.marche.domain.Reserve;
import test.edf.agregio.offre.domain.Offre;
import test.edf.agregio.offre.domain.OffreRepository;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Repository
public class SpringOffreRepository implements OffreRepository {

    private final JpaOffreRepository jpaOffreRepository;

    public SpringOffreRepository(JpaOffreRepository jpaOffreRepository) {
        this.jpaOffreRepository = jpaOffreRepository;
    }

    @Override
    public void save(Offre offre) {
        jpaOffreRepository.save(OffreEntity.from(offre));
    }

    @Override
    public Set<Offre> find(Reserve reserve) {
        return jpaOffreRepository.findByMarche(reserve).stream().map(OffreEntity::toOffre).collect(toSet());
    }
}
