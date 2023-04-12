package test.edf.agregio.offre.domain;

import test.edf.agregio.parc.domain.ParcProducteur;

import java.util.Collection;

public record BlocHoraire(Collection<ParcProducteur> parcProducteurs, int prixPlancher) {
    public int quantite() {
        return parcProducteurs.stream().mapToInt(ParcProducteur::production).sum();
    }
}
