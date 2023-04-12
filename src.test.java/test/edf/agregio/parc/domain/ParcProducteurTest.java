package test.edf.agregio.parc.domain;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static test.edf.agregio.parc.domain.TypeParc.SOLAIRE;

public class ParcProducteurTest {

    @Test
    public void shouldCreateParcProducteur() {
        int production = 5;
        var parcProducteur = new ParcProducteur(SOLAIRE, production);
        assertThat(parcProducteur).isNotNull();
        assertThat(parcProducteur.typeParc()).isEqualTo(SOLAIRE);
        assertThat(parcProducteur.production()).isEqualTo(production);
    }

}
