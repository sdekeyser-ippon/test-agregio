package test.edf.agregio.parc.infrastructure.primary;

import org.testng.annotations.Test;
import test.edf.agregio.parc.domain.ParcProducteur;

import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static test.edf.agregio.parc.domain.TypeParc.EOLIEN;

public class RestParcProducteurTest {

    @Test
    public void shouldCreateRestParcProducteur() {
        UUID uuid = randomUUID();
        int production = 40;
        var restParc = new RestParcProducteur(uuid, EOLIEN, production);
        assertThat(restParc).isNotNull();
        assertThat(restParc.uuid()).isEqualTo(uuid);
        assertThat(restParc.typeParc()).isEqualTo(EOLIEN);
        assertThat(restParc.production()).isEqualTo(production);
    }

    @Test
    public void shouldConvertToParcProducteur() {
        UUID uuid = randomUUID();
        int production = 40;
        var restParc = new RestParcProducteur(uuid, EOLIEN, production);
        ParcProducteur parcProducteur = restParc.toParcProducteur();
        assertThat(parcProducteur).usingRecursiveComparison().comparingOnlyFields().isEqualTo(restParc);
    }

}
