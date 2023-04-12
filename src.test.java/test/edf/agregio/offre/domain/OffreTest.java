package test.edf.agregio.offre.domain;

import org.testng.annotations.Test;
import test.edf.agregio.marche.domain.Marche;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptySet;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static test.edf.agregio.marche.domain.Reserve.SECONDAIRE;

public class OffreTest {

    @Test
    public void shouldCreateOffre() {
        UUID uuid = randomUUID();
        var marche = new Marche(SECONDAIRE);
        List<BlocHoraire> blocHoraires = List.of(new BlocHoraire(randomUUID(), emptySet(), 200), new BlocHoraire(randomUUID(), emptySet(), 500));
        var offre = new Offre(uuid, marche, blocHoraires);
        assertThat(offre).isNotNull();
        assertThat(offre.uuid()).isEqualTo(uuid);
        assertThat(offre.blocHoraires()).isEqualTo(blocHoraires);
        assertThat(offre.marche()).isEqualTo(marche);
    }

}
