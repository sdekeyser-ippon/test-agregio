package test.edf.agregio.offre.infrastructure.secondary;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import test.edf.agregio.offre.domain.BlocHoraire;
import test.edf.agregio.parc.domain.ParcProducteur;
import test.edf.agregio.parc.infrastructure.secondary.ParcEntity;

import java.util.Set;

import static java.util.UUID.randomUUID;
import static test.edf.agregio.parc.domain.TypeParc.EOLIEN;
import static test.edf.agregio.parc.domain.TypeParc.SOLAIRE;

public class BlocHoraireEntityTest {

    @Test
    public void shouldCreateBlocHoraireEntity() {
        var blocHoraire = new BlocHoraire(randomUUID(), Set.of(new ParcProducteur(randomUUID(), EOLIEN, 50)), 800);
        BlocHoraireEntity blocHoraireEntity = BlocHoraireEntity.from(blocHoraire);
        Assertions.assertThat(blocHoraireEntity).usingRecursiveComparison().isEqualTo(blocHoraire);
    }

    @Test
    public void shouldMapToBlocHoraire() {
        var blocHoraireEntity = new BlocHoraireEntity();
        blocHoraireEntity.setUuid(randomUUID());
        var parcEntity = new ParcEntity();
        parcEntity.setUuid(randomUUID());
        parcEntity.setTypeParc(SOLAIRE);
        parcEntity.setProduction(40);
        blocHoraireEntity.setParcProducteurs(Set.of(parcEntity));
        blocHoraireEntity.setPrixPlancher(760);
        BlocHoraire blocHoraire = blocHoraireEntity.toBlocHoraire();
        Assertions.assertThat(blocHoraire).usingRecursiveComparison().isEqualTo(blocHoraireEntity);
    }

}
