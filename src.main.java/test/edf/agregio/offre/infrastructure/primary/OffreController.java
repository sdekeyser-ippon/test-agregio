package test.edf.agregio.offre.infrastructure.primary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.edf.agregio.offre.application.OffreApplicationService;

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
}
