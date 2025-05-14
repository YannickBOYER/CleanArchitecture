package fr.esgi.avis.controller.rest;

import fr.esgi.avis.business.Joueur;
import fr.esgi.avis.controller.rest.dto.out.JoueurResponseDTO;
import fr.esgi.avis.controller.rest.mapper.JoueurDtoMapper;
import fr.esgi.avis.usecase.usecase.JoueurUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/joueurs")
public class JoueurRestController {
    private final JoueurUseCase useCase;
    private final JoueurDtoMapper joueurDtoMapper;

    public JoueurRestController(JoueurUseCase useCase,
                                JoueurDtoMapper joueurDtoMapper) {
        this.useCase = useCase;
        this.joueurDtoMapper = joueurDtoMapper;
    }

    @GetMapping("/{username}")
    public JoueurResponseDTO findByUsername(@PathVariable String username){
        final Joueur joueur = useCase.findByUsername(username);
        return joueurDtoMapper.toDto(joueur);
    }
}
