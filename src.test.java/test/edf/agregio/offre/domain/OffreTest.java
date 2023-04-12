package test.edf.agregio.offre.domain;

import org.testng.annotations.Test;
import test.edf.agregio.marche.domain.Marche;

import java.util.List;

import static java.util.Collections.emptySet;
import static org.assertj.core.api.Assertions.assertThat;
import static test.edf.agregio.marche.domain.Reserve.SECONDAIRE;

public class OffreTest {

    @Test
    public void shouldCreateOffre() {
        var marche = new Marche(SECONDAIRE);
        List<BlocHoraire> blocHoraires = List.of(new BlocHoraire(emptySet(), 200), new BlocHoraire(emptySet(), 500));
        var offre = new Offre(marche, blocHoraires);
        assertThat(offre).isNotNull();
        assertThat(offre.blocHoraires()).isEqualTo(blocHoraires);
        assertThat(offre.marche()).isEqualTo(marche);
    }

}
