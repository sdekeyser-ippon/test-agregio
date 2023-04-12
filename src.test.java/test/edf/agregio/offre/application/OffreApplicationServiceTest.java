package test.edf.agregio.offre.application;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.edf.agregio.marche.domain.Marche;
import test.edf.agregio.offre.domain.BlocHoraire;
import test.edf.agregio.offre.domain.Offre;
import test.edf.agregio.offre.domain.OffreRepository;
import test.edf.agregio.parc.domain.ParcProducteur;

import java.util.List;
import java.util.Set;

import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.verify;
import static test.edf.agregio.marche.domain.Reserve.RAPIDE;
import static test.edf.agregio.parc.domain.TypeParc.SOLAIRE;

public class OffreApplicationServiceTest {

    private OffreApplicationService offreApplicationService;
    @Mock
    private OffreRepository offreRepository;

    @BeforeTest
    public void init() {
        MockitoAnnotations.openMocks(this);
        offreApplicationService = new OffreApplicationService(offreRepository);
    }

    @Test
    public void shouldSaveOffre() {
        var offre = new Offre(randomUUID(), new Marche(RAPIDE), List.of(new BlocHoraire(randomUUID(), Set.of(new ParcProducteur(randomUUID(), SOLAIRE, 50)), 640)));

        offreApplicationService.save(offre);

        verify(offreRepository).save(offre);
    }
}
