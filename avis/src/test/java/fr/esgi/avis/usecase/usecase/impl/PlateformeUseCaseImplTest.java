package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Plateforme;
import fr.esgi.avis.business.datasource.adapter.PlateformeJpaAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PlateformeUseCaseImplTest {
    @Mock
    PlateformeJpaAdapter jpaAdapter;
    @InjectMocks
    PlateformeUseCaseImpl plateformeUseCaseImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Plateforme plateforme1 = new Plateforme(Long.valueOf(1),"test1", LocalDate.of(2025, Month.MARCH, 11));
        Plateforme plateforme2 = new Plateforme(Long.valueOf(2),"test2", LocalDate.of(2025, Month.MARCH, 10));


        when(jpaAdapter.findAll()).thenReturn(List.of(plateforme1, plateforme2));

        List<Plateforme> result = plateformeUseCaseImpl.findAll();

        assertThat(result).containsExactlyInAnyOrder(plateforme1, plateforme2);
    }

    @Test
    void testFindById() {
        Plateforme plateforme = new Plateforme(Long.valueOf(1),"PlateformeTest", LocalDate.of(2025, Month.MARCH, 11));

        when(jpaAdapter.findById(anyLong())).thenReturn(Optional.of(plateforme));

        Plateforme result = plateformeUseCaseImpl.findById(plateforme.getId());

        assertNotNull(result.getId());
        assertEquals(plateforme.getNom(), result.getNom());
        assertEquals(plateforme.getDateDeSortie(), result.getDateDeSortie());
    }
}
