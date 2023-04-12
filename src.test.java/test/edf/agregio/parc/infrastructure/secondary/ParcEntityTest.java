package test.edf.agregio.parc.infrastructure.secondary;

import org.testng.annotations.Test;
import test.edf.agregio.parc.domain.ParcProducteur;

import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static test.edf.agregio.parc.domain.TypeParc.EOLIEN;
import static test.edf.agregio.parc.domain.TypeParc.HYDRAULIQUE;
import static test.edf.agregio.parc.infrastructure.secondary.ParcEntity.from;

public class ParcEntityTest {

    @Test
    public void shouldCreateParcEntity() {
        UUID uuid = randomUUID();
        int production = 40;
        var parcProducteur = new ParcProducteur(uuid, EOLIEN, production);
        ParcEntity parcEntity = from(parcProducteur);
        assertThat(parcEntity).usingRecursiveComparison().isEqualTo(parcProducteur);
    }

    @Test
    public void shouldMapToParcProducteur() {
        UUID uuid = randomUUID();
        int production = 40;
        var parcEntity = new ParcEntity();
        parcEntity.setUuid(uuid);
        parcEntity.setProduction(production);
        parcEntity.setTypeParc(HYDRAULIQUE);
        ParcProducteur parcProducteur = parcEntity.toParcProducteur();
        assertThat(parcProducteur).usingRecursiveComparison().isEqualTo(parcEntity);
    }

}
