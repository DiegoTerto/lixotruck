package br.com.lixotruck.lixotruck.model.region.service;

import br.com.lixotruck.lixotruck.model.region.Region;
import br.com.lixotruck.lixotruck.model.region.RegionRepository;
import br.com.lixotruck.lixotruck.model.region.Router;
import br.com.lixotruck.lixotruck.model.region.dtos.create.CreateOrUpdateRegionDTO;
import br.com.lixotruck.lixotruck.model.region.dtos.create.CreateOrUpdateRouterDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class RegionServiceTest {

    @InjectMocks
    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;

    @Test
    void shouldCreateOK() {
        CreateOrUpdateRegionDTO dto = createOrUpdateRegionDTO();

        when(regionRepository.save(any())).thenReturn(new Region());

        assertDoesNotThrow(() -> regionService.create(dto));
        verify(regionRepository).save(any());
    }

    @Test
    void shouldUpdateThrowException() {
        CreateOrUpdateRegionDTO dto = createOrUpdateRegionDTO();
        UUID id = UUID.randomUUID();

        RuntimeException ex = assertThrows(RuntimeException.class, () -> regionService.update(dto, id));

        verify(regionRepository).findById(any());
        assertEquals("Região não encontrada", ex.getMessage());
    }

    @Test
    void shouldUpdateOK() {
        CreateOrUpdateRegionDTO dto = createOrUpdateRegionDTO();
        UUID id = UUID.randomUUID();
        List<Router> router = new ArrayList<>();
        Region region = new Region(id, "region name", "region code", router);

        when(regionRepository.findById(any())).thenReturn(Optional.of(region));
        assertDoesNotThrow(() -> regionService.update(dto, id));

        verify(regionRepository).findById(any());
        verify(regionRepository).save(any());
    }

    @Test
    void shouldDeleteThrowException() {
        UUID id = UUID.randomUUID();

        RuntimeException ex = assertThrows(RuntimeException.class, () -> regionService.delete(id));

        assertEquals("Região não encontrada", ex.getMessage());
    }

    @Test
    void shouldDeleteOK() {
        UUID id = UUID.randomUUID();
        List<Router> router = new ArrayList<>();
        Region region = new Region(id, "region name", "region code", router);

        when(regionRepository.findById(any())).thenReturn(Optional.of(region));

        assertDoesNotThrow(() -> regionService.delete(id));
        verify(regionRepository).findById(any());
    }

    private CreateOrUpdateRegionDTO createOrUpdateRegionDTO() {
        List<CreateOrUpdateRouterDTO> routers = new ArrayList<>();
        return new CreateOrUpdateRegionDTO("region name", "region code", routers);
    }
}
