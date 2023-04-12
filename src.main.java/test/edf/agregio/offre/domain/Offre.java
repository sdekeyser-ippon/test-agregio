package test.edf.agregio.offre.domain;

import java.util.Collection;

public record Offre(test.edf.agregio.marche.domain.Marche marche, Collection<BlocHoraire> blocHoraires) {
}
