package test.edf.agregio.offre.infrastructure.primary;

import test.edf.agregio.offre.domain.BlocHoraire;
import test.edf.agregio.parc.infrastructure.primary.RestParcProducteur;

import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

public record RestBlocHoraire(UUID uuid, Set<RestParcProducteur> parcProducteurs, int prixPlancher) {
    public BlocHoraire toBlocHoraire() {
        return new BlocHoraire(uuid(), parcProducteurs().stream().map(RestParcProducteur::toParcProducteur).collect(toSet()), prixPlancher());
    }
}
