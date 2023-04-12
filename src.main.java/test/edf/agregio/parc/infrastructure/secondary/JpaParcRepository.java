package test.edf.agregio.parc.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaParcRepository extends JpaRepository<ParcEntity, UUID> {
}
