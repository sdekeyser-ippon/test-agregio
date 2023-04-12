package test.edf.agregio.offre.domain;

import org.testng.annotations.Test;
import test.edf.agregio.parc.domain.ParcProducteur;

import java.util.Set;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static test.edf.agregio.parc.domain.TypeParc.EOLIEN;
import static test.edf.agregio.parc.domain.TypeParc.SOLAIRE;

public class BlocHoraireTest {

    @Test
    public void shouldCreateBlocHoraire() {
        int prix = 500;
        UUID uuid = randomUUID();
        Set<ParcProducteur> parcProducteurs = Set.of(new ParcProducteur(randomUUID(), SOLAIRE, 30), new ParcProducteur(randomUUID(), EOLIEN, 20));
        var blocHoraire = new BlocHoraire(uuid, parcProducteurs, prix);
        assertThat(blocHoraire).isNotNull();
        assertThat(blocHoraire.uuid()).isEqualTo(uuid);
        assertThat(blocHoraire.parcProducteurs()).isEqualTo(parcProducteurs);
        assertThat(blocHoraire.prixPlancher()).isEqualTo(prix);
    }

    @Test
    public void shouldComputeQuantite() {
        int productionSolaire = 30;
        int productionEolien = 20;
        Set<ParcProducteur> parcProducteurs = Set.of(new ParcProducteur(randomUUID(), SOLAIRE, productionSolaire), new ParcProducteur(randomUUID(), EOLIEN, productionEolien));
        var blocHoraire = new BlocHoraire(randomUUID(), parcProducteurs, 300);
        assertThat(blocHoraire.quantite()).isEqualTo(productionEolien + productionSolaire);
    }

}
