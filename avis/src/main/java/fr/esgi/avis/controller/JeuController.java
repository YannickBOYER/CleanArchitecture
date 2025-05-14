package fr.esgi.avis.controller;

import fr.esgi.avis.controller.rest.*;
import fr.esgi.avis.controller.rest.dto.in.JeuRequestDTO;
import fr.esgi.avis.controller.rest.dto.out.*;
import fr.esgi.avis.usecase.exception.ModerateurNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("jeux")
public class JeuController {
    private final JeuRestController jeuRestController;
    private final GenreRestController genreRestController;
    private final EditeurRestController editeurRestController;
    private final ClassificationRestController classificationRestController;
    private final PlateformeRestController plateformeRestController;
    private final JoueurRestController joueurRestController;
    private final ModerateurRestController moderateurRestController;

    public JeuController(JeuRestController jeuRestController, GenreRestController genreRestController, EditeurRestController editeurRestController, ClassificationRestController classificationRestController, PlateformeRestController plateformeRestController, JoueurRestController joueurRestController, ModerateurRestController moderateurRestController) {
        this.jeuRestController = jeuRestController;
        this.genreRestController = genreRestController;
        this.editeurRestController = editeurRestController;
        this.classificationRestController = classificationRestController;
        this.plateformeRestController = plateformeRestController;
        this.joueurRestController = joueurRestController;
        this.moderateurRestController = moderateurRestController;
    }

    @GetMapping("")
    public ModelAndView findAll(@PageableDefault(size = 7, direction = Sort.Direction.ASC) Pageable pageable){
        final ModelAndView mav = new ModelAndView("jeux");

        final Page<JeuResponseDTO> jeux = jeuRestController.findAll(pageable);
        mav.addObject("jeux", jeux);

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final boolean isModerateur = auth.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_MODERATEUR"));
        mav.addObject("isModerateur", isModerateur);

        return mav;
    }

    @GetMapping("/{id}/avis")
    public ModelAndView avis(@PathVariable Long id, @PageableDefault(size = 7, direction = Sort.Direction.ASC) Pageable pageable){
        final ModelAndView mav = new ModelAndView("avis");

        final Page<AvisResponseDTO> avisByJeu = jeuRestController.avis(id, pageable);
        mav.addObject("avis", avisByJeu);

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final boolean isModerateur = auth.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_MODERATEUR"));
        final boolean isJoueur = auth.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_JOUEUR"));
        mav.addObject("isModerateur", isModerateur);
        mav.addObject("isJoueur", isJoueur);

        mav.addObject("idJeu", id);

        return mav;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        final ModelAndView mav = new ModelAndView("jeux-form");

        mav.addObject("jeu", new JeuRequestDTO());

        final List<GenreResponseDTO> genres = genreRestController.findAll();
        mav.addObject("genres", genres);

        final List<EditeurResponseDTO> editeurs = editeurRestController.findAll();
        mav.addObject("editeurs", editeurs);

        final List<ClassificationResponseDTO> classifications = classificationRestController.findAll();
        mav.addObject("classifications", classifications);

        final List<PlateformeResponseDTO> plateformes = plateformeRestController.findAll();
        mav.addObject("plateformes", plateformes);

        return mav;
    }

    @GetMapping("/{id}/avis/create")
    public ModelAndView createAvis(@PathVariable Long id){
        final ModelAndView mav = new ModelAndView("avis-form");

        final JeuResponseDTO jeu = jeuRestController.findById(id);
        mav.addObject("jeu", jeu);

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final String username = ((User)authentication.getPrincipal()).getUsername();
        final JoueurResponseDTO joueur = joueurRestController.findByUsername(username);
        mav.addObject("idJoueur", joueur.id);

        final List<ModerateurResponseDTO> moderateurs = moderateurRestController.findAll();
        if(moderateurs.isEmpty()){
            throw new ModerateurNotFoundException();
        }else{
            final Long idModerateur = moderateurs.get(0).id;
            mav.addObject("idModerateur", idModerateur);
        }

        return mav;
    }
}
