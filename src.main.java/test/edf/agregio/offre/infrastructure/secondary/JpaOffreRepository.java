package test.edf.agregio.offre.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaOffreRepository extends JpaRepository<OffreEntity, UUID> {
}
