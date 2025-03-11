package fr.esgi.avis.controller.rest;

import fr.esgi.avis.business.Editeur;
import fr.esgi.avis.controller.rest.dto.in.EditeurRequestDTO;
import fr.esgi.avis.controller.rest.dto.out.EditeurResponseDTO;
import fr.esgi.avis.controller.rest.mapper.EditeurDtoMapper;
import fr.esgi.avis.usecase.usecase.EditeurUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Editeurs")
public class EditeurRestController {
    private final EditeurUseCase useCase;
    private final EditeurDtoMapper mapper;

    public EditeurRestController(EditeurUseCase useCase, EditeurDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EditeurResponseDTO create(@RequestBody EditeurRequestDTO requestDTO){
        final Editeur editeur = mapper.toBusiness(requestDTO);
        return mapper.toDto(useCase.save(editeur));
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<EditeurResponseDTO> findAll(){
        return useCase.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public EditeurResponseDTO findById(@PathVariable Long id){
        return mapper.toDto(useCase.findById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        useCase.deleteById(id);
    }
}
