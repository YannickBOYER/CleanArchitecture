package fr.esgi.avis.controller;

import fr.esgi.avis.controller.rest.JeuRestController;
import fr.esgi.avis.controller.rest.dto.out.AvisResponseDTO;
import fr.esgi.avis.controller.rest.dto.out.JeuResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("jeux")
public class JeuController {
    private final JeuRestController jeuRestController;

    public JeuController(JeuRestController jeuRestController) {
        this.jeuRestController = jeuRestController;
    }

    @GetMapping("")
    public ModelAndView findAll(@PageableDefault(size = 7, direction = Sort.Direction.ASC) Pageable pageable){
        final ModelAndView mav = new ModelAndView("jeux");
        final Page<JeuResponseDTO> jeux = jeuRestController.findAll(pageable);
        mav.addObject("jeux", jeux);
        return mav;
    }

    @GetMapping("/{id}/avis")
    public ModelAndView avis(@PathVariable Long id, @PageableDefault(size = 7, direction = Sort.Direction.ASC) Pageable pageable){
        final ModelAndView mav = new ModelAndView("avis");
        final Page<AvisResponseDTO> avisByJeu = jeuRestController.avis(id, pageable);
        mav.addObject("avis", avisByJeu);
        return mav;
    }
}
