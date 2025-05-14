package fr.esgi.avis.utils.initialisation;

import com.github.javafaker.Faker;
import fr.esgi.avis.business.datasource.entity.*;
import fr.esgi.avis.usecase.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component
public class AjoutDonneesInitiales implements CommandLineRunner {
    private final ClassificationRepository classificationRepository;
    private final EditeurRepository editeurRepository;
    private final GenreRepository genreRepository;
    private final PlateformeRepository plateformeRepository;
    private final JeuRepository jeuRepository;
    private final JoueurRepository joueurRepository;
    private final ModerateurRepository moderateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;
    private static final Faker faker = new Faker(Locale.FRENCH);
    private static final Random random = new Random();
    private final AvisEntityRepository avisEntityRepository;

    public AjoutDonneesInitiales(ClassificationRepository classificationRepository, EditeurRepository editeurRepository, GenreRepository genreRepository, PlateformeRepository plateformeRepository, JeuRepository jeuRepository,
                                 JoueurRepository joueurRepository, ModerateurRepository moderateurRepository, PasswordEncoder passwordEncoder, InMemoryUserDetailsManager inMemoryUserDetailsManager,
                                 AvisEntityRepository avisEntityRepository) {
        this.classificationRepository = classificationRepository;
        this.editeurRepository = editeurRepository;
        this.genreRepository = genreRepository;
        this.plateformeRepository = plateformeRepository;
        this.jeuRepository = jeuRepository;
        this.joueurRepository = joueurRepository;
        this.moderateurRepository = moderateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
        this.avisEntityRepository = avisEntityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        generateUsers();
        generateClassifications();
        generateEditeurs();
        generateGenre();
        generatePlateformes();
        generateJeux();
        generateAvis();
    }

    public void generateAvis(){
        for(int i = 0; i < 100; i++){
            final AvisEntity avis = new AvisEntity(
                    faker.yoda().quote(),
                    jeuRepository.findAll().get(random.nextInt(jeuRepository.findAll().size())),
                    joueurRepository.findAll().get(random.nextInt(joueurRepository.findAll().size())),
                    (float)faker.number().numberBetween(0, 20),
                    faker.date()
                            .between(
                                    Date.from(LocalDate.of(2024, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                                    Date.from(LocalDate.of(2025, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant())
                            ).toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime(),
                    moderateurRepository.findAll().get(random.nextInt(moderateurRepository.findAll().size()))
            );
            avisEntityRepository.save(avis);
        }
    }

    public void generateJeux(){
        final String[] names = {
                "The Legend of Zelda: Breath of the Wild",
                "Elden Ring",
                "God of War Ragnarok",
                "Grand Theft Auto V",
                "Red Dead Redemption 2",
                "The Witcher 3: Wild Hunt",
                "Cyberpunk 2077",
                "Super Mario Odyssey",
                "Horizon Forbidden West",
                "Minecraft",
                "Fortnite",
                "Call of Duty: Modern Warfare II",
                "Overwatch 2",
                "League of Legends",
                "Valorant",
                "FIFA 23",
                "Assassin's Creed Valhalla",
                "Dark Souls III",
                "Animal Crossing: New Horizons",
                "Starfield",
        };

        for(int i = 0; i<names.length; i++){
            final JeuEntity jeu = new JeuEntity(
                    names[i],
                    faker.date()
                            .between(
                                    Date.from(LocalDate.of(2015, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                                    Date.from(LocalDate.of(2025, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant())
                            ).toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate(),
                    faker.avatar().image(),
                    faker.number().numberBetween(10, 20),
                    faker.yoda().quote(),
                    genreRepository.findAll().get(random.nextInt(genreRepository.findAll().size())),
                    editeurRepository.findAll().get(random.nextInt(editeurRepository.findAll().size())),
                    classificationRepository.findAll().get(random.nextInt(classificationRepository.findAll().size())),
                    getRandomPlateformes(random.nextInt(5))
            );
            jeuRepository.save(jeu);
        }
    }

    private void generatePlateformes(){
        final String[] nomsPlateformes = {
                "PlayStation", "PlayStation 2", "PlayStation 3", "PlayStation 4", "PlayStation 5",
                "Xbox", "Xbox 360", "Xbox One", "Xbox Series X", "Nintendo 64",
                "GameCube", "Wii", "Wii U", "Nintendo Switch", "PC", "Steam Deck", "PSP", "PS Vita"
        };
        for (String nom : nomsPlateformes) {
            LocalDate dateDeSortie = faker.date()
                    .between(
                            Date.from(LocalDate.of(1980, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                            Date.from(LocalDate.of(2025, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant())
                    )
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            PlateformeEntity plateforme = new PlateformeEntity(nom, dateDeSortie);
            plateformeRepository.save(plateforme);
        }
    }

    public List<PlateformeEntity> getRandomPlateformes(int numberOfPlateformes) {
        // Récupérer toutes les plateformes
        List<PlateformeEntity> allPlateformes = plateformeRepository.findAll();

        // Vérifier que le nombre demandé ne dépasse pas la taille de la liste
        if (numberOfPlateformes > allPlateformes.size()) {
            numberOfPlateformes = allPlateformes.size(); // Limiter au nombre d'éléments disponibles
        }

        // Créer une instance de Random pour générer des indices aléatoires
        Random rand = new Random();
        List<PlateformeEntity> randomPlateformes = new ArrayList<>();

        // Sélectionner aléatoirement les éléments
        while (randomPlateformes.size() < numberOfPlateformes) {
            int index = rand.nextInt(allPlateformes.size());
            PlateformeEntity plateforme = allPlateformes.get(index);

            // Éviter les doublons en vérifiant si la plateforme n'a pas déjà été ajoutée
            if (!randomPlateformes.contains(plateforme)) {
                randomPlateformes.add(plateforme);
            }
        }

        return randomPlateformes;
    }

    private void generateClassifications(){
        final String[] pegiLabels = {"PEGI3", "PEGI7", "PEGI12", "PEGI16", "PEGI18"};
        final int iteration = 5;
        for(int i = 0; i<iteration; i++){
            final ClassificationEntity classificationEntity = classificationRepository.save(
                    new ClassificationEntity(
                            pegiLabels[random.nextInt(pegiLabels.length)],
                            faker.color().hex()
                    )
            );
            classificationRepository.save(classificationEntity);
        }
    }

    private void generateEditeurs(){
        final EditeurEntity[] editeurs = {
                new EditeurEntity("Ubisoft"),
                new EditeurEntity("Electronic Arts"),
                new EditeurEntity("Nintendo"),
                new EditeurEntity("Sony Interactive Entertainment"),
                new EditeurEntity("Activision"),
                new EditeurEntity("Rockstar Games"),
                new EditeurEntity("Bethesda Softworks"),
                new EditeurEntity("Square Enix"),
        };
        final int iteration = 10;
        for(EditeurEntity editeur : editeurs){
            editeurRepository.save(editeur);
        }
    }

    private void generateGenre(){
        final GenreEntity[] genres = {
                new GenreEntity("Action"),
                new GenreEntity("Aventure"),
                new GenreEntity("RPG"),
                new GenreEntity("Stratégie"),
                new GenreEntity("Simulation"),
                new GenreEntity("FPS"),
                new GenreEntity("Plateforme"),
                new GenreEntity("Puzzle"),
                new GenreEntity("Horreur"),
                new GenreEntity("Course"),
                new GenreEntity("Combat"),
                new GenreEntity("MMORPG")
        };
        for (GenreEntity genre : genres) {
            genreRepository.save(genre);
        }
    }

    private void generateUsers(){
        final int userIterator = 10;
        int i = 0;
        while (i<userIterator){
            i++;
            final JoueurEntity joueurEntity = new JoueurEntity(faker.name().firstName(), faker.internet().emailAddress(), faker.internet().password(), LocalDate.now());
            final ModerateurEntity moderateur = new ModerateurEntity(faker.name().firstName(), faker.internet().emailAddress(), faker.internet().password(), faker.phoneNumber().cellPhone());
            joueurRepository.save(joueurEntity);
            moderateurRepository.save(moderateur);
        }
        final JoueurEntity joueurTest = new JoueurEntity("joueur", "joueur@joueur.fr","joueur", LocalDate.now());
        final ModerateurEntity moderateurTest = new ModerateurEntity("moderateur", "moderateur@moderateur.fr","moderateur", faker.phoneNumber().cellPhone());
        joueurRepository.save(joueurTest);
        moderateurRepository.save(moderateurTest);

        for (JoueurEntity joueur: joueurRepository.findAll()) {
            UserDetails newUser = User.builder().username(joueur.getPseudo())
                    .password(passwordEncoder.encode(joueur.getMotDePasse()))
                    .roles("JOUEUR")
                    .build();
            if(!inMemoryUserDetailsManager.userExists(newUser.getUsername())){
                inMemoryUserDetailsManager.createUser(newUser);
            }
        }
        for (ModerateurEntity moderateur: moderateurRepository.findAll()) {
            UserDetails newUser = User.builder().username(moderateur.getPseudo())
                    .password(passwordEncoder.encode(moderateur.getMotDePasse()))
                    .roles("MODERATEUR")
                    .build();
            if(!inMemoryUserDetailsManager.userExists(newUser.getUsername())){
                inMemoryUserDetailsManager.createUser(newUser);
            }
        }
    }
}
