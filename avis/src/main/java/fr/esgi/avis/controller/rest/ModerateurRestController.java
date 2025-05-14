package fr.esgi.avis.controller.rest;

import fr.esgi.avis.business.Moderateur;
import fr.esgi.avis.controller.rest.dto.out.ModerateurResponseDTO;
import fr.esgi.avis.controller.rest.mapper.ModerateurDtoMapper;
import fr.esgi.avis.usecase.usecase.ModerateurUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/moderateurs")
public class ModerateurRestController {
    private final ModerateurUseCase useCase;
    private final ModerateurDtoMapper moderateurDtoMapper;

    public ModerateurRestController(ModerateurUseCase useCase,
                                    ModerateurDtoMapper moderateurDtoMapper) {
        this.useCase = useCase;
        this.moderateurDtoMapper = moderateurDtoMapper;
    }

    @GetMapping("")
    public List<ModerateurResponseDTO> findAll(){
        final List<Moderateur> moderateurs = useCase.findAll();
        return moderateurs.stream().map(moderateurDtoMapper::toDto).collect(Collectors.toList());
    }
}
