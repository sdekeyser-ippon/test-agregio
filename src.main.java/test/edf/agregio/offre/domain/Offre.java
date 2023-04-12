package test.edf.agregio.offre.domain;

import test.edf.agregio.marche.domain.Marche;

import java.util.Collection;

public record Offre(Marche marche, Collection<BlocHoraire> blocHoraires) {
}
