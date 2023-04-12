package test.edf.agregio.parc.domain;

import org.testng.annotations.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static test.edf.agregio.parc.domain.TypeParc.SOLAIRE;

public class ParcProducteurTest {

    @Test
    public void shouldCreateParcProducteur() {
        UUID uuid = UUID.randomUUID();
        int production = 5;
        var parcProducteur = new ParcProducteur(uuid, SOLAIRE, production);
        assertThat(parcProducteur).isNotNull();
        assertThat(parcProducteur.uuid()).isEqualTo(uuid);
        assertThat(parcProducteur.typeParc()).isEqualTo(SOLAIRE);
        assertThat(parcProducteur.production()).isEqualTo(production);
    }

}
