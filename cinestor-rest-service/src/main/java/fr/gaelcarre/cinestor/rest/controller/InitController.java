package fr.gaelcarre.cinestor.rest.controller;

import java.util.HashMap;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import fr.gaelcarre.cinestor.model.Element;
import fr.gaelcarre.cinestor.model.Episode;
import fr.gaelcarre.cinestor.model.Project;
import fr.gaelcarre.cinestor.model.TypeElement;
import fr.gaelcarre.cinestor.model.TypeProject;
import fr.gaelcarre.cinestor.model.User;
import fr.gaelcarre.cinestor.model.UserRole;
import fr.gaelcarre.cinestor.repository.ProjectRepository;
import fr.gaelcarre.cinestor.repository.TypeElementRepository;
import fr.gaelcarre.cinestor.repository.UserRepository;
import fr.gaelcarre.cinestor.repository.UserRoleRepository;

@Component
public class InitController {

	private Logger logger = LoggerFactory.getLogger(InitController.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private TypeElementRepository typeElementRepository;

	private HashMap<String, TypeElement> typesElement = new HashMap<>();

	@Transactional
	public void init() {

		this.logger.debug("Init dataset");

		initializeElementType();

		User gca = new User("gca", "gcagca@gca.com", true, (new BCryptPasswordEncoder(11)).encode("gca"), "Gaël CARRE");
		User nhe = new User("nhe", "gcagca@gca.com", true, (new BCryptPasswordEncoder(11)).encode("nhe"),
				"Nathan HENRY");

		this.userRepository.save(gca);
		this.userRepository.save(nhe);
		this.userRoleRepository.save(new UserRole("gca", "ROLE_ADMIN"));
		this.userRoleRepository.save(new UserRole("gca", "ROLE_USER"));
		this.userRoleRepository.save(new UserRole("nhe", "ROLE_ADMIN"));
		this.userRoleRepository.save(new UserRole("nhe", "ROLE_USER"));

		Project p = new Project();
		p.setName("Angular Material");
		p.setType(TypeProject.TVSHOW);
		p.setIsPublic(true);
		p.getMembers().add(gca);
		p.getMembers().add(nhe);
		p.setDescription(description());
		p.setElements(new HashSet<>());

		Element s = new Element();
		s.setNumber(1);
		s.setType(this.typesElement.get("season"));
		s.setSubelements(new HashSet<>());

		Element s2 = new Element();
		s2.setNumber(2);
		s2.setType(this.typesElement.get("season"));
		s2.setSubelements(new HashSet<>());

		Element e1 = new Element();
		e1.setNumber(1);
		e1.setType(this.typesElement.get("episode"));
		e1.setSubelements(new HashSet<>());

		for (int i = 1; i < 3; i++)
			e1.getSubelements().add(createScene(i));

		Episode e2 = new Episode();
		e2.setNumber(2);

		s.getEpisodes().add(e1);
		s.getEpisodes().add(e2);

		Episode e3 = new Episode();
		e3.setNumber(1);

		s2.getEpisodes().add(e3);

		p.getSeasons().add(s);
		p.getSeasons().add(s2);

		this.projectRepository.save(p);
		// this.elementRepository.save(e1);

	}

	private String description() {
		return "Contrairement à une opinion répandue, le Lorem Ipsum n'est pas simplement du texte aléatoire. Il trouve ses racines dans une oeuvre de la littérature latine classique datant de 45 av. J.-C., le rendant vieux de 2000 ans. Un professeur du Hampden-Sydney College, en Virginie, s'est intéressé à un des mots latins les plus obscurs, consectetur, extrait d'un passage du Lorem Ipsum, et en étudiant tous les usages de ce mot dans la littérature classique, découvrit la source incontestable du Lorem Ipsum. Il provient en fait des sections 1.10.32 et 1.10.33 du \"De Finibus Bonorum et Malorum\" (Des Suprêmes Biens et des Suprêmes Maux) de Cicéron. Cet ouvrage, très populaire pendant la Renaissance, est un traité sur la théorie de l'éthique. Les premières lignes du Lorem Ipsum, \"Lorem ipsum dolor sit amet...\", proviennent de la section 1.10.32.L'extrait standard de Lorem Ipsum utilisé depuis le XVIè siècle est reproduit ci-dessous pour les curieux. Les sections 1.10.32 et 1.10.33 du \"De Finibus Bonorum et Malorum\" de Cicéron sont aussi reproduites dans leur version originale, accompagnée de la traduction anglaise de H. Rackham (1914).";
	}

	public Element createScene(Integer i) {
		Element s = new Element();
		s.setType(this.typesElement.get("scene"));
		s.setNumber(i);
		s.setDescription(
				"Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker.");
		Element ch = new Element();
		ch.setSubelements(new HashSet<>());
		ch.getSubelements().add(createElement(1, "title", "Bob Sinclair"));
		ch.setDescription("Un justicier mystérieux errant dans le Far West qui est un as de la gâchette");
		c.setType(TypeElement.CHARACTER);
		s.setElements(new HashSet<>());
		s.getElements().add(c);
		Element cc = new Element();
		cc.setName("Marine Le Pen");
		cc.setSheet("Un justicier mystérieux errant dans le Far West qui est un as de la gâchette");
		cc.setType(TypeElement.CHARACTER);
		s.getElements().add(cc);

		Element place = new Element();
		place.setType(TypeElement.PLACE);
		place.setName("Paris Bercy");
		place.setDescription("Siege du ministère des finances");
		s.getElements().add(place);

		Element st = new Element();
		st.setType(TypeElement.SOUNDTRACK);
		st.setArtist("Savant");
		st.setTrack("Circus");
		st.setYoutube("0RJYaEwu3Ps");
		s.getElements().add(st);

		return s;
	}

	private Element createElement(int i, String string, String string2) {
		Element e = new Element();
		e.setType(this.typesElement.get(string));
		e.setNumber(i);
		e.setValue(string2);
		return e;
	}

	private void initializeElementType() {

		this.typesElement.put("season", new TypeElement("Season", 1));
		this.typesElement.put("episode", new TypeElement("Episode", 2));
		this.typesElement.put("scene", new TypeElement("Scene", 3));
		this.typesElement.put("soundtrack", new TypeElement("Soundtrack", 4));
		this.typesElement.put("character", new TypeElement("Character", 4));
		this.typesElement.put("elementset", new TypeElement("Elementset", 4));
		this.typesElement.put("title", new TypeElement("Title", 5));
		this.typesElement.put("description", new TypeElement("Description", 5));
		this.typesElement.put("uri", new TypeElement("uri", 5));

		this.typeElementRepository.save((this.typesElement.values()));

	}

}
