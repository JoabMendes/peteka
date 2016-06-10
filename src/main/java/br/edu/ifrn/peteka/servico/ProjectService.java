package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.User;
import br.edu.ifrn.peteka.persistencia.ProjectRepository;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;


@Named
public class ProjectService extends AbstractService<Project, Long> {
    private ProjectRepository projectRepository;

    @Inject
    public ProjectService(ProjectRepository projectRepository) {
        super();
        this.projectRepository = projectRepository;
    }
    
    public Set<Project> getAllProjectsOfUser(User u) {
        return this.projectRepository.getAllProjectsOfUser(u);
    } 
}
