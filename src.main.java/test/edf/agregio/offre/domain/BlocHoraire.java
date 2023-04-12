package test.edf.agregio.offre.domain;

import test.edf.agregio.parc.domain.ParcProducteur;

import java.util.Collection;
import java.util.UUID;

public record BlocHoraire(UUID uuid, Collection<ParcProducteur> parcProducteurs, int prixPlancher) {
    public int quantite() {
        return parcProducteurs.stream().mapToInt(ParcProducteur::production).sum();
    }
}
