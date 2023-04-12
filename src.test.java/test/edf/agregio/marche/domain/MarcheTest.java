package test.edf.agregio.marche.domain;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static test.edf.agregio.marche.domain.Reserve.PRIMAIRE;

public class MarcheTest {

    @Test
    public void shouldCreateMarche() {
        var marche = new Marche(PRIMAIRE);
        assertThat(marche).isNotNull();
        assertThat(marche.reserve()).isEqualTo(PRIMAIRE);
    }

}
