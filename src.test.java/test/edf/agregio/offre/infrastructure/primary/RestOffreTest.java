package test.edf.agregio.offre.infrastructure.primary;

import org.testng.annotations.Test;
import test.edf.agregio.offre.domain.Offre;
import test.edf.agregio.parc.infrastructure.primary.RestParcProducteur;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static test.edf.agregio.marche.domain.Reserve.SECONDAIRE;
import static test.edf.agregio.parc.domain.TypeParc.EOLIEN;
import static test.edf.agregio.parc.domain.TypeParc.HYDRAULIQUE;

public class RestOffreTest {

    @Test
    public void shouldCreateRestOffre() {
        UUID uuid = randomUUID();
        var blocHoraires = List.of(new RestBlocHoraire(randomUUID(), Set.of(new RestParcProducteur(randomUUID(), EOLIEN, 50)), 800));
        var restOffre = new RestOffre(uuid, SECONDAIRE, blocHoraires);

        assertThat(restOffre).isNotNull();
        assertThat(restOffre.uuid()).isEqualTo(uuid);
        assertThat(restOffre.marche()).isEqualTo(SECONDAIRE);
        assertThat(restOffre.blocHoraires()).isEqualTo(blocHoraires);
    }

    @Test
    public void shouldMapToOffre() {
        var restOffre = new RestOffre(randomUUID(), SECONDAIRE, List.of(new RestBlocHoraire(randomUUID(), Set.of(new RestParcProducteur(randomUUID(), HYDRAULIQUE, 70)), 500)));

        Offre offre = restOffre.toOffre();

        assertThat(offre).usingRecursiveComparison().ignoringFields("marche").isEqualTo(restOffre);
        assertThat(offre.marche().reserve()).isEqualTo(SECONDAIRE);
    }

}
