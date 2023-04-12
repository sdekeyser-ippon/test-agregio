package test.edf.agregio.offre.infrastructure.primary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.edf.agregio.marche.domain.Reserve;
import test.edf.agregio.offre.application.OffreApplicationService;
import test.edf.agregio.offre.domain.BlocHoraire;
import test.edf.agregio.offre.domain.Offre;
import test.edf.agregio.parc.domain.ParcProducteur;
import test.edf.agregio.parc.infrastructure.primary.RestParcProducteur;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RestController
@RequestMapping("/api/offre")
public class OffreController {

    private final OffreApplicationService offreApplicationService;

    public OffreController(OffreApplicationService offreApplicationService) {
        this.offreApplicationService = offreApplicationService;
    }

    @PostMapping
    public ResponseEntity<Void> createOffre(RestOffre restOffre) {
        offreApplicationService.save(restOffre.toOffre());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Set<RestOffre>> getOffre(Reserve reserve) {
        return ResponseEntity.ok(offreApplicationService.find(reserve).stream().map(this::mapRestOffre).collect(toSet()));
    }

    private RestOffre mapRestOffre(Offre offre) {
        return new RestOffre(offre.uuid(), offre.marche().reserve(), offre.blocHoraires().stream().map(this::mapBlocHoraire).toList());
    }

    private RestBlocHoraire mapBlocHoraire(BlocHoraire blocHoraire) {
        return new RestBlocHoraire(blocHoraire.uuid(), blocHoraire.parcProducteurs().stream().map(this::mapParcProducteur).collect(toSet()), blocHoraire.prixPlancher());
    }

    private RestParcProducteur mapParcProducteur(ParcProducteur parcProducteur) {
        return new RestParcProducteur(parcProducteur.uuid(), parcProducteur.typeParc(), parcProducteur.production());
    }
}
