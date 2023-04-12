package test.edf.agregio.offre.infrastructure.primary;

import org.testng.annotations.Test;
import test.edf.agregio.offre.domain.BlocHoraire;
import test.edf.agregio.parc.infrastructure.primary.RestParcProducteur;

import java.util.Set;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static test.edf.agregio.parc.domain.TypeParc.HYDRAULIQUE;
import static test.edf.agregio.parc.domain.TypeParc.SOLAIRE;

public class RestBlocHoraireTest {

    @Test
    public void shouldCreateRestBlocHoraire() {
        UUID uuid = randomUUID();
        var restParcProducteurs = Set.of(new RestParcProducteur(randomUUID(), HYDRAULIQUE, 80));
        var prixPlancher = 450;
        var restBlocHoraire = new RestBlocHoraire(uuid, restParcProducteurs, prixPlancher);

        assertThat(restBlocHoraire).isNotNull();
        assertThat(restBlocHoraire.uuid()).isEqualTo(uuid);
        assertThat(restBlocHoraire.parcProducteurs()).isEqualTo(restParcProducteurs);
        assertThat(restBlocHoraire.prixPlancher()).isEqualTo(prixPlancher);
    }

    @Test
    public void shouldMapToBlocHoraire() {
        var restBlocHoraire = new RestBlocHoraire(randomUUID(), Set.of(new RestParcProducteur(randomUUID(), SOLAIRE, 90)), 600);

        BlocHoraire blocHoraire = restBlocHoraire.toBlocHoraire();

        assertThat(blocHoraire).usingRecursiveComparison().isEqualTo(restBlocHoraire);
    }

}
