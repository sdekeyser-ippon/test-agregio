package test.edf.agregio.parc.infrastructure.secondary;

import test.edf.agregio.parc.domain.ParcProducteur;
import test.edf.agregio.parc.domain.TypeParc;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ParcEntity {

    @Id
    private UUID uuid;
    private TypeParc typeParc;
    private int production;

    public static ParcEntity from(ParcProducteur parcProducteur) {
        var parcEntity = new ParcEntity();
        parcEntity.setUuid(parcProducteur.uuid());
        parcEntity.setTypeParc(parcProducteur.typeParc());
        parcEntity.setProduction(parcProducteur.production());
        return parcEntity;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public TypeParc getTypeParc() {
        return typeParc;
    }

    public void setTypeParc(TypeParc typeParc) {
        this.typeParc = typeParc;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public ParcProducteur toParcProducteur() {
        return new ParcProducteur(getUuid(), getTypeParc(), getProduction());
    }
}
