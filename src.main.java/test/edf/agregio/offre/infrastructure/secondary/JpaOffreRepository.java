package test.edf.agregio.offre.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import test.edf.agregio.marche.domain.Reserve;

import java.util.Set;
import java.util.UUID;

public interface JpaOffreRepository extends JpaRepository<OffreEntity, UUID> {

    Set<OffreEntity> findByMarche(Reserve reserve);

}
