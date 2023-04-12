package test.edf.agregio.offre.infrastructure.secondary;

import org.testng.annotations.Test;
import test.edf.agregio.marche.domain.Marche;
import test.edf.agregio.offre.domain.BlocHoraire;
import test.edf.agregio.offre.domain.Offre;
import test.edf.agregio.parc.domain.ParcProducteur;
import test.edf.agregio.parc.infrastructure.secondary.ParcEntity;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static test.edf.agregio.marche.domain.Reserve.PRIMAIRE;
import static test.edf.agregio.marche.domain.Reserve.SECONDAIRE;
import static test.edf.agregio.parc.domain.TypeParc.EOLIEN;

public class OffreEntityTest {

    @Test
    public void shouldCreateOffreEntity() {
        UUID uuid = randomUUID();
        var offre = new Offre(uuid, new Marche(PRIMAIRE), List.of(new BlocHoraire(randomUUID(), Set.of(new ParcProducteur(randomUUID(), EOLIEN, 50)), 800)));
        OffreEntity offreEntity = OffreEntity.from(offre);
        assertThat(offreEntity).usingRecursiveComparison().ignoringFields("marche").isEqualTo(offre);
        assertThat(offreEntity.getMarche()).isEqualTo(PRIMAIRE);
    }

    @Test
    public void shouldMapToOffre() {
        var offreEntity = new OffreEntity();
        offreEntity.setUuid(randomUUID());
        offreEntity.setMarche(SECONDAIRE);
        var parcEntity = new ParcEntity();
        parcEntity.setUuid(randomUUID());
        parcEntity.setProduction(50);
        parcEntity.setTypeParc(EOLIEN);
        var blocHoraireEntity = new BlocHoraireEntity();
        blocHoraireEntity.setUuid(randomUUID());
        blocHoraireEntity.setParcProducteurs(Set.of(parcEntity));
        blocHoraireEntity.setPrixPlancher(760);
        offreEntity.setBlocHoraires(List.of(blocHoraireEntity));

        Offre offre = offreEntity.toOffre();

        assertThat(offre).usingRecursiveComparison().ignoringFields("marche").isEqualTo(offreEntity);
        assertThat(offre.marche().reserve()).isEqualTo(SECONDAIRE);
    }

}
