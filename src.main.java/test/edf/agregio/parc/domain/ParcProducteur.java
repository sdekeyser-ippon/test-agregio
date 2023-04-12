package test.edf.agregio.parc.domain;

import java.util.UUID;

public record ParcProducteur(UUID uuid, TypeParc typeParc, int production) {
}
