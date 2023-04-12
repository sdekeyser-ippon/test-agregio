package test.edf.agregio.parc.application;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.edf.agregio.parc.domain.ParcProducteur;
import test.edf.agregio.parc.domain.ParcRepository;

import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.verify;
import static test.edf.agregio.parc.domain.TypeParc.HYDRAULIQUE;

public class ParcApplicationServiceTest {

    private ParcApplicationService parcApplicationService;
    @Mock
    ParcRepository parcRepository;

    @BeforeTest
    public void init() {
        MockitoAnnotations.openMocks(this);
        parcApplicationService = new ParcApplicationService(parcRepository);
    }

    @Test
    public void shouldSaveParc() {
        var parcProducteur = new ParcProducteur(randomUUID(), HYDRAULIQUE, 40);

        parcApplicationService.save(parcProducteur);

        verify(parcRepository).save(parcProducteur);
    }

}
