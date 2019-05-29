package fr.gaelcarre.cinestor.rest.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gaelcarre.cinestor.model.Element;
import fr.gaelcarre.cinestor.model.Project;
import fr.gaelcarre.cinestor.repository.ElementRepository;
import fr.gaelcarre.cinestor.repository.ProjectRepository;

@RestController
@RequestMapping()
public class ProjectService {

	private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ElementRepository elementRepository;

	@GetMapping("user/project/{userid}")
	public ResponseEntity<Set<Project>> getProjectsByUser(@PathVariable Long userid) {
		Set<Project> projects = this.projectRepository.findByMembers_Id(userid);
		return ResponseEntity.ok(projects);
	}

	@GetMapping("/project/{id}")
	public ResponseEntity<Project> getProject(@PathVariable Long id) {
		Project project = this.projectRepository.findOne(id);
		return ResponseEntity.ok(project);
	}

	@GetMapping("/element/{id}")
	public ResponseEntity<Element> getElement(@PathVariable Long id) {
		return ResponseEntity.ok(this.elementRepository.findOne(id));
	}

	@PostMapping("project")
	public ResponseEntity<Project> createProject(@RequestBody Project project) {
		if (project != null) {
			project = this.projectRepository.save(project);
			return ResponseEntity.ok(project);
		} else
			return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/element/{id}")
	@Transactional
	public ResponseEntity<Boolean> deleteElement(@PathVariable Long id) {
		// Element elt = this.elementRepository.findOne(id);
		// if (elt != null) {
		// elt.setParent(null);
		// elt.setProject(null);
		// elt.setSubelements(null);
		// this.elementRepository.delete(elt);
		// }

		this.elementRepository.deleteById(id);

		return ResponseEntity.ok(true);
	}

	@PutMapping("/project/{id}")
	public ResponseEntity<Project> putProject(@PathVariable Long id, @RequestBody Project project) {
		this.projectRepository.save(project);
		return ResponseEntity.ok(project);
	}

	@PutMapping("/element/{id}")
	public ResponseEntity<Element> putElement(@PathVariable Long id, @RequestBody Element element) {
		this.elementRepository.save(element);
		return ResponseEntity.ok(element);
	}
}
