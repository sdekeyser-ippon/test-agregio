package test.edf.agregio.offre.infrastructure.secondary;

import test.edf.agregio.marche.domain.Marche;
import test.edf.agregio.marche.domain.Reserve;
import test.edf.agregio.offre.domain.Offre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class OffreEntity {

    @Id
    private UUID uuid;
    private Reserve marche;
    @OneToMany
    private List<BlocHoraireEntity> blocHoraires;

    public static OffreEntity from(Offre offre) {
        var offreEntity = new OffreEntity();
        offreEntity.setUuid(offre.uuid());
        offreEntity.setMarche(offre.marche().reserve());
        offreEntity.setBlocHoraires(offre.blocHoraires().stream().map(BlocHoraireEntity::from).toList());
        return offreEntity;
    }

    public Offre toOffre() {
        return new Offre(getUuid(), new Marche(getMarche()), getBlocHoraires().stream().map(BlocHoraireEntity::toBlocHoraire).toList());
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Reserve getMarche() {
        return marche;
    }

    public void setMarche(Reserve marche) {
        this.marche = marche;
    }

    public List<BlocHoraireEntity> getBlocHoraires() {
        return blocHoraires;
    }

    public void setBlocHoraires(List<BlocHoraireEntity> blocHoraires) {
        this.blocHoraires = blocHoraires;
    }
}
