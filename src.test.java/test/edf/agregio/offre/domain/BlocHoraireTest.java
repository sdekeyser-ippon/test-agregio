package test.edf.agregio.offre.domain;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BlocHoraireTest {

    @Test
    public void shouldCreateBlocHoraire() {
        int quantite = 10;
        int prix = 200;
        var blocHoraire = new BlocHoraire(quantite, prix);
        assertThat(blocHoraire).isNotNull();
        assertThat(blocHoraire.quantiteDesiree()).isEqualTo(quantite);
        assertThat(blocHoraire.prixPlancher()).isEqualTo(prix);
    }

}
