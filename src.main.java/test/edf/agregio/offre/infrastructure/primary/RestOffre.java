package test.edf.agregio.offre.infrastructure.primary;

import test.edf.agregio.marche.domain.Marche;
import test.edf.agregio.marche.domain.Reserve;
import test.edf.agregio.offre.domain.Offre;

import java.util.Collection;
import java.util.UUID;

public record RestOffre(UUID uuid, Reserve marche, Collection<RestBlocHoraire> blocHoraires) {
    public Offre toOffre() {
        return new Offre(uuid(), new Marche(marche()), blocHoraires.stream().map(RestBlocHoraire::toBlocHoraire).toList());
    }
}
