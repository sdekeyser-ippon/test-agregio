package test.edf.agregio.offre.infrastructure.secondary;

import test.edf.agregio.offre.domain.BlocHoraire;
import test.edf.agregio.parc.infrastructure.secondary.ParcEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

@Entity
public class BlocHoraireEntity {

    @Id
    private UUID uuid;

    @OneToMany
    private Set<ParcEntity> parcProducteurs;

    private int prixPlancher;

    public static BlocHoraireEntity from(BlocHoraire blocHoraire) {
        var blocHoraireEntity = new BlocHoraireEntity();
        blocHoraireEntity.setUuid(blocHoraire.uuid());
        blocHoraireEntity.setParcProducteurs(blocHoraire.parcProducteurs().stream().map(ParcEntity::from).collect(toSet()));
        blocHoraireEntity.setPrixPlancher(blocHoraire.prixPlancher());
        return blocHoraireEntity;
    }

    public BlocHoraire toBlocHoraire() {
        return new BlocHoraire(getUuid(), getParcProducteurs().stream().map(ParcEntity::toParcProducteur).collect(toSet()), getPrixPlancher());
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Set<ParcEntity> getParcProducteurs() {
        return parcProducteurs;
    }

    public void setParcProducteurs(Set<ParcEntity> parcProducteurs) {
        this.parcProducteurs = parcProducteurs;
    }

    public int getPrixPlancher() {
        return prixPlancher;
    }

    public void setPrixPlancher(int prixPlancher) {
        this.prixPlancher = prixPlancher;
    }
}
