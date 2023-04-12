package test.edf.agregio.offre.domain;

import test.edf.agregio.marche.domain.Marche;

import java.util.Collection;
import java.util.UUID;

public record Offre(UUID uuid, Marche marche, Collection<BlocHoraire> blocHoraires) {
}
