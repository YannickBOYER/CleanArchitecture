package fr.esgi.avis.controller.rest;

import fr.esgi.avis.business.Genre;
import fr.esgi.avis.controller.rest.dto.in.GenreRequestDTO;
import fr.esgi.avis.controller.rest.dto.out.GenreResponseDTO;
import fr.esgi.avis.controller.rest.mapper.GenreDtoMapper;
import fr.esgi.avis.usecase.usecase.GenreUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Genres")
public class GenreRestController {
    private final GenreUseCase useCase;
    private final GenreDtoMapper mapper;

    public GenreRestController(GenreUseCase genreUseCase, GenreDtoMapper genreMapper) {
        this.useCase = genreUseCase;
        this.mapper = genreMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public GenreResponseDTO create(@RequestBody GenreRequestDTO requestDTO){
        final Genre genre = mapper.toBusiness(requestDTO);
        return mapper.toDto(useCase.save(genre));
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<GenreResponseDTO> findAll(){
        final List<Genre> genres = useCase.findAll();
        return genres.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public GenreResponseDTO findById(@PathVariable Long id){
        final Genre genre = useCase.findById(id);
        return mapper.toDto(genre);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public GenreResponseDTO update(@PathVariable Long id, @RequestBody GenreRequestDTO requestDTO){
        final Genre genre = useCase.update(id, mapper.toBusiness(requestDTO));
        return mapper.toDto(genre);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id){
        useCase.delete(id);
    }
}
