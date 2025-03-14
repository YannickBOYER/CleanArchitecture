package fr.esgi.avis.utils.initialisation;

import fr.esgi.avis.business.datasource.entity.*;
import fr.esgi.avis.business.datasource.mapper.*;
import fr.esgi.avis.usecase.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AjoutDonneesInitiales implements CommandLineRunner {
    private final ClassificationRepository classificationRepository;
    private final EditeurRepository editeurRepository;
    private final GenreRepository genreRepository;
    private final PlateformeRepository plateformeRepository;
    private final JeuRepository jeuRepository;
    private final ClassificationMapper classificationMapper;
    private final EditeurMapper editeurMapper;
    private final GenreMapper genreMapper;
    private final PlateformeMapper plateformeMapper;
    private final JeuMapper jeuMapper;

    public AjoutDonneesInitiales(ClassificationRepository classificationRepository, EditeurRepository editeurRepository, GenreRepository genreRepository, PlateformeRepository plateformeRepository, JeuRepository jeuRepository,
                                 ClassificationMapper classificationMapper,
                                 EditeurMapper editeurMapper,
                                 GenreMapper genreMapper,
                                 PlateformeMapper plateformeMapper,
                                 JeuMapper jeuMapper) {
        this.classificationRepository = classificationRepository;
        this.editeurRepository = editeurRepository;
        this.genreRepository = genreRepository;
        this.plateformeRepository = plateformeRepository;
        this.jeuRepository = jeuRepository;
        this.classificationMapper = classificationMapper;
        this.editeurMapper = editeurMapper;
        this.genreMapper = genreMapper;
        this.plateformeMapper = plateformeMapper;
        this.jeuMapper = jeuMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        final ClassificationEntity classificationEntity = classificationRepository.save(new ClassificationEntity("PEGI12", "ff00ff"));
        final EditeurEntity editeurEntity = editeurRepository.save(new EditeurEntity("Ubisoft"));
        final GenreEntity genreEntity = genreRepository.save(new GenreEntity("Action"));
        final PlateformeEntity plateformeEntity = plateformeRepository.save(new PlateformeEntity("PS5", LocalDate.now()));

        /*final Classification classification = classificationMapper.toBusiness(classificationEntity);
        final Editeur editeur = editeurMapper.toBusiness(editeurEntity);
        final Genre genre = genreMapper.toBusiness(genreEntity);
        final Plateforme plateforme = plateformeMapper.toBusiness(plateformeEntity);

        final List<Plateforme> plateformes = new ArrayList<>();
        plateformes.add(plateforme);

        Jeu jeu = new Jeu("Assassin's creed", LocalDate.now(), "Image AC", 6.5f, "Jeu action aventure", genre, editeur, classification, plateformes);
        JeuEntity jeuEntity = jeuMapper.toEntity(jeu);
        jeuEntity = jeuRepository.save(jeuEntity);
        jeu = jeuMapper.toBusiness(jeuEntity);*/
    }
}
