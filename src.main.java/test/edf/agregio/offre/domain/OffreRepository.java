package test.edf.agregio.offre.domain;

import test.edf.agregio.marche.domain.Reserve;

import java.util.Set;

public interface OffreRepository {
    void save(Offre offre);

    Set<Offre> find(Reserve reserve);
}
