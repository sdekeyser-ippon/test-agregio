package test.edf.agregio.parc.infrastructure.primary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.edf.agregio.parc.application.ParcApplicationService;

@RestController
@RequestMapping("/api/parc")
public class ParcController {

    private final ParcApplicationService parcApplicationService;

    public ParcController(ParcApplicationService parcApplicationService) {
        this.parcApplicationService = parcApplicationService;
    }

    @PostMapping
    public ResponseEntity<Void> createParcProducteur(RestParcProducteur restParcProducteur) {
        parcApplicationService.save(restParcProducteur.toParcProducteur());
        return ResponseEntity.ok().build();
    }
}
