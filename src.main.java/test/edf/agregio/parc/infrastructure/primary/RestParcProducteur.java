package test.edf.agregio.parc.infrastructure.primary;

import test.edf.agregio.parc.domain.ParcProducteur;
import test.edf.agregio.parc.domain.TypeParc;

import java.util.UUID;

public record RestParcProducteur(UUID uuid, TypeParc typeParc, int production) {
    public ParcProducteur toParcProducteur() {
        return new ParcProducteur(uuid(), typeParc(), production());
    }
}
